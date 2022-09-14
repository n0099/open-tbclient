package com.baidu.tieba;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.Personalized.UserFollowLive;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class g27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final i27 a;
    public final int b;
    public int c;
    public o27 d;
    public int e;
    public int f;
    public int g;
    public ArrayList<ThreadInfo> h;
    public ArrayList<App> i;
    public Long j;
    public List<Cdo> k;

    /* loaded from: classes4.dex */
    public class a implements Comparator<q26> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(g27 g27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(q26 q26Var, q26 q26Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, q26Var, q26Var2)) == null) {
                if (q26Var != null && q26Var2 != null) {
                    if (q26Var.getPosition() > q26Var2.getPosition()) {
                        return 1;
                    }
                    if (q26Var.getPosition() < q26Var2.getPosition()) {
                        return -1;
                    }
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends vk5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c26 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g27 g27Var, int i, String str, c26 c26Var) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g27Var, Integer.valueOf(i), str, c26Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = c26Var;
        }

        @Override // com.baidu.tieba.vk5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), d(), null)));
                c26 c26Var = this.h;
                if (c26Var instanceof k26) {
                    statisticItem = ((k26) c26Var).S();
                } else if (c26Var instanceof l26) {
                    statisticItem = ((l26) c26Var).Q(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public g27() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.d = new o27();
        this.e = 0;
        this.j = 0L;
        this.a = new i27();
        this.b = bx4.k().l("home_page_max_thread_count", 300);
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.k = new ArrayList();
    }

    public final b27 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            i27 i27Var = this.a;
            if (i27Var != null && !ListUtils.isEmpty(i27Var.a)) {
                for (Cdo cdo : this.a.a) {
                    if (cdo instanceof b27) {
                        return (b27) cdo;
                    }
                }
            }
            return null;
        }
        return (b27) invokeV.objValue;
    }

    public final c27 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            i27 i27Var = this.a;
            if (i27Var != null && !ListUtils.isEmpty(i27Var.a)) {
                for (Cdo cdo : this.a.a) {
                    if (cdo instanceof c27) {
                        return (c27) cdo;
                    }
                }
            }
            return null;
        }
        return (c27) invokeV.objValue;
    }

    public i27 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)})) == null) {
            if (i == 0 || i == 1) {
                if (builder == null) {
                    builder = new DataRes.Builder();
                }
                if (builder2 == null) {
                    builder2 = new DataRes.Builder();
                }
                j27.c(builder);
                j27.c(builder2);
                q(z, builder, builder2, i);
                List<ThreadInfo> r = r(builder, i, this.b);
                j27.n(builder);
                List<q26> d = j27.d(builder);
                t(d);
                List<Cdo> g = g(builder.thread_list, d, builder2.user_follow_live, i, 0, builder2);
                List<Cdo> g2 = g(r, new ArrayList(), builder2.user_follow_live, i, 1, null);
                this.d.a(g);
                h27.c(builder, g);
                i27 i27Var = this.a;
                i27Var.a = g;
                i27Var.c = g2 == null ? 0 : g2.size();
                return this.a;
            }
            return null;
        }
        return (i27) invokeCommon.objValue;
    }

    public List<ThreadInfo> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.h : (List) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : invokeV.intValue;
    }

    public void f(List<Cdo> list, UserFollowLive userFollowLive) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, list, userFollowLive) == null) && UbsABTestHelper.isHomePageRecommendLiveSencondFloorShow() && a() == null && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
            b27 b27Var = new b27();
            b27Var.f(userFollowLive);
            list.add(0, b27Var);
            this.a.a.add(0, b27Var);
            b27Var.position = -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<Cdo> g(List<ThreadInfo> list, List<q26> list2, UserFollowLive userFollowLive, int i, int i2, DataRes.Builder builder) {
        InterceptResult invokeCommon;
        b27 a2;
        c27 c27Var;
        boolean z;
        c26 e;
        k26 g;
        ThreadRecommendInfoData threadRecommendInfoData;
        k26 g2;
        k26 g3;
        k26 g4;
        k26 g5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{list, list2, userFollowLive, Integer.valueOf(i), Integer.valueOf(i2), builder})) == null) {
            if (list == null) {
                return null;
            }
            if (builder != null && !ListUtils.isEmpty(builder.thread_list) && builder.active_center != null) {
                ThreadInfo threadInfo = builder.thread_list.get(builder.thread_list.size() - 1);
                if (threadInfo.id.longValue() > 0 && sl4.f().l()) {
                    this.j = threadInfo.id;
                }
            }
            List<Cdo> arrayList = new ArrayList<>(ListUtils.getCount(list));
            for (ThreadInfo threadInfo2 : list) {
                ThreadData threadData = new ThreadData();
                AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                threadData.isFromHomPage = true;
                threadData.parserProtobuf(threadInfo2);
                arrayList.add(threadData);
            }
            if (builder != null && lx6.n(builder.hot_recomforum, -1)) {
                lx6 lx6Var = new lx6();
                lx6Var.floorPosition = builder.hot_recomforum.floor.intValue() > 0 ? builder.hot_recomforum.floor.intValue() - 1 : 0;
                if (lx6Var.j(builder.hot_recomforum.tab_list)) {
                    h(lx6Var, lx6Var.floorPosition, arrayList);
                }
            }
            if (i2 == 0 && UbsABTestHelper.isPersonalizeFunAdABTest()) {
                int f = zz4.f();
                int e2 = zz4.e();
                if (i == 0) {
                    e2 = zz4.a();
                    this.k.clear();
                }
                i(e2, f, arrayList);
            }
            LinkedList<Cdo> linkedList = new LinkedList();
            int i3 = 0;
            for (Cdo cdo : arrayList) {
                boolean z2 = cdo instanceof ThreadData;
                if (z2 && ((ThreadData) cdo).isFunAdPlaceHolder()) {
                    linkedList.add(cdo);
                } else if (z2) {
                    ThreadData threadData2 = (ThreadData) cdo;
                    if (!TextUtils.isEmpty(threadData2.getLegoCard())) {
                        bs4 bs4Var = new bs4();
                        bs4Var.h(threadData2.getLegoCard());
                        bs4Var.position = i3;
                        linkedList.add(bs4Var);
                    } else if (b57.N(threadData2)) {
                        if (!StringUtils.isNull(threadData2.getTopicModule().topic_name)) {
                            b57 b57Var = new b57();
                            b57Var.P(threadData2.getTopicModule());
                            b57Var.Z = 1;
                            b57Var.position = i3;
                            b57Var.Q(threadData2);
                            b57Var.setSupportType(BaseCardInfo.SupportType.FULL);
                            linkedList.add(b57Var);
                        }
                    } else if (!k26.W(threadData2) && !l26.R(threadData2) && !m26.W(threadData2)) {
                        if (f26.W(threadData2) && threadData2.isBJHArticleThreadType()) {
                            f26 f26Var = new f26(threadData2);
                            f26Var.position = i3;
                            linkedList.add(f26Var);
                        } else {
                            c26 e3 = j27.e(threadData2);
                            if (e3 != null) {
                                e3.g = threadData2.getTid();
                                e3.position = i3;
                            }
                            if (e3 != null && e3.isValid()) {
                                linkedList.add(e3);
                            }
                        }
                    } else {
                        k26 g6 = j27.g(threadData2);
                        if (g6 != null) {
                            if (threadData2.showCardEnterFourm()) {
                                if (g6.isValid()) {
                                    g6.g = threadData2.getTid();
                                    g6.position = i3;
                                    j27.t(g6);
                                    linkedList.add(g6);
                                }
                            } else {
                                ThreadData threadData3 = g6.a;
                                if (threadData3 != null && threadData3.getForumData() != null && !StringUtils.isNull(threadData3.getForumData().b)) {
                                    g6.g = threadData2.getTid();
                                    g6.position = i3;
                                    j27.r(g6);
                                    linkedList.add(g6);
                                    z = true;
                                    e = j27.e(threadData2);
                                    if (e != null) {
                                        e.g = threadData2.getTid();
                                        e.position = i3;
                                        if (e instanceof k26) {
                                            if (threadData2.isBJHNormalThreadType()) {
                                                j27.u(e);
                                            } else if (threadData2.picCount() == 1) {
                                                j27.w(e);
                                                int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                                                e.j = imageWidthAndHeight[0];
                                                e.k = imageWidthAndHeight[1];
                                            } else if (threadData2.picCount() >= 2) {
                                                j27.v(e);
                                            } else {
                                                j27.x(e);
                                            }
                                        } else if (e instanceof l26) {
                                            j27.y(e);
                                        }
                                    }
                                    if (e instanceof m26) {
                                        j27.z(e);
                                    }
                                    if (e != null && e.isValid()) {
                                        e.a.insertItemToTitleOrAbstractText();
                                        if (!threadData2.isUgcThreadType() && threadData2.getAuthor() != null && z) {
                                            String format = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ac), threadData2.getAuthor().getName_show());
                                            SpannableString spannableString = new SpannableString(format);
                                            spannableString.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), e), 0, format.length() - 1, 33);
                                            e.a.insertUsernameIntoTitleOrAbstract(spannableString);
                                        }
                                        linkedList.add(e);
                                    }
                                    if (threadData2.getItem() != null && (g5 = j27.g(threadData2)) != null) {
                                        g5.g = threadData2.getTid();
                                        g5.position = i3;
                                        j27.A(g5);
                                        if (!k26.W(threadData2)) {
                                            g5.L("1");
                                        } else if (l26.R(threadData2)) {
                                            g5.L("2");
                                        }
                                        linkedList.add(g5);
                                    }
                                    if ((ListUtils.isEmpty(threadData2.getLinkDataList()) || !ListUtils.isEmpty(threadData2.getGoodsDataList())) && (g = j27.g(threadData2)) != null) {
                                        g.g = threadData2.getTid();
                                        g.position = i3;
                                        if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) != 1) {
                                            j27.D(g);
                                        } else {
                                            j27.B(g);
                                        }
                                        linkedList.add(g);
                                    }
                                    threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                    if (threadRecommendInfoData != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason) && (g4 = j27.g(threadData2)) != null) {
                                        g4.g = threadData2.getTid();
                                        g4.position = i3;
                                        j27.C(g4);
                                        if (g4.isValid()) {
                                            linkedList.add(g4);
                                        }
                                    }
                                    if (threadData2.showCardEnterFourm() && (g3 = j27.g(threadData2)) != null) {
                                        g3.g = threadData2.getTid();
                                        g3.position = i3;
                                        j27.q(g3);
                                        if (!k26.W(threadData2)) {
                                            g3.L("1");
                                        } else if (l26.R(threadData2)) {
                                            g3.L("2");
                                        }
                                        if (!threadData2.showCardEnterFourm() && !StringUtils.isNull(threadData2.getForum_name())) {
                                            linkedList.add(g3);
                                        } else if (!StringUtils.isNull(threadData2.getForum_name())) {
                                            linkedList.add(g3);
                                        }
                                    }
                                    if (threadData2.getTopAgreePost() != null) {
                                        k26 g7 = j27.g(threadData2);
                                        if (g7 != null) {
                                            g7.g = threadData2.getTid();
                                            g7.position = i3;
                                            j27.s(g7);
                                        }
                                        if (g7 != null && g7.isValid()) {
                                            linkedList.add(g7);
                                        }
                                    }
                                    g2 = j27.g(threadData2);
                                    if (g2 != null) {
                                        g2.g = threadData2.getTid();
                                        g2.position = i3;
                                        j27.p(g2);
                                    }
                                    if (g2 != null && g2.isValid()) {
                                        linkedList.add(g2);
                                    }
                                } else if (g6.isValid()) {
                                    g6.g = threadData2.getTid();
                                    g6.position = i3;
                                    j27.t(g6);
                                    linkedList.add(g6);
                                }
                            }
                        }
                        z = false;
                        e = j27.e(threadData2);
                        if (e != null) {
                        }
                        if (e instanceof m26) {
                        }
                        if (e != null) {
                            e.a.insertItemToTitleOrAbstractText();
                            if (!threadData2.isUgcThreadType()) {
                                String format2 = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ac), threadData2.getAuthor().getName_show());
                                SpannableString spannableString2 = new SpannableString(format2);
                                spannableString2.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), e), 0, format2.length() - 1, 33);
                                e.a.insertUsernameIntoTitleOrAbstract(spannableString2);
                            }
                            linkedList.add(e);
                        }
                        if (threadData2.getItem() != null) {
                            g5.g = threadData2.getTid();
                            g5.position = i3;
                            j27.A(g5);
                            if (!k26.W(threadData2)) {
                            }
                            linkedList.add(g5);
                        }
                        if (ListUtils.isEmpty(threadData2.getLinkDataList())) {
                        }
                        g.g = threadData2.getTid();
                        g.position = i3;
                        if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) != 1) {
                        }
                        linkedList.add(g);
                        threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                        if (threadRecommendInfoData != null) {
                            g4.g = threadData2.getTid();
                            g4.position = i3;
                            j27.C(g4);
                            if (g4.isValid()) {
                            }
                        }
                        if (threadData2.showCardEnterFourm()) {
                            g3.g = threadData2.getTid();
                            g3.position = i3;
                            j27.q(g3);
                            if (!k26.W(threadData2)) {
                            }
                            if (!threadData2.showCardEnterFourm()) {
                            }
                            if (!StringUtils.isNull(threadData2.getForum_name())) {
                            }
                        }
                        if (threadData2.getTopAgreePost() != null) {
                        }
                        g2 = j27.g(threadData2);
                        if (g2 != null) {
                        }
                        if (g2 != null) {
                            linkedList.add(g2);
                        }
                    }
                    long g8 = dh.g(threadData2.getId(), 0L);
                    if (g8 != 0 && g8 == this.j.longValue()) {
                        if (builder.active_center != null) {
                            c27Var = new c27();
                            c27Var.N(builder.active_center);
                        } else {
                            c27Var = null;
                        }
                        if (c27Var == null) {
                            c27Var = b();
                        }
                        if (c27Var != null) {
                            i3++;
                            c27Var.R = i3;
                            linkedList.add(c27Var);
                        }
                    }
                    i3++;
                } else if (cdo instanceof BaseCardInfo) {
                    linkedList.add(cdo);
                } else {
                    linkedList.add(cdo);
                }
                i3++;
            }
            if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
                int i4 = 0;
                int i5 = 0;
                for (int i6 = 0; i6 < ListUtils.getCount(list2); i6++) {
                    q26 q26Var = (q26) ListUtils.getItem(list2, i6);
                    if (q26Var != null && i4 < linkedList.size()) {
                        while (i4 < linkedList.size() && (!(linkedList.get(i4) instanceof c26) || ((c26) linkedList.get(i4)).position + i5 != q26Var.getPosition() - 1)) {
                            i4++;
                        }
                        if (linkedList.size() > i4 && i4 > 0) {
                            linkedList.add(i4, q26Var);
                            i5++;
                        }
                    }
                }
                int i7 = 0;
                int i8 = 0;
                for (Cdo cdo2 : linkedList) {
                    if (cdo2 instanceof zr4) {
                        ((zr4) cdo2).setPosition(i7 + 1);
                        i8++;
                    } else if (cdo2 instanceof BaseCardInfo) {
                        BaseCardInfo baseCardInfo = (BaseCardInfo) cdo2;
                        i7 = baseCardInfo.position + i8;
                        baseCardInfo.position = i7;
                    }
                }
            }
            if (i2 == 0 && UbsABTestHelper.isHomePageRecommendLiveSencondFloorShow()) {
                if (i == 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
                    b27 b27Var = new b27();
                    b27Var.f(userFollowLive);
                    linkedList.add(0, b27Var);
                    b27Var.position = -1;
                } else if (i == 1 && (a2 = a()) != null) {
                    linkedList.add(0, a2);
                    a2.position = -1;
                }
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            return linkedList;
        }
        return (List) invokeCommon.objValue;
    }

    public void h(lq4 lq4Var, int i, List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048583, this, lq4Var, i, list) == null) || lq4Var == null || list == null || i <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    lq4Var.floorPosition = i;
                    ListUtils.add(list, i3, lq4Var);
                    return;
                }
                i2++;
            }
        }
    }

    public final void i(int i, int i2, List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, list) == null) || ListUtils.isEmpty(list) || i < 0 || i2 < 1) {
            return;
        }
        ListIterator<Cdo> listIterator = list.listIterator();
        int i3 = 0;
        int i4 = 0;
        while (listIterator.hasNext()) {
            if (i3 == i || (i3 > i && (i3 - i) % i2 == 0)) {
                if (i4 < this.k.size()) {
                    listIterator.add(this.k.get(i4));
                } else {
                    ThreadData threadData = new ThreadData();
                    tm8 tm8Var = new tm8();
                    tm8Var.n(true);
                    threadData.funAdData = tm8Var;
                    listIterator.add(threadData);
                    this.k.add(threadData);
                }
                i4++;
            }
            listIterator.next();
            i3++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
        if (r5.size() <= r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
        r5.add(r0, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
        r5.add(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(List<Cdo> list, lx6 lx6Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048585, this, list, lx6Var, i) == null) || lx6Var == null || ListUtils.isEmpty(lx6Var.f())) {
            return;
        }
        int i2 = 0;
        if (list.size() > 0) {
            int i3 = 0;
            while (i3 < list.size() && ((!(list.get(i3) instanceof c26) || ((c26) list.get(i3)).position + 1 != i) && (!(list.get(i3) instanceof zr4) || ((zr4) list.get(i3)).i() + 1 != i))) {
                i3++;
            }
        }
        int i4 = 0;
        for (Cdo cdo : list) {
            if (cdo instanceof lx6) {
                ((lx6) cdo).position = i2 + 1;
                i4++;
            } else if (cdo instanceof BaseCardInfo) {
                BaseCardInfo baseCardInfo = (BaseCardInfo) cdo;
                int i5 = baseCardInfo.position + i4;
                baseCardInfo.position = i5;
                i2 = i5;
            }
        }
    }

    public void k(List<Cdo> list, wf8 wf8Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048586, this, list, wf8Var, i) == null) || ListUtils.isEmpty(list) || wf8Var == null || i < 0) {
            return;
        }
        s(list);
        if (i == 0) {
            j(list, lx6.c(wf8Var), wf8Var.a);
            return;
        }
        while (i < list.size() && !(list.get(i) instanceof c26) && !(list.get(i) instanceof zr4)) {
            i++;
        }
        if (list.get(i) instanceof c26) {
            j(list, lx6.c(wf8Var), ((c26) list.get(i)).position + 2);
        } else if (list.get(i) instanceof zr4) {
            j(list, lx6.c(wf8Var), ((zr4) list.get(i)).i() + 2);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ArrayList<ThreadInfo> arrayList = this.h;
            return (arrayList == null || ListUtils.isEmpty(arrayList)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.e > 0 : invokeV.booleanValue;
    }

    public final void n(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) {
            j27.k(z, builder, builder2, i, this.c, this.f, this.g);
        }
    }

    public final void o(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        List<ThreadInfo> list;
        List<ThreadInfo> list2;
        Long l;
        Long l2;
        Long l3;
        Long l4;
        Long l5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) || builder == null || builder2 == null || (list = builder.thread_list) == null || (list2 = builder2.thread_list) == null) {
            return;
        }
        this.f = ListUtils.getCount(list);
        BannerList bannerList = builder.banner_list;
        if (bannerList != null) {
            this.g = ListUtils.getCount(bannerList.app);
        } else {
            this.g = 0;
        }
        int count = ListUtils.getCount(list) + ListUtils.getCount(this.h);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null && !TextUtils.isEmpty(threadInfo.lego_card)) {
                hashSet2.add(threadInfo.lego_card);
            } else if (threadInfo != null && (l5 = threadInfo.tid) != null) {
                hashSet.add(l5);
            }
        }
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        Iterator<ThreadInfo> it = this.h.iterator();
        while (it.hasNext()) {
            ThreadInfo next = it.next();
            if (next != null && !TextUtils.isEmpty(next.lego_card)) {
                hashSet4.add(next.lego_card);
            } else if (next != null && (l4 = next.tid) != null) {
                hashSet3.add(l4);
            }
        }
        if (i == 1) {
            if (!ListUtils.isEmpty(list2)) {
                this.d.b((ThreadInfo) ListUtils.getItem(list2, 0));
            }
            for (ThreadInfo threadInfo2 : list2) {
                if (threadInfo2 != null && !TextUtils.isEmpty(threadInfo2.lego_card)) {
                    if (!hashSet2.contains(threadInfo2.lego_card) && !hashSet4.contains(threadInfo2.lego_card)) {
                        list.add(threadInfo2);
                    }
                } else if (threadInfo2 != null && (l3 = threadInfo2.tid) != null && !hashSet.contains(l3) && !hashSet3.contains(threadInfo2.tid)) {
                    list.add(threadInfo2);
                    JSONObject b2 = ye8.b(threadInfo2);
                    if (b2 != null) {
                        arrayList.add(b2);
                    }
                }
            }
        } else {
            this.d.c(z, list);
            if (m()) {
                BannerList bannerList2 = builder.banner_list;
                if (bannerList2 != null && !ListUtils.isEmpty(bannerList2.app)) {
                    this.i.addAll(0, builder.banner_list.app);
                    BannerList.Builder builder3 = new BannerList.Builder(builder.banner_list);
                    builder3.app = new LinkedList();
                    builder.banner_list = builder3.build(false);
                }
                this.h.addAll(0, list);
                list.clear();
                hashSet.clear();
                hashSet2.clear();
                if (ListUtils.getCount(this.h) > this.b) {
                    for (int size = this.h.size() - 1; size >= this.b; size--) {
                        this.h.remove(size);
                    }
                }
                hashSet3.clear();
                hashSet4.clear();
                Iterator<ThreadInfo> it2 = this.h.iterator();
                while (it2.hasNext()) {
                    ThreadInfo next2 = it2.next();
                    if (next2 != null && !TextUtils.isEmpty(next2.lego_card)) {
                        hashSet4.add(next2.lego_card);
                    } else if (next2 != null && (l2 = next2.tid) != null) {
                        hashSet3.add(l2);
                    }
                }
            }
            for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                ThreadInfo threadInfo3 = (ThreadInfo) ListUtils.getItem(list2, count2);
                if (threadInfo3 != null && !TextUtils.isEmpty(threadInfo3.lego_card)) {
                    if (!hashSet2.contains(threadInfo3.lego_card) && !hashSet4.contains(threadInfo3.lego_card)) {
                        list.add(0, threadInfo3);
                    }
                } else if (threadInfo3 != null && (l = threadInfo3.tid) != null && ((!hashSet.contains(l) && !hashSet3.contains(threadInfo3.tid)) || threadInfo3.is_highlight.intValue() == 1)) {
                    list.add(0, threadInfo3);
                    JSONObject b3 = ye8.b(threadInfo3);
                    if (b3 != null) {
                        arrayList.add(0, b3);
                    }
                }
            }
        }
        if (m()) {
            if (!ListUtils.isEmpty(this.i) && builder2.banner_list != null) {
                int count3 = ListUtils.getCount(list2) + ListUtils.getCount(builder2.banner_list.app);
                for (int i2 = 0; i2 < this.i.size(); i2++) {
                    App app = this.i.get(i2);
                    if (app != null) {
                        App.Builder builder4 = new App.Builder(app);
                        rc8.c(builder4, count3);
                        App build = builder4.build(false);
                        this.i.remove(i2);
                        this.i.add(i2, build);
                    }
                }
            }
            if (ListUtils.getCount(list) >= this.e) {
                list.addAll(this.h);
                this.h.clear();
                BannerList.Builder builder5 = new BannerList.Builder(builder.banner_list);
                if (builder5.app == null) {
                    builder5.app = new LinkedList();
                }
                builder5.app.addAll(this.i);
                builder.banner_list = builder5.build(false);
                this.i.clear();
            }
        }
        int count4 = (ListUtils.getCount(list) + ListUtils.getCount(this.h)) - count;
        this.a.b = count4;
        this.c = count4;
        ye8.f().h("HOME", arrayList);
    }

    public final void p(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, list, list2) == null) || list == null || list2 == null) {
            return;
        }
        list.addAll(list2);
    }

    public final void q(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) || builder == null || builder2 == null) {
            return;
        }
        Integer num = builder2.fresh_ctrl_num;
        int intValue = (num == null || num.intValue() <= 0) ? 0 : builder2.fresh_ctrl_num.intValue();
        this.e = intValue;
        int i2 = this.b;
        if (intValue > i2) {
            intValue = i2;
        }
        this.e = intValue;
        o(z, builder, builder2, i);
        n(z, builder, builder2, i);
        p(builder.thread_personalized, builder2.thread_personalized);
    }

    public final List<ThreadInfo> r(DataRes.Builder builder, int i, int i2) {
        InterceptResult invokeLII;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048593, this, builder, i, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (builder != null && (list = builder.thread_list) != null) {
                if (i == 1) {
                    for (int count = ((ListUtils.getCount(list) - i2) + 30) - 1; count >= 30; count--) {
                        if (list.size() > count) {
                            arrayList.add(list.remove(count));
                        }
                    }
                } else {
                    for (int count2 = ListUtils.getCount(list) - 1; count2 >= i2; count2--) {
                        list.remove(count2);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLII.objValue;
    }

    public final void s(List<Cdo> list) {
        BaseCardInfo baseCardInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            Iterator<Cdo> it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                Cdo next = it.next();
                if ((next instanceof BaseCardInfo) && (i = (baseCardInfo = (BaseCardInfo) next).position) > 0) {
                    baseCardInfo.position = i - i2;
                }
                if (next instanceof lx6) {
                    it.remove();
                    i2++;
                }
            }
        }
    }

    public final void t(List<q26> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, list) == null) || list == null) {
            return;
        }
        Collections.sort(list, new a(this));
    }
}
