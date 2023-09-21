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
public class f28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final r78 a;
    public boolean b;

    public f28() {
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
        this.a = new r78();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final a28 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            r78 r78Var = this.a;
            if (r78Var != null && !ListUtils.isEmpty(r78Var.a)) {
                for (bn bnVar : this.a.a) {
                    if (bnVar instanceof a28) {
                        return (a28) bnVar;
                    }
                }
            }
            return null;
        }
        return (a28) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public r78 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                a28 a28Var = new a28();
                a28Var.d(userFollowLive);
                linkedList.add(0, a28Var);
                a28Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    a28 b = b();
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
                        if (z18.f(concernData)) {
                            z18 z18Var = new z18();
                            if (concernData.recom_user_list.size() >= 4) {
                                z18Var.d(concernData.recom_user_list);
                                z18Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                z18Var.g(z2);
                                linkedList.add(z18Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = u6a.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                u6a.f().h("CONCERN", arrayList);
                r78 r78Var = this.a;
                r78Var.a = linkedList;
                return r78Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            u6a.f().h("CONCERN", arrayList);
            r78 r78Var2 = this.a;
            r78Var2.a = linkedList;
            return r78Var2;
        }
        return (r78) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (z18.f(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!t08.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && z18.f(concernData2)) {
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

    public List<bn> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        aq6 iq6Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((iq6.R(threadData) || jq6.L(threadData) || kq6.R(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (kq6.R(threadData)) {
                    iq6Var = new kq6(threadData);
                } else if (jq6.L(threadData)) {
                    iq6Var = new jq6(threadData);
                } else {
                    iq6Var = new iq6();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    iq6Var.a = threadData;
                }
                iq6Var.g = threadData.getTid();
                if (iq6.R(threadData)) {
                    iq6Var.E("1");
                } else if (jq6.L(threadData)) {
                    iq6Var.E("2");
                }
                iq6Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && iq6Var.getThreadData() != null && iq6Var.getThreadData().getAuthor() != null) {
                    if (!iq6Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        t78.t(iq6Var);
                        t78.q(threadData);
                    } else {
                        t78.v(iq6Var);
                    }
                } else if (iq6Var instanceof kq6) {
                    t78.v(iq6Var);
                } else {
                    t78.v(iq6Var);
                }
                iq6Var.a.insertItemToTitleOrAbstractText();
                if (iq6Var instanceof iq6) {
                    if (threadData.isBJHNormalThreadType()) {
                        t78.w(iq6Var);
                    } else if (threadData.picCount() == 1) {
                        t78.y(iq6Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        iq6Var.j = imageWidthAndHeight[0];
                        iq6Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        t78.x(iq6Var);
                    } else {
                        t78.z(iq6Var);
                    }
                } else if (iq6Var instanceof jq6) {
                    t78.A(iq6Var);
                }
                if (iq6Var instanceof kq6) {
                    t78.B(iq6Var);
                }
                if (threadData.getItem() != null) {
                    t78.C(iq6Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        t78.F(iq6Var);
                    } else {
                        t78.D(iq6Var);
                    }
                }
                t78.s(iq6Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    t78.u(iq6Var);
                }
                t78.r(iq6Var);
                iq6Var.setSupportType(BaseCardInfo.SupportType.TOP);
                iq6Var.position = i;
                arrayList.add(iq6Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    t78.q(threadData);
                }
                if (threadData.isShareThread) {
                    iq6 iq6Var2 = new iq6();
                    iq6Var2.a = threadData;
                    iq6Var2.position = i;
                    arrayList.add(iq6Var2);
                } else if (jq6.L(threadData)) {
                    jq6 jq6Var = new jq6(threadData);
                    jq6Var.g = threadData.getTid();
                    if (concernData != null) {
                        jq6Var.D(concernData.source.intValue());
                    }
                    if (jq6Var.isValid()) {
                        arrayList.add(jq6Var);
                    }
                } else if (hq6.R(threadData)) {
                    hq6 hq6Var = new hq6(threadData);
                    hq6Var.g = threadData.getTid();
                    hq6Var.E("3");
                    if (hq6Var.isValid()) {
                        arrayList.add(hq6Var);
                    }
                } else if (dq6.R(threadData) && threadData.isBJHArticleThreadType()) {
                    dq6 dq6Var = new dq6(threadData);
                    dq6Var.position = i;
                    arrayList.add(dq6Var);
                } else {
                    iq6 iq6Var3 = new iq6();
                    iq6Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    iq6Var3.E(str);
                    iq6Var3.position = i;
                    if (concernData != null) {
                        iq6Var3.D(concernData.source.intValue());
                    }
                    if (iq6Var3.a != null && iq6Var3.isValid() && !StringUtils.isNull(iq6Var3.a.getId()) && !"0".equals(iq6Var3.a.getTid())) {
                        arrayList.add(iq6Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
