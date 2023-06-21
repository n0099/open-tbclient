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
public class ei {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ei i;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, lh> a;
    public String b;
    public dh c;
    public gi d;
    public f e;
    public fh f;
    public Handler g;
    public hi h;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ei a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ei eiVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eiVar, looper};
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
            this.a = eiVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 6) {
                for (Map.Entry entry : this.a.a.entrySet()) {
                    lh lhVar = (lh) entry.getValue();
                    if (lhVar.u() > 0) {
                        this.a.y(lhVar, true, true);
                    }
                    if (lhVar.t() > 0) {
                        bi.c(lhVar, true, true, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ei eiVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, lh lhVar, boolean z, boolean z2) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {eiVar, str, str2, str3, str4, action, lhVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
            this.a = lhVar;
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
                    vh.m().r(this.a, this.b, true, this.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ei eiVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, lh lhVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {eiVar, str, str2, str3, str4, action, lhVar};
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
            this.a = lhVar;
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
        public final /* synthetic */ lh c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ei eiVar, String str, String str2, DiskFileOperate.Action action, lh lhVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eiVar, str, str2, action, lhVar};
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
            this.c = lhVar;
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
    public class e implements hi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ei a;

        public e(ei eiVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eiVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eiVar;
        }

        @Override // com.baidu.tieba.hi
        public void a(lh lhVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lhVar) == null) {
                if (this.a.o(lhVar)) {
                    this.a.z(lhVar);
                }
                if (this.a.m(lhVar)) {
                    this.a.u(lhVar);
                }
                if (this.a.n(lhVar)) {
                    this.a.x(lhVar);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ei this$0;

        public f(ei eiVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eiVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = eiVar;
        }

        public /* synthetic */ f(ei eiVar, a aVar) {
            this(eiVar);
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

    public ei() {
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
            for (Map.Entry<String, lh> entry : this.a.entrySet()) {
                lh value = entry.getValue();
                z(value);
                u(value);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (Map.Entry<String, lh> entry : this.a.entrySet()) {
                lh value = entry.getValue();
                B(value);
                w(value);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (Map.Entry<String, lh> entry : this.a.entrySet()) {
                lh value = entry.getValue();
                B(value);
                y(value, false, false);
                w(value);
            }
        }
    }

    public void B(lh lhVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lhVar) != null) || lhVar == null) {
            return;
        }
        if (lhVar.l() > 0) {
            A(lhVar, true);
        } else if (lhVar.v() > 0) {
            fi.b(lhVar);
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
            lh j = i().j(str);
            B(j);
            y(j, false, true);
            w(j);
        }
    }

    public void u(lh lhVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, lhVar) == null) {
            v(lhVar, false);
        }
    }

    public void w(lh lhVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, lhVar) != null) || lhVar == null) {
            return;
        }
        if (lhVar.m() > 0) {
            v(lhVar, true);
        } else if (lhVar.t() > 0) {
            bi.c(lhVar, false, false, false);
        }
    }

    public void z(lh lhVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, lhVar) == null) {
            A(lhVar, false);
        }
    }

    public final void A(lh lhVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048576, this, lhVar, z) != null) || lhVar == null) {
            return;
        }
        if (fi.a(lhVar) > UploadTask.SIZE_LIMIT_DEFAULT) {
            fi.b(lhVar);
        }
        fi.c(lhVar, z);
    }

    public final void v(lh lhVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048596, this, lhVar, z) != null) || lhVar == null) {
            return;
        }
        if (bi.b(lhVar) > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            bi.c(lhVar, false, false, false);
        }
        bi.d(lhVar, z);
    }

    public static ei i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (i == null) {
                synchronized (ei.class) {
                    if (i == null) {
                        i = new ei();
                    }
                }
            }
            return i;
        }
        return (ei) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.d == null) {
                this.d = new gi();
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

    public void D(String str, String str2, String str3, String str4, ch chVar, Object... objArr) {
        lh j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, chVar, objArr}) == null) {
            if (str == null && str2 == null) {
                return;
            }
            if ((chVar != null || (objArr != null && objArr.length != 0)) && (j = j(str)) != null && sh.o().v(str, str2)) {
                if (chVar == null) {
                    chVar = new ch(str);
                }
                if (!str.equals("stat") && !str.equals("crash")) {
                    chVar.c("module", str, "st", str2, "t", String.valueOf(System.currentTimeMillis()));
                }
                if (objArr != null && objArr.length > 0) {
                    chVar.c(objArr);
                }
                if (this.b != null && !str.equals("stat")) {
                    chVar.b("uid", this.b);
                }
                if (str3 != null && !str.equals("stat")) {
                    chVar.b("c_logid", str3);
                }
                if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
                    chVar.b(PushConstants.SEQ_ID, str4);
                }
                if (!str.equals("stat")) {
                    chVar.b("net", gh.a(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    chVar.c("pid", Integer.valueOf(Process.myPid()));
                    if (BdStatisticsManager.getInstance().isMainProcess()) {
                        chVar.b("ismainproc", "1");
                    } else {
                        chVar.b("ismainproc", "0");
                    }
                }
                if (ih.e() && ih.d(j)) {
                    chVar.d(this.f);
                    j.c(chVar);
                }
                if (sh.o().u(str, str2)) {
                    j.a(chVar);
                } else {
                    j.b(chVar);
                }
                kh.e(j, chVar);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (Map.Entry<String, lh> entry : this.a.entrySet()) {
                lh value = entry.getValue();
                dh dhVar = this.c;
                if (dhVar != null) {
                    long logUploadTime = dhVar.getLogUploadTime(value.o());
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
                        fi.b(value);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        fi.b(value);
                    }
                    if (value.m() > 0) {
                        v(value, false);
                    }
                    if (value.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                        bi.c(value, false, false, false);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        bi.c(value, false, false, false);
                    }
                }
            }
        }
    }

    public synchronized lh j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String g = lh.g(str);
                lh lhVar = this.a.get(g);
                if (lhVar == null) {
                    if ("alert".equals(g)) {
                        lhVar = new yh(null);
                    } else if ("error".equals(g)) {
                        lhVar = new ai(this.h);
                    } else if ("dbg".equals(g)) {
                        lhVar = new zh(this.h);
                    } else if ("stat".equals(g)) {
                        lhVar = new di(this.h);
                    } else if ("pfmonitor".equals(g)) {
                        lhVar = new ci(this.h);
                    } else {
                        lhVar = new ai(this.h);
                    }
                    lhVar.I(g);
                    this.a.put(g, lhVar);
                }
                return lhVar;
            }
        }
        return (lh) invokeL.objValue;
    }

    public void l(fh fhVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fhVar) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.e, intentFilter);
            }
            this.c = BdStatisticsManager.getInstance().getBdLogSetting();
            this.f = fhVar;
        }
    }

    public final boolean m(lh lhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, lhVar)) == null) {
            boolean z = false;
            if (lhVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - lhVar.i() >= 60000) {
                z = true;
            }
            if (sh.o().s(lhVar.o())) {
                z = true;
            }
            if (lhVar.m() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(lh lhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, lhVar)) == null) {
            boolean z = false;
            if (lhVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - lhVar.j() >= 60000) {
                z = true;
            }
            if (sh.o().s(lhVar.o())) {
                z = true;
            }
            if (lhVar.n() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            for (Map.Entry<String, lh> entry : this.a.entrySet()) {
                lh value = entry.getValue();
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

    public final boolean o(lh lhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, lhVar)) == null) {
            boolean z = false;
            if (lhVar == null || !ih.e() || !ih.d(lhVar)) {
                return false;
            }
            if (System.currentTimeMillis() - lhVar.k() >= 60000) {
                z = true;
            }
            if (sh.o().s(lhVar.o())) {
                z = true;
            }
            if (lhVar.l() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void x(lh lhVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, lhVar) == null) && lhVar != null && lhVar.n() != 0) {
            if (lhVar.u() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                c cVar = new c(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), lhVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), lhVar.r(), DiskFileOperate.Action.RENAME, lhVar);
                cVar.setSdCard(lhVar.E());
                cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                ec.f().a(cVar);
            }
            d dVar = new d(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), lhVar.s(), DiskFileOperate.Action.APPEND, lhVar);
            dVar.setSdCard(lhVar.E());
            dVar.b(lhVar.y().toString());
            lhVar.e();
            if (!lhVar.A()) {
                dVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.setTrySuccessWeight(3);
            }
            ec.f().a(dVar);
        }
    }

    public void y(lh lhVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{lhVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && lhVar != null && lhVar.u() > 0) {
            b bVar = new b(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), lhVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), lhVar.r(), DiskFileOperate.Action.RENAME, lhVar, z, z2);
            bVar.setSdCard(lhVar.E());
            bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            ec.f().a(bVar);
        }
    }
}
