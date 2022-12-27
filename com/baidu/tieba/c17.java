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
public class c17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final y57 a;
    public boolean b;

    public c17() {
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
        this.a = new y57();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final x07 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            y57 y57Var = this.a;
            if (y57Var != null && !ListUtils.isEmpty(y57Var.a)) {
                for (xn xnVar : this.a.a) {
                    if (xnVar instanceof x07) {
                        return (x07) xnVar;
                    }
                }
            }
            return null;
        }
        return (x07) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public y57 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                x07 x07Var = new x07();
                x07Var.f(userFollowLive);
                linkedList.add(0, x07Var);
                x07Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    x07 b = b();
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
                        if (z07.m(builder.hot_recomforum, i2)) {
                            z07 z07Var = new z07();
                            if (z07Var.i(builder.hot_recomforum.tab_list)) {
                                z07Var.position = i2;
                                linkedList.add(z07Var);
                                i2++;
                            }
                        }
                        if (w07.i(concernData)) {
                            w07 w07Var = new w07();
                            if (concernData.recom_user_list.size() >= 4) {
                                w07Var.f(concernData.recom_user_list);
                                w07Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                w07Var.k(z2);
                                linkedList.add(w07Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = mk8.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                mk8.f().h("CONCERN", arrayList);
                y57 y57Var = this.a;
                y57Var.a = linkedList;
                return y57Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            mk8.f().h("CONCERN", arrayList);
            y57 y57Var2 = this.a;
            y57Var2.a = linkedList;
            return y57Var2;
        }
        return (y57) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (w07.i(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!sz6.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && w07.i(concernData2)) {
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

    public List<xn> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        o56 w56Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((w56.W(threadData) || x56.R(threadData) || y56.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (y56.W(threadData)) {
                    w56Var = new y56(threadData);
                } else if (x56.R(threadData)) {
                    w56Var = new x56(threadData);
                } else {
                    w56Var = new w56();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    w56Var.a = threadData;
                }
                w56Var.g = threadData.getTid();
                if (w56.W(threadData)) {
                    w56Var.L("1");
                } else if (x56.R(threadData)) {
                    w56Var.L("2");
                }
                w56Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && w56Var.getThreadData() != null && w56Var.getThreadData().getAuthor() != null) {
                    if (!w56Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        z57.r(w56Var);
                        z57.o(threadData);
                    } else {
                        z57.t(w56Var);
                    }
                } else if (w56Var instanceof y56) {
                    z57.t(w56Var);
                } else {
                    z57.t(w56Var);
                }
                w56Var.a.insertItemToTitleOrAbstractText();
                if (w56Var instanceof w56) {
                    if (threadData.isBJHNormalThreadType()) {
                        z57.u(w56Var);
                    } else if (threadData.picCount() == 1) {
                        z57.w(w56Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        w56Var.j = imageWidthAndHeight[0];
                        w56Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        z57.v(w56Var);
                    } else {
                        z57.x(w56Var);
                    }
                } else if (w56Var instanceof x56) {
                    z57.y(w56Var);
                }
                if (w56Var instanceof y56) {
                    z57.z(w56Var);
                }
                if (threadData.getItem() != null) {
                    z57.A(w56Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        z57.D(w56Var);
                    } else {
                        z57.B(w56Var);
                    }
                }
                z57.q(w56Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    z57.s(w56Var);
                }
                z57.p(w56Var);
                w56Var.setSupportType(BaseCardInfo.SupportType.TOP);
                w56Var.position = i;
                arrayList.add(w56Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    z57.o(threadData);
                }
                if (threadData.isShareThread) {
                    w56 w56Var2 = new w56();
                    w56Var2.a = threadData;
                    w56Var2.position = i;
                    arrayList.add(w56Var2);
                } else if (x56.R(threadData)) {
                    x56 x56Var = new x56(threadData);
                    x56Var.g = threadData.getTid();
                    if (concernData != null) {
                        x56Var.K(concernData.source.intValue());
                    }
                    if (x56Var.isValid()) {
                        arrayList.add(x56Var);
                    }
                } else if (v56.W(threadData)) {
                    v56 v56Var = new v56(threadData);
                    v56Var.g = threadData.getTid();
                    v56Var.L("3");
                    if (v56Var.isValid()) {
                        arrayList.add(v56Var);
                    }
                } else if (r56.W(threadData) && threadData.isBJHArticleThreadType()) {
                    r56 r56Var = new r56(threadData);
                    r56Var.position = i;
                    arrayList.add(r56Var);
                } else {
                    w56 w56Var3 = new w56();
                    w56Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    w56Var3.L(str);
                    w56Var3.position = i;
                    if (concernData != null) {
                        w56Var3.K(concernData.source.intValue());
                    }
                    if (w56Var3.a != null && w56Var3.isValid() && !StringUtils.isNull(w56Var3.a.getId()) && !"0".equals(w56Var3.a.getTid())) {
                        arrayList.add(w56Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
