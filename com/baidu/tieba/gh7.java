package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ForumTagInfo;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.forum.data.ForumTabItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ThemeColorInfo;
/* loaded from: classes6.dex */
public final class gh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public String b;
    public String c;
    public List<ForumTabItem> d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public String j;
    public ThemeColorInfo k;
    public String l;
    public nh7 m;
    public UserData n;
    public ForumTagInfo o;
    public String p;
    public int q;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public gh7() {
        this(0L, null, null, null, 0, 0, 0, 0, 0, null, null, null, null, null, null, null, 0, 131071, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Long) objArr[0]).longValue(), (String) objArr[1], (String) objArr[2], (List) objArr[3], ((Integer) objArr[4]).intValue(), ((Integer) objArr[5]).intValue(), ((Integer) objArr[6]).intValue(), ((Integer) objArr[7]).intValue(), ((Integer) objArr[8]).intValue(), (String) objArr[9], (ThemeColorInfo) objArr[10], (String) objArr[11], (nh7) objArr[12], (UserData) objArr[13], (ForumTagInfo) objArr[14], (String) objArr[15], ((Integer) objArr[16]).intValue(), ((Integer) objArr[17]).intValue(), (DefaultConstructorMarker) objArr[18]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof gh7) {
                gh7 gh7Var = (gh7) obj;
                return this.a == gh7Var.a && Intrinsics.areEqual(this.b, gh7Var.b) && Intrinsics.areEqual(this.c, gh7Var.c) && Intrinsics.areEqual(this.d, gh7Var.d) && this.e == gh7Var.e && this.f == gh7Var.f && this.g == gh7Var.g && this.h == gh7Var.h && this.i == gh7Var.i && Intrinsics.areEqual(this.j, gh7Var.j) && Intrinsics.areEqual(this.k, gh7Var.k) && Intrinsics.areEqual(this.l, gh7Var.l) && Intrinsics.areEqual(this.m, gh7Var.m) && Intrinsics.areEqual(this.n, gh7Var.n) && Intrinsics.areEqual(this.o, gh7Var.o) && Intrinsics.areEqual(this.p, gh7Var.p) && this.q == gh7Var.q;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int a = ((((((((((((((((((c.a(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31) + this.j.hashCode()) * 31;
            ThemeColorInfo themeColorInfo = this.k;
            int hashCode = (a + (themeColorInfo == null ? 0 : themeColorInfo.hashCode())) * 31;
            String str = this.l;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            nh7 nh7Var = this.m;
            int hashCode3 = (hashCode2 + (nh7Var == null ? 0 : nh7Var.hashCode())) * 31;
            UserData userData = this.n;
            int hashCode4 = (hashCode3 + (userData == null ? 0 : userData.hashCode())) * 31;
            ForumTagInfo forumTagInfo = this.o;
            return ((((hashCode4 + (forumTagInfo != null ? forumTagInfo.hashCode() : 0)) * 31) + this.p.hashCode()) * 31) + this.q;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return "ForumData(forumId=" + this.a + ", forumName=" + this.b + ", forumIcon=" + this.c + ", tabItemList=" + this.d + ", defaultTabId=" + this.e + ", firstTabSortType=" + this.f + ", msgBubbleFrequencyLimit=" + this.g + ", unreadMsgBubbleFrequencyLimit=" + this.h + ", specialMsgBubbleFrequencyLimit=" + this.i + ", themeColor=" + this.j + ", themeColorInfo=" + this.k + ", frsCommonInfo=" + this.l + ", privateForumInfoData=" + this.m + ", userData=" + this.n + ", forumTagInfo=" + this.o + ", firstCategory=" + this.p + ", isMemberBroadcastForum=" + this.q + ')';
        }
        return (String) invokeV.objValue;
    }

    public gh7(long j, String forumName, String forumIcon, List<ForumTabItem> tabItemList, int i, int i2, int i3, int i4, int i5, String themeColor, ThemeColorInfo themeColorInfo, String str, nh7 nh7Var, UserData userData, ForumTagInfo forumTagInfo, String firstCategory, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), forumName, forumIcon, tabItemList, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), themeColor, themeColorInfo, str, nh7Var, userData, forumTagInfo, firstCategory, Integer.valueOf(i6)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(forumName, "forumName");
        Intrinsics.checkNotNullParameter(forumIcon, "forumIcon");
        Intrinsics.checkNotNullParameter(tabItemList, "tabItemList");
        Intrinsics.checkNotNullParameter(themeColor, "themeColor");
        Intrinsics.checkNotNullParameter(firstCategory, "firstCategory");
        this.a = j;
        this.b = forumName;
        this.c = forumIcon;
        this.d = tabItemList;
        this.e = i;
        this.f = i2;
        this.g = i3;
        this.h = i4;
        this.i = i5;
        this.j = themeColor;
        this.k = themeColorInfo;
        this.l = str;
        this.m = nh7Var;
        this.n = userData;
        this.o = forumTagInfo;
        this.p = firstCategory;
        this.q = i6;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ gh7(long j, String str, String str2, List list, int i, int i2, int i3, int i4, int i5, String str3, ThemeColorInfo themeColorInfo, String str4, nh7 nh7Var, UserData userData, ForumTagInfo forumTagInfo, String str5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r5, r6, r7, r8, r10, r11, r12, r13, r14, r9, r15, r16, r4, r17, r0);
        long j2;
        String str6;
        String str7;
        List list2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        String str8;
        ThemeColorInfo themeColorInfo2;
        String str9;
        nh7 nh7Var2;
        UserData userData2;
        ForumTagInfo forumTagInfo2;
        String str10;
        int i13;
        if ((i7 & 1) != 0) {
            j2 = 0;
        } else {
            j2 = j;
        }
        if ((i7 & 2) != 0) {
            str6 = "";
        } else {
            str6 = str;
        }
        if ((i7 & 4) != 0) {
            str7 = "";
        } else {
            str7 = str2;
        }
        if ((i7 & 8) != 0) {
            list2 = new ArrayList();
        } else {
            list2 = list;
        }
        if ((i7 & 16) != 0) {
            i8 = -1;
        } else {
            i8 = i;
        }
        if ((i7 & 32) != 0) {
            i9 = 0;
        } else {
            i9 = i2;
        }
        if ((i7 & 64) != 0) {
            i10 = 0;
        } else {
            i10 = i3;
        }
        if ((i7 & 128) != 0) {
            i11 = 0;
        } else {
            i11 = i4;
        }
        if ((i7 & 256) != 0) {
            i12 = 0;
        } else {
            i12 = i5;
        }
        if ((i7 & 512) != 0) {
            str8 = "";
        } else {
            str8 = str3;
        }
        if ((i7 & 1024) != 0) {
            themeColorInfo2 = null;
        } else {
            themeColorInfo2 = themeColorInfo;
        }
        if ((i7 & 2048) != 0) {
            str9 = null;
        } else {
            str9 = str4;
        }
        if ((i7 & 4096) != 0) {
            nh7Var2 = null;
        } else {
            nh7Var2 = nh7Var;
        }
        if ((i7 & 8192) != 0) {
            userData2 = null;
        } else {
            userData2 = userData;
        }
        UserData userData3 = userData2;
        if ((i7 & 16384) != 0) {
            forumTagInfo2 = null;
        } else {
            forumTagInfo2 = forumTagInfo;
        }
        if ((i7 & 32768) != 0) {
            str10 = "";
        } else {
            str10 = str5;
        }
        if ((i7 & 65536) != 0) {
            i13 = 0;
        } else {
            i13 = i6;
        }
    }

    public final void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.i = i;
        }
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.j = str;
        }
    }

    public final void C(ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, themeColorInfo) == null) {
            this.k = themeColorInfo;
        }
    }

    public final void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.h = i;
        }
    }

    public final void E(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, userData) == null) {
            this.n = userData;
        }
    }

    public final void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.e = i;
        }
    }

    public final void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.p = str;
        }
    }

    public final void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.c = str;
        }
    }

    public final void t(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048602, this, j) == null) {
            this.a = j;
        }
    }

    public final void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.b = str;
        }
    }

    public final void v(ForumTagInfo forumTagInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, forumTagInfo) == null) {
            this.o = forumTagInfo;
        }
    }

    public final void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.l = str;
        }
    }

    public final void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.q = i;
        }
    }

    public final void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.g = i;
        }
    }

    public final void z(nh7 nh7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, nh7Var) == null) {
            this.m = nh7Var;
        }
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.p;
        }
        return (String) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a;
        }
        return invokeV.longValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final ForumTagInfo f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.o;
        }
        return (ForumTagInfo) invokeV.objValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public final nh7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.m;
        }
        return (nh7) invokeV.objValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public final List<ForumTabItem> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.d;
        }
        return (List) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public final ThemeColorInfo m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.k;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public final UserData o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.n;
        }
        return (UserData) invokeV.objValue;
    }

    public final int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.q;
        }
        return invokeV.intValue;
    }
}
