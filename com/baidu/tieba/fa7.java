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
public class fa7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, List<yn> list) {
        gx8 gx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, str, list) == null) && list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<yn> it = list.iterator();
            int i = 0;
            AdvertAppInfo advertAppInfo = null;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i++;
                yn next = it.next();
                if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof gt5)) {
                    it.remove();
                }
                if (next instanceof l97) {
                    advertAppInfo = ((l97) next).c();
                } else if (next instanceof vt4) {
                    vt4 vt4Var = (vt4) next;
                    if (vt4Var.c() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) vt4Var.c()).getAdvertAppInfo();
                    }
                } else if ((next instanceof ThreadData) && (gx8Var = ((ThreadData) next).funAdData) != null && gx8Var.i()) {
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

    public static void b(List<yn> list, DataRes.Builder builder, x77 x77Var, i97 i97Var) {
        gx8 gx8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, list, builder, x77Var, i97Var) == null) {
            if (list != null && list.size() > 0) {
                Iterator<yn> it = list.iterator();
                while (it.hasNext()) {
                    yn next = it.next();
                    if (!(next instanceof l97) && !(next instanceof vt4) && !(next instanceof gt5)) {
                        if ((next instanceof ThreadData) && (gx8Var = ((ThreadData) next).funAdData) != null) {
                            gx8Var.p(true);
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
                if (x77Var != null) {
                    x77Var.a(builder3);
                }
            }
            if (i97Var != null) {
                i97Var.y(list);
            }
        }
    }

    public static void c(String str, DataRes.Builder builder, x77 x77Var) {
        BannerList bannerList;
        List<App> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, builder, x77Var) == null) && !TextUtils.isEmpty(str) && builder != null && (bannerList = builder.banner_list) != null && (list = bannerList.app) != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : builder.banner_list.app) {
                if (app != null && str.equals(wm8.a(app))) {
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
            if (x77Var != null) {
                x77Var.a(builder3);
            }
        }
    }
}
