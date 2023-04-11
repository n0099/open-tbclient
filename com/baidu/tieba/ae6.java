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
/* loaded from: classes3.dex */
public class ae6 extends BdAsyncTask<Void, Void, yd6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public ae6(String str, x99 x99Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, x99Var};
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
        this.c = x99Var.c();
        this.b = x99Var.a();
        this.d = x99Var.b();
    }

    public static void c(String str, x99 x99Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, x99Var) == null) {
            ae6 ae6Var = new ae6(str, x99Var);
            ae6Var.setPriority(4);
            ae6Var.execute(new Void[0]);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public yd6 doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        boolean z;
        yd6 yd6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
            File file = new File(td6.l().m(), this.a);
            if (!ff6.a(file)) {
                xe6.b("lt-log", "离线包下载失败：" + this.a + "->目录创建失败");
            }
            File file2 = new File(file, this.c + ".zip");
            if (!file2.exists()) {
                z = new NetWork(this.b).downloadFile(file2.getAbsolutePath(), null, 0, 3, 0, true);
            } else {
                z = true;
            }
            if (!z) {
                ff6.c(file2);
                xe6.b("lt-log", "离线包下载失败:网络下载异常：" + this.a);
                td6.t("download bundle", "download_error", this.a, this.c, gf6.a(Pair.create("error_code", "-1"), Pair.create(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "网络下载错误")));
                return null;
            } else if (!ef6.d(file2, this.d)) {
                ff6.c(file2);
                xe6.b("lt-log", "离线包目md5验证失败：" + this.a);
                td6.t("download bundle", "md5_error", this.a, this.c, gf6.a(Pair.create("detail", this.d + "_" + ef6.b(file2))));
                return null;
            } else {
                File file3 = new File(td6.l().k(), this.a);
                if (!e(file2, file3, this.c)) {
                    td6.t("download bundle", "unzip_error", this.a, this.c, "");
                    return null;
                }
                File file4 = new File(file3, this.c);
                Map<String, de6> b = be6.b(file4);
                if (be6.f(file4, b)) {
                    yd6Var = new yd6(file4, this.c, b);
                } else {
                    yd6Var = null;
                }
                if (yd6Var != null && yd6Var.c()) {
                    td6.i(td6.l().k(), this.c, this.a);
                    td6.i(td6.l().m(), this.c + ".zip", this.a);
                    return yd6Var;
                }
                ff6.b(file4);
                xe6.b("lt-log", "离线包应用失败：" + this.a + "，path：" + file4.getAbsolutePath());
                return null;
            }
        }
        return (yd6) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onPostExecute(yd6 yd6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yd6Var) == null) {
            super.onPostExecute(yd6Var);
            if (yd6Var != null) {
                td6.l().v(this.a, yd6Var.b());
                td6.l().s();
                wd6.d().j(this.a, yd6Var.a());
                wd6.d().c(this.a);
                td6.t("download bundle", "success", "", this.a, yd6Var.b());
            } else {
                wd6.d().c(this.a);
            }
            sd6.b(yd6Var, this.a);
        }
    }

    public final boolean e(File file, File file2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, file, file2, str)) == null) {
            File file3 = new File(file2, str);
            if (!file3.exists()) {
                try {
                    kf6.c(file, file3);
                    return true;
                } catch (UnzipErrorException e) {
                    ff6.b(file2);
                    xe6.b("lt-log", "离线包资源解压缩失败：" + e);
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
