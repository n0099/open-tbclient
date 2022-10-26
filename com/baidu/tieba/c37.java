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
import tbclient.Personalized.UserFollowLive;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class c37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final e37 a;
    public final int b;
    public int c;
    public k37 d;
    public int e;
    public int f;
    public int g;
    public ArrayList h;
    public ArrayList i;
    public Long j;
    public List k;

    /* loaded from: classes3.dex */
    public class a implements Comparator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(c37 c37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c37Var};
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
        public int compare(k36 k36Var, k36 k36Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, k36Var, k36Var2)) == null) {
                if (k36Var != null && k36Var2 != null) {
                    if (k36Var.getPosition() > k36Var2.getPosition()) {
                        return 1;
                    }
                    if (k36Var.getPosition() < k36Var2.getPosition()) {
                        return -1;
                    }
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends pl5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w26 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c37 c37Var, int i, String str, w26 w26Var) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c37Var, Integer.valueOf(i), str, w26Var};
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
            this.h = w26Var;
        }

        @Override // com.baidu.tieba.pl5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), d(), null)));
                w26 w26Var = this.h;
                if (w26Var instanceof e36) {
                    statisticItem = ((e36) w26Var).S();
                } else if (w26Var instanceof f36) {
                    statisticItem = ((f36) w26Var).Q(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public c37() {
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
        this.d = new k37();
        this.e = 0;
        this.j = 0L;
        this.a = new e37();
        this.b = ux4.k().l("home_page_max_thread_count", 300);
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.k = new ArrayList();
    }

    public final x27 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e37 e37Var = this.a;
            if (e37Var != null && !ListUtils.isEmpty(e37Var.a)) {
                for (eo eoVar : this.a.a) {
                    if (eoVar instanceof x27) {
                        return (x27) eoVar;
                    }
                }
            }
            return null;
        }
        return (x27) invokeV.objValue;
    }

    public final y27 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            e37 e37Var = this.a;
            if (e37Var != null && !ListUtils.isEmpty(e37Var.a)) {
                for (eo eoVar : this.a.a) {
                    if (eoVar instanceof y27) {
                        return (y27) eoVar;
                    }
                }
            }
            return null;
        }
        return (y27) invokeV.objValue;
    }

    public e37 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        InterceptResult invokeCommon;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)})) == null) {
            if (i != 0 && i != 1) {
                return null;
            }
            if (builder == null) {
                builder = new DataRes.Builder();
            }
            if (builder2 == null) {
                builder2 = new DataRes.Builder();
            }
            f37.c(builder);
            f37.c(builder2);
            p(z, builder, builder2, i);
            List q = q(builder, i, this.b);
            f37.n(builder);
            List d = f37.d(builder);
            s(d);
            List f = f(builder.thread_list, d, builder2.user_follow_live, i, 0, builder2);
            List f2 = f(q, new ArrayList(), builder2.user_follow_live, i, 1, null);
            this.d.a(f);
            d37.c(builder, f);
            e37 e37Var = this.a;
            e37Var.a = f;
            if (f2 == null) {
                size = 0;
            } else {
                size = f2.size();
            }
            e37Var.c = size;
            return this.a;
        }
        return (e37) invokeCommon.objValue;
    }

    public List d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h;
        }
        return (List) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ArrayList arrayList = this.h;
            if (arrayList != null && !ListUtils.isEmpty(arrayList)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.e > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
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
    public final List f(List list, List list2, UserFollowLive userFollowLive, int i, int i2, DataRes.Builder builder) {
        InterceptResult invokeCommon;
        x27 a2;
        y27 y27Var;
        boolean z;
        w26 e;
        e36 g;
        ThreadRecommendInfoData threadRecommendInfoData;
        e36 g2;
        e36 g3;
        e36 g4;
        e36 g5;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{list, list2, userFollowLive, Integer.valueOf(i), Integer.valueOf(i2), builder})) == null) {
            if (list == null) {
                return null;
            }
            if (builder != null && !ListUtils.isEmpty(builder.thread_list) && builder.active_center != null) {
                ThreadInfo threadInfo = (ThreadInfo) builder.thread_list.get(builder.thread_list.size() - 1);
                if (threadInfo.id.longValue() > 0 && gm4.f().l()) {
                    this.j = threadInfo.id;
                }
            }
            List<eo> arrayList = new ArrayList(ListUtils.getCount(list));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ThreadData threadData = new ThreadData();
                AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                threadData.isFromHomPage = true;
                threadData.parserProtobuf((ThreadInfo) it.next());
                arrayList.add(threadData);
            }
            if (builder != null && gy6.n(builder.hot_recomforum, -1)) {
                gy6 gy6Var = new gy6();
                if (builder.hot_recomforum.floor.intValue() > 0) {
                    i3 = builder.hot_recomforum.floor.intValue() - 1;
                } else {
                    i3 = 0;
                }
                gy6Var.floorPosition = i3;
                if (gy6Var.j(builder.hot_recomforum.tab_list)) {
                    g(gy6Var, gy6Var.floorPosition, arrayList);
                }
            }
            if (i2 == 0 && UbsABTestHelper.isPersonalizeFunAdABTest()) {
                int f = r05.f();
                int e2 = r05.e();
                if (i == 0) {
                    e2 = r05.a();
                    this.k.clear();
                }
                h(e2, f, arrayList);
            }
            LinkedList<eo> linkedList = new LinkedList();
            int i4 = 0;
            for (eo eoVar : arrayList) {
                boolean z2 = eoVar instanceof ThreadData;
                if (z2 && ((ThreadData) eoVar).isFunAdPlaceHolder()) {
                    linkedList.add(eoVar);
                } else if (z2) {
                    ThreadData threadData2 = (ThreadData) eoVar;
                    if (!TextUtils.isEmpty(threadData2.getLegoCard())) {
                        qs4 qs4Var = new qs4();
                        qs4Var.h(threadData2.getLegoCard());
                        qs4Var.position = i4;
                        linkedList.add(qs4Var);
                    } else if (x57.N(threadData2)) {
                        if (!StringUtils.isNull(threadData2.getTopicModule().topic_name)) {
                            x57 x57Var = new x57();
                            x57Var.P(threadData2.getTopicModule());
                            x57Var.Z = 1;
                            x57Var.position = i4;
                            x57Var.Q(threadData2);
                            x57Var.setSupportType(BaseCardInfo.SupportType.FULL);
                            linkedList.add(x57Var);
                        }
                    } else if (!e36.W(threadData2) && !f36.R(threadData2) && !g36.W(threadData2)) {
                        if (z26.W(threadData2) && threadData2.isBJHArticleThreadType()) {
                            z26 z26Var = new z26(threadData2);
                            z26Var.position = i4;
                            linkedList.add(z26Var);
                        } else {
                            w26 e3 = f37.e(threadData2);
                            if (e3 != null) {
                                e3.g = threadData2.getTid();
                                e3.position = i4;
                            }
                            if (e3 != null && e3.isValid()) {
                                linkedList.add(e3);
                            }
                        }
                    } else {
                        e36 g6 = f37.g(threadData2);
                        if (g6 != null) {
                            if (threadData2.showCardEnterFourm()) {
                                if (g6.isValid()) {
                                    g6.g = threadData2.getTid();
                                    g6.position = i4;
                                    f37.t(g6);
                                    linkedList.add(g6);
                                }
                            } else {
                                ThreadData threadData3 = g6.a;
                                if (threadData3 != null && threadData3.getForumData() != null && !StringUtils.isNull(threadData3.getForumData().b)) {
                                    g6.g = threadData2.getTid();
                                    g6.position = i4;
                                    f37.r(g6);
                                    linkedList.add(g6);
                                    z = true;
                                    e = f37.e(threadData2);
                                    if (e != null) {
                                        e.g = threadData2.getTid();
                                        e.position = i4;
                                        if (e instanceof e36) {
                                            if (threadData2.isBJHNormalThreadType()) {
                                                f37.u(e);
                                            } else if (threadData2.picCount() == 1) {
                                                f37.w(e);
                                                int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                                                e.j = imageWidthAndHeight[0];
                                                e.k = imageWidthAndHeight[1];
                                            } else if (threadData2.picCount() >= 2) {
                                                f37.v(e);
                                            } else {
                                                f37.x(e);
                                            }
                                        } else if (e instanceof f36) {
                                            f37.y(e);
                                        }
                                    }
                                    if (e instanceof g36) {
                                        f37.z(e);
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
                                    if (threadData2.getItem() != null && (g5 = f37.g(threadData2)) != null) {
                                        g5.g = threadData2.getTid();
                                        g5.position = i4;
                                        f37.A(g5);
                                        if (!e36.W(threadData2)) {
                                            g5.L("1");
                                        } else if (f36.R(threadData2)) {
                                            g5.L("2");
                                        }
                                        linkedList.add(g5);
                                    }
                                    if ((ListUtils.isEmpty(threadData2.getLinkDataList()) || !ListUtils.isEmpty(threadData2.getGoodsDataList())) && (g = f37.g(threadData2)) != null) {
                                        g.g = threadData2.getTid();
                                        g.position = i4;
                                        if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) != 1) {
                                            f37.D(g);
                                        } else {
                                            f37.B(g);
                                        }
                                        linkedList.add(g);
                                    }
                                    threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                    if (threadRecommendInfoData != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason) && (g4 = f37.g(threadData2)) != null) {
                                        g4.g = threadData2.getTid();
                                        g4.position = i4;
                                        f37.C(g4);
                                        if (g4.isValid()) {
                                            linkedList.add(g4);
                                        }
                                    }
                                    if (threadData2.showCardEnterFourm() && (g3 = f37.g(threadData2)) != null) {
                                        g3.g = threadData2.getTid();
                                        g3.position = i4;
                                        f37.q(g3);
                                        if (!e36.W(threadData2)) {
                                            g3.L("1");
                                        } else if (f36.R(threadData2)) {
                                            g3.L("2");
                                        }
                                        if (!threadData2.showCardEnterFourm() && !StringUtils.isNull(threadData2.getForum_name())) {
                                            linkedList.add(g3);
                                        } else if (!StringUtils.isNull(threadData2.getForum_name())) {
                                            linkedList.add(g3);
                                        }
                                    }
                                    if (threadData2.getTopAgreePost() != null) {
                                        e36 g7 = f37.g(threadData2);
                                        if (g7 != null) {
                                            g7.g = threadData2.getTid();
                                            g7.position = i4;
                                            f37.s(g7);
                                        }
                                        if (g7 != null && g7.isValid()) {
                                            linkedList.add(g7);
                                        }
                                    }
                                    g2 = f37.g(threadData2);
                                    if (g2 != null) {
                                        g2.g = threadData2.getTid();
                                        g2.position = i4;
                                        f37.p(g2);
                                    }
                                    if (g2 != null && g2.isValid()) {
                                        linkedList.add(g2);
                                    }
                                } else if (g6.isValid()) {
                                    g6.g = threadData2.getTid();
                                    g6.position = i4;
                                    f37.t(g6);
                                    linkedList.add(g6);
                                }
                            }
                        }
                        z = false;
                        e = f37.e(threadData2);
                        if (e != null) {
                        }
                        if (e instanceof g36) {
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
                            g5.position = i4;
                            f37.A(g5);
                            if (!e36.W(threadData2)) {
                            }
                            linkedList.add(g5);
                        }
                        if (ListUtils.isEmpty(threadData2.getLinkDataList())) {
                        }
                        g.g = threadData2.getTid();
                        g.position = i4;
                        if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) != 1) {
                        }
                        linkedList.add(g);
                        threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                        if (threadRecommendInfoData != null) {
                            g4.g = threadData2.getTid();
                            g4.position = i4;
                            f37.C(g4);
                            if (g4.isValid()) {
                            }
                        }
                        if (threadData2.showCardEnterFourm()) {
                            g3.g = threadData2.getTid();
                            g3.position = i4;
                            f37.q(g3);
                            if (!e36.W(threadData2)) {
                            }
                            if (!threadData2.showCardEnterFourm()) {
                            }
                            if (!StringUtils.isNull(threadData2.getForum_name())) {
                            }
                        }
                        if (threadData2.getTopAgreePost() != null) {
                        }
                        g2 = f37.g(threadData2);
                        if (g2 != null) {
                        }
                        if (g2 != null) {
                            linkedList.add(g2);
                        }
                    }
                    long g8 = eh.g(threadData2.getId(), 0L);
                    if (g8 != 0 && g8 == this.j.longValue()) {
                        if (builder.active_center != null) {
                            y27Var = new y27();
                            y27Var.N(builder.active_center);
                        } else {
                            y27Var = null;
                        }
                        if (y27Var == null) {
                            y27Var = b();
                        }
                        if (y27Var != null) {
                            i4++;
                            y27Var.R = i4;
                            linkedList.add(y27Var);
                        }
                    }
                    i4++;
                } else if (eoVar instanceof BaseCardInfo) {
                    linkedList.add(eoVar);
                } else {
                    linkedList.add(eoVar);
                }
                i4++;
            }
            if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
                int i5 = 0;
                int i6 = 0;
                for (int i7 = 0; i7 < ListUtils.getCount(list2); i7++) {
                    k36 k36Var = (k36) ListUtils.getItem(list2, i7);
                    if (k36Var != null && i5 < linkedList.size()) {
                        while (i5 < linkedList.size() && (!(linkedList.get(i5) instanceof w26) || ((w26) linkedList.get(i5)).position + i6 != k36Var.getPosition() - 1)) {
                            i5++;
                        }
                        if (linkedList.size() > i5 && i5 > 0) {
                            linkedList.add(i5, k36Var);
                            i6++;
                        }
                    }
                }
                int i8 = 0;
                int i9 = 0;
                for (eo eoVar2 : linkedList) {
                    if (eoVar2 instanceof os4) {
                        ((os4) eoVar2).setPosition(i8 + 1);
                        i9++;
                    } else if (eoVar2 instanceof BaseCardInfo) {
                        BaseCardInfo baseCardInfo = (BaseCardInfo) eoVar2;
                        i8 = baseCardInfo.position + i9;
                        baseCardInfo.position = i8;
                    }
                }
            }
            if (i2 == 0 && UbsABTestHelper.isHomePageRecommendLiveSencondFloorShow()) {
                if (i == 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
                    x27 x27Var = new x27();
                    x27Var.f(userFollowLive);
                    linkedList.add(0, x27Var);
                    x27Var.position = -1;
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

    public void g(ar4 ar4Var, int i, List list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048582, this, ar4Var, i, list) != null) || ar4Var == null || list == null || i <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (((eo) list.get(i3)) instanceof ThreadData) {
                if (i == i2) {
                    ar4Var.floorPosition = i;
                    ListUtils.add(list, i3, ar4Var);
                    return;
                }
                i2++;
            }
        }
    }

    public final void h(int i, int i2, List list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, list) == null) && !ListUtils.isEmpty(list) && i >= 0 && i2 >= 1) {
            ListIterator listIterator = list.listIterator();
            int i3 = 0;
            int i4 = 0;
            while (listIterator.hasNext()) {
                if (i3 == i || (i3 > i && (i3 - i) % i2 == 0)) {
                    if (i4 < this.k.size()) {
                        listIterator.add(this.k.get(i4));
                    } else {
                        ThreadData threadData = new ThreadData();
                        pn8 pn8Var = new pn8();
                        pn8Var.n(true);
                        threadData.funAdData = pn8Var;
                        listIterator.add(threadData);
                        this.k.add(threadData);
                    }
                    i4++;
                }
                listIterator.next();
                i3++;
            }
        }
    }

    public final List q(DataRes.Builder builder, int i, int i2) {
        InterceptResult invokeLII;
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048592, this, builder, i, i2)) == null) {
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
    public final void i(List list, gy6 gy6Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, gy6Var, i) == null) && gy6Var != null && !ListUtils.isEmpty(gy6Var.f())) {
            int i2 = 0;
            if (list.size() > 0) {
                int i3 = 0;
                while (i3 < list.size() && ((!(list.get(i3) instanceof w26) || ((w26) list.get(i3)).position + 1 != i) && (!(list.get(i3) instanceof os4) || ((os4) list.get(i3)).i() + 1 != i))) {
                    i3++;
                }
            }
            Iterator it = list.iterator();
            int i4 = 0;
            while (it.hasNext()) {
                eo eoVar = (eo) it.next();
                if (eoVar instanceof gy6) {
                    ((gy6) eoVar).position = i2 + 1;
                    i4++;
                } else if (eoVar instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) eoVar;
                    int i5 = baseCardInfo.position + i4;
                    baseCardInfo.position = i5;
                    i2 = i5;
                }
            }
        }
    }

    public void j(List list, vg8 vg8Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048585, this, list, vg8Var, i) != null) || ListUtils.isEmpty(list) || vg8Var == null || i < 0) {
            return;
        }
        r(list);
        if (i == 0) {
            i(list, gy6.c(vg8Var), vg8Var.a);
            return;
        }
        while (i < list.size() && !(list.get(i) instanceof w26) && !(list.get(i) instanceof os4)) {
            i++;
        }
        if (list.get(i) instanceof w26) {
            i(list, gy6.c(vg8Var), ((w26) list.get(i)).position + 2);
        } else if (list.get(i) instanceof os4) {
            i(list, gy6.c(vg8Var), ((os4) list.get(i)).i() + 2);
        }
    }

    public final void m(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) {
            f37.k(z, builder, builder2, i, this.c, this.f, this.g);
        }
    }

    public final void n(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        List<ThreadInfo> list;
        List<ThreadInfo> list2;
        Long l;
        Long l2;
        Long l3;
        Long l4;
        Long l5;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) && builder != null && builder2 != null && (list = builder.thread_list) != null && (list2 = builder2.thread_list) != null) {
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
            Iterator it = this.h.iterator();
            while (it.hasNext()) {
                ThreadInfo threadInfo2 = (ThreadInfo) it.next();
                if (threadInfo2 != null && !TextUtils.isEmpty(threadInfo2.lego_card)) {
                    hashSet4.add(threadInfo2.lego_card);
                } else if (threadInfo2 != null && (l4 = threadInfo2.tid) != null) {
                    hashSet3.add(l4);
                }
            }
            if (i == 1) {
                if (!ListUtils.isEmpty(list2)) {
                    this.d.b((ThreadInfo) ListUtils.getItem(list2, 0));
                }
                for (ThreadInfo threadInfo3 : list2) {
                    if (threadInfo3 != null && !TextUtils.isEmpty(threadInfo3.lego_card)) {
                        if (!hashSet2.contains(threadInfo3.lego_card) && !hashSet4.contains(threadInfo3.lego_card)) {
                            list.add(threadInfo3);
                        }
                    } else if (threadInfo3 != null && (l3 = threadInfo3.tid) != null && !hashSet.contains(l3) && !hashSet3.contains(threadInfo3.tid)) {
                        list.add(threadInfo3);
                        JSONObject b2 = xf8.b(threadInfo3);
                        if (b2 != null) {
                            arrayList.add(b2);
                        }
                    }
                }
            } else {
                this.d.c(z, list);
                if (l()) {
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
                    Iterator it2 = this.h.iterator();
                    while (it2.hasNext()) {
                        ThreadInfo threadInfo4 = (ThreadInfo) it2.next();
                        if (threadInfo4 != null && !TextUtils.isEmpty(threadInfo4.lego_card)) {
                            hashSet4.add(threadInfo4.lego_card);
                        } else if (threadInfo4 != null && (l2 = threadInfo4.tid) != null) {
                            hashSet3.add(l2);
                        }
                    }
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ThreadInfo threadInfo5 = (ThreadInfo) ListUtils.getItem(list2, count2);
                    if (threadInfo5 != null && !TextUtils.isEmpty(threadInfo5.lego_card)) {
                        if (!hashSet2.contains(threadInfo5.lego_card) && !hashSet4.contains(threadInfo5.lego_card)) {
                            list.add(0, threadInfo5);
                        }
                    } else if (threadInfo5 != null && (l = threadInfo5.tid) != null && ((!hashSet.contains(l) && !hashSet3.contains(threadInfo5.tid)) || threadInfo5.is_highlight.intValue() == 1)) {
                        list.add(0, threadInfo5);
                        JSONObject b3 = xf8.b(threadInfo5);
                        if (b3 != null) {
                            arrayList.add(0, b3);
                        }
                    }
                }
            }
            if (l()) {
                if (!ListUtils.isEmpty(this.i) && builder2.banner_list != null) {
                    int count3 = ListUtils.getCount(list2) + ListUtils.getCount(builder2.banner_list.app);
                    for (int i2 = 0; i2 < this.i.size(); i2++) {
                        App app = (App) this.i.get(i2);
                        if (app != null) {
                            App.Builder builder4 = new App.Builder(app);
                            qd8.c(builder4, count3);
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
            xf8.f().h("HOME", arrayList);
        }
    }

    public final void o(List list, List list2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, list, list2) == null) && list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    public final void p(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) && builder != null && builder2 != null) {
            Integer num = builder2.fresh_ctrl_num;
            if (num != null && num.intValue() > 0) {
                i2 = builder2.fresh_ctrl_num.intValue();
            } else {
                i2 = 0;
            }
            this.e = i2;
            int i3 = this.b;
            if (i2 > i3) {
                i2 = i3;
            }
            this.e = i2;
            n(z, builder, builder2, i);
            m(z, builder, builder2, i);
            o(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    public final void r(List list) {
        BaseCardInfo baseCardInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            Iterator it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                eo eoVar = (eo) it.next();
                if ((eoVar instanceof BaseCardInfo) && (i = (baseCardInfo = (BaseCardInfo) eoVar).position) > 0) {
                    baseCardInfo.position = i - i2;
                }
                if (eoVar instanceof gy6) {
                    it.remove();
                    i2++;
                }
            }
        }
    }

    public final void s(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, list) != null) || list == null) {
            return;
        }
        Collections.sort(list, new a(this));
    }
}
