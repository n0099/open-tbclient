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
/* loaded from: classes4.dex */
public class f37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void A(w26 w26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, w26Var) == null) {
            w26Var.u = true;
            w26Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void C(w26 w26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, w26Var) == null) {
            w26Var.z = true;
            w26Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static int f(App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, app)) == null) {
            if (app == null) {
                return -1;
            }
            return qd8.b(app);
        }
        return invokeL.intValue;
    }

    public static e36 g(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, threadData)) == null) {
            e36 e36Var = new e36();
            e36Var.a = threadData;
            threadData.isLinkThread();
            if (!threadData.isLinkThread()) {
                threadData.isGodThread();
            }
            return e36Var;
        }
        return (e36) invokeL.objValue;
    }

    public static AdvertAppInfo l(App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, app)) == null) {
            s27 s27Var = new s27();
            s27Var.f(app);
            return s27Var.c();
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    public static void r(w26 w26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, w26Var) == null) {
            w26Var.n = true;
            w26Var.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void u(w26 w26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, w26Var) == null) {
            ((e36) w26Var).o = true;
            w26Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void v(w26 w26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, w26Var) == null) {
            ((e36) w26Var).q = true;
            w26Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void w(w26 w26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, w26Var) == null) {
            ((e36) w26Var).p = true;
            w26Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void x(w26 w26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, w26Var) == null) {
            ((e36) w26Var).r = true;
            w26Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void y(w26 w26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, null, w26Var) == null) {
            ((f36) w26Var).s = true;
            w26Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void z(w26 w26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, w26Var) == null) {
            ((g36) w26Var).t = true;
            w26Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void B(w26 w26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, w26Var) == null) {
            if (w26Var instanceof e36) {
                ((e36) w26Var).w = true;
            } else if (w26Var instanceof f36) {
                ((f36) w26Var).w = true;
            } else if (w26Var instanceof d36) {
                ((d36) w26Var).w = true;
            }
            w26Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void D(w26 w26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, w26Var) == null) {
            if (w26Var instanceof e36) {
                ((e36) w26Var).v = true;
            } else if (w26Var instanceof f36) {
                ((f36) w26Var).v = true;
            } else if (w26Var instanceof d36) {
                ((d36) w26Var).v = true;
            }
            w26Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void a(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, list) == null) && list != null && list.size() > 1) {
            int size = list.size() - 1;
            while (true) {
                int i = size - 1;
                if (i > 0) {
                    int f = f((App) list.get(size));
                    int f2 = f((App) list.get(i));
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

    public static void p(w26 w26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, w26Var) == null) {
            if (w26Var instanceof g36) {
                ((g36) w26Var).A = true;
            } else if (w26Var instanceof e36) {
                ((e36) w26Var).A = true;
            } else if (w26Var instanceof f36) {
                ((f36) w26Var).A = true;
            } else if (w26Var instanceof d36) {
                ((d36) w26Var).A = true;
            }
            w26Var.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public static void t(w26 w26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, w26Var) == null) {
            if (w26Var instanceof g36) {
                ((g36) w26Var).m = true;
            } else if (w26Var instanceof e36) {
                ((e36) w26Var).m = true;
            } else if (w26Var instanceof f36) {
                ((f36) w26Var).m = true;
            } else if (w26Var instanceof d36) {
                ((d36) w26Var).m = true;
            }
            w26Var.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void E(BannerList.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, builder) == null) && builder != null && !ListUtils.isEmpty(builder.app)) {
            for (int i = 0; i < builder.app.size(); i++) {
                App app = (App) builder.app.get(i);
                if (app != null) {
                    App.Builder builder2 = new App.Builder(app);
                    builder2.pos = Integer.valueOf(qd8.b(app));
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
                lengthLimitName = lengthLimitName + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f113f) + "   " + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f100f) + formatTimeForHomeC;
            }
            threadData.setThreadExtendInfo(lengthLimitName);
        }
    }

    public static void q(w26 w26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, w26Var) == null) {
            if (w26Var != null && w26Var.getThreadData() != null && w26Var.getThreadData().isFromHomPage && w26Var.getThreadData().isWorksInfo()) {
                return;
            }
            if (w26Var instanceof e36) {
                ((e36) w26Var).x = true;
            } else if (w26Var instanceof f36) {
                ((f36) w26Var).x = true;
            } else if (w26Var instanceof d36) {
                ((d36) w26Var).x = true;
            }
            w26Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void b(int i, List list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65542, null, i, list) == null) && list != null) {
            int i2 = 0;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                App app = (App) it.next();
                if (app != null) {
                    int b = qd8.b(app);
                    if (b <= 0) {
                        it.remove();
                        yf8.h(l(app), 1, 23);
                    } else {
                        int i3 = i + i2 + 1;
                        if (b <= i3) {
                            i2++;
                        } else {
                            it.remove();
                            yf8.i(l(app), 1, 2, b, i3);
                        }
                    }
                } else {
                    it.remove();
                }
            }
        }
    }

    public static List d(DataRes.Builder builder) {
        InterceptResult invokeL;
        List<App> list;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, builder)) == null) {
            v27 v27Var = null;
            if (builder == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            List<Resource> list2 = builder.resource_list;
            if (list2 != null) {
                for (Resource resource : list2) {
                    u27 u27Var = new u27();
                    u27Var.c(resource);
                    linkedList.add(u27Var);
                }
            }
            List<CardForum> list3 = builder.card_forum;
            if (list3 != null) {
                for (CardForum cardForum : list3) {
                    if (cardForum != null && t27.n(cardForum.card_type.intValue()) && v27Var == null) {
                        v27Var = new v27();
                        v27Var.s(cardForum);
                        if (v27Var.r()) {
                            linkedList.add(v27Var);
                        }
                    }
                }
            }
            List f = le8.l().f();
            if (f != null) {
                f.clear();
            }
            BannerList bannerList = builder.banner_list;
            if (bannerList != null && (list = bannerList.app) != null) {
                for (App app : list) {
                    s27 s27Var = new s27();
                    s27Var.f(app);
                    if (f != null && (advertAppInfo = s27Var.a) != null) {
                        advertAppInfo.isFromHomPage = true;
                        f.add(advertAppInfo);
                    }
                    AdvertAppInfo c = s27Var.c();
                    if (c == null) {
                        yf8.h(s27Var.c(), 1, 100);
                    } else {
                        int n = c.n();
                        if (n != 0) {
                            yf8.h(s27Var.c(), 1, n);
                            if (n != 28 && n != 31) {
                                c.c = -1001;
                            }
                        }
                        if (s27Var.getPosition() <= 0) {
                            yf8.h(s27Var.c(), 1, 23);
                            c.c = -1001;
                        }
                        if (c.h()) {
                            try {
                                if (TextUtils.isEmpty(c.p)) {
                                    yf8.h(s27Var.c(), 1, 26);
                                } else if (vm8.b(TbadkCoreApplication.getInst().getContext(), c.p) && an5.a().p()) {
                                    yf8.h(s27Var.c(), 1, 3);
                                }
                            } catch (Exception unused) {
                                yf8.h(s27Var.c(), 1, 100);
                            }
                        }
                        linkedList.add(s27Var);
                    }
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    public static w26 e(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            if (threadData.isShareThread) {
                e36 e36Var = new e36();
                e36Var.a = threadData;
                return e36Var;
            } else if (g36.W(threadData)) {
                return new g36(threadData);
            } else {
                if (d36.W(threadData)) {
                    return new d36(threadData);
                }
                if (!e36.W(threadData) && !e36.X(threadData)) {
                    if (!f36.R(threadData)) {
                        return null;
                    }
                    return new f36(threadData);
                }
                e36 e36Var2 = new e36();
                threadData.isLinkThread();
                threadData.isSmartAppThreadType();
                if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                    threadData.isGodThread();
                }
                e36Var2.a = threadData;
                return e36Var2;
            }
        }
        return (w26) invokeL.objValue;
    }

    public static void s(w26 w26Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, null, w26Var) == null) && w26Var != null && w26Var.getThreadData() != null && w26Var.getThreadData().getTopAgreePost() != null && w26Var.getThreadData().getTopAgreePost().s() != null && w26Var.getThreadData().getTopAgreePost().s().getUserId() != null) {
            if (w26Var instanceof e36) {
                ((e36) w26Var).y = true;
            } else if (w26Var instanceof f36) {
                ((f36) w26Var).y = true;
            } else if (w26Var instanceof d36) {
                ((d36) w26Var).y = true;
            }
            w26Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void h(BannerList.Builder builder, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65548, null, builder, i) == null) && builder != null && builder.app != null) {
            for (int i2 = 0; i2 < builder.app.size(); i2++) {
                App app = (App) builder.app.get(i2);
                if (app != null) {
                    App.Builder builder2 = new App.Builder(app);
                    qd8.c(builder2, i);
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
                List list = builder2.app;
                if (list != null) {
                    Iterator it = list.iterator();
                    int i6 = 0;
                    while (it.hasNext()) {
                        App app = (App) it.next();
                        if (app != null) {
                            int b = qd8.b(app);
                            if (b <= 0) {
                                it.remove();
                                yf8.h(l(app), 1, 23);
                            } else {
                                int i7 = i4 + i6 + 1;
                                if (b <= i7) {
                                    i6++;
                                } else {
                                    it.remove();
                                    yf8.i(l(app), 1, 2, b, i7);
                                }
                            }
                        } else {
                            it.remove();
                        }
                    }
                }
                h(builder2, i5);
                List list2 = builder2.app;
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
        List list;
        List list2;
        List list3;
        List list4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && builder2 != null && builder != null) {
            List list5 = builder2.card_forum;
            if (list5 != null && (list4 = builder.card_forum) != null) {
                list4.addAll(list5);
            }
            List list6 = builder2.card_topic;
            if (list6 != null && (list3 = builder.card_topic) != null) {
                list3.addAll(list6);
            }
            List list7 = builder2.resource_list;
            if (list7 != null && (list2 = builder.resource_list) != null) {
                list2.addAll(list7);
            }
            if (i == 0) {
                builder.banner_list = j(z, builder.banner_list, builder2.banner_list, i2);
            } else {
                List list8 = builder.thread_list;
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
                    ux4.k().u("has_requested_new_user_guide", true);
                }
            }
            if (builder2.interestion != null && builder != null && (list = builder.interestion) != null && list.size() == 0) {
                builder.interestion.addAll(builder2.interestion);
            }
            List list9 = builder2.card_god;
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
            List list = builder2.app;
            if (list != null) {
                Iterator it = list.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    App app = (App) it.next();
                    if (app != null) {
                        int b = qd8.b(app);
                        if (b <= 0) {
                            it.remove();
                            yf8.h(l(app), 1, 23);
                        } else {
                            int i3 = i + i2 + 1;
                            if (b <= i3) {
                                i2++;
                            } else {
                                it.remove();
                                yf8.i(l(app), 1, 2, b, i3);
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
            List list2 = builder2.app;
            if (list2 != null) {
                builder.app.addAll(0, list2);
            }
            return builder.build(false);
        }
        return (BannerList) invokeCommon.objValue;
    }

    public static void m(DataRes.Builder builder) {
        BannerList.Builder builder2;
        List list;
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
                App app = (App) builder2.app.get(size);
                s27 s27Var = new s27();
                s27Var.f(app);
                if (app != null) {
                    i = qd8.b(app);
                } else {
                    i = -1;
                }
                if (i < 0) {
                    yf8.h(s27Var.c(), 1, 33);
                    builder2.app.remove(size);
                } else {
                    int i2 = count + size;
                    if (i > i2) {
                        yf8.i(s27Var.p(), 1, 2, i, i2);
                        builder2.app.remove(size);
                    } else {
                        AdvertAppInfo c = s27Var.c();
                        if (c == null) {
                            yf8.h(s27Var.c(), 1, 100);
                            builder2.app.remove(size);
                        } else {
                            int n = c.n();
                            if (n != 0) {
                                yf8.h(s27Var.c(), 1, n);
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
                    if (((CardForum) builder.card_forum.get(size)).position.longValue() > count) {
                        builder.card_forum.remove(size);
                    }
                }
                for (int size2 = builder.card_topic.size() - 1; size2 >= 0; size2--) {
                    if (((CardTopic) builder.card_topic.get(size2)).position.intValue() > count) {
                        builder.card_topic.remove(size2);
                    }
                }
                for (int size3 = builder.resource_list.size() - 1; size3 >= 0; size3--) {
                    if (((Resource) builder.resource_list.get(size3)).position.longValue() > count) {
                        builder.resource_list.remove(size3);
                    }
                }
                for (int size4 = builder.card_god.size() - 1; size4 >= 0; size4--) {
                    if (((CardGod) builder.card_god.get(size4)).position.intValue() > count) {
                        builder.card_god.remove(size4);
                    }
                }
            }
        }
    }
}
