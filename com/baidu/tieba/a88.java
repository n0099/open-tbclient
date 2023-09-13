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
public class a88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, List<cn> list) {
        rha rhaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, str, list) == null) && list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<cn> it = list.iterator();
            int i = 0;
            AdvertAppInfo advertAppInfo = null;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i++;
                cn next = it.next();
                if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof v66)) {
                    it.remove();
                }
                if (next instanceof y68) {
                    advertAppInfo = ((y68) next).c();
                } else if (next instanceof u25) {
                    u25 u25Var = (u25) next;
                    if (u25Var.c() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) u25Var.c()).getAdvertAppInfo();
                    }
                } else if ((next instanceof ThreadData) && (rhaVar = ((ThreadData) next).funAdData) != null && rhaVar.i()) {
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

    public static void b(List<cn> list, DataRes.Builder builder, j58 j58Var, v68 v68Var) {
        rha rhaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, list, builder, j58Var, v68Var) == null) {
            if (list != null && list.size() > 0) {
                Iterator<cn> it = list.iterator();
                while (it.hasNext()) {
                    cn next = it.next();
                    if (!(next instanceof y68) && !(next instanceof u25) && !(next instanceof v66)) {
                        if ((next instanceof ThreadData) && (rhaVar = ((ThreadData) next).funAdData) != null) {
                            rhaVar.p(true);
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
                if (j58Var != null) {
                    j58Var.a(builder3);
                }
            }
            if (v68Var != null) {
                v68Var.B(list);
            }
        }
    }

    public static void c(String str, DataRes.Builder builder, j58 j58Var) {
        BannerList bannerList;
        List<App> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, builder, j58Var) == null) && !TextUtils.isEmpty(str) && builder != null && (bannerList = builder.banner_list) != null && (list = bannerList.app) != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : builder.banner_list.app) {
                if (app != null && str.equals(m2a.a(app))) {
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
            if (j58Var != null) {
                j58Var.a(builder3);
            }
        }
    }
}
