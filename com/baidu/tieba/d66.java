package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.danmu.cache.CacheManager;
import com.baidu.tieba.danmu.data.ItemState;
import com.baidu.tieba.danmu.data.state.DrawState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class d66 extends h56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public int j;
    public a k;
    public final CacheManager l;
    public l66 m;

    @Override // com.baidu.tieba.h56
    public void l(p0 entity, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entity, f) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
        }
    }

    /* loaded from: classes3.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        public final void c(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
            }
        }

        public a(d66 this$0) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {this$0};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.a = -1;
            CollectionsKt__CollectionsKt.emptyList();
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
        }

        public final void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a = i;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d66(c56 context) {
        super(context, r3, null, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c56) objArr2[0], (s0) objArr2[1], (Comparator) objArr2[2], ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Class[] b = c76.a.b();
        s0 b2 = s0.d((Class[]) Arrays.copyOf(b, b.length)).b();
        Intrinsics.checkNotNullExpressionValue(b2, "all(*Families.layoutComponentTypes).get()");
        this.i = -1;
        this.j = -1;
        this.k = new a(this);
        this.l = context.b();
        this.m = new m66();
    }

    @Override // com.baidu.tieba.h56, com.baidu.tieba.q0
    public void a(p0 entity) {
        x46 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, entity) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            super.a(entity);
            l66 l66Var = this.m;
            j56 b = h66.b(entity);
            if (b == null) {
                a2 = null;
            } else {
                a2 = b.a();
            }
            if (a2 == null) {
                return;
            }
            l66Var.b(a2);
        }
    }

    public final void p(l66 l66Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, l66Var) == null) {
            Intrinsics.checkNotNullParameter(l66Var, "<set-?>");
            this.m = l66Var;
        }
    }

    public final x66 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return g66.c(this);
        }
        return (x66) invokeV.objValue;
    }

    public final l66 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.m;
        }
        return (l66) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h56, com.baidu.tieba.r0
    public void update(float f) {
        boolean z;
        x46 a2;
        boolean z2;
        k56 k56Var;
        DrawState drawState;
        x46 a3;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            i66.b("LayoutSystem_update");
            r46 c = i().c();
            boolean z5 = false;
            if (this.i == c.r() && this.j == c.o()) {
                z = false;
            } else {
                z = true;
            }
            if (g66.e(this) && !z) {
                i66.a();
                return;
            }
            if (this.i != c.r()) {
                BdLog.v("DanmakuEngine [Layout] RetainerGeneration change, clear retainer.");
                this.m.c(0, (int) (n().getHeight() * c.u()));
                this.m.clear();
                this.i = c.r();
            }
            if (this.k.a() != c.l()) {
                this.k.b(c.l());
                this.k.c(CollectionsKt___CollectionsKt.toList(c.n()));
            }
            long b = g66.b(this);
            List k = k();
            ArrayList arrayList = new ArrayList();
            for (Object obj : k) {
                i56 d = h66.d((p0) obj);
                if (d == null || d.d()) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (z4) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            boolean z6 = false;
            while (true) {
                x46 x46Var = null;
                if (!it.hasNext()) {
                    break;
                }
                j56 b2 = h66.b((p0) it.next());
                if (b2 != null) {
                    x46Var = b2.a();
                }
                if (x46Var != null && x46Var.i() != ItemState.Measuring) {
                    boolean z7 = !x46Var.f().r(c.p());
                    if (x46Var.i().compareTo(ItemState.Measuring) < 0 || z7) {
                        if (z7 && x46Var.i().compareTo(ItemState.Measuring) >= 0) {
                            BdLog.v(Intrinsics.stringPlus("DanmakuEngine [Layout] re-measure ", x46Var.e()));
                        }
                        x46Var.o(ItemState.Measuring);
                        this.l.o(x46Var, n(), c);
                        z6 = true;
                    }
                }
            }
            ArrayList<p0> arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                j56 b3 = h66.b((p0) obj2);
                if (b3 == null) {
                    a3 = null;
                } else {
                    a3 = b3.a();
                }
                if (a3 == null || a3.i().compareTo(ItemState.Measured) < 0) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z3) {
                    arrayList2.add(obj2);
                }
            }
            boolean z8 = z6;
            for (p0 p0Var : arrayList2) {
                j56 b4 = h66.b(p0Var);
                if (b4 == null) {
                    a2 = null;
                } else {
                    a2 = b4.a();
                }
                if (a2 != null) {
                    DrawState f2 = a2.f();
                    k56 e = h66.e(p0Var);
                    if (e != null || (e = (k56) g66.a(this, k56.class, p0Var, a2)) != null) {
                        k56 k56Var2 = e;
                        if (f2.e() != c.o()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            f2.H(z5);
                            k56Var = k56Var2;
                            drawState = f2;
                            k56Var.e(o().d(a2, b, n(), c));
                        } else {
                            k56Var = k56Var2;
                            drawState = f2;
                        }
                        if (k56Var.d()) {
                            synchronized (a2.i()) {
                                if (a2.i().compareTo(ItemState.Rendering) < 0) {
                                    a2.o(ItemState.Rendering);
                                    this.l.m(a2, n(), c);
                                    z8 = true;
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                            o().a(a2, b, n(), c);
                            drawState.y(c.o());
                        }
                        k56Var.c().set(drawState.g(), drawState.h());
                        z5 = false;
                    }
                }
            }
            if (g66.e(this)) {
                if (z8) {
                    this.l.n();
                } else {
                    c.H();
                    this.j = c.o();
                }
            }
            i66.a();
        }
    }
}
