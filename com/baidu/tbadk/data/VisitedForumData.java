package com.baidu.tbadk.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.BlockPopInfo;
import tbclient.FrsTabInfo;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class VisitedForumData extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f12951e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12952f;

    /* renamed from: g  reason: collision with root package name */
    public int f12953g;

    /* renamed from: h  reason: collision with root package name */
    public String f12954h;

    /* renamed from: i  reason: collision with root package name */
    public String f12955i;
    public boolean isForumBusinessAccount;
    public String j;
    public ThemeColorInfo k;
    public int l;
    public boolean m;
    public int n;
    public boolean o;
    public boolean p;
    public String q;
    public List<FrsTabItemData> r;
    public PostPrefixData s;

    public VisitedForumData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12951e = "";
        this.f12952f = false;
        this.f12953g = 0;
        this.f12954h = "";
        this.f12955i = "";
        this.j = "";
        this.k = null;
        this.l = 0;
        this.m = false;
        this.o = false;
        this.p = false;
        this.q = "";
    }

    public PostPrefixData A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.s : (PostPrefixData) invokeV.objValue;
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12953g : invokeV.intValue;
    }

    public List<FrsTabItemData> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.r : (List) invokeV.objValue;
    }

    public ThemeColorInfo D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (ThemeColorInfo) invokeV.objValue;
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f12952f : invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public void I(HistoryForumInfo historyForumInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, historyForumInfo) == null) || historyForumInfo == null) {
            return;
        }
        this.f12951e = historyForumInfo.avatar;
        this.f12955i = String.valueOf(historyForumInfo.forum_id);
        this.f12954h = historyForumInfo.forum_name;
        this.f12952f = historyForumInfo.is_liveforum.intValue() == 1;
        this.f12953g = historyForumInfo.unread_num.intValue();
        this.j = historyForumInfo.visit_time;
        this.k = historyForumInfo.theme_color;
        this.l = historyForumInfo.follow_num.intValue();
        this.m = historyForumInfo.need_trans.booleanValue();
        this.n = historyForumInfo.level_id.intValue();
        BlockPopInfo blockPopInfo = historyForumInfo.block_pop_info;
        if (blockPopInfo != null) {
            this.p = blockPopInfo.can_post.intValue() == 1;
            this.q = historyForumInfo.block_pop_info.block_info;
        }
        if (!ListUtils.isEmpty(historyForumInfo.tab_info)) {
            this.r = new ArrayList();
            for (FrsTabInfo frsTabInfo : historyForumInfo.tab_info) {
                if (frsTabInfo != null) {
                    this.r.add(new FrsTabItemData(frsTabInfo));
                }
            }
        }
        if (historyForumInfo.has_postpre.booleanValue()) {
            PostPrefixData postPrefixData = new PostPrefixData();
            this.s = postPrefixData;
            postPrefixData.parserProtobuf(historyForumInfo.post_prefix);
        }
        this.isForumBusinessAccount = historyForumInfo.is_forum_business_account.intValue() == 1;
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.o = z;
        }
    }

    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f12955i : (String) invokeV.objValue;
    }

    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f12954h : (String) invokeV.objValue;
    }

    public int getLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.n : invokeV.intValue;
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f12955i = str;
        }
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.q : (String) invokeV.objValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.l : invokeV.intValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f12951e : (String) invokeV.objValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, Boolean.valueOf(z), themeColorInfo, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f12951e = str3;
        this.f12952f = z;
        this.f12954h = str2;
        this.f12955i = str;
        this.j = str4;
        this.f12953g = 0;
        this.k = themeColorInfo;
        this.l = i2;
    }
}
