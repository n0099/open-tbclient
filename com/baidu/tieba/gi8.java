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
/* loaded from: classes6.dex */
public class gi8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, List<pi> list) {
        lwa lwaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, str, list) == null) && list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<pi> it = list.iterator();
            int i = 0;
            AdvertAppInfo advertAppInfo = null;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i++;
                pi next = it.next();
                if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof h36)) {
                    it.remove();
                }
                if (next instanceof eh8) {
                    advertAppInfo = ((eh8) next).c();
                } else if (next instanceof wx4) {
                    wx4 wx4Var = (wx4) next;
                    if (wx4Var.c() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) wx4Var.c()).getAdvertAppInfo();
                    }
                } else if ((next instanceof ThreadData) && (lwaVar = ((ThreadData) next).funAdData) != null && lwaVar.i()) {
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

    public static void b(List<pi> list, DataRes.Builder builder, of8 of8Var, bh8 bh8Var) {
        lwa lwaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, list, builder, of8Var, bh8Var) == null) {
            if (list != null && list.size() > 0) {
                Iterator<pi> it = list.iterator();
                while (it.hasNext()) {
                    pi next = it.next();
                    if (!(next instanceof eh8) && !(next instanceof wx4) && !(next instanceof h36)) {
                        if ((next instanceof ThreadData) && (lwaVar = ((ThreadData) next).funAdData) != null) {
                            lwaVar.p(true);
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
                if (of8Var != null) {
                    of8Var.a(builder3);
                }
            }
            if (bh8Var != null) {
                bh8Var.B(list);
            }
        }
    }

    public static void c(String str, DataRes.Builder builder, of8 of8Var) {
        BannerList bannerList;
        List<App> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, builder, of8Var) == null) && !TextUtils.isEmpty(str) && builder != null && (bannerList = builder.banner_list) != null && (list = bannerList.app) != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : builder.banner_list.app) {
                if (app != null && str.equals(vga.a(app))) {
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
            if (of8Var != null) {
                of8Var.a(builder3);
            }
        }
    }
}
