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
/* loaded from: classes4.dex */
public class a28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, List<wn> list) {
        zz9 zz9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, str, list) == null) && list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<wn> it = list.iterator();
            int i = 0;
            AdvertAppInfo advertAppInfo = null;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i++;
                wn next = it.next();
                if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof r66)) {
                    it.remove();
                }
                if (next instanceof e18) {
                    advertAppInfo = ((e18) next).c();
                } else if (next instanceof a35) {
                    a35 a35Var = (a35) next;
                    if (a35Var.c() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) a35Var.c()).getAdvertAppInfo();
                    }
                } else if ((next instanceof ThreadData) && (zz9Var = ((ThreadData) next).funAdData) != null && zz9Var.i()) {
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

    public static void b(List<wn> list, DataRes.Builder builder, rz7 rz7Var, b18 b18Var) {
        zz9 zz9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, list, builder, rz7Var, b18Var) == null) {
            if (list != null && list.size() > 0) {
                Iterator<wn> it = list.iterator();
                while (it.hasNext()) {
                    wn next = it.next();
                    if (!(next instanceof e18) && !(next instanceof a35) && !(next instanceof r66)) {
                        if ((next instanceof ThreadData) && (zz9Var = ((ThreadData) next).funAdData) != null) {
                            zz9Var.p(true);
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
                if (rz7Var != null) {
                    rz7Var.a(builder3);
                }
            }
            if (b18Var != null) {
                b18Var.z(list);
            }
        }
    }

    public static void c(String str, DataRes.Builder builder, rz7 rz7Var) {
        BannerList bannerList;
        List<App> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, builder, rz7Var) == null) && !TextUtils.isEmpty(str) && builder != null && (bannerList = builder.banner_list) != null && (list = bannerList.app) != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : builder.banner_list.app) {
                if (app != null && str.equals(fn9.a(app))) {
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
            if (rz7Var != null) {
                rz7Var.a(builder3);
            }
        }
    }
}
