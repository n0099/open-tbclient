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
public class di {
    public static /* synthetic */ Interceptable $ic;
    public static volatile di i;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, kh> a;
    public String b;
    public ch c;
    public fi d;
    public f e;
    public eh f;
    public Handler g;
    public gi h;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ di a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(di diVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {diVar, looper};
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
            this.a = diVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 6) {
                for (Map.Entry entry : this.a.a.entrySet()) {
                    kh khVar = (kh) entry.getValue();
                    if (khVar.u() > 0) {
                        this.a.y(khVar, true, true);
                    }
                    if (khVar.t() > 0) {
                        ai.c(khVar, true, true, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kh a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(di diVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, kh khVar, boolean z, boolean z2) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {diVar, str, str2, str3, str4, action, khVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
            this.a = khVar;
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
                    uh.m().r(this.a, this.b, true, this.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kh a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(di diVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, kh khVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {diVar, str, str2, str3, str4, action, khVar};
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
            this.a = khVar;
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
    public class d extends jc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kh c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(di diVar, String str, String str2, DiskFileOperate.Action action, kh khVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {diVar, str, str2, action, khVar};
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
            this.c = khVar;
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
    public class e implements gi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ di a;

        public e(di diVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {diVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = diVar;
        }

        @Override // com.baidu.tieba.gi
        public void a(kh khVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, khVar) == null) {
                if (this.a.o(khVar)) {
                    this.a.z(khVar);
                }
                if (this.a.m(khVar)) {
                    this.a.u(khVar);
                }
                if (this.a.n(khVar)) {
                    this.a.x(khVar);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ di this$0;

        public f(di diVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {diVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = diVar;
        }

        public /* synthetic */ f(di diVar, a aVar) {
            this(diVar);
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

    public di() {
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
            for (Map.Entry<String, kh> entry : this.a.entrySet()) {
                kh value = entry.getValue();
                z(value);
                u(value);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (Map.Entry<String, kh> entry : this.a.entrySet()) {
                kh value = entry.getValue();
                B(value);
                w(value);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (Map.Entry<String, kh> entry : this.a.entrySet()) {
                kh value = entry.getValue();
                B(value);
                y(value, false, false);
                w(value);
            }
        }
    }

    public void B(kh khVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, khVar) != null) || khVar == null) {
            return;
        }
        if (khVar.l() > 0) {
            A(khVar, true);
        } else if (khVar.v() > 0) {
            ei.b(khVar);
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
            kh j = i().j(str);
            B(j);
            y(j, false, true);
            w(j);
        }
    }

    public void u(kh khVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, khVar) == null) {
            v(khVar, false);
        }
    }

    public void w(kh khVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, khVar) != null) || khVar == null) {
            return;
        }
        if (khVar.m() > 0) {
            v(khVar, true);
        } else if (khVar.t() > 0) {
            ai.c(khVar, false, false, false);
        }
    }

    public void z(kh khVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, khVar) == null) {
            A(khVar, false);
        }
    }

    public final void A(kh khVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048576, this, khVar, z) != null) || khVar == null) {
            return;
        }
        if (ei.a(khVar) > UploadTask.SIZE_LIMIT_DEFAULT) {
            ei.b(khVar);
        }
        ei.c(khVar, z);
    }

