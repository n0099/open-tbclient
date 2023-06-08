package com.baidu.tieba.homepage.concern.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.fp9;
import com.baidu.tieba.g35;
import com.baidu.tieba.gw7;
import com.baidu.tieba.h15;
import com.baidu.tieba.vn;
import com.baidu.tieba.wo6;
import com.baidu.tieba.x08;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
/* loaded from: classes6.dex */
public class RecommendBarCardModel extends h15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List<vn> b;
    public String c;
    public String d;
    public RecDataSource e;

    @Override // com.baidu.tieba.h15
    public g35 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (g35) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h15
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class RecDataSource {
        public static final /* synthetic */ RecDataSource[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RecDataSource FORUMBACKCONCERN;
        public static final RecDataSource OTHER;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-223654933, "Lcom/baidu/tieba/homepage/concern/data/RecommendBarCardModel$RecDataSource;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-223654933, "Lcom/baidu/tieba/homepage/concern/data/RecommendBarCardModel$RecDataSource;");
                    return;
                }
            }
            FORUMBACKCONCERN = new RecDataSource("FORUMBACKCONCERN", 0);
            RecDataSource recDataSource = new RecDataSource("OTHER", 1);
            OTHER = recDataSource;
            $VALUES = new RecDataSource[]{FORUMBACKCONCERN, recDataSource};
        }

        public RecDataSource(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static RecDataSource valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (RecDataSource) Enum.valueOf(RecDataSource.class, str);
            }
            return (RecDataSource) invokeL.objValue;
        }

        public static RecDataSource[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (RecDataSource[]) $VALUES.clone();
            }
            return (RecDataSource[]) invokeV.objValue;
        }
    }

    public RecommendBarCardModel() {
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
        this.e = RecDataSource.OTHER;
    }

    @Nullable
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.vn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return wo6.z0;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public List<vn> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.e == RecDataSource.FORUMBACKCONCERN) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public static RecommendBarCardModel c(x08 x08Var) {
        InterceptResult invokeL;
        x08.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, x08Var)) == null) {
            if (x08Var != null && !ListUtils.isEmpty(x08Var.d())) {
                RecommendBarCardModel recommendBarCardModel = new RecommendBarCardModel();
                ArrayList arrayList = new ArrayList();
                recommendBarCardModel.q(arrayList);
                recommendBarCardModel.n(x08Var.c());
                List<x08.a> d = x08Var.d();
                if (!ListUtils.isEmpty(d)) {
                    gw7 gw7Var = new gw7();
                    recommendBarCardModel.a = true;
                    gw7Var.i(true);
                    gw7Var.l(true);
                    for (int i = 0; i < d.size() && i < 3 && (aVar = d.get(i)) != null && aVar.a > 0 && !TextUtils.isEmpty(aVar.c) && !TextUtils.isEmpty(aVar.b) && !TextUtils.isEmpty(aVar.d) && !TextUtils.isEmpty(aVar.f); i++) {
                        gw7Var.g[i] = new gw7.a();
                        gw7.a aVar2 = gw7Var.g[i];
                        aVar2.p(d.get(i).b);
                        aVar2.x(true);
                        aVar2.o(d.get(i).c);
                        aVar2.w(d.get(i).d);
                        aVar2.m(d.get(i).a());
                        aVar2.s(Long.valueOf(d.get(i).a));
                    }
                    arrayList.add(gw7Var);
                }
                return recommendBarCardModel;
            }
            return null;
        }
        return (RecommendBarCardModel) invokeL.objValue;
    }

    public static RecommendBarCardModel d(fp9 fp9Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, fp9Var)) == null) {
            if (fp9Var != null && !ListUtils.isEmpty(fp9Var.b)) {
                RecommendBarCardModel recommendBarCardModel = new RecommendBarCardModel();
                ArrayList arrayList = new ArrayList();
                recommendBarCardModel.q(arrayList);
                for (fp9.b bVar : fp9Var.b) {
                    if (!ListUtils.isEmpty(bVar.b)) {
                        gw7 gw7Var = new gw7();
                        if (!StringUtils.isNull(bVar.a) && !recommendBarCardModel.a) {
                            z = false;
                        } else {
                            z = true;
                        }
                        recommendBarCardModel.a = z;
                        gw7Var.a = bVar.a;
                        for (int i = 0; i < bVar.b.size() && i < 3; i++) {
                            gw7Var.g[i] = new gw7.a();
                            gw7.a aVar = gw7Var.g[i];
                            aVar.p(bVar.b.get(i).b);
                            aVar.o(bVar.b.get(i).e);
                            aVar.w(bVar.b.get(i).f);
                            aVar.n(bVar.b.get(i).c);
                            aVar.q(bVar.b.get(i).d);
                            aVar.s(Long.valueOf(bVar.b.get(i).a));
                        }
                        arrayList.add(gw7Var);
                        if (arrayList.size() >= 6) {
                            break;
                        }
                    }
                }
                return recommendBarCardModel;
            }
            return null;
        }
        return (RecommendBarCardModel) invokeL.objValue;
    }

    public boolean l(List<DiscoverTabCard> list) {
        InterceptResult invokeL;
        boolean z;
        boolean booleanValue;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            List<vn> arrayList = new ArrayList<>();
            q(arrayList);
            for (int i = 0; i < list.size(); i++) {
                DiscoverTabCard discoverTabCard = list.get(i);
                List<RecommendForumInfo> list2 = discoverTabCard.forum_list;
                if (list2 != null && list2.size() >= 3) {
                    gw7 gw7Var = new gw7();
                    if (!StringUtils.isNull(discoverTabCard.name) && !this.a) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.a = z;
                    gw7Var.a = discoverTabCard.name;
                    Boolean bool = discoverTabCard.is_show_order_number;
                    if (bool == null) {
                        booleanValue = false;
                    } else {
                        booleanValue = bool.booleanValue();
                    }
                    gw7Var.b = booleanValue;
                    gw7Var.c = discoverTabCard.jump_name;
                    for (int i2 = 0; i2 < discoverTabCard.forum_list.size() && i2 < 3; i2++) {
                        gw7Var.g[i2] = new gw7.a();
                        gw7.a aVar = gw7Var.g[i2];
                        aVar.p(discoverTabCard.forum_list.get(i2).forum_name);
                        aVar.o(discoverTabCard.forum_list.get(i2).avatar);
                        aVar.t(discoverTabCard.forum_list.get(i2).hot_text);
                        aVar.w(discoverTabCard.forum_list.get(i2).slogan);
                        aVar.n(discoverTabCard.forum_list.get(i2).member_count.intValue());
                        aVar.q(discoverTabCard.forum_list.get(i2).thread_count.intValue());
                        if (discoverTabCard.forum_list.get(i2).is_like.intValue() == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        aVar.m(z2);
                        aVar.s(discoverTabCard.forum_list.get(i2).forum_id);
                        aVar.u(discoverTabCard.forum_list.get(i2).hot_thread_id.longValue());
                    }
                    arrayList.add(gw7Var);
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

    public static boolean s(DiscoverHotForum discoverHotForum, int i) {
        InterceptResult invokeLI;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, discoverHotForum, i)) == null) {
            if (TbadkCoreApplication.isLogin() && UbsABTestHelper.needShowRecommendBarCard() && discoverHotForum != null && (num = discoverHotForum.floor) != null && ((i < 0 || i == num.intValue() - 1) && !ListUtils.isEmpty(discoverHotForum.tab_list))) {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public void m(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.d = str;
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.c = str;
        }
    }

    public void q(List<vn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.b = list;
        }
    }

    public void o(RecDataSource recDataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, recDataSource) == null) {
            this.e = recDataSource;
            if (ListUtils.isEmpty(this.b)) {
                return;
            }
            for (vn vnVar : this.b) {
                if (vnVar instanceof gw7) {
                    ((gw7) vnVar).h(recDataSource);
                }
            }
        }
    }
}
