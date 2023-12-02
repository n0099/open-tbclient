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
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
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
public abstract class ej7<T> implements xi7<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract dj7 f(Object obj);

    public abstract List<LayoutFactory> g(Object obj);

    public ej7() {
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

    @Override // com.baidu.tieba.xi7
    public List<rb7<?>> c(Object originData, q67 feedData, Map<String, String> schemaLocalInfo, boolean z) {
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
            for (LayoutFactory layoutFactory : g) {
                a97 a97Var = j77.a().get(layoutFactory.layout);
                if (a97Var instanceof u87) {
                    ((u87) a97Var).j();
                }
                boolean z2 = false;
                if (a97Var != null) {
                    if (a97Var instanceof ua7) {
                        ((ua7) a97Var).a(schemaLocalInfo);
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
                    rb7<?> b = a97Var.b(layoutFactory);
                    if (b != null) {
                        arrayList.add(b);
                    }
                } else if (Intrinsics.areEqual("template_stub_head_card", layoutFactory.layout)) {
                    if ((originData instanceof DataRes) && (headerCard = ((DataRes) originData).header_card) != null) {
                        kbb kbbVar = new kbb();
                        kbbVar.f(headerCard);
                        if (qbb.p(kbbVar, false)) {
                            qbb qbbVar = new qbb();
                            qbbVar.n(2);
                            qbbVar.h(kbbVar);
                            arrayList.add(new sb7(qbbVar, "template_stub_head_card"));
                        }
                    }
                } else {
                    BdLog.e("no layout for " + layoutFactory.layout);
                }
            }
            dj7 f = f(originData);
            h(feedData, arrayList, f.c(), f.b(), f.a());
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public final boolean d(rb7<?> rb7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rb7Var)) == null) {
            if (Intrinsics.areEqual("feed_top_card", rb7Var.a())) {
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
                    kja.h(advertAppInfo, 1, 26);
                    return true;
                } else if (rva.b(TbadkCoreApplication.getInst().getContext(), advertAppInfo.q) && e06.a().o()) {
                    kja.h(advertAppInfo, 1, 3);
                    return true;
                } else {
                    return false;
                }
            } catch (Exception unused) {
                kja.h(advertAppInfo, 1, 100);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void h(q67 q67Var, List<rb7<?>> list, BannerList bannerList, int i, List<AdMixFloor> list2) {
        T t;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{q67Var, list, bannerList, Integer.valueOf(i), list2}) == null) && i != -1) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (w88.d()) {
                            i(q67Var, list);
                            return;
                        } else {
                            k(bannerList, list);
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
                                k(bannerList, list);
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
                i(q67Var, list);
                return;
            }
            k(bannerList, list);
        }
    }

    public final void i(q67 q67Var, List<rb7<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, q67Var, list) == null) {
            int h = p88.m().h();
            int i = p88.m().i() - 1;
            int i2 = 0;
            if (!q67Var.a.isEmpty()) {
                int size = q67Var.a.size() - 1;
                int i3 = 0;
                if (size >= 0) {
                    while (true) {
                        int i4 = size - 1;
                        if (Intrinsics.areEqual(g37.a(), q67Var.a.get(size).a()) || (q67Var.a.get(size).b() instanceof AdvertAppInfo)) {
                            break;
                        }
                        i3++;
                        if (i4 < 0) {
                            break;
                        }
                        size = i4;
                    }
                }
                if (i3 <= h) {
                    i = h - i3;
                }
            }
            if (!ListUtils.isEmpty(list) && i >= 0 && h >= 1) {
                ListIterator<rb7<?>> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    if (!d(listIterator.next()) && ((i2 = i2 + 1) == i || (i2 > i && (i2 - i) % h == 0))) {
                        kwa kwaVar = new kwa();
                        kwaVar.n(true);
                        listIterator.add(new a37(new y27(kwaVar, z27.c(), false, 4, null), g37.a()));
                    }
                }
            }
        }
    }

    public final void j(List<AdMixFloor> list, List<rb7<?>> list2) {
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
                        kwa kwaVar = new kwa();
                        kwaVar.n(true);
                        list2.add(new a37(new y27(kwaVar, z27.c(), false, 4, null), g37.a()));
                        i++;
                    }
                }
            }
        }
    }

    public final void k(BannerList bannerList, List<rb7<?>> list) {
        List<App> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bannerList, list) == null) {
            if (bannerList != null) {
                list2 = bannerList.app;
            } else {
                list2 = null;
            }
            if (list2 != null) {
                int i = 0;
                for (App app : bannerList.app) {
                    AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                    advertAppInfo.l(app);
                    if (advertAppInfo.l == null) {
                        kja.h(advertAppInfo, 1, 100);
                    } else {
                        int h = advertAppInfo.h();
                        if (h != 0) {
                            kja.h(advertAppInfo, 1, h);
                        } else if (!advertAppInfo.e() || !e(advertAppInfo)) {
                            int i2 = advertAppInfo.position + i;
                            if (i2 >= 0 && list.size() >= i2) {
                                i++;
                                if (advertAppInfo.b()) {
                                    list.add(i2, new sb7(advertAppInfo, c37.c()));
                                } else {
                                    list.add(i2, new a37(advertAppInfo, c37.e(advertAppInfo.b, advertAppInfo.c)));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
