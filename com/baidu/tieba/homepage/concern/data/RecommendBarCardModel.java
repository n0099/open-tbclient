package com.baidu.tieba.homepage.concern.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.bna;
import com.baidu.tieba.dn6;
import com.baidu.tieba.fw4;
import com.baidu.tieba.jc8;
import com.baidu.tieba.oh8;
import com.baidu.tieba.pi;
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
public class RecommendBarCardModel extends fw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List<pi> b;
    public String c;
    public String d;
    public RecDataSource e;

    @Override // com.baidu.tieba.fw4
    public NegativeFeedBackData getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (NegativeFeedBackData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fw4
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
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.pi
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return dn6.z0;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public List<pi> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public boolean k() {
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

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (SharedPrefHelper.getInstance().getInt("key_home_show_card_not_click", 0) < 3) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = SharedPrefHelper.getInstance().getLong("key_home_show_card_hide_time", 0L);
            if (j == 0) {
                SharedPrefHelper.getInstance().putLong("key_home_show_card_hide_time", currentTimeMillis);
                return false;
            } else if (currentTimeMillis - j < 259200000) {
                return false;
            } else {
                SharedPrefHelper.getInstance().putLong("key_home_show_card_hide_time", currentTimeMillis);
                SharedPrefHelper.getInstance().putInt("key_home_show_card_not_click", 0);
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public static RecommendBarCardModel d(oh8 oh8Var) {
        InterceptResult invokeL;
        oh8.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, oh8Var)) == null) {
            if (oh8Var != null && !ListUtils.isEmpty(oh8Var.d())) {
                RecommendBarCardModel recommendBarCardModel = new RecommendBarCardModel();
                ArrayList arrayList = new ArrayList();
                recommendBarCardModel.s(arrayList);
                recommendBarCardModel.p(oh8Var.c());
                List<oh8.a> d = oh8Var.d();
                if (!ListUtils.isEmpty(d)) {
                    jc8 jc8Var = new jc8();
                    recommendBarCardModel.a = true;
                    jc8Var.h(true);
                    jc8Var.l(true);
                    for (int i = 0; i < d.size() && i < 3 && (aVar = d.get(i)) != null && aVar.a > 0 && !TextUtils.isEmpty(aVar.c) && !TextUtils.isEmpty(aVar.b) && !TextUtils.isEmpty(aVar.d) && !TextUtils.isEmpty(aVar.f); i++) {
                        jc8Var.g[i] = new jc8.a();
                        jc8.a aVar2 = jc8Var.g[i];
                        aVar2.o(d.get(i).b);
                        aVar2.v(true);
                        aVar2.n(d.get(i).c);
                        aVar2.u(d.get(i).d);
                        aVar2.k(d.get(i).a());
                        aVar2.q(Long.valueOf(d.get(i).a));
                    }
                    arrayList.add(jc8Var);
                }
                return recommendBarCardModel;
            }
            return null;
        }
        return (RecommendBarCardModel) invokeL.objValue;
    }

    public static RecommendBarCardModel e(bna bnaVar) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bnaVar)) == null) {
            if (bnaVar != null && !ListUtils.isEmpty(bnaVar.b)) {
                RecommendBarCardModel recommendBarCardModel = new RecommendBarCardModel();
                ArrayList arrayList = new ArrayList();
                recommendBarCardModel.s(arrayList);
                for (bna.b bVar : bnaVar.b) {
                    if (!ListUtils.isEmpty(bVar.b)) {
                        jc8 jc8Var = new jc8();
                        if (!StringUtils.isNull(bVar.a) && !recommendBarCardModel.a) {
                            z = false;
                        } else {
                            z = true;
                        }
                        recommendBarCardModel.a = z;
                        jc8Var.a = bVar.a;
                        for (int i = 0; i < bVar.b.size() && i < 3; i++) {
                            jc8Var.g[i] = new jc8.a();
                            jc8.a aVar = jc8Var.g[i];
                            aVar.o(bVar.b.get(i).b);
                            aVar.n(bVar.b.get(i).e);
                            aVar.u(bVar.b.get(i).f);
                            aVar.l(bVar.b.get(i).c);
                            aVar.p(bVar.b.get(i).d);
                            aVar.q(Long.valueOf(bVar.b.get(i).a));
                        }
                        arrayList.add(jc8Var);
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

    public boolean n(List<DiscoverTabCard> list) {
        InterceptResult invokeL;
        boolean z;
        boolean booleanValue;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            List<pi> arrayList = new ArrayList<>();
            s(arrayList);
            for (int i = 0; i < list.size(); i++) {
                DiscoverTabCard discoverTabCard = list.get(i);
                List<RecommendForumInfo> list2 = discoverTabCard.forum_list;
                if (list2 != null && list2.size() >= 3) {
                    jc8 jc8Var = new jc8();
                    if (!StringUtils.isNull(discoverTabCard.name) && !this.a) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.a = z;
                    jc8Var.a = discoverTabCard.name;
                    Boolean bool = discoverTabCard.is_show_order_number;
                    if (bool == null) {
                        booleanValue = false;
                    } else {
                        booleanValue = bool.booleanValue();
                    }
                    jc8Var.b = booleanValue;
                    jc8Var.c = discoverTabCard.jump_name;
                    for (int i2 = 0; i2 < discoverTabCard.forum_list.size() && i2 < 3; i2++) {
                        jc8Var.g[i2] = new jc8.a();
                        jc8.a aVar = jc8Var.g[i2];
                        aVar.o(discoverTabCard.forum_list.get(i2).forum_name);
                        aVar.n(discoverTabCard.forum_list.get(i2).avatar);
                        aVar.s(discoverTabCard.forum_list.get(i2).hot_text);
                        aVar.u(discoverTabCard.forum_list.get(i2).slogan);
                        aVar.l(discoverTabCard.forum_list.get(i2).member_count.intValue());
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
                    arrayList.add(jc8Var);
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

    public static boolean t(DiscoverHotForum discoverHotForum, int i) {
        InterceptResult invokeLI;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, discoverHotForum, i)) == null) {
            if (TbadkCoreApplication.isLogin() && discoverHotForum != null && (num = discoverHotForum.floor) != null && ((i < 0 || i == num.intValue() - 1) && !ListUtils.isEmpty(discoverHotForum.tab_list) && c())) {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public void o(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.d = str;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.c = str;
        }
    }

    public void s(List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.b = list;
        }
    }

    public void q(RecDataSource recDataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, recDataSource) == null) {
            this.e = recDataSource;
            if (ListUtils.isEmpty(this.b)) {
                return;
            }
            for (pi piVar : this.b) {
                if (piVar instanceof jc8) {
                    ((jc8) piVar).g(recDataSource);
                }
            }
        }
    }
}
