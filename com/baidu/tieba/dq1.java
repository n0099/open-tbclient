package com.baidu.tieba;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.tieba.np1;
import com.baidu.tieba.qq1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dq1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dq1 g;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Integer, zp1> a;
    public final ArrayList<np1.a> b;
    public com.baidu.sso.j.d c;
    public Context d;
    public boolean e;
    public int f;

    /* loaded from: classes5.dex */
    public class a implements vp1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq1 a;

        public a(dq1 dq1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dq1Var;
        }

        @Override // com.baidu.tieba.vp1
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                op1.g(this.a.d).B(System.currentTimeMillis());
            }
        }

        @Override // com.baidu.tieba.vp1
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return op1.g(this.a.d).b();
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements np1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zp1 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;
        public final /* synthetic */ np1.a e;

        public b(dq1 dq1Var, zp1 zp1Var, Context context, int i, long j, np1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq1Var, zp1Var, context, Integer.valueOf(i), Long.valueOf(j), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zp1Var;
            this.b = context;
            this.c = i;
            this.d = j;
            this.e = aVar;
        }

        @Override // com.baidu.tieba.np1.a
        public void onFinish(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    if (new JSONObject(str).optInt("0", -1) == 0) {
                        this.a.j(this.b, this.c, this.d);
                        return;
                    }
                    if (this.e != null) {
                        this.e.onFinish(str);
                    }
                    tp1.j().c(false);
                } catch (Throwable unused) {
                    np1.a aVar = this.e;
                    if (aVar != null) {
                        aVar.onFinish(str);
                    }
                    tp1.j().c(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements np1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zp1 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;
        public final /* synthetic */ np1.a e;

        public c(dq1 dq1Var, zp1 zp1Var, Context context, int i, long j, np1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq1Var, zp1Var, context, Integer.valueOf(i), Long.valueOf(j), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zp1Var;
            this.b = context;
            this.c = i;
            this.d = j;
            this.e = aVar;
        }

        @Override // com.baidu.tieba.np1.a
        public void onFinish(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    if (new JSONObject(str).optInt("0", -1) == 0) {
                        this.a.p(this.b, this.c, this.d);
                        return;
                    }
                    if (this.e != null) {
                        this.e.onFinish(str);
                    }
                    tp1.j().n(false);
                } catch (Throwable unused) {
                    np1.a aVar = this.e;
                    if (aVar != null) {
                        aVar.onFinish(str);
                    }
                    tp1.j().n(false);
                }
            }
        }
    }

    public dq1() {
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
        this.a = new HashMap();
        this.b = new ArrayList<>();
        this.f = -1;
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            try {
                if (this.c != null) {
                    context.unregisterReceiver(this.c);
                }
                this.c = null;
            } catch (Throwable th) {
                er1.d(th);
            }
        }
    }

    public static dq1 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (g == null) {
                synchronized (dq1.class) {
                    if (g == null) {
                        g = new dq1();
                    }
                }
            }
            return g;
        }
        return (dq1) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public final int b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            if (this.a.size() == 1) {
                return Integer.valueOf(this.a.get(this.a.keySet().iterator().next()).c).intValue();
            }
            if (this.a.size() == 2 && i2 < 4 && i2 > 0) {
                return i2;
            }
            return i;
        }
        return invokeII.intValue;
    }

    public synchronized void d(int i, int i2, int i3, int i4, String str, cq1 cq1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, cq1Var, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (cq1Var == null) {
                    return;
                }
                Pair<Boolean, np1.a> b2 = tp1.j().b(i);
                if (!((Boolean) b2.first).booleanValue()) {
                    return;
                }
                fq1.a().b(i);
                i((np1.a) b2.second, new yp1(i2, i3, i4, str), cq1Var.a, z);
                if (i2 == 1) {
                    cq1Var.b = 1;
                }
                if (z) {
                    int i5 = cq1Var.a;
                    if (i5 == 1) {
                        uq1.b(this.d, i4, cq1Var.b, i3, str);
                    } else if (i5 == 3) {
                        uq1.f(this.d, i4, cq1Var.b, i3, str);
                    } else if (i5 == 2) {
                        if (i2 == 3 && i3 == 2019) {
                            op1.g(this.d).G(System.currentTimeMillis());
                            op1.g(this.d).i(i3);
                        }
                        uq1.a(this.d, i4, i2, i3, cq1Var.c, cq1Var.d);
                    } else {
                        if (i2 == 3 && i3 == 2019) {
                            op1.g(this.d).P(System.currentTimeMillis());
                            op1.g(this.d).r(i3);
                        }
                        uq1.e(this.d, i4, i2, i3, cq1Var.c, cq1Var.d);
                    }
                }
            }
        }
    }

    public synchronized void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            synchronized (this) {
                try {
                    if (this.e) {
                        return;
                    }
                    this.d = context.getApplicationContext();
                    if (!qq1.a.d()) {
                        or1.b().a(this.d, null);
                    }
                    boolean z = false;
                    if (!qp1.a(this.d).e(true) && er1.h(this.d) == 0) {
                        z = true;
                    }
                    h(this.d, z);
                    er1.j(this.d);
                    up1.c().b(new a(this));
                    this.a.put(1, new wp1(this.d));
                    this.a.put(3, new gq1(this.d));
                    this.a.put(2, new iq1(this.d));
                    this.e = true;
                }
            }
        }
    }

    public synchronized void f(Context context, int i, Pair<Integer, Integer> pair, long j, np1.a aVar) {
        Pair<Integer, Integer> pair2;
        int intValue;
        int intValue2;
        int intValue3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Integer.valueOf(i), pair, Long.valueOf(j), aVar}) == null) {
            synchronized (this) {
                int i2 = -1;
                if (tp1.j().d()) {
                    this.b.add(aVar);
                    return;
                }
                this.b.clear();
                int a2 = tp1.j().a(aVar);
                try {
                    Message message = new Message();
                    message.what = a2;
                    message.arg1 = -1;
                    message.arg2 = 1;
                    this.f = -1;
                    fq1.a().c(message, j);
                    if (pair == null) {
                        pair2 = nr1.c(context);
                    } else {
                        pair2 = pair;
                    }
                    intValue = ((Integer) pair2.first).intValue();
                    intValue2 = ((Integer) pair2.second).intValue();
                    intValue3 = ((Integer) pair2.second).intValue();
                } catch (Throwable unused) {
                    i2 = a2;
                    cq1 cq1Var = new cq1();
                    cq1Var.a = 1;
                    d(i2, 3, 2009, -1, "auth login unknown error.", cq1Var, true);
                }
                if (!j(a2, intValue2, intValue, 1)) {
                    return;
                }
                int b2 = b(intValue2, i);
                this.f = b2;
                tp1.j().i(false, true);
                if (b2 != 1 && b2 != 2 && b2 != 3) {
                    cq1 cq1Var2 = new cq1();
                    cq1Var2.a = 1;
                    d(a2, 3, 2004, b2, "has no op.", cq1Var2, true);
                    return;
                }
                zp1 zp1Var = this.a.get(Integer.valueOf(b2));
                if (zp1Var == null) {
                    cq1 cq1Var3 = new cq1();
                    cq1Var3.a = 1;
                    d(a2, 3, 2002, b2, "not support current operator", cq1Var3, true);
                } else {
                    zp1Var.m(intValue3);
                    zp1Var.i(context, intValue, a2);
                    uq1.d(context, intValue3, 1, zp1.q);
                }
            }
        }
    }

    public void k(Context context, int i, Pair<Integer, Integer> pair, long j, np1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i), pair, Long.valueOf(j), aVar}) == null) {
            int a2 = tp1.j().a(aVar);
            try {
                Message message = new Message();
                message.what = a2;
                message.arg1 = -1;
                message.arg2 = 3;
                this.f = -1;
                fq1.a().c(message, j);
                if (pair == null) {
                    pair = nr1.c(context);
                }
                int intValue = ((Integer) pair.first).intValue();
                int intValue2 = ((Integer) pair.second).intValue();
                int intValue3 = ((Integer) pair.second).intValue();
                if (!j(a2, intValue2, intValue, 3)) {
                    return;
                }
                int b2 = b(intValue2, i);
                this.f = b2;
                if (!tp1.j().m(false, true)) {
                    cq1 cq1Var = new cq1();
                    cq1Var.a = 3;
                    d(a2, 3, 998, b2, "is doing auth prelogin.", cq1Var, false);
                } else if (b2 != 1 && b2 != 2 && b2 != 3) {
                    cq1 cq1Var2 = new cq1();
                    cq1Var2.a = 3;
                    d(a2, 3, 2004, b2, "has no op.", cq1Var2, true);
                } else {
                    zp1 zp1Var = this.a.get(Integer.valueOf(b2));
                    if (zp1Var == null) {
                        cq1 cq1Var3 = new cq1();
                        cq1Var3.a = 3;
                        d(a2, 3, 2002, b2, "not support current operator", cq1Var3, true);
                        return;
                    }
                    zp1Var.m(intValue3);
                    zp1Var.h(context, a2);
                    uq1.d(context, intValue3, 3, zp1.r);
                }
            } catch (Throwable unused) {
                cq1 cq1Var4 = new cq1();
                cq1Var4.a = 3;
                d(a2, 3, 2009, -1, "auth login unknown error.", cq1Var4, true);
            }
        }
    }

    public void g(Context context, long j, np1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j), aVar}) == null) {
            int a2 = tp1.j().a(aVar);
            Pair<Integer, Integer> c2 = nr1.c(context);
            int intValue = ((Integer) c2.first).intValue();
            int intValue2 = ((Integer) c2.second).intValue();
            if (!j(a2, intValue2, intValue, 2)) {
                return;
            }
            if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                cq1 cq1Var = new cq1();
                cq1Var.a = 2;
                d(a2, 3, 2004, intValue2, "has no op.", cq1Var, true);
                return;
            }
            zp1 zp1Var = this.a.get(Integer.valueOf(intValue2));
            if (zp1Var == null) {
                cq1 cq1Var2 = new cq1();
                cq1Var2.a = 2;
                d(a2, 3, 2002, intValue2, "not support current operator", cq1Var2, true);
            } else if (!tp1.j().e(false, true)) {
                cq1 cq1Var3 = new cq1();
                cq1Var3.a = 2;
                d(a2, 3, 998, intValue2, "is doing auth login.", cq1Var3, false);
            } else {
                uq1.d(context, intValue2, 2, zp1.q);
                if (!zp1Var.l()) {
                    zp1Var.j(context, a2, j);
                } else if (tp1.j().d()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (tp1.j().d()) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                            try {
                                Thread.sleep(100L);
                                if (!zp1Var.l()) {
                                    zp1Var.j(context, a2, j);
                                    return;
                                }
                            } catch (Throwable th) {
                                er1.d(th);
                                cq1 cq1Var4 = new cq1();
                                cq1Var4.a = 2;
                                d(a2, 3, IMConstants.IM_MSG_TYPE_ADVISORY_DISCLAIMER, intValue2, "auth out time", cq1Var4, true);
                                return;
                            }
                        } else {
                            cq1 cq1Var5 = new cq1();
                            cq1Var5.a = 2;
                            d(a2, 3, IMConstants.IM_MSG_TYPE_ADVISORY_DISCLAIMER, intValue2, "auth out time", cq1Var5, true);
                            return;
                        }
                    }
                } else {
                    f(context, 0, c2, j, new b(this, zp1Var, context, a2, j, aVar));
                }
            }
        }
    }

    public void l(Context context, long j, np1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, Long.valueOf(j), aVar}) == null) {
            int a2 = tp1.j().a(aVar);
            Pair<Integer, Integer> c2 = nr1.c(context);
            int intValue = ((Integer) c2.first).intValue();
            int intValue2 = ((Integer) c2.second).intValue();
            if (!j(a2, intValue2, intValue, 4)) {
                return;
            }
            if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                cq1 cq1Var = new cq1();
                cq1Var.a = 4;
                d(a2, 3, 2004, intValue2, "has no op.", cq1Var, true);
                return;
            }
            zp1 zp1Var = this.a.get(Integer.valueOf(intValue2));
            if (zp1Var == null) {
                cq1 cq1Var2 = new cq1();
                cq1Var2.a = 4;
                d(a2, 3, 2002, intValue2, "not support current operator", cq1Var2, true);
            } else if (!tp1.j().o(false, true)) {
                cq1 cq1Var3 = new cq1();
                cq1Var3.a = 4;
                d(a2, 3, 998, intValue2, "is doing auth verify.", cq1Var3, false);
            } else {
                uq1.d(context, intValue2, 4, zp1.r);
                if (!zp1Var.q()) {
                    zp1Var.p(context, a2, j);
                } else if (tp1.j().g()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (tp1.j().g()) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                            try {
                                Thread.sleep(100L);
                                if (!zp1Var.q()) {
                                    zp1Var.p(context, a2, j);
                                    return;
                                }
                            } catch (Throwable th) {
                                er1.d(th);
                                cq1 cq1Var4 = new cq1();
                                cq1Var4.a = 4;
                                d(a2, 3, IMConstants.IM_MSG_TYPE_ADVISORY_DISCLAIMER, intValue2, "auth out time", cq1Var4, true);
                                return;
                            }
                        } else {
                            cq1 cq1Var5 = new cq1();
                            cq1Var5.a = 4;
                            d(a2, 3, IMConstants.IM_MSG_TYPE_ADVISORY_DISCLAIMER, intValue2, "auth out time", cq1Var5, true);
                            return;
                        }
                    }
                } else {
                    k(context, 0, c2, j, new c(this, zp1Var, context, a2, j, aVar));
                }
            }
        }
    }

    public synchronized void h(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, context, z) == null) {
            synchronized (this) {
                try {
                    n(context);
                    this.c = new com.baidu.sso.j.d();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("sso_action_t_m");
                    if (z) {
                        intentFilter.addAction(NetworkMonitor.NET_CHANGE_ACTION);
                    }
                    context.registerReceiver(this.c, intentFilter);
                } catch (Throwable th) {
                    er1.d(th);
                }
            }
        }
    }

    public final synchronized void i(np1.a aVar, yp1 yp1Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{aVar, yp1Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (i == 1) {
                    this.b.clear();
                    bq1.b(aVar, yp1Var, i, (ArrayList) this.b.clone(), z);
                } else {
                    bq1.b(aVar, yp1Var, i, null, z);
                }
            }
        }
    }

    public final boolean j(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4)) == null) {
            cq1 cq1Var = new cq1();
            cq1Var.a = i4;
            if (!this.e) {
                d(i, 3, 2001, i2, "has no init.", cq1Var, false);
                return false;
            } else if (TextUtils.isEmpty(np1.b) && TextUtils.isEmpty(np1.c)) {
                d(i, 3, 2007, i2, "has no key.", cq1Var, false);
                return false;
            } else if (this.a.isEmpty()) {
                d(i, 3, 2002, i2, "has no sdk.", cq1Var, false);
                return false;
            } else if (i3 == 0) {
                d(i, 3, 2003, i2, "has no net.", cq1Var, false);
                return false;
            } else {
                return true;
            }
        }
        return invokeIIII.booleanValue;
    }
}
