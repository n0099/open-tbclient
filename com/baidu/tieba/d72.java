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
import com.baidu.tieba.hm2;
import com.baidu.tieba.km2;
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
/* loaded from: classes3.dex */
public final class d72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
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
                pj4.j(new File(filesDir, "aiapps_zip"));
                pj4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                for (File file2 : listFiles) {
                    long lastModified = file2.lastModified();
                    if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                        pj4.L(file2);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947657386, "Lcom/baidu/tieba/d72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947657386, "Lcom/baidu/tieba/d72;");
                return;
            }
        }
        a = vj1.a;
        b = false;
    }

    public d72() {
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

    public static ef3 a(ReadableByteChannel readableByteChannel, String str, db4 db4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, db4Var)) == null) {
            if (readableByteChannel == null) {
                ef3 ef3Var = new ef3();
                ef3Var.k(11L);
                ef3Var.i(2300L);
                ef3Var.f("empty source");
                if3.a().f(ef3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + ef3Var);
                }
                return ef3Var;
            }
            db4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            db4Var.n("770", "na_pms_start_check_sign");
            if (yg3.d(readableByteChannel, str, new sh3())) {
                db4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                db4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            ef3 ef3Var2 = new ef3();
            ef3Var2.k(11L);
            ef3Var2.i(2300L);
            ef3Var2.f("check zip file sign fail.");
            if3.a().f(ef3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + ef3Var2);
            }
            return ef3Var2;
        }
        return (ef3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable jc4 jc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jc4Var)) == null) {
            if (jc4Var == null || TextUtils.isEmpty(jc4Var.a)) {
                return false;
            }
            File file = new File(jc4Var.a);
            return file.exists() && file.isFile() && file.delete();
        }
        return invokeL.booleanValue;
    }

    @AnyThread
    public static void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || b) {
            return;
        }
        synchronized (d72.class) {
            if (b) {
                return;
            }
            b = true;
            fg3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? hm2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? tm2.g().c() : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? tm2.g().c() : (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? hm2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? hm2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? tm2.g().c() : (String) invokeV.objValue;
    }

    public static boolean j(fc4 fc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, fc4Var)) == null) {
            if (fc4Var == null) {
                return false;
            }
            int i = fc4Var.a;
            return i == 1013 || i == 1015;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, kc4 kc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, kc4Var) == null) || pMSAppInfo == null || kc4Var == null) {
            return;
        }
        pMSAppInfo.copyMainPkgInfo(kc4Var);
        if (kc4Var.h == 1) {
            pMSAppInfo.setOrientation(tm2.i().u(kc4Var.g, kc4Var.i));
        } else {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, lc4 lc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, lc4Var) == null) || pMSAppInfo == null || lc4Var == null) {
            return;
        }
        pMSAppInfo.copySubPkgInfo(lc4Var);
        if (lc4Var.h == 0) {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static ef3 m(jc4 jc4Var, db4 db4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, jc4Var, db4Var)) == null) {
            if (jc4Var == null) {
                ef3 ef3Var = new ef3();
                ef3Var.k(11L);
                ef3Var.i(2320L);
                ef3Var.f("pkg info is empty");
                if3.a().f(ef3Var);
                return ef3Var;
            }
            File file = new File(jc4Var.a);
            int i2 = jc4Var.h;
            if (i2 == 1) {
                i = tm2.g().a(jc4Var.g, String.valueOf(jc4Var.i));
                if (i == null) {
                    ef3 ef3Var2 = new ef3();
                    ef3Var2.k(11L);
                    ef3Var2.i(2320L);
                    ef3Var2.f("获取解压目录失败");
                    if3.a().f(ef3Var2);
                    return ef3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = hm2.e.i(jc4Var.g, String.valueOf(jc4Var.i));
            } else {
                ef3 ef3Var3 = new ef3();
                ef3Var3.k(11L);
                ef3Var3.i(2320L);
                ef3Var3.f("pkh category illegal");
                if3.a().f(ef3Var3);
                return ef3Var3;
            }
            if (!file.exists()) {
                ef3 ef3Var4 = new ef3();
                ef3Var4.k(11L);
                ef3Var4.i(2320L);
                ef3Var4.f("解压失败：包不存在");
                if3.a().f(ef3Var4);
                return ef3Var4;
            } else if (i.isFile() && !i.delete()) {
                l02.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                ef3 ef3Var5 = new ef3();
                ef3Var5.k(11L);
                ef3Var5.i(2320L);
                ef3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                if3.a().f(ef3Var5);
                return ef3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                ef3 ef3Var6 = new ef3();
                ef3Var6.k(11L);
                ef3Var6.i(2320L);
                ef3Var6.f("解压失败：解压文件夹创建失败");
                if3.a().f(ef3Var6);
                return ef3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, db4Var).b) {
                    return null;
                }
                b n = n(file, i, db4Var);
                if (n.b) {
                    aa3.a(db4Var, jc4Var.h, true);
                    return null;
                }
                aa3.a(db4Var, jc4Var.h, false);
                l02.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                pj4.L(i);
                ef3 ef3Var7 = new ef3();
                int i3 = n.a;
                if (i3 == 0) {
                    ef3Var7.k(11L);
                    ef3Var7.i(2320L);
                    ef3Var7.f("unzip failed");
                } else if (i3 != 1 && i3 != 2) {
                    ef3Var7.k(4L);
                    ef3Var7.i(7L);
                    ef3Var7.f("Unkown bundle type");
                } else {
                    ef3Var7.k(11L);
                    ef3Var7.i(2330L);
                    ef3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                }
                if3.a().f(ef3Var7);
                return ef3Var7;
            }
        }
        return (ef3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull db4 db4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, db4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            km2.c j = km2.j(file);
            int i = 0;
            if (j.b != -1) {
                db4Var.n("670", "package_start_decrypt");
                db4Var.n("770", "na_package_start_decrypt");
                km2.b d = km2.d(j.a, file2, j.b);
                db4Var.n("670", "package_end_decrypt");
                db4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                db4Var.n("670", "package_start_unzip");
                db4Var.n("770", "na_package_start_unzip");
                boolean U = pj4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = pj4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        ma3 ma3Var = new ma3();
                        ef3 ef3Var = new ef3();
                        ef3Var.k(4L);
                        ef3Var.i(52L);
                        ma3Var.p(ef3Var);
                        ma3Var.l("path", file2.getAbsolutePath());
                        ma3Var.l("eMsg", "unzip files not match zip content");
                        ma3Var.l("decryptType", String.valueOf(j.b));
                        ma3Var.l("stack", fh3.z(30));
                        ea3.R(ma3Var);
                    }
                }
                db4Var.n("670", "package_end_unzip");
                db4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                km2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            hb4.a(db4Var, bundle, "event_download_package_type");
            return bVar;
        }
        return (b) invokeLLL.objValue;
    }

    public static void o(@Nullable PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, null, pMSAppInfo) == null) || pMSAppInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
            d43.u(pMSAppInfo.appId, "", lg3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            d43.t("", lg3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            d43.s(pMSAppInfo.appId, lg3.d(pMSAppInfo.domains));
        }
        if (TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            return;
        }
        d43.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
    }
}
