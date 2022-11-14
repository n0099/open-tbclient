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
public class hi {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hi i;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, oh> a;
    public String b;
    public gh c;
    public ji d;
    public f e;
    public ih f;
    public Handler g;
    public ki h;

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hi a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(hi hiVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hiVar, looper};
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
            this.a = hiVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 6) {
                for (Map.Entry entry : this.a.a.entrySet()) {
                    oh ohVar = (oh) entry.getValue();
                    if (ohVar.u() > 0) {
                        this.a.y(ohVar, true, true);
                    }
                    if (ohVar.t() > 0) {
                        ei.c(ohVar, true, true, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oh a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(hi hiVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, oh ohVar, boolean z, boolean z2) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {hiVar, str, str2, str3, str4, action, ohVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
            this.a = ohVar;
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
                    yh.m().r(this.a, this.b, true, this.c);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oh a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(hi hiVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, oh ohVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {hiVar, str, str2, str3, str4, action, ohVar};
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
            this.a = ohVar;
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
    public class d extends qc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oh c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(hi hiVar, String str, String str2, DiskFileOperate.Action action, oh ohVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hiVar, str, str2, action, ohVar};
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
            this.c = ohVar;
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
    public class e implements ki {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hi a;

        public e(hi hiVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hiVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hiVar;
        }

        @Override // com.baidu.tieba.ki
        public void a(oh ohVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ohVar) == null) {
                if (this.a.o(ohVar)) {
                    this.a.z(ohVar);
                }
                if (this.a.m(ohVar)) {
                    this.a.u(ohVar);
                }
                if (this.a.n(ohVar)) {
                    this.a.x(ohVar);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hi this$0;

        public f(hi hiVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hiVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = hiVar;
        }

        public /* synthetic */ f(hi hiVar, a aVar) {
            this(hiVar);
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

    public hi() {
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
            for (Map.Entry<String, oh> entry : this.a.entrySet()) {
                oh value = entry.getValue();
                z(value);
                u(value);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (Map.Entry<String, oh> entry : this.a.entrySet()) {
                oh value = entry.getValue();
                B(value);
                w(value);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (Map.Entry<String, oh> entry : this.a.entrySet()) {
                oh value = entry.getValue();
                B(value);
                y(value, false, false);
                w(value);
            }
        }
    }

    public void B(oh ohVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ohVar) != null) || ohVar == null) {
            return;
        }
        if (ohVar.l() > 0) {
            A(ohVar, true);
        } else if (ohVar.v() > 0) {
            ii.b(ohVar);
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
            oh j = i().j(str);
            B(j);
            y(j, false, true);
            w(j);
        }
    }

    public void u(oh ohVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, ohVar) == null) {
            v(ohVar, false);
        }
    }

    public void w(oh ohVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, ohVar) != null) || ohVar == null) {
            return;
        }
        if (ohVar.m() > 0) {
            v(ohVar, true);
        } else if (ohVar.t() > 0) {
            ei.c(ohVar, false, false, false);
        }
    }

    public void z(oh ohVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, ohVar) == null) {
            A(ohVar, false);
        }
    }

    public final void A(oh ohVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048576, this, ohVar, z) != null) || ohVar == null) {
            return;
        }
        if (ii.a(ohVar) > 20480) {
            ii.b(ohVar);
        }
        ii.c(ohVar, z);
    }

    public final void v(oh ohVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048596, this, ohVar, z) != null) || ohVar == null) {
            return;
        }
        if (ei.b(ohVar) > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            ei.c(ohVar, false, false, false);
        }
        ei.d(ohVar, z);
    }

    public static hi i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (i == null) {
                synchronized (hi.class) {
                    if (i == null) {
                        i = new hi();
                    }
                }
            }
            return i;
        }
        return (hi) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.d == null) {
                this.d = new ji();
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

    public void D(String str, String str2, String str3, String str4, fh fhVar, Object... objArr) {
        oh j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, fhVar, objArr}) == null) {
            if (str == null && str2 == null) {
                return;
            }
            if ((fhVar != null || (objArr != null && objArr.length != 0)) && (j = j(str)) != null && vh.o().v(str, str2)) {
                if (fhVar == null) {
                    fhVar = new fh(str);
                }
                if (!str.equals("stat") && !str.equals("crash")) {
                    fhVar.c("module", str, "st", str2, "t", String.valueOf(System.currentTimeMillis()));
                }
                if (objArr != null && objArr.length > 0) {
                    fhVar.c(objArr);
                }
                if (this.b != null && !str.equals("stat")) {
                    fhVar.b("uid", this.b);
                }
                if (str3 != null && !str.equals("stat")) {
                    fhVar.b("c_logid", str3);
                }
                if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
                    fhVar.b("seq_id", str4);
                }
                if (!str.equals("stat")) {
                    fhVar.b("net", jh.a(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    fhVar.c("pid", Integer.valueOf(Process.myPid()));
                    if (BdStatisticsManager.getInstance().isMainProcess()) {
                        fhVar.b("ismainproc", "1");
                    } else {
                        fhVar.b("ismainproc", "0");
                    }
                }
                if (lh.e() && lh.d(j)) {
                    fhVar.d(this.f);
                    j.c(fhVar);
                }
                if (vh.o().u(str, str2)) {
                    j.a(fhVar);
                } else {
                    j.b(fhVar);
                }
                nh.e(j, fhVar);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (Map.Entry<String, oh> entry : this.a.entrySet()) {
                oh value = entry.getValue();
                gh ghVar = this.c;
                if (ghVar != null) {
                    long logUploadTime = ghVar.getLogUploadTime(value.o());
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
                        ii.b(value);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        ii.b(value);
                    }
                    if (value.m() > 0) {
                        v(value, false);
                    }
                    if (value.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                        ei.c(value, false, false, false);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        ei.c(value, false, false, false);
                    }
                }
            }
        }
    }

    public synchronized oh j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String g = oh.g(str);
                oh ohVar = this.a.get(g);
                if (ohVar == null) {
                    if ("alert".equals(g)) {
                        ohVar = new bi(null);
                    } else if ("error".equals(g)) {
                        ohVar = new di(this.h);
                    } else if ("dbg".equals(g)) {
                        ohVar = new ci(this.h);
                    } else if ("stat".equals(g)) {
                        ohVar = new gi(this.h);
                    } else if ("pfmonitor".equals(g)) {
                        ohVar = new fi(this.h);
                    } else {
                        ohVar = new di(this.h);
                    }
                    ohVar.I(g);
                    this.a.put(g, ohVar);
                }
                return ohVar;
            }
        }
        return (oh) invokeL.objValue;
    }

    public void l(ih ihVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ihVar) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.e, intentFilter);
            }
            this.c = BdStatisticsManager.getInstance().getBdLogSetting();
            this.f = ihVar;
        }
    }

    public final boolean m(oh ohVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, ohVar)) == null) {
            boolean z = false;
            if (ohVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - ohVar.i() >= 60000) {
                z = true;
            }
            if (vh.o().s(ohVar.o())) {
                z = true;
            }
            if (ohVar.m() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(oh ohVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, ohVar)) == null) {
            boolean z = false;
            if (ohVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - ohVar.j() >= 60000) {
                z = true;
            }
            if (vh.o().s(ohVar.o())) {
                z = true;
            }
            if (ohVar.n() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            for (Map.Entry<String, oh> entry : this.a.entrySet()) {
                oh value = entry.getValue();
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

    public final boolean o(oh ohVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, ohVar)) == null) {
            boolean z = false;
            if (ohVar == null || !lh.e() || !lh.d(ohVar)) {
                return false;
            }
            if (System.currentTimeMillis() - ohVar.k() >= 60000) {
                z = true;
            }
            if (vh.o().s(ohVar.o())) {
                z = true;
            }
            if (ohVar.l() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void x(oh ohVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, ohVar) == null) && ohVar != null && ohVar.n() != 0) {
            if (ohVar.u() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                c cVar = new c(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), ohVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), ohVar.r(), DiskFileOperate.Action.RENAME, ohVar);
                cVar.setSdCard(ohVar.E());
                cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                lc.f().a(cVar);
            }
            d dVar = new d(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), ohVar.s(), DiskFileOperate.Action.APPEND, ohVar);
            dVar.setSdCard(ohVar.E());
            dVar.b(ohVar.y().toString());
            ohVar.e();
            if (!ohVar.A()) {
                dVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.setTrySuccessWeight(3);
            }
            lc.f().a(dVar);
        }
    }

    public void y(oh ohVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{ohVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && ohVar != null && ohVar.u() > 0) {
            b bVar = new b(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), ohVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), ohVar.r(), DiskFileOperate.Action.RENAME, ohVar, z, z2);
            bVar.setSdCard(ohVar.E());
            bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            lc.f().a(bVar);
        }
    }
}
