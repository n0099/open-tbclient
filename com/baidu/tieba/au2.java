package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bu2;
import com.baidu.tieba.cu2;
import com.baidu.tieba.jw2;
import com.baidu.tieba.zt2;
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
public class au2 extends bu2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final bk4 d;
    public final vi4 e;
    public gl3 f;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au2 a;

        public a(au2 au2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = au2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947627595, "Lcom/baidu/tieba/au2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947627595, "Lcom/baidu/tieba/au2;");
                return;
            }
        }
        g = nr1.a;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || fl3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        gl3 gl3Var = this.f;
        if (gl3Var == null) {
            return;
        }
        gl3Var.stopWatching();
        this.f = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public au2(bk4 bk4Var, vi4 vi4Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bk4Var, vi4Var};
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
        this.d = bk4Var;
        this.e = vi4Var;
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
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || fl3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            gl3 gl3Var = new gl3(str);
            this.f = gl3Var;
            gl3Var.startWatching();
        }
    }

    @Override // com.baidu.tieba.bu2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                d82.k("SwanExtractor", "#onInstallFaild del: " + string);
                hr4.M(string);
            }
        }
    }

    public final void k() {
        bk4 bk4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bk4Var = this.d) != null && bk4Var.h == 0 && !zt2.w()) {
            zt2.e(this.d.g + File.separator + this.d.i);
        }
    }

    @Override // com.baidu.tieba.bu2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        iw2 iw2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                iw2Var = iw2.d(string);
                jw2.b e = iw2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                iw2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (iw2Var != null && g) {
                iw2Var.g("SwanExtractor", "done: " + l);
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
            wm3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            d82.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                iw2 d = iw2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + r);
            }
            c().putLong("result_error_code", r.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(String str, String str2) {
        vi4 vi4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && (vi4Var = this.e) != null) {
            vi4Var.n(str, str2);
        }
    }

    public final wm3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        int i2;
        boolean z;
        cu2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            iw2 d = iw2.d(str);
            bk4 bk4Var = this.d;
            if (bk4Var == null) {
                wm3 wm3Var = new wm3();
                wm3Var.k(11L);
                wm3Var.i(2320L);
                wm3Var.f("pkg info is empty");
                an3.a().f(wm3Var);
                return wm3Var;
            }
            int i3 = bk4Var.h;
            boolean z2 = true;
            if (i3 == 1) {
                ls1 g2 = lu2.g();
                bk4 bk4Var2 = this.d;
                i = g2.a(bk4Var2.g, String.valueOf(bk4Var2.i));
            } else if (i3 == 0) {
                i = zt2.e.i(bk4Var.g, String.valueOf(bk4Var.i));
            } else {
                wm3 wm3Var2 = new wm3();
                wm3Var2.k(11L);
                wm3Var2.i(2320L);
                wm3Var2.f("pkh category illegal");
                an3.a().f(wm3Var2);
                return wm3Var2;
            }
            if (i == null) {
                wm3 wm3Var3 = new wm3();
                wm3Var3.k(11L);
                wm3Var3.i(2320L);
                wm3Var3.f("获取解压目录失败");
                an3.a().f(wm3Var3);
                return wm3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                wm3 wm3Var4 = new wm3();
                wm3Var4.k(11L);
                wm3Var4.i(2320L);
                wm3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                an3.a().f(wm3Var4);
                return wm3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        xn3.k(new a(this), "doFallbackIfNeeded");
                        wm3 wm3Var5 = new wm3();
                        wm3Var5.k(11L);
                        wm3Var5.i(2320L);
                        wm3Var5.f("解压失败：解压文件夹创建失败");
                        an3.a().f(wm3Var5);
                        return wm3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    cu2.c i4 = cu2.i(bufferedInputStream);
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
                        bVar = cu2.d(bufferedInputStream, i, i2);
                        if (bVar == null || !bVar.a) {
                            z2 = false;
                        }
                    } else {
                        z2 = kr4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i2 = 0;
                    }
                    m(z);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        cu2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i2);
                        zi4.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z2) {
                        return null;
                    }
                    wm3 wm3Var6 = new wm3();
                    wm3Var6.k(11L);
                    if (z) {
                        wm3Var6.i(2330L);
                        wm3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        wm3Var6.i(2320L);
                        wm3Var6.f("unzip failed");
                    }
                    an3.a().f(wm3Var6);
                    return wm3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    wm3 wm3Var7 = new wm3();
                    wm3Var7.k(11L);
                    wm3Var7.i(2320L);
                    wm3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    an3.a().f(wm3Var7);
                    return wm3Var7;
                }
            }
        }
        return (wm3) invokeLL.objValue;
    }
}
