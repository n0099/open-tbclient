package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class gi {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gi i;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, nh> a;
    public String b;
    public fh c;
    public ii d;
    public f e;
    public hh f;
    public Handler g;
    public ji h;

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gi a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(gi giVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = giVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 6) {
                for (Map.Entry entry : this.a.a.entrySet()) {
                    nh nhVar = (nh) entry.getValue();
                    if (nhVar.u() > 0) {
                        this.a.y(nhVar, true, true);
                    }
                    if (nhVar.t() > 0) {
                        di.c(nhVar, true, true, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nh a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(gi giVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, nh nhVar, boolean z, boolean z2) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {giVar, str, str2, str3, str4, action, nhVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (DiskFileOperate.Action) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nhVar;
            this.b = z;
            this.c = z2;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.a.H(0L);
                    xh.m().r(this.a, this.b, true, this.c);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nh a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(gi giVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, nh nhVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {giVar, str, str2, str3, str4, action, nhVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (DiskFileOperate.Action) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nhVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.a.H(0L);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends pc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nh c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(gi giVar, String str, String str2, DiskFileOperate.Action action, nh nhVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giVar, str, str2, action, nhVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (DiskFileOperate.Action) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nhVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.c.H(getFileInfo().length());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements ji {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gi a;

        public e(gi giVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = giVar;
        }

        @Override // com.baidu.tieba.ji
        public void a(nh nhVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nhVar) == null) {
                if (this.a.o(nhVar)) {
                    this.a.z(nhVar);
                }
                if (this.a.m(nhVar)) {
                    this.a.u(nhVar);
                }
                if (this.a.n(nhVar)) {
                    this.a.x(nhVar);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gi this$0;

        public f(gi giVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = giVar;
        }

        public /* synthetic */ f(gi giVar, a aVar) {
            this(giVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, context, intent) != null) || intent == null) {
                return;
            }
            this.this$0.C(intent.getStringExtra("intent_data_userid"));
            this.this$0.p();
        }
    }

    public gi() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap<>();
        this.g = new a(this, Looper.getMainLooper());
        this.h = new e(this);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (Map.Entry<String, nh> entry : this.a.entrySet()) {
                nh value = entry.getValue();
                z(value);
                u(value);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (Map.Entry<String, nh> entry : this.a.entrySet()) {
                nh value = entry.getValue();
                B(value);
                w(value);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (Map.Entry<String, nh> entry : this.a.entrySet()) {
                nh value = entry.getValue();
                B(value);
                y(value, false, false);
                w(value);
            }
        }
    }

    public void B(nh nhVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nhVar) != null) || nhVar == null) {
            return;
        }
        if (nhVar.l() > 0) {
            A(nhVar, true);
        } else if (nhVar.v() > 0) {
            hi.b(nhVar);
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.b = str;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            nh j = i().j(str);
            B(j);
            y(j, false, true);
            w(j);
        }
    }

    public void u(nh nhVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, nhVar) == null) {
            v(nhVar, false);
        }
    }

    public void w(nh nhVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, nhVar) != null) || nhVar == null) {
            return;
        }
        if (nhVar.m() > 0) {
            v(nhVar, true);
        } else if (nhVar.t() > 0) {
            di.c(nhVar, false, false, false);
        }
    }

    public void z(nh nhVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, nhVar) == null) {
            A(nhVar, false);
        }
    }

    public final void A(nh nhVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048576, this, nhVar, z) != null) || nhVar == null) {
            return;
        }
        if (hi.a(nhVar) > 20480) {
            hi.b(nhVar);
        }
        hi.c(nhVar, z);
    }

    public final void v(nh nhVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048596, this, nhVar, z) != null) || nhVar == null) {
            return;
        }
        if (di.b(nhVar) > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            di.c(nhVar, false, false, false);
        }
        di.d(nhVar, z);
    }

    public static gi i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (i == null) {
                synchronized (gi.class) {
                    if (i == null) {
                        i = new gi();
                    }
                }
            }
            return i;
        }
        return (gi) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.d == null) {
                this.d = new ii();
            }
            this.d.a();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Message obtainMessage = this.g.obtainMessage();
            obtainMessage.what = 6;
            this.g.removeMessages(6);
            this.g.sendMessageDelayed(obtainMessage, 3000L);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Message obtainMessage = this.g.obtainMessage();
            obtainMessage.what = 6;
            this.g.removeMessages(6);
            this.g.sendMessage(obtainMessage);
        }
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public void D(String str, String str2, String str3, String str4, eh ehVar, Object... objArr) {
        nh j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, ehVar, objArr}) == null) {
            if (str == null && str2 == null) {
                return;
            }
            if ((ehVar != null || (objArr != null && objArr.length != 0)) && (j = j(str)) != null && uh.o().v(str, str2)) {
                if (ehVar == null) {
                    ehVar = new eh(str);
                }
                if (!str.equals("stat") && !str.equals("crash")) {
                    ehVar.c("module", str, "st", str2, "t", String.valueOf(System.currentTimeMillis()));
                }
                if (objArr != null && objArr.length > 0) {
                    ehVar.c(objArr);
                }
                if (this.b != null && !str.equals("stat")) {
                    ehVar.b("uid", this.b);
                }
                if (str3 != null && !str.equals("stat")) {
                    ehVar.b("c_logid", str3);
                }
                if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
                    ehVar.b("seq_id", str4);
                }
                if (!str.equals("stat")) {
                    ehVar.b("net", ih.a(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    ehVar.c("pid", Integer.valueOf(Process.myPid()));
                    if (BdStatisticsManager.getInstance().isMainProcess()) {
                        ehVar.b("ismainproc", "1");
                    } else {
                        ehVar.b("ismainproc", "0");
                    }
                }
                if (kh.e() && kh.d(j)) {
                    ehVar.d(this.f);
                    j.c(ehVar);
                }
                if (uh.o().u(str, str2)) {
                    j.a(ehVar);
                } else {
                    j.b(ehVar);
                }
                mh.e(j, ehVar);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (Map.Entry<String, nh> entry : this.a.entrySet()) {
                nh value = entry.getValue();
                fh fhVar = this.c;
                if (fhVar != null) {
                    long logUploadTime = fhVar.getLogUploadTime(value.o());
                    if (logUploadTime <= 0) {
                        logUploadTime = System.currentTimeMillis();
                        this.c.setLogUploadTime(value.o(), logUploadTime);
                    }
                    value.L(logUploadTime);
                }
                if (value != null) {
                    if (value.l() > 0) {
                        A(value, false);
                    }
                    if (value.v() > 20480) {
                        hi.b(value);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        hi.b(value);
                    }
                    if (value.m() > 0) {
                        v(value, false);
                    }
                    if (value.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                        di.c(value, false, false, false);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        di.c(value, false, false, false);
                    }
                }
            }
        }
    }

    public synchronized nh j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String g = nh.g(str);
                nh nhVar = this.a.get(g);
                if (nhVar == null) {
                    if ("alert".equals(g)) {
                        nhVar = new ai(null);
                    } else if ("error".equals(g)) {
                        nhVar = new ci(this.h);
                    } else if ("dbg".equals(g)) {
                        nhVar = new bi(this.h);
                    } else if ("stat".equals(g)) {
                        nhVar = new fi(this.h);
                    } else if ("pfmonitor".equals(g)) {
                        nhVar = new ei(this.h);
                    } else {
                        nhVar = new ci(this.h);
                    }
                    nhVar.I(g);
                    this.a.put(g, nhVar);
                }
                return nhVar;
            }
        }
        return (nh) invokeL.objValue;
    }

    public void l(hh hhVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, hhVar) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.e, intentFilter);
            }
            this.c = BdStatisticsManager.getInstance().getBdLogSetting();
            this.f = hhVar;
        }
    }

    public final boolean m(nh nhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, nhVar)) == null) {
            boolean z = false;
            if (nhVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - nhVar.i() >= 60000) {
                z = true;
            }
            if (uh.o().s(nhVar.o())) {
                z = true;
            }
            if (nhVar.m() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(nh nhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, nhVar)) == null) {
            boolean z = false;
            if (nhVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - nhVar.j() >= 60000) {
                z = true;
            }
            if (uh.o().s(nhVar.o())) {
                z = true;
            }
            if (nhVar.n() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            for (Map.Entry<String, nh> entry : this.a.entrySet()) {
                nh value = entry.getValue();
                z(value);
                u(value);
                x(value);
            }
            if (z) {
                h();
            } else {
                g();
            }
        }
    }

    public final boolean o(nh nhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, nhVar)) == null) {
            boolean z = false;
            if (nhVar == null || !kh.e() || !kh.d(nhVar)) {
                return false;
            }
            if (System.currentTimeMillis() - nhVar.k() >= 60000) {
                z = true;
            }
            if (uh.o().s(nhVar.o())) {
                z = true;
            }
            if (nhVar.l() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void x(nh nhVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, nhVar) == null) && nhVar != null && nhVar.n() != 0) {
            if (nhVar.u() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                c cVar = new c(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), nhVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), nhVar.r(), DiskFileOperate.Action.RENAME, nhVar);
                cVar.setSdCard(nhVar.E());
                cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                kc.f().a(cVar);
            }
            d dVar = new d(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), nhVar.s(), DiskFileOperate.Action.APPEND, nhVar);
            dVar.setSdCard(nhVar.E());
            dVar.b(nhVar.y().toString());
            nhVar.e();
            if (!nhVar.A()) {
                dVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.setTrySuccessWeight(3);
            }
            kc.f().a(dVar);
        }
    }

    public void y(nh nhVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{nhVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && nhVar != null && nhVar.u() > 0) {
            b bVar = new b(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), nhVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), nhVar.r(), DiskFileOperate.Action.RENAME, nhVar, z, z2);
            bVar.setSdCard(nhVar.E());
            bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            kc.f().a(bVar);
        }
    }
}
