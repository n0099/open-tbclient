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
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ad.AbsDataRecorder;
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
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.Personalized.UserFollowLive;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class es7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final gs7 a;
    public final int b;
    public int c;
    public ms7 d;
    public int e;
    public int f;
    public int g;
    public ArrayList<ThreadInfo> h;
    public ArrayList<App> i;
    public Long j;
    public List<in> k;

    public final int e(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i, i2)) == null) ? (i2 < 0 || i <= i2) ? i : i - 1 : invokeII.intValue;
    }

    /* loaded from: classes4.dex */
    public class a implements Comparator<th6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(es7 es7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es7Var};
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
        public int compare(th6 th6Var, th6 th6Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, th6Var, th6Var2)) == null) {
                if (th6Var != null && th6Var2 != null) {
                    if (th6Var.getPosition() > th6Var2.getPosition()) {
                        return 1;
                    }
                    if (th6Var.getPosition() < th6Var2.getPosition()) {
                        return -1;
                    }
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends cv5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fh6 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(es7 es7Var, int i, String str, fh6 fh6Var) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es7Var, Integer.valueOf(i), str, fh6Var};
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
            this.i = fh6Var;
        }

        @Override // com.baidu.tieba.cv5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), d(), null)));
                fh6 fh6Var = this.i;
                if (fh6Var instanceof nh6) {
                    statisticItem = ((nh6) fh6Var).S();
                } else if (fh6Var instanceof oh6) {
                    statisticItem = ((oh6) fh6Var).Q(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public es7() {
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
        this.d = new ms7();
        this.e = 0;
        this.j = 0L;
        this.a = new gs7();
        if (UbsABTestHelper.disableHomeMaxThreadCount()) {
            this.b = LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        } else {
            this.b = q45.m().n("home_page_max_thread_count", 300);
        }
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.k = new ArrayList();
    }

    public final as7 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            gs7 gs7Var = this.a;
            if (gs7Var != null && !ListUtils.isEmpty(gs7Var.a)) {
                for (in inVar : this.a.a) {
                    if (inVar instanceof as7) {
                        return (as7) inVar;
                    }
                }
            }
            return null;
        }
        return (as7) invokeV.objValue;
    }

    public final bs7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            gs7 gs7Var = this.a;
            if (gs7Var != null && !ListUtils.isEmpty(gs7Var.a)) {
                for (in inVar : this.a.a) {
                    if (inVar instanceof bs7) {
                        return (bs7) inVar;
                    }
                }
            }
            return null;
        }
        return (bs7) invokeV.objValue;
    }

    public gs7 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        InterceptResult invokeCommon;
        int i2;
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
            hs7.c(builder);
            hs7.c(builder2);
            s(z, builder, builder2, i);
            List<ThreadInfo> t = t(builder, i, this.b);
            hs7.n(builder);
            List<AdvertAppInfo> f = db9.l().f();
            int i3 = 0;
            if (i != 0 && z && f != null) {
                i2 = f.size();
            } else {
                i2 = 0;
            }
            List<th6> d = hs7.d(builder);
            w(d);
            List<in> i4 = i(builder.thread_list, d, builder2.user_follow_live, i, 0, builder2, i2);
            List<in> i5 = i(t, new ArrayList(), builder2.user_follow_live, i, 1, null, i2);
            this.d.a(i4);
            fs7.c(builder, i4);
            gs7 gs7Var = this.a;
            gs7Var.a = i4;
            if (i5 != null) {
                i3 = i5.size();
            }
            gs7Var.c = i3;
            return this.a;
        }
        return (gs7) invokeCommon.objValue;
    }

    public List<ThreadInfo> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h;
        }
        return (List) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ArrayList<ThreadInfo> arrayList = this.h;
            if (arrayList != null && !ListUtils.isEmpty(arrayList)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.e > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void g(th6 th6Var, List<in> list, int i, int i2, int i3) {
        vz5 vz5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{th6Var, list, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            AbsDataRecorder g = rz5.i().g(AbsDataRecorder.Scene.RECOMMEND);
            String str = null;
            if (g instanceof vz5) {
                vz5Var = (vz5) g;
            } else {
                vz5Var = null;
            }
            if (th6Var instanceof wr7) {
                str = ((wr7) th6Var).a.a;
            }
            if (vz5Var != null && !ListUtils.isEmpty(vz5Var.d()) && vz5Var.d().contains(str)) {
                rz5.i().n(list, i + 1, 1);
            } else if (i2 == i3 + 1 && rz5.i().p(AbsDataRecorder.Scene.RECOMMEND)) {
                rz5.i().n(list, i + 1, 1);
                if (!StringUtils.isNull(str) && vz5Var != null && vz5Var.d() != null) {
                    vz5Var.d().add(str);
                }
            }
        }
    }

    public void h(List<in> list, UserFollowLive userFollowLive) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, list, userFollowLive) == null) && UbsABTestHelper.isHomePageRecommendLiveSencondFloorShow() && a() == null && list != null && this.a.a != null && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
            as7 as7Var = new as7();
            as7Var.d(userFollowLive);
            list.add(0, as7Var);
            this.a.a.add(0, as7Var);
            as7Var.position = -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<in> i(List<ThreadInfo> list, List<th6> list2, UserFollowLive userFollowLive, int i, int i2, DataRes.Builder builder, int i3) {
        InterceptResult invokeCommon;
        char c;
        int i4;
        List<in> linkedList;
        as7 a2;
        bs7 bs7Var;
        boolean z;
        fh6 e;
        nh6 g;
        ThreadRecommendInfoData threadRecommendInfoData;
        nh6 g2;
        nh6 g3;
        nh6 g4;
        nh6 g5;
        int e2;
        in7 in7Var;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{list, list2, userFollowLive, Integer.valueOf(i), Integer.valueOf(i2), builder, Integer.valueOf(i3)})) == null) {
            if (list == null) {
                return null;
            }
            if (builder != null && !ListUtils.isEmpty(builder.thread_list) && builder.active_center != null) {
                ThreadInfo threadInfo = builder.thread_list.get(builder.thread_list.size() - 1);
                if (threadInfo.id.longValue() > 0 && pq4.f().l()) {
                    this.j = threadInfo.id;
                }
            }
            List<in> arrayList = new ArrayList<>(ListUtils.getCount(list));
            Iterator<ThreadInfo> it = list.iterator();
            while (true) {
                c = 0;
                if (!it.hasNext()) {
                    break;
                }
                ThreadData threadData = new ThreadData();
                AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                threadData.isFromHomPage = true;
                threadData.parserProtobuf(it.next());
                arrayList.add(threadData);
            }
            if (i2 == 0 && jn7.k(builder)) {
                jn7 jn7Var = new jn7();
                jn7Var.h(builder.header_card);
                if (ListUtils.add(arrayList, jn7Var.getPosition(), jn7Var)) {
                    i4 = jn7Var.getPosition();
                    jn7Var.position = i4;
                    if (builder != null && in7.i(builder.hot_recomforum, -1)) {
                        in7Var = new in7();
                        if (builder.hot_recomforum.floor.intValue() <= 0) {
                            i5 = builder.hot_recomforum.floor.intValue() - 1;
                        } else {
                            i5 = 0;
                        }
                        in7Var.floorPosition = i5;
                        if (in7Var.f(builder.hot_recomforum.tab_list)) {
                            j(in7Var, in7Var.floorPosition, arrayList);
                        }
                    }
                    if (i2 == 0 && UbsABTestHelper.isPersonalizeFunAdABTest() && v(builder)) {
                        int f = m75.f();
                        e2 = m75.e();
                        if (i == 0) {
                            e2 = m75.a();
                            this.k.clear();
                        }
                        if (i4 >= 0 && e2 > i4) {
                            e2++;
                        }
                        k(e2, f, arrayList);
                    }
                    linkedList = new LinkedList<>();
                    int i6 = 0;
                    for (in inVar : arrayList) {
                        boolean z2 = inVar instanceof ThreadData;
                        if (z2 && ((ThreadData) inVar).isFunAdPlaceHolder()) {
                            if (v(builder)) {
                                linkedList.add(inVar);
                                i6++;
                            }
                            c = 0;
                        } else if (z2) {
                            ThreadData threadData2 = (ThreadData) inVar;
                            if (!TextUtils.isEmpty(threadData2.getLegoCard())) {
                                by4 by4Var = new by4();
                                by4Var.e(threadData2.getLegoCard());
                                by4Var.position = i6;
                                linkedList.add(by4Var);
                            } else if (cv7.L(threadData2)) {
                                if (!StringUtils.isNull(threadData2.getTopicModule().topic_name)) {
                                    cv7 cv7Var = new cv7();
                                    cv7Var.N(threadData2.getTopicModule());
                                    cv7Var.Z = 1;
                                    cv7Var.position = i6;
                                    cv7Var.Q(threadData2);
                                    cv7Var.setSupportType(BaseCardInfo.SupportType.FULL);
                                    linkedList.add(cv7Var);
                                }
                            } else if (!nh6.W(threadData2) && !oh6.R(threadData2) && !ph6.W(threadData2)) {
                                if (ih6.W(threadData2) && threadData2.isBJHArticleThreadType()) {
                                    ih6 ih6Var = new ih6(threadData2);
                                    ih6Var.position = i6;
                                    linkedList.add(ih6Var);
                                } else {
                                    fh6 e3 = hs7.e(threadData2);
                                    if (e3 != null) {
                                        e3.g = threadData2.getTid();
                                        e3.position = i6;
                                    }
                                    if (e3 != null && e3.isValid()) {
                                        linkedList.add(e3);
                                    }
                                }
                            } else {
                                nh6 g6 = hs7.g(threadData2);
                                if (g6 != null) {
                                    if (threadData2.showCardEnterFourm()) {
                                        if (g6.isValid()) {
                                            g6.g = threadData2.getTid();
                                            g6.position = i6;
                                            hs7.t(g6);
                                            linkedList.add(g6);
                                        }
                                    } else {
                                        ThreadData threadData3 = g6.a;
                                        if (threadData3 != null && threadData3.getForumData() != null && !StringUtils.isNull(threadData3.getForumData().b)) {
                                            g6.g = threadData2.getTid();
                                            g6.position = i6;
                                            hs7.r(g6);
                                            linkedList.add(g6);
                                            z = true;
                                            e = hs7.e(threadData2);
                                            if (e != null) {
                                                e.g = threadData2.getTid();
                                                e.position = i6;
                                                if (e instanceof nh6) {
                                                    if (threadData2.isBJHNormalThreadType()) {
                                                        hs7.u(e);
                                                    } else if (threadData2.picCount() == 1) {
                                                        hs7.w(e);
                                                        int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                                                        e.j = imageWidthAndHeight[c];
                                                        e.k = imageWidthAndHeight[1];
                                                    } else if (threadData2.picCount() >= 2) {
                                                        hs7.v(e);
                                                    } else {
                                                        hs7.x(e);
                                                    }
                                                } else if (e instanceof oh6) {
                                                    hs7.y(e);
                                                }
                                            }
                                            if (e instanceof ph6) {
                                                hs7.z(e);
                                            }
                                            if (e != null && e.isValid()) {
                                                e.a.insertItemToTitleOrAbstractText();
                                                if (!threadData2.isUgcThreadType() && threadData2.getAuthor() != null && z) {
                                                    String string = TbadkCoreApplication.getInst().getString(R.string.at_username);
                                                    Object[] objArr = new Object[1];
                                                    objArr[c] = threadData2.getAuthor().getName_show();
                                                    String format = String.format(string, objArr);
                                                    SpannableString spannableString = new SpannableString(format);
                                                    spannableString.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), e), 0, format.length() - 1, 33);
                                                    e.a.insertUsernameIntoTitleOrAbstract(spannableString);
                                                }
                                                linkedList.add(e);
                                            }
                                            if (threadData2.getItem() != null && (g5 = hs7.g(threadData2)) != null) {
                                                g5.g = threadData2.getTid();
                                                g5.position = i6;
                                                hs7.A(g5);
                                                if (!nh6.W(threadData2)) {
                                                    g5.H("1");
                                                } else if (oh6.R(threadData2)) {
                                                    g5.H("2");
                                                }
                                                linkedList.add(g5);
                                            }
                                            if ((ListUtils.isEmpty(threadData2.getLinkDataList()) || !ListUtils.isEmpty(threadData2.getGoodsDataList())) && (g = hs7.g(threadData2)) != null) {
                                                g.g = threadData2.getTid();
                                                g.position = i6;
                                                if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) != 1) {
                                                    hs7.D(g);
                                                } else {
                                                    hs7.B(g);
                                                }
                                                linkedList.add(g);
                                            }
                                            threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                            if (threadRecommendInfoData != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason) && (g4 = hs7.g(threadData2)) != null) {
                                                g4.g = threadData2.getTid();
                                                g4.position = i6;
                                                hs7.C(g4);
                                                if (g4.isValid()) {
                                                    linkedList.add(g4);
                                                }
                                            }
                                            if (threadData2.showCardEnterFourm() && (g3 = hs7.g(threadData2)) != null) {
                                                g3.g = threadData2.getTid();
                                                g3.position = i6;
                                                hs7.q(g3);
                                                if (!nh6.W(threadData2)) {
                                                    g3.H("1");
                                                } else if (oh6.R(threadData2)) {
                                                    g3.H("2");
                                                }
                                                if (!threadData2.showCardEnterFourm() && !StringUtils.isNull(threadData2.getForum_name())) {
                                                    linkedList.add(g3);
                                                } else if (!StringUtils.isNull(threadData2.getForum_name())) {
                                                    linkedList.add(g3);
                                                }
                                            }
                                            if (threadData2.getTopAgreePost() != null) {
                                                nh6 g7 = hs7.g(threadData2);
                                                if (g7 != null) {
                                                    g7.g = threadData2.getTid();
                                                    g7.position = i6;
                                                    hs7.s(g7);
                                                }
                                                if (g7 != null && g7.isValid()) {
                                                    linkedList.add(g7);
                                                }
                                            }
                                            g2 = hs7.g(threadData2);
                                            if (g2 != null) {
                                                g2.g = threadData2.getTid();
                                                g2.position = i6;
                                                hs7.p(g2);
                                            }
                                            if (g2 != null && g2.isValid()) {
                                                linkedList.add(g2);
                                            }
                                        } else if (g6.isValid()) {
                                            g6.g = threadData2.getTid();
                                            g6.position = i6;
                                            hs7.t(g6);
                                            linkedList.add(g6);
                                        }
                                    }
                                }
                                z = false;
                                e = hs7.e(threadData2);
                                if (e != null) {
                                }
                                if (e instanceof ph6) {
                                }
                                if (e != null) {
                                    e.a.insertItemToTitleOrAbstractText();
                                    if (!threadData2.isUgcThreadType()) {
                                        String string2 = TbadkCoreApplication.getInst().getString(R.string.at_username);
                                        Object[] objArr2 = new Object[1];
                                        objArr2[c] = threadData2.getAuthor().getName_show();
                                        String format2 = String.format(string2, objArr2);
                                        SpannableString spannableString2 = new SpannableString(format2);
                                        spannableString2.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), e), 0, format2.length() - 1, 33);
                                        e.a.insertUsernameIntoTitleOrAbstract(spannableString2);
                                    }
                                    linkedList.add(e);
                                }
                                if (threadData2.getItem() != null) {
                                    g5.g = threadData2.getTid();
                                    g5.position = i6;
                                    hs7.A(g5);
                                    if (!nh6.W(threadData2)) {
                                    }
                                    linkedList.add(g5);
                                }
                                if (ListUtils.isEmpty(threadData2.getLinkDataList())) {
                                }
                                g.g = threadData2.getTid();
                                g.position = i6;
                                if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) != 1) {
                                }
                                linkedList.add(g);
                                threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                if (threadRecommendInfoData != null) {
                                    g4.g = threadData2.getTid();
                                    g4.position = i6;
                                    hs7.C(g4);
                                    if (g4.isValid()) {
                                    }
                                }
                                if (threadData2.showCardEnterFourm()) {
                                    g3.g = threadData2.getTid();
                                    g3.position = i6;
                                    hs7.q(g3);
                                    if (!nh6.W(threadData2)) {
                                    }
                                    if (!threadData2.showCardEnterFourm()) {
                                    }
                                    if (!StringUtils.isNull(threadData2.getForum_name())) {
                                    }
                                }
                                if (threadData2.getTopAgreePost() != null) {
                                }
                                g2 = hs7.g(threadData2);
                                if (g2 != null) {
                                }
                                if (g2 != null) {
                                    linkedList.add(g2);
                                }
                            }
                            long g8 = gg.g(threadData2.getId(), 0L);
                            if (g8 != 0 && g8 == this.j.longValue()) {
                                if (builder.active_center != null) {
                                    bs7Var = new bs7();
                                    bs7Var.L(builder.active_center);
                                } else {
                                    bs7Var = null;
                                }
                                if (bs7Var == null) {
                                    bs7Var = b();
                                }
                                if (bs7Var != null) {
                                    i6++;
                                    bs7Var.R = i6;
                                    linkedList.add(bs7Var);
                                }
                            }
                            i6++;
                            c = 0;
                        } else {
                            if (inVar instanceof BaseCardInfo) {
                                linkedList.add(inVar);
                            } else {
                                linkedList.add(inVar);
                            }
                            i6++;
                            c = 0;
                        }
                    }
                    if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
                        int i7 = 0;
                        int i8 = 0;
                        for (int i9 = 0; i9 < ListUtils.getCount(list2); i9++) {
                            th6 th6Var = (th6) ListUtils.getItem(list2, i9);
                            if (th6Var != null && i7 < linkedList.size()) {
                                int i10 = i7;
                                while (i10 < linkedList.size() && (!(linkedList.get(i10) instanceof fh6) || e(((fh6) linkedList.get(i10)).position, i4) + i8 != th6Var.getPosition() - 1)) {
                                    i10++;
                                }
                                if (linkedList.size() > i10 && i10 > 0) {
                                    linkedList.add(i10, th6Var);
                                    int i11 = i8 + 1;
                                    g(th6Var, linkedList, i10, i11, i3);
                                    i7 = i10;
                                    i8 = i11;
                                } else {
                                    i7 = i10;
                                }
                            }
                        }
                        int i12 = 0;
                        int i13 = 0;
                        for (in inVar2 : linkedList) {
                            if (inVar2 instanceof ay4) {
                                ((ay4) inVar2).setPosition(i13 + 1);
                                i12++;
                            } else if (inVar2 instanceof BaseCardInfo) {
                                BaseCardInfo baseCardInfo = (BaseCardInfo) inVar2;
                                int i14 = baseCardInfo.position + i12;
                                baseCardInfo.position = i14;
                                i13 = i14;
                            }
                        }
                    }
                    if (i2 == 0 && UbsABTestHelper.isHomePageRecommendLiveSencondFloorShow()) {
                        if (i != 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
                            as7 as7Var = new as7();
                            as7Var.d(userFollowLive);
                            linkedList.add(0, as7Var);
                            as7Var.position = -1;
                        } else if (i == 1 && (a2 = a()) != null) {
                            linkedList.add(0, a2);
                            a2.position = -1;
                        }
                    }
                    AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                    return linkedList;
                }
            }
            i4 = -1;
            if (builder != null) {
                in7Var = new in7();
                if (builder.hot_recomforum.floor.intValue() <= 0) {
                }
                in7Var.floorPosition = i5;
                if (in7Var.f(builder.hot_recomforum.tab_list)) {
                }
            }
            if (i2 == 0) {
                int f2 = m75.f();
                e2 = m75.e();
                if (i == 0) {
                }
                if (i4 >= 0) {
                    e2++;
                }
                k(e2, f2, arrayList);
            }
            linkedList = new LinkedList<>();
            int i62 = 0;
            while (r4.hasNext()) {
            }
            if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
            }
            if (i2 == 0) {
                if (i != 0) {
                }
                if (i == 1) {
                    linkedList.add(0, a2);
                    a2.position = -1;
                }
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            return linkedList;
        }
        return (List) invokeCommon.objValue;
    }

    public void j(kw4 kw4Var, int i, List<in> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048585, this, kw4Var, i, list) != null) || kw4Var == null || list == null || i <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    kw4Var.floorPosition = i;
                    ListUtils.add(list, i3, kw4Var);
                    return;
                }
                i2++;
            }
        }
    }

    public final void k(int i, int i2, List<in> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048586, this, i, i2, list) == null) && !ListUtils.isEmpty(list) && i >= 0 && i2 >= 1) {
            ListIterator<in> listIterator = list.listIterator();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (listIterator.hasNext()) {
                if (i4 == i || (i4 > i && (i4 - i) % i2 == 0)) {
                    if (i5 < this.k.size()) {
                        listIterator.add(this.k.get(i5));
                    } else {
                        ThreadData threadData = new ThreadData();
                        yl9 yl9Var = new yl9();
                        yl9Var.n(true);
                        threadData.funAdData = yl9Var;
                        listIterator.add(threadData);
                        this.k.add(threadData);
                    }
                    i5++;
                    if (i3 == 0) {
                        i3 = i4 + 1;
                    }
                }
                listIterator.next();
                i4++;
            }
            if (i3 > 0 && rz5.i().p(AbsDataRecorder.Scene.RECOMMEND)) {
                rz5.i().n(list, i3, 1);
            }
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
    public final void l(List<in> list, in7 in7Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048587, this, list, in7Var, i) == null) && in7Var != null && !ListUtils.isEmpty(in7Var.d())) {
            int i2 = 0;
            if (list.size() > 0) {
                int i3 = 0;
                while (i3 < list.size() && ((!(list.get(i3) instanceof fh6) || ((fh6) list.get(i3)).position + 1 != i) && (!(list.get(i3) instanceof ay4) || ((ay4) list.get(i3)).p() + 1 != i))) {
                    i3++;
                }
            }
            int i4 = 0;
            for (in inVar : list) {
                if (inVar instanceof in7) {
                    ((in7) inVar).position = i2 + 1;
                    i4++;
                } else if (inVar instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) inVar;
                    int i5 = baseCardInfo.position + i4;
                    baseCardInfo.position = i5;
                    i2 = i5;
                }
            }
        }
    }

    public void m(List<in> list, rd9 rd9Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048588, this, list, rd9Var, i) != null) || ListUtils.isEmpty(list) || rd9Var == null || i < 0) {
            return;
        }
        u(list);
        if (i == 0) {
            l(list, in7.c(rd9Var), rd9Var.a);
            return;
        }
        while (i < list.size() && !(list.get(i) instanceof fh6) && !(list.get(i) instanceof ay4)) {
            i++;
        }
        if (list.get(i) instanceof fh6) {
            l(list, in7.c(rd9Var), ((fh6) list.get(i)).position + 2);
        } else if (list.get(i) instanceof ay4) {
            l(list, in7.c(rd9Var), ((ay4) list.get(i)).p() + 2);
        }
    }

    public final void p(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) {
            hs7.k(z, builder, builder2, i, this.c, this.f, this.g);
        }
    }

    public final void q(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        List<ThreadInfo> list;
        List<ThreadInfo> list2;
        Long l;
        Long l2;
        Long l3;
        Long l4;
        Long l5;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) && builder != null && builder2 != null && (list = builder.thread_list) != null && (list2 = builder2.thread_list) != null) {
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
                        JSONObject b2 = qc9.b(threadInfo2);
                        if (b2 != null) {
                            arrayList.add(b2);
                        }
                    }
                }
            } else {
                this.d.c(z, list);
                if (o()) {
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
                        JSONObject b3 = qc9.b(threadInfo3);
                        if (b3 != null) {
                            arrayList.add(0, b3);
                        }
                    }
                }
            }
            if (o()) {
                if (!ListUtils.isEmpty(this.i) && builder2.banner_list != null) {
                    int count3 = ListUtils.getCount(list2) + ListUtils.getCount(builder2.banner_list.app);
                    for (int i2 = 0; i2 < this.i.size(); i2++) {
                        App app = this.i.get(i2);
                        if (app != null) {
                            App.Builder builder4 = new App.Builder(app);
                            ia9.c(builder4, count3);
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
            qc9.f().h("HOME", arrayList);
        }
    }

    public final void r(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, list, list2) == null) && list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    public final void s(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) && builder != null && builder2 != null) {
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
            q(z, builder, builder2, i);
            p(z, builder, builder2, i);
            r(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    public final List<ThreadInfo> t(DataRes.Builder builder, int i, int i2) {
        InterceptResult invokeLII;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048595, this, builder, i, i2)) == null) {
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

    public final void u(List<in> list) {
        BaseCardInfo baseCardInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            Iterator<in> it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                in next = it.next();
                if ((next instanceof BaseCardInfo) && (i = (baseCardInfo = (BaseCardInfo) next).position) > 0) {
                    baseCardInfo.position = i - i2;
                }
                if (next instanceof in7) {
                    it.remove();
                    i2++;
                }
            }
        }
    }

    public final boolean v(DataRes.Builder builder) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, builder)) == null) {
            if (builder != null && (num = builder.show_adsense) != null && num.intValue() == 2) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void w(List<th6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, list) != null) || list == null) {
            return;
        }
        Collections.sort(list, new a(this));
    }
}
