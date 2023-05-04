package com.baidu.tieba;

import androidx.core.util.Pair;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes4.dex */
public class ff6 extends BdAsyncTask<Void, Void, df6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public ff6(String str, bd9 bd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bd9Var};
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
        this.c = bd9Var.c();
        this.b = bd9Var.a();
        this.d = bd9Var.b();
    }

    public static void c(String str, bd9 bd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, bd9Var) == null) {
            ff6 ff6Var = new ff6(str, bd9Var);
            ff6Var.setPriority(4);
            ff6Var.execute(new Void[0]);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public df6 doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        boolean z;
        df6 df6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
            File file = new File(ze6.l().m(), this.a);
            if (!og6.a(file)) {
                kg6.b("lt-log", "离线包下载失败：" + this.a + "->目录创建失败");
            }
            File file2 = new File(file, this.c + ".zip");
            if (!file2.exists()) {
                z = new NetWork(this.b).downloadFile(file2.getAbsolutePath(), null, 0, 3, 0, true);
            } else {
                z = true;
            }
            if (!z) {
                og6.c(file2);
                kg6.b("lt-log", "离线包下载失败:网络下载异常：" + this.a);
                ze6.t("download bundle", "download_error", this.a, this.c, pg6.a(Pair.create("error_code", "-1"), Pair.create(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "网络下载错误")));
                return null;
            } else if (!ng6.d(file2, this.d)) {
                og6.c(file2);
                kg6.b("lt-log", "离线包目md5验证失败：" + this.a);
                ze6.t("download bundle", "md5_error", this.a, this.c, pg6.a(Pair.create("detail", this.d + "_" + ng6.b(file2))));
                return null;
            } else {
                File file3 = new File(ze6.l().k(), this.a);
                if (!e(file2, file3, this.c)) {
                    ze6.t("download bundle", "unzip_error", this.a, this.c, "");
                    return null;
                }
                File file4 = new File(file3, this.c);
                Map<String, if6> b = gf6.b(file4);
                if (gf6.f(file4, b)) {
                    df6Var = new df6(file4, this.c, b);
                } else {
                    df6Var = null;
                }
                if (df6Var != null && df6Var.c()) {
                    ze6.i(ze6.l().k(), this.c, this.a);
                    ze6.i(ze6.l().m(), this.c + ".zip", this.a);
                    return df6Var;
                }
                og6.b(file4);
                kg6.b("lt-log", "离线包应用失败：" + this.a + "，path：" + file4.getAbsolutePath());
                return null;
            }
        }
        return (df6) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onPostExecute(df6 df6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, df6Var) == null) {
            super.onPostExecute(df6Var);
            if (df6Var != null) {
                ze6.l().v(this.a, df6Var.b());
                ze6.l().s();
                af6.d().j(this.a, df6Var.a());
                af6.d().c(this.a);
                ze6.t("download bundle", "success", this.a, df6Var.b(), "");
            } else {
                ze6.l().h(this.a);
                ze6.l().s();
                af6.d().h(this.a);
            }
            ye6.b(df6Var, this.a);
        }
    }

    public final boolean e(File file, File file2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, file, file2, str)) == null) {
            File file3 = new File(file2, str);
            if (!file3.exists()) {
                try {
                    sg6.c(file, file3);
                    return true;
                } catch (UnzipErrorException e) {
                    og6.b(file2);
                    kg6.b("lt-log", "离线包资源解压缩失败：" + e);
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
