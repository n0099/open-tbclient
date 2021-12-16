package com.baidu.tieba.danmu.collection;

import androidx.core.util.Pools;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001.B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J7\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\u00182\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\u00020\u00162\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\u0018H\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0013\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010\u001fJ0\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\u00182\u0006\u0010!\u001a\u00020\u00042\u0014\u0010\"\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u00160#J\u0006\u0010$\u001a\u00020\u0016J0\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\u00182\u0006\u0010!\u001a\u00020\u00042\u0014\u0010&\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u00040#J/\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010(J\u0016\u0010)\u001a\u00020\u001d2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0002J\u0013\u0010+\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010,J\u0014\u0010+\u001a\u00020\u001d2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\nJ\u0016\u0010-\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006/"}, d2 = {"Lcom/baidu/tieba/danmu/collection/OrderedRangeList;", "T", "", "start", "", "end", AnimationProperty.MARGIN, "(III)V", "dataHolderMap", "", "Lcom/baidu/tieba/danmu/collection/OrderedRangeList$Holder;", "getEnd", "()I", "setEnd", "(I)V", "holderPool", "Landroidx/core/util/Pools$SimplePool;", "holders", "", "getStart", "setStart", "add", "", "place", "", "data", "(Ljava/util/List;IILjava/lang/Object;)Z", "checkContinuous", "clear", "", "contains", "(Ljava/lang/Object;)Z", "find", "length", "predicate", "Lkotlin/Function1;", "isEmpty", "min", "selector", "obtain", "(IILjava/lang/Object;)Lcom/baidu/tieba/danmu/collection/OrderedRangeList$Holder;", "recycle", "holder", "remove", "(Ljava/lang/Object;)V", "update", "Holder", "danmu_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class OrderedRangeList<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f43826b;

    /* renamed from: c  reason: collision with root package name */
    public final int f43827c;

    /* renamed from: d  reason: collision with root package name */
    public final Pools.SimplePool<a<T>> f43828d;

    /* renamed from: e  reason: collision with root package name */
    public final List<a<T>> f43829e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<T, a<T>> f43830f;

    public OrderedRangeList(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i2;
        this.f43826b = i3;
        this.f43827c = i4;
        Pools.SimplePool<a<T>> simplePool = new Pools.SimplePool<>(100);
        for (int i7 = 0; i7 < 100; i7++) {
            simplePool.release(new a<>(0, 0, null, 7, null));
        }
        Unit unit = Unit.INSTANCE;
        this.f43828d = simplePool;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a(g(), f(), null, 4, null));
        Unit unit2 = Unit.INSTANCE;
        this.f43829e = arrayList;
        this.f43830f = new LinkedHashMap();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.danmu.collection.OrderedRangeList */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ a j(OrderedRangeList orderedRangeList, int i2, int i3, Object obj, int i4, Object obj2) {
        if ((i4 & 4) != 0) {
            obj = null;
        }
        return orderedRangeList.i(i2, i3, obj);
    }

    public final boolean a(List<a<T>> place, int i2, int i3, T t) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{place, Integer.valueOf(i2), Integer.valueOf(i3), t})) == null) {
            Intrinsics.checkNotNullParameter(place, "place");
            if (!place.isEmpty()) {
                if (!(place instanceof Collection) || !place.isEmpty()) {
                    Iterator<T> it = place.iterator();
                    while (it.hasNext()) {
                        if (!((a) it.next()).c()) {
                            z = false;
                            break;
                        }
                    }
                }
                z = true;
                if (!z || i2 < ((a) CollectionsKt___CollectionsKt.first((List<? extends Object>) place)).d() || i3 > ((a) CollectionsKt___CollectionsKt.last((List<? extends Object>) place)).b() || i2 >= i3 || !b(place)) {
                    return false;
                }
                int d2 = ((a) CollectionsKt___CollectionsKt.first((List<? extends Object>) place)).d();
                int b2 = ((a) CollectionsKt___CollectionsKt.last((List<? extends Object>) place)).b();
                List<a<T>> list = this.f43829e;
                int binarySearch = CollectionsKt__CollectionsKt.binarySearch(list, 0, list.size(), new OrderedRangeList$add$$inlined$binarySearchBy$default$1(Integer.valueOf(d2)));
                if (binarySearch < 0) {
                    return false;
                }
                Iterator<T> it2 = place.iterator();
                while (it2.hasNext()) {
                    Object a2 = ((a) it2.next()).a();
                    if (a2 != null) {
                        this.f43830f.remove(a2);
                    }
                    this.f43829e.remove(binarySearch);
                }
                if (this.f43827c + i3 < b2) {
                    int i4 = b2;
                    while (binarySearch + 1 < this.f43829e.size() && this.f43829e.get(binarySearch).a() == null) {
                        i4 = this.f43829e.get(binarySearch).b();
                        k(this.f43829e.remove(binarySearch));
                    }
                    this.f43829e.add(binarySearch, j(this, i3 + this.f43827c, i4, null, 4, null));
                }
                a<T> i5 = i(i2, i3, t);
                this.f43829e.add(binarySearch, i5);
                this.f43830f.put(t, i5);
                for (a<T> aVar : place) {
                    k(aVar);
                }
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean b(List<a<T>> list) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            List<Pair> zipWithNext = CollectionsKt___CollectionsKt.zipWithNext(list);
            if (!(zipWithNext instanceof Collection) || !zipWithNext.isEmpty()) {
                for (Pair pair : zipWithNext) {
                    a aVar = (a) pair.component1();
                    a aVar2 = (a) pair.component2();
                    if (aVar.b() != aVar2.d() || aVar.d() >= aVar2.d()) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            return !z2;
        }
        return invokeL.booleanValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f43829e.clear();
            this.f43829e.add(new a<>(this.a, this.f43826b, null, 4, null));
            this.f43830f.clear();
        }
    }

    public final boolean d(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, t)) == null) ? this.f43830f.containsKey(t) : invokeL.booleanValue;
    }

    /* JADX DEBUG: Type inference failed for r3v13. Raw type applied. Possible types: T, ? super T */
    /* JADX DEBUG: Type inference failed for r3v19. Raw type applied. Possible types: T, ? super T */
    public final List<a<T>> e(int i2, Function1<? super T, Boolean> predicate) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i2, predicate)) == null) {
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            if (this.f43829e.isEmpty()) {
                List<a<T>> emptyList = Collections.emptyList();
                Intrinsics.checkNotNullExpressionValue(emptyList, "emptyList()");
                return emptyList;
            }
            int i3 = 0;
            Iterator<a<T>> it = this.f43829e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i3 = -1;
                    break;
                } else if (predicate.invoke((T) it.next().a()).booleanValue()) {
                    break;
                } else {
                    i3++;
                }
            }
            int i4 = i3;
            while (i3 >= 0 && i3 < this.f43829e.size()) {
                if (this.f43829e.get(i3).b() - this.f43829e.get(i4).d() < i2) {
                    i3++;
                    while (i3 < this.f43829e.size() && !predicate.invoke((T) this.f43829e.get(i3).a()).booleanValue()) {
                        i3++;
                        i4 = i3;
                    }
                } else {
                    return CollectionsKt___CollectionsKt.toList(this.f43829e.subList(i4, i3 + 1));
                }
            }
            List<a<T>> emptyList2 = Collections.emptyList();
            Intrinsics.checkNotNullExpressionValue(emptyList2, "emptyList()");
            return emptyList2;
        }
        return (List) invokeIL.objValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f43826b : invokeV.intValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : invokeV.intValue;
    }

    public final List<a<T>> h(int i2, Function1<? super T, Integer> selector) {
        InterceptResult invokeIL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i2, selector)) == null) {
            Intrinsics.checkNotNullParameter(selector, "selector");
            if (this.f43829e.isEmpty()) {
                List<a<T>> emptyList = Collections.emptyList();
                Intrinsics.checkNotNullExpressionValue(emptyList, "emptyList()");
                return emptyList;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                boolean z2 = true;
                if (i4 < 0 || i4 >= this.f43829e.size()) {
                    break;
                } else if (this.f43829e.get(i4).b() - this.f43829e.get(i7).d() < i2) {
                    i4++;
                } else {
                    int i8 = i4 + 1;
                    List<a<T>> subList = this.f43829e.subList(i7, i8);
                    if (!(subList instanceof Collection) || !subList.isEmpty()) {
                        Iterator<T> it = subList.iterator();
                        while (it.hasNext()) {
                            if (selector.invoke((Object) ((a) it.next()).a()).intValue() < i3) {
                                z = true;
                                continue;
                            } else {
                                z = false;
                                continue;
                            }
                            if (z) {
                                break;
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                        Iterator<T> it2 = subList.iterator();
                        if (!it2.hasNext()) {
                            throw new NoSuchElementException();
                        }
                        int intValue = selector.invoke((Object) ((a) it2.next()).a()).intValue();
                        while (it2.hasNext()) {
                            int intValue2 = selector.invoke((Object) ((a) it2.next()).a()).intValue();
                            if (intValue > intValue2) {
                                intValue = intValue2;
                            }
                        }
                        i6 = i4;
                        i3 = intValue;
                        i5 = i7;
                    }
                    i7++;
                    i4 = i8;
                }
            }
            if (i6 >= i5) {
                return CollectionsKt___CollectionsKt.toList(this.f43829e.subList(i5, i6 + 1));
            }
            List<a<T>> emptyList2 = Collections.emptyList();
            Intrinsics.checkNotNullExpressionValue(emptyList2, "emptyList()");
            return emptyList2;
        }
        return (List) invokeIL.objValue;
    }

    public final a<T> i(int i2, int i3, T t) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, t)) == null) {
            a<T> acquire = this.f43828d.acquire();
            if (acquire == null) {
                acquire = null;
            } else {
                acquire.g(i2);
                acquire.f(i3);
                acquire.e(t);
            }
            return acquire == null ? new a<>(i2, i3, t) : acquire;
        }
        return (a) invokeIIL.objValue;
    }

    public final void k(a<T> aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) && this.f43828d.release(aVar)) {
            aVar.e(null);
            aVar.g(-1);
            aVar.f(-1);
        }
    }

    public final void l(a<T> holder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, holder) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            List<a<T>> list = this.f43829e;
            int binarySearch = CollectionsKt__CollectionsKt.binarySearch(list, 0, list.size(), new OrderedRangeList$remove$$inlined$binarySearchBy$default$1(Integer.valueOf(holder.d())));
            if (binarySearch < 0) {
                return;
            }
            int d2 = holder.d();
            int b2 = holder.b();
            if (binarySearch > 0) {
                a<T> aVar = this.f43829e.get(binarySearch - 1);
                if (aVar.a() == null) {
                    d2 = aVar.d();
                    binarySearch--;
                    this.f43829e.remove(binarySearch);
                    k(aVar);
                }
            }
            int i2 = d2;
            T a2 = holder.a();
            if (a2 != null) {
                this.f43830f.remove(a2);
            }
            this.f43829e.remove(binarySearch);
            k(holder);
            if (binarySearch < this.f43829e.size()) {
                a<T> aVar2 = this.f43829e.get(binarySearch);
                if (aVar2.a() == null) {
                    b2 = aVar2.b();
                    this.f43829e.remove(binarySearch);
                    k(aVar2);
                }
            }
            this.f43829e.add(binarySearch, j(this, i2, b2, null, 4, null));
        }
    }

    public final void m(T t) {
        a<T> aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, t) == null) || (aVar = this.f43830f.get(t)) == null) {
            return;
        }
        l(aVar);
    }

    public final void update(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            this.a = i2;
            this.f43826b = i3;
            c();
        }
    }

    /* loaded from: classes11.dex */
    public static final class a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f43831b;

        /* renamed from: c  reason: collision with root package name */
        public T f43832c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a() {
            this(0, 0, null, 7, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr = newInitContext.callArgs;
                    this(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), objArr[2], ((Integer) objArr[3]).intValue(), (DefaultConstructorMarker) objArr[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public a(int i2, int i3, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), t};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i2;
            this.f43831b = i3;
            this.f43832c = t;
        }

        public final T a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f43832c : (T) invokeV.objValue;
        }

        public final int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f43831b : invokeV.intValue;
        }

        public final boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.a == -1 || this.f43831b == -1) ? false : true : invokeV.booleanValue;
        }

        public final int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.intValue;
        }

        public final void e(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
                this.f43832c = t;
            }
        }

        public final void f(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
                this.f43831b = i2;
            }
        }

        public final void g(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                this.a = i2;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                sb.append(this.a);
                sb.append(IStringUtil.TOP_PATH);
                sb.append(this.f43831b);
                sb.append(']');
                String str = this.f43832c == null ? null : "-Data";
                if (str == null) {
                    str = "";
                }
                sb.append(str);
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public /* synthetic */ a(int i2, int i3, Object obj, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? -1 : i2, (i4 & 2) != 0 ? -1 : i3, (i4 & 4) != 0 ? null : obj);
        }
    }

    public /* synthetic */ OrderedRangeList(int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, i3, (i5 & 4) != 0 ? 0 : i4);
    }
}
