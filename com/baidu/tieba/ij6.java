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
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class ij6 extends mi6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public int j;
    public a k;
    public final CacheManager l;
    public qj6 m;

    @Override // com.baidu.tieba.mi6
    public void l(y entity, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entity, f) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
        }
    }

    /* loaded from: classes4.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        public final void c(List<? extends Object> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
            }
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(ij6 ij6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ij6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
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
    public ij6(hi6 context) {
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
                super((hi6) objArr2[0], (b0) objArr2[1], (Comparator) objArr2[2], ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Class<? extends ji6>[] b = hk6.a.b();
        b0 b2 = b0.d((Class[]) Arrays.copyOf(b, b.length)).b();
        Intrinsics.checkNotNullExpressionValue(b2, "all(*Families.layoutComponentTypes).get()");
        this.i = -1;
        this.j = -1;
        this.k = new a(this);
        this.l = context.b();
        this.m = new rj6();
    }

    @Override // com.baidu.tieba.mi6, com.baidu.tieba.z
    public void a(y entity) {
        ci6 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, entity) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            super.a(entity);
            qj6 qj6Var = this.m;
            oi6 b = mj6.b(entity);
            if (b != null && (a2 = b.a()) != null) {
                qj6Var.b(a2);
            }
        }
    }

    public final void o(qj6 qj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, qj6Var) == null) {
            Intrinsics.checkNotNullParameter(qj6Var, "<set-?>");
            this.m = qj6Var;
        }
    }

    public final ck6 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return lj6.c(this);
        }
        return (ck6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mi6, com.baidu.tieba.a0
    public void update(float f) {
        boolean z;
        ci6 a2;
        boolean z2;
        pi6 pi6Var;
        boolean z3;
        ci6 a3;
        ci6 a4;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
            nj6.b("LayoutSystem_update");
            wh6 c = i().c();
            if (this.i == c.r() && this.j == c.o()) {
                z = false;
            } else {
                z = true;
            }
            if (lj6.e(this) && !z) {
                nj6.a();
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
            long b = lj6.b(this);
            List<y> k = k();
            ArrayList<y> arrayList = new ArrayList();
            for (Object obj : k) {
                ni6 d = mj6.d((y) obj);
                if (d == null || d.d()) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (z4) {
                    arrayList.add(obj);
                }
            }
            boolean z5 = false;
            for (y yVar : arrayList) {
                oi6 b2 = mj6.b(yVar);
                if (b2 != null && (a4 = b2.a()) != null && a4.j() != ItemState.Measuring) {
                    boolean z6 = !a4.f().r(c.p());
                    if (a4.j().compareTo(ItemState.Measuring) < 0 || z6) {
                        if (z6 && a4.j().compareTo(ItemState.Measuring) >= 0) {
                            BdLog.v("DanmakuEngine [Layout] re-measure " + a4.e());
                        }
                        a4.p(ItemState.Measuring);
                        this.l.o(a4, n(), c);
                        z5 = true;
                    }
                }
            }
            ArrayList<y> arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                oi6 b3 = mj6.b((y) obj2);
                if (b3 != null && (a3 = b3.a()) != null && a3.j().compareTo(ItemState.Measured) >= 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    arrayList2.add(obj2);
                }
            }
            boolean z7 = z5;
            for (y yVar2 : arrayList2) {
                oi6 b4 = mj6.b(yVar2);
                if (b4 != null && (a2 = b4.a()) != null) {
                    DrawState f2 = a2.f();
                    pi6 e = mj6.e(yVar2);
                    if (e != null || (e = (pi6) lj6.a(this, pi6.class, yVar2, a2)) != null) {
                        pi6 pi6Var2 = e;
                        if (f2.e() != c.o()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            f2.H(false);
                            pi6Var = pi6Var2;
                            pi6Var.e(this.m.d(a2, b, n(), c));
                        } else {
                            pi6Var = pi6Var2;
                        }
                        if (pi6Var.d()) {
                            synchronized (a2.j()) {
                                if (a2.j().compareTo(ItemState.Rendering) < 0) {
                                    a2.p(ItemState.Rendering);
                                    this.l.m(a2, n(), c);
                                    z7 = true;
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                            this.m.a(a2, b, n(), c);
                            f2.y(c.o());
                        }
                        pi6Var.c().set(f2.g(), f2.h());
                    }
                }
            }
            if (lj6.e(this)) {
                if (z7) {
                    this.l.n();
                } else {
                    c.H();
                    this.j = c.o();
                }
            }
            nj6.a();
        }
    }
}
