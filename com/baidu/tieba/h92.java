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
import com.baidu.tieba.lo2;
import com.baidu.tieba.oo2;
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
/* loaded from: classes6.dex */
public final class h92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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
                sl4.j(new File(filesDir, "aiapps_zip"));
                sl4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                            sl4.L(file2);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947778472, "Lcom/baidu/tieba/h92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947778472, "Lcom/baidu/tieba/h92;");
                return;
            }
        }
        a = am1.a;
        b = false;
    }

    public h92() {
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
        synchronized (h92.class) {
            if (b) {
                return;
            }
            b = true;
            ji3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return lo2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return xo2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return xo2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return lo2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return lo2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return xo2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static ih3 a(ReadableByteChannel readableByteChannel, String str, hd4 hd4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, hd4Var)) == null) {
            if (readableByteChannel == null) {
                ih3 ih3Var = new ih3();
                ih3Var.k(11L);
                ih3Var.i(2300L);
                ih3Var.f("empty source");
                mh3.a().f(ih3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + ih3Var);
                }
                return ih3Var;
            }
            hd4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            hd4Var.n("770", "na_pms_start_check_sign");
            if (cj3.d(readableByteChannel, str, new wj3())) {
                hd4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                hd4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            ih3 ih3Var2 = new ih3();
            ih3Var2.k(11L);
            ih3Var2.i(2300L);
            ih3Var2.f("check zip file sign fail.");
            mh3.a().f(ih3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + ih3Var2);
            }
            return ih3Var2;
        }
        return (ih3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable ne4 ne4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ne4Var)) == null) {
            if (ne4Var == null || TextUtils.isEmpty(ne4Var.a)) {
                return false;
            }
            File file = new File(ne4Var.a);
            if (!file.exists() || !file.isFile() || !file.delete()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(je4 je4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, je4Var)) == null) {
            if (je4Var == null) {
                return false;
            }
            int i = je4Var.a;
            if (i != 1013 && i != 1015) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, oe4 oe4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, oe4Var) == null) && pMSAppInfo != null && oe4Var != null) {
            pMSAppInfo.copyMainPkgInfo(oe4Var);
            if (oe4Var.h == 1) {
                pMSAppInfo.setOrientation(xo2.i().u(oe4Var.g, oe4Var.i));
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, pe4 pe4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, pe4Var) == null) && pMSAppInfo != null && pe4Var != null) {
            pMSAppInfo.copySubPkgInfo(pe4Var);
            if (pe4Var.h == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static ih3 m(ne4 ne4Var, hd4 hd4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, ne4Var, hd4Var)) == null) {
            if (ne4Var == null) {
                ih3 ih3Var = new ih3();
                ih3Var.k(11L);
                ih3Var.i(2320L);
                ih3Var.f("pkg info is empty");
                mh3.a().f(ih3Var);
                return ih3Var;
            }
            File file = new File(ne4Var.a);
            int i2 = ne4Var.h;
            if (i2 == 1) {
                i = xo2.g().a(ne4Var.g, String.valueOf(ne4Var.i));
                if (i == null) {
                    ih3 ih3Var2 = new ih3();
                    ih3Var2.k(11L);
                    ih3Var2.i(2320L);
                    ih3Var2.f("获取解压目录失败");
                    mh3.a().f(ih3Var2);
                    return ih3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = lo2.e.i(ne4Var.g, String.valueOf(ne4Var.i));
            } else {
                ih3 ih3Var3 = new ih3();
                ih3Var3.k(11L);
                ih3Var3.i(2320L);
                ih3Var3.f("pkh category illegal");
                mh3.a().f(ih3Var3);
                return ih3Var3;
            }
            if (!file.exists()) {
                ih3 ih3Var4 = new ih3();
                ih3Var4.k(11L);
                ih3Var4.i(2320L);
                ih3Var4.f("解压失败：包不存在");
                mh3.a().f(ih3Var4);
                return ih3Var4;
            } else if (i.isFile() && !i.delete()) {
                p22.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                ih3 ih3Var5 = new ih3();
                ih3Var5.k(11L);
                ih3Var5.i(2320L);
                ih3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                mh3.a().f(ih3Var5);
                return ih3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                ih3 ih3Var6 = new ih3();
                ih3Var6.k(11L);
                ih3Var6.i(2320L);
                ih3Var6.f("解压失败：解压文件夹创建失败");
                mh3.a().f(ih3Var6);
                return ih3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, hd4Var).b) {
                    return null;
                }
                b n = n(file, i, hd4Var);
                if (n.b) {
                    ec3.a(hd4Var, ne4Var.h, true);
                    return null;
                }
                ec3.a(hd4Var, ne4Var.h, false);
                p22.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                sl4.L(i);
                ih3 ih3Var7 = new ih3();
                int i3 = n.a;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        ih3Var7.k(4L);
                        ih3Var7.i(7L);
                        ih3Var7.f("Unkown bundle type");
                    } else {
                        ih3Var7.k(11L);
                        ih3Var7.i(2330L);
                        ih3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                    }
                } else {
                    ih3Var7.k(11L);
                    ih3Var7.i(2320L);
                    ih3Var7.f("unzip failed");
                }
                mh3.a().f(ih3Var7);
                return ih3Var7;
            }
        }
        return (ih3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull hd4 hd4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, hd4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            oo2.c j = oo2.j(file);
            int i = 0;
            if (j.b != -1) {
                hd4Var.n("670", "package_start_decrypt");
                hd4Var.n("770", "na_package_start_decrypt");
                oo2.b d = oo2.d(j.a, file2, j.b);
                hd4Var.n("670", "package_end_decrypt");
                hd4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                hd4Var.n("670", "package_start_unzip");
                hd4Var.n("770", "na_package_start_unzip");
                boolean U = sl4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = sl4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        qc3 qc3Var = new qc3();
                        ih3 ih3Var = new ih3();
                        ih3Var.k(4L);
                        ih3Var.i(52L);
                        qc3Var.p(ih3Var);
                        qc3Var.l("path", file2.getAbsolutePath());
                        qc3Var.l("eMsg", "unzip files not match zip content");
                        qc3Var.l("decryptType", String.valueOf(j.b));
                        qc3Var.l("stack", jj3.z(30));
                        ic3.R(qc3Var);
                    }
                }
                hd4Var.n("670", "package_end_unzip");
                hd4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                oo2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            ld4.a(hd4Var, bundle, "event_download_package_type");
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
            h63.u(pMSAppInfo.appId, "", pi3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            h63.t("", pi3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            h63.s(pMSAppInfo.appId, pi3.d(pMSAppInfo.domains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            h63.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
        }
    }
}
