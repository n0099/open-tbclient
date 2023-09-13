package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.du2;
import com.baidu.tieba.fu2;
import com.baidu.tieba.gu2;
import com.baidu.tieba.nw2;
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
public class eu2 extends fu2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final fk4 d;
    public final zi4 e;
    public kl3 f;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eu2 a;

        public a(eu2 eu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eu2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eu2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947746759, "Lcom/baidu/tieba/eu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947746759, "Lcom/baidu/tieba/eu2;");
                return;
            }
        }
        g = rr1.a;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || jl3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        kl3 kl3Var = this.f;
        if (kl3Var == null) {
            return;
        }
        kl3Var.stopWatching();
        this.f = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eu2(fk4 fk4Var, zi4 zi4Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fk4Var, zi4Var};
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
        this.d = fk4Var;
        this.e = zi4Var;
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
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || jl3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            kl3 kl3Var = new kl3(str);
            this.f = kl3Var;
            kl3Var.startWatching();
        }
    }

    @Override // com.baidu.tieba.fu2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                h82.k("SwanExtractor", "#onInstallFaild del: " + string);
                lr4.M(string);
            }
        }
    }

    public final void k() {
        fk4 fk4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (fk4Var = this.d) != null && fk4Var.h == 0 && !du2.w()) {
            du2.e(this.d.g + File.separator + this.d.i);
        }
    }

    @Override // com.baidu.tieba.fu2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        mw2 mw2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                mw2Var = mw2.d(string);
                nw2.b e = mw2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                mw2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (mw2Var != null && g) {
                mw2Var.g("SwanExtractor", "done: " + l);
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
            an3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            h82.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                mw2 d = mw2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + r);
            }
            c().putLong("result_error_code", r.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(String str, String str2) {
        zi4 zi4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && (zi4Var = this.e) != null) {
            zi4Var.n(str, str2);
        }
    }

    public final an3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        int i2;
        boolean z;
        gu2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            mw2 d = mw2.d(str);
            fk4 fk4Var = this.d;
            if (fk4Var == null) {
                an3 an3Var = new an3();
                an3Var.k(11L);
                an3Var.i(2320L);
                an3Var.f("pkg info is empty");
                en3.a().f(an3Var);
                return an3Var;
            }
            int i3 = fk4Var.h;
            boolean z2 = true;
            if (i3 == 1) {
                ps1 g2 = pu2.g();
                fk4 fk4Var2 = this.d;
                i = g2.a(fk4Var2.g, String.valueOf(fk4Var2.i));
            } else if (i3 == 0) {
                i = du2.e.i(fk4Var.g, String.valueOf(fk4Var.i));
            } else {
                an3 an3Var2 = new an3();
                an3Var2.k(11L);
                an3Var2.i(2320L);
                an3Var2.f("pkh category illegal");
                en3.a().f(an3Var2);
                return an3Var2;
            }
            if (i == null) {
                an3 an3Var3 = new an3();
                an3Var3.k(11L);
                an3Var3.i(2320L);
                an3Var3.f("获取解压目录失败");
                en3.a().f(an3Var3);
                return an3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                an3 an3Var4 = new an3();
                an3Var4.k(11L);
                an3Var4.i(2320L);
                an3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                en3.a().f(an3Var4);
                return an3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        bo3.k(new a(this), "doFallbackIfNeeded");
                        an3 an3Var5 = new an3();
                        an3Var5.k(11L);
                        an3Var5.i(2320L);
                        an3Var5.f("解压失败：解压文件夹创建失败");
                        en3.a().f(an3Var5);
                        return an3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    gu2.c i4 = gu2.i(bufferedInputStream);
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
                        bVar = gu2.d(bufferedInputStream, i, i2);
                        if (bVar == null || !bVar.a) {
                            z2 = false;
                        }
                    } else {
                        z2 = or4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i2 = 0;
                    }
                    m(z);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        gu2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i2);
                        dj4.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z2) {
                        return null;
                    }
                    an3 an3Var6 = new an3();
                    an3Var6.k(11L);
                    if (z) {
                        an3Var6.i(2330L);
                        an3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        an3Var6.i(2320L);
                        an3Var6.f("unzip failed");
                    }
                    en3.a().f(an3Var6);
                    return an3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    an3 an3Var7 = new an3();
                    an3Var7.k(11L);
                    an3Var7.i(2320L);
                    an3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    en3.a().f(an3Var7);
                    return an3Var7;
                }
            }
        }
        return (an3) invokeLL.objValue;
    }
}
