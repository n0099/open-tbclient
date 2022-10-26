package com.baidu.tieba.danmu.ecs.system;

import android.os.Trace;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.tieba.a66;
import com.baidu.tieba.a76;
import com.baidu.tieba.bq4;
import com.baidu.tieba.c56;
import com.baidu.tieba.c66;
import com.baidu.tieba.c76;
import com.baidu.tieba.e66;
import com.baidu.tieba.g66;
import com.baidu.tieba.h56;
import com.baidu.tieba.h66;
import com.baidu.tieba.i56;
import com.baidu.tieba.i66;
import com.baidu.tieba.j56;
import com.baidu.tieba.k56;
import com.baidu.tieba.l56;
import com.baidu.tieba.m56;
import com.baidu.tieba.o0;
import com.baidu.tieba.p0;
import com.baidu.tieba.r46;
import com.baidu.tieba.s0;
import com.baidu.tieba.w46;
import com.baidu.tieba.w56;
import com.baidu.tieba.x46;
import com.baidu.tieba.x56;
import com.baidu.tieba.y46;
import com.baidu.tieba.y56;
import com.baidu.tieba.z46;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010J\u0014\u0010 \u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\"J\b\u0010#\u001a\u00020\u001eH\u0003J\u0016\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u001bH\u0002J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\b\u0010(\u001a\u00020\u001eH\u0002J\u0010\u0010)\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010J\u0016\u0010*\u001a\u00020\u001e2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00100\u001bH\u0016J\u0016\u0010,\u001a\u00020\u001e2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00100\u001bH\u0016J\u0018\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0014J\u0010\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u00020\u001eH\u0002J\u0010\u00107\u001a\u00020\u001e2\u0006\u00101\u001a\u000202H\u0016J\b\u00108\u001a\u00020\u001eH\u0002J\u0006\u00109\u001a\u00020\u001eJ\u000e\u0010:\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0012j\b\u0012\u0004\u0012\u00020\u000b`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u0019\u001a&\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00100\u0010 \u001a*\u0012\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u001b0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/baidu/tieba/danmu/ecs/system/DataSystem;", "Lcom/baidu/tieba/danmu/ecs/base/DanmakuSortedSystem;", "Lcom/baidu/tieba/danmu/data/DataSource$DataChangeListener;", "context", "Lcom/baidu/tieba/danmu/ecs/DanmakuContext;", "(Lcom/baidu/tieba/danmu/ecs/DanmakuContext;)V", "comparator", "Lcom/baidu/tieba/danmu/ecs/system/DanmakuItemComparator;", "currentData", "Lcom/baidu/tieba/danmu/ecs/system/Danmakus;", "endTimeMills", "", "entityEntryTime", "forceUpdate", "", "holdingItem", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", "idSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "pendingAddItems", "", "pendingCreateItems", "pendingUpdateItems", "shouldSort", "sortedData", "kotlin.jvm.PlatformType", "", "startTimeMills", "addItem", "", "item", "addItems", "items", "", "addPendingItems", "createEntityBeforeEntry", "", "data", "createItemEntity", "createPendingItems", "hold", "onDataAdded", "additionalItems", "onDataRemoved", "removalItems", "processEntity", "entity", "Lcom/badlogic/ashley/core/Entity;", "deltaTime", "", "removedFromEngine", "engine", "Lcom/badlogic/ashley/core/Engine;", QuickPersistConfigConst.KEY_SPLASH_SORT, "update", "updateCurrentSlice", "updateEntities", "updateItem", "Companion", "danmu_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class DataSystem extends h56 implements z46.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List i;
    public c66 j;
    public final a66 k;
    public final List l;
    public final List m;
    public final List n;
    public boolean o;
    public long p;
    public long q;
    public boolean r;
    public final HashSet s;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1163828288, "Lcom/baidu/tieba/danmu/ecs/system/DataSystem;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1163828288, "Lcom/baidu/tieba/danmu/ecs/system/DataSystem;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataSystem(c56 context) {
        super(context, c76.a.a(), null, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c56) objArr2[0], (s0) objArr2[1], (Comparator) objArr2[2], ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.i = Collections.synchronizedList(new ArrayList());
        List synchronizedList = Collections.synchronizedList(new w46());
        Intrinsics.checkNotNullExpressionValue(synchronizedList, "synchronizedList(TreeList())");
        this.j = new c66(synchronizedList, 0L, 0L, -1, -1, false, 32, null);
        this.k = new a66();
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.s = new HashSet();
    }

    public final void A(x46 x46Var) {
        m56 m56Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, x46Var) != null) || this.s.contains(Long.valueOf(x46Var.e().f()))) {
            return;
        }
        p0 entity = f().i();
        Intrinsics.checkNotNullExpressionValue(entity, "entity");
        if (((j56) g66.a(this, j56.class, entity, x46Var)) == null) {
            return;
        }
        if (x46Var.e().j() > 0) {
            if (((k56) g66.a(this, k56.class, entity, x46Var)) == null) {
                return;
            }
            int j = x46Var.e().j();
            if (j != 1) {
                if (j != 4) {
                    if (j == 5) {
                        entity.a(new x56());
                    }
                } else {
                    entity.a(new w56());
                }
            } else {
                entity.a(new y56());
            }
        }
        if (!x46Var.d().isEmpty() && (m56Var = (m56) g66.a(this, m56.class, entity, x46Var)) != null) {
            for (l56 it : x46Var.d()) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                m56Var.d(it);
            }
        }
        f().c(entity);
        this.s.add(Long.valueOf(x46Var.e().f()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (this.o) {
                synchronized (this) {
                    List sortedData = this.i;
                    Intrinsics.checkNotNullExpressionValue(sortedData, "sortedData");
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(sortedData, this.k);
                    Unit unit = Unit.INSTANCE;
                }
                this.o = false;
            }
            if (this.j.c()) {
                synchronized (this) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(this.j.a(), this.k);
                    Unit unit2 = Unit.INSTANCE;
                }
                this.j.f(false);
            }
        }
    }

    @Override // com.baidu.tieba.h56, com.baidu.tieba.f56, com.baidu.tieba.r0
    public void g(o0 engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
            super.g(engine);
            this.i.clear();
        }
    }

    public final void w(x46 item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, item) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            synchronized (this) {
                this.l.add(item);
            }
        }
    }

    public final void x(Collection items) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, items) == null) {
            Intrinsics.checkNotNullParameter(items, "items");
            synchronized (this) {
                this.l.addAll(items);
            }
        }
    }

    public final int z(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) {
            this.m.addAll(list);
            return list.size();
        }
        return invokeL.intValue;
    }

    public final void B() {
        List<x46> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                list = CollectionsKt___CollectionsKt.toList(this.m);
                this.m.clear();
            }
            for (x46 x46Var : list) {
                A(x46Var);
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.i.isEmpty()) {
            return;
        }
        int i = 0;
        if (!bq4.e()) {
            i66.b("DataSystem_createNewSlice");
            synchronized (this) {
                List sortedData = this.i;
                Intrinsics.checkNotNullExpressionValue(sortedData, "sortedData");
                int a = e66.a(sortedData, Long.valueOf(this.p), DataSystem$updateCurrentSlice$1$1$1.INSTANCE);
                List sortedData2 = this.i;
                Intrinsics.checkNotNullExpressionValue(sortedData2, "sortedData");
                int b = e66.b(sortedData2, Long.valueOf(this.q), DataSystem$updateCurrentSlice$1$1$2.INSTANCE);
                if (a != -1 && b != -1 && b >= a) {
                    BdLog.w("DanmakuEngine [Data] update current slice [" + a + StringUtil.ARRAY_ELEMENT_SEPARATOR + b + "] in time (" + this.p + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.q + ')');
                    List subList = this.i.subList(a, b + 1);
                    i66.a();
                    Unit unit = Unit.INSTANCE;
                    i66.b(Intrinsics.stringPlus("DataSystem_getCurrentEntity_", Integer.valueOf(subList.size())));
                    c66 c66Var = this.j;
                    List synchronizedList = Collections.synchronizedList(e66.c(subList));
                    Intrinsics.checkNotNullExpressionValue(synchronizedList, "synchronizedList(newData.toTreeList())");
                    this.j = new c66(synchronizedList, this.p, this.q, a, b, false, 32, null);
                    i66.a();
                    i66.b("DataSystem_diffAndCreateEntity");
                    if (a <= c66Var.b() && b > c66Var.d()) {
                        z(subList);
                    } else {
                        i = 0 + subList.size();
                        z(subList);
                        BdLog.d("DanmakuEngine [Data] Add all new data [" + a + StringUtil.ARRAY_ELEMENT_SEPARATOR + b + ']');
                    }
                    i66.a();
                    BdLog.d("DanmakuEngine [Data] Add " + i + " in [" + this.p + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.q + ']');
                }
                BdLog.w("DanmakuEngine [Data] update current slice failed: invalid start or end index.");
                i66.a();
            }
            return;
        }
        Trace.beginSection("DataSystem_updateCurrentSlice");
        i66.b("DataSystem_createNewSlice");
        synchronized (this) {
            List sortedData3 = this.i;
            Intrinsics.checkNotNullExpressionValue(sortedData3, "sortedData");
            int a2 = e66.a(sortedData3, Long.valueOf(this.p), DataSystem$updateCurrentSlice$1$1$1.INSTANCE);
            List sortedData4 = this.i;
            Intrinsics.checkNotNullExpressionValue(sortedData4, "sortedData");
            int b2 = e66.b(sortedData4, Long.valueOf(this.q), DataSystem$updateCurrentSlice$1$1$2.INSTANCE);
            if (a2 != -1 && b2 != -1 && b2 >= a2) {
                BdLog.w("DanmakuEngine [Data] update current slice [" + a2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + b2 + "] in time (" + this.p + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.q + ')');
                List subList2 = this.i.subList(a2, b2 + 1);
                i66.a();
                Unit unit2 = Unit.INSTANCE;
                i66.b(Intrinsics.stringPlus("DataSystem_getCurrentEntity_", Integer.valueOf(subList2.size())));
                c66 c66Var2 = this.j;
                List synchronizedList2 = Collections.synchronizedList(e66.c(subList2));
                Intrinsics.checkNotNullExpressionValue(synchronizedList2, "synchronizedList(newData.toTreeList())");
                this.j = new c66(synchronizedList2, this.p, this.q, a2, b2, false, 32, null);
                i66.a();
                i66.b("DataSystem_diffAndCreateEntity");
                if (a2 <= c66Var2.b() && b2 > c66Var2.d()) {
                    z(subList2);
                } else {
                    i = 0 + subList2.size();
                    z(subList2);
                    BdLog.d("DanmakuEngine [Data] Add all new data [" + a2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + b2 + ']');
                }
                i66.a();
                BdLog.d("DanmakuEngine [Data] Add " + i + " in [" + this.p + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.q + ']');
            }
            BdLog.w("DanmakuEngine [Data] update current slice failed: invalid start or end index.");
            i66.a();
        }
        Unit unit3 = Unit.INSTANCE;
        Trace.endSection();
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            r46 c = i().c();
            long max = Math.max(c.k(), c.t());
            long b = g66.b(this) - max;
            long b2 = g66.b(this) + max;
            g66.b(this);
            y();
            if (!bq4.e()) {
                m();
            } else {
                Trace.beginSection("DataSystem_sort");
                m();
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
            }
            if (this.r || b < this.p || g66.b(this) > this.q - i().c().q()) {
                this.p = b;
                this.q = b2;
                C();
                this.r = false;
            }
            B();
        }
    }

    @Override // com.baidu.tieba.h56
    public void l(p0 entity, float f) {
        x46 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048581, this, entity, f) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            a76 d = g66.d(this);
            j56 b = h66.b(entity);
            if (b == null) {
                a = null;
            } else {
                a = b.a();
            }
            if (a == null) {
                return;
            }
            i56 d2 = h66.d(entity);
            if (d2 == null && (d2 = (i56) g66.a(this, i56.class, entity, a)) == null) {
                return;
            }
            r46 c = i().c();
            if (d2.c() != c.l()) {
                d2.update(c.l(), i().e().a(a, d, c).a());
            }
        }
    }

    @Override // com.baidu.tieba.h56, com.baidu.tieba.r0
    public void update(float f) {
        x46 a;
        long k;
        x46 a2;
        long k2;
        x46 a3;
        long k3;
        x46 a4;
        long k4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
            if (!bq4.e()) {
                if (!bq4.e()) {
                    r46 c = i().c();
                    for (p0 p0Var : k()) {
                        j56 b = h66.b(p0Var);
                        if (b == null) {
                            a4 = null;
                        } else {
                            a4 = b.a();
                        }
                        if (a4 != null) {
                            y46 e = a4.e();
                            if (e.j() == 1) {
                                k4 = c.t();
                            } else {
                                k4 = c.k();
                            }
                            a4.m(k4);
                            if (h66.h(p0Var, g66.b(this))) {
                                if (!this.j.a().isEmpty()) {
                                    this.j.a().remove(a4);
                                }
                                this.s.remove(Long.valueOf(e.f()));
                                f().m(p0Var);
                                c66 c66Var = this.j;
                                c66Var.g(c66Var.d() + 1);
                            } else if (h66.g(p0Var, this.q)) {
                                this.s.remove(Long.valueOf(e.f()));
                                f().m(p0Var);
                            }
                        }
                    }
                    super.update(f);
                    return;
                }
                Trace.beginSection("DataSystem_processEntity");
                r46 c2 = i().c();
                for (p0 p0Var2 : k()) {
                    j56 b2 = h66.b(p0Var2);
                    if (b2 == null) {
                        a3 = null;
                    } else {
                        a3 = b2.a();
                    }
                    if (a3 != null) {
                        y46 e2 = a3.e();
                        if (e2.j() == 1) {
                            k3 = c2.t();
                        } else {
                            k3 = c2.k();
                        }
                        a3.m(k3);
                        if (h66.h(p0Var2, g66.b(this))) {
                            if (!this.j.a().isEmpty()) {
                                this.j.a().remove(a3);
                            }
                            this.s.remove(Long.valueOf(e2.f()));
                            f().m(p0Var2);
                            c66 c66Var2 = this.j;
                            c66Var2.g(c66Var2.d() + 1);
                        } else if (h66.g(p0Var2, this.q)) {
                            this.s.remove(Long.valueOf(e2.f()));
                            f().m(p0Var2);
                        }
                    }
                }
                super.update(f);
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
                return;
            }
            Trace.beginSection("DataSystem_update");
            if (!bq4.e()) {
                r46 c3 = i().c();
                for (p0 p0Var3 : k()) {
                    j56 b3 = h66.b(p0Var3);
                    if (b3 == null) {
                        a2 = null;
                    } else {
                        a2 = b3.a();
                    }
                    if (a2 != null) {
                        y46 e3 = a2.e();
                        if (e3.j() == 1) {
                            k2 = c3.t();
                        } else {
                            k2 = c3.k();
                        }
                        a2.m(k2);
                        if (h66.h(p0Var3, g66.b(this))) {
                            if (!this.j.a().isEmpty()) {
                                this.j.a().remove(a2);
                            }
                            this.s.remove(Long.valueOf(e3.f()));
                            f().m(p0Var3);
                            c66 c66Var3 = this.j;
                            c66Var3.g(c66Var3.d() + 1);
                        } else if (h66.g(p0Var3, this.q)) {
                            this.s.remove(Long.valueOf(e3.f()));
                            f().m(p0Var3);
                        }
                    }
                }
                super.update(f);
            } else {
                Trace.beginSection("DataSystem_processEntity");
                r46 c4 = i().c();
                for (p0 p0Var4 : k()) {
                    j56 b4 = h66.b(p0Var4);
                    if (b4 == null) {
                        a = null;
                    } else {
                        a = b4.a();
                    }
                    if (a != null) {
                        y46 e4 = a.e();
                        if (e4.j() == 1) {
                            k = c4.t();
                        } else {
                            k = c4.k();
                        }
                        a.m(k);
                        if (h66.h(p0Var4, g66.b(this))) {
                            if (!this.j.a().isEmpty()) {
                                this.j.a().remove(a);
                            }
                            this.s.remove(Long.valueOf(e4.f()));
                            f().m(p0Var4);
                            c66 c66Var4 = this.j;
                            c66Var4.g(c66Var4.d() + 1);
                        } else if (h66.g(p0Var4, this.q)) {
                            this.s.remove(Long.valueOf(e4.f()));
                            f().m(p0Var4);
                        }
                    }
                }
                super.update(f);
                Unit unit2 = Unit.INSTANCE;
                Trace.endSection();
            }
            Unit unit3 = Unit.INSTANCE;
            Trace.endSection();
        }
    }

    public final void y() {
        List list;
        List list2;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this) {
                list = CollectionsKt___CollectionsKt.toList(this.l);
                this.l.clear();
            }
            synchronized (this) {
                list2 = CollectionsKt___CollectionsKt.toList(this.n);
                this.n.clear();
            }
            this.i.removeAll(list2);
            this.i.addAll(list2);
            this.i.addAll(list);
            boolean z5 = false;
            if ((list instanceof Collection) && list.isEmpty()) {
                i = 0;
            } else {
                Iterator it = list.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (((x46) it.next()).e().k() < this.p) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z && (i = i + 1) < 0) {
                        CollectionsKt__CollectionsKt.throwCountOverflow();
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                long j = this.p;
                long j2 = this.q;
                long k = ((x46) obj).e().k();
                if (j <= k && k < j2) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    arrayList.add(obj);
                }
            }
            c66 c66Var = this.j;
            c66Var.g(c66Var.d() + i);
            c66 c66Var2 = this.j;
            c66Var2.e(c66Var2.b() + i + arrayList.size());
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : list2) {
                long j3 = this.p;
                long j4 = this.q;
                long k2 = ((x46) obj2).e().k();
                if (j3 <= k2 && k2 < j4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    arrayList2.add(obj2);
                }
            }
            this.j.a().removeAll(arrayList2);
            this.j.a().addAll(arrayList2);
            this.j.a().addAll(arrayList);
            this.m.addAll(arrayList);
            if (!(!list.isEmpty()) && !(!list2.isEmpty())) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.o = z2;
            c66 c66Var3 = this.j;
            c66Var3.f((c66Var3.c() || (arrayList.isEmpty() ^ true) || (arrayList2.isEmpty() ^ true)) ? true : true);
        }
    }
}
