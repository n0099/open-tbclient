package com.baidu.tbadk.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ForumTagInfo;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.jf7;
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
/* loaded from: classes3.dex */
public class VisitedForumData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String firstCategory;
    public ForumTagInfo forumTagInfo;
    public boolean isAlaForum;
    public boolean isForumBusinessAccount;
    public String mBlockInfo;
    public int mFollowNumber;
    public String mForumId;
    public String mForumImageUrl;
    public String mForumName;
    public boolean mIsCanPost;
    public boolean mIsPost;
    public int mLevel;
    public boolean mNeedTrans;
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

    public String getBlockInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBlockInfo : (String) invokeV.objValue;
    }

    public int getFollowNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mFollowNumber : invokeV.intValue;
    }

    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mForumId : (String) invokeV.objValue;
    }

    public String getForumImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mForumImageUrl : (String) invokeV.objValue;
    }

    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mForumName : (String) invokeV.objValue;
    }

    public int getLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mLevel : invokeV.intValue;
    }

    public boolean getNeedTrans() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mNeedTrans : invokeV.booleanValue;
    }

    public PostPrefixData getPostPrefix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPostPrefix : (PostPrefixData) invokeV.objValue;
    }

    public int getRedCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mRedCount : invokeV.intValue;
    }

    public List<FrsTabItemData> getTabInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mTabInfoList : (List) invokeV.objValue;
    }

    public ArrayList<Integer> getThemeColorArrayList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ThemeColorInfo themeColorInfo = this.mThemeColorInfo;
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                return null;
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(Integer.valueOf(jf7.b(this.mThemeColorInfo.day.light_color)));
            arrayList.add(Integer.valueOf(jf7.b(this.mThemeColorInfo.day.dark_color)));
            arrayList.add(Integer.valueOf(jf7.b(this.mThemeColorInfo.night.light_color)));
            arrayList.add(Integer.valueOf(jf7.b(this.mThemeColorInfo.night.dark_color)));
            arrayList.add(Integer.valueOf(jf7.b(this.mThemeColorInfo.dark.light_color)));
            arrayList.add(Integer.valueOf(jf7.b(this.mThemeColorInfo.dark.dark_color)));
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ThemeColorInfo getThemeColorInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mThemeColorInfo : (ThemeColorInfo) invokeV.objValue;
    }

    public String getVisitedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mVisitedTime : (String) invokeV.objValue;
    }

    public boolean isAlaForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.isAlaForum : invokeV.booleanValue;
    }

    public boolean isCanPost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mIsCanPost : invokeV.booleanValue;
    }

    public boolean isPost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mIsPost : invokeV.booleanValue;
    }

    public void parseHistoryForum(HistoryForumInfo historyForumInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, historyForumInfo) == null) || historyForumInfo == null) {
            return;
        }
        this.mForumImageUrl = historyForumInfo.avatar;
        this.mForumId = String.valueOf(historyForumInfo.forum_id);
        this.mForumName = historyForumInfo.forum_name;
        this.isAlaForum = historyForumInfo.is_liveforum.intValue() == 1;
        this.mRedCount = historyForumInfo.unread_num.intValue();
        this.mVisitedTime = historyForumInfo.visit_time;
        this.mThemeColorInfo = historyForumInfo.theme_color;
        this.mFollowNumber = historyForumInfo.follow_num.intValue();
        this.mNeedTrans = historyForumInfo.need_trans.booleanValue();
        this.mLevel = historyForumInfo.level_id.intValue();
        BlockPopInfo blockPopInfo = historyForumInfo.block_pop_info;
        if (blockPopInfo != null) {
            this.mIsCanPost = blockPopInfo.can_post.intValue() == 1;
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
        this.isForumBusinessAccount = historyForumInfo.is_forum_business_account.intValue() == 1;
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
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.mForumId = str;
        }
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.mForumName = str;
        }
    }

    public void setIsPost(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.mIsPost = z;
        }
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i, ForumTagInfo forumTagInfo, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, Boolean.valueOf(z), themeColorInfo, Integer.valueOf(i), forumTagInfo, str5};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.forumTagInfo = forumTagInfo;
        this.firstCategory = str5;
    }
}
