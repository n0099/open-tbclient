package com.baidu.tieba;

import androidx.core.util.Pair;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.util.DownloadErrorLogger;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.browser.exception.UnzipErrorException;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Map;
/* loaded from: classes5.dex */
public class gl6 extends BdAsyncTask<Void, Void, el6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public gl6(String str, cn9 cn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, cn9Var};
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
        this.c = cn9Var.c();
        this.b = cn9Var.a();
        this.d = cn9Var.b();
    }

    public static void c(String str, cn9 cn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, cn9Var) == null) {
            gl6 gl6Var = new gl6(str, cn9Var);
            gl6Var.setPriority(4);
            gl6Var.execute(new Void[0]);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public el6 doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        boolean z;
        el6 el6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
            File file = new File(al6.n().o(), this.a);
            HybridLog.getInstance().b("Offline", "离线包开始下载：" + this.a + " 目录：" + file);
            if (!qm6.a(file)) {
                mm6.b("newHybrid", "离线包下载失败：" + this.a + "->目录创建失败");
            }
            File file2 = new File(file, this.c + ".zip");
            if (!file2.exists()) {
                z = new NetWork(this.b).downloadFile(file2.getAbsolutePath(), null, 0, 3, 0, true);
            } else {
                z = true;
            }
            if (!z) {
                qm6.c(file2);
                mm6.b("newHybrid", "离线包下载失败:网络下载异常：" + this.a);
                al6.w("download bundle", DownloadErrorLogger.LOGGER_SPACE, this.a, this.c, rm6.a(Pair.create("error_code", "-1"), Pair.create(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "网络下载错误")));
                return null;
            } else if (!pm6.d(file2, this.d)) {
                qm6.c(file2);
                mm6.b("newHybrid", "离线包目md5验证失败：" + this.a);
                al6.w("download bundle", "md5_error", this.a, this.c, rm6.a(Pair.create("detail", this.d + "_" + pm6.b(file2))));
                return null;
            } else {
                File file3 = new File(al6.n().m(), this.a);
                if (!e(file2, file3, this.c)) {
                    al6.w("download bundle", "unzip_error", this.a, this.c, "");
                    return null;
                }
                File file4 = new File(file3, this.c);
                Map<String, jl6> b = hl6.b(file4);
                if (hl6.f(file4, b)) {
                    el6Var = new el6(file4, this.c, b);
                } else {
                    el6Var = null;
                }
                if (el6Var != null && el6Var.c()) {
                    al6.j(al6.n().m(), this.c, this.a);
                    al6.j(al6.n().o(), this.c + ".zip", this.a);
                    return el6Var;
                }
                qm6.b(file4);
                mm6.b("newHybrid", "离线包应用失败：" + this.a + "，path：" + file4.getAbsolutePath());
                return null;
            }
        }
        return (el6) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onPostExecute(el6 el6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, el6Var) == null) {
            super.onPostExecute(el6Var);
            if (el6Var != null) {
                al6.n().y(this.a, el6Var.b());
                al6.n().v();
                bl6.e().k(this.a, el6Var.a());
                bl6.e().c(this.a);
                al6.w("download bundle", "success", this.a, el6Var.b(), "");
            } else {
                al6.n().i(this.a);
                al6.n().v();
                bl6.e().i(this.a);
            }
            zk6.b(el6Var, this.a);
        }
    }

    public final boolean e(File file, File file2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, file, file2, str)) == null) {
            File file3 = new File(file2, str);
            if (!file3.exists()) {
                try {
                    um6.c(file, file3);
                    return true;
                } catch (UnzipErrorException e) {
                    qm6.b(file2);
                    mm6.b("newHybrid", "离线包资源解压缩失败：" + e);
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
