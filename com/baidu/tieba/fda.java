package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ForumTagInfo;
import com.baidu.tbadk.core.data.FrsBannerHeaderData;
import com.baidu.tbadk.core.data.FrsGameRankInfoData;
import com.baidu.tbadk.core.data.FrsSpriteNewUserGuide;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SpecHotTopicHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.mvc.data.IResponseData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.FrsBountyTaskData;
import com.baidu.tieba.recapp.localads.LocationCacheData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import tbclient.AdMixFloor;
import tbclient.AddBawuPopInfo;
import tbclient.AlaLiveNotify;
import tbclient.BottomMenu;
import tbclient.CategoryInfo;
import tbclient.ForumArIno;
import tbclient.ForumRuleStatus;
import tbclient.FrsPage.ActivityConfig;
import tbclient.FrsPage.AgreeBanner;
import tbclient.FrsPage.ColorEgg;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.FrsPage.ForumGroup;
import tbclient.FrsPage.ForumHeadIcon;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.FrsPage.HeaderCard;
import tbclient.FrsPage.LiveFuseForumData;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsPage.NebulaHotThreads;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsPage.RecomPostTopic;
import tbclient.FrsPage.StarEnter;
import tbclient.FrsPage.StarRank;
import tbclient.FrsTabInfo;
import tbclient.HotUserRankEntry;
import tbclient.ItemInfo;
import tbclient.OriForumInfo;
import tbclient.PopInfo;
import tbclient.ServiceArea;
import tbclient.SignActivityInfo;
import tbclient.SmartApp;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.WindowToast;
/* loaded from: classes5.dex */
public class fda implements vl5, IResponseData {
    public static /* synthetic */ Interceptable $ic;
    public static final Wire WIRE;
    public transient /* synthetic */ FieldHolder $fh;
    public int accessFlag;
    public ActivityConfig activityConfig;
    public List<AdMixFloor> adMixFloor;
    public String adSampleMapKey;
    public int adShowSelect;
    public AgreeBanner agreeBanner;
    public int alaLiveCount;
    public AntiData anti;
    public int baWuNoticeNum;
    public String bawuCenterUrl;
    public AddBawuPopInfo bawuPopInfo;
    public lw4 bookInfoData;
    public List<BottomMenu> bottomMenuList;
    @Nullable
    public FrsBountyTaskData bountyTaskData;
    public rc7 brandAdData;
    public ada businessPromot;
    public ThreadData cardVideoInfo;
    public ew4 carrierEnterData;
    public List<CategoryInfo> categoryInfos;
    public uca chatGroup;
    public ArrayList<hw4> color_eggs;
    public int defaultShowTab;
    public PopInfo enterFrsDialogInfo;
    public String firstCategory;
    public boolean fortuneBag;
    public String fortuneDesc;
    public ForumData forum;
    public ForumActiveInfo forumActiveInfo;
    public ForumArIno forumArIno;
    public ForumHeadIcon forumHeadIcon;
    public ForumRuleStatus forumRule;
    public int forumState;
    public ForumTagInfo forumTagInfo;
    public FrsBannerHeaderData frsBannerHeaderData;
    public int frsDefaultTabId;
    public ForumGroup frsForumGroup;
    public FrsGameRankInfoData frsGameRankInfoData;
    public PopInfo frsMaskPopInfo;
    @Nullable
    public FrsSpriteNewUserGuide frsSpriteNewUserGuide;
    public int gameDefaultTabId;
    public String gameName;
    public List<FrsTabInfo> gameTabInfo;
    public String gameUrl;
    public lda gconAccount;
    public boolean hasGame;
    public uw4 headSdkData;
    public HeaderCard headerCard;
    public ow4 headlineImgInfoData;
    public boolean isBrandForum;
    public boolean isFromCache;
    public boolean isFrsVideoAutoPlay;
    public boolean isMemberBroadcastForum;
    public int isNewUrl;
    public boolean isShowRedTip;
    public ItemInfo itemInfo;
    public List<FeedForumData> likeFeedForumDataList;
    public List<LiveFuseForumData> liveFuseForumDataList;
    public AlaLiveNotify liveNotify;
    public kw4 mActivityHeadData;
    public List<yh> mCardShipinNew;
    public List<Integer> mCardShipinPos;
    public long mDataParseTime;
    public hda mEntelechyTabInfo;
    public int mErrorNo;
    public yca mFrsInsertLiveData;
    public zca mFrsStageLiveData;
    public kda mFrsVideoActivityData;
    public vt7 mGameRankListData;
    public boolean mHasThreadExceptTop;
    public HotUserRankEntry mHotUserRankData;
    public FrsTabInfo mNewChapterInfo;
    public PrivateForumPopInfoData mPrivateForumPopInfoData;
    public SignActivityInfo mSignActivityInfo;
    public int mSortType;
    public List<WindowToast> mWindowToast;
    public Integer mangaReadRecordChapterId;
    public NebulaHotThreads nebulaHotThreads;
    public int needLog;
    public List<OriForumInfo> oriForumInfoList;
    public mx4 page;
    public int photoLivePos;
    public RecomPostTopic postTopic;
    public rw4 presentInfoData;
    public vx4 privateForumTotalData;
    public List<RecmForumInfo> recm_forum_list;
    public vw4 recommendBookData;
    public cy4 schoolRecommendInfo;
    public int schoolRecommendPos;
    public uda serviceAreaData;
    public List<Map<String, Object>> serviceAreaFlutterData;
    public Integer showAdsense;
    public SmartApp smartApp;
    public List<String> smartAppAvatar;
    public gda star;
    public List<cda> starEnter;
    public StarRank starRank;
    public ArrayList<yh> threadList;
    public List<Long> threadListIds;
    public Integer toLoadHorseData;
    public List<yh> topThreadList;
    public UserData userData;
    public List<User> userList;
    public HashMap<String, MetaData> userMap;
    public ld7 userRecommend;
    @Nullable
    public o85 voiceRoomConfig;
    @Nullable
    public p85 voiceRoomData;

