package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gp2;
import com.baidu.tieba.ip2;
import com.baidu.tieba.jp2;
import com.baidu.tieba.qr2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
/* loaded from: classes6.dex */
public class hp2 extends ip2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final if4 d;
    public final ce4 e;
    public ng3 f;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hp2 a;

        public a(hp2 hp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hp2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.k();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947831327, "Lcom/baidu/tieba/hp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947831327, "Lcom/baidu/tieba/hp2;");
                return;
            }
        }
        g = vm1.a;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || mg3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        ng3 ng3Var = this.f;
        if (ng3Var == null) {
            return;
        }
        ng3Var.stopWatching();
        this.f = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hp2(if4 if4Var, ce4 ce4Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {if4Var, ce4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = if4Var;
        this.e = ce4Var;
    }

    public final void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                q("670", "package_end_decrypt");
                q("770", "na_package_end_decrypt");
                return;
            }
            q("670", "package_end_unzip");
            q("770", "na_package_end_unzip");
        }
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                q("670", "package_start_decrypt");
                q("770", "na_package_start_decrypt");
                return;
            }
            q("670", "package_start_unzip");
            q("770", "na_package_start_unzip");
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || mg3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            ng3 ng3Var = new ng3(str);
            this.f = ng3Var;
            ng3Var.startWatching();
        }
    }

    @Override // com.baidu.tieba.ip2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                k32.k("SwanExtractor", "#onInstallFaild del: " + string);
                nm4.M(string);
            }
        }
    }

    public final void k() {
        if4 if4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (if4Var = this.d) != null && if4Var.h == 0 && !gp2.w()) {
            gp2.e(this.d.g + File.separator + this.d.i);
        }
    }

    @Override // com.baidu.tieba.ip2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        pr2 pr2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                pr2Var = pr2.d(string);
                qr2.b e = pr2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                pr2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (pr2Var != null && g) {
                pr2Var.g("SwanExtractor", "done: " + l);
            }
            return l;
        }
        return invokeLL.booleanValue;
    }

    public final boolean l(InputStream inputStream, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, inputStream, str)) == null) {
            if (inputStream == null) {
                return false;
            }
            di3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            k32.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                pr2 d = pr2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + r);
            }
            c().putLong("result_error_code", r.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(String str, String str2) {
        ce4 ce4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && (ce4Var = this.e) != null) {
            ce4Var.n(str, str2);
        }
    }

    public final di3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        int i2;
        boolean z;
        jp2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            pr2 d = pr2.d(str);
            if4 if4Var = this.d;
            if (if4Var == null) {
                di3 di3Var = new di3();
                di3Var.k(11L);
                di3Var.i(2320L);
                di3Var.f("pkg info is empty");
                hi3.a().f(di3Var);
                return di3Var;
            }
            int i3 = if4Var.h;
            boolean z2 = true;
            if (i3 == 1) {
                tn1 g2 = sp2.g();
                if4 if4Var2 = this.d;
                i = g2.a(if4Var2.g, String.valueOf(if4Var2.i));
            } else if (i3 == 0) {
                i = gp2.e.i(if4Var.g, String.valueOf(if4Var.i));
            } else {
                di3 di3Var2 = new di3();
                di3Var2.k(11L);
                di3Var2.i(2320L);
                di3Var2.f("pkh category illegal");
                hi3.a().f(di3Var2);
                return di3Var2;
            }
            if (i == null) {
                di3 di3Var3 = new di3();
                di3Var3.k(11L);
                di3Var3.i(2320L);
                di3Var3.f("获取解压目录失败");
                hi3.a().f(di3Var3);
                return di3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                di3 di3Var4 = new di3();
                di3Var4.k(11L);
                di3Var4.i(2320L);
                di3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                hi3.a().f(di3Var4);
                return di3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        ej3.k(new a(this), "doFallbackIfNeeded");
                        di3 di3Var5 = new di3();
                        di3Var5.k(11L);
                        di3Var5.i(2320L);
                        di3Var5.f("解压失败：解压文件夹创建失败");
                        hi3.a().f(di3Var5);
                        return di3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    jp2.c i4 = jp2.i(bufferedInputStream);
                    if (i4 == null) {
                        i2 = -1;
                    } else {
                        i2 = i4.b;
                    }
                    if (i2 != -1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    n(z);
                    if (z) {
                        bVar = jp2.d(bufferedInputStream, i, i2);
                        if (bVar == null || !bVar.a) {
                            z2 = false;
                        }
                    } else {
                        z2 = qm4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i2 = 0;
                    }
                    m(z);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        jp2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i2);
                        ge4.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z2) {
                        return null;
                    }
                    di3 di3Var6 = new di3();
                    di3Var6.k(11L);
                    if (z) {
                        di3Var6.i(2330L);
                        di3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        di3Var6.i(2320L);
                        di3Var6.f("unzip failed");
                    }
                    hi3.a().f(di3Var6);
                    return di3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    di3 di3Var7 = new di3();
                    di3Var7.k(11L);
                    di3Var7.i(2320L);
                    di3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    hi3.a().f(di3Var7);
                    return di3Var7;
                }
            }
        }
        return (di3) invokeLL.objValue;
    }
}
