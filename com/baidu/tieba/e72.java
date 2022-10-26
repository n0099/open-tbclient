package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.im2;
import com.baidu.tieba.lm2;
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
public final class e72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public final class a implements Runnable {
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
                qj4.j(new File(filesDir, "aiapps_zip"));
                qj4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                            qj4.L(file2);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947687177, "Lcom/baidu/tieba/e72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947687177, "Lcom/baidu/tieba/e72;");
                return;
            }
        }
        a = wj1.a;
        b = false;
    }

    public e72() {
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

    public static void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) != null) || b) {
            return;
        }
        synchronized (e72.class) {
            if (b) {
                return;
            }
            b = true;
            gg3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return im2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return um2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return um2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return im2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return im2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return um2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static ff3 a(ReadableByteChannel readableByteChannel, String str, eb4 eb4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, eb4Var)) == null) {
            if (readableByteChannel == null) {
                ff3 ff3Var = new ff3();
                ff3Var.k(11L);
                ff3Var.i(2300L);
                ff3Var.f("empty source");
                jf3.a().f(ff3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + ff3Var);
                }
                return ff3Var;
            }
            eb4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            eb4Var.n("770", "na_pms_start_check_sign");
            if (zg3.d(readableByteChannel, str, new th3())) {
                eb4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                eb4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            ff3 ff3Var2 = new ff3();
            ff3Var2.k(11L);
            ff3Var2.i(2300L);
            ff3Var2.f("check zip file sign fail.");
            jf3.a().f(ff3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + ff3Var2);
            }
            return ff3Var2;
        }
        return (ff3) invokeLLL.objValue;
    }

    public static boolean b(kc4 kc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, kc4Var)) == null) {
            if (kc4Var == null || TextUtils.isEmpty(kc4Var.a)) {
                return false;
            }
            File file = new File(kc4Var.a);
            if (!file.exists() || !file.isFile() || !file.delete()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(gc4 gc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, gc4Var)) == null) {
            if (gc4Var == null) {
                return false;
            }
            int i = gc4Var.a;
            if (i != 1013 && i != 1015) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, lc4 lc4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, lc4Var) == null) && pMSAppInfo != null && lc4Var != null) {
            pMSAppInfo.copyMainPkgInfo(lc4Var);
            if (lc4Var.h == 1) {
                pMSAppInfo.setOrientation(um2.i().u(lc4Var.g, lc4Var.i));
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, mc4 mc4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, mc4Var) == null) && pMSAppInfo != null && mc4Var != null) {
            pMSAppInfo.copySubPkgInfo(mc4Var);
            if (mc4Var.h == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static ff3 m(kc4 kc4Var, eb4 eb4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, kc4Var, eb4Var)) == null) {
            if (kc4Var == null) {
                ff3 ff3Var = new ff3();
                ff3Var.k(11L);
                ff3Var.i(2320L);
                ff3Var.f("pkg info is empty");
                jf3.a().f(ff3Var);
                return ff3Var;
            }
            File file = new File(kc4Var.a);
            int i2 = kc4Var.h;
            if (i2 == 1) {
                i = um2.g().a(kc4Var.g, String.valueOf(kc4Var.i));
                if (i == null) {
                    ff3 ff3Var2 = new ff3();
                    ff3Var2.k(11L);
                    ff3Var2.i(2320L);
                    ff3Var2.f("获取解压目录失败");
                    jf3.a().f(ff3Var2);
                    return ff3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = im2.e.i(kc4Var.g, String.valueOf(kc4Var.i));
            } else {
                ff3 ff3Var3 = new ff3();
                ff3Var3.k(11L);
                ff3Var3.i(2320L);
                ff3Var3.f("pkh category illegal");
                jf3.a().f(ff3Var3);
                return ff3Var3;
            }
            if (!file.exists()) {
                ff3 ff3Var4 = new ff3();
                ff3Var4.k(11L);
                ff3Var4.i(2320L);
                ff3Var4.f("解压失败：包不存在");
                jf3.a().f(ff3Var4);
                return ff3Var4;
            } else if (i.isFile() && !i.delete()) {
                m02.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                ff3 ff3Var5 = new ff3();
                ff3Var5.k(11L);
                ff3Var5.i(2320L);
                ff3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                jf3.a().f(ff3Var5);
                return ff3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                ff3 ff3Var6 = new ff3();
                ff3Var6.k(11L);
                ff3Var6.i(2320L);
                ff3Var6.f("解压失败：解压文件夹创建失败");
                jf3.a().f(ff3Var6);
                return ff3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, eb4Var).b) {
                    return null;
                }
                b n = n(file, i, eb4Var);
                if (n.b) {
                    ba3.a(eb4Var, kc4Var.h, true);
                    return null;
                }
                ba3.a(eb4Var, kc4Var.h, false);
                m02.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                qj4.L(i);
                ff3 ff3Var7 = new ff3();
                int i3 = n.a;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        ff3Var7.k(4L);
                        ff3Var7.i(7L);
                        ff3Var7.f("Unkown bundle type");
                    } else {
                        ff3Var7.k(11L);
                        ff3Var7.i(2330L);
                        ff3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                    }
                } else {
                    ff3Var7.k(11L);
                    ff3Var7.i(2320L);
                    ff3Var7.f("unzip failed");
                }
                jf3.a().f(ff3Var7);
                return ff3Var7;
            }
        }
        return (ff3) invokeLL.objValue;
    }

    public static b n(File file, File file2, eb4 eb4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, eb4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            lm2.c j = lm2.j(file);
            int i = 0;
            if (j.b != -1) {
                eb4Var.n("670", "package_start_decrypt");
                eb4Var.n("770", "na_package_start_decrypt");
                lm2.b d = lm2.d(j.a, file2, j.b);
                eb4Var.n("670", "package_end_decrypt");
                eb4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                eb4Var.n("670", "package_start_unzip");
                eb4Var.n("770", "na_package_start_unzip");
                boolean U = qj4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = qj4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        na3 na3Var = new na3();
                        ff3 ff3Var = new ff3();
                        ff3Var.k(4L);
                        ff3Var.i(52L);
                        na3Var.p(ff3Var);
                        na3Var.l("path", file2.getAbsolutePath());
                        na3Var.l("eMsg", "unzip files not match zip content");
                        na3Var.l("decryptType", String.valueOf(j.b));
                        na3Var.l("stack", gh3.z(30));
                        fa3.R(na3Var);
                    }
                }
                eb4Var.n("670", "package_end_unzip");
                eb4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                lm2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            ib4.a(eb4Var, bundle, "event_download_package_type");
            return bVar;
        }
        return (b) invokeLLL.objValue;
    }

    public static void o(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65552, null, pMSAppInfo) != null) || pMSAppInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
            e43.u(pMSAppInfo.appId, "", mg3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            e43.t("", mg3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            e43.s(pMSAppInfo.appId, mg3.d(pMSAppInfo.domains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            e43.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
        }
    }
}
