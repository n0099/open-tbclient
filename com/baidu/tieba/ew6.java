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
/* loaded from: classes4.dex */
public class ew6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a17 a;
    public boolean b;

    public ew6() {
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
        this.a = new a17();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final aw6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a17 a17Var = this.a;
            if (a17Var != null && !ListUtils.isEmpty(a17Var.a)) {
                for (pn pnVar : this.a.a) {
                    if (pnVar instanceof aw6) {
                        return (aw6) pnVar;
                    }
                }
            }
            return null;
        }
        return (aw6) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a17 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                    aw6 aw6Var = new aw6();
                    aw6Var.f(userFollowLive);
                    linkedList.add(0, aw6Var);
                    aw6Var.position = -1;
                    this.b = true;
                } else {
                    if (i == 1) {
                        aw6 b = b();
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
                            if (cw6.n(builder.hot_recomforum, i2)) {
                                cw6 cw6Var = new cw6();
                                if (cw6Var.j(builder.hot_recomforum.tab_list)) {
                                    cw6Var.position = i2;
                                    linkedList.add(cw6Var);
                                    i2++;
                                }
                            }
                            if (zv6.j(concernData)) {
                                zv6 zv6Var = new zv6();
                                if (concernData.recom_user_list.size() >= 4) {
                                    zv6Var.f(concernData.recom_user_list);
                                    zv6Var.position = i2;
                                    zv6Var.l(builder.thread_info.size() > 1);
                                    linkedList.add(zv6Var);
                                }
                            } else {
                                ThreadData threadData = new ThreadData();
                                threadData.setFromConcern(true);
                                AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                                threadData.parserProtobuf(concernData.thread_list);
                                JSONObject b2 = sd8.b(concernData.thread_list);
                                if (b2 != null) {
                                    arrayList.add(b2);
                                }
                                linkedList.addAll(f(threadData, i2, concernData));
                            }
                            i2++;
                        }
                    }
                    AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                    sd8.f().h("CONCERN", arrayList);
                    a17 a17Var = this.a;
                    a17Var.a = linkedList;
                    return a17Var;
                }
                i2 = 1;
                while (r11.hasNext()) {
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                sd8.f().h("CONCERN", arrayList);
                a17 a17Var2 = this.a;
                a17Var2.a = linkedList;
                return a17Var2;
            }
            return null;
        }
        return (a17) invokeCommon.objValue;
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
                if (zv6.j(concernData)) {
                    list.add(concernData);
                } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                    list.add(concernData);
                }
            }
        } else {
            if (!wu6.H()) {
                list.clear();
            }
            for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                if (concernData2 != null && zv6.j(concernData2)) {
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
        n06 v06Var;
        ThreadInfo threadInfo;
        boolean hadConcerned;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            if ((v06.W(threadData) || w06.R(threadData) || x06.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (x06.W(threadData)) {
                    v06Var = new x06(threadData);
                } else if (w06.R(threadData)) {
                    v06Var = new w06(threadData);
                } else {
                    v06Var = new v06();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    v06Var.a = threadData;
                }
                v06Var.g = threadData.getTid();
                if (v06.W(threadData)) {
                    v06Var.L("1");
                } else if (w06.R(threadData)) {
                    v06Var.L("2");
                }
                v06Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && v06Var.getThreadData() != null && v06Var.getThreadData().getAuthor() != null) {
                    if (!v06Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        b17.r(v06Var);
                        b17.o(threadData);
                    } else {
                        b17.t(v06Var);
                    }
                } else if (v06Var instanceof x06) {
                    b17.t(v06Var);
                } else {
                    b17.t(v06Var);
                }
                v06Var.a.insertItemToTitleOrAbstractText();
                if (v06Var instanceof v06) {
                    if (threadData.isBJHNormalThreadType()) {
                        b17.u(v06Var);
                    } else if (threadData.picCount() == 1) {
                        b17.w(v06Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        v06Var.j = imageWidthAndHeight[0];
                        v06Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        b17.v(v06Var);
                    } else {
                        b17.x(v06Var);
                    }
                } else if (v06Var instanceof w06) {
                    b17.y(v06Var);
                }
                if (v06Var instanceof x06) {
                    b17.z(v06Var);
                }
                if (threadData.getItem() != null) {
                    b17.A(v06Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        b17.D(v06Var);
                    } else {
                        b17.B(v06Var);
                    }
                }
                b17.q(v06Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    b17.s(v06Var);
                }
                b17.p(v06Var);
                v06Var.setSupportType(BaseCardInfo.SupportType.TOP);
                v06Var.position = i;
                arrayList.add(v06Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !(hadConcerned = threadData.getThreadData().getAuthor().hadConcerned()) && (hadConcerned || !ThreadCardUtils.isSelf(threadData))) {
                    b17.o(threadData);
                }
                if (threadData.isShareThread) {
                    v06 v06Var2 = new v06();
                    v06Var2.a = threadData;
                    v06Var2.position = i;
                    arrayList.add(v06Var2);
                } else if (w06.R(threadData)) {
                    w06 w06Var = new w06(threadData);
                    w06Var.g = threadData.getTid();
                    if (concernData != null) {
                        w06Var.K(concernData.source.intValue());
                    }
                    if (w06Var.isValid()) {
                        arrayList.add(w06Var);
                    }
                } else if (u06.W(threadData)) {
                    u06 u06Var = new u06(threadData);
                    u06Var.g = threadData.getTid();
                    u06Var.L("3");
                    if (u06Var.isValid()) {
                        arrayList.add(u06Var);
                    }
                } else if (q06.W(threadData) && threadData.isBJHArticleThreadType()) {
                    q06 q06Var = new q06(threadData);
                    q06Var.position = i;
                    arrayList.add(q06Var);
                } else {
                    v06 v06Var3 = new v06();
                    v06Var3.a = threadData;
                    v06Var3.L(threadData.isLinkThread() ? "4" : "1");
                    v06Var3.position = i;
                    if (concernData != null) {
                        v06Var3.K(concernData.source.intValue());
                    }
                    if (v06Var3.a != null && v06Var3.isValid() && !StringUtils.isNull(v06Var3.a.getId()) && !"0".equals(v06Var3.a.getTid())) {
                        arrayList.add(v06Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
