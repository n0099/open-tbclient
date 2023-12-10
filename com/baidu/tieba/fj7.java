package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.AdMixFloor;
import tbclient.App;
import tbclient.BannerList;
import tbclient.FrsBottomSmartBgColor;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.FrsBottom;
import tbclient.FrsPage.HeaderCard;
import tbclient.LayoutFactory;
/* loaded from: classes5.dex */
public abstract class fj7<T> implements yi7<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract ej7 f(Object obj);

    public abstract List<LayoutFactory> g(Object obj);

    /* loaded from: classes5.dex */
    public static final class a<T> implements Comparator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, t, t2)) == null) {
                return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((AdvertAppInfo) t).position), Integer.valueOf(((AdvertAppInfo) t2).position));
            }
            return invokeLL.intValue;
        }
    }

    public fj7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.yi7
    public List<sb7<?>> c(Object originData, q67 feedData, Map<String, String> schemaLocalInfo, boolean z) {
        InterceptResult invokeCommon;
        String str;
        FrsBottomSmartBgColor frsBottomSmartBgColor;
        HeaderCard headerCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{originData, feedData, schemaLocalInfo, Boolean.valueOf(z)})) == null) {
            Intrinsics.checkNotNullParameter(originData, "originData");
            Intrinsics.checkNotNullParameter(feedData, "feedData");
            Intrinsics.checkNotNullParameter(schemaLocalInfo, "schemaLocalInfo");
            List<LayoutFactory> g = g(originData);
            ArrayList arrayList = new ArrayList();
            Iterator<LayoutFactory> it = g.iterator();
            while (true) {
                boolean z2 = false;
                if (!it.hasNext()) {
                    break;
                }
                LayoutFactory next = it.next();
                a97 a97Var = j77.a().get(next.layout);
                if (a97Var instanceof u87) {
                    ((u87) a97Var).j();
                }
                if (a97Var != null) {
                    if (a97Var instanceof va7) {
                        ((va7) a97Var).a(schemaLocalInfo);
                    }
                    if (a97Var instanceof h77) {
                        ((h77) a97Var).c(z);
                    }
                    if ((a97Var instanceof y87) && (originData instanceof DataRes)) {
                        y87 y87Var = (y87) a97Var;
                        DataRes dataRes = (DataRes) originData;
                        Integer num = dataRes.forum.is_like;
                        if (num != null && num.intValue() == 1) {
                            z2 = true;
                        }
                        y87Var.c(z2);
                        FrsBottom frsBottom = dataRes.frs_bottom;
                        if (frsBottom != null && (frsBottomSmartBgColor = frsBottom.frs_smart_bg_color) != null) {
                            str = frsBottomSmartBgColor.tag_color;
                        } else {
                            str = null;
                        }
                        if (str == null) {
                            str = "#FF2B87FF";
                        }
                        y87Var.d(str);
                    }
                    sb7<?> b = a97Var.b(next);
                    if (b != null) {
                        arrayList.add(b);
                    }
                } else if (Intrinsics.areEqual("template_stub_head_card", next.layout)) {
                    if ((originData instanceof DataRes) && (headerCard = ((DataRes) originData).header_card) != null) {
                        lbb lbbVar = new lbb();
                        lbbVar.f(headerCard);
                        if (rbb.p(lbbVar, false)) {
                            rbb rbbVar = new rbb();
                            rbbVar.n(2);
                            rbbVar.h(lbbVar);
                            arrayList.add(new tb7(rbbVar, "template_stub_head_card"));
                        }
                    }
                } else {
                    BdLog.e("no layout for " + next.layout);
                }
            }
            int i = 0;
            for (sb7<?> sb7Var : arrayList) {
                if (sb7Var instanceof f67) {
                    break;
                } else if (Intrinsics.areEqual("feed_top_card", sb7Var.a())) {
                    i++;
                }
            }
            ej7 f = f(originData);
            h(feedData, arrayList, f.c(), f.b(), f.a(), i);
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public final boolean d(sb7<?> sb7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sb7Var)) == null) {
            if (Intrinsics.areEqual("feed_top_card", sb7Var.a())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean e(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, advertAppInfo)) == null) {
            try {
                if (TextUtils.isEmpty(advertAppInfo.q)) {
                    lja.h(advertAppInfo, 1, 26);
                    return true;
                } else if (sva.b(TbadkCoreApplication.getInst().getContext(), advertAppInfo.q) && e06.a().o()) {
                    lja.h(advertAppInfo, 1, 3);
                    return true;
                } else {
                    return false;
                }
            } catch (Exception unused) {
                lja.h(advertAppInfo, 1, 100);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void h(q67 q67Var, List<sb7<?>> list, BannerList bannerList, int i, List<AdMixFloor> list2, int i2) {
        T t;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{q67Var, list, bannerList, Integer.valueOf(i), list2, Integer.valueOf(i2)}) == null) && i != -1) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (x88.d()) {
                            i(q67Var, list, i2);
                            return;
                        } else {
                            k(bannerList, list, i2);
                            return;
                        }
                    } else if (list2 != null) {
                        Iterator<T> it = list2.iterator();
                        if (it.hasNext()) {
                            t = it.next();
                            Integer num = ((AdMixFloor) t).ad_type;
                            Intrinsics.checkNotNullExpressionValue(num, "it.ad_type");
                            int intValue = num.intValue();
                            if (intValue != 1) {
                                if (intValue == 2) {
                                    j(list2, list);
                                }
                            } else {
                                k(bannerList, list, i2);
                            }
                        } else {
                            t = null;
                        }
                        AdMixFloor adMixFloor = (AdMixFloor) t;
                        return;
                    } else {
                        return;
                    }
                }
                i(q67Var, list, i2);
                return;
            }
            k(bannerList, list, i2);
        }
    }

    public final void i(q67 q67Var, List<sb7<?>> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, q67Var, list, i) == null) {
            int h = q88.m().h();
            int i2 = (q88.m().i() - 1) + i;
            int i3 = 0;
            if (!q67Var.a.isEmpty()) {
                int size = q67Var.a.size() - 1;
                int i4 = 0;
                if (size >= 0) {
                    while (true) {
                        int i5 = size - 1;
                        if (Intrinsics.areEqual(g37.a(), q67Var.a.get(size).a()) || (q67Var.a.get(size).b() instanceof AdvertAppInfo)) {
                            break;
                        }
                        i4++;
                        if (i5 < 0) {
                            break;
                        }
                        size = i5;
                    }
                }
                if (i4 <= h) {
                    i2 = h - i4;
                }
            }
            if (!ListUtils.isEmpty(list) && i2 >= 0 && h >= 1) {
                ListIterator<sb7<?>> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    if (!d(listIterator.next()) && ((i3 = i3 + 1) == i2 || (i3 > i2 && (i3 - i2) % h == 0))) {
                        lwa lwaVar = new lwa();
                        lwaVar.n(true);
                        listIterator.add(new a37(new y27(lwaVar, z27.c(), false, 4, null), g37.a()));
                    }
                }
            }
        }
    }

    public final void k(BannerList bannerList, List<sb7<?>> list, int i) {
        List<App> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, bannerList, list, i) == null) {
            if (bannerList != null) {
                list2 = bannerList.app;
            } else {
                list2 = null;
            }
            if (list2 != null) {
                List<App> list3 = bannerList.app;
                Intrinsics.checkNotNullExpressionValue(list3, "bannerList.app");
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10));
                for (App app : list3) {
                    AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                    advertAppInfo.l(app);
                    arrayList.add(advertAppInfo);
                }
                for (AdvertAppInfo advertAppInfo2 : CollectionsKt___CollectionsKt.sortedWith(arrayList, new a())) {
                    if (advertAppInfo2.l == null) {
                        lja.h(advertAppInfo2, 1, 100);
                    } else {
                        int h = advertAppInfo2.h();
                        if (h != 0) {
                            lja.h(advertAppInfo2, 1, h);
                        } else if (!advertAppInfo2.e() || !e(advertAppInfo2)) {
                            int i2 = advertAppInfo2.position - 1;
                            advertAppInfo2.position = i2;
                            int i3 = i2 + i;
                            if (i3 >= 0 && list.size() >= i3) {
                                if (advertAppInfo2.b()) {
                                    list.add(i3, new tb7(advertAppInfo2, c37.c()));
                                } else {
                                    list.add(i3, new a37(advertAppInfo2, c37.e(advertAppInfo2.b, advertAppInfo2.c)));
                                }
                            } else {
                                zga.n(advertAppInfo2);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void j(List<AdMixFloor> list, List<sb7<?>> list2) {
        boolean z;
        boolean z2;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, list, list2) == null) {
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            int i = 0;
            for (AdMixFloor adMixFloor : list) {
                if (adMixFloor != null && (num = adMixFloor.ad_type) != null && num.intValue() == 2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    Integer num2 = adMixFloor.floor_num;
                    Intrinsics.checkNotNullExpressionValue(num2, "mixFloor.floor_num");
                    int intValue = (num2.intValue() + i) - 1;
                    if (intValue >= 0 && intValue <= list2.size()) {
                        lwa lwaVar = new lwa();
                        lwaVar.n(true);
                        list2.add(new a37(new y27(lwaVar, z27.c(), false, 4, null), g37.a()));
                        i++;
                    }
                }
            }
        }
    }
}
