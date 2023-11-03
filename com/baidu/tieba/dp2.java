package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cp2;
import com.baidu.tieba.ep2;
import com.baidu.tieba.fp2;
import com.baidu.tieba.mr2;
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
public class dp2 extends ep2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final ef4 d;
    public final yd4 e;
    public jg3 f;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dp2 a;

        public a(dp2 dp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dp2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947712163, "Lcom/baidu/tieba/dp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947712163, "Lcom/baidu/tieba/dp2;");
                return;
            }
        }
        g = rm1.a;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || ig3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        jg3 jg3Var = this.f;
        if (jg3Var == null) {
            return;
        }
        jg3Var.stopWatching();
        this.f = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dp2(ef4 ef4Var, yd4 yd4Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ef4Var, yd4Var};
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
        this.d = ef4Var;
        this.e = yd4Var;
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
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || ig3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            jg3 jg3Var = new jg3(str);
            this.f = jg3Var;
            jg3Var.startWatching();
        }
    }

    @Override // com.baidu.tieba.ep2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                g32.k("SwanExtractor", "#onInstallFaild del: " + string);
                jm4.M(string);
            }
        }
    }

    public final void k() {
        ef4 ef4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (ef4Var = this.d) != null && ef4Var.h == 0 && !cp2.w()) {
            cp2.e(this.d.g + File.separator + this.d.i);
        }
    }

    @Override // com.baidu.tieba.ep2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        lr2 lr2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                lr2Var = lr2.d(string);
                mr2.b e = lr2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                lr2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (lr2Var != null && g) {
                lr2Var.g("SwanExtractor", "done: " + l);
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
            zh3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            g32.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                lr2 d = lr2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + r);
            }
            c().putLong("result_error_code", r.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(String str, String str2) {
        yd4 yd4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && (yd4Var = this.e) != null) {
            yd4Var.n(str, str2);
        }
    }

    public final zh3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        int i2;
        boolean z;
        fp2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            lr2 d = lr2.d(str);
            ef4 ef4Var = this.d;
            if (ef4Var == null) {
                zh3 zh3Var = new zh3();
                zh3Var.k(11L);
                zh3Var.i(2320L);
                zh3Var.f("pkg info is empty");
                di3.a().f(zh3Var);
                return zh3Var;
            }
            int i3 = ef4Var.h;
            boolean z2 = true;
            if (i3 == 1) {
                pn1 g2 = op2.g();
                ef4 ef4Var2 = this.d;
                i = g2.a(ef4Var2.g, String.valueOf(ef4Var2.i));
            } else if (i3 == 0) {
                i = cp2.e.i(ef4Var.g, String.valueOf(ef4Var.i));
            } else {
                zh3 zh3Var2 = new zh3();
                zh3Var2.k(11L);
                zh3Var2.i(2320L);
                zh3Var2.f("pkh category illegal");
                di3.a().f(zh3Var2);
                return zh3Var2;
            }
            if (i == null) {
                zh3 zh3Var3 = new zh3();
                zh3Var3.k(11L);
                zh3Var3.i(2320L);
                zh3Var3.f("获取解压目录失败");
                di3.a().f(zh3Var3);
                return zh3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                zh3 zh3Var4 = new zh3();
                zh3Var4.k(11L);
                zh3Var4.i(2320L);
                zh3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                di3.a().f(zh3Var4);
                return zh3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        aj3.k(new a(this), "doFallbackIfNeeded");
                        zh3 zh3Var5 = new zh3();
                        zh3Var5.k(11L);
                        zh3Var5.i(2320L);
                        zh3Var5.f("解压失败：解压文件夹创建失败");
                        di3.a().f(zh3Var5);
                        return zh3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    fp2.c i4 = fp2.i(bufferedInputStream);
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
                        bVar = fp2.d(bufferedInputStream, i, i2);
                        if (bVar == null || !bVar.a) {
                            z2 = false;
                        }
                    } else {
                        z2 = mm4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i2 = 0;
                    }
                    m(z);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        fp2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i2);
                        ce4.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z2) {
                        return null;
                    }
                    zh3 zh3Var6 = new zh3();
                    zh3Var6.k(11L);
                    if (z) {
                        zh3Var6.i(2330L);
                        zh3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        zh3Var6.i(2320L);
                        zh3Var6.f("unzip failed");
                    }
                    di3.a().f(zh3Var6);
                    return zh3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    zh3 zh3Var7 = new zh3();
                    zh3Var7.k(11L);
                    zh3Var7.i(2320L);
                    zh3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    di3.a().f(zh3Var7);
                    return zh3Var7;
                }
            }
        }
        return (zh3) invokeLL.objValue;
    }
}