    public final void v(kh khVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048596, this, khVar, z) != null) || khVar == null) {
            return;
        }
        if (ai.b(khVar) > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            ai.c(khVar, false, false, false);
        }
        ai.d(khVar, z);
    }

    public static di i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (i == null) {
                synchronized (di.class) {
                    if (i == null) {
                        i = new di();
                    }
                }
            }
            return i;
        }
        return (di) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.d == null) {
                this.d = new fi();
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

    public void D(String str, String str2, String str3, String str4, bh bhVar, Object... objArr) {
        kh j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, bhVar, objArr}) == null) {
            if (str == null && str2 == null) {
                return;
            }
            if ((bhVar != null || (objArr != null && objArr.length != 0)) && (j = j(str)) != null && rh.o().v(str, str2)) {
                if (bhVar == null) {
                    bhVar = new bh(str);
                }
                if (!str.equals("stat") && !str.equals("crash")) {
                    bhVar.c("module", str, "st", str2, "t", String.valueOf(System.currentTimeMillis()));
                }
                if (objArr != null && objArr.length > 0) {
                    bhVar.c(objArr);
                }
                if (this.b != null && !str.equals("stat")) {
                    bhVar.b("uid", this.b);
                }
                if (str3 != null && !str.equals("stat")) {
                    bhVar.b("c_logid", str3);
                }
                if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
                    bhVar.b(PushConstants.SEQ_ID, str4);
                }
                if (!str.equals("stat")) {
                    bhVar.b("net", fh.a(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    bhVar.c("pid", Integer.valueOf(Process.myPid()));
                    if (BdStatisticsManager.getInstance().isMainProcess()) {
                        bhVar.b("ismainproc", "1");
                    } else {
                        bhVar.b("ismainproc", "0");
                    }
                }
                if (hh.e() && hh.d(j)) {
                    bhVar.d(this.f);
                    j.c(bhVar);
                }
                if (rh.o().u(str, str2)) {
                    j.a(bhVar);
                } else {
                    j.b(bhVar);
                }
                jh.e(j, bhVar);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (Map.Entry<String, kh> entry : this.a.entrySet()) {
                kh value = entry.getValue();
                ch chVar = this.c;
                if (chVar != null) {
                    long logUploadTime = chVar.getLogUploadTime(value.o());
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
                    if (value.v() > UploadTask.SIZE_LIMIT_DEFAULT) {
                        ei.b(value);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        ei.b(value);
                    }
                    if (value.m() > 0) {
                        v(value, false);
                    }
                    if (value.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                        ai.c(value, false, false, false);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        ai.c(value, false, false, false);
                    }
                }
            }
        }
    }

    public synchronized kh j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String g = kh.g(str);
                kh khVar = this.a.get(g);
                if (khVar == null) {
                    if ("alert".equals(g)) {
                        khVar = new xh(null);
                    } else if ("error".equals(g)) {
                        khVar = new zh(this.h);
                    } else if ("dbg".equals(g)) {
                        khVar = new yh(this.h);
                    } else if ("stat".equals(g)) {
                        khVar = new ci(this.h);
                    } else if ("pfmonitor".equals(g)) {
                        khVar = new bi(this.h);
                    } else {
                        khVar = new zh(this.h);
                    }
                    khVar.I(g);
                    this.a.put(g, khVar);
                }
                return khVar;
            }
        }
        return (kh) invokeL.objValue;
    }

    public void l(eh ehVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ehVar) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.e, intentFilter);
            }
            this.c = BdStatisticsManager.getInstance().getBdLogSetting();
            this.f = ehVar;
        }
    }

    public final boolean m(kh khVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, khVar)) == null) {
            boolean z = false;
            if (khVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - khVar.i() >= 60000) {
                z = true;
            }
            if (rh.o().s(khVar.o())) {
                z = true;
            }
            if (khVar.m() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(kh khVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, khVar)) == null) {
            boolean z = false;
            if (khVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - khVar.j() >= 60000) {
                z = true;
            }
            if (rh.o().s(khVar.o())) {
                z = true;
            }
            if (khVar.n() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            for (Map.Entry<String, kh> entry : this.a.entrySet()) {
                kh value = entry.getValue();
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

    public final boolean o(kh khVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, khVar)) == null) {
            boolean z = false;
            if (khVar == null || !hh.e() || !hh.d(khVar)) {
                return false;
            }
            if (System.currentTimeMillis() - khVar.k() >= 60000) {
                z = true;
            }
            if (rh.o().s(khVar.o())) {
                z = true;
            }
            if (khVar.l() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void x(kh khVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, khVar) == null) && khVar != null && khVar.n() != 0) {
            if (khVar.u() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                c cVar = new c(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), khVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), khVar.r(), DiskFileOperate.Action.RENAME, khVar);
                cVar.setSdCard(khVar.E());
                cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                ec.f().a(cVar);
            }
            d dVar = new d(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), khVar.s(), DiskFileOperate.Action.APPEND, khVar);
            dVar.setSdCard(khVar.E());
            dVar.b(khVar.y().toString());
            khVar.e();
            if (!khVar.A()) {
                dVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.setTrySuccessWeight(3);
            }
            ec.f().a(dVar);
        }
    }

    public void y(kh khVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{khVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && khVar != null && khVar.u() > 0) {
            b bVar = new b(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), khVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), khVar.r(), DiskFileOperate.Action.RENAME, khVar, z, z2);
            bVar.setSdCard(khVar.E());
            bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            ec.f().a(bVar);
        }
    }
}
