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
import com.baidu.tieba.fn2;
import com.baidu.tieba.in2;
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
public final class b82 {
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
                nk4.j(new File(filesDir, "aiapps_zip"));
                nk4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                            nk4.L(file2);
                        }
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947598765, "Lcom/baidu/tieba/b82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947598765, "Lcom/baidu/tieba/b82;");
                return;
            }
        }
        a = tk1.a;
        b = false;
    }

    public b82() {
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
        synchronized (b82.class) {
            if (b) {
                return;
            }
            b = true;
            dh3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return fn2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return rn2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return rn2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return fn2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return fn2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return rn2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static cg3 a(ReadableByteChannel readableByteChannel, String str, bc4 bc4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, bc4Var)) == null) {
            if (readableByteChannel == null) {
                cg3 cg3Var = new cg3();
                cg3Var.k(11L);
                cg3Var.i(2300L);
                cg3Var.f("empty source");
                gg3.a().f(cg3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + cg3Var);
                }
                return cg3Var;
            }
            bc4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            bc4Var.n("770", "na_pms_start_check_sign");
            if (wh3.d(readableByteChannel, str, new qi3())) {
                bc4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                bc4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            cg3 cg3Var2 = new cg3();
            cg3Var2.k(11L);
            cg3Var2.i(2300L);
            cg3Var2.f("check zip file sign fail.");
            gg3.a().f(cg3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + cg3Var2);
            }
            return cg3Var2;
        }
        return (cg3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable hd4 hd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, hd4Var)) == null) {
            if (hd4Var == null || TextUtils.isEmpty(hd4Var.a)) {
                return false;
            }
            File file = new File(hd4Var.a);
            if (!file.exists() || !file.isFile() || !file.delete()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(dd4 dd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, dd4Var)) == null) {
            if (dd4Var == null) {
                return false;
            }
            int i = dd4Var.a;
            if (i != 1013 && i != 1015) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, id4 id4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, id4Var) == null) && pMSAppInfo != null && id4Var != null) {
            pMSAppInfo.copyMainPkgInfo(id4Var);
            if (id4Var.h == 1) {
                pMSAppInfo.setOrientation(rn2.i().u(id4Var.g, id4Var.i));
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, jd4 jd4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, jd4Var) == null) && pMSAppInfo != null && jd4Var != null) {
            pMSAppInfo.copySubPkgInfo(jd4Var);
            if (jd4Var.h == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static cg3 m(hd4 hd4Var, bc4 bc4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, hd4Var, bc4Var)) == null) {
            if (hd4Var == null) {
                cg3 cg3Var = new cg3();
                cg3Var.k(11L);
                cg3Var.i(2320L);
                cg3Var.f("pkg info is empty");
                gg3.a().f(cg3Var);
                return cg3Var;
            }
            File file = new File(hd4Var.a);
            int i2 = hd4Var.h;
            if (i2 == 1) {
                i = rn2.g().a(hd4Var.g, String.valueOf(hd4Var.i));
                if (i == null) {
                    cg3 cg3Var2 = new cg3();
                    cg3Var2.k(11L);
                    cg3Var2.i(2320L);
                    cg3Var2.f("获取解压目录失败");
                    gg3.a().f(cg3Var2);
                    return cg3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = fn2.e.i(hd4Var.g, String.valueOf(hd4Var.i));
            } else {
                cg3 cg3Var3 = new cg3();
                cg3Var3.k(11L);
                cg3Var3.i(2320L);
                cg3Var3.f("pkh category illegal");
                gg3.a().f(cg3Var3);
                return cg3Var3;
            }
            if (!file.exists()) {
                cg3 cg3Var4 = new cg3();
                cg3Var4.k(11L);
                cg3Var4.i(2320L);
                cg3Var4.f("解压失败：包不存在");
                gg3.a().f(cg3Var4);
                return cg3Var4;
            } else if (i.isFile() && !i.delete()) {
                j12.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                cg3 cg3Var5 = new cg3();
                cg3Var5.k(11L);
                cg3Var5.i(2320L);
                cg3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                gg3.a().f(cg3Var5);
                return cg3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                cg3 cg3Var6 = new cg3();
                cg3Var6.k(11L);
                cg3Var6.i(2320L);
                cg3Var6.f("解压失败：解压文件夹创建失败");
                gg3.a().f(cg3Var6);
                return cg3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, bc4Var).b) {
                    return null;
                }
                b n = n(file, i, bc4Var);
                if (n.b) {
                    ya3.a(bc4Var, hd4Var.h, true);
                    return null;
                }
                ya3.a(bc4Var, hd4Var.h, false);
                j12.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                nk4.L(i);
                cg3 cg3Var7 = new cg3();
                int i3 = n.a;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        cg3Var7.k(4L);
                        cg3Var7.i(7L);
                        cg3Var7.f("Unkown bundle type");
                    } else {
                        cg3Var7.k(11L);
                        cg3Var7.i(2330L);
                        cg3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                    }
                } else {
                    cg3Var7.k(11L);
                    cg3Var7.i(2320L);
                    cg3Var7.f("unzip failed");
                }
                gg3.a().f(cg3Var7);
                return cg3Var7;
            }
        }
        return (cg3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull bc4 bc4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, bc4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            in2.c j = in2.j(file);
            int i = 0;
            if (j.b != -1) {
                bc4Var.n("670", "package_start_decrypt");
                bc4Var.n("770", "na_package_start_decrypt");
                in2.b d = in2.d(j.a, file2, j.b);
                bc4Var.n("670", "package_end_decrypt");
                bc4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                bc4Var.n("670", "package_start_unzip");
                bc4Var.n("770", "na_package_start_unzip");
                boolean U = nk4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = nk4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        kb3 kb3Var = new kb3();
                        cg3 cg3Var = new cg3();
                        cg3Var.k(4L);
                        cg3Var.i(52L);
                        kb3Var.p(cg3Var);
                        kb3Var.l("path", file2.getAbsolutePath());
                        kb3Var.l("eMsg", "unzip files not match zip content");
                        kb3Var.l("decryptType", String.valueOf(j.b));
                        kb3Var.l("stack", di3.z(30));
                        cb3.R(kb3Var);
                    }
                }
                bc4Var.n("670", "package_end_unzip");
                bc4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                in2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            fc4.a(bc4Var, bundle, "event_download_package_type");
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
            b53.u(pMSAppInfo.appId, "", jh3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            b53.t("", jh3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            b53.s(pMSAppInfo.appId, jh3.d(pMSAppInfo.domains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            b53.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
        }
    }
}
