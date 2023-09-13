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
/* loaded from: classes5.dex */
public class d28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final p78 a;
    public boolean b;

    public d28() {
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
        this.a = new p78();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final y18 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            p78 p78Var = this.a;
            if (p78Var != null && !ListUtils.isEmpty(p78Var.a)) {
                for (cn cnVar : this.a.a) {
                    if (cnVar instanceof y18) {
                        return (y18) cnVar;
                    }
                }
            }
            return null;
        }
        return (y18) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public p78 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        InterceptResult invokeCommon;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)})) == null) {
            if (i != 0 && i != 1) {
                return null;
            }
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
                y18 y18Var = new y18();
                y18Var.d(userFollowLive);
                linkedList.add(0, y18Var);
                y18Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    y18 b = b();
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
                        if (x18.f(concernData)) {
                            x18 x18Var = new x18();
                            if (concernData.recom_user_list.size() >= 4) {
                                x18Var.d(concernData.recom_user_list);
                                x18Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                x18Var.g(z2);
                                linkedList.add(x18Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = w4a.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                w4a.f().h("CONCERN", arrayList);
                p78 p78Var = this.a;
                p78Var.a = linkedList;
                return p78Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            w4a.f().h("CONCERN", arrayList);
            p78 p78Var2 = this.a;
            p78Var2.a = linkedList;
            return p78Var2;
        }
        return (p78) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (x18.f(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!r08.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && x18.f(concernData2)) {
                        list.add(0, concernData2);
                    } else if (concernData2 != null && (threadInfo = concernData2.thread_list) != null && threadInfo.tid != null) {
                        list.add(0, concernData2);
                    }
                }
            }
            this.a.b = ListUtils.getCount(list) - count;
        }
    }

    public final void e(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        List<ConcernData> list;
        List<ConcernData> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) && (list = builder.thread_info) != null && (list2 = builder2.thread_info) != null) {
            d(z, list, list2, i);
            builder.hot_recomforum = builder2.hot_recomforum;
        }
    }

    public List<cn> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        up6 cq6Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((cq6.R(threadData) || dq6.L(threadData) || eq6.R(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (eq6.R(threadData)) {
                    cq6Var = new eq6(threadData);
                } else if (dq6.L(threadData)) {
                    cq6Var = new dq6(threadData);
                } else {
                    cq6Var = new cq6();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    cq6Var.a = threadData;
                }
                cq6Var.g = threadData.getTid();
                if (cq6.R(threadData)) {
                    cq6Var.E("1");
                } else if (dq6.L(threadData)) {
                    cq6Var.E("2");
                }
                cq6Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && cq6Var.getThreadData() != null && cq6Var.getThreadData().getAuthor() != null) {
                    if (!cq6Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        r78.t(cq6Var);
                        r78.q(threadData);
                    } else {
                        r78.v(cq6Var);
                    }
                } else if (cq6Var instanceof eq6) {
                    r78.v(cq6Var);
                } else {
                    r78.v(cq6Var);
                }
                cq6Var.a.insertItemToTitleOrAbstractText();
                if (cq6Var instanceof cq6) {
                    if (threadData.isBJHNormalThreadType()) {
                        r78.w(cq6Var);
                    } else if (threadData.picCount() == 1) {
                        r78.y(cq6Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        cq6Var.j = imageWidthAndHeight[0];
                        cq6Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        r78.x(cq6Var);
                    } else {
                        r78.z(cq6Var);
                    }
                } else if (cq6Var instanceof dq6) {
                    r78.A(cq6Var);
                }
                if (cq6Var instanceof eq6) {
                    r78.B(cq6Var);
                }
                if (threadData.getItem() != null) {
                    r78.C(cq6Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        r78.F(cq6Var);
                    } else {
                        r78.D(cq6Var);
                    }
                }
                r78.s(cq6Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    r78.u(cq6Var);
                }
                r78.r(cq6Var);
                cq6Var.setSupportType(BaseCardInfo.SupportType.TOP);
                cq6Var.position = i;
                arrayList.add(cq6Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    r78.q(threadData);
                }
                if (threadData.isShareThread) {
                    cq6 cq6Var2 = new cq6();
                    cq6Var2.a = threadData;
                    cq6Var2.position = i;
                    arrayList.add(cq6Var2);
                } else if (dq6.L(threadData)) {
                    dq6 dq6Var = new dq6(threadData);
                    dq6Var.g = threadData.getTid();
                    if (concernData != null) {
                        dq6Var.D(concernData.source.intValue());
                    }
                    if (dq6Var.isValid()) {
                        arrayList.add(dq6Var);
                    }
                } else if (bq6.R(threadData)) {
                    bq6 bq6Var = new bq6(threadData);
                    bq6Var.g = threadData.getTid();
                    bq6Var.E("3");
                    if (bq6Var.isValid()) {
                        arrayList.add(bq6Var);
                    }
                } else if (xp6.R(threadData) && threadData.isBJHArticleThreadType()) {
                    xp6 xp6Var = new xp6(threadData);
                    xp6Var.position = i;
                    arrayList.add(xp6Var);
                } else {
                    cq6 cq6Var3 = new cq6();
                    cq6Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    cq6Var3.E(str);
                    cq6Var3.position = i;
                    if (concernData != null) {
                        cq6Var3.D(concernData.source.intValue());
                    }
                    if (cq6Var3.a != null && cq6Var3.isValid() && !StringUtils.isNull(cq6Var3.a.getId()) && !"0".equals(cq6Var3.a.getTid())) {
                        arrayList.add(cq6Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
