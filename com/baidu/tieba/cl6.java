package com.baidu.tieba;

import androidx.core.util.Pair;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.download.util.DownloadErrorLogger;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.browser.exception.UnzipErrorException;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
/* loaded from: classes5.dex */
public class cl6 extends BdAsyncTask<Void, Void, al6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public cl6(String str, t0a t0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, t0aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.c = t0aVar.c();
        this.b = t0aVar.a();
        this.d = t0aVar.b();
    }

    public static void c(String str, t0a t0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, t0aVar) == null) {
            cl6 cl6Var = new cl6(str, t0aVar);
            cl6Var.setPriority(4);
            cl6Var.execute(new Void[0]);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public al6 doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        boolean z;
        al6 al6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
            File file = new File(uk6.n().o(), this.a);
            HybridLog.getInstance().e("Offline", "离线包开始下载：" + this.a + " 目录：" + file + " 地址：" + this.b);
            if (!mm6.a(file)) {
                HybridLog.getInstance().e("newHybrid", "离线包下载失败：" + this.a + "->目录创建失败");
            }
            File file2 = new File(file, this.c + ".zip");
            if (!file2.exists()) {
                if (this.b.startsWith("http")) {
                    z = new NetWork(this.b).downloadFile(file2.getAbsolutePath(), null, 0, 3, 0, true);
                } else {
                    z = e(this.b, file2);
                }
            } else {
                z = true;
            }
            if (!z) {
                mm6.c(file2);
                HybridLog.getInstance().e("newHybrid", "离线包下载失败:网络下载异常：" + this.a);
                uk6.x("download bundle", DownloadErrorLogger.LOGGER_SPACE, this.a, this.c, nm6.a(Pair.create("error_code", "-1"), Pair.create(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "网络下载错误")));
                return null;
            } else if (!lm6.d(file2, this.d)) {
                mm6.c(file2);
                HybridLog.getInstance().e("newHybrid", "离线包目md5验证失败：" + this.a);
                uk6.x("download bundle", "md5_error", this.a, this.c, nm6.a(Pair.create("detail", this.d + "_" + lm6.b(file2))));
                return null;
            } else {
                File file3 = new File(uk6.n().m(), this.a);
                if (!f(file2, file3, this.c)) {
                    HybridLog.getInstance().e("Offline", "离线包zip解压失败：" + this.a);
                    uk6.x("download bundle", "unzip_error", this.a, this.c, "");
                    return null;
                }
                File file4 = new File(file3, this.c);
                Map<String, fl6> b = dl6.b(file4);
                if (dl6.f(file4, b)) {
                    al6Var = new al6(file4, this.c, b);
                } else {
                    al6Var = null;
                }
                if (al6Var != null && al6Var.c()) {
                    uk6.j(uk6.n().m(), this.c, this.a);
                    uk6.j(uk6.n().o(), this.c + ".zip", this.a);
                    return al6Var;
                }
                mm6.b(file4);
                HybridLog.getInstance().e("Offline", "离线包应用失败：" + this.a + "，path：" + file4.getAbsolutePath());
                return null;
            }
        }
        return (al6) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onPostExecute(al6 al6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, al6Var) == null) {
            super.onPostExecute(al6Var);
            if (al6Var != null) {
                uk6.n().z(this.a, al6Var.b());
                uk6.n().w();
                vk6.e().k(this.a, al6Var.a());
                vk6.e().c(this.a);
                uk6.x("download bundle", "success", this.a, al6Var.b(), "");
            } else {
                uk6.n().i(this.a);
                uk6.n().w();
                vk6.e().i(this.a);
            }
            tk6.b(al6Var, this.a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(String str, File file) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        InputStream open;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, file)) == null) {
            InputStream inputStream = null;
            try {
                open = TbadkCoreApplication.getInst().getResources().getAssets().open(str);
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (-1 == read) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                Closeables.closeSafely(open);
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
                return true;
            } catch (Exception e3) {
                e = e3;
                inputStream = open;
                try {
                    BdLog.e(e.getMessage());
                    Closeables.closeSafely(inputStream);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    Closeables.closeSafely(inputStream);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = open;
                Closeables.closeSafely(inputStream);
                if (fileOutputStream != null) {
                }
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean f(File file, File file2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, file, file2, str)) == null) {
            File file3 = new File(file2, str);
            if (!file3.exists()) {
                try {
                    qm6.c(file, file3);
                    return true;
                } catch (UnzipErrorException e) {
                    mm6.b(file2);
                    TbLog hybridLog = HybridLog.getInstance();
                    hybridLog.e("Offline", "离线包资源解压缩失败：" + e);
                    return false;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
