package com.baidu.tieba.danmu.ecs.system;

import android.os.Trace;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.a06;
import com.repackage.f06;
import com.repackage.f16;
import com.repackage.fn4;
import com.repackage.g06;
import com.repackage.g16;
import com.repackage.h06;
import com.repackage.h16;
import com.repackage.i06;
import com.repackage.j16;
import com.repackage.j26;
import com.repackage.k0;
import com.repackage.l0;
import com.repackage.l06;
import com.repackage.l16;
import com.repackage.l26;
import com.repackage.n16;
import com.repackage.o0;
import com.repackage.p16;
import com.repackage.q06;
import com.repackage.q16;
import com.repackage.r06;
import com.repackage.r16;
import com.repackage.s06;
import com.repackage.t06;
import com.repackage.u06;
import com.repackage.v06;
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
public final class DataSystem extends q06 implements i06.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<g06> i;
    public l16 j;
    public final j16 k;
    public final List<g06> l;
    public final List<g06> m;
    public final List<g06> n;
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
    public DataSystem(l06 context) {
        super(context, l26.a.a(), null, 4, null);
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
                super((l06) objArr2[0], (o0) objArr2[1], (Comparator) objArr2[2], ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.i = Collections.synchronizedList(new ArrayList());
        List synchronizedList = Collections.synchronizedList(new f06());
        Intrinsics.checkNotNullExpressionValue(synchronizedList, "synchronizedList(TreeList())");
        this.j = new l16(synchronizedList, 0L, 0L, -1, -1, false, 32, null);
        this.k = new j16();
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.s = new HashSet<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (this.o) {
                synchronized (this) {
                    List<g06> sortedData = this.i;
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

    public final void A(g06 g06Var) {
        v06 v06Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, g06Var) == null) || this.s.contains(Long.valueOf(g06Var.e().f()))) {
            return;
        }
        l0 entity = f().i();
        Intrinsics.checkNotNullExpressionValue(entity, "entity");
        if (((s06) p16.a(this, s06.class, entity, g06Var)) == null) {
            return;
        }
        if (g06Var.e().j() > 0) {
            if (((t06) p16.a(this, t06.class, entity, g06Var)) == null) {
                return;
            }
            int j = g06Var.e().j();
            if (j == 1) {
                entity.a(new h16());
            } else if (j == 4) {
                entity.a(new f16());
            } else if (j == 5) {
                entity.a(new g16());
            }
        }
        if (!g06Var.d().isEmpty() && (v06Var = (v06) p16.a(this, v06.class, entity, g06Var)) != null) {
            for (u06 it : g06Var.d()) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                v06Var.d(it);
            }
        }
        f().c(entity);
        this.s.add(Long.valueOf(g06Var.e().f()));
    }

    public final void B() {
        List<g06> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                list = CollectionsKt___CollectionsKt.toList(this.m);
                this.m.clear();
            }
            for (g06 g06Var : list) {
                A(g06Var);
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.i.isEmpty()) {
            return;
        }
        int i = 0;
        if (!fn4.e()) {
            r16.b("DataSystem_createNewSlice");
            synchronized (this) {
                List sortedData = this.i;
                Intrinsics.checkNotNullExpressionValue(sortedData, "sortedData");
                int a = n16.a(sortedData, Long.valueOf(this.p), DataSystem$updateCurrentSlice$1$1$1.INSTANCE);
                List sortedData2 = this.i;
                Intrinsics.checkNotNullExpressionValue(sortedData2, "sortedData");
                int b = n16.b(sortedData2, Long.valueOf(this.q), DataSystem$updateCurrentSlice$1$1$2.INSTANCE);
                if (a != -1 && b != -1 && b >= a) {
                    BdLog.w("DanmakuEngine [Data] update current slice [" + a + StringUtil.ARRAY_ELEMENT_SEPARATOR + b + "] in time (" + this.p + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.q + ')');
                    List subList = this.i.subList(a, b + 1);
                    r16.a();
                    Unit unit = Unit.INSTANCE;
                    r16.b(Intrinsics.stringPlus("DataSystem_getCurrentEntity_", Integer.valueOf(subList.size())));
                    l16 l16Var = this.j;
                    List synchronizedList = Collections.synchronizedList(n16.c(subList));
                    Intrinsics.checkNotNullExpressionValue(synchronizedList, "synchronizedList(newData.toTreeList())");
                    this.j = new l16(synchronizedList, this.p, this.q, a, b, false, 32, null);
                    r16.a();
                    r16.b("DataSystem_diffAndCreateEntity");
                    if (a <= l16Var.b() && b > l16Var.d()) {
                        z(subList);
                    } else {
                        i = 0 + subList.size();
                        z(subList);
                        BdLog.d("DanmakuEngine [Data] Add all new data [" + a + StringUtil.ARRAY_ELEMENT_SEPARATOR + b + ']');
                    }
                    r16.a();
                    BdLog.d("DanmakuEngine [Data] Add " + i + " in [" + this.p + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.q + ']');
                }
                BdLog.w("DanmakuEngine [Data] update current slice failed: invalid start or end index.");
                r16.a();
            }
            return;
        }
        Trace.beginSection("DataSystem_updateCurrentSlice");
        r16.b("DataSystem_createNewSlice");
        synchronized (this) {
            List sortedData3 = this.i;
            Intrinsics.checkNotNullExpressionValue(sortedData3, "sortedData");
            int a2 = n16.a(sortedData3, Long.valueOf(this.p), DataSystem$updateCurrentSlice$1$1$1.INSTANCE);
            List sortedData4 = this.i;
            Intrinsics.checkNotNullExpressionValue(sortedData4, "sortedData");
            int b2 = n16.b(sortedData4, Long.valueOf(this.q), DataSystem$updateCurrentSlice$1$1$2.INSTANCE);
            if (a2 != -1 && b2 != -1 && b2 >= a2) {
                BdLog.w("DanmakuEngine [Data] update current slice [" + a2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + b2 + "] in time (" + this.p + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.q + ')');
                List subList2 = this.i.subList(a2, b2 + 1);
                r16.a();
                Unit unit2 = Unit.INSTANCE;
                r16.b(Intrinsics.stringPlus("DataSystem_getCurrentEntity_", Integer.valueOf(subList2.size())));
                l16 l16Var2 = this.j;
                List synchronizedList2 = Collections.synchronizedList(n16.c(subList2));
                Intrinsics.checkNotNullExpressionValue(synchronizedList2, "synchronizedList(newData.toTreeList())");
                this.j = new l16(synchronizedList2, this.p, this.q, a2, b2, false, 32, null);
                r16.a();
                r16.b("DataSystem_diffAndCreateEntity");
                if (a2 <= l16Var2.b() && b2 > l16Var2.d()) {
                    z(subList2);
                } else {
                    i = 0 + subList2.size();
                    z(subList2);
                    BdLog.d("DanmakuEngine [Data] Add all new data [" + a2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + b2 + ']');
                }
                r16.a();
                BdLog.d("DanmakuEngine [Data] Add " + i + " in [" + this.p + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.q + ']');
            }
            BdLog.w("DanmakuEngine [Data] update current slice failed: invalid start or end index.");
            r16.a();
        }
        Unit unit3 = Unit.INSTANCE;
        Trace.endSection();
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a06 c = i().c();
            long max = Math.max(c.k(), c.t());
            long b = p16.b(this) - max;
            long b2 = p16.b(this) + max;
            p16.b(this);
            y();
            if (!fn4.e()) {
                m();
            } else {
                Trace.beginSection("DataSystem_sort");
                m();
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
            }
            if (this.r || b < this.p || p16.b(this) > this.q - i().c().q()) {
                this.p = b;
                this.q = b2;
                C();
                this.r = false;
            }
            B();
        }
    }

    @Override // com.repackage.q06, com.repackage.o06, com.repackage.n0
    public void g(k0 engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
            super.g(engine);
            this.i.clear();
        }
    }

    @Override // com.repackage.q06
    public void l(l0 entity, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048581, this, entity, f) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            j26 d = p16.d(this);
            s06 b = q16.b(entity);
            g06 a = b == null ? null : b.a();
            if (a == null) {
                return;
            }
            r06 d2 = q16.d(entity);
            if (d2 == null && (d2 = (r06) p16.a(this, r06.class, entity, a)) == null) {
                return;
            }
            a06 c = i().c();
            if (d2.c() != c.l()) {
                d2.update(c.l(), i().e().a(a, d, c).a());
            }
        }
    }

    @Override // com.repackage.q06, com.repackage.n0
    public void update(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
            if (!fn4.e()) {
                if (!fn4.e()) {
                    a06 c = i().c();
                    for (l0 l0Var : k()) {
                        s06 b = q16.b(l0Var);
                        g06 a = b == null ? null : b.a();
                        if (a != null) {
                            h06 e = a.e();
                            a.m(e.j() == 1 ? c.t() : c.k());
                            if (q16.h(l0Var, p16.b(this))) {
                                if (!this.j.a().isEmpty()) {
                                    this.j.a().remove(a);
                                }
                                this.s.remove(Long.valueOf(e.f()));
                                f().m(l0Var);
                                l16 l16Var = this.j;
                                l16Var.g(l16Var.d() + 1);
                            } else if (q16.g(l0Var, this.q)) {
                                this.s.remove(Long.valueOf(e.f()));
                                f().m(l0Var);
                            }
                        }
                    }
                    super.update(f);
                    return;
                }
                Trace.beginSection("DataSystem_processEntity");
                a06 c2 = i().c();
                for (l0 l0Var2 : k()) {
                    s06 b2 = q16.b(l0Var2);
                    g06 a2 = b2 == null ? null : b2.a();
                    if (a2 != null) {
                        h06 e2 = a2.e();
                        a2.m(e2.j() == 1 ? c2.t() : c2.k());
                        if (q16.h(l0Var2, p16.b(this))) {
                            if (!this.j.a().isEmpty()) {
                                this.j.a().remove(a2);
                            }
                            this.s.remove(Long.valueOf(e2.f()));
                            f().m(l0Var2);
                            l16 l16Var2 = this.j;
                            l16Var2.g(l16Var2.d() + 1);
                        } else if (q16.g(l0Var2, this.q)) {
                            this.s.remove(Long.valueOf(e2.f()));
                            f().m(l0Var2);
                        }
                    }
                }
                super.update(f);
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
                return;
            }
            Trace.beginSection("DataSystem_update");
            if (!fn4.e()) {
                a06 c3 = i().c();
                for (l0 l0Var3 : k()) {
                    s06 b3 = q16.b(l0Var3);
                    g06 a3 = b3 == null ? null : b3.a();
                    if (a3 != null) {
                        h06 e3 = a3.e();
                        a3.m(e3.j() == 1 ? c3.t() : c3.k());
                        if (q16.h(l0Var3, p16.b(this))) {
                            if (!this.j.a().isEmpty()) {
                                this.j.a().remove(a3);
                            }
                            this.s.remove(Long.valueOf(e3.f()));
                            f().m(l0Var3);
                            l16 l16Var3 = this.j;
                            l16Var3.g(l16Var3.d() + 1);
                        } else if (q16.g(l0Var3, this.q)) {
                            this.s.remove(Long.valueOf(e3.f()));
                            f().m(l0Var3);
                        }
                    }
                }
                super.update(f);
            } else {
                Trace.beginSection("DataSystem_processEntity");
                a06 c4 = i().c();
                for (l0 l0Var4 : k()) {
                    s06 b4 = q16.b(l0Var4);
                    g06 a4 = b4 == null ? null : b4.a();
                    if (a4 != null) {
                        h06 e4 = a4.e();
                        a4.m(e4.j() == 1 ? c4.t() : c4.k());
                        if (q16.h(l0Var4, p16.b(this))) {
                            if (!this.j.a().isEmpty()) {
                                this.j.a().remove(a4);
                            }
                            this.s.remove(Long.valueOf(e4.f()));
                            f().m(l0Var4);
                            l16 l16Var4 = this.j;
                            l16Var4.g(l16Var4.d() + 1);
                        } else if (q16.g(l0Var4, this.q)) {
                            this.s.remove(Long.valueOf(e4.f()));
                            f().m(l0Var4);
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

    public final void w(g06 item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, item) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            synchronized (this) {
                this.l.add(item);
            }
        }
    }

    public final void x(Collection<? extends g06> items) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, items) == null) {
            Intrinsics.checkNotNullParameter(items, "items");
            synchronized (this) {
                this.l.addAll(items);
            }
        }
    }

    @WorkerThread
    public final void y() {
        List list;
        List list2;
        int i;
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
            boolean z = false;
            if ((list instanceof Collection) && list.isEmpty()) {
                i = 0;
            } else {
                Iterator it = list.iterator();
                i = 0;
                while (it.hasNext()) {
                    if ((((g06) it.next()).e().k() < this.p) && (i = i + 1) < 0) {
                        CollectionsKt__CollectionsKt.throwCountOverflow();
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                long j = this.p;
                long j2 = this.q;
                long k = ((g06) obj).e().k();
                if (j <= k && k < j2) {
                    arrayList.add(obj);
                }
            }
            l16 l16Var = this.j;
            l16Var.g(l16Var.d() + i);
            l16 l16Var2 = this.j;
            l16Var2.e(l16Var2.b() + i + arrayList.size());
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : list2) {
                long j3 = this.p;
                long j4 = this.q;
                long k2 = ((g06) obj2).e().k();
                if (j3 <= k2 && k2 < j4) {
                    arrayList2.add(obj2);
                }
            }
            this.j.a().removeAll(arrayList2);
            this.j.a().addAll(arrayList2);
            this.j.a().addAll(arrayList);
            this.m.addAll(arrayList);
            this.o = (list.isEmpty() ^ true) || (list2.isEmpty() ^ true);
            l16 l16Var3 = this.j;
            l16Var3.f((l16Var3.c() || (arrayList.isEmpty() ^ true) || (arrayList2.isEmpty() ^ true)) ? true : true);
        }
    }

    public final int z(List<? extends g06> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) {
            this.m.addAll(list);
            return list.size();
        }
        return invokeL.intValue;
    }
}
