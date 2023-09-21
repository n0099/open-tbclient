package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cu2;
import com.baidu.tieba.eu2;
import com.baidu.tieba.fu2;
import com.baidu.tieba.mw2;
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
/* loaded from: classes5.dex */
public class du2 extends eu2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final ek4 d;
    public final yi4 e;
    public jl3 f;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ du2 a;

        public a(du2 du2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {du2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = du2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947716968, "Lcom/baidu/tieba/du2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947716968, "Lcom/baidu/tieba/du2;");
                return;
            }
        }
        g = qr1.a;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || il3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        jl3 jl3Var = this.f;
        if (jl3Var == null) {
            return;
        }
        jl3Var.stopWatching();
        this.f = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public du2(ek4 ek4Var, yi4 yi4Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ek4Var, yi4Var};
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
        this.d = ek4Var;
        this.e = yi4Var;
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
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || il3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            jl3 jl3Var = new jl3(str);
            this.f = jl3Var;
            jl3Var.startWatching();
        }
    }

    @Override // com.baidu.tieba.eu2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                g82.k("SwanExtractor", "#onInstallFaild del: " + string);
                kr4.M(string);
            }
        }
    }

    public final void k() {
        ek4 ek4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (ek4Var = this.d) != null && ek4Var.h == 0 && !cu2.w()) {
            cu2.e(this.d.g + File.separator + this.d.i);
        }
    }

    @Override // com.baidu.tieba.eu2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        lw2 lw2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                lw2Var = lw2.d(string);
                mw2.b e = lw2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                lw2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (lw2Var != null && g) {
                lw2Var.g("SwanExtractor", "done: " + l);
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
            zm3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            g82.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                lw2 d = lw2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + r);
            }
            c().putLong("result_error_code", r.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(String str, String str2) {
        yi4 yi4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && (yi4Var = this.e) != null) {
            yi4Var.n(str, str2);
        }
    }

    public final zm3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        int i2;
        boolean z;
        fu2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            lw2 d = lw2.d(str);
            ek4 ek4Var = this.d;
            if (ek4Var == null) {
                zm3 zm3Var = new zm3();
                zm3Var.k(11L);
                zm3Var.i(2320L);
                zm3Var.f("pkg info is empty");
                dn3.a().f(zm3Var);
                return zm3Var;
            }
            int i3 = ek4Var.h;
            boolean z2 = true;
            if (i3 == 1) {
                os1 g2 = ou2.g();
                ek4 ek4Var2 = this.d;
                i = g2.a(ek4Var2.g, String.valueOf(ek4Var2.i));
            } else if (i3 == 0) {
                i = cu2.e.i(ek4Var.g, String.valueOf(ek4Var.i));
            } else {
                zm3 zm3Var2 = new zm3();
                zm3Var2.k(11L);
                zm3Var2.i(2320L);
                zm3Var2.f("pkh category illegal");
                dn3.a().f(zm3Var2);
                return zm3Var2;
            }
            if (i == null) {
                zm3 zm3Var3 = new zm3();
                zm3Var3.k(11L);
                zm3Var3.i(2320L);
                zm3Var3.f("获取解压目录失败");
                dn3.a().f(zm3Var3);
                return zm3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                zm3 zm3Var4 = new zm3();
                zm3Var4.k(11L);
                zm3Var4.i(2320L);
                zm3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                dn3.a().f(zm3Var4);
                return zm3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        ao3.k(new a(this), "doFallbackIfNeeded");
                        zm3 zm3Var5 = new zm3();
                        zm3Var5.k(11L);
                        zm3Var5.i(2320L);
                        zm3Var5.f("解压失败：解压文件夹创建失败");
                        dn3.a().f(zm3Var5);
                        return zm3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    fu2.c i4 = fu2.i(bufferedInputStream);
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
                        bVar = fu2.d(bufferedInputStream, i, i2);
                        if (bVar == null || !bVar.a) {
                            z2 = false;
                        }
                    } else {
                        z2 = nr4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i2 = 0;
                    }
                    m(z);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        fu2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i2);
                        cj4.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z2) {
                        return null;
                    }
                    zm3 zm3Var6 = new zm3();
                    zm3Var6.k(11L);
                    if (z) {
                        zm3Var6.i(2330L);
                        zm3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        zm3Var6.i(2320L);
                        zm3Var6.f("unzip failed");
                    }
                    dn3.a().f(zm3Var6);
                    return zm3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    zm3 zm3Var7 = new zm3();
                    zm3Var7.k(11L);
                    zm3Var7.i(2320L);
                    zm3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    dn3.a().f(zm3Var7);
                    return zm3Var7;
                }
            }
        }
        return (zm3) invokeLL.objValue;
    }
}
