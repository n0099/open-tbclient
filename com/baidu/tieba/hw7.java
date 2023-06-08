package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.homepage.concern.data.RecommendBarCardModel;
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
/* loaded from: classes6.dex */
public class hw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final d18 a;
    public boolean b;

    public hw7() {
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
        this.a = new d18();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final cw7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d18 d18Var = this.a;
            if (d18Var != null && !ListUtils.isEmpty(d18Var.a)) {
                for (vn vnVar : this.a.a) {
                    if (vnVar instanceof cw7) {
                        return (cw7) vnVar;
                    }
                }
            }
            return null;
        }
        return (cw7) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d18 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                cw7 cw7Var = new cw7();
                cw7Var.d(userFollowLive);
                linkedList.add(0, cw7Var);
                cw7Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    cw7 b = b();
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
                        if (RecommendBarCardModel.s(builder.hot_recomforum, i2)) {
                            RecommendBarCardModel recommendBarCardModel = new RecommendBarCardModel();
                            if (recommendBarCardModel.l(builder.hot_recomforum.tab_list)) {
                                recommendBarCardModel.position = i2;
                                linkedList.add(recommendBarCardModel);
                                i2++;
                            }
                        }
                        if (bw7.f(concernData)) {
                            bw7 bw7Var = new bw7();
                            if (concernData.recom_user_list.size() >= 4) {
                                bw7Var.d(concernData.recom_user_list);
                                bw7Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                bw7Var.h(z2);
                                linkedList.add(bw7Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = wn9.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                wn9.f().h("CONCERN", arrayList);
                d18 d18Var = this.a;
                d18Var.a = linkedList;
                return d18Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            wn9.f().h("CONCERN", arrayList);
            d18 d18Var2 = this.a;
            d18Var2.a = linkedList;
            return d18Var2;
        }
        return (d18) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (bw7.f(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!yu7.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && bw7.f(concernData2)) {
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

    public List<vn> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        oo6 wo6Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((wo6.X(threadData) || xo6.P(threadData) || yo6.X(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (yo6.X(threadData)) {
                    wo6Var = new yo6(threadData);
                } else if (xo6.P(threadData)) {
                    wo6Var = new xo6(threadData);
                } else {
                    wo6Var = new wo6();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    wo6Var.a = threadData;
                }
                wo6Var.g = threadData.getTid();
                if (wo6.X(threadData)) {
                    wo6Var.F("1");
                } else if (xo6.P(threadData)) {
                    wo6Var.F("2");
                }
                wo6Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && wo6Var.getThreadData() != null && wo6Var.getThreadData().getAuthor() != null) {
                    if (!wo6Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        f18.r(wo6Var);
                        f18.o(threadData);
                    } else {
                        f18.t(wo6Var);
                    }
                } else if (wo6Var instanceof yo6) {
                    f18.t(wo6Var);
                } else {
                    f18.t(wo6Var);
                }
                wo6Var.a.insertItemToTitleOrAbstractText();
                if (wo6Var instanceof wo6) {
                    if (threadData.isBJHNormalThreadType()) {
                        f18.u(wo6Var);
                    } else if (threadData.picCount() == 1) {
                        f18.w(wo6Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        wo6Var.j = imageWidthAndHeight[0];
                        wo6Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        f18.v(wo6Var);
                    } else {
                        f18.x(wo6Var);
                    }
                } else if (wo6Var instanceof xo6) {
                    f18.y(wo6Var);
                }
                if (wo6Var instanceof yo6) {
                    f18.z(wo6Var);
                }
                if (threadData.getItem() != null) {
                    f18.A(wo6Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        f18.D(wo6Var);
                    } else {
                        f18.B(wo6Var);
                    }
                }
                f18.q(wo6Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    f18.s(wo6Var);
                }
                f18.p(wo6Var);
                wo6Var.setSupportType(BaseCardInfo.SupportType.TOP);
                wo6Var.position = i;
                arrayList.add(wo6Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    f18.o(threadData);
                }
                if (threadData.isShareThread) {
                    wo6 wo6Var2 = new wo6();
                    wo6Var2.a = threadData;
                    wo6Var2.position = i;
                    arrayList.add(wo6Var2);
                } else if (xo6.P(threadData)) {
                    xo6 xo6Var = new xo6(threadData);
                    xo6Var.g = threadData.getTid();
                    if (concernData != null) {
                        xo6Var.E(concernData.source.intValue());
                    }
                    if (xo6Var.isValid()) {
                        arrayList.add(xo6Var);
                    }
                } else if (vo6.X(threadData)) {
                    vo6 vo6Var = new vo6(threadData);
                    vo6Var.g = threadData.getTid();
                    vo6Var.F("3");
                    if (vo6Var.isValid()) {
                        arrayList.add(vo6Var);
                    }
                } else if (ro6.X(threadData) && threadData.isBJHArticleThreadType()) {
                    ro6 ro6Var = new ro6(threadData);
                    ro6Var.position = i;
                    arrayList.add(ro6Var);
                } else {
                    wo6 wo6Var3 = new wo6();
                    wo6Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    wo6Var3.F(str);
                    wo6Var3.position = i;
                    if (concernData != null) {
                        wo6Var3.E(concernData.source.intValue());
                    }
                    if (wo6Var3.a != null && wo6Var3.isValid() && !StringUtils.isNull(wo6Var3.a.getId()) && !"0".equals(wo6Var3.a.getTid())) {
                        arrayList.add(wo6Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
