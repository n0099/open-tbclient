package com.baidu.tieba.danmu.collection;

import androidx.core.util.Pools;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tieba.danmu.collection.OrderedRangeList;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
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
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001.B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J7\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\u00182\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\u00020\u00162\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\u0018H\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0013\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010\u001fJ0\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\u00182\u0006\u0010!\u001a\u00020\u00042\u0014\u0010\"\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u00160#J\u0006\u0010$\u001a\u00020\u0016J0\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\u00182\u0006\u0010!\u001a\u00020\u00042\u0014\u0010&\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u00040#J/\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010(J\u0016\u0010)\u001a\u00020\u001d2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0002J\u0013\u0010+\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010,J\u0014\u0010+\u001a\u00020\u001d2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\nJ\u0016\u0010-\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006/"}, d2 = {"Lcom/baidu/tieba/danmu/collection/OrderedRangeList;", ExifInterface.GPS_DIRECTION_TRUE, "", "start", "", "end", CriusAttrConstants.MARGIN, "(III)V", "dataHolderMap", "", "Lcom/baidu/tieba/danmu/collection/OrderedRangeList$Holder;", "getEnd", "()I", "setEnd", "(I)V", "holderPool", "Landroidx/core/util/Pools$SimplePool;", "holders", "", "getStart", "setStart", StickerDataChangeType.ADD, "", "place", "", "data", "(Ljava/util/List;IILjava/lang/Object;)Z", "checkContinuous", "clear", "", "contains", "(Ljava/lang/Object;)Z", "find", CloudStabilityUBCUtils.KEY_LENGTH, "predicate", "Lkotlin/Function1;", "isEmpty", "min", "selector", "obtain", "(IILjava/lang/Object;)Lcom/baidu/tieba/danmu/collection/OrderedRangeList$Holder;", "recycle", "holder", "remove", "(Ljava/lang/Object;)V", StickerDataChangeType.UPDATE, "Holder", "danmu_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class OrderedRangeList<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public final int c;
    public final Pools.SimplePool<a<T>> d;
    public final List<a<T>> e;
    public final Map<T, a<T>> f;

    /* loaded from: classes4.dex */
    public static final class a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public T c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a() {
            this(0, 0, null, 7, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    this(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), objArr[2], ((Integer) objArr[3]).intValue(), (DefaultConstructorMarker) objArr[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public a(int i, int i2, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), t};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = i2;
            this.c = t;
        }

        public /* synthetic */ a(int i, int i2, Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? -1 : i, (i3 & 2) != 0 ? -1 : i2, (i3 & 4) != 0 ? null : obj);
        }

        public final T a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.c;
            }
            return (T) invokeV.objValue;
        }

        public final int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return invokeV.intValue;
        }

        public final boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.a != -1 && this.b != -1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
        }

        public final void e(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
                this.c = t;
            }
        }

        public final void f(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                this.b = i;
            }
        }

        public final void g(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                this.a = i;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                sb.append(this.a);
                sb.append(IStringUtil.TOP_PATH);
                sb.append(this.b);
                sb.append(']');
                if (this.c == null) {
                    str = null;
                } else {
                    str = "-Data";
                }
                if (str == null) {
                    str = "";
                }
                sb.append(str);
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    public OrderedRangeList(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
        this.b = i2;
        this.c = i3;
        Pools.SimplePool<a<T>> simplePool = new Pools.SimplePool<>(100);
        for (int i6 = 0; i6 < 100; i6++) {
            simplePool.release(new a<>(0, 0, null, 7, null));
        }
        Unit unit = Unit.INSTANCE;
        this.d = simplePool;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a(g(), f(), null, 4, null));
        Unit unit2 = Unit.INSTANCE;
        this.e = arrayList;
        this.f = new LinkedHashMap();
    }

    public /* synthetic */ OrderedRangeList(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i4 & 4) != 0 ? 0 : i3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.danmu.collection.OrderedRangeList */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ a j(OrderedRangeList orderedRangeList, int i, int i2, Object obj, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            obj = null;
        }
        return orderedRangeList.i(i, i2, obj);
    }

    public final boolean a(List<a<T>> place, int i, int i2, T t) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{place, Integer.valueOf(i), Integer.valueOf(i2), t})) == null) {
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
                if (!z || i < ((a) CollectionsKt___CollectionsKt.first((List<? extends Object>) place)).d() || i2 > ((a) CollectionsKt___CollectionsKt.last((List<? extends Object>) place)).b() || i >= i2 || !b(place)) {
                    return false;
                }
                int d = ((a) CollectionsKt___CollectionsKt.first((List<? extends Object>) place)).d();
                int b = ((a) CollectionsKt___CollectionsKt.last((List<? extends Object>) place)).b();
                List<a<T>> list = this.e;
                final Integer valueOf = Integer.valueOf(d);
                int binarySearch = CollectionsKt__CollectionsKt.binarySearch(list, 0, list.size(), new Function1<a<T>, Integer>(valueOf) { // from class: com.baidu.tieba.danmu.collection.OrderedRangeList$add$$inlined$binarySearchBy$default$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Comparable $key;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {valueOf};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$key = valueOf;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function1
                    public final Integer invoke(OrderedRangeList.a<T> aVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, aVar)) == null) {
                            return Integer.valueOf(ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(aVar.d()), this.$key));
                        }
                        return (Integer) invokeL.objValue;
                    }
                });
                if (binarySearch < 0) {
                    return false;
                }
                Iterator<T> it2 = place.iterator();
                while (it2.hasNext()) {
                    Object a2 = ((a) it2.next()).a();
                    if (a2 != null) {
                        this.f.remove(a2);
                    }
                    this.e.remove(binarySearch);
                }
                if (this.c + i2 < b) {
                    int i3 = b;
                    while (binarySearch + 1 < this.e.size() && this.e.get(binarySearch).a() == null) {
                        i3 = this.e.get(binarySearch).b();
                        k(this.e.remove(binarySearch));
                    }
                    this.e.add(binarySearch, j(this, i2 + this.c, i3, null, 4, null));
                }
                a<T> i4 = i(i, i2, t);
                this.e.add(binarySearch, i4);
                this.f.put(t, i4);
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
                    if (aVar.b() == aVar2.d() && aVar.d() < aVar2.d()) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            if (!z2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.clear();
            this.e.add(new a<>(this.a, this.b, null, 4, null));
            this.f.clear();
        }
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public final boolean d(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, t)) == null) {
            return this.f.containsKey(t);
        }
        return invokeL.booleanValue;
    }

    public final void k(a<T> aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) && this.d.release(aVar)) {
            aVar.e(null);
            aVar.g(-1);
            aVar.f(-1);
        }
    }

    public final void m(T t) {
        a<T> aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, t) != null) || (aVar = this.f.get(t)) == null) {
            return;
        }
        l(aVar);
    }

    /* JADX DEBUG: Type inference failed for r3v13. Raw type applied. Possible types: T, ? super T */
    /* JADX DEBUG: Type inference failed for r3v19. Raw type applied. Possible types: T, ? super T */
    public final List<a<T>> e(int i, Function1<? super T, Boolean> predicate) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i, predicate)) == null) {
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            if (this.e.isEmpty()) {
                List<a<T>> emptyList = Collections.emptyList();
                Intrinsics.checkNotNullExpressionValue(emptyList, "emptyList()");
                return emptyList;
            }
            int i2 = 0;
            Iterator<a<T>> it = this.e.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (predicate.invoke((T) it.next().a()).booleanValue()) {
                        break;
                    }
                    i2++;
                } else {
                    i2 = -1;
                    break;
                }
            }
            int i3 = i2;
            while (i2 >= 0 && i2 < this.e.size()) {
                if (this.e.get(i2).b() - this.e.get(i3).d() < i) {
                    i2++;
                    while (i2 < this.e.size() && !predicate.invoke((T) this.e.get(i2).a()).booleanValue()) {
                        i2++;
                        i3 = i2;
                    }
                } else {
                    return CollectionsKt___CollectionsKt.toList(this.e.subList(i3, i2 + 1));
                }
            }
            List<a<T>> emptyList2 = Collections.emptyList();
            Intrinsics.checkNotNullExpressionValue(emptyList2, "emptyList()");
            return emptyList2;
        }
        return (List) invokeIL.objValue;
    }

    public final List<a<T>> h(int i, Function1<? super T, Integer> selector) {
        InterceptResult invokeIL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i, selector)) == null) {
            Intrinsics.checkNotNullParameter(selector, "selector");
            if (this.e.isEmpty()) {
                List<a<T>> emptyList = Collections.emptyList();
                Intrinsics.checkNotNullExpressionValue(emptyList, "emptyList()");
                return emptyList;
            }
            int i2 = Integer.MAX_VALUE;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                boolean z2 = true;
                if (i3 < 0 || i3 >= this.e.size()) {
                    break;
                } else if (this.e.get(i3).b() - this.e.get(i6).d() < i) {
                    i3++;
                } else {
                    int i7 = i3 + 1;
                    List<a<T>> subList = this.e.subList(i6, i7);
                    if (!(subList instanceof Collection) || !subList.isEmpty()) {
                        Iterator<T> it = subList.iterator();
                        while (it.hasNext()) {
                            if (selector.invoke((Object) ((a) it.next()).a()).intValue() < i2) {
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
                        if (it2.hasNext()) {
                            int intValue = selector.invoke((Object) ((a) it2.next()).a()).intValue();
                            while (it2.hasNext()) {
                                int intValue2 = selector.invoke((Object) ((a) it2.next()).a()).intValue();
                                if (intValue > intValue2) {
                                    intValue = intValue2;
                                }
                            }
                            i5 = i3;
                            i2 = intValue;
                            i4 = i6;
                        } else {
                            throw new NoSuchElementException();
                        }
                    }
                    i6++;
                    i3 = i7;
                }
            }
            if (i5 >= i4) {
                return CollectionsKt___CollectionsKt.toList(this.e.subList(i4, i5 + 1));
            }
            List<a<T>> emptyList2 = Collections.emptyList();
            Intrinsics.checkNotNullExpressionValue(emptyList2, "emptyList()");
            return emptyList2;
        }
        return (List) invokeIL.objValue;
    }

    public final a<T> i(int i, int i2, T t) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, t)) == null) {
            a<T> acquire = this.d.acquire();
            if (acquire == null) {
                acquire = null;
            } else {
                acquire.g(i);
                acquire.f(i2);
                acquire.e(t);
            }
            if (acquire == null) {
                return new a<>(i, i2, t);
            }
            return acquire;
        }
        return (a) invokeIIL.objValue;
    }

    public final void l(a<T> holder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, holder) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            List<a<T>> list = this.e;
            final Integer valueOf = Integer.valueOf(holder.d());
            int binarySearch = CollectionsKt__CollectionsKt.binarySearch(list, 0, list.size(), new Function1<a<T>, Integer>(valueOf) { // from class: com.baidu.tieba.danmu.collection.OrderedRangeList$remove$$inlined$binarySearchBy$default$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Comparable $key;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {valueOf};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$key = valueOf;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Integer invoke(OrderedRangeList.a<T> aVar) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, aVar)) == null) {
                        return Integer.valueOf(ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(aVar.d()), this.$key));
                    }
                    return (Integer) invokeL.objValue;
                }
            });
            if (binarySearch < 0) {
                return;
            }
            int d = holder.d();
            int b = holder.b();
            if (binarySearch > 0) {
                a<T> aVar = this.e.get(binarySearch - 1);
                if (aVar.a() == null) {
                    d = aVar.d();
                    binarySearch--;
                    this.e.remove(binarySearch);
                    k(aVar);
                }
            }
            int i = d;
            T a2 = holder.a();
            if (a2 != null) {
                this.f.remove(a2);
            }
            this.e.remove(binarySearch);
            k(holder);
            if (binarySearch < this.e.size()) {
                a<T> aVar2 = this.e.get(binarySearch);
                if (aVar2.a() == null) {
                    b = aVar2.b();
                    this.e.remove(binarySearch);
                    k(aVar2);
                }
            }
            this.e.add(binarySearch, j(this, i, b, null, 4, null));
        }
    }

    public final void update(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            this.a = i;
            this.b = i2;
            c();
        }
    }
}