    @Override // com.baidu.tieba.wl5
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vl5
    public boolean initByByteArray(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, bArr)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.data.IResponseData
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, jSONObject) == null) {
        }
    }

    @Override // com.baidu.tbadk.mvc.data.IResponseData
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, message) == null) {
        }
    }

    @Override // com.baidu.tieba.vl5
    public byte[] toCacheByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947761670, "Lcom/baidu/tieba/fda;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947761670, "Lcom/baidu/tieba/fda;");
                return;
            }
        }
        WIRE = new Wire(new Class[0]);
    }

    public int getAccessFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.accessFlag;
        }
        return invokeV.intValue;
    }

    public kw4 getActivityHeadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mActivityHeadData;
        }
        return (kw4) invokeV.objValue;
    }

    public AgreeBanner getAgreeBanner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.agreeBanner;
        }
        return (AgreeBanner) invokeV.objValue;
    }

    public int getAlaLiveCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.alaLiveCount;
        }
        return invokeV.intValue;
    }

    public AntiData getAnti() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.anti;
        }
        return (AntiData) invokeV.objValue;
    }

    public int getBaWuNoticeNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.baWuNoticeNum;
        }
        return invokeV.intValue;
    }

    public String getBawuCenterUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.bawuCenterUrl;
        }
        return (String) invokeV.objValue;
    }

    public lw4 getBookInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.bookInfoData;
        }
        return (lw4) invokeV.objValue;
    }

    @Nullable
    public FrsBountyTaskData getBountyTaskData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.bountyTaskData;
        }
        return (FrsBountyTaskData) invokeV.objValue;
    }

    public ada getBusinessPromot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.businessPromot;
        }
        return (ada) invokeV.objValue;
    }

    public List<yh> getCardShipinNew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mCardShipinNew;
        }
        return (List) invokeV.objValue;
    }

    public List<Integer> getCardShipinPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mCardShipinPos;
        }
        return (List) invokeV.objValue;
    }

    public ThreadData getCardVideoInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.cardVideoInfo;
        }
        return (ThreadData) invokeV.objValue;
    }

    public ew4 getCarrierEnterData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.carrierEnterData;
        }
        return (ew4) invokeV.objValue;
    }

    public List<CategoryInfo> getCategoryInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.categoryInfos;
        }
        return (List) invokeV.objValue;
    }

    public uca getChatGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.chatGroup;
        }
        return (uca) invokeV.objValue;
    }

    public long getDataParseTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mDataParseTime;
        }
        return invokeV.longValue;
    }

    public hda getEntelechyTabInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mEntelechyTabInfo;
        }
        return (hda) invokeV.objValue;
    }

    public String getFortuneDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.fortuneDesc;
        }
        return (String) invokeV.objValue;
    }

    public ForumData getForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.forum;
        }
        return (ForumData) invokeV.objValue;
    }

    public ForumHeadIcon getForumHeadIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.forumHeadIcon;
        }
        return (ForumHeadIcon) invokeV.objValue;
    }

    public int getForumState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.forumState;
        }
        return invokeV.intValue;
    }

    public int getFrsDefaultTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.frsDefaultTabId;
        }
        return invokeV.intValue;
    }

    public yca getFrsInsertLiveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mFrsInsertLiveData;
        }
        return (yca) invokeV.objValue;
    }

    public zca getFrsStageLiveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mFrsStageLiveData;
        }
        return (zca) invokeV.objValue;
    }

    public kda getFrsVideoActivityData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.mFrsVideoActivityData;
        }
        return (kda) invokeV.objValue;
    }

    public int getGameDefaultTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.gameDefaultTabId;
        }
        return invokeV.intValue;
    }

    public String getGameName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.gameName;
        }
        return (String) invokeV.objValue;
    }

    public vt7 getGameRankListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.mGameRankListData;
        }
        return (vt7) invokeV.objValue;
    }

    public List<FrsTabInfo> getGameTabInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.gameTabInfo;
        }
        return (List) invokeV.objValue;
    }

    public String getGameUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.gameUrl;
        }
        return (String) invokeV.objValue;
    }

    public lda getGconAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.gconAccount;
        }
        return (lda) invokeV.objValue;
    }

    public uw4 getHeadSdkData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.headSdkData;
        }
        return (uw4) invokeV.objValue;
    }

    public ow4 getHeadlineImgInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.headlineImgInfoData;
        }
        return (ow4) invokeV.objValue;
    }

    public HotUserRankEntry getHotUserRankData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.mHotUserRankData;
        }
        return (HotUserRankEntry) invokeV.objValue;
    }

    public int getIsNewUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.isNewUrl;
        }
        return invokeV.intValue;
    }

    public List<FeedForumData> getLikeFeedForumDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.likeFeedForumDataList;
        }
        return (List) invokeV.objValue;
    }

    public AlaLiveNotify getLiveNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.liveNotify;
        }
        return (AlaLiveNotify) invokeV.objValue;
    }

    public Integer getMangaReadRecordChapterId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.mangaReadRecordChapterId;
        }
        return (Integer) invokeV.objValue;
    }

    public mx4 getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.page;
        }
        return (mx4) invokeV.objValue;
    }

    public int getPhotoLivePos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.photoLivePos;
        }
        return invokeV.intValue;
    }

    public PrivateForumPopInfoData getPrivateForumPopInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.mPrivateForumPopInfoData;
        }
        return (PrivateForumPopInfoData) invokeV.objValue;
    }

    public vx4 getPrivateForumTotalInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.privateForumTotalData;
        }
        return (vx4) invokeV.objValue;
    }

    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.recm_forum_list;
        }
        return (List) invokeV.objValue;
    }

    public int getSchoolRecommendPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.schoolRecommendPos;
        }
        return invokeV.intValue;
    }

    public cy4 getSchoolRecommendUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.schoolRecommendInfo;
        }
        return (cy4) invokeV.objValue;
    }

    public int getSortType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.mSortType;
        }
        return invokeV.intValue;
    }

    public gda getStar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.star;
        }
        return (gda) invokeV.objValue;
    }

    public List<cda> getStarEnter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.starEnter;
        }
        return (List) invokeV.objValue;
    }

    public ArrayList<yh> getThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.threadList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<Long> getThreadListIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.threadListIds;
        }
        return (List) invokeV.objValue;
    }

    public Integer getToLoadHorseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.toLoadHorseData;
        }
        return (Integer) invokeV.objValue;
    }

    public UserData getUserData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.userData;
        }
        return (UserData) invokeV.objValue;
    }

    public HashMap<String, MetaData> getUserMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.userMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public ld7 getUserRecommend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.userRecommend;
        }
        return (ld7) invokeV.objValue;
    }

    @NonNull
    public o85 getVoiceRoomConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            o85 o85Var = this.voiceRoomConfig;
            if (o85Var != null) {
                return o85Var;
            }
            return o85.a;
        }
        return (o85) invokeV.objValue;
    }

    public p85 getVoiceRoomData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.voiceRoomData;
        }
        return (p85) invokeV.objValue;
    }

    public boolean isFortuneBag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.fortuneBag;
        }
        return invokeV.booleanValue;
    }

    public boolean isHasGame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.hasGame;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowRedTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.isShowRedTip;
        }
        return invokeV.booleanValue;
    }

    public ArrayList<yh> switchThreadDataToThreadCardInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            ArrayList<yh> switchThreadDataToThreadCardInfo = switchThreadDataToThreadCardInfo(this.threadList);
            setThreadList(switchThreadDataToThreadCardInfo);
            return switchThreadDataToThreadCardInfo;
        }
        return (ArrayList) invokeV.objValue;
    }

    public fda() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.needLog = 0;
        this.starEnter = new ArrayList();
        this.isNewUrl = 0;
        this.color_eggs = new ArrayList<>();
        this.mActivityHeadData = null;
        this.mEntelechyTabInfo = new hda();
        this.frsDefaultTabId = 1;
        this.isShowRedTip = false;
        this.bawuCenterUrl = null;
        this.headSdkData = null;
        this.recommendBookData = null;
        this.postTopic = null;
        this.bookInfoData = null;
        this.mangaReadRecordChapterId = -1;
        this.presentInfoData = null;
        this.headlineImgInfoData = null;
        this.schoolRecommendPos = -1;
        this.topThreadList = null;
        this.forumState = 0;
        this.accessFlag = 0;
        this.alaLiveCount = 0;
        this.gameDefaultTabId = 0;
        this.mErrorNo = 0;
        this.defaultShowTab = 1;
        this.mDataParseTime = 0L;
        this.serviceAreaFlutterData = new ArrayList();
        initData();
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.forum = new ForumData();
            this.threadList = new ArrayList<>();
            this.topThreadList = new ArrayList();
            this.userMap = new HashMap<>();
            this.page = new mx4();
            this.star = new gda();
            this.userData = new UserData();
            this.gconAccount = new lda();
            setAnti(new AntiData());
            setChatGroup(new uca());
            this.privateForumTotalData = new vx4();
            this.mCardShipinNew = new ArrayList();
            this.mCardShipinPos = new ArrayList();
        }
    }

    private void handleDefaultTab(int i) {
        List<FrsTabInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i) == null) {
            this.frsDefaultTabId = 1;
            hda hdaVar = this.mEntelechyTabInfo;
            if (hdaVar != null && (list = hdaVar.a) != null && list.size() > 0) {
                for (FrsTabInfo frsTabInfo : this.mEntelechyTabInfo.a) {
                    if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                        this.frsDefaultTabId = i;
                        return;
                    }
                }
            }
        }
    }

    public void deleteLikeFeedForum(String str) {
        List<FeedForumData> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (list = this.likeFeedForumDataList) != null && str != null) {
            for (FeedForumData feedForumData : list) {
                if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                    this.likeFeedForumDataList.remove(feedForumData);
                    return;
                }
            }
        }
    }

    private void insertPeiWanData(ThreadData threadData, ArrayList<yh> arrayList, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, this, threadData, arrayList, i) == null) && threadData != null && arrayList != null && threadData.getPeiwanInfo() != null) {
            wk6 wk6Var = new wk6();
            wk6Var.p(threadData.getPeiwanInfo().room_status);
            wk6Var.q(threadData.getPeiwanInfo().room_status_text);
            wk6Var.l(threadData.getPeiwanInfo().cover);
            wk6Var.r(threadData.getPeiwanInfo().scheme);
            wk6Var.v(threadData.getPeiwanInfo().voice);
            wk6Var.t(threadData.getPeiwanInfo().tag_list);
            wk6Var.o(threadData.getPeiwanInfo().room_id.longValue());
            threadData.setSupportType(BaseCardInfo.SupportType.BOTTOM);
            wk6Var.u(threadData);
            wk6Var.setSupportType(BaseCardInfo.SupportType.BOTTOM);
            wk6Var.position = i + 1;
            wk6Var.setTid(threadData.tid);
            wk6Var.m(!this.isFromCache);
            arrayList.add(wk6Var);
        }
    }

    private void insertRecommendInfo(ThreadData threadData, ArrayList<yh> arrayList, int i) {
        ThreadRecommendInfoData threadRecommendInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65541, this, threadData, arrayList, i) == null) && threadData != null && arrayList != null && (threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData.getThreadRecommendInfoDataList(), 0)) != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason)) {
            py4 py4Var = new py4();
            py4Var.s = true;
            py4Var.t = threadData;
            py4Var.position = i;
            py4Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
            arrayList.add(py4Var);
        }
    }

    private void setRemoveDuplicationFlag(DataRes dataRes, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, this, dataRes, threadData) == null) && threadData.getThreadType() == 69) {
            if (dataRes.is_need_live_ununiq.intValue() == 1) {
                threadData.setNeedRemoveDuplicationFlag(ThreadData.RemoveDuplication.NOT_NEED);
            } else {
                threadData.setNeedRemoveDuplicationFlag(ThreadData.RemoveDuplication.NEED);
            }
        }
    }

    public void convertThreadInfoToThreadData(DataRes dataRes, List<ThreadInfo> list, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{dataRes, list, Long.valueOf(j)}) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                ThreadData threadData = new ThreadData();
                threadData.setDispatchedForumId(dataRes.forum.id.longValue());
                SpecHotTopicHelper.setSpecTopicIcon(j, threadData);
                threadData.setUserMap(this.userMap);
                threadData.setFromFrs(true);
                threadData.parserProtobuf(threadInfo);
                threadData.parser_title();
                threadData.insertItemToTitleOrAbstractText();
                if (threadData.getFid() == 0 && j != 0) {
                    threadData.setFid(j);
                }
                if (StringUtils.isNull(threadData.getForum_name())) {
                    threadData.setForum_name(this.forum.getName());
                }
                threadData.setForumAvatar(this.forum.getImage_url());
                threadData.parseStyle_flag(this.color_eggs);
                threadData.isFromBrandForum = this.forum.isBrandForum;
                setRemoveDuplicationFlag(dataRes, threadData);
                if (!TextUtils.isEmpty(threadData.getLegoCard())) {
                    cx4 cx4Var = new cx4();
                    cx4Var.e(threadData.getLegoCard());
                    this.threadList.add(cx4Var);
                } else {
                    this.threadList.add(threadData);
                    JSONObject c = h1a.c(threadInfo, threadData.getForum_name());
                    if (c != null) {
                        arrayList.add(c);
                    }
                }
            }
        }
        h1a.f().h("FRS", arrayList);
    }

    public FrsPageResIdl parserProtobuf(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048642, this, bArr, z)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (bArr == null) {
                return null;
            }
            try {
                FrsPageResIdl frsPageResIdl = (FrsPageResIdl) WIRE.parseFrom(bArr, FrsPageResIdl.class);
                if (frsPageResIdl != null && frsPageResIdl.data != null) {
                    parserProtobuf(frsPageResIdl.data);
                }
                if (z) {
                    if (this.mDataParseTime == 0) {
                        this.mDataParseTime = System.currentTimeMillis() - currentTimeMillis;
                    }
                } else {
                    this.mDataParseTime = 0L;
                }
                return frsPageResIdl;
            } catch (Exception e) {
                BdLog.detailException(e);
                return null;
            }
        }
        return (FrsPageResIdl) invokeLZ.objValue;
    }

    public void parserProtobuf(DataRes dataRes) {
        long j;
        boolean z;
        boolean z2;
        long j2;
        boolean z3;
        boolean z4;
        MetaData metaData;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048643, this, dataRes) != null) || dataRes == null) {
            return;
        }
        try {
            initData();
            if (!ListUtils.isEmpty(dataRes.color_egg)) {
                for (ColorEgg colorEgg : dataRes.color_egg) {
                    if (colorEgg != null && !ListUtils.isEmpty(colorEgg.holiday_words)) {
                        hw4 hw4Var = new hw4();
                        if (hw4Var.c(colorEgg)) {
                            this.color_eggs.add(hw4Var);
                        }
                    }
                }
            }
            int i = 0;
            if (dataRes.forum != null) {
                if (dataRes.forum.has_game.intValue() == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                this.hasGame = z5;
                this.gameUrl = dataRes.forum.game_url;
                this.gameName = dataRes.forum.game_name;
                if (dataRes.forum.is_brand_forum.intValue() == 1) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                this.isBrandForum = z6;
                if (dataRes.forum.tag_info != null) {
                    this.firstCategory = dataRes.forum.tag_info.first_category;
                    if (dataRes.forum.tag_info.recom_tag != null) {
                        ForumTagInfo forumTagInfo = new ForumTagInfo();
                        this.forumTagInfo = forumTagInfo;
                        forumTagInfo.id = String.valueOf(dataRes.forum.tag_info.recom_tag.id);
                        this.forumTagInfo.name = dataRes.forum.tag_info.recom_tag.name;
                        this.forumTagInfo.pic = dataRes.forum.tag_info.recom_tag.pic;
                    }
                }
            }
            this.frsSpriteNewUserGuide = FrsSpriteNewUserGuide.parse(dataRes.sprite_bubble_guide);
            this.bountyTaskData = FrsBountyTaskData.parseProto(dataRes.bounty_card);
            if (this.isBrandForum && dataRes.brand_forum_info != null) {
                kw4 kw4Var = new kw4();
                this.mActivityHeadData = kw4Var;
                kw4Var.e(dataRes.brand_forum_info.head_imgs);
                rc7 rc7Var = new rc7();
                this.brandAdData = rc7Var;
                rc7Var.a(dataRes.brand_forum_info);
                if (!ListUtils.isEmpty(dataRes.brand_forum_info.relation_forum)) {
                    this.oriForumInfoList = new ArrayList();
                    for (OriForumInfo oriForumInfo : dataRes.brand_forum_info.relation_forum) {
                        if (oriForumInfo != null) {
                            this.oriForumInfoList.add(oriForumInfo);
                        }
                    }
                }
            } else if (dataRes.activityhead != null) {
                if (dataRes.forum != null) {
                    j = dataRes.forum.id.longValue();
                } else {
                    j = 0;
                }
                kw4 kw4Var2 = new kw4();
                this.mActivityHeadData = kw4Var2;
                kw4Var2.d(dataRes.activityhead, j);
            } else if (dataRes.private_forum_info != null && dataRes.private_forum_info.head_imgs != null && !ad.isEmpty(dataRes.private_forum_info.head_imgs.img_url)) {
                kw4 kw4Var3 = new kw4();
                this.mActivityHeadData = kw4Var3;
                kw4Var3.e(dataRes.private_forum_info.head_imgs);
            }
            this.bottomMenuList = dataRes.bottom_menu;
            this.adMixFloor = dataRes.ad_mix_list;
            this.adShowSelect = dataRes.ad_show_select.intValue();
            this.adSampleMapKey = dataRes.ad_sample_map_key;
            this.liveFuseForumDataList = dataRes.live_fuse_forum;
            this.baWuNoticeNum = dataRes.bawu_unread_notice_num.intValue();
            if (dataRes.recreation_rank_info != null) {
                this.frsGameRankInfoData = FrsGameRankInfoData.ofRecreationRankInfo(dataRes.recreation_rank_info);
            }
            if (dataRes.is_member_broadcast_forum.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.isMemberBroadcastForum = z;
            this.frsForumGroup = dataRes.forum_group;
            if (dataRes.frs_banner_header != null) {
                FrsBannerHeaderData frsBannerHeaderData = new FrsBannerHeaderData();
                this.frsBannerHeaderData = frsBannerHeaderData;
                frsBannerHeaderData.parseData(dataRes.frs_banner_header);
            }
            this.headerCard = dataRes.header_card;
            List<User> list = dataRes.user_list;
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    MetaData metaData2 = new MetaData();
                    metaData2.parserProtobuf(list.get(i2));
                    String userId = metaData2.getUserId();
                    if (userId != null && !userId.equals("0")) {
                        this.userMap.put(metaData2.getUserId(), metaData2);
                    }
                }
            }
            this.userList = dataRes.user_list;
            setIsNewUrl(dataRes.is_new_url.intValue());
            if (dataRes.fortune_bag.intValue() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.fortuneBag = z2;
            this.fortuneDesc = dataRes.fortune_desc;
            List<StarEnter> list2 = dataRes.star_enter;
            this.starEnter.clear();
            if (list2 != null) {
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    cda cdaVar = new cda();
                    cdaVar.h(list2.get(i3));
                    this.starEnter.add(cdaVar);
                }
            }
            this.gconAccount.c(dataRes.gcon_account);
            this.forum.parserProtobuf(dataRes.forum);
            if (dataRes.forum != null) {
                j2 = dataRes.forum.id.longValue();
                SpecHotTopicHelper.putSpecialTopicIcon(Long.valueOf(j2), dataRes.forum.topic_special_icon, dataRes.forum.topic_special_icon_right);
            } else {
                j2 = 0;
            }
            this.threadListIds = dataRes.thread_id_list;
            this.anti.parserProtobuf(dataRes.anti);
            if (dataRes.anti != null) {
                xma.g(dataRes.anti.block_pop_info);
            }
            this.chatGroup.a(dataRes.group);
            this.page.j(dataRes.page);
            this.star.c(dataRes.frs_star);
            this.userData.parserProtobuf(dataRes.user);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
            }
            if (dataRes.nav_tab_info == null) {
                NavTabInfo.Builder builder = new NavTabInfo.Builder();
                builder.tab = dataRes.frs_tab_info;
                this.mEntelechyTabInfo.a(builder.build(true));
            } else {
                this.mEntelechyTabInfo.a(dataRes.nav_tab_info);
            }
            this.defaultShowTab = 1;
            if (this.mEntelechyTabInfo != null && !ListUtils.isEmpty(this.mEntelechyTabInfo.c)) {
                this.mNewChapterInfo = this.mEntelechyTabInfo.c.get(0);
            }
            this.alaLiveCount = dataRes.ala_live_count.intValue();
            handleDefaultTab(dataRes.frs_tab_default.intValue());
            this.photoLivePos = dataRes.twzhibo_pos.intValue();
            if (dataRes.trends_redpoint.intValue() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.isShowRedTip = z3;
            convertThreadInfoToThreadData(dataRes, dataRes.thread_list, j2);
            this.categoryInfos = dataRes.category_list;
            if (!ad.isEmpty(dataRes.bawu_enter_url)) {
                this.bawuCenterUrl = dataRes.bawu_enter_url;
            }
            if (dataRes.head_sdk != null) {
                uw4 uw4Var = new uw4();
                this.headSdkData = uw4Var;
                uw4Var.a(dataRes.head_sdk);
            }
            if (dataRes.recommend_book != null) {
                vw4 vw4Var = new vw4();
                this.recommendBookData = vw4Var;
                vw4Var.c(dataRes.recommend_book);
            }
            if (dataRes.book_info != null) {
                lw4 lw4Var = new lw4();
                this.bookInfoData = lw4Var;
                lw4Var.c(dataRes.book_info);
            }
            if (dataRes.forum_present_info != null) {
                rw4 rw4Var = new rw4();
                this.presentInfoData = rw4Var;
                rw4Var.a(dataRes.forum_present_info);
            }
            if (dataRes.forum_headline_img_info != null) {
                ow4 ow4Var = new ow4();
                this.headlineImgInfoData = ow4Var;
                ow4Var.b(dataRes.forum_headline_img_info);
            }
            if (dataRes.business_promot != null) {
                ada adaVar = new ada();
                this.businessPromot = adaVar;
                adaVar.t(dataRes.business_promot);
            }
            if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                ThreadData threadData = new ThreadData();
                this.cardVideoInfo = threadData;
                threadData.setIsInsertThread(true);
                this.cardVideoInfo.setInsertFloor(this.photoLivePos);
                this.cardVideoInfo.setUserMap(this.userMap);
                this.cardVideoInfo.parserProtobuf(dataRes.card_shipin_info.get(0));
                this.cardVideoInfo.parser_title();
                this.cardVideoInfo.isFromBrandForum = this.isBrandForum;
                if (this.cardVideoInfo.getFid() == 0 && j2 != 0) {
                    this.cardVideoInfo.setFid(j2);
                }
                this.cardVideoInfo.parseStyle_flag(this.color_eggs);
                ThreadData threadData2 = this.cardVideoInfo;
                if (!this.cardVideoInfo.isTbReadDispatch()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                threadData2.setFloor5Video(z4);
                if (this.cardVideoInfo.getAuthor() != null && this.cardVideoInfo.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.cardVideoInfo.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                    UserPendantData userPendantData = new UserPendantData();
                    userPendantData.setPropsId(metaData.getPendantData().getPropsId());
                    userPendantData.setImgUrl(metaData.getPendantData().getImgUrl());
                    this.cardVideoInfo.getAuthor().setPendantData(userPendantData);
                }
            }
            if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                yca ycaVar = new yca();
                this.mFrsInsertLiveData = ycaVar;
                ycaVar.b = dataRes.ala_insert_floor.intValue();
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < dataRes.ala_live_insert.ala_live_list.size(); i4++) {
                    if (dataRes.ala_live_insert.ala_live_list.get(i4) != null) {
                        ThreadData threadData3 = new ThreadData();
                        threadData3.parserProtobuf(dataRes.ala_live_insert.ala_live_list.get(i4));
                        threadData3.isFromBrandForum = this.isBrandForum;
                        arrayList.add(threadData3);
                    }
                }
                this.mFrsInsertLiveData.a = arrayList;
            }
            if (dataRes.ala_stage_list != null) {
                this.mFrsStageLiveData = new zca();
                ArrayList arrayList2 = new ArrayList();
                for (int i5 = 0; i5 < dataRes.ala_stage_list.size(); i5++) {
                    if (dataRes.ala_stage_list.get(i5) != null) {
                        ThreadData threadData4 = new ThreadData();
                        threadData4.parserProtobuf(dataRes.ala_stage_list.get(i5));
                        threadData4.isFromBrandForum = this.isBrandForum;
                        arrayList2.add(threadData4);
                    }
                }
                this.mFrsStageLiveData.a = arrayList2;
            }
            if (dataRes.school_recom_info != null) {
                this.schoolRecommendPos = dataRes.school_recom_pos.intValue();
                cy4 cy4Var = new cy4();
                this.schoolRecommendInfo = cy4Var;
                cy4Var.d(dataRes.school_recom_info);
            }
            if (dataRes.carrier_enter != null) {
                ew4 ew4Var = new ew4();
                this.carrierEnterData = ew4Var;
                ew4Var.a(dataRes.carrier_enter);
            }
            if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                this.forumState = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                this.accessFlag = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
            }
            this.mSortType = dataRes.sort_type.intValue();
            this.needLog = dataRes.need_log.intValue();
            LocationCacheData.getInstance().setAspShowInfo(dataRes.asp_shown_info);
            this.mCardShipinPos = dataRes.card_shipin_pos;
            if (dataRes.card_shipin_new != null) {
                for (int i6 = 0; i6 < dataRes.card_shipin_new.size(); i6++) {
                    ThreadData threadData5 = new ThreadData();
                    if (this.mCardShipinPos != null && this.mCardShipinPos.size() >= dataRes.card_shipin_new.size()) {
                        threadData5.setInsertFloor(this.mCardShipinPos.get(i6).intValue());
                    }
                    threadData5.setIsInsertThread(true);
                    threadData5.parserProtobuf(dataRes.card_shipin_new.get(i6));
                    threadData5.isFromBrandForum = this.isBrandForum;
                    this.mCardShipinNew.add(threadData5);
                }
            }
            this.enterFrsDialogInfo = dataRes.enter_pop_info;
            if (dataRes.esport != null) {
                vt7 vt7Var = new vt7();
                this.mGameRankListData = vt7Var;
                vt7Var.c(dataRes.esport);
            }
            this.agreeBanner = dataRes.agree_banner;
            if (dataRes.user_extend != null) {
                ld7 ld7Var = new ld7();
                this.userRecommend = ld7Var;
                ld7Var.f(dataRes.user_extend);
            }
            this.liveNotify = dataRes.live_frs_notify;
            this.gameTabInfo = dataRes.frs_game_tab_info;
            this.gameDefaultTabId = dataRes.game_default_tab_id.intValue();
            this.forumHeadIcon = dataRes.forum_head_icon;
            if (dataRes.video != null && dataRes.video.video_act != null) {
                kda kdaVar = new kda();
                this.mFrsVideoActivityData = kdaVar;
                kdaVar.a(dataRes.video.video_act);
            }
            if (dataRes.info != null) {
                this.recm_forum_list = dataRes.info.recm_forum_list;
            }
            this.forumArIno = dataRes.forum_ar_info;
            if (dataRes.star_rank_info != null) {
                this.starRank = dataRes.star_rank_info;
            }
            if (dataRes.recom_post_topic != null) {
                this.postTopic = dataRes.recom_post_topic;
            }
            this.mWindowToast = dataRes.window_toast;
            this.activityConfig = dataRes.activity_config;
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = dataRes.smart_app_avatar;
            this.smartApp = dataRes.smart_app;
            this.nebulaHotThreads = dataRes.nebula_hot_threads;
            if (dataRes.private_forum_info != null) {
                this.privateForumTotalData.d(dataRes.private_forum_info);
            }
            if (dataRes.bawutask_pop != null) {
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                this.mPrivateForumPopInfoData = privateForumPopInfoData;
                privateForumPopInfoData.S(dataRes.bawutask_pop);
            }
            this.forumActiveInfo = dataRes.private_forum_active_info;
            this.userList = dataRes.user_list;
            HotUserRankEntry hotUserRankEntry = dataRes.hot_user_entry;
            this.mHotUserRankData = hotUserRankEntry;
            if (hotUserRankEntry != null) {
                ServiceArea.Builder builder2 = new ServiceArea.Builder();
                builder2.picurl = "icon_mask_service_celebrity24";
                builder2.servicename = "本吧红人榜";
                builder2.service_type = "本吧红人榜";
                this.serviceAreaFlutterData.add(DataExt.toMap(builder2.build(true)));
            }
            if (dataRes.sign_activity_info != null) {
                this.mSignActivityInfo = dataRes.sign_activity_info;
            }
            if (dataRes.add_bawu_pop != null) {
                this.bawuPopInfo = dataRes.add_bawu_pop;
            }
            if (!ListUtils.isEmpty(dataRes.service_area)) {
                this.serviceAreaData = new uda();
                ArrayList arrayList3 = new ArrayList();
                for (ServiceArea serviceArea : dataRes.service_area) {
                    if (serviceArea != null) {
                        this.serviceAreaFlutterData.add(DataExt.toMap(serviceArea));
                        vda vdaVar = new vda();
                        vdaVar.b = serviceArea.picurl;
                        vdaVar.c = serviceArea.servicename;
                        String str = serviceArea.service_type;
                        vdaVar.a = str;
                        if (str != null && str.equals("原生小程序") && serviceArea.area_smart_app != null) {
                            vdaVar.b = serviceArea.area_smart_app.avatar;
                            vdaVar.c = serviceArea.area_smart_app.name;
                        }
                        vdaVar.d = serviceArea.serviceurl;
                        vdaVar.e = serviceArea.schema;
                        vdaVar.i = serviceArea.third_statistics_url;
                        String str2 = serviceArea.version;
                        String string = SharedPrefHelper.getInstance().getString("frs_service_version_" + this.forum.getName() + vdaVar.c, "");
                        if (!TextUtils.isEmpty(string)) {
                            string.equals(serviceArea.version);
                        }
                        vdaVar.j = serviceArea.tag;
                        if (serviceArea.area_smart_app != null) {
                            wda wdaVar = new wda();
                            wdaVar.a(serviceArea.area_smart_app);
                            vdaVar.f = wdaVar;
                        }
                        if (this.forum != null) {
                            this.forum.getName();
                            vdaVar.g = this.forum.getId();
                        }
                        vdaVar.h = i;
                        i++;
                        arrayList3.add(vdaVar);
                    }
                }
                this.serviceAreaData.a = arrayList3.size();
                this.serviceAreaData.b = arrayList3;
            }
            this.itemInfo = dataRes.item_info;
            this.toLoadHorseData = dataRes.is_get_horse_race_lamp;
            this.forumRule = dataRes.forum_rule;
            this.showAdsense = dataRes.show_adsense;
            this.frsMaskPopInfo = dataRes.frsmask_pop_info;
            this.voiceRoomConfig = o85.b(dataRes);
            p85 p85Var = new p85();
            this.voiceRoomData = p85Var;
            p85Var.d(dataRes);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void setAccessFlag(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i) == null) {
            this.accessFlag = i;
        }
    }

    public void setActivityHeadData(kw4 kw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, kw4Var) == null) {
            this.mActivityHeadData = kw4Var;
        }
    }

    public void setAgreeBanner(AgreeBanner agreeBanner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, agreeBanner) == null) {
            this.agreeBanner = agreeBanner;
        }
    }

    public void setAlaLiveCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i) == null) {
            this.alaLiveCount = i;
        }
    }

    public void setAnti(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, antiData) == null) {
            this.anti = antiData;
        }
    }

    public void setBaWuNoticeNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048649, this, i) == null) {
            this.baWuNoticeNum = i;
        }
    }

    public void setBawuCenterUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, str) == null) {
            this.bawuCenterUrl = str;
        }
    }

    public void setBookInfo(lw4 lw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, lw4Var) == null) {
            this.bookInfoData = lw4Var;
        }
    }

    public void setBusinessPromot(ada adaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, adaVar) == null) {
            this.businessPromot = adaVar;
        }
    }

    public void setCardShipinNew(List<yh> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, list) == null) {
            this.mCardShipinNew = list;
        }
    }

    public void setCardShipinPos(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, list) == null) {
            this.mCardShipinPos = list;
        }
    }

    public void setCardVideoInfo(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, threadData) == null) {
            this.cardVideoInfo = threadData;
        }
    }

    public void setCarrierEnterData(ew4 ew4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, ew4Var) == null) {
            this.carrierEnterData = ew4Var;
        }
    }

    public void setCategoryInfos(List<CategoryInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, list) == null) {
            this.categoryInfos = list;
        }
    }

    public void setChatGroup(uca ucaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, ucaVar) == null) {
            this.chatGroup = ucaVar;
        }
    }

    public void setEntelechyTabInfo(hda hdaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, hdaVar) == null) {
            this.mEntelechyTabInfo = hdaVar;
        }
    }

    public void setFortuneBag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048660, this, z) == null) {
            this.fortuneBag = z;
        }
    }

    public void setFortuneDesc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, str) == null) {
            this.fortuneDesc = str;
        }
    }

    public void setForum(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, forumData) == null) {
            this.forum = forumData;
        }
    }

    public void setForumHeadIcon(ForumHeadIcon forumHeadIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, forumHeadIcon) == null) {
            this.forumHeadIcon = forumHeadIcon;
        }
    }

    public void setForumState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048664, this, i) == null) {
            this.forumState = i;
        }
    }

    public void setFrsDefaultTabId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048665, this, i) == null) {
            this.frsDefaultTabId = i;
        }
    }

    public void setFrsInsertLiveData(yca ycaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, ycaVar) == null) {
            this.mFrsInsertLiveData = ycaVar;
        }
    }

    public void setFrsStageLiveData(zca zcaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, zcaVar) == null) {
            this.mFrsStageLiveData = zcaVar;
        }
    }

    public void setFrsVideoActivityData(kda kdaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, kdaVar) == null) {
            this.mFrsVideoActivityData = kdaVar;
        }
    }

    public void setGameDefaultTabId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048669, this, i) == null) {
            this.gameDefaultTabId = i;
        }
    }

    public void setGameName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, str) == null) {
            this.gameName = str;
        }
    }

    public void setGameRankListData(vt7 vt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, vt7Var) == null) {
            this.mGameRankListData = vt7Var;
        }
    }

    public void setGameTabInfo(List<FrsTabInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, list) == null) {
            this.gameTabInfo = list;
        }
    }

    public void setGameUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, str) == null) {
            this.gameUrl = str;
        }
    }

    public void setGconAccount(lda ldaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, ldaVar) == null) {
            this.gconAccount = ldaVar;
        }
    }

    public void setHasGame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048675, this, z) == null) {
            this.hasGame = z;
        }
    }

    public void setHeadSdkData(uw4 uw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, uw4Var) == null) {
            this.headSdkData = uw4Var;
        }
    }

    public void setHeadlineImgInfoData(ow4 ow4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, ow4Var) == null) {
            this.headlineImgInfoData = ow4Var;
        }
    }

    public void setHotUserRankData(HotUserRankEntry hotUserRankEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, hotUserRankEntry) == null) {
            this.mHotUserRankData = hotUserRankEntry;
        }
    }

    public void setIsNewUrl(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048679, this, i) == null) {
            this.isNewUrl = i;
        }
    }

    public void setIsShowRedTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048680, this, z) == null) {
            this.isShowRedTip = z;
        }
    }

    public void setLikeFeedForumDataList(List<FeedForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, list) == null) {
            this.likeFeedForumDataList = list;
        }
    }

    public void setLiveNotify(AlaLiveNotify alaLiveNotify) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, alaLiveNotify) == null) {
            this.liveNotify = alaLiveNotify;
        }
    }

    public void setMangaReadRecordChapterId(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, num) == null) {
            this.mangaReadRecordChapterId = num;
        }
    }

    public void setPage(mx4 mx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, mx4Var) == null) {
            this.page = mx4Var;
        }
    }

    public void setPhotoLivePos(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048685, this, i) == null) {
            this.photoLivePos = i;
        }
    }

    public void setPrivateForumPopInfoData(PrivateForumPopInfoData privateForumPopInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048686, this, privateForumPopInfoData) == null) {
            this.mPrivateForumPopInfoData = privateForumPopInfoData;
        }
    }

    public void setPrivateForumTotalInfo(vx4 vx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, vx4Var) == null) {
            this.privateForumTotalData = vx4Var;
        }
    }

    public void setSchoolRecommendInfo(cy4 cy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, cy4Var) == null) {
            this.schoolRecommendInfo = cy4Var;
        }
    }

    public void setSchoolRecommendPos(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048689, this, i) == null) {
            this.schoolRecommendPos = i;
        }
    }

    public void setSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048690, this, i) == null) {
            this.mSortType = i;
        }
    }

    public void setStar(gda gdaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, gdaVar) == null) {
            this.star = gdaVar;
        }
    }

    public void setStarEnter(List<cda> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, list) == null) {
            this.starEnter = list;
        }
    }

    public void setThreadList(ArrayList<yh> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048693, this, arrayList) == null) {
            this.threadList = arrayList;
        }
    }

    public void setThreadListIds(List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, list) == null) {
            this.threadListIds = list;
        }
    }

    public void setUserData(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, userData) == null) {
            this.userData = userData;
        }
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, hashMap) == null) {
            this.userMap = hashMap;
        }
    }

    public void setUserRecommend(ld7 ld7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, ld7Var) == null) {
            this.userRecommend = ld7Var;
        }
    }

    public void setVoiceRoomConfig(@Nullable o85 o85Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048698, this, o85Var) == null) {
            this.voiceRoomConfig = o85Var;
        }
    }

    public p85 setVoiceRoomData(p85 p85Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048699, this, p85Var)) == null) {
            this.voiceRoomData = p85Var;
            return p85Var;
        }
        return (p85) invokeL.objValue;
    }

    public ArrayList<yh> switchThreadDataToThreadCardInfo(ArrayList<yh> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048701, this, arrayList)) == null) {
            this.mHasThreadExceptTop = false;
            ArrayList<yh> arrayList2 = new ArrayList<>();
            Iterator<yh> it = arrayList.iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                yh next = it.next();
                if (next instanceof bx4) {
                    ((bx4) next).setPosition(i - i2);
                    arrayList2.add(next);
                } else if (next instanceof cx4) {
                    ((cx4) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int i3 = i + 1;
                    threadData.floorPosition = i3;
                    threadData.isFromNet = !this.isFromCache;
                    if (threadData.isTop()) {
                        i2++;
                    }
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        py4 py4Var = new py4();
                        py4Var.t = threadData;
                        py4Var.position = i;
                        py4Var.a = true;
                        py4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(py4Var);
                        py4 py4Var2 = new py4();
                        py4Var2.t = threadData;
                        py4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            py4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            py4Var2.d = true;
                            py4Var2.u = imageWidthAndHeight[0];
                            py4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            py4Var2.e = true;
                        } else {
                            py4Var2.b = true;
                        }
                        py4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(py4Var2);
                        if (threadData.getPollData() != null) {
                            py4 py4Var3 = new py4();
                            py4Var3.o = true;
                            py4Var3.t = threadData;
                            py4Var3.position = i;
                            py4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            py4 py4Var4 = new py4();
                            py4Var4.l = true;
                            py4Var4.t = threadData;
                            py4Var4.position = i;
                            py4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            py4 py4Var5 = new py4();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                py4Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                py4Var5.q = true;
                            }
                            py4Var5.t = threadData;
                            py4Var5.position = i;
                            py4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            py4 py4Var6 = new py4();
                            py4Var6.h = true;
                            py4Var6.t = threadData;
                            py4Var6.position = i;
                            py4Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var6);
                        }
                        if (threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            py4 py4Var7 = new py4();
                            py4Var7.n = true;
                            py4Var7.t = threadData;
                            py4Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var7);
                        }
                        insertRecommendInfo(threadData, arrayList2, i);
                        insertPeiWanData(threadData, arrayList2, i);
                        py4 py4Var8 = new py4();
                        py4Var8.g = true;
                        py4Var8.t = threadData;
                        py4Var8.position = i;
                        py4Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        if (ThreadCardUtils.isBottomShowOp(threadData)) {
                            arrayList2.add(py4Var8);
                        }
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        py4 py4Var9 = new py4();
                        py4Var9.t = threadData;
                        py4Var9.position = i;
                        py4Var9.a = true;
                        py4Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(py4Var9);
                        py4 py4Var10 = new py4();
                        py4Var10.t = threadData;
                        py4Var10.position = i;
                        if (threadData instanceof jx4) {
                            py4Var10.j = true;
                        } else {
                            py4Var10.i = true;
                        }
                        py4Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(py4Var10);
                        if (threadData.getPollData() != null) {
                            py4 py4Var11 = new py4();
                            py4Var11.o = true;
                            py4Var11.t = threadData;
                            py4Var11.position = i;
                            py4Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            py4 py4Var12 = new py4();
                            py4Var12.l = true;
                            py4Var12.t = threadData;
                            py4Var12.position = i;
                            py4Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            py4 py4Var13 = new py4();
                            py4Var13.h = true;
                            py4Var13.t = threadData;
                            py4Var13.position = i;
                            py4Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var13);
                        }
                        if (threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            py4 py4Var14 = new py4();
                            py4Var14.n = true;
                            py4Var14.t = threadData;
                            py4Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var14);
                        }
                        insertRecommendInfo(threadData, arrayList2, i);
                        insertPeiWanData(threadData, arrayList2, i);
                        py4 py4Var15 = new py4();
                        py4Var15.g = true;
                        py4Var15.t = threadData;
                        py4Var15.position = i;
                        py4Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        if (ThreadCardUtils.isBottomShowOp(threadData)) {
                            arrayList2.add(py4Var15);
                        }
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        py4 py4Var16 = new py4();
                        py4Var16.t = threadData;
                        py4Var16.position = i;
                        py4Var16.a = true;
                        py4Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(py4Var16);
                        py4 py4Var17 = new py4();
                        py4Var17.t = threadData;
                        py4Var17.position = i;
                        py4Var17.k = true;
                        py4Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(py4Var17);
                        if (threadData.getPollData() != null) {
                            py4 py4Var18 = new py4();
                            py4Var18.o = true;
                            py4Var18.t = threadData;
                            py4Var18.position = i;
                            py4Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            py4 py4Var19 = new py4();
                            py4Var19.l = true;
                            py4Var19.t = threadData;
                            py4Var19.position = i;
                            py4Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            py4 py4Var20 = new py4();
                            py4Var20.h = true;
                            py4Var20.t = threadData;
                            py4Var20.position = i;
                            py4Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var20);
                        }
                        if (threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            py4 py4Var21 = new py4();
                            py4Var21.n = true;
                            py4Var21.t = threadData;
                            py4Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(py4Var21);
                        }
                        insertRecommendInfo(threadData, arrayList2, i);
                        insertPeiWanData(threadData, arrayList2, i);
                        py4 py4Var22 = new py4();
                        py4Var22.g = true;
                        py4Var22.t = threadData;
                        py4Var22.position = i;
                        py4Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        if (ThreadCardUtils.isBottomShowOp(threadData)) {
                            arrayList2.add(py4Var22);
                        }
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        py4 py4Var23 = new py4();
                        py4Var23.t = threadData;
                        py4Var23.position = i;
                        arrayList2.add(py4Var23);
                    }
                    threadData.setSupportType(BaseCardInfo.SupportType.TOP);
                    i = i3;
                    if (next != null && next.getType() != ThreadData.TYPE_TOP) {
                        this.mHasThreadExceptTop = true;
                    }
                } else {
                    arrayList2.add(next);
                }
                i++;
                if (next != null) {
                    this.mHasThreadExceptTop = true;
                }
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }
}
