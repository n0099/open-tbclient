package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.hy6;
import com.baidu.tieba.vg8;
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
public class gy6 extends ar4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List b;

    @Override // com.baidu.tieba.ar4
    public xs4 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (xs4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ar4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    public gy6() {
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

    public List f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.eo
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return e36.x0;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public static gy6 c(vg8 vg8Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, vg8Var)) == null) {
            if (vg8Var != null && !ListUtils.isEmpty(vg8Var.b)) {
                gy6 gy6Var = new gy6();
                ArrayList arrayList = new ArrayList();
                gy6Var.l(arrayList);
                for (vg8.b bVar : vg8Var.b) {
                    if (!ListUtils.isEmpty(bVar.b)) {
                        hy6 hy6Var = new hy6();
                        if (!StringUtils.isNull(bVar.a) && !gy6Var.a) {
                            z = false;
                        } else {
                            z = true;
                        }
                        gy6Var.a = z;
                        hy6Var.a = bVar.a;
                        for (int i = 0; i < bVar.b.size() && i < 3; i++) {
                            hy6Var.d[i] = new hy6.a();
                            hy6.a aVar = hy6Var.d[i];
                            aVar.r(((vg8.a) bVar.b.get(i)).b);
                            aVar.q(((vg8.a) bVar.b.get(i)).e);
                            aVar.x(((vg8.a) bVar.b.get(i)).f);
                            aVar.o(((vg8.a) bVar.b.get(i)).c);
                            aVar.s(((vg8.a) bVar.b.get(i)).d);
                            aVar.t(Long.valueOf(((vg8.a) bVar.b.get(i)).a));
                        }
                        arrayList.add(hy6Var);
                        if (arrayList.size() >= 6) {
                            break;
                        }
                    }
                }
                return gy6Var;
            }
            return null;
        }
        return (gy6) invokeL.objValue;
    }

    public boolean j(List list) {
        InterceptResult invokeL;
        boolean z;
        boolean booleanValue;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            l(arrayList);
            for (int i = 0; i < list.size(); i++) {
                DiscoverTabCard discoverTabCard = (DiscoverTabCard) list.get(i);
                List<RecommendForumInfo> list2 = discoverTabCard.forum_list;
                if (list2 != null && list2.size() >= 3) {
                    hy6 hy6Var = new hy6();
                    if (!StringUtils.isNull(discoverTabCard.name) && !this.a) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.a = z;
                    hy6Var.a = discoverTabCard.name;
                    Boolean bool = discoverTabCard.is_show_order_number;
                    if (bool == null) {
                        booleanValue = false;
                    } else {
                        booleanValue = bool.booleanValue();
                    }
                    hy6Var.b = booleanValue;
                    hy6Var.c = discoverTabCard.jump_name;
                    for (int i2 = 0; i2 < discoverTabCard.forum_list.size() && i2 < 3; i2++) {
                        hy6Var.d[i2] = new hy6.a();
                        hy6.a aVar = hy6Var.d[i2];
                        aVar.r(discoverTabCard.forum_list.get(i2).forum_name);
                        aVar.q(discoverTabCard.forum_list.get(i2).avatar);
                        aVar.v(discoverTabCard.forum_list.get(i2).hot_text);
                        aVar.x(discoverTabCard.forum_list.get(i2).slogan);
                        aVar.o(discoverTabCard.forum_list.get(i2).member_count.intValue());
                        aVar.s(discoverTabCard.forum_list.get(i2).thread_count.intValue());
                        if (discoverTabCard.forum_list.get(i2).is_like.intValue() == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        aVar.n(z2);
                        aVar.t(discoverTabCard.forum_list.get(i2).forum_id);
                        aVar.w(discoverTabCard.forum_list.get(i2).hot_thread_id.longValue());
                    }
                    arrayList.add(hy6Var);
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

    public static boolean n(DiscoverHotForum discoverHotForum, int i) {
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

    public void l(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.b = list;
        }
    }
}
