package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fn2;
import com.baidu.tieba.hn2;
import com.baidu.tieba.in2;
import com.baidu.tieba.pp2;
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
/* loaded from: classes4.dex */
public class gn2 extends hn2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final hd4 d;
    public final bc4 e;
    public me3 f;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gn2 a;

        public a(gn2 gn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gn2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947799614, "Lcom/baidu/tieba/gn2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947799614, "Lcom/baidu/tieba/gn2;");
                return;
            }
        }
        g = tk1.a;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || le3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        me3 me3Var = this.f;
        if (me3Var == null) {
            return;
        }
        me3Var.stopWatching();
        this.f = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gn2(hd4 hd4Var, bc4 bc4Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hd4Var, bc4Var};
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
        this.d = hd4Var;
        this.e = bc4Var;
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
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || le3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            me3 me3Var = new me3(str);
            this.f = me3Var;
            me3Var.startWatching();
        }
    }

    @Override // com.baidu.tieba.hn2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                j12.k("SwanExtractor", "#onInstallFaild del: " + string);
                nk4.M(string);
            }
        }
    }

    public final void k() {
        hd4 hd4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (hd4Var = this.d) != null && hd4Var.h == 0 && !fn2.w()) {
            fn2.e(this.d.g + File.separator + this.d.i);
        }
    }

    @Override // com.baidu.tieba.hn2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        op2 op2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                op2Var = op2.d(string);
                pp2.b e = op2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                op2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (op2Var != null && g) {
                op2Var.g("SwanExtractor", "done: " + l);
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
            cg3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            j12.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                op2 d = op2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + r);
            }
            c().putLong("result_error_code", r.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(String str, String str2) {
        bc4 bc4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && (bc4Var = this.e) != null) {
            bc4Var.n(str, str2);
        }
    }

    public final cg3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        int i2;
        boolean z;
        in2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            op2 d = op2.d(str);
            hd4 hd4Var = this.d;
            if (hd4Var == null) {
                cg3 cg3Var = new cg3();
                cg3Var.k(11L);
                cg3Var.i(2320L);
                cg3Var.f("pkg info is empty");
                gg3.a().f(cg3Var);
                return cg3Var;
            }
            int i3 = hd4Var.h;
            boolean z2 = true;
            if (i3 == 1) {
                rl1 g2 = rn2.g();
                hd4 hd4Var2 = this.d;
                i = g2.a(hd4Var2.g, String.valueOf(hd4Var2.i));
            } else if (i3 == 0) {
                i = fn2.e.i(hd4Var.g, String.valueOf(hd4Var.i));
            } else {
                cg3 cg3Var2 = new cg3();
                cg3Var2.k(11L);
                cg3Var2.i(2320L);
                cg3Var2.f("pkh category illegal");
                gg3.a().f(cg3Var2);
                return cg3Var2;
            }
            if (i == null) {
                cg3 cg3Var3 = new cg3();
                cg3Var3.k(11L);
                cg3Var3.i(2320L);
                cg3Var3.f("获取解压目录失败");
                gg3.a().f(cg3Var3);
                return cg3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                cg3 cg3Var4 = new cg3();
                cg3Var4.k(11L);
                cg3Var4.i(2320L);
                cg3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                gg3.a().f(cg3Var4);
                return cg3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        dh3.k(new a(this), "doFallbackIfNeeded");
                        cg3 cg3Var5 = new cg3();
                        cg3Var5.k(11L);
                        cg3Var5.i(2320L);
                        cg3Var5.f("解压失败：解压文件夹创建失败");
                        gg3.a().f(cg3Var5);
                        return cg3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    in2.c i4 = in2.i(bufferedInputStream);
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
                        bVar = in2.d(bufferedInputStream, i, i2);
                        if (bVar == null || !bVar.a) {
                            z2 = false;
                        }
                    } else {
                        z2 = qk4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i2 = 0;
                    }
                    m(z);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        in2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i2);
                        fc4.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z2) {
                        return null;
                    }
                    cg3 cg3Var6 = new cg3();
                    cg3Var6.k(11L);
                    if (z) {
                        cg3Var6.i(2330L);
                        cg3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        cg3Var6.i(2320L);
                        cg3Var6.f("unzip failed");
                    }
                    gg3.a().f(cg3Var6);
                    return cg3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    cg3 cg3Var7 = new cg3();
                    cg3Var7.k(11L);
                    cg3Var7.i(2320L);
                    cg3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    gg3.a().f(cg3Var7);
                    return cg3Var7;
                }
            }
        }
        return (cg3) invokeLL.objValue;
    }
}
