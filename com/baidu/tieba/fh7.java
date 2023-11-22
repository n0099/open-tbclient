package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.AddBawuPopInfo;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.BusinessPromot;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumInfo;
import tbclient.FrsPage.FrsBannerHeader;
import tbclient.FrsPage.FrsBottom;
import tbclient.FrsPage.FrsSpriteBubble;
import tbclient.FrsPage.LiveFuseForumData;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.FrsPage.RecreationRankInfo;
import tbclient.HotUserRankEntry;
import tbclient.PopInfo;
import tbclient.PrivatePopInfo;
import tbclient.ServiceArea;
import tbclient.SignActivityInfo;
import tbclient.User;
/* loaded from: classes5.dex */
public final class fh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public DataRes b;
    public ForumInfo c;
    public SignActivityInfo d;
    public ActivityHead e;
    public BusinessPromot f;
    public FrsBottom g;
    public PrivateForumTotalInfo h;
    public PrivatePopInfo i;
    public User j;
    public PopInfo k;
    public AddBawuPopInfo l;
    public FrsSpriteBubble m;
    public int n;

    public final void A(RecreationRankInfo recreationRankInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, recreationRankInfo) == null) {
        }
    }

    public final void B(List<ServiceArea> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
        }
    }

    public final void u(FrsBannerHeader frsBannerHeader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, frsBannerHeader) == null) {
        }
    }

    public final void w(HotUserRankEntry hotUserRankEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, hotUserRankEntry) == null) {
        }
    }

    public final void x(List<LiveFuseForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, list) == null) {
        }
    }

    public fh7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final ActivityHead a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (ActivityHead) invokeV.objValue;
    }

    public final AddBawuPopInfo b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.l;
        }
        return (AddBawuPopInfo) invokeV.objValue;
    }

    public final BusinessPromot c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (BusinessPromot) invokeV.objValue;
    }

    public final DataRes d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.b;
        }
        return (DataRes) invokeV.objValue;
    }

    public final ForumInfo e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return (ForumInfo) invokeV.objValue;
    }

    public final FrsBottom f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.g;
        }
        return (FrsBottom) invokeV.objValue;
    }

    public final PopInfo g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.k;
        }
        return (PopInfo) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final PrivateForumTotalInfo i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.h;
        }
        return (PrivateForumTotalInfo) invokeV.objValue;
    }

    public final PrivatePopInfo j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.i;
        }
        return (PrivatePopInfo) invokeV.objValue;
    }

    public final SignActivityInfo k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.d;
        }
        return (SignActivityInfo) invokeV.objValue;
    }

    public final FrsSpriteBubble l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.m;
        }
        return (FrsSpriteBubble) invokeV.objValue;
    }

    public final User m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.j;
        }
        return (User) invokeV.objValue;
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.n;
        }
        return invokeV.intValue;
    }

    public final void C(SignActivityInfo signActivityInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, signActivityInfo) == null) {
            this.d = signActivityInfo;
        }
    }

    public final void D(FrsSpriteBubble frsSpriteBubble) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, frsSpriteBubble) == null) {
            this.m = frsSpriteBubble;
        }
    }

    public final void E(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, user) == null) {
            this.j = user;
        }
    }

    public final void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.n = i;
        }
    }

    public final void o(ActivityHead activityHead) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, activityHead) == null) {
            this.e = activityHead;
        }
    }

    public final void p(AddBawuPopInfo addBawuPopInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, addBawuPopInfo) == null) {
            this.l = addBawuPopInfo;
        }
    }

    public final void q(BusinessPromot businessPromot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, businessPromot) == null) {
            this.f = businessPromot;
        }
    }

    public final void r(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, dataRes) == null) {
            this.b = dataRes;
        }
    }

    public final void s(ForumInfo forumInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, forumInfo) == null) {
            this.c = forumInfo;
        }
    }

    public final void t(FrsBottom frsBottom) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, frsBottom) == null) {
            this.g = frsBottom;
        }
    }

    public final void v(PopInfo popInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, popInfo) == null) {
            this.k = popInfo;
        }
    }

    public final void y(PrivateForumTotalInfo privateForumTotalInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, privateForumTotalInfo) == null) {
            this.h = privateForumTotalInfo;
        }
    }

    public final void z(PrivatePopInfo privatePopInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, privatePopInfo) == null) {
            this.i = privatePopInfo;
        }
    }
}
