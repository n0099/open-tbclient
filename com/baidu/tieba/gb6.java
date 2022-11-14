package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ForumGuide.LikeForum;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class gb6 extends qs4 implements uc5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public String e;
    public int f;
    public int g;
    public int h;
    public String i;
    public int j;
    public int k;
    public int l;
    public PrivateForumInfo m;
    public int n;
    public long o;
    public ThemeColorInfo p;
    public boolean q;
    public long r;
    public ArrayList<FrsTabItemData> s;

    public gb6() {
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
        f(1);
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public ThemeColorInfo B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.p;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        PrivateForumInfo privateForumInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.k == 1 && this.l == 1 && (privateForumInfo = this.m) != null && privateForumInfo.private_forum_status.intValue() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.r;
        }
        return invokeV.longValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.n;
        }
        return invokeV.intValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.q;
        }
        return invokeV.booleanValue;
    }

    public long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.o;
        }
        return invokeV.longValue;
    }

    public ArrayList<FrsTabItemData> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.s;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        PrivateForumInfo privateForumInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.k == 1 && this.l == 1 && (privateForumInfo = this.m) != null && privateForumInfo.private_forum_status.intValue() == 1 && this.m.private_forum_audit_status.intValue() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void I(LikeForum likeForum) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, likeForum) != null) || likeForum == null) {
            return;
        }
        J(likeForum, null);
    }

    public void K(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.r = j;
        }
    }

    public void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.g = i;
        }
    }

    public void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f = i;
        }
    }

    public void J(LikeForum likeForum, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, likeForum, context) != null) || likeForum == null) {
            return;
        }
        try {
            this.d = String.valueOf(likeForum.forum_id);
            this.e = likeForum.forum_name;
            this.g = likeForum.is_sign.intValue();
            this.f = likeForum.level_id.intValue();
            this.i = likeForum.avatar;
            this.o = likeForum.sort_value.longValue();
            this.h = likeForum.hot_num.intValue();
            this.p = likeForum.theme_color;
            this.q = likeForum.need_trans.booleanValue();
            this.s = new ArrayList<>();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public ArrayList<Integer> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            ThemeColorInfo themeColorInfo = this.p;
            if (themeColorInfo != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(Integer.valueOf(hj7.b(this.p.day.light_color)));
                arrayList.add(Integer.valueOf(hj7.b(this.p.day.dark_color)));
                arrayList.add(Integer.valueOf(hj7.b(this.p.night.light_color)));
                arrayList.add(Integer.valueOf(hj7.b(this.p.night.dark_color)));
                arrayList.add(Integer.valueOf(hj7.b(this.p.dark.light_color)));
                arrayList.add(Integer.valueOf(hj7.b(this.p.dark.dark_color)));
                return arrayList;
            }
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }
}
