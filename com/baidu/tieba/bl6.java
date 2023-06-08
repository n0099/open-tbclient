package com.baidu.tieba;

import androidx.core.util.Pair;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.util.DownloadErrorLogger;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.browser.exception.UnzipErrorException;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Map;
/* loaded from: classes5.dex */
public class bl6 extends BdAsyncTask<Void, Void, zk6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public bl6(String str, kl9 kl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, kl9Var};
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
        this.c = kl9Var.c();
        this.b = kl9Var.a();
        this.d = kl9Var.b();
    }

    public static void c(String str, kl9 kl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, kl9Var) == null) {
            bl6 bl6Var = new bl6(str, kl9Var);
            bl6Var.setPriority(4);
            bl6Var.execute(new Void[0]);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public zk6 doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        boolean z;
        zk6 zk6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
            File file = new File(vk6.m().n(), this.a);
            if (!lm6.a(file)) {
                hm6.b("newHybrid", "离线包下载失败：" + this.a + "->目录创建失败");
            }
            File file2 = new File(file, this.c + ".zip");
            if (!file2.exists()) {
                z = new NetWork(this.b).downloadFile(file2.getAbsolutePath(), null, 0, 3, 0, true);
            } else {
                z = true;
            }
            if (!z) {
                lm6.c(file2);
                hm6.b("newHybrid", "离线包下载失败:网络下载异常：" + this.a);
                vk6.u("download bundle", DownloadErrorLogger.LOGGER_SPACE, this.a, this.c, mm6.a(Pair.create("error_code", "-1"), Pair.create(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "网络下载错误")));
                return null;
            } else if (!km6.d(file2, this.d)) {
                lm6.c(file2);
                hm6.b("newHybrid", "离线包目md5验证失败：" + this.a);
                vk6.u("download bundle", "md5_error", this.a, this.c, mm6.a(Pair.create("detail", this.d + "_" + km6.b(file2))));
                return null;
            } else {
                File file3 = new File(vk6.m().l(), this.a);
                if (!e(file2, file3, this.c)) {
                    vk6.u("download bundle", "unzip_error", this.a, this.c, "");
                    return null;
                }
                File file4 = new File(file3, this.c);
                Map<String, el6> b = cl6.b(file4);
                if (cl6.f(file4, b)) {
                    zk6Var = new zk6(file4, this.c, b);
                } else {
                    zk6Var = null;
                }
                if (zk6Var != null && zk6Var.c()) {
                    vk6.i(vk6.m().l(), this.c, this.a);
                    vk6.i(vk6.m().n(), this.c + ".zip", this.a);
                    return zk6Var;
                }
                lm6.b(file4);
                hm6.b("newHybrid", "离线包应用失败：" + this.a + "，path：" + file4.getAbsolutePath());
                return null;
            }
        }
        return (zk6) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onPostExecute(zk6 zk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zk6Var) == null) {
            super.onPostExecute(zk6Var);
            if (zk6Var != null) {
                vk6.m().w(this.a, zk6Var.b());
                vk6.m().t();
                wk6.d().j(this.a, zk6Var.a());
                wk6.d().c(this.a);
                vk6.u("download bundle", "success", this.a, zk6Var.b(), "");
            } else {
                vk6.m().h(this.a);
                vk6.m().t();
                wk6.d().h(this.a);
            }
            uk6.b(zk6Var, this.a);
        }
    }

    public final boolean e(File file, File file2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, file, file2, str)) == null) {
            File file3 = new File(file2, str);
            if (!file3.exists()) {
                try {
                    pm6.c(file, file3);
                    return true;
                } catch (UnzipErrorException e) {
                    lm6.b(file2);
                    hm6.b("newHybrid", "离线包资源解压缩失败：" + e);
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
