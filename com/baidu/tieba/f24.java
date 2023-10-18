package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
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
import java.io.FileFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class f24 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static ExecutorService b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes5.dex */
        public static class a implements FileFilter {
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

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
                    if (file.isDirectory() && TextUtils.isDigitsOnly(file.getName())) {
                        return true;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }
        }

        @SuppressLint({"BDThrowableCheck"})
        public static long a(String str, String str2) throws IllegalArgumentException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    if (TextUtils.isDigitsOnly(str) && TextUtils.isDigitsOnly(str2)) {
                        return Long.parseLong(str) - Long.parseLong(str2);
                    }
                    throw new IllegalArgumentException("version is not digits only");
                }
                throw new IllegalArgumentException("version null");
            }
            return invokeLL.longValue;
        }

        public static File h(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
                return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str, str2);
            }
            return (File) invokeLL.objValue;
        }

        public static File b(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return (File) invokeL.objValue;
        }

        public static void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File[] listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder", str).listFiles(new a());
                if (listFiles != null && listFiles.length > 0) {
                    for (File file : listFiles) {
                        if (i(str2, file.getName())) {
                            if (f24.a) {
                                Log.i("SwanGameBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                            }
                            md4.i().d(str, file.getName());
                            sl4.j(file);
                        }
                    }
                }
            }
        }

        public static void d(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(65539, null, str) != null) || TextUtils.isEmpty(str)) {
                return;
            }
            File e = e(str, false);
            if (e != null) {
                sl4.L(e);
            }
            sl4.L(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str));
        }

        @Nullable
        public static File e(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, z)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return f(str, z, null);
            }
            return (File) invokeLZ.objValue;
        }

        public static File f(String str, boolean z, vj3 vj3Var) {
            InterceptResult invokeCommon;
            File g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{str, Boolean.valueOf(z), vj3Var})) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File[] listFiles = g().listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (File file : listFiles) {
                        if (TextUtils.equals(file.getName(), str + ".aigames")) {
                            return file;
                        }
                    }
                    if (f24.a && z) {
                        h53.g(AppRuntime.getAppContext(), g.getPath() + " 没有小游戏包!").G();
                    }
                    ih3 ih3Var = new ih3();
                    ih3Var.k(5L);
                    ih3Var.i(4L);
                    ih3Var.f("没有小游戏包! for release, no such bundle file");
                    mh3.a().f(ih3Var);
                    if (vj3Var != null) {
                        vj3Var.a = ih3Var;
                    }
                    return null;
                }
                if (f24.a && z) {
                    h53.g(AppRuntime.getAppContext(), g.getPath() + " 没有小游戏包!").G();
                }
                ih3 ih3Var2 = new ih3();
                ih3Var2.k(5L);
                ih3Var2.i(4L);
                ih3Var2.f("没有小游戏包! for release, bundle files are empty");
                mh3.a().f(ih3Var2);
                if (vj3Var != null) {
                    vj3Var.a = ih3Var2;
                }
                return null;
            }
            return (File) invokeCommon.objValue;
        }

        public static File g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "aigames_zip");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return (File) invokeV.objValue;
        }

        public static boolean i(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
                if (f24.a) {
                    Log.i("SwanGameBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
                }
                try {
                    if (a(str, str2) <= 0) {
                        return false;
                    }
                    return true;
                } catch (IllegalArgumentException e) {
                    if (f24.a) {
                        Log.e("SwanGameBundleHelper", "比较版本号Exception：" + e.getMessage());
                    }
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }

        public static c j(mq2 mq2Var, vj3 vj3Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, mq2Var, vj3Var)) == null) {
                if (mq2Var == null) {
                    return null;
                }
                File h = h(mq2Var.I(), mq2Var.x1());
                if (!h.exists()) {
                    File f = f(mq2Var.I(), true, vj3Var);
                    if (f == null) {
                        k23.Q().a0(8, new SwanAppDeleteInfo(mq2Var.I(), 1).setPurgerScenes(5));
                        return null;
                    }
                    b(h);
                    if (!f24.i(f, h, mq2Var, vj3Var)) {
                        h53.g(AppRuntime.getAppContext(), "小游戏bundle解压失败!").G();
                        ih3 ih3Var = new ih3();
                        ih3Var.k(5L);
                        ih3Var.i(7L);
                        ih3Var.f("小游戏bundle解压失败! for release");
                        mh3.a().f(ih3Var);
                        if (vj3Var != null && vj3Var.a == null) {
                            vj3Var.a = ih3Var;
                        }
                        return null;
                    }
                }
                c(mq2Var.I(), mq2Var.x1());
                c cVar = new c();
                File file = new File(h, "game.json");
                j54 a2 = j54.a(sl4.E(file));
                if (a2 == null) {
                    return null;
                }
                cVar.a = h.getPath() + File.separator;
                cVar.c = a2;
                if (!TextUtils.isEmpty(a2.e)) {
                    cVar.b = cVar.a + File.separator + a2.e + File.separator;
                    a54.a().d(true);
                    a54.a().e(cVar.b);
                    a54.a().f(a2.e);
                } else {
                    a54.a().d(false);
                }
                if (f24.a) {
                    Log.d("SwanGameBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanGameBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanGameBundleHelper", "info.appBundlePath path: " + cVar.a);
                    Log.d("SwanGameBundleHelper", "info.mAppOpenDataBundle path: " + cVar.b);
                }
                return cVar;
            }
            return (c) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq2 a;
        public final /* synthetic */ jo2 b;

        public a(mq2 mq2Var, jo2 jo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mq2Var, jo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mq2Var;
            this.b = jo2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            c j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vj3 vj3Var = new vj3();
                if (this.a.o0() && (o13.x() || f24.a)) {
                    j = b.a(this.a, vj3Var);
                } else {
                    j = d.j(this.a, vj3Var);
                }
                this.b.a(0, j);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static c a(mq2 mq2Var, vj3 vj3Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, mq2Var, vj3Var)) == null) {
                File b = b(vj3Var);
                if (b == null) {
                    return null;
                }
                p53 M = p53.M();
                String b2 = ul4.b(b, false);
                File d = d(b2);
                if (M != null) {
                    if (!TextUtils.equals(M.f0().q("installed_debug_game_bundle_md5", ""), b2)) {
                        if (!f24.i(b, d, mq2Var, vj3Var)) {
                            h53.g(AppRuntime.getAppContext(), "小游戏bundle解压失败!").G();
                            ih3 ih3Var = new ih3();
                            ih3Var.k(5L);
                            ih3Var.i(7L);
                            ih3Var.f("小游戏bundle解压失败! for debug");
                            mh3.a().f(ih3Var);
                            if (vj3Var != null && vj3Var.a == null) {
                                vj3Var.a = ih3Var;
                            }
                            return null;
                        }
                        M.f0().B("installed_debug_game_bundle_md5", b2);
                    }
                } else if (!f24.i(b, d, mq2Var, vj3Var)) {
                    h53.g(AppRuntime.getAppContext(), "小游戏bundle解压失败!").G();
                    ih3 ih3Var2 = new ih3();
                    ih3Var2.k(5L);
                    ih3Var2.i(7L);
                    ih3Var2.f("小游戏bundle解压失败! for debug");
                    mh3.a().f(ih3Var2);
                    if (vj3Var != null && vj3Var.a == null) {
                        vj3Var.a = ih3Var2;
                    }
                    return null;
                }
                c cVar = new c();
                File file = new File(d, "game.json");
                j54 a = j54.a(sl4.E(file));
                if (a == null) {
                    return null;
                }
                cVar.a = d.getPath() + File.separator;
                cVar.c = a;
                if (!TextUtils.isEmpty(a.e)) {
                    cVar.b = cVar.a + a.e + File.separator;
                    a54.a().d(true);
                    a54.a().e(cVar.b);
                    a54.a().f(a.e);
                } else {
                    a54.a().d(false);
                }
                if (f24.a) {
                    Log.d("SwanGameBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanGameBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanGameBundleHelper", "info.appBundlePath path: " + cVar.a);
                    Log.d("SwanGameBundleHelper", "info.mAppOpenDataBundle path: " + cVar.b);
                }
                return cVar;
            }
            return (c) invokeLL.objValue;
        }

        public static File b(vj3 vj3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, vj3Var)) == null) {
                File c = c();
                File[] listFiles = c.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    return e(listFiles);
                }
                Context appContext = AppRuntime.getAppContext();
                h53.g(appContext, c.getPath() + " 没有测试程序包!").G();
                ih3 ih3Var = new ih3();
                ih3Var.k(5L);
                ih3Var.i(4L);
                ih3Var.f("没有小游戏包! for debug, bundle files are empty");
                mh3.a().f(ih3Var);
                if (vj3Var != null) {
                    vj3Var.a = ih3Var;
                    return null;
                }
                return null;
            }
            return (File) invokeL.objValue;
        }

        public static File c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                File e = f24.e("aigames_debug");
                if (!e.exists()) {
                    e.mkdirs();
                }
                return e;
            }
            return (File) invokeV.objValue;
        }

        public static File d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aigames_bundle", str);
                file.mkdirs();
                return file;
            }
            return (File) invokeL.objValue;
        }

        public static File e(File[] fileArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fileArr)) == null) {
                File file = null;
                for (File file2 : fileArr) {
                    if (file == null || file2.lastModified() > file.lastModified()) {
                        file = file2;
                    }
                }
                return file;
            }
            return (File) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends io2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public j54 c;

        public c() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947712225, "Lcom/baidu/tieba/f24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947712225, "Lcom/baidu/tieba/f24;");
                return;
            }
        }
        a = am1.a;
        b = Executors.newSingleThreadExecutor();
    }

    public static void c(mq2 mq2Var, jo2 jo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, mq2Var, jo2Var) == null) {
            b.execute(new a(mq2Var, jo2Var));
        }
    }

    public static void f(String str, lo2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, cVar) == null) {
            lo2.d dVar = new lo2.d();
            dVar.a = str;
            e14.a();
            new wc2().e(dVar, e14.c().getPath(), cVar);
        }
    }

    public static void g(String str, lo2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, cVar) == null) {
            lo2.d dVar = new lo2.d();
            dVar.a = str;
            t14.a();
            new wc2().e(dVar, t14.c().getPath(), cVar);
        }
    }

    public static File d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder");
        }
        return (File) invokeV.objValue;
    }

    public static File e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            File file = new File(AppRuntime.getAppContext().getExternalFilesDir(null), "swangame/debug");
            if (TextUtils.isEmpty(str)) {
                return file;
            }
            return new File(file, str);
        }
        return (File) invokeL.objValue;
    }

    public static void h(lo2.d dVar, lo2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, dVar, cVar) == null) {
            File c2 = b.c();
            new wc2().e(dVar, c2.getPath() + File.separator + System.currentTimeMillis() + ".aibundle", cVar);
        }
    }

    public static boolean i(File file, File file2, mq2 mq2Var, vj3 vj3Var) {
        InterceptResult invokeLLLL;
        boolean U;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65545, null, file, file2, mq2Var, vj3Var)) == null) {
            int i = 0;
            if (file != null && file2 != null) {
                if (file.exists() && file.length() != 0) {
                    uy2.o().F(new UbcFlowEvent("package_start_unzip"));
                    long currentTimeMillis = System.currentTimeMillis();
                    oo2.c j = oo2.j(file);
                    int i2 = j.b;
                    if (i2 != -1) {
                        U = oo2.d(j.a, file2, i2).a;
                        i = j.b;
                    } else {
                        U = sl4.U(file.getPath(), file2.getPath());
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (a) {
                        oo2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (!U) {
                        ih3 ih3Var = new ih3();
                        ih3Var.k(5L);
                        ih3Var.i(7L);
                        ih3Var.f("小游戏bundle解压失败! PkgType=" + i);
                        if (vj3Var != null) {
                            vj3Var.a = ih3Var;
                        }
                    }
                    HybridUbcFlow o = uy2.o();
                    o.F(new UbcFlowEvent("package_end_unzip"));
                    o.D("app_package_version", String.valueOf(i));
                    return U;
                }
                ih3 ih3Var2 = new ih3();
                ih3Var2.k(5L);
                ih3Var2.i(4L);
                ih3Var2.f("小游戏bundle文件不存在或者空文件! ");
                if (vj3Var != null) {
                    vj3Var.a = ih3Var2;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
