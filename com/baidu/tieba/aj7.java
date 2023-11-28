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
public abstract class aj7<T> implements ti7<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract zi7 f(Object obj);

    public abstract List<LayoutFactory> g(Object obj);

    public aj7() {
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

    @Override // com.baidu.tieba.ti7
    public List<nb7<?>> c(Object originData, m67 feedData, Map<String, String> schemaLocalInfo, boolean z) {
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
                w87 w87Var = f77.a().get(layoutFactory.layout);
                if (w87Var instanceof q87) {
                    ((q87) w87Var).j();
                }
                boolean z2 = false;
                if (w87Var != null) {
                    if (w87Var instanceof qa7) {
                        ((qa7) w87Var).a(schemaLocalInfo);
                    }
                    if (w87Var instanceof d77) {
                        ((d77) w87Var).c(z);
                    }
                    if ((w87Var instanceof u87) && (originData instanceof DataRes)) {
                        u87 u87Var = (u87) w87Var;
                        DataRes dataRes = (DataRes) originData;
                        Integer num = dataRes.forum.is_like;
                        if (num != null && num.intValue() == 1) {
                            z2 = true;
                        }
                        u87Var.c(z2);
                        FrsBottom frsBottom = dataRes.frs_bottom;
                        if (frsBottom != null && (frsBottomSmartBgColor = frsBottom.frs_smart_bg_color) != null) {
                            str = frsBottomSmartBgColor.tag_color;
                        } else {
                            str = null;
                        }
                        if (str == null) {
                            str = "#FF2B87FF";
                        }
                        u87Var.d(str);
                    }
                    nb7<?> b = w87Var.b(layoutFactory);
                    if (b != null) {
                        arrayList.add(b);
                    }
                } else if (Intrinsics.areEqual("template_stub_head_card", layoutFactory.layout)) {
                    if ((originData instanceof DataRes) && (headerCard = ((DataRes) originData).header_card) != null) {
                        lbb lbbVar = new lbb();
                        lbbVar.f(headerCard);
                        if (rbb.p(lbbVar, false)) {
                            rbb rbbVar = new rbb();
                            rbbVar.n(2);
                            rbbVar.h(lbbVar);
                            arrayList.add(new ob7(rbbVar, "template_stub_head_card"));
                        }
                    }
                } else {
                    BdLog.e("no layout for " + layoutFactory.layout);
                }
            }
            zi7 f = f(originData);
            h(feedData, arrayList, f.c(), f.b(), f.a());
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public final boolean d(nb7<?> nb7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb7Var)) == null) {
            if (Intrinsics.areEqual("feed_top_card", nb7Var.a())) {
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
                    gja.h(advertAppInfo, 1, 26);
                    return true;
                } else if (sva.b(TbadkCoreApplication.getInst().getContext(), advertAppInfo.q) && a06.a().o()) {
                    gja.h(advertAppInfo, 1, 3);
                    return true;
                } else {
                    return false;
                }
            } catch (Exception unused) {
                gja.h(advertAppInfo, 1, 100);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void h(m67 m67Var, List<nb7<?>> list, BannerList bannerList, int i, List<AdMixFloor> list2) {
        T t;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{m67Var, list, bannerList, Integer.valueOf(i), list2}) == null) && i != -1) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (s88.d()) {
                            i(m67Var, list);
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
                i(m67Var, list);
                return;
            }
            k(bannerList, list);
        }
    }

    public final void i(m67 m67Var, List<nb7<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, m67Var, list) == null) {
            int h = l88.m().h();
            int i = l88.m().i() - 1;
            int i2 = 0;
            if (!m67Var.a.isEmpty()) {
                int size = m67Var.a.size() - 1;
                int i3 = 0;
                if (size >= 0) {
                    while (true) {
                        int i4 = size - 1;
                        if (Intrinsics.areEqual(c37.a(), m67Var.a.get(size).a()) || (m67Var.a.get(size).b() instanceof AdvertAppInfo)) {
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
                ListIterator<nb7<?>> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    if (!d(listIterator.next()) && ((i2 = i2 + 1) == i || (i2 > i && (i2 - i) % h == 0))) {
                        lwa lwaVar = new lwa();
                        lwaVar.n(true);
                        listIterator.add(new w27(new u27(lwaVar, v27.c(), false, 4, null), c37.a()));
                    }
                }
            }
        }
    }

    public final void j(List<AdMixFloor> list, List<nb7<?>> list2) {
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
                        list2.add(new w27(new u27(lwaVar, v27.c(), false, 4, null), c37.a()));
                        i++;
                    }
                }
            }
        }
    }

    public final void k(BannerList bannerList, List<nb7<?>> list) {
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
                        gja.h(advertAppInfo, 1, 100);
                    } else {
                        int h = advertAppInfo.h();
                        if (h != 0) {
                            gja.h(advertAppInfo, 1, h);
                        } else if (!advertAppInfo.e() || !e(advertAppInfo)) {
                            int i2 = advertAppInfo.position + i;
                            if (i2 >= 0 && list.size() >= i2) {
                                i++;
                                if (advertAppInfo.b()) {
                                    list.add(i2, new ob7(advertAppInfo, y27.c()));
                                } else {
                                    list.add(i2, new w27(advertAppInfo, y27.e(advertAppInfo.b, advertAppInfo.c)));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
