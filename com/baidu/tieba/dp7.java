package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.gp7;
import com.baidu.tieba.qg9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.DiscoverHotForum;
import tbclient.DiscoverTabCard;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class dp7 extends ax4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List<in> b;

    @Override // com.baidu.tieba.ax4
    public yy4 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (yy4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ax4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    public dp7() {
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
        this.a = false;
    }

    public List<in> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.in
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return yi6.z0;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public static dp7 c(qg9 qg9Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, qg9Var)) == null) {
            if (qg9Var != null && !ListUtils.isEmpty(qg9Var.b)) {
                dp7 dp7Var = new dp7();
                ArrayList arrayList = new ArrayList();
                dp7Var.g(arrayList);
                for (qg9.b bVar : qg9Var.b) {
                    if (!ListUtils.isEmpty(bVar.b)) {
                        gp7 gp7Var = new gp7();
                        if (!StringUtils.isNull(bVar.a) && !dp7Var.a) {
                            z = false;
                        } else {
                            z = true;
                        }
                        dp7Var.a = z;
                        gp7Var.a = bVar.a;
                        for (int i = 0; i < bVar.b.size() && i < 3; i++) {
                            gp7Var.d[i] = new gp7.a();
                            gp7.a aVar = gp7Var.d[i];
                            aVar.o(bVar.b.get(i).b);
                            aVar.n(bVar.b.get(i).e);
                            aVar.u(bVar.b.get(i).f);
                            aVar.m(bVar.b.get(i).c);
                            aVar.p(bVar.b.get(i).d);
                            aVar.q(Long.valueOf(bVar.b.get(i).a));
                        }
                        arrayList.add(gp7Var);
                        if (arrayList.size() >= 6) {
                            break;
                        }
                    }
                }
                return dp7Var;
            }
            return null;
        }
        return (dp7) invokeL.objValue;
    }

    public boolean f(List<DiscoverTabCard> list) {
        InterceptResult invokeL;
        boolean z;
        boolean booleanValue;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            List<in> arrayList = new ArrayList<>();
            g(arrayList);
            for (int i = 0; i < list.size(); i++) {
                DiscoverTabCard discoverTabCard = list.get(i);
                List<RecommendForumInfo> list2 = discoverTabCard.forum_list;
                if (list2 != null && list2.size() >= 3) {
                    gp7 gp7Var = new gp7();
                    if (!StringUtils.isNull(discoverTabCard.name) && !this.a) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.a = z;
                    gp7Var.a = discoverTabCard.name;
                    Boolean bool = discoverTabCard.is_show_order_number;
                    if (bool == null) {
                        booleanValue = false;
                    } else {
                        booleanValue = bool.booleanValue();
                    }
                    gp7Var.b = booleanValue;
                    gp7Var.c = discoverTabCard.jump_name;
                    for (int i2 = 0; i2 < discoverTabCard.forum_list.size() && i2 < 3; i2++) {
                        gp7Var.d[i2] = new gp7.a();
                        gp7.a aVar = gp7Var.d[i2];
                        aVar.o(discoverTabCard.forum_list.get(i2).forum_name);
                        aVar.n(discoverTabCard.forum_list.get(i2).avatar);
                        aVar.r(discoverTabCard.forum_list.get(i2).hot_text);
                        aVar.u(discoverTabCard.forum_list.get(i2).slogan);
                        aVar.m(discoverTabCard.forum_list.get(i2).member_count.intValue());
                        aVar.p(discoverTabCard.forum_list.get(i2).thread_count.intValue());
                        if (discoverTabCard.forum_list.get(i2).is_like.intValue() == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        aVar.k(z2);
                        aVar.q(discoverTabCard.forum_list.get(i2).forum_id);
                        aVar.t(discoverTabCard.forum_list.get(i2).hot_thread_id.longValue());
                    }
                    arrayList.add(gp7Var);
                    if (arrayList.size() >= 6) {
                        break;
                    }
                }
            }
            if (arrayList.size() <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean h(DiscoverHotForum discoverHotForum, int i) {
        InterceptResult invokeLI;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, discoverHotForum, i)) == null) {
            if (TbadkCoreApplication.isLogin() && UbsABTestHelper.needShowRecommendBarCard() && discoverHotForum != null && (num = discoverHotForum.floor) != null && ((i < 0 || i == num.intValue() - 1) && !ListUtils.isEmpty(discoverHotForum.tab_list))) {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public void g(List<in> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.b = list;
        }
    }
}
