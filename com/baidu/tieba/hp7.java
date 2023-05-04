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
public class hp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final bu7 a;
    public boolean b;

    public hp7() {
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
        this.a = new bu7();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final bp7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            bu7 bu7Var = this.a;
            if (bu7Var != null && !ListUtils.isEmpty(bu7Var.a)) {
                for (in inVar : this.a.a) {
                    if (inVar instanceof bp7) {
                        return (bp7) inVar;
                    }
                }
            }
            return null;
        }
        return (bp7) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public bu7 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                bp7 bp7Var = new bp7();
                bp7Var.d(userFollowLive);
                linkedList.add(0, bp7Var);
                bp7Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    bp7 b = b();
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
                        if (dp7.h(builder.hot_recomforum, i2)) {
                            dp7 dp7Var = new dp7();
                            if (dp7Var.f(builder.hot_recomforum.tab_list)) {
                                dp7Var.position = i2;
                                linkedList.add(dp7Var);
                                i2++;
                            }
                        }
                        if (ap7.f(concernData)) {
                            ap7 ap7Var = new ap7();
                            if (concernData.recom_user_list.size() >= 4) {
                                ap7Var.d(concernData.recom_user_list);
                                ap7Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                ap7Var.g(z2);
                                linkedList.add(ap7Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = nf9.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                nf9.f().h("CONCERN", arrayList);
                bu7 bu7Var = this.a;
                bu7Var.a = linkedList;
                return bu7Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            nf9.f().h("CONCERN", arrayList);
            bu7 bu7Var2 = this.a;
            bu7Var2.a = linkedList;
            return bu7Var2;
        }
        return (bu7) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (ap7.f(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!wn7.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && ap7.f(concernData2)) {
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

    public List<in> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        qi6 yi6Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((yi6.W(threadData) || zi6.N(threadData) || aj6.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (aj6.W(threadData)) {
                    yi6Var = new aj6(threadData);
                } else if (zi6.N(threadData)) {
                    yi6Var = new zi6(threadData);
                } else {
                    yi6Var = new yi6();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    yi6Var.a = threadData;
                }
                yi6Var.g = threadData.getTid();
                if (yi6.W(threadData)) {
                    yi6Var.E("1");
                } else if (zi6.N(threadData)) {
                    yi6Var.E("2");
                }
                yi6Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && yi6Var.getThreadData() != null && yi6Var.getThreadData().getAuthor() != null) {
                    if (!yi6Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        cu7.r(yi6Var);
                        cu7.o(threadData);
                    } else {
                        cu7.t(yi6Var);
                    }
                } else if (yi6Var instanceof aj6) {
                    cu7.t(yi6Var);
                } else {
                    cu7.t(yi6Var);
                }
                yi6Var.a.insertItemToTitleOrAbstractText();
                if (yi6Var instanceof yi6) {
                    if (threadData.isBJHNormalThreadType()) {
                        cu7.u(yi6Var);
                    } else if (threadData.picCount() == 1) {
                        cu7.w(yi6Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        yi6Var.j = imageWidthAndHeight[0];
                        yi6Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        cu7.v(yi6Var);
                    } else {
                        cu7.x(yi6Var);
                    }
                } else if (yi6Var instanceof zi6) {
                    cu7.y(yi6Var);
                }
                if (yi6Var instanceof aj6) {
                    cu7.z(yi6Var);
                }
                if (threadData.getItem() != null) {
                    cu7.A(yi6Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        cu7.D(yi6Var);
                    } else {
                        cu7.B(yi6Var);
                    }
                }
                cu7.q(yi6Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    cu7.s(yi6Var);
                }
                cu7.p(yi6Var);
                yi6Var.setSupportType(BaseCardInfo.SupportType.TOP);
                yi6Var.position = i;
                arrayList.add(yi6Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    cu7.o(threadData);
                }
                if (threadData.isShareThread) {
                    yi6 yi6Var2 = new yi6();
                    yi6Var2.a = threadData;
                    yi6Var2.position = i;
                    arrayList.add(yi6Var2);
                } else if (zi6.N(threadData)) {
                    zi6 zi6Var = new zi6(threadData);
                    zi6Var.g = threadData.getTid();
                    if (concernData != null) {
                        zi6Var.D(concernData.source.intValue());
                    }
                    if (zi6Var.isValid()) {
                        arrayList.add(zi6Var);
                    }
                } else if (xi6.W(threadData)) {
                    xi6 xi6Var = new xi6(threadData);
                    xi6Var.g = threadData.getTid();
                    xi6Var.E("3");
                    if (xi6Var.isValid()) {
                        arrayList.add(xi6Var);
                    }
                } else if (ti6.W(threadData) && threadData.isBJHArticleThreadType()) {
                    ti6 ti6Var = new ti6(threadData);
                    ti6Var.position = i;
                    arrayList.add(ti6Var);
                } else {
                    yi6 yi6Var3 = new yi6();
                    yi6Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    yi6Var3.E(str);
                    yi6Var3.position = i;
                    if (concernData != null) {
                        yi6Var3.D(concernData.source.intValue());
                    }
                    if (yi6Var3.a != null && yi6Var3.isValid() && !StringUtils.isNull(yi6Var3.a.getId()) && !"0".equals(yi6Var3.a.getTid())) {
                        arrayList.add(yi6Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
