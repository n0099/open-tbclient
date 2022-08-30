package com.baidu.tieba.danmu.ecs.system;

import android.os.Trace;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.tieba.a36;
import com.baidu.tieba.a46;
import com.baidu.tieba.b36;
import com.baidu.tieba.c36;
import com.baidu.tieba.d36;
import com.baidu.tieba.e36;
import com.baidu.tieba.j26;
import com.baidu.tieba.mn4;
import com.baidu.tieba.n0;
import com.baidu.tieba.o0;
import com.baidu.tieba.o26;
import com.baidu.tieba.o36;
import com.baidu.tieba.p26;
import com.baidu.tieba.p36;
import com.baidu.tieba.q26;
import com.baidu.tieba.q36;
import com.baidu.tieba.r0;
import com.baidu.tieba.r26;
import com.baidu.tieba.s36;
import com.baidu.tieba.s46;
import com.baidu.tieba.u26;
import com.baidu.tieba.u36;
import com.baidu.tieba.u46;
import com.baidu.tieba.w36;
import com.baidu.tieba.y36;
import com.baidu.tieba.z26;
import com.baidu.tieba.z36;
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
public final class DataSystem extends z26 implements r26.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<p26> i;
    public u36 j;
    public final s36 k;
    public final List<p26> l;
    public final List<p26> m;
    public final List<p26> n;
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
    public DataSystem(u26 context) {
        super(context, u46.a.a(), null, 4, null);
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
                super((u26) objArr2[0], (r0) objArr2[1], (Comparator) objArr2[2], ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.i = Collections.synchronizedList(new ArrayList());
        List synchronizedList = Collections.synchronizedList(new o26());
        Intrinsics.checkNotNullExpressionValue(synchronizedList, "synchronizedList(TreeList())");
        this.j = new u36(synchronizedList, 0L, 0L, -1, -1, false, 32, null);
        this.k = new s36();
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
                    List<p26> sortedData = this.i;
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

    public final void A(p26 p26Var) {
        e36 e36Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, p26Var) == null) || this.s.contains(Long.valueOf(p26Var.e().f()))) {
            return;
        }
        o0 entity = f().i();
        Intrinsics.checkNotNullExpressionValue(entity, "entity");
        if (((b36) y36.a(this, b36.class, entity, p26Var)) == null) {
            return;
        }
        if (p26Var.e().j() > 0) {
            if (((c36) y36.a(this, c36.class, entity, p26Var)) == null) {
                return;
            }
            int j = p26Var.e().j();
            if (j == 1) {
                entity.a(new q36());
            } else if (j == 4) {
                entity.a(new o36());
            } else if (j == 5) {
                entity.a(new p36());
            }
        }
        if (!p26Var.d().isEmpty() && (e36Var = (e36) y36.a(this, e36.class, entity, p26Var)) != null) {
            for (d36 it : p26Var.d()) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                e36Var.d(it);
            }
        }
        f().c(entity);
        this.s.add(Long.valueOf(p26Var.e().f()));
    }

    public final void B() {
        List<p26> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                list = CollectionsKt___CollectionsKt.toList(this.m);
                this.m.clear();
            }
            for (p26 p26Var : list) {
                A(p26Var);
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.i.isEmpty()) {
            return;
        }
        int i = 0;
        if (!mn4.e()) {
            a46.b("DataSystem_createNewSlice");
            synchronized (this) {
                List sortedData = this.i;
                Intrinsics.checkNotNullExpressionValue(sortedData, "sortedData");
                int a = w36.a(sortedData, Long.valueOf(this.p), DataSystem$updateCurrentSlice$1$1$1.INSTANCE);
                List sortedData2 = this.i;
                Intrinsics.checkNotNullExpressionValue(sortedData2, "sortedData");
                int b = w36.b(sortedData2, Long.valueOf(this.q), DataSystem$updateCurrentSlice$1$1$2.INSTANCE);
                if (a != -1 && b != -1 && b >= a) {
                    BdLog.w("DanmakuEngine [Data] update current slice [" + a + StringUtil.ARRAY_ELEMENT_SEPARATOR + b + "] in time (" + this.p + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.q + ')');
                    List subList = this.i.subList(a, b + 1);
                    a46.a();
                    Unit unit = Unit.INSTANCE;
                    a46.b(Intrinsics.stringPlus("DataSystem_getCurrentEntity_", Integer.valueOf(subList.size())));
                    u36 u36Var = this.j;
                    List synchronizedList = Collections.synchronizedList(w36.c(subList));
                    Intrinsics.checkNotNullExpressionValue(synchronizedList, "synchronizedList(newData.toTreeList())");
                    this.j = new u36(synchronizedList, this.p, this.q, a, b, false, 32, null);
                    a46.a();
                    a46.b("DataSystem_diffAndCreateEntity");
                    if (a <= u36Var.b() && b > u36Var.d()) {
                        z(subList);
                    } else {
                        i = 0 + subList.size();
                        z(subList);
                        BdLog.d("DanmakuEngine [Data] Add all new data [" + a + StringUtil.ARRAY_ELEMENT_SEPARATOR + b + ']');
                    }
                    a46.a();
                    BdLog.d("DanmakuEngine [Data] Add " + i + " in [" + this.p + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.q + ']');
                }
                BdLog.w("DanmakuEngine [Data] update current slice failed: invalid start or end index.");
                a46.a();
            }
            return;
        }
        Trace.beginSection("DataSystem_updateCurrentSlice");
        a46.b("DataSystem_createNewSlice");
        synchronized (this) {
            List sortedData3 = this.i;
            Intrinsics.checkNotNullExpressionValue(sortedData3, "sortedData");
            int a2 = w36.a(sortedData3, Long.valueOf(this.p), DataSystem$updateCurrentSlice$1$1$1.INSTANCE);
            List sortedData4 = this.i;
            Intrinsics.checkNotNullExpressionValue(sortedData4, "sortedData");
            int b2 = w36.b(sortedData4, Long.valueOf(this.q), DataSystem$updateCurrentSlice$1$1$2.INSTANCE);
            if (a2 != -1 && b2 != -1 && b2 >= a2) {
                BdLog.w("DanmakuEngine [Data] update current slice [" + a2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + b2 + "] in time (" + this.p + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.q + ')');
                List subList2 = this.i.subList(a2, b2 + 1);
                a46.a();
                Unit unit2 = Unit.INSTANCE;
                a46.b(Intrinsics.stringPlus("DataSystem_getCurrentEntity_", Integer.valueOf(subList2.size())));
                u36 u36Var2 = this.j;
                List synchronizedList2 = Collections.synchronizedList(w36.c(subList2));
                Intrinsics.checkNotNullExpressionValue(synchronizedList2, "synchronizedList(newData.toTreeList())");
                this.j = new u36(synchronizedList2, this.p, this.q, a2, b2, false, 32, null);
                a46.a();
                a46.b("DataSystem_diffAndCreateEntity");
                if (a2 <= u36Var2.b() && b2 > u36Var2.d()) {
                    z(subList2);
                } else {
                    i = 0 + subList2.size();
                    z(subList2);
                    BdLog.d("DanmakuEngine [Data] Add all new data [" + a2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + b2 + ']');
                }
                a46.a();
                BdLog.d("DanmakuEngine [Data] Add " + i + " in [" + this.p + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.q + ']');
            }
            BdLog.w("DanmakuEngine [Data] update current slice failed: invalid start or end index.");
            a46.a();
        }
        Unit unit3 = Unit.INSTANCE;
        Trace.endSection();
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            j26 c = i().c();
            long max = Math.max(c.k(), c.t());
            long b = y36.b(this) - max;
            long b2 = y36.b(this) + max;
            y36.b(this);
            y();
            if (!mn4.e()) {
                m();
            } else {
                Trace.beginSection("DataSystem_sort");
                m();
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
            }
            if (this.r || b < this.p || y36.b(this) > this.q - i().c().q()) {
                this.p = b;
                this.q = b2;
                C();
                this.r = false;
            }
            B();
        }
    }

    @Override // com.baidu.tieba.z26, com.baidu.tieba.x26, com.baidu.tieba.q0
    public void g(n0 engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
            super.g(engine);
            this.i.clear();
        }
    }

    @Override // com.baidu.tieba.z26
    public void l(o0 entity, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048581, this, entity, f) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            s46 d = y36.d(this);
            b36 b = z36.b(entity);
            p26 a = b == null ? null : b.a();
            if (a == null) {
                return;
            }
            a36 d2 = z36.d(entity);
            if (d2 == null && (d2 = (a36) y36.a(this, a36.class, entity, a)) == null) {
                return;
            }
            j26 c = i().c();
            if (d2.c() != c.l()) {
                d2.update(c.l(), i().e().a(a, d, c).a());
            }
        }
    }

    @Override // com.baidu.tieba.z26, com.baidu.tieba.q0
    public void update(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
            if (!mn4.e()) {
                if (!mn4.e()) {
                    j26 c = i().c();
                    for (o0 o0Var : k()) {
                        b36 b = z36.b(o0Var);
                        p26 a = b == null ? null : b.a();
                        if (a != null) {
                            q26 e = a.e();
                            a.m(e.j() == 1 ? c.t() : c.k());
                            if (z36.h(o0Var, y36.b(this))) {
                                if (!this.j.a().isEmpty()) {
                                    this.j.a().remove(a);
                                }
                                this.s.remove(Long.valueOf(e.f()));
                                f().m(o0Var);
                                u36 u36Var = this.j;
                                u36Var.g(u36Var.d() + 1);
                            } else if (z36.g(o0Var, this.q)) {
                                this.s.remove(Long.valueOf(e.f()));
                                f().m(o0Var);
                            }
                        }
                    }
                    super.update(f);
                    return;
                }
                Trace.beginSection("DataSystem_processEntity");
                j26 c2 = i().c();
                for (o0 o0Var2 : k()) {
                    b36 b2 = z36.b(o0Var2);
                    p26 a2 = b2 == null ? null : b2.a();
                    if (a2 != null) {
                        q26 e2 = a2.e();
                        a2.m(e2.j() == 1 ? c2.t() : c2.k());
                        if (z36.h(o0Var2, y36.b(this))) {
                            if (!this.j.a().isEmpty()) {
                                this.j.a().remove(a2);
                            }
                            this.s.remove(Long.valueOf(e2.f()));
                            f().m(o0Var2);
                            u36 u36Var2 = this.j;
                            u36Var2.g(u36Var2.d() + 1);
                        } else if (z36.g(o0Var2, this.q)) {
                            this.s.remove(Long.valueOf(e2.f()));
                            f().m(o0Var2);
                        }
                    }
                }
                super.update(f);
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
                return;
            }
            Trace.beginSection("DataSystem_update");
            if (!mn4.e()) {
                j26 c3 = i().c();
                for (o0 o0Var3 : k()) {
                    b36 b3 = z36.b(o0Var3);
                    p26 a3 = b3 == null ? null : b3.a();
                    if (a3 != null) {
                        q26 e3 = a3.e();
                        a3.m(e3.j() == 1 ? c3.t() : c3.k());
                        if (z36.h(o0Var3, y36.b(this))) {
                            if (!this.j.a().isEmpty()) {
                                this.j.a().remove(a3);
                            }
                            this.s.remove(Long.valueOf(e3.f()));
                            f().m(o0Var3);
                            u36 u36Var3 = this.j;
                            u36Var3.g(u36Var3.d() + 1);
                        } else if (z36.g(o0Var3, this.q)) {
                            this.s.remove(Long.valueOf(e3.f()));
                            f().m(o0Var3);
                        }
                    }
                }
                super.update(f);
            } else {
                Trace.beginSection("DataSystem_processEntity");
                j26 c4 = i().c();
                for (o0 o0Var4 : k()) {
                    b36 b4 = z36.b(o0Var4);
                    p26 a4 = b4 == null ? null : b4.a();
                    if (a4 != null) {
                        q26 e4 = a4.e();
                        a4.m(e4.j() == 1 ? c4.t() : c4.k());
                        if (z36.h(o0Var4, y36.b(this))) {
                            if (!this.j.a().isEmpty()) {
                                this.j.a().remove(a4);
                            }
                            this.s.remove(Long.valueOf(e4.f()));
                            f().m(o0Var4);
                            u36 u36Var4 = this.j;
                            u36Var4.g(u36Var4.d() + 1);
                        } else if (z36.g(o0Var4, this.q)) {
                            this.s.remove(Long.valueOf(e4.f()));
                            f().m(o0Var4);
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

    public final void w(p26 item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, item) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            synchronized (this) {
                this.l.add(item);
            }
        }
    }

    public final void x(Collection<? extends p26> items) {
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
                    if ((((p26) it.next()).e().k() < this.p) && (i = i + 1) < 0) {
                        CollectionsKt__CollectionsKt.throwCountOverflow();
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                long j = this.p;
                long j2 = this.q;
                long k = ((p26) obj).e().k();
                if (j <= k && k < j2) {
                    arrayList.add(obj);
                }
            }
            u36 u36Var = this.j;
            u36Var.g(u36Var.d() + i);
            u36 u36Var2 = this.j;
            u36Var2.e(u36Var2.b() + i + arrayList.size());
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : list2) {
                long j3 = this.p;
                long j4 = this.q;
                long k2 = ((p26) obj2).e().k();
                if (j3 <= k2 && k2 < j4) {
                    arrayList2.add(obj2);
                }
            }
            this.j.a().removeAll(arrayList2);
            this.j.a().addAll(arrayList2);
            this.j.a().addAll(arrayList);
            this.m.addAll(arrayList);
            this.o = (list.isEmpty() ^ true) || (list2.isEmpty() ^ true);
            u36 u36Var3 = this.j;
            u36Var3.f((u36Var3.c() || (arrayList.isEmpty() ^ true) || (arrayList2.isEmpty() ^ true)) ? true : true);
        }
    }

    public final int z(List<? extends p26> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) {
            this.m.addAll(list);
            return list.size();
        }
        return invokeL.intValue;
    }
}
