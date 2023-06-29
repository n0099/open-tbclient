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
public class fi {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fi i;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, mh> a;
    public String b;
    public eh c;
    public hi d;
    public f e;
    public gh f;
    public Handler g;
    public ii h;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fi fiVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fiVar, looper};
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
            this.a = fiVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 6) {
                for (Map.Entry entry : this.a.a.entrySet()) {
                    mh mhVar = (mh) entry.getValue();
                    if (mhVar.u() > 0) {
                        this.a.y(mhVar, true, true);
                    }
                    if (mhVar.t() > 0) {
                        ci.c(mhVar, true, true, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(fi fiVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, mh mhVar, boolean z, boolean z2) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {fiVar, str, str2, str3, str4, action, mhVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
            this.a = mhVar;
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
                    wh.m().r(this.a, this.b, true, this.c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(fi fiVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, mh mhVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {fiVar, str, str2, str3, str4, action, mhVar};
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
            this.a = mhVar;
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
    public class d extends kc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(fi fiVar, String str, String str2, DiskFileOperate.Action action, mh mhVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fiVar, str, str2, action, mhVar};
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
            this.c = mhVar;
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
    public class e implements ii {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi a;

        public e(fi fiVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fiVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fiVar;
        }

        @Override // com.baidu.tieba.ii
        public void a(mh mhVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mhVar) == null) {
                if (this.a.o(mhVar)) {
                    this.a.z(mhVar);
                }
                if (this.a.m(mhVar)) {
                    this.a.u(mhVar);
                }
                if (this.a.n(mhVar)) {
                    this.a.x(mhVar);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi this$0;

        public f(fi fiVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fiVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = fiVar;
        }

        public /* synthetic */ f(fi fiVar, a aVar) {
            this(fiVar);
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

    public fi() {
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
            for (Map.Entry<String, mh> entry : this.a.entrySet()) {
                mh value = entry.getValue();
                z(value);
                u(value);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (Map.Entry<String, mh> entry : this.a.entrySet()) {
                mh value = entry.getValue();
                B(value);
                w(value);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (Map.Entry<String, mh> entry : this.a.entrySet()) {
                mh value = entry.getValue();
                B(value);
                y(value, false, false);
                w(value);
            }
        }
    }

    public void B(mh mhVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mhVar) != null) || mhVar == null) {
            return;
        }
        if (mhVar.l() > 0) {
            A(mhVar, true);
        } else if (mhVar.v() > 0) {
            gi.b(mhVar);
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
            mh j = i().j(str);
            B(j);
            y(j, false, true);
            w(j);
        }
    }

    public void u(mh mhVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, mhVar) == null) {
            v(mhVar, false);
        }
    }

    public void w(mh mhVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, mhVar) != null) || mhVar == null) {
            return;
        }
        if (mhVar.m() > 0) {
            v(mhVar, true);
        } else if (mhVar.t() > 0) {
            ci.c(mhVar, false, false, false);
        }
    }

    public void z(mh mhVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, mhVar) == null) {
            A(mhVar, false);
        }
    }

    public final void A(mh mhVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048576, this, mhVar, z) != null) || mhVar == null) {
            return;
        }
        if (gi.a(mhVar) > UploadTask.SIZE_LIMIT_DEFAULT) {
            gi.b(mhVar);
        }
        gi.c(mhVar, z);
    }

    public final void v(mh mhVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048596, this, mhVar, z) != null) || mhVar == null) {
            return;
        }
        if (ci.b(mhVar) > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            ci.c(mhVar, false, false, false);
        }
        ci.d(mhVar, z);
    }

    public static fi i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (i == null) {
                synchronized (fi.class) {
                    if (i == null) {
                        i = new fi();
                    }
                }
            }
            return i;
        }
        return (fi) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.d == null) {
                this.d = new hi();
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

    public void D(String str, String str2, String str3, String str4, dh dhVar, Object... objArr) {
        mh j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, dhVar, objArr}) == null) {
            if (str == null && str2 == null) {
                return;
            }
            if ((dhVar != null || (objArr != null && objArr.length != 0)) && (j = j(str)) != null && th.o().v(str, str2)) {
                if (dhVar == null) {
                    dhVar = new dh(str);
                }
                if (!str.equals("stat") && !str.equals("crash")) {
                    dhVar.c("module", str, "st", str2, "t", String.valueOf(System.currentTimeMillis()));
                }
                if (objArr != null && objArr.length > 0) {
                    dhVar.c(objArr);
                }
                if (this.b != null && !str.equals("stat")) {
                    dhVar.b("uid", this.b);
                }
                if (str3 != null && !str.equals("stat")) {
                    dhVar.b("c_logid", str3);
                }
                if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
                    dhVar.b(PushConstants.SEQ_ID, str4);
                }
                if (!str.equals("stat")) {
                    dhVar.b("net", hh.a(BdBaseApplication.getInst()));
                }
                if (!str.equals("stat") && !str.equals("pfmonitor")) {
                    dhVar.c("pid", Integer.valueOf(Process.myPid()));
                    if (BdStatisticsManager.getInstance().isMainProcess()) {
                        dhVar.b("ismainproc", "1");
                    } else {
                        dhVar.b("ismainproc", "0");
                    }
                }
                if (jh.e() && jh.d(j)) {
                    dhVar.d(this.f);
                    j.c(dhVar);
                }
                if (th.o().u(str, str2)) {
                    j.a(dhVar);
                } else {
                    j.b(dhVar);
                }
                lh.e(j, dhVar);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (Map.Entry<String, mh> entry : this.a.entrySet()) {
                mh value = entry.getValue();
                eh ehVar = this.c;
                if (ehVar != null) {
                    long logUploadTime = ehVar.getLogUploadTime(value.o());
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
                        gi.b(value);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        gi.b(value);
                    }
                    if (value.m() > 0) {
                        v(value, false);
                    }
                    if (value.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                        ci.c(value, false, false, false);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        ci.c(value, false, false, false);
                    }
                }
            }
        }
    }

    public synchronized mh j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String g = mh.g(str);
                mh mhVar = this.a.get(g);
                if (mhVar == null) {
                    if ("alert".equals(g)) {
                        mhVar = new zh(null);
                    } else if ("error".equals(g)) {
                        mhVar = new bi(this.h);
                    } else if ("dbg".equals(g)) {
                        mhVar = new ai(this.h);
                    } else if ("stat".equals(g)) {
                        mhVar = new ei(this.h);
                    } else if ("pfmonitor".equals(g)) {
                        mhVar = new di(this.h);
                    } else {
                        mhVar = new bi(this.h);
                    }
                    mhVar.I(g);
                    this.a.put(g, mhVar);
                }
                return mhVar;
            }
        }
        return (mh) invokeL.objValue;
    }

    public void l(gh ghVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ghVar) == null) {
            if (this.e == null) {
                this.e = new f(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.e, intentFilter);
            }
            this.c = BdStatisticsManager.getInstance().getBdLogSetting();
            this.f = ghVar;
        }
    }

    public final boolean m(mh mhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, mhVar)) == null) {
            boolean z = false;
            if (mhVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - mhVar.i() >= 60000) {
                z = true;
            }
            if (th.o().s(mhVar.o())) {
                z = true;
            }
            if (mhVar.m() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(mh mhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, mhVar)) == null) {
            boolean z = false;
            if (mhVar == null) {
                return false;
            }
            if (System.currentTimeMillis() - mhVar.j() >= 60000) {
                z = true;
            }
            if (th.o().s(mhVar.o())) {
                z = true;
            }
            if (mhVar.n() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            for (Map.Entry<String, mh> entry : this.a.entrySet()) {
                mh value = entry.getValue();
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

    public final boolean o(mh mhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, mhVar)) == null) {
            boolean z = false;
            if (mhVar == null || !jh.e() || !jh.d(mhVar)) {
                return false;
            }
            if (System.currentTimeMillis() - mhVar.k() >= 60000) {
                z = true;
            }
            if (th.o().s(mhVar.o())) {
                z = true;
            }
            if (mhVar.l() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void x(mh mhVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, mhVar) == null) && mhVar != null && mhVar.n() != 0) {
            if (mhVar.u() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                c cVar = new c(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), mhVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), mhVar.r(), DiskFileOperate.Action.RENAME, mhVar);
                cVar.setSdCard(mhVar.E());
                cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                fc.f().a(cVar);
            }
            d dVar = new d(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), mhVar.s(), DiskFileOperate.Action.APPEND, mhVar);
            dVar.setSdCard(mhVar.E());
            dVar.b(mhVar.y().toString());
            mhVar.e();
            if (!mhVar.A()) {
                dVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.setTrySuccessWeight(3);
            }
            fc.f().a(dVar);
        }
    }

    public void y(mh mhVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{mhVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && mhVar != null && mhVar.u() > 0) {
            b bVar = new b(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), mhVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), mhVar.r(), DiskFileOperate.Action.RENAME, mhVar, z, z2);
            bVar.setSdCard(mhVar.E());
            bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            fc.f().a(bVar);
        }
    }
}
