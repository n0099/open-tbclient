package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.gp2;
import com.baidu.tieba.jp2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes5.dex */
public final class ca2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] listFiles;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File filesDir = AppRuntime.getAppContext().getFilesDir();
                nm4.j(new File(filesDir, "aiapps_zip"));
                nm4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                            nm4.L(file2);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public boolean b;
        public String c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0;
            this.b = false;
            this.c = "";
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947667957, "Lcom/baidu/tieba/ca2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947667957, "Lcom/baidu/tieba/ca2;");
                return;
            }
        }
        a = vm1.a;
        b = false;
    }

    public ca2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @AnyThread
    public static void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) != null) || b) {
            return;
        }
        synchronized (ca2.class) {
            if (b) {
                return;
            }
            b = true;
            ej3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return gp2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return sp2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return sp2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return gp2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return gp2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return sp2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static di3 a(ReadableByteChannel readableByteChannel, String str, ce4 ce4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, ce4Var)) == null) {
            if (readableByteChannel == null) {
                di3 di3Var = new di3();
                di3Var.k(11L);
                di3Var.i(2300L);
                di3Var.f("empty source");
                hi3.a().f(di3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + di3Var);
                }
                return di3Var;
            }
            ce4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            ce4Var.n("770", "na_pms_start_check_sign");
            if (xj3.d(readableByteChannel, str, new rk3())) {
                ce4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                ce4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            di3 di3Var2 = new di3();
            di3Var2.k(11L);
            di3Var2.i(2300L);
            di3Var2.f("check zip file sign fail.");
            hi3.a().f(di3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + di3Var2);
            }
            return di3Var2;
        }
        return (di3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable if4 if4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, if4Var)) == null) {
            if (if4Var == null || TextUtils.isEmpty(if4Var.a)) {
                return false;
            }
            File file = new File(if4Var.a);
            if (!file.exists() || !file.isFile() || !file.delete()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(ef4 ef4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, ef4Var)) == null) {
            if (ef4Var == null) {
                return false;
            }
            int i = ef4Var.a;
            if (i != 1013 && i != 1015) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, jf4 jf4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, jf4Var) == null) && pMSAppInfo != null && jf4Var != null) {
            pMSAppInfo.copyMainPkgInfo(jf4Var);
            if (jf4Var.h == 1) {
                pMSAppInfo.setOrientation(sp2.i().u(jf4Var.g, jf4Var.i));
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, kf4 kf4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, kf4Var) == null) && pMSAppInfo != null && kf4Var != null) {
            pMSAppInfo.copySubPkgInfo(kf4Var);
            if (kf4Var.h == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static di3 m(if4 if4Var, ce4 ce4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, if4Var, ce4Var)) == null) {
            if (if4Var == null) {
                di3 di3Var = new di3();
                di3Var.k(11L);
                di3Var.i(2320L);
                di3Var.f("pkg info is empty");
                hi3.a().f(di3Var);
                return di3Var;
            }
            File file = new File(if4Var.a);
            int i2 = if4Var.h;
            if (i2 == 1) {
                i = sp2.g().a(if4Var.g, String.valueOf(if4Var.i));
                if (i == null) {
                    di3 di3Var2 = new di3();
                    di3Var2.k(11L);
                    di3Var2.i(2320L);
                    di3Var2.f("获取解压目录失败");
                    hi3.a().f(di3Var2);
                    return di3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = gp2.e.i(if4Var.g, String.valueOf(if4Var.i));
            } else {
                di3 di3Var3 = new di3();
                di3Var3.k(11L);
                di3Var3.i(2320L);
                di3Var3.f("pkh category illegal");
                hi3.a().f(di3Var3);
                return di3Var3;
            }
            if (!file.exists()) {
                di3 di3Var4 = new di3();
                di3Var4.k(11L);
                di3Var4.i(2320L);
                di3Var4.f("解压失败：包不存在");
                hi3.a().f(di3Var4);
                return di3Var4;
            } else if (i.isFile() && !i.delete()) {
                k32.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                di3 di3Var5 = new di3();
                di3Var5.k(11L);
                di3Var5.i(2320L);
                di3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                hi3.a().f(di3Var5);
                return di3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                di3 di3Var6 = new di3();
                di3Var6.k(11L);
                di3Var6.i(2320L);
                di3Var6.f("解压失败：解压文件夹创建失败");
                hi3.a().f(di3Var6);
                return di3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, ce4Var).b) {
                    return null;
                }
                b n = n(file, i, ce4Var);
                if (n.b) {
                    zc3.a(ce4Var, if4Var.h, true);
                    return null;
                }
                zc3.a(ce4Var, if4Var.h, false);
                k32.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                nm4.L(i);
                di3 di3Var7 = new di3();
                int i3 = n.a;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        di3Var7.k(4L);
                        di3Var7.i(7L);
                        di3Var7.f("Unkown bundle type");
                    } else {
                        di3Var7.k(11L);
                        di3Var7.i(2330L);
                        di3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                    }
                } else {
                    di3Var7.k(11L);
                    di3Var7.i(2320L);
                    di3Var7.f("unzip failed");
                }
                hi3.a().f(di3Var7);
                return di3Var7;
            }
        }
        return (di3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull ce4 ce4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, ce4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            jp2.c j = jp2.j(file);
            int i = 0;
            if (j.b != -1) {
                ce4Var.n("670", "package_start_decrypt");
                ce4Var.n("770", "na_package_start_decrypt");
                jp2.b d = jp2.d(j.a, file2, j.b);
                ce4Var.n("670", "package_end_decrypt");
                ce4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                ce4Var.n("670", "package_start_unzip");
                ce4Var.n("770", "na_package_start_unzip");
                boolean U = nm4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = nm4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        ld3 ld3Var = new ld3();
                        di3 di3Var = new di3();
                        di3Var.k(4L);
                        di3Var.i(52L);
                        ld3Var.p(di3Var);
                        ld3Var.l("path", file2.getAbsolutePath());
                        ld3Var.l("eMsg", "unzip files not match zip content");
                        ld3Var.l("decryptType", String.valueOf(j.b));
                        ld3Var.l("stack", ek3.z(30));
                        dd3.R(ld3Var);
                    }
                }
                ce4Var.n("670", "package_end_unzip");
                ce4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                jp2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            ge4.a(ce4Var, bundle, "event_download_package_type");
            return bVar;
        }
        return (b) invokeLLL.objValue;
    }

    public static void o(@Nullable PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65552, null, pMSAppInfo) != null) || pMSAppInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
            c73.u(pMSAppInfo.appId, "", kj3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            c73.t("", kj3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            c73.s(pMSAppInfo.appId, kj3.d(pMSAppInfo.domains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            c73.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
        }
    }
}
