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
public class by6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final w27 a;
    public boolean b;

    public by6() {
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
        this.a = new w27();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final xx6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            w27 w27Var = this.a;
            if (w27Var != null && !ListUtils.isEmpty(w27Var.a)) {
                for (Cdo cdo : this.a.a) {
                    if (cdo instanceof xx6) {
                        return (xx6) cdo;
                    }
                }
            }
            return null;
        }
        return (xx6) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public w27 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                    xx6 xx6Var = new xx6();
                    xx6Var.f(userFollowLive);
                    linkedList.add(0, xx6Var);
                    xx6Var.position = -1;
                    this.b = true;
                } else {
                    if (i == 1) {
                        xx6 b = b();
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
                            if (zx6.n(builder.hot_recomforum, i2)) {
                                zx6 zx6Var = new zx6();
                                if (zx6Var.j(builder.hot_recomforum.tab_list)) {
                                    zx6Var.position = i2;
                                    linkedList.add(zx6Var);
                                    i2++;
                                }
                            }
                            if (wx6.j(concernData)) {
                                wx6 wx6Var = new wx6();
                                if (concernData.recom_user_list.size() >= 4) {
                                    wx6Var.f(concernData.recom_user_list);
                                    wx6Var.position = i2;
                                    wx6Var.l(builder.thread_info.size() > 1);
                                    linkedList.add(wx6Var);
                                }
                            } else {
                                ThreadData threadData = new ThreadData();
                                threadData.setFromConcern(true);
                                AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                                threadData.parserProtobuf(concernData.thread_list);
                                JSONObject b2 = nf8.b(concernData.thread_list);
                                if (b2 != null) {
                                    arrayList.add(b2);
                                }
                                linkedList.addAll(f(threadData, i2, concernData));
                            }
                            i2++;
                        }
                    }
                    AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                    nf8.f().h("CONCERN", arrayList);
                    w27 w27Var = this.a;
                    w27Var.a = linkedList;
                    return w27Var;
                }
                i2 = 1;
                while (r11.hasNext()) {
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                nf8.f().h("CONCERN", arrayList);
                w27 w27Var2 = this.a;
                w27Var2.a = linkedList;
                return w27Var2;
            }
            return null;
        }
        return (w27) invokeCommon.objValue;
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
                if (wx6.j(concernData)) {
                    list.add(concernData);
                } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                    list.add(concernData);
                }
            }
        } else {
            if (!tw6.H()) {
                list.clear();
            }
            for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                if (concernData2 != null && wx6.j(concernData2)) {
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

    public List<Cdo> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        p26 x26Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            if ((x26.W(threadData) || y26.R(threadData) || z26.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (z26.W(threadData)) {
                    x26Var = new z26(threadData);
                } else if (y26.R(threadData)) {
                    x26Var = new y26(threadData);
                } else {
                    x26Var = new x26();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    x26Var.a = threadData;
                }
                x26Var.g = threadData.getTid();
                if (x26.W(threadData)) {
                    x26Var.L("1");
                } else if (y26.R(threadData)) {
                    x26Var.L("2");
                }
                x26Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && x26Var.getThreadData() != null && x26Var.getThreadData().getAuthor() != null) {
                    if (!x26Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        x27.r(x26Var);
                        x27.o(threadData);
                    } else {
                        x27.t(x26Var);
                    }
                } else if (x26Var instanceof z26) {
                    x27.t(x26Var);
                } else {
                    x27.t(x26Var);
                }
                x26Var.a.insertItemToTitleOrAbstractText();
                if (x26Var instanceof x26) {
                    if (threadData.isBJHNormalThreadType()) {
                        x27.u(x26Var);
                    } else if (threadData.picCount() == 1) {
                        x27.w(x26Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        x26Var.j = imageWidthAndHeight[0];
                        x26Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        x27.v(x26Var);
                    } else {
                        x27.x(x26Var);
                    }
                } else if (x26Var instanceof y26) {
                    x27.y(x26Var);
                }
                if (x26Var instanceof z26) {
                    x27.z(x26Var);
                }
                if (threadData.getItem() != null) {
                    x27.A(x26Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        x27.D(x26Var);
                    } else {
                        x27.B(x26Var);
                    }
                }
                x27.q(x26Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    x27.s(x26Var);
                }
                x27.p(x26Var);
                x26Var.setSupportType(BaseCardInfo.SupportType.TOP);
                x26Var.position = i;
                arrayList.add(x26Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    x27.o(threadData);
                }
                if (threadData.isShareThread) {
                    x26 x26Var2 = new x26();
                    x26Var2.a = threadData;
                    x26Var2.position = i;
                    arrayList.add(x26Var2);
                } else if (y26.R(threadData)) {
                    y26 y26Var = new y26(threadData);
                    y26Var.g = threadData.getTid();
                    if (concernData != null) {
                        y26Var.K(concernData.source.intValue());
                    }
                    if (y26Var.isValid()) {
                        arrayList.add(y26Var);
                    }
                } else if (w26.W(threadData)) {
                    w26 w26Var = new w26(threadData);
                    w26Var.g = threadData.getTid();
                    w26Var.L("3");
                    if (w26Var.isValid()) {
                        arrayList.add(w26Var);
                    }
                } else if (s26.W(threadData) && threadData.isBJHArticleThreadType()) {
                    s26 s26Var = new s26(threadData);
                    s26Var.position = i;
                    arrayList.add(s26Var);
                } else {
                    x26 x26Var3 = new x26();
                    x26Var3.a = threadData;
                    x26Var3.L(threadData.isLinkThread() ? "4" : "1");
                    x26Var3.position = i;
                    if (concernData != null) {
                        x26Var3.K(concernData.source.intValue());
                    }
                    if (x26Var3.a != null && x26Var3.isValid() && !StringUtils.isNull(x26Var3.a.getId()) && !"0".equals(x26Var3.a.getTid())) {
                        arrayList.add(x26Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
