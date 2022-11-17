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
public class d07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a57 a;
    public boolean b;

    public d07() {
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
        this.a = new a57();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final zz6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a57 a57Var = this.a;
            if (a57Var != null && !ListUtils.isEmpty(a57Var.a)) {
                for (xn xnVar : this.a.a) {
                    if (xnVar instanceof zz6) {
                        return (zz6) xnVar;
                    }
                }
            }
            return null;
        }
        return (zz6) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a57 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                zz6 zz6Var = new zz6();
                zz6Var.f(userFollowLive);
                linkedList.add(0, zz6Var);
                zz6Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    zz6 b = b();
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
                        if (b07.n(builder.hot_recomforum, i2)) {
                            b07 b07Var = new b07();
                            if (b07Var.j(builder.hot_recomforum.tab_list)) {
                                b07Var.position = i2;
                                linkedList.add(b07Var);
                                i2++;
                            }
                        }
                        if (yz6.j(concernData)) {
                            yz6 yz6Var = new yz6();
                            if (concernData.recom_user_list.size() >= 4) {
                                yz6Var.f(concernData.recom_user_list);
                                yz6Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                yz6Var.l(z2);
                                linkedList.add(yz6Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = th8.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                th8.f().h("CONCERN", arrayList);
                a57 a57Var = this.a;
                a57Var.a = linkedList;
                return a57Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            th8.f().h("CONCERN", arrayList);
            a57 a57Var2 = this.a;
            a57Var2.a = linkedList;
            return a57Var2;
        }
        return (a57) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (yz6.j(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!vy6.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && yz6.j(concernData2)) {
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
        t46 b56Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((b56.W(threadData) || c56.R(threadData) || d56.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (d56.W(threadData)) {
                    b56Var = new d56(threadData);
                } else if (c56.R(threadData)) {
                    b56Var = new c56(threadData);
                } else {
                    b56Var = new b56();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    b56Var.a = threadData;
                }
                b56Var.g = threadData.getTid();
                if (b56.W(threadData)) {
                    b56Var.L("1");
                } else if (c56.R(threadData)) {
                    b56Var.L("2");
                }
                b56Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && b56Var.getThreadData() != null && b56Var.getThreadData().getAuthor() != null) {
                    if (!b56Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        b57.r(b56Var);
                        b57.o(threadData);
                    } else {
                        b57.t(b56Var);
                    }
                } else if (b56Var instanceof d56) {
                    b57.t(b56Var);
                } else {
                    b57.t(b56Var);
                }
                b56Var.a.insertItemToTitleOrAbstractText();
                if (b56Var instanceof b56) {
                    if (threadData.isBJHNormalThreadType()) {
                        b57.u(b56Var);
                    } else if (threadData.picCount() == 1) {
                        b57.w(b56Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        b56Var.j = imageWidthAndHeight[0];
                        b56Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        b57.v(b56Var);
                    } else {
                        b57.x(b56Var);
                    }
                } else if (b56Var instanceof c56) {
                    b57.y(b56Var);
                }
                if (b56Var instanceof d56) {
                    b57.z(b56Var);
                }
                if (threadData.getItem() != null) {
                    b57.A(b56Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        b57.D(b56Var);
                    } else {
                        b57.B(b56Var);
                    }
                }
                b57.q(b56Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    b57.s(b56Var);
                }
                b57.p(b56Var);
                b56Var.setSupportType(BaseCardInfo.SupportType.TOP);
                b56Var.position = i;
                arrayList.add(b56Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    b57.o(threadData);
                }
                if (threadData.isShareThread) {
                    b56 b56Var2 = new b56();
                    b56Var2.a = threadData;
                    b56Var2.position = i;
                    arrayList.add(b56Var2);
                } else if (c56.R(threadData)) {
                    c56 c56Var = new c56(threadData);
                    c56Var.g = threadData.getTid();
                    if (concernData != null) {
                        c56Var.K(concernData.source.intValue());
                    }
                    if (c56Var.isValid()) {
                        arrayList.add(c56Var);
                    }
                } else if (a56.W(threadData)) {
                    a56 a56Var = new a56(threadData);
                    a56Var.g = threadData.getTid();
                    a56Var.L("3");
                    if (a56Var.isValid()) {
                        arrayList.add(a56Var);
                    }
                } else if (w46.W(threadData) && threadData.isBJHArticleThreadType()) {
                    w46 w46Var = new w46(threadData);
                    w46Var.position = i;
                    arrayList.add(w46Var);
                } else {
                    b56 b56Var3 = new b56();
                    b56Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    b56Var3.L(str);
                    b56Var3.position = i;
                    if (concernData != null) {
                        b56Var3.K(concernData.source.intValue());
                    }
                    if (b56Var3.a != null && b56Var3.isValid() && !StringUtils.isNull(b56Var3.a.getId()) && !"0".equals(b56Var3.a.getTid())) {
                        arrayList.add(b56Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
