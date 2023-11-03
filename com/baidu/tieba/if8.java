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
public class if8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, List<oi> list) {
        sra sraVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, str, list) == null) && list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<oi> it = list.iterator();
            int i = 0;
            AdvertAppInfo advertAppInfo = null;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i++;
                oi next = it.next();
                if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof z26)) {
                    it.remove();
                }
                if (next instanceof ge8) {
                    advertAppInfo = ((ge8) next).c();
                } else if (next instanceof ux4) {
                    ux4 ux4Var = (ux4) next;
                    if (ux4Var.c() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) ux4Var.c()).getAdvertAppInfo();
                    }
                } else if ((next instanceof ThreadData) && (sraVar = ((ThreadData) next).funAdData) != null && sraVar.i()) {
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

    public static void b(List<oi> list, DataRes.Builder builder, rc8 rc8Var, de8 de8Var) {
        sra sraVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, list, builder, rc8Var, de8Var) == null) {
            if (list != null && list.size() > 0) {
                Iterator<oi> it = list.iterator();
                while (it.hasNext()) {
                    oi next = it.next();
                    if (!(next instanceof ge8) && !(next instanceof ux4) && !(next instanceof z26)) {
                        if ((next instanceof ThreadData) && (sraVar = ((ThreadData) next).funAdData) != null) {
                            sraVar.p(true);
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
                if (rc8Var != null) {
                    rc8Var.a(builder3);
                }
            }
            if (de8Var != null) {
                de8Var.B(list);
            }
        }
    }

    public static void c(String str, DataRes.Builder builder, rc8 rc8Var) {
        BannerList bannerList;
        List<App> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, builder, rc8Var) == null) && !TextUtils.isEmpty(str) && builder != null && (bannerList = builder.banner_list) != null && (list = bannerList.app) != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : builder.banner_list.app) {
                if (app != null && str.equals(cca.a(app))) {
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
            if (rc8Var != null) {
                rc8Var.a(builder3);
            }
        }
    }
}
