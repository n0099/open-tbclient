package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.App;
import tbclient.BannerList;
import tbclient.Personalized.DataRes;
/* loaded from: classes5.dex */
public class f28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, List<xn> list) {
        l4a l4aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, str, list) == null) && list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<xn> it = list.iterator();
            int i = 0;
            AdvertAppInfo advertAppInfo = null;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i++;
                xn next = it.next();
                if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof w66)) {
                    it.remove();
                }
                if (next instanceof j18) {
                    advertAppInfo = ((j18) next).c();
                } else if (next instanceof d35) {
                    d35 d35Var = (d35) next;
                    if (d35Var.c() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) d35Var.c()).getAdvertAppInfo();
                    }
                } else if ((next instanceof ThreadData) && (l4aVar = ((ThreadData) next).funAdData) != null && l4aVar.i()) {
                    it.remove();
                    i3 = i;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.a)) {
                    it.remove();
                    advertAppInfo = null;
                    i2 = i;
                }
            }
        }
    }

    public static void b(List<xn> list, DataRes.Builder builder, wz7 wz7Var, g18 g18Var) {
        l4a l4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, list, builder, wz7Var, g18Var) == null) {
            if (list != null && list.size() > 0) {
                Iterator<xn> it = list.iterator();
                while (it.hasNext()) {
                    xn next = it.next();
                    if (!(next instanceof j18) && !(next instanceof d35) && !(next instanceof w66)) {
                        if ((next instanceof ThreadData) && (l4aVar = ((ThreadData) next).funAdData) != null) {
                            l4aVar.p(true);
                            it.remove();
                        }
                    } else {
                        it.remove();
                    }
                }
            }
            if (builder != null && ListUtils.getCount(builder.thread_list) > 0) {
                BannerList.Builder builder2 = new BannerList.Builder(builder.banner_list);
                List<App> list2 = builder2.app;
                if (list2 != null) {
                    list2.clear();
                }
                builder.banner_list = builder2.build(false);
                DataRes.Builder builder3 = new DataRes.Builder(builder.build(true));
                builder3.banner_list = builder2.build(true);
                if (wz7Var != null) {
                    wz7Var.a(builder3);
                }
            }
            if (g18Var != null) {
                g18Var.z(list);
            }
        }
    }

    public static void c(String str, DataRes.Builder builder, wz7 wz7Var) {
        BannerList bannerList;
        List<App> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, builder, wz7Var) == null) && !TextUtils.isEmpty(str) && builder != null && (bannerList = builder.banner_list) != null && (list = bannerList.app) != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : builder.banner_list.app) {
                if (app != null && str.equals(rr9.a(app))) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder2 = new BannerList.Builder(builder.banner_list);
            List<App> list2 = builder2.app;
            if (list2 != null) {
                list2.removeAll(arrayList);
            }
            builder.banner_list = builder2.build(false);
            DataRes.Builder builder3 = new DataRes.Builder(builder.build(true));
            builder3.banner_list = builder2.build(true);
            if (wz7Var != null) {
                wz7Var.a(builder3);
            }
        }
    }
}
