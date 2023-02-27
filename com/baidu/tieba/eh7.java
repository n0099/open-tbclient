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
/* loaded from: classes4.dex */
public class eh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void A(eg6 eg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, eg6Var) == null) {
            eg6Var.u = true;
            eg6Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void C(eg6 eg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, eg6Var) == null) {
            eg6Var.z = true;
            eg6Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static int f(App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, app)) == null) {
            if (app == null) {
                return -1;
            }
            return hv8.b(app);
        }
        return invokeL.intValue;
    }

    public static mg6 g(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, threadData)) == null) {
            mg6 mg6Var = new mg6();
            mg6Var.a = threadData;
            threadData.isLinkThread();
            if (!threadData.isLinkThread()) {
                threadData.isGodThread();
            }
            return mg6Var;
        }
        return (mg6) invokeL.objValue;
    }

    public static AdvertAppInfo l(App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, app)) == null) {
            sg7 sg7Var = new sg7();
            sg7Var.f(app);
            return sg7Var.c();
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    public static void r(eg6 eg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, eg6Var) == null) {
            eg6Var.n = true;
            eg6Var.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void u(eg6 eg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, eg6Var) == null) {
            ((mg6) eg6Var).o = true;
            eg6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void v(eg6 eg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, eg6Var) == null) {
            ((mg6) eg6Var).q = true;
            eg6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void w(eg6 eg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, eg6Var) == null) {
            ((mg6) eg6Var).p = true;
            eg6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void x(eg6 eg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, eg6Var) == null) {
            ((mg6) eg6Var).r = true;
            eg6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void y(eg6 eg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, null, eg6Var) == null) {
            ((ng6) eg6Var).s = true;
            eg6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void z(eg6 eg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, eg6Var) == null) {
            ((og6) eg6Var).t = true;
            eg6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void B(eg6 eg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, eg6Var) == null) {
            if (eg6Var instanceof mg6) {
                ((mg6) eg6Var).w = true;
            } else if (eg6Var instanceof ng6) {
                ((ng6) eg6Var).w = true;
            } else if (eg6Var instanceof lg6) {
                ((lg6) eg6Var).w = true;
            }
            eg6Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void D(eg6 eg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, eg6Var) == null) {
            if (eg6Var instanceof mg6) {
                ((mg6) eg6Var).v = true;
            } else if (eg6Var instanceof ng6) {
                ((ng6) eg6Var).v = true;
            } else if (eg6Var instanceof lg6) {
                ((lg6) eg6Var).v = true;
            }
            eg6Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
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

    public static void p(eg6 eg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, eg6Var) == null) {
            if (eg6Var instanceof og6) {
                ((og6) eg6Var).A = true;
            } else if (eg6Var instanceof mg6) {
                ((mg6) eg6Var).A = true;
            } else if (eg6Var instanceof ng6) {
                ((ng6) eg6Var).A = true;
            } else if (eg6Var instanceof lg6) {
                ((lg6) eg6Var).A = true;
            }
            eg6Var.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public static void t(eg6 eg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, eg6Var) == null) {
            if (eg6Var instanceof og6) {
                ((og6) eg6Var).m = true;
            } else if (eg6Var instanceof mg6) {
                ((mg6) eg6Var).m = true;
            } else if (eg6Var instanceof ng6) {
                ((ng6) eg6Var).m = true;
            } else if (eg6Var instanceof lg6) {
                ((lg6) eg6Var).m = true;
            }
            eg6Var.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void E(BannerList.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, builder) == null) && builder != null && !ListUtils.isEmpty(builder.app)) {
            for (int i = 0; i < builder.app.size(); i++) {
                App app = builder.app.get(i);
                if (app != null) {
                    App.Builder builder2 = new App.Builder(app);
                    builder2.pos = Integer.valueOf(hv8.b(app));
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

    public static void q(eg6 eg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, eg6Var) == null) {
            if (eg6Var != null && eg6Var.getThreadData() != null && eg6Var.getThreadData().isFromHomPage && eg6Var.getThreadData().isWorksInfo()) {
                return;
            }
            if (eg6Var instanceof mg6) {
                ((mg6) eg6Var).x = true;
            } else if (eg6Var instanceof ng6) {
                ((ng6) eg6Var).x = true;
            } else if (eg6Var instanceof lg6) {
                ((lg6) eg6Var).x = true;
            }
            eg6Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
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
                    int b = hv8.b(next);
                    if (b <= 0) {
                        it.remove();
                        px8.h(l(next), 1, 23);
                    } else {
                        int i3 = i + i2 + 1;
                        if (b <= i3) {
                            i2++;
                        } else {
                            it.remove();
                            px8.i(l(next), 1, 2, b, i3);
                        }
                    }
                } else {
                    it.remove();
                }
            }
        }
    }

    public static List<sg6> d(DataRes.Builder builder) {
        InterceptResult invokeL;
        List<App> list;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, builder)) == null) {
            vg7 vg7Var = null;
            if (builder == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            List<Resource> list2 = builder.resource_list;
            if (list2 != null) {
                for (Resource resource : list2) {
                    ug7 ug7Var = new ug7();
                    ug7Var.c(resource);
                    linkedList.add(ug7Var);
                }
            }
            List<CardForum> list3 = builder.card_forum;
            if (list3 != null) {
                for (CardForum cardForum : list3) {
                    if (cardForum != null && tg7.l(cardForum.card_type.intValue()) && vg7Var == null) {
                        vg7Var = new vg7();
                        vg7Var.o(cardForum);
                        if (vg7Var.n()) {
                            linkedList.add(vg7Var);
                        }
                    }
                }
            }
            List<AdvertAppInfo> f = cw8.l().f();
            if (f != null) {
                f.clear();
            }
            BannerList bannerList = builder.banner_list;
            if (bannerList != null && (list = bannerList.app) != null) {
                for (App app : list) {
                    sg7 sg7Var = new sg7();
                    sg7Var.f(app);
                    if (f != null && (advertAppInfo = sg7Var.a) != null) {
                        advertAppInfo.isFromHomPage = true;
                        f.add(advertAppInfo);
                    }
                    AdvertAppInfo c = sg7Var.c();
                    if (c == null) {
                        px8.h(sg7Var.c(), 1, 100);
                    } else {
                        int l = c.l();
                        if (l != 0) {
                            px8.h(sg7Var.c(), 1, l);
                            if (l != 28 && l != 31) {
                                c.c = -1001;
                            }
                        }
                        if (sg7Var.getPosition() <= 0) {
                            px8.h(sg7Var.c(), 1, 23);
                            c.c = -1001;
                        }
                        if (c.g()) {
                            try {
                                if (TextUtils.isEmpty(c.p)) {
                                    px8.h(sg7Var.c(), 1, 26);
                                } else if (a59.b(TbadkCoreApplication.getInst().getContext(), c.p) && cw5.a().p()) {
                                    px8.h(sg7Var.c(), 1, 3);
                                }
                            } catch (Exception unused) {
                                px8.h(sg7Var.c(), 1, 100);
                            }
                        }
                        linkedList.add(sg7Var);
                    }
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    public static eg6 e(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            if (threadData.isShareThread) {
                mg6 mg6Var = new mg6();
                mg6Var.a = threadData;
                return mg6Var;
            } else if (og6.W(threadData)) {
                return new og6(threadData);
            } else {
                if (lg6.W(threadData)) {
                    return new lg6(threadData);
                }
                if (!mg6.W(threadData) && !mg6.X(threadData)) {
                    if (!ng6.R(threadData)) {
                        return null;
                    }
                    return new ng6(threadData);
                }
                mg6 mg6Var2 = new mg6();
                threadData.isLinkThread();
                threadData.isSmartAppThreadType();
                if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                    threadData.isGodThread();
                }
                mg6Var2.a = threadData;
                return mg6Var2;
            }
        }
        return (eg6) invokeL.objValue;
    }

    public static void s(eg6 eg6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, null, eg6Var) == null) && eg6Var != null && eg6Var.getThreadData() != null && eg6Var.getThreadData().getTopAgreePost() != null && eg6Var.getThreadData().getTopAgreePost().r() != null && eg6Var.getThreadData().getTopAgreePost().r().getUserId() != null) {
            if (eg6Var instanceof mg6) {
                ((mg6) eg6Var).y = true;
            } else if (eg6Var instanceof ng6) {
                ((ng6) eg6Var).y = true;
            } else if (eg6Var instanceof lg6) {
                ((lg6) eg6Var).y = true;
            }
            eg6Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void h(BannerList.Builder builder, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65548, null, builder, i) == null) && builder != null && builder.app != null) {
            for (int i2 = 0; i2 < builder.app.size(); i2++) {
                App app = builder.app.get(i2);
                if (app != null) {
                    App.Builder builder2 = new App.Builder(app);
                    hv8.c(builder2, i);
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
                            int b = hv8.b(next);
                            if (b <= 0) {
                                it.remove();
                                px8.h(l(next), 1, 23);
                            } else {
                                int i7 = i4 + i6 + 1;
                                if (b <= i7) {
                                    i6++;
                                } else {
                                    it.remove();
                                    px8.i(l(next), 1, 2, b, i7);
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
                    b55.m().w("has_requested_new_user_guide", true);
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
                        int b = hv8.b(next);
                        if (b <= 0) {
                            it.remove();
                            px8.h(l(next), 1, 23);
                        } else {
                            int i3 = i + i2 + 1;
                            if (b <= i3) {
                                i2++;
                            } else {
                                it.remove();
                                px8.i(l(next), 1, 2, b, i3);
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
                sg7 sg7Var = new sg7();
                sg7Var.f(app);
                if (app != null) {
                    i = hv8.b(app);
                } else {
                    i = -1;
                }
                if (i < 0) {
                    px8.h(sg7Var.c(), 1, 33);
                    builder2.app.remove(size);
                } else {
                    int i2 = count + size;
                    if (i > i2) {
                        px8.i(sg7Var.z(), 1, 2, i, i2);
                        builder2.app.remove(size);
                    } else {
                        AdvertAppInfo c = sg7Var.c();
                        if (c == null) {
                            px8.h(sg7Var.c(), 1, 100);
                            builder2.app.remove(size);
                        } else {
                            int l = c.l();
                            if (l != 0) {
                                px8.h(sg7Var.c(), 1, l);
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
