package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.an2;
import com.baidu.tieba.cn2;
import com.baidu.tieba.dn2;
import com.baidu.tieba.kp2;
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
/* loaded from: classes3.dex */
public class bn2 extends cn2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final cd4 d;
    public final wb4 e;
    public he3 f;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bn2 a;

        public a(bn2 bn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bn2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947650659, "Lcom/baidu/tieba/bn2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947650659, "Lcom/baidu/tieba/bn2;");
                return;
            }
        }
        g = ok1.a;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || ge3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        he3 he3Var = this.f;
        if (he3Var == null) {
            return;
        }
        he3Var.stopWatching();
        this.f = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bn2(cd4 cd4Var, wb4 wb4Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cd4Var, wb4Var};
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
        this.d = cd4Var;
        this.e = wb4Var;
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
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || ge3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            he3 he3Var = new he3(str);
            this.f = he3Var;
            he3Var.startWatching();
        }
    }

    @Override // com.baidu.tieba.cn2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                e12.k("SwanExtractor", "#onInstallFaild del: " + string);
                ik4.M(string);
            }
        }
    }

    public final void k() {
        cd4 cd4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (cd4Var = this.d) != null && cd4Var.h == 0 && !an2.w()) {
            an2.e(this.d.g + File.separator + this.d.i);
        }
    }

    @Override // com.baidu.tieba.cn2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        jp2 jp2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                jp2Var = jp2.d(string);
                kp2.b e = jp2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                jp2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (jp2Var != null && g) {
                jp2Var.g("SwanExtractor", "done: " + l);
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
            xf3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            e12.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                jp2 d = jp2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + r);
            }
            c().putLong("result_error_code", r.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(String str, String str2) {
        wb4 wb4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && (wb4Var = this.e) != null) {
            wb4Var.n(str, str2);
        }
    }

    public final xf3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        int i2;
        boolean z;
        dn2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            jp2 d = jp2.d(str);
            cd4 cd4Var = this.d;
            if (cd4Var == null) {
                xf3 xf3Var = new xf3();
                xf3Var.k(11L);
                xf3Var.i(2320L);
                xf3Var.f("pkg info is empty");
                bg3.a().f(xf3Var);
                return xf3Var;
            }
            int i3 = cd4Var.h;
            boolean z2 = true;
            if (i3 == 1) {
                ml1 g2 = mn2.g();
                cd4 cd4Var2 = this.d;
                i = g2.a(cd4Var2.g, String.valueOf(cd4Var2.i));
            } else if (i3 == 0) {
                i = an2.e.i(cd4Var.g, String.valueOf(cd4Var.i));
            } else {
                xf3 xf3Var2 = new xf3();
                xf3Var2.k(11L);
                xf3Var2.i(2320L);
                xf3Var2.f("pkh category illegal");
                bg3.a().f(xf3Var2);
                return xf3Var2;
            }
            if (i == null) {
                xf3 xf3Var3 = new xf3();
                xf3Var3.k(11L);
                xf3Var3.i(2320L);
                xf3Var3.f("获取解压目录失败");
                bg3.a().f(xf3Var3);
                return xf3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                xf3 xf3Var4 = new xf3();
                xf3Var4.k(11L);
                xf3Var4.i(2320L);
                xf3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                bg3.a().f(xf3Var4);
                return xf3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        yg3.k(new a(this), "doFallbackIfNeeded");
                        xf3 xf3Var5 = new xf3();
                        xf3Var5.k(11L);
                        xf3Var5.i(2320L);
                        xf3Var5.f("解压失败：解压文件夹创建失败");
                        bg3.a().f(xf3Var5);
                        return xf3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    dn2.c i4 = dn2.i(bufferedInputStream);
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
                        bVar = dn2.d(bufferedInputStream, i, i2);
                        if (bVar == null || !bVar.a) {
                            z2 = false;
                        }
                    } else {
                        z2 = lk4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i2 = 0;
                    }
                    m(z);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        dn2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i2);
                        ac4.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z2) {
                        return null;
                    }
                    xf3 xf3Var6 = new xf3();
                    xf3Var6.k(11L);
                    if (z) {
                        xf3Var6.i(2330L);
                        xf3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        xf3Var6.i(2320L);
                        xf3Var6.f("unzip failed");
                    }
                    bg3.a().f(xf3Var6);
                    return xf3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    xf3 xf3Var7 = new xf3();
                    xf3Var7.k(11L);
                    xf3Var7.i(2320L);
                    xf3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    bg3.a().f(xf3Var7);
                    return xf3Var7;
                }
            }
        }
        return (xf3) invokeLL.objValue;
    }
}
