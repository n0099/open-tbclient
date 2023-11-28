package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dp2;
import com.baidu.tieba.fp2;
import com.baidu.tieba.gp2;
import com.baidu.tieba.nr2;
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
public class ep2 extends fp2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final ff4 d;
    public final zd4 e;
    public kg3 f;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ep2 a;

        public a(ep2 ep2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ep2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ep2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947741954, "Lcom/baidu/tieba/ep2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947741954, "Lcom/baidu/tieba/ep2;");
                return;
            }
        }
        g = sm1.a;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || jg3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        kg3 kg3Var = this.f;
        if (kg3Var == null) {
            return;
        }
        kg3Var.stopWatching();
        this.f = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ep2(ff4 ff4Var, zd4 zd4Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ff4Var, zd4Var};
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
        this.d = ff4Var;
        this.e = zd4Var;
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
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || jg3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            kg3 kg3Var = new kg3(str);
            this.f = kg3Var;
            kg3Var.startWatching();
        }
    }

    @Override // com.baidu.tieba.fp2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                h32.k("SwanExtractor", "#onInstallFaild del: " + string);
                km4.M(string);
            }
        }
    }

    public final void k() {
        ff4 ff4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (ff4Var = this.d) != null && ff4Var.h == 0 && !dp2.w()) {
            dp2.e(this.d.g + File.separator + this.d.i);
        }
    }

    @Override // com.baidu.tieba.fp2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        mr2 mr2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                mr2Var = mr2.d(string);
                nr2.b e = mr2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                mr2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (mr2Var != null && g) {
                mr2Var.g("SwanExtractor", "done: " + l);
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
            ai3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            h32.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                mr2 d = mr2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + r);
            }
            c().putLong("result_error_code", r.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(String str, String str2) {
        zd4 zd4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && (zd4Var = this.e) != null) {
            zd4Var.n(str, str2);
        }
    }

    public final ai3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        int i2;
        boolean z;
        gp2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            mr2 d = mr2.d(str);
            ff4 ff4Var = this.d;
            if (ff4Var == null) {
                ai3 ai3Var = new ai3();
                ai3Var.k(11L);
                ai3Var.i(2320L);
                ai3Var.f("pkg info is empty");
                ei3.a().f(ai3Var);
                return ai3Var;
            }
            int i3 = ff4Var.h;
            boolean z2 = true;
            if (i3 == 1) {
                qn1 g2 = pp2.g();
                ff4 ff4Var2 = this.d;
                i = g2.a(ff4Var2.g, String.valueOf(ff4Var2.i));
            } else if (i3 == 0) {
                i = dp2.e.i(ff4Var.g, String.valueOf(ff4Var.i));
            } else {
                ai3 ai3Var2 = new ai3();
                ai3Var2.k(11L);
                ai3Var2.i(2320L);
                ai3Var2.f("pkh category illegal");
                ei3.a().f(ai3Var2);
                return ai3Var2;
            }
            if (i == null) {
                ai3 ai3Var3 = new ai3();
                ai3Var3.k(11L);
                ai3Var3.i(2320L);
                ai3Var3.f("获取解压目录失败");
                ei3.a().f(ai3Var3);
                return ai3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                ai3 ai3Var4 = new ai3();
                ai3Var4.k(11L);
                ai3Var4.i(2320L);
                ai3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                ei3.a().f(ai3Var4);
                return ai3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        bj3.k(new a(this), "doFallbackIfNeeded");
                        ai3 ai3Var5 = new ai3();
                        ai3Var5.k(11L);
                        ai3Var5.i(2320L);
                        ai3Var5.f("解压失败：解压文件夹创建失败");
                        ei3.a().f(ai3Var5);
                        return ai3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    gp2.c i4 = gp2.i(bufferedInputStream);
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
                        bVar = gp2.d(bufferedInputStream, i, i2);
                        if (bVar == null || !bVar.a) {
                            z2 = false;
                        }
                    } else {
                        z2 = nm4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i2 = 0;
                    }
                    m(z);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        gp2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i2);
                        de4.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z2) {
                        return null;
                    }
                    ai3 ai3Var6 = new ai3();
                    ai3Var6.k(11L);
                    if (z) {
                        ai3Var6.i(2330L);
                        ai3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        ai3Var6.i(2320L);
                        ai3Var6.f("unzip failed");
                    }
                    ei3.a().f(ai3Var6);
                    return ai3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    ai3 ai3Var7 = new ai3();
                    ai3Var7.k(11L);
                    ai3Var7.i(2320L);
                    ai3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    ei3.a().f(ai3Var7);
                    return ai3Var7;
                }
            }
        }
        return (ai3) invokeLL.objValue;
    }
}
