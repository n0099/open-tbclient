package com.baidu.tieba.danmu.ecs.system;

import android.os.Trace;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.tieba.at6;
import com.baidu.tieba.bu6;
import com.baidu.tieba.bv6;
import com.baidu.tieba.dt6;
import com.baidu.tieba.du6;
import com.baidu.tieba.dv6;
import com.baidu.tieba.f0;
import com.baidu.tieba.f05;
import com.baidu.tieba.fu6;
import com.baidu.tieba.g0;
import com.baidu.tieba.hu6;
import com.baidu.tieba.it6;
import com.baidu.tieba.iu6;
import com.baidu.tieba.j0;
import com.baidu.tieba.jt6;
import com.baidu.tieba.ju6;
import com.baidu.tieba.kt6;
import com.baidu.tieba.lt6;
import com.baidu.tieba.mt6;
import com.baidu.tieba.nt6;
import com.baidu.tieba.ss6;
import com.baidu.tieba.xs6;
import com.baidu.tieba.xt6;
import com.baidu.tieba.ys6;
import com.baidu.tieba.yt6;
import com.baidu.tieba.zs6;
import com.baidu.tieba.zt6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
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
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010J\u0014\u0010 \u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\"J\b\u0010#\u001a\u00020\u001eH\u0003J\u0016\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u001bH\u0002J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\b\u0010(\u001a\u00020\u001eH\u0002J\u0010\u0010)\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010J\u0016\u0010*\u001a\u00020\u001e2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00100\u001bH\u0016J\u0016\u0010,\u001a\u00020\u001e2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00100\u001bH\u0016J\u0018\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0014J\u0010\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u00020\u001eH\u0002J\u0010\u00107\u001a\u00020\u001e2\u0006\u00101\u001a\u000202H\u0016J\b\u00108\u001a\u00020\u001eH\u0002J\u0006\u00109\u001a\u00020\u001eJ\u000e\u0010:\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0012j\b\u0012\u0004\u0012\u00020\u000b`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u0019\u001a&\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00100\u0010 \u001a*\u0012\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u001b0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/baidu/tieba/danmu/ecs/system/DataSystem;", "Lcom/baidu/tieba/danmu/ecs/base/DanmakuSortedSystem;", "Lcom/baidu/tieba/danmu/data/DataSource$DataChangeListener;", "context", "Lcom/baidu/tieba/danmu/ecs/DanmakuContext;", "(Lcom/baidu/tieba/danmu/ecs/DanmakuContext;)V", "comparator", "Lcom/baidu/tieba/danmu/ecs/system/DanmakuItemComparator;", "currentData", "Lcom/baidu/tieba/danmu/ecs/system/Danmakus;", "endTimeMills", "", "entityEntryTime", "forceUpdate", "", "holdingItem", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", "idSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "pendingAddItems", "", "pendingCreateItems", "pendingUpdateItems", "shouldSort", "sortedData", "kotlin.jvm.PlatformType", "", "startTimeMills", "addItem", "", "item", "addItems", "items", "", "addPendingItems", "createEntityBeforeEntry", "", "data", "createItemEntity", "createPendingItems", "hold", "onDataAdded", "additionalItems", "onDataRemoved", "removalItems", "processEntity", "entity", "Lcom/badlogic/ashley/core/Entity;", "deltaTime", "", "removedFromEngine", "engine", "Lcom/badlogic/ashley/core/Engine;", QuickPersistConfigConst.KEY_SPLASH_SORT, StickerDataChangeType.UPDATE, "updateCurrentSlice", "updateEntities", "updateItem", "Companion", "danmu_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DataSystem extends it6 implements at6.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ys6> i;
    public du6 j;
    public final bu6 k;
    public final List<ys6> l;
    public final List<ys6> m;
    public final List<ys6> n;
    public boolean o;
    public long p;
    public long q;
    public boolean r;
    public final HashSet<Long> s;

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
    public DataSystem(dt6 context) {
        super(context, dv6.a.a(), null, 4, null);
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
                super((dt6) objArr2[0], (j0) objArr2[1], (Comparator) objArr2[2], ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.i = Collections.synchronizedList(new ArrayList());
        List synchronizedList = Collections.synchronizedList(new xs6());
        Intrinsics.checkNotNullExpressionValue(synchronizedList, "synchronizedList(TreeList())");
        this.j = new du6(synchronizedList, 0L, 0L, -1, -1, false, 32, null);
        this.k = new bu6();
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.s = new HashSet<>();
    }

    public final void A(ys6 ys6Var) {
        nt6 nt6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, ys6Var) != null) || this.s.contains(Long.valueOf(ys6Var.e().f()))) {
            return;
        }
        g0 entity = f().i();
        Intrinsics.checkNotNullExpressionValue(entity, "entity");
        if (((kt6) hu6.a(this, kt6.class, entity, ys6Var)) == null) {
            return;
        }
        if (ys6Var.e().j() > 0) {
            if (((lt6) hu6.a(this, lt6.class, entity, ys6Var)) == null) {
                return;
            }
            int j = ys6Var.e().j();
            if (j != 1) {
                if (j != 4) {
                    if (j == 5) {
                        entity.a(new yt6());
                    }
                } else {
                    entity.a(new xt6());
                }
            } else {
                entity.a(new zt6());
            }
        }
        if (!ys6Var.d().isEmpty() && (nt6Var = (nt6) hu6.a(this, nt6.class, entity, ys6Var)) != null) {
            for (mt6 it : ys6Var.d()) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                nt6Var.d(it);
            }
        }
        f().c(entity);
        this.s.add(Long.valueOf(ys6Var.e().f()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (this.o) {
                synchronized (this) {
                    List<ys6> sortedData = this.i;
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

    @Override // com.baidu.tieba.it6, com.baidu.tieba.gt6, com.baidu.tieba.i0
    public void g(f0 engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
            super.g(engine);
            this.i.clear();
        }
    }

    public final void w(ys6 item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, item) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            synchronized (this) {
                this.l.add(item);
            }
        }
    }

    public final void x(Collection<? extends ys6> items) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, items) == null) {
            Intrinsics.checkNotNullParameter(items, "items");
            synchronized (this) {
                this.l.addAll(items);
            }
        }
    }

    public final int z(List<? extends ys6> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) {
            this.m.addAll(list);
            return list.size();
        }
        return invokeL.intValue;
    }

    public final void B() {
        List<ys6> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                list = CollectionsKt___CollectionsKt.toList(this.m);
                this.m.clear();
            }
            for (ys6 ys6Var : list) {
                A(ys6Var);
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.i.isEmpty()) {
            return;
        }
        int i = 0;
        if (!f05.e()) {
            ju6.b("DataSystem_createNewSlice");
            synchronized (this) {
                List sortedData = this.i;
                Intrinsics.checkNotNullExpressionValue(sortedData, "sortedData");
                int a = fu6.a(sortedData, Long.valueOf(this.p), DataSystem$updateCurrentSlice$1$1$1.INSTANCE);
                List sortedData2 = this.i;
                Intrinsics.checkNotNullExpressionValue(sortedData2, "sortedData");
                int b = fu6.b(sortedData2, Long.valueOf(this.q), DataSystem$updateCurrentSlice$1$1$2.INSTANCE);
                if (a != -1 && b != -1 && b >= a) {
                    BdLog.w("DanmakuEngine [Data] update current slice [" + a + StringUtil.ARRAY_ELEMENT_SEPARATOR + b + "] in time (" + this.p + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.q + ')');
                    List subList = this.i.subList(a, b + 1);
                    ju6.a();
                    Unit unit = Unit.INSTANCE;
                    ju6.b("DataSystem_getCurrentEntity_" + subList.size());
                    du6 du6Var = this.j;
                    List synchronizedList = Collections.synchronizedList(fu6.c(subList));
                    Intrinsics.checkNotNullExpressionValue(synchronizedList, "synchronizedList(newData.toTreeList())");
                    this.j = new du6(synchronizedList, this.p, this.q, a, b, false, 32, null);
                    ju6.a();
                    ju6.b("DataSystem_diffAndCreateEntity");
                    if (a <= du6Var.b() && b > du6Var.d()) {
                        z(subList);
                    } else {
                        i = 0 + subList.size();
                        z(subList);
                        BdLog.d("DanmakuEngine [Data] Add all new data [" + a + StringUtil.ARRAY_ELEMENT_SEPARATOR + b + ']');
                    }
                    ju6.a();
                    BdLog.d("DanmakuEngine [Data] Add " + i + " in [" + this.p + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.q + ']');
                }
                BdLog.w("DanmakuEngine [Data] update current slice failed: invalid start or end index.");
                ju6.a();
            }
            return;
        }
        Trace.beginSection("DataSystem_updateCurrentSlice");
        ju6.b("DataSystem_createNewSlice");
        synchronized (this) {
            List sortedData3 = this.i;
            Intrinsics.checkNotNullExpressionValue(sortedData3, "sortedData");
            int a2 = fu6.a(sortedData3, Long.valueOf(this.p), DataSystem$updateCurrentSlice$1$1$1.INSTANCE);
            List sortedData4 = this.i;
            Intrinsics.checkNotNullExpressionValue(sortedData4, "sortedData");
            int b2 = fu6.b(sortedData4, Long.valueOf(this.q), DataSystem$updateCurrentSlice$1$1$2.INSTANCE);
            if (a2 != -1 && b2 != -1 && b2 >= a2) {
                BdLog.w("DanmakuEngine [Data] update current slice [" + a2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + b2 + "] in time (" + this.p + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.q + ')');
                List subList2 = this.i.subList(a2, b2 + 1);
                ju6.a();
                Unit unit2 = Unit.INSTANCE;
                ju6.b("DataSystem_getCurrentEntity_" + subList2.size());
                du6 du6Var2 = this.j;
                List synchronizedList2 = Collections.synchronizedList(fu6.c(subList2));
                Intrinsics.checkNotNullExpressionValue(synchronizedList2, "synchronizedList(newData.toTreeList())");
                this.j = new du6(synchronizedList2, this.p, this.q, a2, b2, false, 32, null);
                ju6.a();
                ju6.b("DataSystem_diffAndCreateEntity");
                if (a2 <= du6Var2.b() && b2 > du6Var2.d()) {
                    z(subList2);
                } else {
                    i = 0 + subList2.size();
                    z(subList2);
                    BdLog.d("DanmakuEngine [Data] Add all new data [" + a2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + b2 + ']');
                }
                ju6.a();
                BdLog.d("DanmakuEngine [Data] Add " + i + " in [" + this.p + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.q + ']');
            }
            BdLog.w("DanmakuEngine [Data] update current slice failed: invalid start or end index.");
            ju6.a();
        }
        Unit unit3 = Unit.INSTANCE;
        Trace.endSection();
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ss6 c = i().c();
            long max = Math.max(c.k(), c.t());
            long b = hu6.b(this) - max;
            long b2 = hu6.b(this) + max;
            hu6.b(this);
            y();
            if (!f05.e()) {
                m();
            } else {
                Trace.beginSection("DataSystem_sort");
                m();
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
            }
            if (this.r || b < this.p || hu6.b(this) > this.q - i().c().q()) {
                this.p = b;
                this.q = b2;
                C();
                this.r = false;
            }
            B();
        }
    }

    @Override // com.baidu.tieba.it6
    public void l(g0 entity, float f) {
        ys6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048581, this, entity, f) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            bv6 d = hu6.d(this);
            kt6 b = iu6.b(entity);
            if (b != null && (a = b.a()) != null) {
                jt6 d2 = iu6.d(entity);
                if (d2 == null && (d2 = (jt6) hu6.a(this, jt6.class, entity, a)) == null) {
                    return;
                }
                ss6 c = i().c();
                if (d2.c() != c.l()) {
                    d2.update(c.l(), i().e().a(a, d, c).a());
                }
            }
        }
    }

    @Override // com.baidu.tieba.it6, com.baidu.tieba.i0
    public void update(float f) {
        ys6 a;
        long k;
        ys6 a2;
        long k2;
        ys6 a3;
        long k3;
        ys6 a4;
        long k4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
            if (!f05.e()) {
                if (!f05.e()) {
                    ss6 c = i().c();
                    for (g0 g0Var : k()) {
                        kt6 b = iu6.b(g0Var);
                        if (b != null && (a4 = b.a()) != null) {
                            zs6 e = a4.e();
                            if (e.j() == 1) {
                                k4 = c.t();
                            } else {
                                k4 = c.k();
                            }
                            a4.n(k4);
                            if (iu6.h(g0Var, hu6.b(this))) {
                                if (!this.j.a().isEmpty()) {
                                    this.j.a().remove(a4);
                                }
                                this.s.remove(Long.valueOf(e.f()));
                                f().m(g0Var);
                                du6 du6Var = this.j;
                                du6Var.g(du6Var.d() + 1);
                            } else if (iu6.g(g0Var, this.q)) {
                                this.s.remove(Long.valueOf(e.f()));
                                f().m(g0Var);
                            }
                        }
                    }
                    super.update(f);
                    return;
                }
                Trace.beginSection("DataSystem_processEntity");
                ss6 c2 = i().c();
                for (g0 g0Var2 : k()) {
                    kt6 b2 = iu6.b(g0Var2);
                    if (b2 != null && (a3 = b2.a()) != null) {
                        zs6 e2 = a3.e();
                        if (e2.j() == 1) {
                            k3 = c2.t();
                        } else {
                            k3 = c2.k();
                        }
                        a3.n(k3);
                        if (iu6.h(g0Var2, hu6.b(this))) {
                            if (!this.j.a().isEmpty()) {
                                this.j.a().remove(a3);
                            }
                            this.s.remove(Long.valueOf(e2.f()));
                            f().m(g0Var2);
                            du6 du6Var2 = this.j;
                            du6Var2.g(du6Var2.d() + 1);
                        } else if (iu6.g(g0Var2, this.q)) {
                            this.s.remove(Long.valueOf(e2.f()));
                            f().m(g0Var2);
                        }
                    }
                }
                super.update(f);
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
                return;
            }
            Trace.beginSection("DataSystem_update");
            if (!f05.e()) {
                ss6 c3 = i().c();
                for (g0 g0Var3 : k()) {
                    kt6 b3 = iu6.b(g0Var3);
                    if (b3 != null && (a2 = b3.a()) != null) {
                        zs6 e3 = a2.e();
                        if (e3.j() == 1) {
                            k2 = c3.t();
                        } else {
                            k2 = c3.k();
                        }
                        a2.n(k2);
                        if (iu6.h(g0Var3, hu6.b(this))) {
                            if (!this.j.a().isEmpty()) {
                                this.j.a().remove(a2);
                            }
                            this.s.remove(Long.valueOf(e3.f()));
                            f().m(g0Var3);
                            du6 du6Var3 = this.j;
                            du6Var3.g(du6Var3.d() + 1);
                        } else if (iu6.g(g0Var3, this.q)) {
                            this.s.remove(Long.valueOf(e3.f()));
                            f().m(g0Var3);
                        }
                    }
                }
                super.update(f);
            } else {
                Trace.beginSection("DataSystem_processEntity");
                ss6 c4 = i().c();
                for (g0 g0Var4 : k()) {
                    kt6 b4 = iu6.b(g0Var4);
                    if (b4 != null && (a = b4.a()) != null) {
                        zs6 e4 = a.e();
                        if (e4.j() == 1) {
                            k = c4.t();
                        } else {
                            k = c4.k();
                        }
                        a.n(k);
                        if (iu6.h(g0Var4, hu6.b(this))) {
                            if (!this.j.a().isEmpty()) {
                                this.j.a().remove(a);
                            }
                            this.s.remove(Long.valueOf(e4.f()));
                            f().m(g0Var4);
                            du6 du6Var4 = this.j;
                            du6Var4.g(du6Var4.d() + 1);
                        } else if (iu6.g(g0Var4, this.q)) {
                            this.s.remove(Long.valueOf(e4.f()));
                            f().m(g0Var4);
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

    @WorkerThread
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
                    if (((ys6) it.next()).e().k() < this.p) {
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
                long k = ((ys6) obj).e().k();
                if (j <= k && k < j2) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    arrayList.add(obj);
                }
            }
            du6 du6Var = this.j;
            du6Var.g(du6Var.d() + i);
            du6 du6Var2 = this.j;
            du6Var2.e(du6Var2.b() + i + arrayList.size());
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : list2) {
                long j3 = this.p;
                long j4 = this.q;
                long k2 = ((ys6) obj2).e().k();
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
            du6 du6Var3 = this.j;
            du6Var3.f((du6Var3.c() || (arrayList.isEmpty() ^ true) || (arrayList2.isEmpty() ^ true)) ? true : true);
        }
    }
}
