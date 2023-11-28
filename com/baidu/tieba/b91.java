package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.g21;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class b91 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public long c;
    public long d;
    public long e;
    public Runnable f;
    public final Handler g;
    public final boolean h;
    public final int i;
    public boolean j;
    public boolean k;
    public g21.b l;
    public boolean m;
    public String n;
    public String o;

    /* loaded from: classes5.dex */
    public class a implements g21.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public final /* synthetic */ TelephonyManager c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ b91 e;

        public a(b91 b91Var, TelephonyManager telephonyManager, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b91Var, telephonyManager, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = b91Var;
            this.c = telephonyManager;
            this.d = context;
            this.a = 0;
            this.b = 0;
        }

        @Override // com.baidu.tieba.g21.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            hg0.a("NadPSLogger", "监听到通话状态：OFFHOOK");
                            b(i);
                            if (this.a == 0) {
                                this.e.b = System.currentTimeMillis();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    hg0.a("NadPSLogger", "监听到通话状态：RINGING");
                    b(i);
                    this.e.k = true;
                    return;
                }
                hg0.a("NadPSLogger", "监听到通话状态：IDLE");
                b(i);
                if (this.a == 2) {
                    this.e.c = System.currentTimeMillis();
                    b91 b91Var = this.e;
                    b91Var.k(this.c, b91Var.l, this.d);
                }
            }
        }

        public final void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a = this.b;
                this.b = i;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ TelephonyManager b;
        public final /* synthetic */ g21.b c;
        public final /* synthetic */ b91 d;

        public b(b91 b91Var, Context context, TelephonyManager telephonyManager, g21.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b91Var, context, telephonyManager, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = b91Var;
            this.a = context;
            this.b = telephonyManager;
            this.c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && g21.a(this.a)) {
                if (this.b.getCallState() == 0) {
                    if (this.d.m) {
                        this.d.m = !g21.c(this.a, this.b, this.c);
                    }
                    this.d.e = System.currentTimeMillis();
                    this.d.o();
                    return;
                }
                this.d.l(this.a, this.b, this.c);
            }
        }
    }

    public b91() {
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
        this.a = 0L;
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.g = new Handler(Looper.getMainLooper());
        this.h = ij0.b().a().a("psl_switch", 1) == 1;
        this.i = ij0.b().a().a("psl_time", 20);
        this.j = false;
        this.k = false;
        this.m = false;
    }

    public final int m(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            if (j <= 0) {
                return 0;
            }
            return (int) TimeUnit.MILLISECONDS.toSeconds(j);
        }
        return invokeJ.intValue;
    }

    public final void k(@NonNull TelephonyManager telephonyManager, @NonNull g21.b bVar, @NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, telephonyManager, bVar, context) == null) {
            long j = this.b;
            if (j != 0) {
                long j2 = this.c;
                if (j2 != 0 && j2 > j) {
                    this.g.removeCallbacks(this.f);
                    if (this.m) {
                        this.m = !g21.c(context, telephonyManager, bVar);
                    }
                    this.e = System.currentTimeMillis();
                    o();
                    return;
                }
            }
            l(context, telephonyManager, bVar);
        }
    }

    public final void l(@NonNull Context context, @NonNull TelephonyManager telephonyManager, @NonNull g21.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, telephonyManager, bVar) == null) {
            Runnable runnable = this.f;
            if (runnable != null) {
                this.g.removeCallbacks(runnable);
            } else {
                this.f = new b(this, context, telephonyManager, bVar);
            }
            if (!this.m) {
                this.m = g21.b(context, telephonyManager, bVar);
            }
            this.g.postDelayed(this.f, TimeUnit.SECONDS.toMillis(this.i));
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long j = this.c;
            if (j != 0) {
                long j2 = this.b;
                if (j2 != 0 && j > j2) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void o() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.j) {
            return;
        }
        this.j = true;
        if (TextUtils.isEmpty(this.n)) {
            return;
        }
        String str3 = "1";
        if (n()) {
            str = "1";
        } else {
            str = "0";
        }
        String str4 = "-1";
        if (!n()) {
            str2 = "-1";
        } else {
            str2 = "" + m(this.c - this.b);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(PreferencesUtil.LEFT_MOUNT);
        sb.append(this.i);
        sb.append(",");
        sb.append(m(this.e - this.d));
        sb.append(",");
        if (n()) {
            str4 = "" + m(this.b - this.a);
        }
        sb.append(str4);
        sb.append(",");
        if (!this.k) {
            str3 = "0";
        }
        sb.append(str3);
        sb.append(PreferencesUtil.RIGHT_MOUNT);
        String sb2 = sb.toString();
        ClogBuilder m = new ClogBuilder().y(ClogBuilder.LogType.PHONE_STATE_LISTEN).p(this.n).k(str).l(str2).m(sb2);
        if (!TextUtils.isEmpty(this.o)) {
            m.n(this.o);
        } else {
            m.n("");
        }
        bz0.e(m);
        hg0.a("NadPSLogger", "==========结束监听并打点==========");
        hg0.a("NadPSLogger", "log_type：" + ClogBuilder.LogType.PHONE_STATE_LISTEN.type);
        hg0.a("NadPSLogger", "da_ext1 是否监听到主动呼出：" + str);
        hg0.a("NadPSLogger", "da_ext2 主动呼出时长：" + str2);
        hg0.a("NadPSLogger", "da_ext3 云控监听时长，实际监听时长，拨号前停留时长，期间有无呼入：" + sb2);
    }

    @Deprecated
    public void p(@NonNull Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, context, str, str2) == null) {
            Context applicationContext = context.getApplicationContext();
            if (!this.h || !g21.a(applicationContext)) {
                return;
            }
            this.b = 0L;
            this.c = 0L;
            this.d = 0L;
            this.e = 0L;
            this.a = 0L;
            this.a = System.currentTimeMillis();
            this.j = false;
            this.k = false;
            this.n = str;
            this.o = str2;
            TelephonyManager telephonyManager = (TelephonyManager) applicationContext.getSystemService("phone");
            g21.b bVar = new g21.b();
            this.l = bVar;
            bVar.b(new a(this, telephonyManager, applicationContext));
            l(applicationContext, telephonyManager, this.l);
            this.d = System.currentTimeMillis();
            hg0.a("NadPSLogger", "==========开始监听==========");
        }
    }
}
