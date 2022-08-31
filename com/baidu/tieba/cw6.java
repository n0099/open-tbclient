package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
import tbclient.Userlike.UserFollowLive;
/* loaded from: classes3.dex */
public class cw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final y07 a;
    public boolean b;

    public cw6() {
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
        this.b = false;
        this.a = new y07();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final yv6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            y07 y07Var = this.a;
            if (y07Var != null && !ListUtils.isEmpty(y07Var.a)) {
                for (pn pnVar : this.a.a) {
                    if (pnVar instanceof yv6) {
                        return (yv6) pnVar;
                    }
                }
            }
            return null;
        }
        return (yv6) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public y07 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)})) == null) {
            if (i == 0 || i == 1) {
                if (builder == null) {
                    builder = new DataRes.Builder();
                }
                if (builder2 == null) {
                    builder2 = new DataRes.Builder();
                }
                a(builder);
                a(builder2);
                e(z, builder, builder2, i);
                LinkedList linkedList = new LinkedList();
                ArrayList arrayList = new ArrayList();
                UserFollowLive userFollowLive = builder2.user_follow_live;
                if (i == 0 && userFollowLive != null && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
                    yv6 yv6Var = new yv6();
                    yv6Var.f(userFollowLive);
                    linkedList.add(0, yv6Var);
                    yv6Var.position = -1;
                    this.b = true;
                } else {
                    if (i == 1) {
                        yv6 b = b();
                        if (b != null) {
                            linkedList.add(0, b);
                            b.position = -1;
                            this.b = true;
                        }
                    } else {
                        this.b = false;
                    }
                    i2 = 0;
                    for (ConcernData concernData : builder.thread_info) {
                        if (concernData != null) {
                            if (aw6.n(builder.hot_recomforum, i2)) {
                                aw6 aw6Var = new aw6();
                                if (aw6Var.j(builder.hot_recomforum.tab_list)) {
                                    aw6Var.position = i2;
                                    linkedList.add(aw6Var);
                                    i2++;
                                }
                            }
                            if (xv6.j(concernData)) {
                                xv6 xv6Var = new xv6();
                                if (concernData.recom_user_list.size() >= 4) {
                                    xv6Var.f(concernData.recom_user_list);
                                    xv6Var.position = i2;
                                    xv6Var.l(builder.thread_info.size() > 1);
                                    linkedList.add(xv6Var);
                                }
                            } else {
                                ThreadData threadData = new ThreadData();
                                threadData.setFromConcern(true);
                                AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                                threadData.parserProtobuf(concernData.thread_list);
                                JSONObject b2 = qd8.b(concernData.thread_list);
                                if (b2 != null) {
                                    arrayList.add(b2);
                                }
                                linkedList.addAll(f(threadData, i2, concernData));
                            }
                            i2++;
                        }
                    }
                    AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                    qd8.f().h("CONCERN", arrayList);
                    y07 y07Var = this.a;
                    y07Var.a = linkedList;
                    return y07Var;
                }
                i2 = 1;
                while (r11.hasNext()) {
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                qd8.f().h("CONCERN", arrayList);
                y07 y07Var2 = this.a;
                y07Var2.a = linkedList;
                return y07Var2;
            }
            return null;
        }
        return (y07) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) || list == null || list2 == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        if (i == 1) {
            for (ConcernData concernData : list2) {
                if (xv6.j(concernData)) {
                    list.add(concernData);
                } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                    list.add(concernData);
                }
            }
        } else {
            if (!uu6.H()) {
                list.clear();
            }
            for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                if (concernData2 != null && xv6.j(concernData2)) {
                    list.add(0, concernData2);
                } else if (concernData2 != null && (threadInfo = concernData2.thread_list) != null && threadInfo.tid != null) {
                    list.add(0, concernData2);
                }
            }
        }
        this.a.b = ListUtils.getCount(list) - count;
    }

    public final void e(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        List<ConcernData> list;
        List<ConcernData> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) || (list = builder.thread_info) == null || (list2 = builder2.thread_info) == null) {
            return;
        }
        d(z, list, list2, i);
        builder.hot_recomforum = builder2.hot_recomforum;
    }

    public List<pn> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        l06 t06Var;
        ThreadInfo threadInfo;
        boolean hadConcerned;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            if ((t06.W(threadData) || u06.R(threadData) || v06.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (v06.W(threadData)) {
                    t06Var = new v06(threadData);
                } else if (u06.R(threadData)) {
                    t06Var = new u06(threadData);
                } else {
                    t06Var = new t06();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    t06Var.a = threadData;
                }
                t06Var.g = threadData.getTid();
                if (t06.W(threadData)) {
                    t06Var.L("1");
                } else if (u06.R(threadData)) {
                    t06Var.L("2");
                }
                t06Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && t06Var.getThreadData() != null && t06Var.getThreadData().getAuthor() != null) {
                    if (!t06Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        z07.r(t06Var);
                        z07.o(threadData);
                    } else {
                        z07.t(t06Var);
                    }
                } else if (t06Var instanceof v06) {
                    z07.t(t06Var);
                } else {
                    z07.t(t06Var);
                }
                t06Var.a.insertItemToTitleOrAbstractText();
                if (t06Var instanceof t06) {
                    if (threadData.isBJHNormalThreadType()) {
                        z07.u(t06Var);
                    } else if (threadData.picCount() == 1) {
                        z07.w(t06Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        t06Var.j = imageWidthAndHeight[0];
                        t06Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        z07.v(t06Var);
                    } else {
                        z07.x(t06Var);
                    }
                } else if (t06Var instanceof u06) {
                    z07.y(t06Var);
                }
                if (t06Var instanceof v06) {
                    z07.z(t06Var);
                }
                if (threadData.getItem() != null) {
                    z07.A(t06Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        z07.D(t06Var);
                    } else {
                        z07.B(t06Var);
                    }
                }
                z07.q(t06Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    z07.s(t06Var);
                }
                z07.p(t06Var);
                t06Var.setSupportType(BaseCardInfo.SupportType.TOP);
                t06Var.position = i;
                arrayList.add(t06Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !(hadConcerned = threadData.getThreadData().getAuthor().hadConcerned()) && (hadConcerned || !ThreadCardUtils.isSelf(threadData))) {
                    z07.o(threadData);
                }
                if (threadData.isShareThread) {
                    t06 t06Var2 = new t06();
                    t06Var2.a = threadData;
                    t06Var2.position = i;
                    arrayList.add(t06Var2);
                } else if (u06.R(threadData)) {
                    u06 u06Var = new u06(threadData);
                    u06Var.g = threadData.getTid();
                    if (concernData != null) {
                        u06Var.K(concernData.source.intValue());
                    }
                    if (u06Var.isValid()) {
                        arrayList.add(u06Var);
                    }
                } else if (s06.W(threadData)) {
                    s06 s06Var = new s06(threadData);
                    s06Var.g = threadData.getTid();
                    s06Var.L("3");
                    if (s06Var.isValid()) {
                        arrayList.add(s06Var);
                    }
                } else if (o06.W(threadData) && threadData.isBJHArticleThreadType()) {
                    o06 o06Var = new o06(threadData);
                    o06Var.position = i;
                    arrayList.add(o06Var);
                } else {
                    t06 t06Var3 = new t06();
                    t06Var3.a = threadData;
                    t06Var3.L(threadData.isLinkThread() ? "4" : "1");
                    t06Var3.position = i;
                    if (concernData != null) {
                        t06Var3.K(concernData.source.intValue());
                    }
                    if (t06Var3.a != null && t06Var3.isValid() && !StringUtils.isNull(t06Var3.a.getId()) && !"0".equals(t06Var3.a.getTid())) {
                        arrayList.add(t06Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
