package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes5.dex */
public class dlb {
    public static /* synthetic */ Interceptable $ic;
    public static String A;
    public static int B;
    public static final SimpleDateFormat x;
    public static String y;
    public static String z;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public int d;
    public String e;
    public String f;
    public String g;
    public int h;
    public String i;
    public String j;
    public String k;
    public long l;
    public long m;
    public String n;
    public String o;
    public boolean p;
    public String q;
    public String r;
    public ArrayList<String> s;
    public StringBuilder t;
    public StringBuilder u;
    public StringBuilder v;
    public StringBuilder w;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947709807, "Lcom/baidu/tieba/dlb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947709807, "Lcom/baidu/tieba/dlb;");
                return;
            }
        }
        x = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
        A = "";
        B = -1;
        B = elb.b();
        z = Build.MODEL;
        A = Build.VERSION.SDK_INT + " " + Build.VERSION.RELEASE;
        y = wkb.getContext().provideQualifier();
    }

    public dlb() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = "";
        this.d = -1;
        this.g = "";
        this.r = "-1";
        this.s = new ArrayList<>();
        this.t = new StringBuilder();
        this.u = new StringBuilder();
        this.v = new StringBuilder();
        this.w = new StringBuilder();
    }

    public static dlb b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            dlb dlbVar = new dlb();
            Context provideContext = wkb.getContext().provideContext();
            String str = dlbVar.g;
            if (str == null || str.length() == 0) {
                try {
                    PackageInfo packageInfo = provideContext.getPackageManager().getPackageInfo(provideContext.getPackageName(), 0);
                    dlbVar.h = packageInfo.versionCode;
                    dlbVar.g = packageInfo.versionName;
                } catch (Throwable th) {
                    Log.e("BlockInfo", "newInstance: ", th);
                }
            }
            dlbVar.d = B;
            dlbVar.b = z;
            dlbVar.c = A;
            dlbVar.a = y;
            dlbVar.e = wkb.getContext().provideUid();
            dlbVar.f = flb.a();
            dlbVar.i = wkb.getContext().provideNetworkType();
            dlbVar.j = String.valueOf(elb.a());
            dlbVar.k = String.valueOf(elb.c());
            if (Build.VERSION.SDK_INT >= 24) {
                dlbVar.r = Long.toString(SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
            }
            return dlbVar;
        }
        return (dlb) invokeV.objValue;
    }

    public dlb a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuilder sb = this.t;
            sb.append("qua");
            sb.append(" = ");
            sb.append(this.a);
            sb.append("\r\n");
            StringBuilder sb2 = this.t;
            sb2.append(PushService.APP_VERSION_NAME);
            sb2.append(" = ");
            sb2.append(this.g);
            sb2.append("\r\n");
            StringBuilder sb3 = this.t;
            sb3.append(PushService.APP_VERSION_CODE);
            sb3.append(" = ");
            sb3.append(this.h);
            sb3.append("\r\n");
            StringBuilder sb4 = this.t;
            sb4.append("uid");
            sb4.append(" = ");
            sb4.append(this.e);
            sb4.append("\r\n");
            StringBuilder sb5 = this.t;
            sb5.append("network");
            sb5.append(" = ");
            sb5.append(this.i);
            sb5.append("\r\n");
            StringBuilder sb6 = this.t;
            sb6.append("model");
            sb6.append(" = ");
            sb6.append(this.b);
            sb6.append("\r\n");
            StringBuilder sb7 = this.t;
            sb7.append("api-level");
            sb7.append(" = ");
            sb7.append(this.c);
            sb7.append("\r\n");
            StringBuilder sb8 = this.t;
            sb8.append("cpu-core");
            sb8.append(" = ");
            sb8.append(this.d);
            sb8.append("\r\n");
            StringBuilder sb9 = this.t;
            sb9.append("process");
            sb9.append(" = ");
            sb9.append(this.f);
            sb9.append("\r\n");
            StringBuilder sb10 = this.t;
            sb10.append("freeMemory");
            sb10.append(" = ");
            sb10.append(this.j);
            sb10.append("\r\n");
            StringBuilder sb11 = this.t;
            sb11.append("totalMemory");
            sb11.append(" = ");
            sb11.append(this.k);
            sb11.append("\r\n");
            StringBuilder sb12 = this.v;
            sb12.append("time");
            sb12.append(" = ");
            sb12.append(this.l);
            sb12.append("\r\n");
            StringBuilder sb13 = this.v;
            sb13.append("thread-time");
            sb13.append(" = ");
            sb13.append(this.m);
            sb13.append("\r\n");
            StringBuilder sb14 = this.v;
            sb14.append("time-start");
            sb14.append(" = ");
            sb14.append(this.n);
            sb14.append("\r\n");
            StringBuilder sb15 = this.v;
            sb15.append("time-end");
            sb15.append(" = ");
            sb15.append(this.o);
            sb15.append("\r\n");
            StringBuilder sb16 = this.u;
            sb16.append("cpu-busy");
            sb16.append(" = ");
            sb16.append(this.p);
            sb16.append("\r\n");
            StringBuilder sb17 = this.u;
            sb17.append("cpu-rate");
            sb17.append(" = ");
            sb17.append(this.q);
            sb17.append("\r\n");
            ArrayList<String> arrayList = this.s;
            if (arrayList != null && !arrayList.isEmpty()) {
                StringBuilder sb18 = new StringBuilder();
                Iterator<String> it = this.s.iterator();
                while (it.hasNext()) {
                    sb18.append(it.next());
                    sb18.append("\r\n");
                }
                StringBuilder sb19 = this.w;
                sb19.append("stack");
                sb19.append(" = ");
                sb19.append(sb18.toString());
                sb19.append("\r\n");
            }
            return this;
        }
        return (dlb) invokeV.objValue;
    }

    public dlb c(long j, long j2, long j3, long j4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)})) == null) {
            this.l = j2 - j;
            this.m = j4 - j3;
            this.n = Long.toString(j);
            this.o = Long.toString(j2);
            return this;
        }
        return (dlb) invokeCommon.objValue;
    }

    public dlb d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.q = str;
            return this;
        }
        return (dlb) invokeL.objValue;
    }

    public dlb e(ArrayList<String> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, arrayList)) == null) {
            this.s = arrayList;
            return this;
        }
        return (dlb) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return String.valueOf(this.t) + ((Object) this.v) + ((Object) this.u) + ((Object) this.w);
        }
        return (String) invokeV.objValue;
    }
}
