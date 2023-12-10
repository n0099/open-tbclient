package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.mgc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.sdk.crashreportbaidu.ActivityHistory;
import com.yy.sdk.crashreportbaidu.CrashHandler;
import com.yy.sdk.crashreportbaidu.CrashInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class igc {
    public static /* synthetic */ Interceptable $ic = null;
    public static lgc<CrashInfo> a = null;
    public static String b = "";
    public static ggc c;
    public static List<String> d;
    public static e e;
    public static List<String> f;
    public static h g;
    public static ConcurrentHashMap<String, Integer> h;
    public static CrashHandler.b i;
    public static Boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface e {
        void a(String str, boolean z, String str2, String str3, String str4);

        void b(String str, boolean z, String str2, String str3, String str4);

        void c(boolean z, String str, String str2, String str3);
    }

    /* loaded from: classes6.dex */
    public interface g {
        Map<String, String> getExtInfo();
    }

    /* loaded from: classes6.dex */
    public interface h {
        List<String> a();
    }

    /* loaded from: classes6.dex */
    public static class a implements CrashHandler.b {
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

        @Override // com.yy.sdk.crashreportbaidu.CrashHandler.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ngc.S();
            }
        }

        @Override // com.yy.sdk.crashreportbaidu.CrashHandler.b
        public void b(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, str2) == null) {
                igc.m(i, str, null, str2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                List<CrashInfo> d = igc.a.d();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (CrashInfo crashInfo : d) {
                    mgc.j(crashInfo, null, null);
                    igc.h.put(crashInfo.crashId, 7);
                    igc.h(crashInfo, arrayList, arrayList2, arrayList3);
                    igc.u(crashInfo, arrayList, "2");
                    igc.u(crashInfo, arrayList2, "3");
                }
                igc.j();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements mgc.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // com.baidu.tieba.mgc.f
        public void onResult(String str, boolean z, int i, String str2) {
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i), str2}) == null) {
                Object[] objArr = new Object[4];
                objArr[0] = this.a;
                if (z) {
                    str3 = "success";
                } else {
                    str3 = "failed";
                }
                objArr[1] = str3;
                objArr[2] = Integer.valueOf(i);
                objArr[3] = str2;
                hgc.d("CrashReport", String.format("crash[id = %s] report %s [status code = %s, ret = %s]", objArr));
                igc.c.b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements mgc.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CrashInfo a;
        public final /* synthetic */ String b;
        public final /* synthetic */ List c;

        public d(CrashInfo crashInfo, String str, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {crashInfo, str, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = crashInfo;
            this.b = str;
            this.c = list;
        }

        @Override // com.baidu.tieba.mgc.f
        public void onResult(String str, boolean z, int i, String str2) {
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i), str2}) == null) {
                Object[] objArr = new Object[5];
                objArr[0] = this.a.crashId;
                if (z) {
                    str3 = "success";
                } else {
                    str3 = "failed";
                }
                objArr[1] = str3;
                objArr[2] = this.b;
                objArr[3] = Integer.valueOf(i);
                objArr[4] = str2;
                kgc.d("CrashReport", String.format("upload crash report[id = %s] %s [stage = %s, status code = %s, ret = %s]", objArr));
                String d = mgc.d(this.a.crashId, this.b);
                if (!TextUtils.isEmpty(d)) {
                    new File(d).delete();
                }
                if (z) {
                    this.a.clearFiles(this.c);
                    Integer num = (Integer) igc.h.get(this.a.crashId);
                    if (num != null) {
                        int intValue = num.intValue();
                        if ("2".equals(this.b)) {
                            intValue &= -2;
                        } else if ("3".equals(this.b)) {
                            intValue &= -3;
                        }
                        if (intValue == 0) {
                            igc.a.c(this.a.crashId);
                            igc.h.remove(this.a.crashId);
                        } else {
                            igc.h.put(this.a.crashId, Integer.valueOf(intValue));
                        }
                    }
                }
                igc.c.b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public String b;
        public String c;
        public String d;
        public String e;
        public jgc f;

        public f() {
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
            this.a = null;
            this.b = "default";
            this.c = "default";
            this.d = "";
            this.e = "default";
            this.f = null;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.c;
            }
            return (String) invokeV.objValue;
        }

        public Context c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a;
            }
            return (Context) invokeV.objValue;
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.e;
            }
            return (String) invokeV.objValue;
        }

        public jgc e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.f;
            }
            return (jgc) invokeV.objValue;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.d;
            }
            return (String) invokeV.objValue;
        }

        public f g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.b = str;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f h(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
                this.a = context;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f i(jgc jgcVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jgcVar)) == null) {
                this.f = jgcVar;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.d = str;
                return this;
            }
            return (f) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947853988, "Lcom/baidu/tieba/igc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947853988, "Lcom/baidu/tieba/igc;");
                return;
            }
        }
        h = new ConcurrentHashMap<>();
        i = new a();
        j = Boolean.FALSE;
    }

    public igc() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            List<String> list = f;
            if (list != null && list.size() != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void k() {
        List<String> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65548, null) != null) || (list = d) == null) {
            return;
        }
        for (String str : list) {
            ngc.P(str);
        }
    }

    public static List<String> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return f;
        }
        return (List) invokeV.objValue;
    }

    public static void u(CrashInfo crashInfo, List<String> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65558, null, crashInfo, list, str) == null) {
            mgc.k(crashInfo, str, list, new d(crashInfo, str, list));
        }
    }

    public static void g(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, map) == null) {
            ngc.a(map);
        }
    }

    public static void q(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, eVar) == null) {
            e = eVar;
        }
    }

    public static void r(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, map) == null) {
            ngc.V(map);
        }
    }

    public static void t(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, context) == null) {
            kgc.d("CrashReport", "upload all dumps");
            new Thread(new b()).start();
        }
    }

    public static void h(CrashInfo crashInfo, List<String> list, List<String> list2, List<String> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, crashInfo, list, list2, list3) == null) {
            list.clear();
            list2.clear();
            boolean z = false;
            int i2 = 0;
            for (String str : crashInfo.fileList) {
                if (str != null) {
                    File file = new File(str);
                    String name = file.getName();
                    if (!name.endsWith(".dmp") && !name.endsWith(".symbol")) {
                        if (!z && ((name.contains(crashInfo.crashId) || name.endsWith(".syslog")) && file.exists())) {
                            i2 |= 2;
                            z = true;
                        }
                        if (name.endsWith(".hprof") && file.exists()) {
                            list3.add(str);
                            i2 |= 4;
                        }
                    } else if (file.exists()) {
                        list.add(str);
                        i2 |= 1;
                    }
                }
            }
            if (z) {
                list2.addAll(crashInfo.fileList);
                list2.removeAll(list);
            }
            if (i2 != 0) {
                h.put(crashInfo.crashId, Integer.valueOf(i2));
            }
        }
    }

    public static void j() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            try {
                File file = new File(ngc.s());
                if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                    Date date = new Date();
                    for (File file2 : listFiles) {
                        if (!file2.isDirectory() && file2.getName().endsWith(".syslog")) {
                            if (date.getTime() - new Date(file2.lastModified()).getTime() > 432000000) {
                                file2.delete();
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x01c6 A[Catch: all -> 0x01d9, TryCatch #4 {all -> 0x01d9, blocks: (B:57:0x01c2, B:59:0x01c6, B:63:0x01ce), top: B:83:0x01c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m(int i2, String str, String str2, String str3) {
        String str4;
        CrashInfo crashInfo;
        boolean z;
        List<String> a2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            String str5 = str;
            String str6 = str2;
            boolean z3 = true;
            try {
                if (e != null) {
                    e eVar = e;
                    if (i2 == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    eVar.c(z2, str5, str6, str3);
                }
            } catch (Throwable th) {
                kgc.e("CrashReport", "mCrashCallback.preCrashCallback error!", th);
            }
            try {
                File file = new File(str5);
                File file2 = new File(file.getParent() + File.separator + ngc.n() + ".dmp");
                str5 = file2.getAbsolutePath();
                file.renameTo(file2);
            } catch (Throwable th2) {
                kgc.e("CrashReport", "NullPointerException!", th2);
            }
            String str7 = str5;
            try {
                File file3 = new File(str6);
                File file4 = new File(file3.getParent() + File.separator + ngc.n() + ".symbol");
                str6 = file4.getAbsolutePath();
                file3.renameTo(file4);
            } catch (Throwable th3) {
                kgc.e("CrashReport", "mCrashCallback.preCrashCallback error!", th3);
            }
            String str8 = str6;
            hgc.d("CrashReport", (CrashInfo.CrashType.valueOf(i2).toString() + " heppen") + ", dumpFile = " + str7 + ", dumpSymbolFile = " + str8);
            CrashInfo generateCrashInfo = CrashInfo.generateCrashInfo(CrashInfo.CrashType.valueOf(i2), str7, str3, str8, b);
            String str9 = generateCrashInfo.crashId;
            if (i()) {
                generateCrashInfo.fileList.addAll(l());
            }
            HashSet hashSet = new HashSet(generateCrashInfo.fileList);
            h hVar = g;
            if (hVar != null && (a2 = hVar.a()) != null) {
                for (int i3 = 0; i3 < a2.size(); i3++) {
                    String str10 = a2.get(i3);
                    if (!hashSet.contains(str10)) {
                        generateCrashInfo.fileList.add(str10);
                        hgc.d("CrashReport", "newCrash.fileList.add = " + str10);
                    }
                }
            }
            String a3 = a.a(generateCrashInfo);
            try {
                if (e != null) {
                    e eVar2 = e;
                    String str11 = generateCrashInfo.crashId;
                    if (i2 == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    str4 = str9;
                    crashInfo = generateCrashInfo;
                    try {
                        eVar2.b(str11, z, str7, str8, str3);
                    } catch (Throwable th4) {
                        th = th4;
                        kgc.e("CrashReport", "mCrashCallback.crashCallback error!", th);
                        k();
                        hgc.d("CrashReport", String.format("start report crash[crash id = %s]", str4));
                        c.a(3);
                        CrashInfo crashInfo2 = crashInfo;
                        mgc.j(crashInfo2, a3, new c(str4));
                        h.put(crashInfo2.crashId, 7);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str7);
                        arrayList.add(str8);
                        u(crashInfo2, arrayList, "2");
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.addAll(crashInfo2.fileList);
                        arrayList2.removeAll(arrayList);
                        u(crashInfo2, arrayList2, "3");
                        if (e != null) {
                        }
                        if (Build.VERSION.SDK_INT >= 22) {
                        }
                    }
                } else {
                    str4 = str9;
                    crashInfo = generateCrashInfo;
                }
                if (i2 == 1) {
                    kgc.e("CrashReport", "Native Crash Happen!", new Throwable("NativeCrashException"));
                }
            } catch (Throwable th5) {
                th = th5;
                str4 = str9;
                crashInfo = generateCrashInfo;
            }
            k();
            hgc.d("CrashReport", String.format("start report crash[crash id = %s]", str4));
            c.a(3);
            CrashInfo crashInfo22 = crashInfo;
            mgc.j(crashInfo22, a3, new c(str4));
            h.put(crashInfo22.crashId, 7);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(str7);
            arrayList3.add(str8);
            u(crashInfo22, arrayList3, "2");
            ArrayList arrayList22 = new ArrayList();
            arrayList22.addAll(crashInfo22.fileList);
            arrayList22.removeAll(arrayList3);
            u(crashInfo22, arrayList22, "3");
            try {
                if (e != null) {
                    e eVar3 = e;
                    String str12 = crashInfo22.crashId;
                    if (i2 != 1) {
                        z3 = false;
                    }
                    eVar3.a(str12, z3, str7, str8, str3);
                }
            } catch (Throwable th6) {
                kgc.c("CrashReport", "mCrashCallback.preCrashCallback error!", th6);
            }
            if (Build.VERSION.SDK_INT >= 22) {
                c.c(3000);
            } else {
                c.c(4000);
            }
        }
    }

    public static synchronized boolean n(f fVar) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, fVar)) == null) {
            synchronized (igc.class) {
                if (j.booleanValue()) {
                    kgc.d("CrashReport", "crashreport has init, please check!");
                    return false;
                }
                if ((fVar.c().getApplicationInfo().flags & 2) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                ngc.U(z);
                kgc.f(fVar.e());
                ActivityHistory.INSTANCE.init(fVar.c());
                ngc.I(fVar.c(), fVar.a(), fVar.b());
                ngc.W(fVar.d());
                CrashHandler.e(i);
                o(fVar.c());
                c = new ggc();
                mgc.e(fVar.c());
                if (p(fVar.f(), fVar.c())) {
                    ngc.Q(true);
                    CrashHandler.initNativeHandler(ngc.s());
                    kgc.d("CrashReport", "crashreport init, use native catch 3.1.0-baidu-SNAPSHOT");
                } else {
                    ngc.Q(false);
                    kgc.d("CrashReport", "crashreport init by 3.1.0-baidu-SNAPSHOT");
                }
                t(fVar.c());
                j = Boolean.TRUE;
                if (ngc.J()) {
                    StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().build());
                }
                return j.booleanValue();
            }
        }
        return invokeL.booleanValue;
    }

    public static void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, context) == null) {
            a = new lgc<>(context, "CrashDB_" + ngc.e());
            lgc lgcVar = new lgc(context, "CrashSharedPref");
            List<CrashInfo> d2 = lgcVar.d();
            for (CrashInfo crashInfo : d2) {
                kgc.a("hqq", "oldCrash: " + crashInfo.nyyData);
                a.a(crashInfo);
            }
            if (!d2.isEmpty()) {
                lgcVar.b();
            }
        }
    }

    public static boolean p(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, str, context)) == null) {
            if (str != null) {
                try {
                    if (!str.isEmpty()) {
                        System.load(str);
                        return true;
                    }
                } catch (UnsatisfiedLinkError e2) {
                    if (!ngc.J()) {
                        kgc.c("CrashReport", "load yycrashreport.so failed, native crash will not report", e2);
                        return false;
                    }
                    throw new UnsatisfiedLinkError("load yycrashreport failed");
                }
            }
            if (!ngc.M(context, "yycrashreport")) {
                throw new UnsatisfiedLinkError("load yycrashreport failed");
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void s(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, list) == null) {
            synchronized (igc.class) {
                if (f == null) {
                    f = new ArrayList();
                } else {
                    f.clear();
                }
                for (int i2 = 0; i2 < list.size(); i2++) {
                    String str = list.get(i2);
                    if (b != null && !b.equals(str)) {
                        f.add(str);
                    }
                }
            }
        }
    }
}
