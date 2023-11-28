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
/* loaded from: classes6.dex */
public class hc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final vh8 a;
    public boolean b;

    public hc8() {
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
        this.a = new vh8();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final cc8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            vh8 vh8Var = this.a;
            if (vh8Var != null && !ListUtils.isEmpty(vh8Var.a)) {
                for (pi piVar : this.a.a) {
                    if (piVar instanceof cc8) {
                        return (cc8) piVar;
                    }
                }
            }
            return null;
        }
        return (cc8) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public vh8 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                cc8 cc8Var = new cc8();
                cc8Var.d(userFollowLive);
                linkedList.add(0, cc8Var);
                cc8Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    cc8 b = b();
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
                        if (bc8.f(concernData)) {
                            bc8 bc8Var = new bc8();
                            if (concernData.recom_user_list.size() >= 4) {
                                bc8Var.d(concernData.recom_user_list);
                                bc8Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                bc8Var.g(z2);
                                linkedList.add(bc8Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = fja.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                fja.f().h("CONCERN", arrayList);
                vh8 vh8Var = this.a;
                vh8Var.a = linkedList;
                return vh8Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            fja.f().h("CONCERN", arrayList);
            vh8 vh8Var2 = this.a;
            vh8Var2.a = linkedList;
            return vh8Var2;
        }
        return (vh8) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (bc8.f(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!va8.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && bc8.f(concernData2)) {
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

    public List<pi> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        qm6 zm6Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((zm6.R(threadData) || an6.L(threadData) || bn6.R(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (bn6.R(threadData)) {
                    zm6Var = new bn6(threadData);
                } else if (an6.L(threadData)) {
                    zm6Var = new an6(threadData);
                } else {
                    zm6Var = new zm6();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    zm6Var.a = threadData;
                }
                zm6Var.g = threadData.getTid();
                if (zm6.R(threadData)) {
                    zm6Var.E("1");
                } else if (an6.L(threadData)) {
                    zm6Var.E("2");
                }
                zm6Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && zm6Var.getThreadData() != null && zm6Var.getThreadData().getAuthor() != null) {
                    if (!zm6Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        xh8.t(zm6Var);
                        xh8.q(threadData);
                    } else {
                        xh8.v(zm6Var);
                    }
                } else if (zm6Var instanceof bn6) {
                    xh8.v(zm6Var);
                } else {
                    xh8.v(zm6Var);
                }
                zm6Var.a.insertItemToTitleOrAbstractText();
                if (zm6Var instanceof zm6) {
                    if (threadData.isBJHNormalThreadType()) {
                        xh8.w(zm6Var);
                    } else if (threadData.picCount() == 1) {
                        xh8.y(zm6Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        zm6Var.j = imageWidthAndHeight[0];
                        zm6Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        xh8.x(zm6Var);
                    } else {
                        xh8.z(zm6Var);
                    }
                } else if (zm6Var instanceof an6) {
                    xh8.A(zm6Var);
                }
                if (zm6Var instanceof bn6) {
                    xh8.B(zm6Var);
                }
                if (threadData.getItem() != null) {
                    xh8.C(zm6Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        xh8.F(zm6Var);
                    } else {
                        xh8.D(zm6Var);
                    }
                }
                xh8.s(zm6Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    xh8.u(zm6Var);
                }
                xh8.r(zm6Var);
                zm6Var.setSupportType(BaseCardInfo.SupportType.TOP);
                zm6Var.position = i;
                arrayList.add(zm6Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    xh8.q(threadData);
                }
                if (threadData.isShareThread) {
                    zm6 zm6Var2 = new zm6();
                    zm6Var2.a = threadData;
                    zm6Var2.position = i;
                    arrayList.add(zm6Var2);
                } else if (an6.L(threadData)) {
                    an6 an6Var = new an6(threadData);
                    an6Var.g = threadData.getTid();
                    if (concernData != null) {
                        an6Var.D(concernData.source.intValue());
                    }
                    if (an6Var.isValid()) {
                        arrayList.add(an6Var);
                    }
                } else if (ym6.R(threadData)) {
                    ym6 ym6Var = new ym6(threadData);
                    ym6Var.g = threadData.getTid();
                    ym6Var.E("3");
                    if (ym6Var.isValid()) {
                        arrayList.add(ym6Var);
                    }
                } else if (tm6.R(threadData) && threadData.isBJHArticleThreadType()) {
                    tm6 tm6Var = new tm6(threadData);
                    tm6Var.position = i;
                    arrayList.add(tm6Var);
                } else {
                    zm6 zm6Var3 = new zm6();
                    zm6Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    zm6Var3.E(str);
                    zm6Var3.position = i;
                    if (concernData != null) {
                        zm6Var3.D(concernData.source.intValue());
                    }
                    if (zm6Var3.a != null && zm6Var3.isValid() && !StringUtils.isNull(zm6Var3.a.getId()) && !"0".equals(zm6Var3.a.getTid())) {
                        arrayList.add(zm6Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
