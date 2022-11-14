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
public class c07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final z47 a;
    public boolean b;

    public c07() {
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
        this.a = new z47();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final yz6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            z47 z47Var = this.a;
            if (z47Var != null && !ListUtils.isEmpty(z47Var.a)) {
                for (xn xnVar : this.a.a) {
                    if (xnVar instanceof yz6) {
                        return (yz6) xnVar;
                    }
                }
            }
            return null;
        }
        return (yz6) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public z47 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                yz6 yz6Var = new yz6();
                yz6Var.f(userFollowLive);
                linkedList.add(0, yz6Var);
                yz6Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    yz6 b = b();
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
                        if (a07.n(builder.hot_recomforum, i2)) {
                            a07 a07Var = new a07();
                            if (a07Var.j(builder.hot_recomforum.tab_list)) {
                                a07Var.position = i2;
                                linkedList.add(a07Var);
                                i2++;
                            }
                        }
                        if (xz6.j(concernData)) {
                            xz6 xz6Var = new xz6();
                            if (concernData.recom_user_list.size() >= 4) {
                                xz6Var.f(concernData.recom_user_list);
                                xz6Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                xz6Var.l(z2);
                                linkedList.add(xz6Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = sh8.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                sh8.f().h("CONCERN", arrayList);
                z47 z47Var = this.a;
                z47Var.a = linkedList;
                return z47Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            sh8.f().h("CONCERN", arrayList);
            z47 z47Var2 = this.a;
            z47Var2.a = linkedList;
            return z47Var2;
        }
        return (z47) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (xz6.j(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!uy6.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && xz6.j(concernData2)) {
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
        s46 a56Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((a56.W(threadData) || b56.R(threadData) || c56.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (c56.W(threadData)) {
                    a56Var = new c56(threadData);
                } else if (b56.R(threadData)) {
                    a56Var = new b56(threadData);
                } else {
                    a56Var = new a56();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    a56Var.a = threadData;
                }
                a56Var.g = threadData.getTid();
                if (a56.W(threadData)) {
                    a56Var.L("1");
                } else if (b56.R(threadData)) {
                    a56Var.L("2");
                }
                a56Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && a56Var.getThreadData() != null && a56Var.getThreadData().getAuthor() != null) {
                    if (!a56Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        a57.r(a56Var);
                        a57.o(threadData);
                    } else {
                        a57.t(a56Var);
                    }
                } else if (a56Var instanceof c56) {
                    a57.t(a56Var);
                } else {
                    a57.t(a56Var);
                }
                a56Var.a.insertItemToTitleOrAbstractText();
                if (a56Var instanceof a56) {
                    if (threadData.isBJHNormalThreadType()) {
                        a57.u(a56Var);
                    } else if (threadData.picCount() == 1) {
                        a57.w(a56Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        a56Var.j = imageWidthAndHeight[0];
                        a56Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        a57.v(a56Var);
                    } else {
                        a57.x(a56Var);
                    }
                } else if (a56Var instanceof b56) {
                    a57.y(a56Var);
                }
                if (a56Var instanceof c56) {
                    a57.z(a56Var);
                }
                if (threadData.getItem() != null) {
                    a57.A(a56Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        a57.D(a56Var);
                    } else {
                        a57.B(a56Var);
                    }
                }
                a57.q(a56Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    a57.s(a56Var);
                }
                a57.p(a56Var);
                a56Var.setSupportType(BaseCardInfo.SupportType.TOP);
                a56Var.position = i;
                arrayList.add(a56Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    a57.o(threadData);
                }
                if (threadData.isShareThread) {
                    a56 a56Var2 = new a56();
                    a56Var2.a = threadData;
                    a56Var2.position = i;
                    arrayList.add(a56Var2);
                } else if (b56.R(threadData)) {
                    b56 b56Var = new b56(threadData);
                    b56Var.g = threadData.getTid();
                    if (concernData != null) {
                        b56Var.K(concernData.source.intValue());
                    }
                    if (b56Var.isValid()) {
                        arrayList.add(b56Var);
                    }
                } else if (z46.W(threadData)) {
                    z46 z46Var = new z46(threadData);
                    z46Var.g = threadData.getTid();
                    z46Var.L("3");
                    if (z46Var.isValid()) {
                        arrayList.add(z46Var);
                    }
                } else if (v46.W(threadData) && threadData.isBJHArticleThreadType()) {
                    v46 v46Var = new v46(threadData);
                    v46Var.position = i;
                    arrayList.add(v46Var);
                } else {
                    a56 a56Var3 = new a56();
                    a56Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    a56Var3.L(str);
                    a56Var3.position = i;
                    if (concernData != null) {
                        a56Var3.K(concernData.source.intValue());
                    }
                    if (a56Var3.a != null && a56Var3.isValid() && !StringUtils.isNull(a56Var3.a.getId()) && !"0".equals(a56Var3.a.getTid())) {
                        arrayList.add(a56Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
