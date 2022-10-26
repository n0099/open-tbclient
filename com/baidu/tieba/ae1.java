package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tieba.vq0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ae1 {
    public static /* synthetic */ Interceptable $ic;
    public static d a;
    public static List b;
    public static ce1 c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ String b;
        public final /* synthetic */ File c;
        public final /* synthetic */ String d;

        /* renamed from: com.baidu.tieba.ae1$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0199a implements vq0.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0199a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.vq0.b
            public void a(String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                    ClogBuilder.LogType logType = ClogBuilder.LogType.DOWNLOAD_FAILED;
                    a aVar = this.a;
                    i01.b(new k01(logType, aVar.b, aVar.d, true).b(i, str, "download"));
                }
            }

            @Override // com.baidu.tieba.vq0.b
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    a aVar = this.a;
                    ae1.A(aVar.a, aVar.c);
                    zd1.m().g();
                }
            }
        }

        public a(File file, String str, File file2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, str, file2, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = file;
            this.b = str;
            this.c = file2;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    vq0.a(this.a, this.b, new C0199a(this));
                } catch (Exception e) {
                    i01.b(new k01(ClogBuilder.LogType.DOWNLOAD_FAILED, this.b, this.d, true).b(-1, e.getMessage(), "download"));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ce1 a;

        public b(ce1 ce1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ce1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ce1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ae1.C(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        public c(List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            List list;
            ce1 ce1Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (list = this.a) != null && list.size() != 0) {
                ArrayList arrayList = new ArrayList(3);
                Iterator it = this.a.iterator();
                while (it.hasNext() && (ce1Var = (ce1) it.next()) != null) {
                    if (ae1.w(ce1Var.w)) {
                        ae1.k(ce1Var);
                    } else {
                        arrayList.add(ce1Var);
                    }
                }
                if (arrayList.size() > 0) {
                    if (ae1.a == null) {
                        d unused = ae1.a = new d(arrayList, null);
                        aj0.b().registerReceiver(ae1.a, ae1.a.getIntentFilter());
                        return;
                    }
                    ae1.a.setNeedDownloadList(arrayList);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List mNeedDownloadList;

        public d(List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mNeedDownloadList = list;
        }

        public void setNeedDownloadList(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.mNeedDownloadList = list;
            }
        }

        public /* synthetic */ d(List list, a aVar) {
            this(list);
        }

        public IntentFilter getIntentFilter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            }
            return (IntentFilter) invokeV.objValue;
        }

        public List getNeedDownloadList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mNeedDownloadList;
            }
            return (List) invokeV.objValue;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, intent) == null) {
                Log.d("SourceManager", "onReceive: receiver");
                if (!TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (ce1 ce1Var : this.mNeedDownloadList) {
                    if (ae1.w(ce1Var.w)) {
                        Log.d("SourceManager", "onReceive: " + ce1Var);
                        ae1.k(ce1Var);
                    } else {
                        arrayList.add(ce1Var);
                    }
                }
                this.mNeedDownloadList = arrayList;
            }
        }
    }

    public static boolean A(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, file, file2)) == null) {
            if (file != null && file2 != null) {
                return file.renameTo(file2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static int f(ce1 ce1Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, ce1Var, i)) == null) {
            return h(ce1Var, false, i);
        }
        return invokeLI.intValue;
    }

    public static int g(ce1 ce1Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65547, null, ce1Var, j)) == null) {
            return i(ce1Var, false, 0, j);
        }
        return invokeLJ.intValue;
    }

    public static void B(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, list) == null) {
            j11.d(new c(list), "ScheduleDownloadSplashSourceThread");
        }
    }

    public static void D(ce1 ce1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, ce1Var) == null) && ce1Var.v >= 1) {
            int i = ce1Var.x;
            if (i < Integer.MAX_VALUE) {
                ce1Var.x = i + 1;
            }
            j11.d(new b(ce1Var), "updateSplashDataItemRate");
        }
    }

    public static void E(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list) == null) && list != null && list.size() != 0) {
            b = Collections.synchronizedList(list);
            z(list, r());
        }
    }

    public static int e(ce1 ce1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, ce1Var)) == null) {
            return h(ce1Var, false, 0);
        }
        return invokeL.intValue;
    }

    public static File s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) {
            String n = n(str);
            if (TextUtils.isEmpty(n)) {
                return null;
            }
            return new File(q(), n);
        }
        return (File) invokeL.objValue;
    }

    public static File v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(".tmp");
            return new File(q(), stringBuffer.toString());
        }
        return (File) invokeL.objValue;
    }

    public static boolean w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65563, null, i)) == null) {
            if (new iq0(aj0.b()).a() || i == 0) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static void C(ce1 ce1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ce1Var) == null) {
            ArrayList arrayList = new ArrayList();
            File r = r();
            List t = t();
            if (t != null && t.size() != 0) {
                for (int i = 0; i < t.size(); i++) {
                    ce1 ce1Var2 = (ce1) t.get(i);
                    if (TextUtils.equals(ce1Var.b, ce1Var2.b)) {
                        ce1.l(ce1Var2, ce1Var);
                        arrayList.add(ce1Var2);
                    } else {
                        arrayList.add(ce1Var2);
                    }
                }
                z(arrayList, r);
            }
        }
    }

    public static String m(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, file)) == null) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        } catch (Exception unused) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return sb.toString();
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedReader2.close();
                } catch (Exception unused3) {
                }
            } catch (Exception unused4) {
            } catch (Throwable th2) {
                th = th2;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(y21.b(str, false));
            int lastIndexOf = str.lastIndexOf(".");
            int lastIndexOf2 = str.lastIndexOf("/");
            if (lastIndexOf < lastIndexOf2 || lastIndexOf == -1 || lastIndexOf2 == -1) {
                return null;
            }
            sb.append(str.substring(lastIndexOf));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static ce1 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            return p(0);
        }
        return (ce1) invokeV.objValue;
    }

    public static File q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            File file = new File(aj0.b().getFilesDir(), SpeedStatsUtils.UBC_VALUE_SPLASH);
            file.mkdirs();
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static File r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            return new File(q(), "splash.dat");
        }
        return (File) invokeV.objValue;
    }

    public static List x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            return y(false, 0);
        }
        return (List) invokeV.objValue;
    }

    public static int h(ce1 ce1Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{ce1Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            return i(ce1Var, z, i, System.currentTimeMillis());
        }
        return invokeCommon.intValue;
    }

    public static int i(ce1 ce1Var, boolean z, int i, long j) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{ce1Var, Boolean.valueOf(z), Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (ce1Var.f()) {
                if (!be1.a(ud1.a())) {
                    i2 = 1024;
                } else {
                    i2 = 0;
                }
                if (ee1.a() >= be1.d()) {
                    i2 |= 2048;
                }
                if (!be1.c(true)) {
                    i2 |= 4096;
                }
                if (i2 != 0) {
                    return i2;
                }
            } else {
                i2 = 0;
            }
            if (ce1Var.y) {
                return i2;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long j2 = j / 1000;
            long c2 = ee1.c();
            if ((t21.a(System.currentTimeMillis(), j) < 2 && j2 < ce1Var.s) || j2 > ce1Var.t) {
                i2 |= 2;
            }
            if (z) {
                int i3 = ce1Var.x;
                int i4 = ce1Var.v;
                if (i3 >= i4 || i4 == 0) {
                    i2 |= 8;
                }
            }
            if (currentTimeMillis - c2 < ce1Var.u * 60000) {
                i2 |= 16;
            }
            File s = s(ce1Var.g);
            if (s == null || !s.exists()) {
                i2 |= 4;
            }
            if (i == 1 && od1.a().d() != null && od1.a().d().optInt("hot_launch_splash_policy", 0) == 2 && TextUtils.equals(ce1Var.e, "splash_video")) {
                return i2 | 256;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public static void j(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            if (list != null && !list.isEmpty()) {
                File[] listFiles = q().listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    ArrayList arrayList = new ArrayList(list.size());
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ce1 ce1Var = (ce1) it.next();
                        if (ce1Var != null) {
                            arrayList.add(n(ce1Var.g));
                            arrayList.add(n(ce1Var.z));
                            arrayList.add(n(ce1Var.H));
                        }
                    }
                    ce1 ce1Var2 = c;
                    if (ce1Var2 != null) {
                        arrayList.add(n(ce1Var2.g));
                        arrayList.add(n(c.z));
                        arrayList.add(n(c.H));
                    }
                    for (File file : listFiles) {
                        if (!arrayList.contains(file.getName())) {
                            file.delete();
                        }
                    }
                    return;
                }
                return;
            }
            x21.c(q());
        }
    }

    public static void k(ce1 ce1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65551, null, ce1Var) != null) || !URLUtil.isNetworkUrl(ce1Var.g)) {
            return;
        }
        l(ce1Var.g, ce1Var.d);
        if (!TextUtils.isEmpty(ce1Var.z)) {
            l(ce1Var.z, ce1Var.d);
        }
        if (!TextUtils.isEmpty(ce1Var.H)) {
            l(ce1Var.H, ce1Var.d);
        }
    }

    public static ce1 p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i)) == null) {
            List y = y(true, i);
            if (y != null && y.size() > 0) {
                for (int i2 = 0; i2 < y.size(); i2++) {
                    ce1 ce1Var = (ce1) y.get(i2);
                    if (ce1Var != null && ce1Var.h()) {
                        return ce1Var;
                    }
                }
                return null;
            }
            return null;
        }
        return (ce1) invokeI.objValue;
    }

    public static void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, str, str2) == null) {
            File s = s(str);
            if (s != null && s.exists()) {
                return;
            }
            File v = v(y21.b(str, false));
            if (v.exists()) {
                v.delete();
            }
            j11.d(new a(v, str, s, str2), "download splash resource");
        }
    }

    public static List t() {
        InterceptResult invokeV;
        String m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            List list = b;
            if (list != null) {
                return list;
            }
            b = new CopyOnWriteArrayList();
            File r = r();
            if (!r.exists() || (m = m(r)) == null) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(m);
                for (int i = 0; i < jSONArray.length(); i++) {
                    b.add(ce1.b(jSONArray.optJSONObject(i)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return b;
        }
        return (List) invokeV.objValue;
    }

    public static HashMap u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            HashMap hashMap = new HashMap();
            File r = r();
            if (!r.exists()) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(m(r));
                for (int i = 0; i < jSONArray.length(); i++) {
                    ce1 b2 = ce1.b((JSONObject) jSONArray.get(i));
                    hashMap.put(b2.b, b2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public static List y(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65565, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            List t = t();
            if (t != null && t.size() != 0) {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = new JSONObject();
                int i2 = 0;
                for (int i3 = 0; i3 < t.size(); i3++) {
                    ce1 ce1Var = (ce1) t.get(i3);
                    int h = h(ce1Var, z, i);
                    if (h == 0) {
                        arrayList.add(ce1Var);
                    } else {
                        i2 |= h;
                        try {
                            jSONObject.put(ce1Var.c, h);
                        } catch (JSONException unused) {
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    BaseVM.i(i2, jSONObject.toString());
                    return null;
                }
                return arrayList;
            }
            BaseVM.h(1);
            return null;
        }
        return (List) invokeCommon.objValue;
    }

    public static boolean z(List list, File file) {
        InterceptResult invokeLL;
        StringBuffer stringBuffer;
        int i;
        FileWriter fileWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, list, file)) == null) {
            int i2 = 0;
            if (list.size() <= 0) {
                return false;
            }
            FileWriter fileWriter2 = null;
            try {
                ce1[] ce1VarArr = (ce1[]) list.toArray(new ce1[list.size() - 1]);
                stringBuffer = new StringBuffer();
                stringBuffer.append(PreferencesUtil.LEFT_MOUNT);
                int length = ce1VarArr.length;
                while (true) {
                    i = length - 1;
                    if (i2 >= i) {
                        break;
                    }
                    stringBuffer.append(ce1VarArr[i2].k());
                    stringBuffer.append(",");
                    i2++;
                }
                stringBuffer.append(ce1VarArr[i].k());
                stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
                fileWriter = new FileWriter(file);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileWriter.write(stringBuffer.toString());
                try {
                    fileWriter.close();
                } catch (Exception unused2) {
                }
                return true;
            } catch (IOException unused3) {
                fileWriter2 = fileWriter;
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (Exception unused4) {
                    }
                }
                return true;
            } catch (Throwable th2) {
                fileWriter2 = fileWriter;
                th = th2;
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }
}
