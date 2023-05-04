package com.baidu.tieba;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pl1;
import com.baidu.tieba.sm1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class fm1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fm1 g;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Integer, bm1> a;
    public final ArrayList<pl1.a> b;
    public com.baidu.sso.j.d c;
    public Context d;
    public boolean e;
    public int f;

    /* loaded from: classes4.dex */
    public class a implements xl1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm1 a;

        public a(fm1 fm1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fm1Var;
        }

        @Override // com.baidu.tieba.xl1
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ql1.g(this.a.d).B(System.currentTimeMillis());
            }
        }

        @Override // com.baidu.tieba.xl1
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return ql1.g(this.a.d).b();
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements pl1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm1 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;
        public final /* synthetic */ pl1.a e;

        public b(fm1 fm1Var, bm1 bm1Var, Context context, int i, long j, pl1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm1Var, bm1Var, context, Integer.valueOf(i), Long.valueOf(j), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bm1Var;
            this.b = context;
            this.c = i;
            this.d = j;
            this.e = aVar;
        }

        @Override // com.baidu.tieba.pl1.a
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
                    vl1.j().c(false);
                } catch (Throwable unused) {
                    pl1.a aVar = this.e;
                    if (aVar != null) {
                        aVar.onFinish(str);
                    }
                    vl1.j().c(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements pl1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm1 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;
        public final /* synthetic */ pl1.a e;

        public c(fm1 fm1Var, bm1 bm1Var, Context context, int i, long j, pl1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm1Var, bm1Var, context, Integer.valueOf(i), Long.valueOf(j), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bm1Var;
            this.b = context;
            this.c = i;
            this.d = j;
            this.e = aVar;
        }

        @Override // com.baidu.tieba.pl1.a
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
                    vl1.j().n(false);
                } catch (Throwable unused) {
                    pl1.a aVar = this.e;
                    if (aVar != null) {
                        aVar.onFinish(str);
                    }
                    vl1.j().n(false);
                }
            }
        }
    }

    public fm1() {
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
                gn1.d(th);
            }
        }
    }

    public static fm1 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (g == null) {
                synchronized (fm1.class) {
                    if (g == null) {
                        g = new fm1();
                    }
                }
            }
            return g;
        }
        return (fm1) invokeV.objValue;
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

    public synchronized void d(int i, int i2, int i3, int i4, String str, em1 em1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, em1Var, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (em1Var == null) {
                    return;
                }
                Pair<Boolean, pl1.a> b2 = vl1.j().b(i);
                if (!((Boolean) b2.first).booleanValue()) {
                    return;
                }
                hm1.a().b(i);
                i((pl1.a) b2.second, new am1(i2, i3, i4, str), em1Var.a, z);
                if (i2 == 1) {
                    em1Var.b = 1;
                }
                if (z) {
                    int i5 = em1Var.a;
                    if (i5 == 1) {
                        wm1.b(this.d, i4, em1Var.b, i3, str);
                    } else if (i5 == 3) {
                        wm1.f(this.d, i4, em1Var.b, i3, str);
                    } else if (i5 == 2) {
                        if (i2 == 3 && i3 == 2019) {
                            ql1.g(this.d).G(System.currentTimeMillis());
                            ql1.g(this.d).i(i3);
                        }
                        wm1.a(this.d, i4, i2, i3, em1Var.c, em1Var.d);
                    } else {
                        if (i2 == 3 && i3 == 2019) {
                            ql1.g(this.d).P(System.currentTimeMillis());
                            ql1.g(this.d).r(i3);
                        }
                        wm1.e(this.d, i4, i2, i3, em1Var.c, em1Var.d);
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
                    if (!sm1.a.d()) {
                        qn1.b().a(this.d, null);
                    }
                    boolean z = false;
                    if (!sl1.a(this.d).e(true) && gn1.h(this.d) == 0) {
                        z = true;
                    }
                    h(this.d, z);
                    gn1.j(this.d);
                    wl1.c().b(new a(this));
                    this.a.put(1, new yl1(this.d));
                    this.a.put(3, new im1(this.d));
                    this.a.put(2, new km1(this.d));
                    this.e = true;
                }
            }
        }
    }

    public synchronized void f(Context context, int i, Pair<Integer, Integer> pair, long j, pl1.a aVar) {
        Pair<Integer, Integer> pair2;
        int intValue;
        int intValue2;
        int intValue3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Integer.valueOf(i), pair, Long.valueOf(j), aVar}) == null) {
            synchronized (this) {
                int i2 = -1;
                if (vl1.j().d()) {
                    this.b.add(aVar);
                    return;
                }
                this.b.clear();
                int a2 = vl1.j().a(aVar);
                try {
                    Message message = new Message();
                    message.what = a2;
                    message.arg1 = -1;
                    message.arg2 = 1;
                    this.f = -1;
                    hm1.a().c(message, j);
                    if (pair == null) {
                        pair2 = pn1.c(context);
                    } else {
                        pair2 = pair;
                    }
                    intValue = ((Integer) pair2.first).intValue();
                    intValue2 = ((Integer) pair2.second).intValue();
                    intValue3 = ((Integer) pair2.second).intValue();
                } catch (Throwable unused) {
                    i2 = a2;
                    em1 em1Var = new em1();
                    em1Var.a = 1;
                    d(i2, 3, 2009, -1, "auth login unknown error.", em1Var, true);
                }
                if (!j(a2, intValue2, intValue, 1)) {
                    return;
                }
                int b2 = b(intValue2, i);
                this.f = b2;
                vl1.j().i(false, true);
                if (b2 != 1 && b2 != 2 && b2 != 3) {
                    em1 em1Var2 = new em1();
                    em1Var2.a = 1;
                    d(a2, 3, 2004, b2, "has no op.", em1Var2, true);
                    return;
                }
                bm1 bm1Var = this.a.get(Integer.valueOf(b2));
                if (bm1Var == null) {
                    em1 em1Var3 = new em1();
                    em1Var3.a = 1;
                    d(a2, 3, 2002, b2, "not support current operator", em1Var3, true);
                } else {
                    bm1Var.m(intValue3);
                    bm1Var.i(context, intValue, a2);
                    wm1.d(context, intValue3, 1, bm1.q);
                }
            }
        }
    }

    public void k(Context context, int i, Pair<Integer, Integer> pair, long j, pl1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i), pair, Long.valueOf(j), aVar}) == null) {
            int a2 = vl1.j().a(aVar);
            try {
                Message message = new Message();
                message.what = a2;
                message.arg1 = -1;
                message.arg2 = 3;
                this.f = -1;
                hm1.a().c(message, j);
                if (pair == null) {
                    pair = pn1.c(context);
                }
                int intValue = ((Integer) pair.first).intValue();
                int intValue2 = ((Integer) pair.second).intValue();
                int intValue3 = ((Integer) pair.second).intValue();
                if (!j(a2, intValue2, intValue, 3)) {
                    return;
                }
                int b2 = b(intValue2, i);
                this.f = b2;
                if (!vl1.j().m(false, true)) {
                    em1 em1Var = new em1();
                    em1Var.a = 3;
                    d(a2, 3, 998, b2, "is doing auth prelogin.", em1Var, false);
                } else if (b2 != 1 && b2 != 2 && b2 != 3) {
                    em1 em1Var2 = new em1();
                    em1Var2.a = 3;
                    d(a2, 3, 2004, b2, "has no op.", em1Var2, true);
                } else {
                    bm1 bm1Var = this.a.get(Integer.valueOf(b2));
                    if (bm1Var == null) {
                        em1 em1Var3 = new em1();
                        em1Var3.a = 3;
                        d(a2, 3, 2002, b2, "not support current operator", em1Var3, true);
                        return;
                    }
                    bm1Var.m(intValue3);
                    bm1Var.h(context, a2);
                    wm1.d(context, intValue3, 3, bm1.r);
                }
            } catch (Throwable unused) {
                em1 em1Var4 = new em1();
                em1Var4.a = 3;
                d(a2, 3, 2009, -1, "auth login unknown error.", em1Var4, true);
            }
        }
    }

    public void g(Context context, long j, pl1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j), aVar}) == null) {
            int a2 = vl1.j().a(aVar);
            Pair<Integer, Integer> c2 = pn1.c(context);
            int intValue = ((Integer) c2.first).intValue();
            int intValue2 = ((Integer) c2.second).intValue();
            if (!j(a2, intValue2, intValue, 2)) {
                return;
            }
            if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                em1 em1Var = new em1();
                em1Var.a = 2;
                d(a2, 3, 2004, intValue2, "has no op.", em1Var, true);
                return;
            }
            bm1 bm1Var = this.a.get(Integer.valueOf(intValue2));
            if (bm1Var == null) {
                em1 em1Var2 = new em1();
                em1Var2.a = 2;
                d(a2, 3, 2002, intValue2, "not support current operator", em1Var2, true);
            } else if (!vl1.j().e(false, true)) {
                em1 em1Var3 = new em1();
                em1Var3.a = 2;
                d(a2, 3, 998, intValue2, "is doing auth login.", em1Var3, false);
            } else {
                wm1.d(context, intValue2, 2, bm1.q);
                if (!bm1Var.l()) {
                    bm1Var.j(context, a2, j);
                } else if (vl1.j().d()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (vl1.j().d()) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                            try {
                                Thread.sleep(100L);
                                if (!bm1Var.l()) {
                                    bm1Var.j(context, a2, j);
                                    return;
                                }
                            } catch (Throwable th) {
                                gn1.d(th);
                                em1 em1Var4 = new em1();
                                em1Var4.a = 2;
                                d(a2, 3, IMConstants.IM_MSG_TYPE_ADVISORY_DISCLAIMER, intValue2, "auth out time", em1Var4, true);
                                return;
                            }
                        } else {
                            em1 em1Var5 = new em1();
                            em1Var5.a = 2;
                            d(a2, 3, IMConstants.IM_MSG_TYPE_ADVISORY_DISCLAIMER, intValue2, "auth out time", em1Var5, true);
                            return;
                        }
                    }
                } else {
                    f(context, 0, c2, j, new b(this, bm1Var, context, a2, j, aVar));
                }
            }
        }
    }

    public void l(Context context, long j, pl1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, Long.valueOf(j), aVar}) == null) {
            int a2 = vl1.j().a(aVar);
            Pair<Integer, Integer> c2 = pn1.c(context);
            int intValue = ((Integer) c2.first).intValue();
            int intValue2 = ((Integer) c2.second).intValue();
            if (!j(a2, intValue2, intValue, 4)) {
                return;
            }
            if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                em1 em1Var = new em1();
                em1Var.a = 4;
                d(a2, 3, 2004, intValue2, "has no op.", em1Var, true);
                return;
            }
            bm1 bm1Var = this.a.get(Integer.valueOf(intValue2));
            if (bm1Var == null) {
                em1 em1Var2 = new em1();
                em1Var2.a = 4;
                d(a2, 3, 2002, intValue2, "not support current operator", em1Var2, true);
            } else if (!vl1.j().o(false, true)) {
                em1 em1Var3 = new em1();
                em1Var3.a = 4;
                d(a2, 3, 998, intValue2, "is doing auth verify.", em1Var3, false);
            } else {
                wm1.d(context, intValue2, 4, bm1.r);
                if (!bm1Var.q()) {
                    bm1Var.p(context, a2, j);
                } else if (vl1.j().g()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (vl1.j().g()) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                            try {
                                Thread.sleep(100L);
                                if (!bm1Var.q()) {
                                    bm1Var.p(context, a2, j);
                                    return;
                                }
                            } catch (Throwable th) {
                                gn1.d(th);
                                em1 em1Var4 = new em1();
                                em1Var4.a = 4;
                                d(a2, 3, IMConstants.IM_MSG_TYPE_ADVISORY_DISCLAIMER, intValue2, "auth out time", em1Var4, true);
                                return;
                            }
                        } else {
                            em1 em1Var5 = new em1();
                            em1Var5.a = 4;
                            d(a2, 3, IMConstants.IM_MSG_TYPE_ADVISORY_DISCLAIMER, intValue2, "auth out time", em1Var5, true);
                            return;
                        }
                    }
                } else {
                    k(context, 0, c2, j, new c(this, bm1Var, context, a2, j, aVar));
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
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    }
                    context.registerReceiver(this.c, intentFilter);
                } catch (Throwable th) {
                    gn1.d(th);
                }
            }
        }
    }

    public final synchronized void i(pl1.a aVar, am1 am1Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{aVar, am1Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (i == 1) {
                    this.b.clear();
                    dm1.b(aVar, am1Var, i, (ArrayList) this.b.clone(), z);
                } else {
                    dm1.b(aVar, am1Var, i, null, z);
                }
            }
        }
    }

    public final boolean j(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4)) == null) {
            em1 em1Var = new em1();
            em1Var.a = i4;
            if (!this.e) {
                d(i, 3, 2001, i2, "has no init.", em1Var, false);
                return false;
            } else if (TextUtils.isEmpty(pl1.b) && TextUtils.isEmpty(pl1.c)) {
                d(i, 3, 2007, i2, "has no key.", em1Var, false);
                return false;
            } else if (this.a.isEmpty()) {
                d(i, 3, 2002, i2, "has no sdk.", em1Var, false);
                return false;
            } else if (i3 == 0) {
                d(i, 3, 2003, i2, "has no net.", em1Var, false);
                return false;
            } else {
                return true;
            }
        }
        return invokeIIII.booleanValue;
    }
}
