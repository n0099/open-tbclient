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
import com.baidu.adp.lib.stats.BdStatsItem;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.searchbox.retrieve.core.task.UploadTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class ad {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ad j;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, hc> a;
    public final uc b;
    public String c;
    public ac d;
    public cd e;
    public f f;
    public bc g;
    public Handler h;
    public dd i;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ad a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ad adVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVar, looper};
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
            this.a = adVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 6) {
                for (Map.Entry entry : this.a.a.entrySet()) {
                    hc hcVar = (hc) entry.getValue();
                    if (hcVar.u() > 0) {
                        this.a.y(hcVar, true, true);
                    }
                    if (hcVar.t() > 0) {
                        xc.c(hcVar, true, true, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hc a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ad adVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, hc hcVar, boolean z, boolean z2) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {adVar, str, str2, str3, str4, action, hcVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
            this.a = hcVar;
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
                    qc.m().r(this.a, this.b, true, this.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hc a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ad adVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, hc hcVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {adVar, str, str2, str3, str4, action, hcVar};
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
            this.a = hcVar;
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

    /* loaded from: classes5.dex */
    public class d extends p7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hc c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ad adVar, String str, String str2, DiskFileOperate.Action action, hc hcVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVar, str, str2, action, hcVar};
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
            this.c = hcVar;
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

    /* loaded from: classes5.dex */
    public class e implements dd {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ad a;

        public e(ad adVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adVar;
        }

        @Override // com.baidu.tieba.dd
        public void a(hc hcVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hcVar) == null) {
                if (this.a.o(hcVar)) {
                    this.a.z(hcVar);
                }
                if (this.a.m(hcVar)) {
                    this.a.u(hcVar);
                }
                if (this.a.n(hcVar)) {
                    this.a.x(hcVar);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ad this$0;

        public f(ad adVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = adVar;
        }

        public /* synthetic */ f(ad adVar, a aVar) {
            this(adVar);
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

    public ad() {
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
        this.a = new ConcurrentHashMap<>();
        this.b = new uc();
        this.h = new a(this, Looper.getMainLooper());
        this.i = new e(this);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (Map.Entry<String, hc> entry : this.a.entrySet()) {
                hc value = entry.getValue();
                z(value);
                u(value);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (Map.Entry<String, hc> entry : this.a.entrySet()) {
                hc value = entry.getValue();
                B(value);
                w(value);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (Map.Entry<String, hc> entry : this.a.entrySet()) {
                hc value = entry.getValue();
                B(value);
                y(value, false, false);
                w(value);
            }
        }
    }

    public void B(hc hcVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hcVar) != null) || hcVar == null) {
            return;
        }
        if (hcVar.l() > 0) {
            A(hcVar, true);
        } else if (hcVar.v() > 0) {
            bd.b(hcVar);
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.c = str;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            hc j2 = i().j(str);
            B(j2);
            y(j2, false, true);
            w(j2);
        }
    }

    public void u(hc hcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, hcVar) == null) {
            v(hcVar, false);
        }
    }

    public void w(hc hcVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, hcVar) != null) || hcVar == null) {
            return;
        }
        if (hcVar.m() > 0) {
            v(hcVar, true);
        } else if (hcVar.t() > 0) {
            xc.c(hcVar, false, false, false);
        }
    }

    public void z(hc hcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, hcVar) == null) {
            A(hcVar, false);
        }
    }

    public final void A(hc hcVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048576, this, hcVar, z) != null) || hcVar == null) {
            return;
        }
        if (bd.a(hcVar) > UploadTask.SIZE_LIMIT_DEFAULT) {
            bd.b(hcVar);
        }
        bd.c(hcVar, z);
    }

    public final void v(hc hcVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048596, this, hcVar, z) != null) || hcVar == null) {
            return;
        }
        if (xc.b(hcVar) > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            xc.c(hcVar, false, false, false);
        }
        xc.d(hcVar, z);
    }

    public static ad i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (j == null) {
                synchronized (ad.class) {
                    if (j == null) {
                        j = new ad();
                    }
                }
            }
            return j;
        }
        return (ad) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.e == null) {
                this.e = new cd();
            }
            this.e.a();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Message obtainMessage = this.h.obtainMessage();
            obtainMessage.what = 6;
            this.h.removeMessages(6);
            this.h.sendMessageDelayed(obtainMessage, 3000L);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Message obtainMessage = this.h.obtainMessage();
            obtainMessage.what = 6;
            this.h.removeMessages(6);
            this.h.sendMessage(obtainMessage);
        }
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public void D(String str, String str2, String str3, String str4, BdStatsItem bdStatsItem, Object... objArr) {
        hc j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, bdStatsItem, objArr}) == null) {
            if (str == null && str2 == null) {
                return;
            }
            if ((bdStatsItem != null || (objArr != null && objArr.length != 0)) && (j2 = j(str)) != null && nc.o().v(str, str2)) {
                if (bdStatsItem == null) {
                    bdStatsItem = new BdStatsItem(str);
                }
                if (!"stat".equals(str) && !"crash".equals(str)) {
                    bdStatsItem.append("module", str, "st", str2, "t", String.valueOf(System.currentTimeMillis()));
                }
                if (objArr != null && objArr.length > 0) {
                    bdStatsItem.append(objArr);
                }
                if (this.c != null && !str.equals("stat")) {
                    bdStatsItem.append("uid", this.c);
                }
                if (str3 != null && !str.equals("stat")) {
                    bdStatsItem.append("c_logid", str3);
                }
                if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
                    bdStatsItem.append(PushConstants.SEQ_ID, str4);
                }
                if (!str.equals("stat")) {
                    bdStatsItem.append("net", cc.a(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    bdStatsItem.append("pid", Integer.valueOf(Process.myPid()));
                    if (BdStatisticsManager.getInstance().isMainProcess()) {
                        bdStatsItem.append("ismainproc", "1");
                    } else {
                        bdStatsItem.append("ismainproc", "0");
                    }
                }
                ed a2 = this.b.a();
                if (a2 != null) {
                    bdStatsItem.append("cold_session_id", Long.valueOf(a2.b()));
                    bdStatsItem.append("cold_session_index", Long.valueOf(a2.c()));
                    bdStatsItem.append("cold_session_pid", a2.a());
                }
                if (ec.e() && ec.d(j2)) {
                    bdStatsItem.generateTrackLogInfo(this.g);
                    j2.c(bdStatsItem);
                }
                if (nc.o().u(str, str2)) {
                    j2.a(bdStatsItem);
                } else {
                    j2.b(bdStatsItem);
                }
                gc.e(j2, bdStatsItem);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (Map.Entry<String, hc> entry : this.a.entrySet()) {
                hc value = entry.getValue();
                ac acVar = this.d;
                if (acVar != null) {
                    long logUploadTime = acVar.getLogUploadTime(value.o());
                    if (logUploadTime <= 0) {
                        logUploadTime = System.currentTimeMillis();
                        this.d.setLogUploadTime(value.o(), logUploadTime);
                    }
                    value.L(logUploadTime);
                }
                if (value != null) {
                    if (value.l() > 0) {
                        A(value, false);
                    }
                    if (value.v() > UploadTask.SIZE_LIMIT_DEFAULT) {
                        bd.b(value);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        bd.b(value);
                    }
                    if (value.m() > 0) {
                        v(value, false);
                    }
                    if (value.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                        xc.c(value, false, false, false);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        xc.c(value, false, false, false);
                    }
                }
            }
        }
    }

    public synchronized hc j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String g = hc.g(str);
                hc hcVar = this.a.get(g);
                if (hcVar == null) {
                    if ("alert".equals(g)) {
                        hcVar = new tc(null);
                    } else if ("error".equals(g)) {
                        hcVar = new wc(this.i);
                    } else if ("dbg".equals(g)) {
                        hcVar = new vc(this.i);
                    } else if ("stat".equals(g)) {
                        hcVar = new zc(this.i);
                    } else if ("pfmonitor".equals(g)) {
                        hcVar = new yc(this.i);
                    } else {
                        hcVar = new wc(this.i);
                    }
                    hcVar.I(g);
                    this.a.put(g, hcVar);
                }
                return hcVar;
            }
        }
        return (hc) invokeL.objValue;
    }

    public void l(bc bcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bcVar) == null) {
            if (this.f == null) {
                this.f = new f(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.f, intentFilter);
            }
            this.d = BdStatisticsManager.getInstance().getBdLogSetting();
            this.g = bcVar;
        }
    }

    public final boolean m(hc hcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, hcVar)) == null) {
            boolean z = false;
            if (hcVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - hcVar.i() >= 60000) {
                z = true;
            }
            if (nc.o().s(hcVar.o())) {
                z = true;
            }
            if (hcVar.m() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(hc hcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, hcVar)) == null) {
            boolean z = false;
            if (hcVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - hcVar.j() >= 60000) {
                z = true;
            }
            if (nc.o().s(hcVar.o())) {
                z = true;
            }
            if (hcVar.n() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            for (Map.Entry<String, hc> entry : this.a.entrySet()) {
                hc value = entry.getValue();
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

    public final boolean o(hc hcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, hcVar)) == null) {
            boolean z = false;
            if (hcVar == null || !ec.e() || !ec.d(hcVar)) {
                return false;
            }
            if (System.currentTimeMillis() - hcVar.k() >= 60000) {
                z = true;
            }
            if (nc.o().s(hcVar.o())) {
                z = true;
            }
            if (hcVar.l() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void x(hc hcVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, hcVar) == null) && hcVar != null && hcVar.n() != 0) {
            if (hcVar.u() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                c cVar = new c(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), hcVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), hcVar.r(), DiskFileOperate.Action.RENAME, hcVar);
                cVar.setSdCard(hcVar.E());
                cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                k7.g().a(cVar);
            }
            d dVar = new d(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), hcVar.s(), DiskFileOperate.Action.APPEND, hcVar);
            dVar.setSdCard(hcVar.E());
            dVar.b(hcVar.y().toString());
            hcVar.e();
            if (!hcVar.A()) {
                dVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.setTrySuccessWeight(3);
            }
            k7.g().a(dVar);
        }
    }

    public void y(hc hcVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{hcVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && hcVar != null && hcVar.u() > 0) {
            b bVar = new b(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), hcVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), hcVar.r(), DiskFileOperate.Action.RENAME, hcVar, z, z2);
            bVar.setSdCard(hcVar.E());
            bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            k7.g().a(bVar);
        }
    }
}
