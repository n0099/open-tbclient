package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FrsPage.MatchPlayerInfo;
import tbclient.Post;
/* loaded from: classes6.dex */
public final class fva {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public double c;
    public long d;
    public zfa e;
    public String f;
    public String g;
    public int h;
    public String i;
    public long j;
    public int k;
    public long l;
    public int m;
    public String n;
    public String o;
    public int p;
    public String q;

    public fva() {
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
        this.n = "";
        this.o = "";
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.n;
        }
        return (String) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.o;
        }
        return (String) invokeV.objValue;
    }

    public final zfa d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (zfa) invokeV.objValue;
    }

    public final long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.j;
        }
        return invokeV.longValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public final long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.l;
        }
        return invokeV.longValue;
    }

    public final double j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return invokeV.doubleValue;
    }

    public final long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.d;
        }
        return invokeV.longValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public final int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public final String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public final String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.q;
        }
        return (String) invokeV.objValue;
    }

    public final void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.q = UtilHelper.urlAddParam(str, "tab_id=1");
        }
    }

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.n = str;
        }
    }

    public final void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.o = str;
        }
    }

    public final void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.m = i;
        }
    }

    public final void w(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Double.valueOf(d)}) == null) {
            this.c = d;
        }
    }

    public final void x(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            this.d = j;
        }
    }

    public final void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.h = i;
        }
    }

    public final void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.p = i;
        }
    }

    public final void r(MatchPlayerInfo matchPlayerInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, matchPlayerInfo) != null) || matchPlayerInfo == null) {
            return;
        }
        this.a = matchPlayerInfo.name;
        this.b = matchPlayerInfo.avatar;
        Double d = matchPlayerInfo.score;
        Intrinsics.checkNotNullExpressionValue(d, "matchPlayerInfo.score");
        this.c = d.doubleValue();
        Long l = matchPlayerInfo.score_cnt;
        Intrinsics.checkNotNullExpressionValue(l, "matchPlayerInfo.score_cnt");
        this.d = l.longValue();
        Post post = matchPlayerInfo.hot_post;
        if (post != null) {
            zfa zfaVar = new zfa();
            this.e = zfaVar;
            Intrinsics.checkNotNull(zfaVar);
            zfaVar.H0(post);
        }
        this.f = matchPlayerInfo.sub_avatar;
        this.g = matchPlayerInfo.sub_text;
        Integer num = matchPlayerInfo.score_self;
        Intrinsics.checkNotNullExpressionValue(num, "matchPlayerInfo.score_self");
        this.h = num.intValue();
        this.i = matchPlayerInfo.score_link;
        Long l2 = matchPlayerInfo.match_id;
        Intrinsics.checkNotNullExpressionValue(l2, "matchPlayerInfo.match_id");
        this.j = l2.longValue();
        Integer num2 = matchPlayerInfo.match_index;
        Intrinsics.checkNotNullExpressionValue(num2, "matchPlayerInfo.match_index");
        this.k = num2.intValue();
        Long l3 = matchPlayerInfo.player_id;
        Intrinsics.checkNotNullExpressionValue(l3, "matchPlayerInfo.player_id");
        this.l = l3.longValue();
        A(matchPlayerInfo.score_link);
    }

    public final void s(tbclient.Personalized.MatchPlayerInfo matchPlayerInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, matchPlayerInfo) != null) || matchPlayerInfo == null) {
            return;
        }
        this.a = matchPlayerInfo.name;
        this.b = matchPlayerInfo.avatar;
        Double d = matchPlayerInfo.score;
        Intrinsics.checkNotNullExpressionValue(d, "matchPlayerInfo.score");
        this.c = d.doubleValue();
        Long l = matchPlayerInfo.score_cnt;
        Intrinsics.checkNotNullExpressionValue(l, "matchPlayerInfo.score_cnt");
        this.d = l.longValue();
        Post post = matchPlayerInfo.hot_post;
        if (post != null) {
            zfa zfaVar = new zfa();
            this.e = zfaVar;
            Intrinsics.checkNotNull(zfaVar);
            zfaVar.H0(post);
        }
        this.f = matchPlayerInfo.sub_avatar;
        this.g = matchPlayerInfo.sub_text;
        Integer num = matchPlayerInfo.score_self;
        Intrinsics.checkNotNullExpressionValue(num, "matchPlayerInfo.score_self");
        this.h = num.intValue();
        this.i = matchPlayerInfo.score_link;
        Long l2 = matchPlayerInfo.match_id;
        Intrinsics.checkNotNullExpressionValue(l2, "matchPlayerInfo.match_id");
        this.j = l2.longValue();
        Integer num2 = matchPlayerInfo.match_index;
        Intrinsics.checkNotNullExpressionValue(num2, "matchPlayerInfo.match_index");
        this.k = num2.intValue();
        Long l3 = matchPlayerInfo.player_id;
        Intrinsics.checkNotNullExpressionValue(l3, "matchPlayerInfo.player_id");
        this.l = l3.longValue();
        A(matchPlayerInfo.score_link);
    }
}
