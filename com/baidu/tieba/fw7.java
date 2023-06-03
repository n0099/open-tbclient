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
/* loaded from: classes5.dex */
public class fw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b18 a;
    public boolean b;

    public fw7() {
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
        this.a = new b18();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final aw7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b18 b18Var = this.a;
            if (b18Var != null && !ListUtils.isEmpty(b18Var.a)) {
                for (vn vnVar : this.a.a) {
                    if (vnVar instanceof aw7) {
                        return (aw7) vnVar;
                    }
                }
            }
            return null;
        }
        return (aw7) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b18 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                aw7 aw7Var = new aw7();
                aw7Var.d(userFollowLive);
                linkedList.add(0, aw7Var);
                aw7Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    aw7 b = b();
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
                        if (zv7.f(concernData)) {
                            zv7 zv7Var = new zv7();
                            if (concernData.recom_user_list.size() >= 4) {
                                zv7Var.d(concernData.recom_user_list);
                                zv7Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                zv7Var.h(z2);
                                linkedList.add(zv7Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = rn9.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                rn9.f().h("CONCERN", arrayList);
                b18 b18Var = this.a;
                b18Var.a = linkedList;
                return b18Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            rn9.f().h("CONCERN", arrayList);
            b18 b18Var2 = this.a;
            b18Var2.a = linkedList;
            return b18Var2;
        }
        return (b18) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (zv7.f(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!wu7.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && zv7.f(concernData2)) {
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
        mo6 uo6Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((uo6.X(threadData) || vo6.P(threadData) || wo6.X(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (wo6.X(threadData)) {
                    uo6Var = new wo6(threadData);
                } else if (vo6.P(threadData)) {
                    uo6Var = new vo6(threadData);
                } else {
                    uo6Var = new uo6();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    uo6Var.a = threadData;
                }
                uo6Var.g = threadData.getTid();
                if (uo6.X(threadData)) {
                    uo6Var.F("1");
                } else if (vo6.P(threadData)) {
                    uo6Var.F("2");
                }
                uo6Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && uo6Var.getThreadData() != null && uo6Var.getThreadData().getAuthor() != null) {
                    if (!uo6Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        d18.r(uo6Var);
                        d18.o(threadData);
                    } else {
                        d18.t(uo6Var);
                    }
                } else if (uo6Var instanceof wo6) {
                    d18.t(uo6Var);
                } else {
                    d18.t(uo6Var);
                }
                uo6Var.a.insertItemToTitleOrAbstractText();
                if (uo6Var instanceof uo6) {
                    if (threadData.isBJHNormalThreadType()) {
                        d18.u(uo6Var);
                    } else if (threadData.picCount() == 1) {
                        d18.w(uo6Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        uo6Var.j = imageWidthAndHeight[0];
                        uo6Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        d18.v(uo6Var);
                    } else {
                        d18.x(uo6Var);
                    }
                } else if (uo6Var instanceof vo6) {
                    d18.y(uo6Var);
                }
                if (uo6Var instanceof wo6) {
                    d18.z(uo6Var);
                }
                if (threadData.getItem() != null) {
                    d18.A(uo6Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        d18.D(uo6Var);
                    } else {
                        d18.B(uo6Var);
                    }
                }
                d18.q(uo6Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    d18.s(uo6Var);
                }
                d18.p(uo6Var);
                uo6Var.setSupportType(BaseCardInfo.SupportType.TOP);
                uo6Var.position = i;
                arrayList.add(uo6Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    d18.o(threadData);
                }
                if (threadData.isShareThread) {
                    uo6 uo6Var2 = new uo6();
                    uo6Var2.a = threadData;
                    uo6Var2.position = i;
                    arrayList.add(uo6Var2);
                } else if (vo6.P(threadData)) {
                    vo6 vo6Var = new vo6(threadData);
                    vo6Var.g = threadData.getTid();
                    if (concernData != null) {
                        vo6Var.E(concernData.source.intValue());
                    }
                    if (vo6Var.isValid()) {
                        arrayList.add(vo6Var);
                    }
                } else if (to6.X(threadData)) {
                    to6 to6Var = new to6(threadData);
                    to6Var.g = threadData.getTid();
                    to6Var.F("3");
                    if (to6Var.isValid()) {
                        arrayList.add(to6Var);
                    }
                } else if (po6.X(threadData) && threadData.isBJHArticleThreadType()) {
                    po6 po6Var = new po6(threadData);
                    po6Var.position = i;
                    arrayList.add(po6Var);
                } else {
                    uo6 uo6Var3 = new uo6();
                    uo6Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    uo6Var3.F(str);
                    uo6Var3.position = i;
                    if (concernData != null) {
                        uo6Var3.E(concernData.source.intValue());
                    }
                    if (uo6Var3.a != null && uo6Var3.isValid() && !StringUtils.isNull(uo6Var3.a.getId()) && !"0".equals(uo6Var3.a.getTid())) {
                        arrayList.add(uo6Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
