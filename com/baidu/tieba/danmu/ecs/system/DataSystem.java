package com.baidu.tieba.danmu.ecs.system;

import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.m0.e.a;
import c.a.r0.m0.e.c;
import c.a.r0.m0.f.c.d;
import c.a.r0.m0.f.e.b;
import c.a.r0.m0.g.e;
import c.b.a.a.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.QuickPersistConfigConst;
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
/* loaded from: classes10.dex */
public final class DataSystem extends d implements c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<a> m;
    public c.a.r0.m0.f.e.d n;
    public final b o;
    public final List<a> p;
    public final List<a> q;
    public final List<a> r;
    public boolean s;
    public long t;
    public long u;
    public boolean v;
    public final HashSet<Long> w;

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
    public DataSystem(c.a.r0.m0.f.a context) {
        super(context, c.a.r0.m0.k.d.a.a(), null, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.r0.m0.f.a) objArr2[0], (g) objArr2[1], (Comparator) objArr2[2], ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.m = Collections.synchronizedList(new ArrayList());
        List synchronizedList = Collections.synchronizedList(new c.a.r0.m0.d.a());
        Intrinsics.checkNotNullExpressionValue(synchronizedList, "synchronizedList(TreeList())");
        this.n = new c.a.r0.m0.f.e.d(synchronizedList, 0L, 0L, -1, -1, false, 32, null);
        this.o = new b();
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.w = new HashSet<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (this.s) {
                synchronized (this) {
                    List<a> sortedData = this.m;
                    Intrinsics.checkNotNullExpressionValue(sortedData, "sortedData");
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(sortedData, this.o);
                    Unit unit = Unit.INSTANCE;
                }
                this.s = false;
            }
            if (this.n.c()) {
                synchronized (this) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(this.n.a(), this.o);
                    Unit unit2 = Unit.INSTANCE;
                }
                this.n.f(false);
            }
        }
    }

    public final void A(a aVar) {
        c.a.r0.m0.f.d.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.w.contains(Long.valueOf(aVar.e().f()))) {
            return;
        }
        c.b.a.a.d entity = f().i();
        Intrinsics.checkNotNullExpressionValue(entity, "entity");
        if (((c.a.r0.m0.f.d.b) c.a.r0.m0.g.c.a(this, c.a.r0.m0.f.d.b.class, entity, aVar)) == null) {
            return;
        }
        if (aVar.e().j() > 0) {
            if (((c.a.r0.m0.f.d.c) c.a.r0.m0.g.c.a(this, c.a.r0.m0.f.d.c.class, entity, aVar)) == null) {
                return;
            }
            int j2 = aVar.e().j();
            if (j2 == 1) {
                entity.a(new c.a.r0.m0.f.d.f.b.a());
            } else if (j2 == 4) {
                entity.a(new c.a.r0.m0.f.d.f.a.a());
            } else if (j2 == 5) {
                entity.a(new c.a.r0.m0.f.d.f.a.b());
            }
        }
        if (!aVar.d().isEmpty() && (bVar = (c.a.r0.m0.f.d.d.b) c.a.r0.m0.g.c.a(this, c.a.r0.m0.f.d.d.b.class, entity, aVar)) != null) {
            for (c.a.r0.m0.f.d.d.a it : aVar.d()) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                bVar.d(it);
            }
        }
        f().c(entity);
        this.w.add(Long.valueOf(aVar.e().f()));
    }

    public final void B() {
        List<a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                list = CollectionsKt___CollectionsKt.toList(this.q);
                this.q.clear();
            }
            for (a aVar : list) {
                A(aVar);
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.m.isEmpty()) {
            return;
        }
        e.b("DataSystem_createNewSlice");
        synchronized (this) {
            List sortedData = this.m;
            Intrinsics.checkNotNullExpressionValue(sortedData, "sortedData");
            int a = c.a.r0.m0.g.a.a(sortedData, Long.valueOf(this.t), DataSystem$updateCurrentSlice$1$1$1.INSTANCE);
            List sortedData2 = this.m;
            Intrinsics.checkNotNullExpressionValue(sortedData2, "sortedData");
            int b2 = c.a.r0.m0.g.a.b(sortedData2, Long.valueOf(this.u), DataSystem$updateCurrentSlice$1$1$2.INSTANCE);
            if (a != -1 && b2 != -1 && b2 >= a) {
                BdLog.w("DanmakuEngine [Data] update current slice [" + a + StringUtil.ARRAY_ELEMENT_SEPARATOR + b2 + "] in time (" + this.t + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.u + ')');
                List subList = this.m.subList(a, b2 + 1);
                e.a();
                Unit unit = Unit.INSTANCE;
                e.b(Intrinsics.stringPlus("DataSystem_getCurrentEntity_", Integer.valueOf(subList.size())));
                c.a.r0.m0.f.e.d dVar = this.n;
                List synchronizedList = Collections.synchronizedList(c.a.r0.m0.g.a.c(subList));
                Intrinsics.checkNotNullExpressionValue(synchronizedList, "synchronizedList(newData.toTreeList())");
                this.n = new c.a.r0.m0.f.e.d(synchronizedList, this.t, this.u, a, b2, false, 32, null);
                e.a();
                e.b("DataSystem_diffAndCreateEntity");
                int i2 = 0;
                if (a <= dVar.b() && b2 > dVar.d()) {
                    z(subList);
                } else {
                    i2 = 0 + subList.size();
                    z(subList);
                    BdLog.d("DanmakuEngine [Data] Add all new data [" + a + StringUtil.ARRAY_ELEMENT_SEPARATOR + b2 + ']');
                }
                e.a();
                BdLog.d("DanmakuEngine [Data] Add " + i2 + " in [" + this.t + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.u + ']');
                return;
            }
            BdLog.w("DanmakuEngine [Data] update current slice failed: invalid start or end index.");
            e.a();
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.r0.m0.a c2 = i().c();
            long max = Math.max(c2.k(), c2.t());
            long b2 = c.a.r0.m0.g.c.b(this) - max;
            long b3 = c.a.r0.m0.g.c.b(this) + max;
            c.a.r0.m0.g.c.b(this);
            y();
            m();
            if (this.v || b2 < this.t || c.a.r0.m0.g.c.b(this) > this.u - i().c().q()) {
                this.t = b2;
                this.u = b3;
                C();
                this.v = false;
            }
            B();
        }
    }

    @Override // c.a.r0.m0.f.c.d, c.a.r0.m0.f.c.b, c.b.a.a.f
    public void g(c.b.a.a.c engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
            super.g(engine);
            this.m.clear();
        }
    }

    @Override // c.a.r0.m0.f.c.d
    public void l(c.b.a.a.d entity, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048581, this, entity, f2) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            c.a.r0.m0.k.b d2 = c.a.r0.m0.g.c.d(this);
            c.a.r0.m0.f.d.b b2 = c.a.r0.m0.g.d.b(entity);
            a a = b2 == null ? null : b2.a();
            if (a == null) {
                return;
            }
            c.a.r0.m0.f.d.a d3 = c.a.r0.m0.g.d.d(entity);
            if (d3 == null && (d3 = (c.a.r0.m0.f.d.a) c.a.r0.m0.g.c.a(this, c.a.r0.m0.f.d.a.class, entity, a)) == null) {
                return;
            }
            c.a.r0.m0.a c2 = i().c();
            if (d3.c() != c2.l()) {
                d3.update(c2.l(), i().e().a(a, d2, c2).a());
            }
        }
    }

    @Override // c.a.r0.m0.f.c.d, c.b.a.a.f
    public void update(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            c.a.r0.m0.a c2 = i().c();
            for (c.b.a.a.d dVar : k()) {
                c.a.r0.m0.f.d.b b2 = c.a.r0.m0.g.d.b(dVar);
                a a = b2 == null ? null : b2.a();
                if (a != null) {
                    c.a.r0.m0.e.b e2 = a.e();
                    a.m(e2.j() == 1 ? c2.t() : c2.k());
                    if (c.a.r0.m0.g.d.h(dVar, c.a.r0.m0.g.c.b(this))) {
                        if (!this.n.a().isEmpty()) {
                            this.n.a().remove(a);
                        }
                        this.w.remove(Long.valueOf(e2.f()));
                        f().m(dVar);
                        c.a.r0.m0.f.e.d dVar2 = this.n;
                        dVar2.g(dVar2.d() + 1);
                    } else if (c.a.r0.m0.g.d.g(dVar, this.u)) {
                        this.w.remove(Long.valueOf(e2.f()));
                        f().m(dVar);
                    }
                }
            }
            super.update(f2);
        }
    }

    public final void w(a item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, item) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            synchronized (this) {
                this.p.add(item);
            }
        }
    }

    public final void x(Collection<? extends a> items) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, items) == null) {
            Intrinsics.checkNotNullParameter(items, "items");
            synchronized (this) {
                this.p.addAll(items);
            }
        }
    }

    @WorkerThread
    public final void y() {
        List list;
        List list2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this) {
                list = CollectionsKt___CollectionsKt.toList(this.p);
                this.p.clear();
            }
            synchronized (this) {
                list2 = CollectionsKt___CollectionsKt.toList(this.r);
                this.r.clear();
            }
            this.m.removeAll(list2);
            this.m.addAll(list2);
            this.m.addAll(list);
            boolean z = false;
            if ((list instanceof Collection) && list.isEmpty()) {
                i2 = 0;
            } else {
                Iterator it = list.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    if ((((a) it.next()).e().k() < this.t) && (i2 = i2 + 1) < 0) {
                        CollectionsKt__CollectionsKt.throwCountOverflow();
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                long j2 = this.t;
                long j3 = this.u;
                long k2 = ((a) obj).e().k();
                if (j2 <= k2 && k2 < j3) {
                    arrayList.add(obj);
                }
            }
            c.a.r0.m0.f.e.d dVar = this.n;
            dVar.g(dVar.d() + i2);
            c.a.r0.m0.f.e.d dVar2 = this.n;
            dVar2.e(dVar2.b() + i2 + arrayList.size());
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : list2) {
                long j4 = this.t;
                long j5 = this.u;
                long k3 = ((a) obj2).e().k();
                if (j4 <= k3 && k3 < j5) {
                    arrayList2.add(obj2);
                }
            }
            this.n.a().removeAll(arrayList2);
            this.n.a().addAll(arrayList2);
            this.n.a().addAll(arrayList);
            this.q.addAll(arrayList);
            this.s = (list.isEmpty() ^ true) || (list2.isEmpty() ^ true);
            c.a.r0.m0.f.e.d dVar3 = this.n;
            dVar3.f((dVar3.c() || (arrayList.isEmpty() ^ true) || (arrayList2.isEmpty() ^ true)) ? true : true);
        }
    }

    public final int z(List<? extends a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) {
            this.q.addAll(list);
            return list.size();
        }
        return invokeL.intValue;
    }
}
