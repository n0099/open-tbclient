package com.baidu.tbadk.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ForumTagInfo;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.lego.card.utils.ColorUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.BlockPopInfo;
import tbclient.FrsTabInfo;
import tbclient.HistoryForumInfo;
import tbclient.RecomTagInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes5.dex */
public class VisitedForumData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String firstCategory;
    public ForumTagInfo forumTagInfo;
    public boolean isAlaForum;
    public boolean isForumBusinessAccount;
    public String mBlockInfo;
    public int mDayThreadNum;
    public int mFollowNumber;
    public String mForumId;
    public String mForumImageUrl;
    public String mForumName;
    public boolean mIsCanPost;
    public boolean mIsLike;
    public boolean mIsPost;
    public int mLevel;
    public boolean mNeedTrans;
    public int mPostNum;
    public PostPrefixData mPostPrefix;
    public int mRedCount;
    public List<FrsTabItemData> mTabInfoList;
    public ThemeColorInfo mThemeColorInfo;
    public String mVisitedTime;

    public VisitedForumData() {
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
        this.mForumImageUrl = "";
        this.isAlaForum = false;
        this.mRedCount = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.mVisitedTime = "";
        this.mThemeColorInfo = null;
        this.mFollowNumber = 0;
        this.mNeedTrans = false;
        this.mIsPost = false;
        this.mIsCanPost = false;
        this.mBlockInfo = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i, ForumTagInfo forumTagInfo, String str5, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, Boolean.valueOf(z), themeColorInfo, Integer.valueOf(i), forumTagInfo, str5, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mForumImageUrl = str3;
        this.isAlaForum = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.mVisitedTime = str4;
        this.mRedCount = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.mFollowNumber = i;
        this.mPostNum = i2;
        this.forumTagInfo = forumTagInfo;
        this.firstCategory = str5;
    }

    public String getBlockInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mBlockInfo;
        }
        return (String) invokeV.objValue;
    }

    public int getDayThreadNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mDayThreadNum;
        }
        return invokeV.intValue;
    }

    public int getFollowNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mFollowNumber;
        }
        return invokeV.intValue;
    }

    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mForumId;
        }
        return (String) invokeV.objValue;
    }

    public String getForumImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mForumImageUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mForumName;
        }
        return (String) invokeV.objValue;
    }

    public int getLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mLevel;
        }
        return invokeV.intValue;
    }

    public boolean getNeedTrans() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mNeedTrans;
        }
        return invokeV.booleanValue;
    }

    public int getPostNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mPostNum;
        }
        return invokeV.intValue;
    }

    public PostPrefixData getPostPrefix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mPostPrefix;
        }
        return (PostPrefixData) invokeV.objValue;
    }

    public int getRedCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mRedCount;
        }
        return invokeV.intValue;
    }

    public List<FrsTabItemData> getTabInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mTabInfoList;
        }
        return (List) invokeV.objValue;
    }

    public ThemeColorInfo getThemeColorInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mThemeColorInfo;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public String getVisitedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mVisitedTime;
        }
        return (String) invokeV.objValue;
    }

    public boolean isAlaForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.isAlaForum;
        }
        return invokeV.booleanValue;
    }

    public boolean isCanPost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mIsCanPost;
        }
        return invokeV.booleanValue;
    }

    public boolean isIsLike() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mIsLike;
        }
        return invokeV.booleanValue;
    }

    public boolean isPost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mIsPost;
        }
        return invokeV.booleanValue;
    }

    public ArrayList<Integer> getThemeColorArrayList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ThemeColorInfo themeColorInfo = this.mThemeColorInfo;
            if (themeColorInfo != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(Integer.valueOf(ColorUtils.parseColor(this.mThemeColorInfo.day.light_color)));
                arrayList.add(Integer.valueOf(ColorUtils.parseColor(this.mThemeColorInfo.day.dark_color)));
                arrayList.add(Integer.valueOf(ColorUtils.parseColor(this.mThemeColorInfo.night.light_color)));
                arrayList.add(Integer.valueOf(ColorUtils.parseColor(this.mThemeColorInfo.night.dark_color)));
                arrayList.add(Integer.valueOf(ColorUtils.parseColor(this.mThemeColorInfo.dark.light_color)));
                arrayList.add(Integer.valueOf(ColorUtils.parseColor(this.mThemeColorInfo.dark.dark_color)));
                return arrayList;
            }
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void parseHistoryForum(HistoryForumInfo historyForumInfo) {
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, historyForumInfo) != null) || historyForumInfo == null) {
            return;
        }
        this.mForumImageUrl = historyForumInfo.avatar;
        this.mForumId = String.valueOf(historyForumInfo.forum_id);
        this.mForumName = historyForumInfo.forum_name;
        boolean z4 = false;
        if (historyForumInfo.is_liveforum.intValue() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isAlaForum = z;
        this.mRedCount = historyForumInfo.unread_num.intValue();
        this.mVisitedTime = historyForumInfo.visit_time;
        this.mThemeColorInfo = historyForumInfo.theme_color;
        this.mFollowNumber = historyForumInfo.follow_num.intValue();
        this.mNeedTrans = historyForumInfo.need_trans.booleanValue();
        this.mLevel = historyForumInfo.level_id.intValue();
        BlockPopInfo blockPopInfo = historyForumInfo.block_pop_info;
        if (blockPopInfo != null) {
            if (blockPopInfo.can_post.intValue() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.mIsCanPost = z3;
            this.mBlockInfo = historyForumInfo.block_pop_info.block_info;
        }
        if (!ListUtils.isEmpty(historyForumInfo.tab_info)) {
            this.mTabInfoList = new ArrayList();
            for (FrsTabInfo frsTabInfo : historyForumInfo.tab_info) {
                if (frsTabInfo != null) {
                    this.mTabInfoList.add(new FrsTabItemData(frsTabInfo));
                }
            }
        }
        if (historyForumInfo.has_postpre.booleanValue()) {
            PostPrefixData postPrefixData = new PostPrefixData();
            this.mPostPrefix = postPrefixData;
            postPrefixData.parserProtobuf(historyForumInfo.post_prefix);
        }
        if (historyForumInfo.is_forum_business_account.intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.isForumBusinessAccount = z2;
        if (historyForumInfo.tag_info != null) {
            ForumTagInfo forumTagInfo = new ForumTagInfo();
            this.forumTagInfo = forumTagInfo;
            forumTagInfo.id = String.valueOf(historyForumInfo.tag_info.id);
            ForumTagInfo forumTagInfo2 = this.forumTagInfo;
            RecomTagInfo recomTagInfo = historyForumInfo.tag_info;
            forumTagInfo2.name = recomTagInfo.name;
            forumTagInfo2.pic = recomTagInfo.pic;
        }
        this.firstCategory = historyForumInfo.first_category;
        if (historyForumInfo.is_like.intValue() == 1) {
            z4 = true;
        }
        this.mIsLike = z4;
        this.mDayThreadNum = historyForumInfo.day_thread_num.intValue();
    }

    public void setDayThreadNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.mDayThreadNum = i;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.mForumId = str;
        }
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.mForumName = str;
        }
    }

    public void setIsLike(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.mIsLike = z;
        }
    }

    public void setIsPost(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.mIsPost = z;
        }
    }

    public void setPostNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.mPostNum = i;
        }
    }
}
