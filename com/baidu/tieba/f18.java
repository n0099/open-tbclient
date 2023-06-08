package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.App;
import tbclient.BannerList;
import tbclient.DiscoverHotForum;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.CardGod;
import tbclient.Personalized.CardTopic;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.Resource;
import tbclient.Personalized.TagStruct;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class f18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void A(oo6 oo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, oo6Var) == null) {
            oo6Var.u = true;
            oo6Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void C(oo6 oo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, oo6Var) == null) {
            oo6Var.z = true;
            oo6Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static int f(App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, app)) == null) {
            if (app == null) {
                return -1;
            }
            return nl9.b(app);
        }
        return invokeL.intValue;
    }

    public static wo6 g(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, threadData)) == null) {
            wo6 wo6Var = new wo6();
            wo6Var.a = threadData;
            threadData.isLinkThread();
            if (!threadData.isLinkThread()) {
                threadData.isGodThread();
            }
            return wo6Var;
        }
        return (wo6) invokeL.objValue;
    }

    public static AdvertAppInfo l(App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, app)) == null) {
            r08 r08Var = new r08();
            r08Var.d(app);
            return r08Var.c();
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    public static void r(oo6 oo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, oo6Var) == null) {
            oo6Var.n = true;
            oo6Var.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void u(oo6 oo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, oo6Var) == null) {
            ((wo6) oo6Var).o = true;
            oo6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void v(oo6 oo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, oo6Var) == null) {
            ((wo6) oo6Var).q = true;
            oo6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void w(oo6 oo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, oo6Var) == null) {
            ((wo6) oo6Var).p = true;
            oo6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void x(oo6 oo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, oo6Var) == null) {
            ((wo6) oo6Var).r = true;
            oo6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void y(oo6 oo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, null, oo6Var) == null) {
            ((xo6) oo6Var).s = true;
            oo6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void z(oo6 oo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, oo6Var) == null) {
            ((yo6) oo6Var).t = true;
            oo6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void B(oo6 oo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, oo6Var) == null) {
            if (oo6Var instanceof wo6) {
                ((wo6) oo6Var).w = true;
            } else if (oo6Var instanceof xo6) {
                ((xo6) oo6Var).w = true;
            } else if (oo6Var instanceof vo6) {
                ((vo6) oo6Var).w = true;
            }
            oo6Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void D(oo6 oo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, oo6Var) == null) {
            if (oo6Var instanceof wo6) {
                ((wo6) oo6Var).v = true;
            } else if (oo6Var instanceof xo6) {
                ((xo6) oo6Var).v = true;
            } else if (oo6Var instanceof vo6) {
                ((vo6) oo6Var).v = true;
            }
            oo6Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void a(List<App> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, list) == null) && list != null && list.size() > 1) {
            int size = list.size() - 1;
            while (true) {
                int i = size - 1;
                if (i > 0) {
                    int f = f(list.get(size));
                    int f2 = f(list.get(i));
                    if (f <= 0 || f - f2 < 3) {
                        ListUtils.remove(list, size);
                    }
                    size--;
                } else {
                    return;
                }
            }
        }
    }

    public static void p(oo6 oo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, oo6Var) == null) {
            if (oo6Var instanceof yo6) {
                ((yo6) oo6Var).A = true;
            } else if (oo6Var instanceof wo6) {
                ((wo6) oo6Var).A = true;
            } else if (oo6Var instanceof xo6) {
                ((xo6) oo6Var).A = true;
            } else if (oo6Var instanceof vo6) {
                ((vo6) oo6Var).A = true;
            }
            oo6Var.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public static void t(oo6 oo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, oo6Var) == null) {
            if (oo6Var instanceof yo6) {
                ((yo6) oo6Var).m = true;
            } else if (oo6Var instanceof wo6) {
                ((wo6) oo6Var).m = true;
            } else if (oo6Var instanceof xo6) {
                ((xo6) oo6Var).m = true;
            } else if (oo6Var instanceof vo6) {
                ((vo6) oo6Var).m = true;
            }
            oo6Var.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void E(BannerList.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, builder) == null) && builder != null && !ListUtils.isEmpty(builder.app)) {
            for (int i = 0; i < builder.app.size(); i++) {
                App app = builder.app.get(i);
                if (app != null) {
                    App.Builder builder2 = new App.Builder(app);
                    builder2.pos = Integer.valueOf(nl9.b(app));
                    App build = builder2.build(false);
                    builder.app.remove(i);
                    builder.app.add(i, build);
                }
            }
        }
    }

    public static void c(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65543, null, builder) != null) || builder == null) {
            return;
        }
        if (builder.thread_list == null) {
            builder.thread_list = new LinkedList();
        }
        if (builder.card_forum == null) {
            builder.card_forum = new LinkedList();
        }
        if (builder.card_topic == null) {
            builder.card_topic = new LinkedList();
        }
        if (builder.resource_list == null) {
            builder.resource_list = new LinkedList();
        }
        if (builder.thread_personalized == null) {
            builder.thread_personalized = new LinkedList();
        }
        if (builder.interestion == null) {
            builder.interestion = new LinkedList();
        }
        if (builder.card_god == null) {
            builder.card_god = new LinkedList();
        }
    }

    public static void o(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, threadData) == null) {
            String lengthLimitName = threadData.getLengthLimitName();
            String formatTimeForHomeC = StringHelper.getFormatTimeForHomeC(threadData.getLast_time_int() * 1000);
            if (!TextUtils.isEmpty(lengthLimitName) && !TextUtils.isEmpty(formatTimeForHomeC)) {
                lengthLimitName = lengthLimitName + TbadkCoreApplication.getInst().getString(R.string.send_post) + "   " + TbadkCoreApplication.getInst().getString(R.string.repley_when) + formatTimeForHomeC;
            }
            threadData.setThreadExtendInfo(lengthLimitName);
        }
    }

    public static void q(oo6 oo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, oo6Var) == null) {
            if (oo6Var != null && oo6Var.getThreadData() != null && oo6Var.getThreadData().isFromHomPage && oo6Var.getThreadData().isWorksInfo()) {
                return;
            }
            if (oo6Var instanceof wo6) {
                ((wo6) oo6Var).x = true;
            } else if (oo6Var instanceof xo6) {
                ((xo6) oo6Var).x = true;
            } else if (oo6Var instanceof vo6) {
                ((vo6) oo6Var).x = true;
            }
            oo6Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void b(int i, List<App> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65542, null, i, list) == null) && list != null) {
            int i2 = 0;
            Iterator<App> it = list.iterator();
            while (it.hasNext()) {
                App next = it.next();
                if (next != null) {
                    int b = nl9.b(next);
                    if (b <= 0) {
                        it.remove();
                        xn9.h(l(next), 1, 23);
                    } else {
                        int i3 = i + i2 + 1;
                        if (b <= i3) {
                            i2++;
                        } else {
                            it.remove();
                            xn9.i(l(next), 1, 2, b, i3);
                        }
                    }
                } else {
                    it.remove();
                }
            }
        }
    }

    public static List<cp6> d(DataRes.Builder builder) {
        InterceptResult invokeL;
        List<App> list;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, builder)) == null) {
            u08 u08Var = null;
            if (builder == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            List<Resource> list2 = builder.resource_list;
            if (list2 != null) {
                for (Resource resource : list2) {
                    t08 t08Var = new t08();
                    t08Var.c(resource);
                    linkedList.add(t08Var);
                }
            }
            List<CardForum> list3 = builder.card_forum;
            if (list3 != null) {
                for (CardForum cardForum : list3) {
                    if (cardForum != null && s08.i(cardForum.card_type.intValue()) && u08Var == null) {
                        u08Var = new u08();
                        u08Var.l(cardForum);
                        if (u08Var.k()) {
                            linkedList.add(u08Var);
                        }
                    }
                }
            }
            List<AdvertAppInfo> f = jm9.l().f();
            if (f != null) {
                f.clear();
            }
            BannerList bannerList = builder.banner_list;
            if (bannerList != null && (list = bannerList.app) != null) {
                for (App app : list) {
                    r08 r08Var = new r08();
                    r08Var.d(app);
                    if (f != null && (advertAppInfo = r08Var.a) != null) {
                        advertAppInfo.isFromHomPage = true;
                        f.add(advertAppInfo);
                    }
                    AdvertAppInfo c = r08Var.c();
                    if (c == null) {
                        xn9.h(r08Var.c(), 1, 100);
                    } else {
                        int i = c.i();
                        if (i != 0) {
                            xn9.h(r08Var.c(), 1, i);
                            if (i != 28 && i != 31) {
                                c.c = -1001;
                            }
                        }
                        if (r08Var.getPosition() <= 0) {
                            xn9.h(r08Var.c(), 1, 23);
                            c.c = -1001;
                        }
                        if (c.e()) {
                            try {
                                if (TextUtils.isEmpty(c.p)) {
                                    xn9.h(r08Var.c(), 1, 26);
                                } else if (nx9.b(TbadkCoreApplication.getInst().getContext(), c.p) && e36.a().o()) {
                                    xn9.h(r08Var.c(), 1, 3);
                                }
                            } catch (Exception unused) {
                                xn9.h(r08Var.c(), 1, 100);
                            }
                        }
                        linkedList.add(r08Var);
                    }
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    public static oo6 e(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            if (threadData.isShareThread) {
                wo6 wo6Var = new wo6();
                wo6Var.a = threadData;
                return wo6Var;
            } else if (yo6.X(threadData)) {
                return new yo6(threadData);
            } else {
                if (vo6.X(threadData)) {
                    return new vo6(threadData);
                }
                if (!wo6.X(threadData) && !wo6.Y(threadData)) {
                    if (!xo6.P(threadData)) {
                        return null;
                    }
                    return new xo6(threadData);
                }
                wo6 wo6Var2 = new wo6();
                threadData.isLinkThread();
                threadData.isSmartAppThreadType();
                if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                    threadData.isGodThread();
                }
                wo6Var2.a = threadData;
                return wo6Var2;
            }
        }
        return (oo6) invokeL.objValue;
    }

    public static void s(oo6 oo6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, null, oo6Var) == null) && oo6Var != null && oo6Var.getThreadData() != null && oo6Var.getThreadData().getTopAgreePost() != null && oo6Var.getThreadData().getTopAgreePost().p() != null && oo6Var.getThreadData().getTopAgreePost().p().getUserId() != null) {
            if (oo6Var instanceof wo6) {
                ((wo6) oo6Var).y = true;
            } else if (oo6Var instanceof xo6) {
                ((xo6) oo6Var).y = true;
            } else if (oo6Var instanceof vo6) {
                ((vo6) oo6Var).y = true;
            }
            oo6Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void h(BannerList.Builder builder, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65548, null, builder, i) == null) && builder != null && builder.app != null) {
            for (int i2 = 0; i2 < builder.app.size(); i2++) {
                App app = builder.app.get(i2);
                if (app != null) {
                    App.Builder builder2 = new App.Builder(app);
                    nl9.c(builder2, i);
                    App build = builder2.build(false);
                    builder.app.remove(i2);
                    builder.app.add(i2, build);
                }
            }
        }
    }

    public static BannerList i(boolean z, BannerList bannerList, BannerList bannerList2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Boolean.valueOf(z), bannerList, bannerList2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i4 <= 0) {
                return bannerList;
            }
            BannerList.Builder builder = new BannerList.Builder(bannerList);
            if (bannerList2 != null && bannerList2.app != null) {
                if (builder.app == null) {
                    builder.app = new LinkedList();
                }
                b(i, builder.app);
                int i5 = i2 + i3;
                BannerList.Builder builder2 = new BannerList.Builder(bannerList2);
                if (builder2.app == null) {
                    builder2.app = new LinkedList();
                }
                if (z) {
                    E(builder2);
                }
                List<App> list = builder2.app;
                if (list != null) {
                    Iterator<App> it = list.iterator();
                    int i6 = 0;
                    while (it.hasNext()) {
                        App next = it.next();
                        if (next != null) {
                            int b = nl9.b(next);
                            if (b <= 0) {
                                it.remove();
                                xn9.h(l(next), 1, 23);
                            } else {
                                int i7 = i4 + i6 + 1;
                                if (b <= i7) {
                                    i6++;
                                } else {
                                    it.remove();
                                    xn9.i(l(next), 1, 2, b, i7);
                                }
                            }
                        } else {
                            it.remove();
                        }
                    }
                }
                h(builder2, i5);
                List<App> list2 = builder2.app;
                if (list2 != null) {
                    builder.app.addAll(list2);
                }
                return builder.build(false);
            }
            return builder.build(false);
        }
        return (BannerList) invokeCommon.objValue;
    }

    public static void k(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i, int i2, int i3, int i4) {
        int i5;
        List<TagStruct> list;
        List<Resource> list2;
        List<CardTopic> list3;
        List<CardForum> list4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && builder2 != null && builder != null) {
            List<CardForum> list5 = builder2.card_forum;
            if (list5 != null && (list4 = builder.card_forum) != null) {
                list4.addAll(list5);
            }
            List<CardTopic> list6 = builder2.card_topic;
            if (list6 != null && (list3 = builder.card_topic) != null) {
                list3.addAll(list6);
            }
            List<Resource> list7 = builder2.resource_list;
            if (list7 != null && (list2 = builder.resource_list) != null) {
                list2.addAll(list7);
            }
            if (i == 0) {
                builder.banner_list = j(z, builder.banner_list, builder2.banner_list, i2);
            } else {
                List<ThreadInfo> list8 = builder.thread_list;
                if (list8 != null) {
                    i5 = list8.size();
                } else {
                    i5 = 0;
                }
                builder.banner_list = i(z, builder.banner_list, builder2.banner_list, i5, i3, i4, i2);
            }
            if (builder.age_sex == null) {
                builder.age_sex = builder2.age_sex;
                if (builder2.age_sex != null) {
                    n95.m().w("has_requested_new_user_guide", true);
                }
            }
            if (builder2.interestion != null && builder != null && (list = builder.interestion) != null && list.size() == 0) {
                builder.interestion.addAll(builder2.interestion);
            }
            List<CardGod> list9 = builder2.card_god;
            if (list9 != null) {
                builder.card_god.addAll(list9);
            }
            DiscoverHotForum discoverHotForum = builder2.hot_recomforum;
            if (discoverHotForum != null) {
                builder.hot_recomforum = discoverHotForum;
            }
        }
    }

    public static BannerList j(boolean z, BannerList bannerList, BannerList bannerList2, int i) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Boolean.valueOf(z), bannerList, bannerList2, Integer.valueOf(i)})) == null) {
            if (i <= 0) {
                return bannerList;
            }
            BannerList.Builder builder = new BannerList.Builder(bannerList);
            if (builder.app == null) {
                builder.app = new LinkedList();
            }
            BannerList.Builder builder2 = new BannerList.Builder(bannerList2);
            if (z) {
                E(builder2);
            }
            List<App> list = builder2.app;
            if (list != null) {
                Iterator<App> it = list.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    App next = it.next();
                    if (next != null) {
                        int b = nl9.b(next);
                        if (b <= 0) {
                            it.remove();
                            xn9.h(l(next), 1, 23);
                        } else {
                            int i3 = i + i2 + 1;
                            if (b <= i3) {
                                i2++;
                            } else {
                                it.remove();
                                xn9.i(l(next), 1, 2, b, i3);
                            }
                        }
                    } else {
                        it.remove();
                    }
                }
            } else {
                i2 = 0;
            }
            int i4 = i2 + i;
            if (i4 <= 0) {
                return builder.build(false);
            }
            h(builder, i4);
            List<App> list2 = builder2.app;
            if (list2 != null) {
                builder.app.addAll(0, list2);
            }
            return builder.build(false);
        }
        return (BannerList) invokeCommon.objValue;
    }

    public static void m(DataRes.Builder builder) {
        BannerList.Builder builder2;
        List<App> list;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65553, null, builder) != null) || builder == null) {
            return;
        }
        int count = ListUtils.getCount(builder.thread_list);
        BannerList bannerList = builder.banner_list;
        if (bannerList != null && bannerList.app != null && (list = (builder2 = new BannerList.Builder(bannerList)).app) != null) {
            a(list);
            for (int size = builder2.app.size() - 1; size >= 0; size--) {
                App app = builder2.app.get(size);
                r08 r08Var = new r08();
                r08Var.d(app);
                if (app != null) {
                    i = nl9.b(app);
                } else {
                    i = -1;
                }
                if (i < 0) {
                    xn9.h(r08Var.c(), 1, 33);
                    builder2.app.remove(size);
                } else {
                    int i2 = count + size;
                    if (i > i2) {
                        xn9.i(r08Var.G(), 1, 2, i, i2);
                        builder2.app.remove(size);
                    } else {
                        AdvertAppInfo c = r08Var.c();
                        if (c == null) {
                            xn9.h(r08Var.c(), 1, 100);
                            builder2.app.remove(size);
                        } else {
                            int i3 = c.i();
                            if (i3 != 0) {
                                xn9.h(r08Var.c(), 1, i3);
                                builder2.app.remove(size);
                            }
                        }
                    }
                }
            }
            if (builder2.app.size() != builder.banner_list.app.size()) {
                builder.banner_list = builder2.build(false);
            }
        }
    }

    public static void n(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, builder) == null) {
            m(builder);
            if (builder != null && builder.card_forum != null && builder.card_topic != null && builder.resource_list != null && ListUtils.getCount(builder.thread_list) != 0) {
                int count = ListUtils.getCount(builder.thread_list);
                for (int size = builder.card_forum.size() - 1; size >= 0; size--) {
                    if (builder.card_forum.get(size).position.longValue() > count) {
                        builder.card_forum.remove(size);
                    }
                }
                for (int size2 = builder.card_topic.size() - 1; size2 >= 0; size2--) {
                    if (builder.card_topic.get(size2).position.intValue() > count) {
                        builder.card_topic.remove(size2);
                    }
                }
                for (int size3 = builder.resource_list.size() - 1; size3 >= 0; size3--) {
                    if (builder.resource_list.get(size3).position.longValue() > count) {
                        builder.resource_list.remove(size3);
                    }
                }
                for (int size4 = builder.card_god.size() - 1; size4 >= 0; size4--) {
                    if (builder.card_god.get(size4).position.intValue() > count) {
                        builder.card_god.remove(size4);
                    }
                }
            }
        }
    }
}
