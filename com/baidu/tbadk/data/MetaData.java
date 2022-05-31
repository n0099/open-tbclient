package com.baidu.tbadk.data;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupLevelActivityConfig;
import com.baidu.tbadk.core.atomData.NativeEmotionManagerActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.coreExtra.data.BazhuGradeData;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.coreExtra.data.PrivSetsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jg;
import com.repackage.ki;
import com.repackage.ou4;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.BaijiahaoInfo;
import tbclient.BazhuSign;
import tbclient.ForumToolPerm;
import tbclient.GodInfo;
import tbclient.Icon;
import tbclient.LiveRoomInfo;
import tbclient.NewGodInfo;
import tbclient.PrivSets;
import tbclient.SpringVirtualUser;
import tbclient.TbVipInfo;
import tbclient.TshowInfo;
import tbclient.User;
/* loaded from: classes3.dex */
public class MetaData extends OrmObject implements Serializable, ou4 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -2658065756886586092L;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaInfoData alaInfo;
    public AlaUserInfoData alaUserData;
    public String appealThreadPopover;
    public String authDesc;
    public int authType;
    public transient BaijiahaoInfo baijiahaoInfo;
    public String bawu_type;
    public String bazhuDesc;
    public String bazhuLevel;
    public int bazhuShowOutside;
    public UserTbVipInfoData bigVData;
    public BusinessAccountData businessAccountData;
    public boolean canModifyAvatar;
    public String cantModifyAvatarDesc;
    public int concernNum;
    public WorkCreateAutherData creatorInfo;
    public String fansNickName;
    public int fansNum;
    public transient List<ForumToolPerm> forumToolAuth;
    public int gender;
    public int giftNum;
    @Deprecated
    public transient GodInfo godInfo;
    public int godStatus;
    public GodUserData godUserData;
    public String god_intro;
    public String imBjhAvatar;
    public String ipAddress;
    public boolean isBigV;
    public int isBusinessAccount;
    public boolean isDefaultAvatar;
    public boolean isGod;
    public boolean isLikeStatusFromNet;
    public boolean isMask;
    public int isMem;
    public boolean isNickNameInVerifying;
    public int isOriginalAuthor;
    public int is_bawu;
    public int is_bazhu;
    public int is_follower;
    public int is_god_user;
    public int is_like;
    public int is_manager;
    public int is_my_follower;
    public int is_myfans;
    public int is_myfriend;
    public int is_nearlyAt;
    public int left_call_num;
    public int level_id;
    public int likeNum;
    public int likeStatus;
    public transient LiveRoomInfo liveRoomInfo;
    public BazhuGradeData mBazhuGrade;
    public boolean mHadConcerned;
    public ArrayList<IconData> mIconInfo;
    public NewGodData mNewGodData;
    public int mRelation;
    public ArrayList<IconData> mTShowIconInfo;
    public ArrayList<IconData> mTShowIconInfoNew;
    public List<BazhuGradeData> managerForum;
    public String name_show;
    public String nickNameInVerifying;
    public UserPendantData pendantData;
    public String portrait;
    public String portraith;
    public PrivSetsData privSetsData;
    public int rankInfluence;
    public String rankNum;
    public String sealPrefix;
    public ThemeCardInUserData themeCard;
    public int threadNum;
    public String tiebaUid;
    public int type;
    public String uk;
    public String userId;
    public String userName;
    public String virtualUserUrl;

    public MetaData() {
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
        this.isNickNameInVerifying = false;
        this.isLikeStatusFromNet = true;
        this.is_like = 0;
        this.likeStatus = 0;
        this.godUserData = new GodUserData();
        this.bigVData = new UserTbVipInfoData();
        this.mNewGodData = new NewGodData();
        this.mBazhuGrade = new BazhuGradeData();
        this.privSetsData = new PrivSetsData();
        this.userId = null;
        this.type = 0;
        this.level_id = 0;
        this.userName = null;
        this.uk = null;
        this.name_show = null;
        this.portrait = null;
        this.portraith = null;
        this.mIconInfo = new ArrayList<>();
        this.mTShowIconInfo = new ArrayList<>();
        this.mTShowIconInfoNew = new ArrayList<>();
        this.is_bawu = 0;
        this.bawu_type = null;
        this.concernNum = 0;
        this.fansNum = 0;
        this.threadNum = -1;
        this.likeNum = -1;
        this.mHadConcerned = false;
        this.godInfo = null;
        this.giftNum = 0;
        this.isMem = 0;
        this.themeCard = new ThemeCardInUserData();
        this.sealPrefix = null;
        this.left_call_num = 0;
        this.baijiahaoInfo = null;
        this.forumToolAuth = new ArrayList();
        this.tiebaUid = null;
        this.managerForum = new ArrayList();
        this.creatorInfo = null;
        this.is_follower = 0;
        this.is_my_follower = 0;
        this.is_nearlyAt = 0;
        this.is_bazhu = 0;
        this.is_god_user = 0;
    }

    private void testBaijiahaoInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            BaijiahaoInfo.Builder builder = new BaijiahaoInfo.Builder();
            builder.auth_id = 1;
            builder.auth_desc = "专家";
            this.baijiahaoInfo = builder.build(true);
        }
    }

    public boolean canModifyAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.canModifyAvatar : invokeV.booleanValue;
    }

    public AlaInfoData getAlaInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.alaInfo : (AlaInfoData) invokeV.objValue;
    }

    public AlaUserInfoData getAlaUserData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.alaUserData : (AlaUserInfoData) invokeV.objValue;
    }

    public String getAppealThreadPopover() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.appealThreadPopover : (String) invokeV.objValue;
    }

    public String getAuthDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.authDesc : (String) invokeV.objValue;
    }

    public int getAuthType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.authType : invokeV.intValue;
    }

    public String getAvatarH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.portraith : (String) invokeV.objValue;
    }

    public String getAvater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.portrait : (String) invokeV.objValue;
    }

    public BaijiahaoInfo getBaijiahaoInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.baijiahaoInfo : (BaijiahaoInfo) invokeV.objValue;
    }

    public String getBawu_type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.bawu_type : (String) invokeV.objValue;
    }

    public String getBazhuDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.bazhuDesc : (String) invokeV.objValue;
    }

    public BazhuGradeData getBazhuGradeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mBazhuGrade : (BazhuGradeData) invokeV.objValue;
    }

    public String getBazhuLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.bazhuLevel : (String) invokeV.objValue;
    }

    public int getBazhuShowOutside() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.bazhuShowOutside : invokeV.intValue;
    }

    public BusinessAccountData getBusinessAccountData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.businessAccountData : (BusinessAccountData) invokeV.objValue;
    }

    public String getCantModifyAvatarDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.cantModifyAvatarDesc : (String) invokeV.objValue;
    }

    public int getConcernNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.concernNum : invokeV.intValue;
    }

    public int getConcern_num() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.concernNum : invokeV.intValue;
    }

    public WorkCreateAutherData getCreatorInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.creatorInfo : (WorkCreateAutherData) invokeV.objValue;
    }

    public String getFansNickName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.fansNickName : (String) invokeV.objValue;
    }

    @Override // com.repackage.ou4
    public int getFansNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.fansNum : invokeV.intValue;
    }

    public List<ForumToolPerm> getForumToolAuth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.forumToolAuth : (List) invokeV.objValue;
    }

    public int getGender() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.gender : invokeV.intValue;
    }

    public int getGiftNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.giftNum : invokeV.intValue;
    }

    @Deprecated
    public GodInfo getGodInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.godInfo : (GodInfo) invokeV.objValue;
    }

    public String getGodIntro() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.god_intro : (String) invokeV.objValue;
    }

    public int getGodStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.godStatus : invokeV.intValue;
    }

    public GodUserData getGodUserData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.godUserData : (GodUserData) invokeV.objValue;
    }

    public ArrayList<IconData> getIconInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mIconInfo : (ArrayList) invokeV.objValue;
    }

    public String getImBjhAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.imBjhAvatar : (String) invokeV.objValue;
    }

    public String getIpAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.ipAddress : (String) invokeV.objValue;
    }

    public int getIsBaZhu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.is_bazhu : invokeV.intValue;
    }

    public int getIsBussinessAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.isBusinessAccount : invokeV.intValue;
    }

    public int getIsFollower() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.is_follower : invokeV.intValue;
    }

    public int getIsGodUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.is_god_user : invokeV.intValue;
    }

    @Override // com.repackage.ou4
    public boolean getIsLike() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? isGod() ? this.godUserData.getIsLike() || this.mHadConcerned : this.is_like == 1 || this.mHadConcerned : invokeV.booleanValue;
    }

    public int getIsMem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.isMem : invokeV.intValue;
    }

    public int getIsMyFans() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.is_myfans : invokeV.intValue;
    }

    public int getIsMyFollower() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.is_my_follower : invokeV.intValue;
    }

    public int getIsMyFriend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.is_myfriend : invokeV.intValue;
    }

    public int getIsNearlyAt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.is_nearlyAt : invokeV.intValue;
    }

    public int getIsOriginalAuthor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.isOriginalAuthor : invokeV.intValue;
    }

    public int getIs_bawu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.is_bawu : invokeV.intValue;
    }

    public int getIs_manager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.is_manager : invokeV.intValue;
    }

    public int getLeft_call_num() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.left_call_num : invokeV.intValue;
    }

    public int getLevel_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.level_id : invokeV.intValue;
    }

    public int getLikeNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.likeNum : invokeV.intValue;
    }

    @Override // com.repackage.ou4
    public int getLikeStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.likeStatus : invokeV.intValue;
    }

    public LiveRoomInfo getLiveRoomInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.liveRoomInfo : (LiveRoomInfo) invokeV.objValue;
    }

    public List<BazhuGradeData> getManagerForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.managerForum : (List) invokeV.objValue;
    }

    public String getName_show() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (!StringUtils.isNull(this.name_show)) {
                return this.name_show;
            }
            return this.userName;
        }
        return (String) invokeV.objValue;
    }

    public NewGodData getNewGodData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.mNewGodData : (NewGodData) invokeV.objValue;
    }

    public UserPendantData getPendantData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.pendantData : (UserPendantData) invokeV.objValue;
    }

    @Override // com.repackage.ou4
    public String getPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.portrait : (String) invokeV.objValue;
    }

    public String getPortraitH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.portraith : (String) invokeV.objValue;
    }

    public PrivSetsData getPrivSetsData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.privSetsData : (PrivSetsData) invokeV.objValue;
    }

    public String getSealPrefix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.sealPrefix : (String) invokeV.objValue;
    }

    public ArrayList<IconData> getTShowInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.mTShowIconInfo : (ArrayList) invokeV.objValue;
    }

    public ArrayList<IconData> getTShowInfoNew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.mTShowIconInfoNew : (ArrayList) invokeV.objValue;
    }

    public ThemeCardInUserData getThemeCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.themeCard : (ThemeCardInUserData) invokeV.objValue;
    }

    public int getThreadNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.threadNum : invokeV.intValue;
    }

    public String getTiebaUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.tiebaUid : (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.type : invokeV.intValue;
    }

    public String getUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.uk : (String) invokeV.objValue;
    }

    @Override // com.repackage.ou4
    public String getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.userId : (String) invokeV.objValue;
    }

    public long getUserIdLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? jg.g(this.userId, 0L) : invokeV.longValue;
    }

    public String getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            String str = this.userName;
            return (str == null || str.length() <= 0) ? "" : this.userName;
        }
        return (String) invokeV.objValue;
    }

    public UserTbVipInfoData getUserTbVipInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.bigVData : (UserTbVipInfoData) invokeV.objValue;
    }

    public String getVirtualUserUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.virtualUserUrl : (String) invokeV.objValue;
    }

    public int getmRelation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.mRelation : invokeV.intValue;
    }

    public boolean hadConcerned() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.mHadConcerned || this.is_like == 1 : invokeV.booleanValue;
    }

    public boolean isBaijiahaoUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            BaijiahaoInfo baijiahaoInfo = this.baijiahaoInfo;
            return baijiahaoInfo != null && baijiahaoInfo.auth_id.intValue() > 0;
        }
        return invokeV.booleanValue;
    }

    public boolean isBigV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.isBigV : invokeV.booleanValue;
    }

    public boolean isForumBusinessAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            BusinessAccountData businessAccountData = this.businessAccountData;
            return businessAccountData != null && businessAccountData.isForumBusinessAccount;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.ou4
    public boolean isGod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.isGod : invokeV.booleanValue;
    }

    public boolean isLikeStatusFromNet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.isLikeStatusFromNet : invokeV.booleanValue;
    }

    public boolean isNewGod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            NewGodData newGodData = this.mNewGodData;
            return newGodData != null && newGodData.isNewGod();
        }
        return invokeV.booleanValue;
    }

    public boolean isOfficial() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            BusinessAccountData businessAccountData = this.businessAccountData;
            return businessAccountData != null && businessAccountData.isBusinessAccount;
        }
        return invokeV.booleanValue;
    }

    public boolean isOriginal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            WorkCreateAutherData workCreateAutherData = this.creatorInfo;
            return (workCreateAutherData == null || TextUtils.isEmpty(workCreateAutherData.authDesc)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean isVideoGod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            NewGodData newGodData = this.mNewGodData;
            return newGodData != null && newGodData.isVideoGod();
        }
        return invokeV.booleanValue;
    }

    public void parseFromCurrentUser() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048656, this) == null) || TbadkCoreApplication.getCurrentAccountInfo() == null) {
            return;
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        this.userId = currentAccountInfo.getID();
        this.gender = currentAccountInfo.getSex();
        this.userName = currentAccountInfo.getAccount();
        this.name_show = currentAccountInfo.getAccountNameShow();
        this.portrait = currentAccountInfo.getPortrait();
    }

    public void parserJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, str) == null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserProtobuf(User user) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048659, this, user) == null) || user == null) {
            return;
        }
        this.userId = user.id + "";
        this.gender = user.gender.intValue();
        this.type = user.type.intValue();
        this.userName = user.name;
        this.level_id = user.level_id.intValue();
        this.is_like = user.is_like.intValue();
        this.is_bawu = user.is_bawu.intValue();
        this.is_manager = user.is_manager.intValue();
        this.bawu_type = user.bawu_type;
        this.is_myfriend = user.is_friend.intValue();
        this.is_myfans = user.is_fans.intValue();
        this.concernNum = user.concern_num.intValue();
        this.mHadConcerned = user.has_concerned.intValue() == 1 || user.has_concerned.intValue() == 2;
        setLikeStatus(user.has_concerned.intValue());
        this.fansNickName = user.fans_nickname;
        this.fansNum = user.fans_num.intValue();
        this.likeNum = user.agree_num.intValue();
        this.threadNum = user.thread_num.intValue();
        String str = this.userName;
        if (str != null && str.length() <= 0) {
            this.userName = null;
        }
        this.name_show = user.name_show;
        this.nickNameInVerifying = user.editing_nickname;
        this.isNickNameInVerifying = user.is_nickname_editing.intValue() == 1;
        this.portrait = user.portrait;
        this.portraith = user.portraith;
        List<Icon> list = user.iconinfo;
        List<TshowInfo> list2 = user.tshow_icon;
        List<TshowInfo> list3 = user.new_tshow_icon;
        this.isMem = user.is_mem.intValue();
        this.mIconInfo.clear();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                IconData iconData = new IconData();
                iconData.parserProtobuf(list.get(i));
                this.mIconInfo.add(iconData);
            }
        }
        this.mTShowIconInfo.clear();
        if (list2 != null) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                IconData iconData2 = new IconData();
                iconData2.parserProtobuf(list2.get(i2));
                this.mTShowIconInfo.add(iconData2);
            }
        }
        this.mTShowIconInfoNew.clear();
        if (list3 != null) {
            for (int i3 = 0; i3 < list3.size(); i3++) {
                IconData iconData3 = new IconData();
                iconData3.parserProtobuf(list3.get(i3));
                this.mTShowIconInfoNew.add(iconData3);
            }
        }
        GodInfo godInfo = user.god_data;
        if (godInfo != null) {
            this.godUserData.parserProtobuf(godInfo);
            this.isGod = this.godUserData.isGod();
            this.isBigV = this.godUserData.isBigV();
            this.god_intro = this.godUserData.getIntro();
        }
        TbVipInfo tbVipInfo = user.tb_vip;
        if (tbVipInfo != null) {
            this.bigVData.parserProtobuf(tbVipInfo);
        }
        this.godInfo = user.god_data;
        this.giftNum = user.gift_num.intValue();
        this.themeCard.parser(user.theme_card);
        if (user.pendant != null) {
            UserPendantData userPendantData = new UserPendantData();
            this.pendantData = userPendantData;
            userPendantData.parserProtobuf(user.pendant);
        }
        this.isLikeStatusFromNet = true;
        if (user.ala_info != null) {
            AlaUserInfoData alaUserInfoData = new AlaUserInfoData();
            this.alaUserData = alaUserInfoData;
            alaUserInfoData.parserProtobuf(user.ala_info);
        }
        if (user.ala_live_info != null) {
            AlaInfoData alaInfoData = new AlaInfoData();
            this.alaInfo = alaInfoData;
            alaInfoData.parserProtobuf(user.ala_live_info);
        } else if (this.alaUserData != null) {
            AlaInfoData alaInfoData2 = new AlaInfoData();
            this.alaInfo = alaInfoData2;
            AlaUserInfoData alaUserInfoData2 = this.alaUserData;
            alaInfoData2.live_status = alaUserInfoData2.live_status;
            alaInfoData2.live_id = alaUserInfoData2.live_id;
        }
        this.liveRoomInfo = user.live_room_info;
        this.sealPrefix = user.seal_prefix;
        SpringVirtualUser springVirtualUser = user.spring_virtual_user;
        if (springVirtualUser != null && springVirtualUser.is_virtual.intValue() == 1 && !StringUtils.isNull(user.spring_virtual_user.url)) {
            this.virtualUserUrl = user.spring_virtual_user.url;
        }
        this.left_call_num = user.left_call_num.intValue();
        this.baijiahaoInfo = user.baijiahao_info;
        this.canModifyAvatar = user.can_modify_avatar.intValue() == 0;
        this.cantModifyAvatarDesc = user.modify_avatar_desc;
        this.rankNum = user.level_influence;
        Integer num = user.influence;
        this.rankInfluence = num == null ? 0 : num.intValue();
        this.isMask = user.is_mask.intValue() == 1;
        NewGodInfo newGodInfo = user.new_god_data;
        if (newGodInfo != null) {
            this.mNewGodData.parserProtobuf(newGodInfo);
        }
        BazhuSign bazhuSign = user.bazhu_grade;
        if (bazhuSign != null) {
            this.mBazhuGrade.parserProtobuf(bazhuSign);
        }
        this.isDefaultAvatar = user.is_default_avatar.intValue() == 1;
        this.uk = user.uk;
        PrivSets privSets = user.priv_sets;
        if (privSets != null) {
            this.privSetsData.parserProtobuf(privSets);
        }
        if (user.business_account_info != null) {
            BusinessAccountData businessAccountData = new BusinessAccountData();
            this.businessAccountData = businessAccountData;
            businessAccountData.parseProto(user.business_account_info);
            TbSingleton.getInstance().setBusinessAccount(this.businessAccountData.isBusinessAccount);
        }
        if (!StringUtils.isNull(user.appeal_thread_popover)) {
            this.appealThreadPopover = user.appeal_thread_popover;
        }
        List<ForumToolPerm> list4 = user.forum_tool_auth;
        this.forumToolAuth.clear();
        if (list4 != null && list4.size() > 0) {
            this.forumToolAuth.addAll(list4);
        }
        String str2 = user.tieba_uid;
        if (str2 != null) {
            this.tiebaUid = str2;
        }
        this.managerForum.clear();
        List<BazhuSign> list5 = user.manager_forum;
        if (list5 != null) {
            for (BazhuSign bazhuSign2 : list5) {
                BazhuGradeData bazhuGradeData = new BazhuGradeData();
                bazhuGradeData.parserProtobuf(bazhuSign2);
                this.managerForum.add(bazhuGradeData);
            }
        }
        this.authType = user.display_auth_type.intValue();
        if (user.work_creator_info != null) {
            WorkCreateAutherData workCreateAutherData = new WorkCreateAutherData();
            this.creatorInfo = workCreateAutherData;
            workCreateAutherData.parseProto(user.work_creator_info);
        }
        this.ipAddress = user.ip_address;
    }

    public void setAuthDesc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, str) == null) {
            this.authDesc = str;
        }
    }

    public void setAuthType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048661, this, i) == null) {
            this.authType = i;
        }
    }

    public void setBaijiahaoInfo(BaijiahaoInfo baijiahaoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, baijiahaoInfo) == null) {
            this.baijiahaoInfo = baijiahaoInfo;
        }
    }

    public void setBazhuDesc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, str) == null) {
            this.bazhuDesc = str;
        }
    }

    public void setBazhuGradeData(BazhuGradeData bazhuGradeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, bazhuGradeData) == null) {
            this.mBazhuGrade = bazhuGradeData;
        }
    }

    public void setBazhuLevel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, str) == null) {
            this.bazhuLevel = str;
        }
    }

    public void setBazhuShowOutside(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048666, this, i) == null) {
            this.bazhuShowOutside = i;
        }
    }

    public void setBusinessAccountData(BusinessAccountData businessAccountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, businessAccountData) == null) {
            this.businessAccountData = businessAccountData;
        }
    }

    public void setConcern_num(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048668, this, i) == null) {
            this.concernNum = i;
        }
    }

    public void setCreatorInfo(WorkCreateAutherData workCreateAutherData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, workCreateAutherData) == null) {
            this.creatorInfo = workCreateAutherData;
        }
    }

    public void setFansNickName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, str) == null) {
            this.fansNickName = str;
        }
    }

    @Override // com.repackage.ou4
    public void setFansNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048671, this, i) == null) {
            this.fansNum = i;
        }
    }

    public void setForumToolAuth(List<ForumToolPerm> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, list) == null) {
            this.forumToolAuth = list;
        }
    }

    public void setGender(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048673, this, i) == null) {
            this.gender = i;
        }
    }

    public void setGiftNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048674, this, i) == null) {
            this.giftNum = i;
        }
    }

    @Deprecated
    public void setGodInfo(GodInfo godInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, godInfo) == null) {
            this.godInfo = godInfo;
        }
    }

    public void setGodIntor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, str) == null) {
            this.god_intro = str;
        }
    }

    public void setGodStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048677, this, i) == null) {
            this.godStatus = i;
        }
    }

    public void setGodUserData(GodUserData godUserData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, godUserData) == null) {
            this.godUserData = godUserData;
        }
    }

    public void setHadConcerned(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048679, this, z) == null) {
            this.mHadConcerned = z;
            setIsLike(z);
        }
    }

    public void setIconInfo(ArrayList<IconData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, arrayList) == null) {
            this.mIconInfo = arrayList;
        }
    }

    public void setImBjhAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, str) == null) {
        }
    }

    public void setIsBaZhu(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048682, this, i) == null) {
            this.is_bazhu = i;
        }
    }

    public void setIsBigV(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048683, this, z) == null) {
            this.isBigV = z;
        }
    }

    public void setIsBusinessAccount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048684, this, i) == null) {
            this.isBusinessAccount = i;
        }
    }

    public void setIsFollower(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048685, this, i) == null) {
            this.is_follower = i;
        }
    }

    @Override // com.repackage.ou4
    public void setIsFromNetWork(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048686, this, z) == null) {
            this.isLikeStatusFromNet = z;
            GodUserData godUserData = this.godUserData;
            if (godUserData != null) {
                godUserData.setIsFromNetWork(z);
            }
        }
    }

    public void setIsGod(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048687, this, z) == null) {
            this.isGod = z;
        }
    }

    public void setIsGodUser(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048688, this, i) == null) {
            this.is_god_user = i;
        }
    }

    public void setIsLike(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048689, this, z) == null) {
            this.is_like = z ? 1 : 0;
            this.mHadConcerned = z;
            if (isGod()) {
                this.godUserData.setIsLike(z);
            }
        }
    }

    public void setIsManager(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048690, this, i) == null) {
            this.is_manager = i;
        }
    }

    public void setIsMyFollower(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048691, this, i) == null) {
            this.is_my_follower = i;
        }
    }

    public void setIsMyFriend(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048692, this, i) == null) {
            this.is_myfriend = i;
        }
    }

    public void setIsNearlyAt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048693, this, i) == null) {
            this.is_nearlyAt = i;
        }
    }

    public void setIsOriginalAuthor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048694, this, i) == null) {
            this.isOriginalAuthor = i;
        }
    }

    public void setLeft_call_num(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048695, this, i) == null) {
            this.left_call_num = i;
        }
    }

    public void setLevel_id(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048696, this, i) == null) {
            this.level_id = i;
        }
    }

    public void setLikeNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048697, this, i) == null) {
            this.likeNum = i;
        }
    }

    @Override // com.repackage.ou4
    public void setLikeStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048698, this, i) == null) {
            this.likeStatus = i;
        }
    }

    public void setName_show(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, str) == null) {
            this.name_show = str;
        }
    }

    public void setNewGodData(NewGodData newGodData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048700, this, newGodData) == null) {
            this.mNewGodData = newGodData;
        }
    }

    public void setPendantData(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048701, this, userPendantData) == null) {
            this.pendantData = userPendantData;
        }
    }

    public void setPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048702, this, str) == null) {
            this.portrait = str;
        }
    }

    public void setPortraitH(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048703, this, str) == null) {
            this.portraith = str;
        }
    }

    public void setPrivSetsData(PrivSetsData privSetsData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048704, this, privSetsData) == null) {
            this.privSetsData = privSetsData;
        }
    }

    public void setSealPrefix(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, str) == null) {
            this.sealPrefix = str;
        }
    }

    public void setTShowInfo(ArrayList<IconData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, arrayList) == null) {
            this.mTShowIconInfo = arrayList;
        }
    }

    public void setTbVipInfoData(UserTbVipInfoData userTbVipInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048707, this, userTbVipInfoData) == null) {
            this.bigVData = userTbVipInfoData;
        }
    }

    public void setThreadNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048708, this, i) == null) {
            this.threadNum = i;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048709, this, i) == null) {
            this.type = i;
        }
    }

    public void setUk(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, str) == null) {
            this.uk = str;
        }
    }

    public void setUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, str) == null) {
            this.userId = str;
        }
    }

    public void setUserIdLong(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048712, this, j) == null) {
            this.userId = String.valueOf(j);
        }
    }

    public void setUserName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, str) == null) {
            this.userName = str;
        }
    }

    public void setVirtualUserUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, str) == null) {
            this.virtualUserUrl = str;
        }
    }

    public void setmRelation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048715, this, i) == null) {
            this.mRelation = i;
        }
    }

    public boolean showBazhuGrade() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) {
            BazhuGradeData bazhuGradeData = this.mBazhuGrade;
            if (bazhuGradeData == null || ki.isEmpty(bazhuGradeData.getDesc())) {
                return false;
            }
            return (this.is_bawu == 1 && "manager".equals(this.bawu_type)) ? this.privSetsData.getBazhuShowInside() != 3 : this.privSetsData.getBazhuShowOutside() != 3;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0178 A[Catch: Exception -> 0x031f, TryCatch #0 {Exception -> 0x031f, blocks: (B:7:0x0009, B:9:0x009c, B:11:0x00a4, B:12:0x00a7, B:16:0x00c3, B:23:0x00fc, B:26:0x0122, B:28:0x0128, B:31:0x013f, B:33:0x0145, B:36:0x015c, B:38:0x0162, B:40:0x0178, B:42:0x018f, B:43:0x0194, B:45:0x019c, B:46:0x01a1, B:48:0x01cb, B:50:0x01d9, B:52:0x01df, B:53:0x01e1, B:55:0x01f1, B:56:0x022e, B:58:0x0236, B:59:0x023b, B:61:0x0243, B:62:0x0248, B:64:0x0250, B:65:0x0255, B:69:0x0267, B:71:0x0279, B:72:0x028e, B:75:0x02a4, B:77:0x02aa, B:78:0x02cd, B:80:0x02e2, B:82:0x02e8, B:83:0x02fc, B:85:0x030c, B:86:0x0316), top: B:94:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x018f A[Catch: Exception -> 0x031f, TryCatch #0 {Exception -> 0x031f, blocks: (B:7:0x0009, B:9:0x009c, B:11:0x00a4, B:12:0x00a7, B:16:0x00c3, B:23:0x00fc, B:26:0x0122, B:28:0x0128, B:31:0x013f, B:33:0x0145, B:36:0x015c, B:38:0x0162, B:40:0x0178, B:42:0x018f, B:43:0x0194, B:45:0x019c, B:46:0x01a1, B:48:0x01cb, B:50:0x01d9, B:52:0x01df, B:53:0x01e1, B:55:0x01f1, B:56:0x022e, B:58:0x0236, B:59:0x023b, B:61:0x0243, B:62:0x0248, B:64:0x0250, B:65:0x0255, B:69:0x0267, B:71:0x0279, B:72:0x028e, B:75:0x02a4, B:77:0x02aa, B:78:0x02cd, B:80:0x02e2, B:82:0x02e8, B:83:0x02fc, B:85:0x030c, B:86:0x0316), top: B:94:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x019c A[Catch: Exception -> 0x031f, TryCatch #0 {Exception -> 0x031f, blocks: (B:7:0x0009, B:9:0x009c, B:11:0x00a4, B:12:0x00a7, B:16:0x00c3, B:23:0x00fc, B:26:0x0122, B:28:0x0128, B:31:0x013f, B:33:0x0145, B:36:0x015c, B:38:0x0162, B:40:0x0178, B:42:0x018f, B:43:0x0194, B:45:0x019c, B:46:0x01a1, B:48:0x01cb, B:50:0x01d9, B:52:0x01df, B:53:0x01e1, B:55:0x01f1, B:56:0x022e, B:58:0x0236, B:59:0x023b, B:61:0x0243, B:62:0x0248, B:64:0x0250, B:65:0x0255, B:69:0x0267, B:71:0x0279, B:72:0x028e, B:75:0x02a4, B:77:0x02aa, B:78:0x02cd, B:80:0x02e2, B:82:0x02e8, B:83:0x02fc, B:85:0x030c, B:86:0x0316), top: B:94:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01cb A[Catch: Exception -> 0x031f, TryCatch #0 {Exception -> 0x031f, blocks: (B:7:0x0009, B:9:0x009c, B:11:0x00a4, B:12:0x00a7, B:16:0x00c3, B:23:0x00fc, B:26:0x0122, B:28:0x0128, B:31:0x013f, B:33:0x0145, B:36:0x015c, B:38:0x0162, B:40:0x0178, B:42:0x018f, B:43:0x0194, B:45:0x019c, B:46:0x01a1, B:48:0x01cb, B:50:0x01d9, B:52:0x01df, B:53:0x01e1, B:55:0x01f1, B:56:0x022e, B:58:0x0236, B:59:0x023b, B:61:0x0243, B:62:0x0248, B:64:0x0250, B:65:0x0255, B:69:0x0267, B:71:0x0279, B:72:0x028e, B:75:0x02a4, B:77:0x02aa, B:78:0x02cd, B:80:0x02e2, B:82:0x02e8, B:83:0x02fc, B:85:0x030c, B:86:0x0316), top: B:94:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01f1 A[Catch: Exception -> 0x031f, TryCatch #0 {Exception -> 0x031f, blocks: (B:7:0x0009, B:9:0x009c, B:11:0x00a4, B:12:0x00a7, B:16:0x00c3, B:23:0x00fc, B:26:0x0122, B:28:0x0128, B:31:0x013f, B:33:0x0145, B:36:0x015c, B:38:0x0162, B:40:0x0178, B:42:0x018f, B:43:0x0194, B:45:0x019c, B:46:0x01a1, B:48:0x01cb, B:50:0x01d9, B:52:0x01df, B:53:0x01e1, B:55:0x01f1, B:56:0x022e, B:58:0x0236, B:59:0x023b, B:61:0x0243, B:62:0x0248, B:64:0x0250, B:65:0x0255, B:69:0x0267, B:71:0x0279, B:72:0x028e, B:75:0x02a4, B:77:0x02aa, B:78:0x02cd, B:80:0x02e2, B:82:0x02e8, B:83:0x02fc, B:85:0x030c, B:86:0x0316), top: B:94:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0236 A[Catch: Exception -> 0x031f, TryCatch #0 {Exception -> 0x031f, blocks: (B:7:0x0009, B:9:0x009c, B:11:0x00a4, B:12:0x00a7, B:16:0x00c3, B:23:0x00fc, B:26:0x0122, B:28:0x0128, B:31:0x013f, B:33:0x0145, B:36:0x015c, B:38:0x0162, B:40:0x0178, B:42:0x018f, B:43:0x0194, B:45:0x019c, B:46:0x01a1, B:48:0x01cb, B:50:0x01d9, B:52:0x01df, B:53:0x01e1, B:55:0x01f1, B:56:0x022e, B:58:0x0236, B:59:0x023b, B:61:0x0243, B:62:0x0248, B:64:0x0250, B:65:0x0255, B:69:0x0267, B:71:0x0279, B:72:0x028e, B:75:0x02a4, B:77:0x02aa, B:78:0x02cd, B:80:0x02e2, B:82:0x02e8, B:83:0x02fc, B:85:0x030c, B:86:0x0316), top: B:94:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0243 A[Catch: Exception -> 0x031f, TryCatch #0 {Exception -> 0x031f, blocks: (B:7:0x0009, B:9:0x009c, B:11:0x00a4, B:12:0x00a7, B:16:0x00c3, B:23:0x00fc, B:26:0x0122, B:28:0x0128, B:31:0x013f, B:33:0x0145, B:36:0x015c, B:38:0x0162, B:40:0x0178, B:42:0x018f, B:43:0x0194, B:45:0x019c, B:46:0x01a1, B:48:0x01cb, B:50:0x01d9, B:52:0x01df, B:53:0x01e1, B:55:0x01f1, B:56:0x022e, B:58:0x0236, B:59:0x023b, B:61:0x0243, B:62:0x0248, B:64:0x0250, B:65:0x0255, B:69:0x0267, B:71:0x0279, B:72:0x028e, B:75:0x02a4, B:77:0x02aa, B:78:0x02cd, B:80:0x02e2, B:82:0x02e8, B:83:0x02fc, B:85:0x030c, B:86:0x0316), top: B:94:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0250 A[Catch: Exception -> 0x031f, TryCatch #0 {Exception -> 0x031f, blocks: (B:7:0x0009, B:9:0x009c, B:11:0x00a4, B:12:0x00a7, B:16:0x00c3, B:23:0x00fc, B:26:0x0122, B:28:0x0128, B:31:0x013f, B:33:0x0145, B:36:0x015c, B:38:0x0162, B:40:0x0178, B:42:0x018f, B:43:0x0194, B:45:0x019c, B:46:0x01a1, B:48:0x01cb, B:50:0x01d9, B:52:0x01df, B:53:0x01e1, B:55:0x01f1, B:56:0x022e, B:58:0x0236, B:59:0x023b, B:61:0x0243, B:62:0x0248, B:64:0x0250, B:65:0x0255, B:69:0x0267, B:71:0x0279, B:72:0x028e, B:75:0x02a4, B:77:0x02aa, B:78:0x02cd, B:80:0x02e2, B:82:0x02e8, B:83:0x02fc, B:85:0x030c, B:86:0x0316), top: B:94:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0279 A[Catch: Exception -> 0x031f, TryCatch #0 {Exception -> 0x031f, blocks: (B:7:0x0009, B:9:0x009c, B:11:0x00a4, B:12:0x00a7, B:16:0x00c3, B:23:0x00fc, B:26:0x0122, B:28:0x0128, B:31:0x013f, B:33:0x0145, B:36:0x015c, B:38:0x0162, B:40:0x0178, B:42:0x018f, B:43:0x0194, B:45:0x019c, B:46:0x01a1, B:48:0x01cb, B:50:0x01d9, B:52:0x01df, B:53:0x01e1, B:55:0x01f1, B:56:0x022e, B:58:0x0236, B:59:0x023b, B:61:0x0243, B:62:0x0248, B:64:0x0250, B:65:0x0255, B:69:0x0267, B:71:0x0279, B:72:0x028e, B:75:0x02a4, B:77:0x02aa, B:78:0x02cd, B:80:0x02e2, B:82:0x02e8, B:83:0x02fc, B:85:0x030c, B:86:0x0316), top: B:94:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02e2 A[Catch: Exception -> 0x031f, LOOP:4: B:80:0x02e2->B:82:0x02e8, LOOP_START, PHI: r2 
      PHI: (r2v1 int) = (r2v0 int), (r2v2 int) binds: [B:79:0x02e0, B:82:0x02e8] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x031f, blocks: (B:7:0x0009, B:9:0x009c, B:11:0x00a4, B:12:0x00a7, B:16:0x00c3, B:23:0x00fc, B:26:0x0122, B:28:0x0128, B:31:0x013f, B:33:0x0145, B:36:0x015c, B:38:0x0162, B:40:0x0178, B:42:0x018f, B:43:0x0194, B:45:0x019c, B:46:0x01a1, B:48:0x01cb, B:50:0x01d9, B:52:0x01df, B:53:0x01e1, B:55:0x01f1, B:56:0x022e, B:58:0x0236, B:59:0x023b, B:61:0x0243, B:62:0x0248, B:64:0x0250, B:65:0x0255, B:69:0x0267, B:71:0x0279, B:72:0x028e, B:75:0x02a4, B:77:0x02aa, B:78:0x02cd, B:80:0x02e2, B:82:0x02e8, B:83:0x02fc, B:85:0x030c, B:86:0x0316), top: B:94:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x030c A[Catch: Exception -> 0x031f, TryCatch #0 {Exception -> 0x031f, blocks: (B:7:0x0009, B:9:0x009c, B:11:0x00a4, B:12:0x00a7, B:16:0x00c3, B:23:0x00fc, B:26:0x0122, B:28:0x0128, B:31:0x013f, B:33:0x0145, B:36:0x015c, B:38:0x0162, B:40:0x0178, B:42:0x018f, B:43:0x0194, B:45:0x019c, B:46:0x01a1, B:48:0x01cb, B:50:0x01d9, B:52:0x01df, B:53:0x01e1, B:55:0x01f1, B:56:0x022e, B:58:0x0236, B:59:0x023b, B:61:0x0243, B:62:0x0248, B:64:0x0250, B:65:0x0255, B:69:0x0267, B:71:0x0279, B:72:0x028e, B:75:0x02a4, B:77:0x02aa, B:78:0x02cd, B:80:0x02e2, B:82:0x02e8, B:83:0x02fc, B:85:0x030c, B:86:0x0316), top: B:94:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parserJson(JSONObject jSONObject) {
        boolean z;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        JSONArray optJSONArray3;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        JSONObject optJSONObject5;
        JSONObject optJSONObject6;
        JSONObject optJSONObject7;
        JSONObject optJSONObject8;
        JSONObject optJSONObject9;
        JSONArray optJSONArray4;
        JSONArray optJSONArray5;
        JSONObject optJSONObject10;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048658, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.userId = jSONObject.optString("id");
            this.gender = jSONObject.optInt("gender", 0);
            this.type = jSONObject.optInt("type", 0);
            this.userName = jSONObject.optString("name");
            this.uk = jSONObject.optString("uk");
            this.level_id = jSONObject.optInt("level_id", 0);
            this.is_like = jSONObject.optInt("is_like", 0);
            this.is_bawu = jSONObject.optInt("is_bawu", 0);
            this.is_manager = jSONObject.optInt("is_manager", 0);
            this.isMem = jSONObject.optInt(GroupLevelActivityConfig.IS_MEM, 0);
            this.bawu_type = jSONObject.optString("bawu_type");
            this.is_myfriend = jSONObject.optInt("is_friend");
            this.is_myfans = jSONObject.optInt("is_fans");
            this.is_follower = jSONObject.optInt("is_double_concern");
            this.is_my_follower = jSONObject.optInt("is_my_concern");
            this.is_nearlyAt = jSONObject.optInt("is_at");
            this.is_bazhu = jSONObject.optInt(NativeEmotionManagerActivityConfig.KEY);
            this.is_god_user = jSONObject.optInt("is_god");
            if (this.userName != null && this.userName.length() <= 0) {
                this.userName = null;
            }
            this.name_show = jSONObject.optString("name_show");
            this.nickNameInVerifying = jSONObject.optString("editing_nickname");
            boolean z2 = true;
            this.isNickNameInVerifying = jSONObject.optInt("is_nickname_editing", 0) == 1;
            this.portrait = jSONObject.optString("portrait");
            this.portraith = jSONObject.optString("portraith");
            this.fansNum = jSONObject.optInt(PersonInfoActivityConfig.FANS_NUM);
            this.likeNum = jSONObject.optInt("my_like_num");
            this.threadNum = jSONObject.optInt("post_num");
            int optInt = jSONObject.optInt("has_concerned");
            if (optInt != 1 && optInt != 2) {
                z = false;
                this.mHadConcerned = z;
                setLikeStatus(optInt);
                optJSONArray = jSONObject.optJSONArray("iconinfo");
                optJSONArray2 = jSONObject.optJSONArray("tshow_icon");
                optJSONArray3 = jSONObject.optJSONArray("new_tshow_icon");
                optJSONObject = jSONObject.optJSONObject("god_data");
                optJSONObject2 = jSONObject.optJSONObject("tb_vip");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        IconData iconData = new IconData();
                        iconData.parserJson(optJSONArray.getJSONObject(i));
                        this.mIconInfo.add(iconData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        IconData iconData2 = new IconData();
                        iconData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.mTShowIconInfo.add(iconData2);
                    }
                }
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        IconData iconData3 = new IconData();
                        iconData3.parserJson(optJSONArray3.getJSONObject(i3));
                        this.mTShowIconInfoNew.add(iconData3);
                    }
                }
                if (optJSONObject != null) {
                    this.godUserData.parseJson(optJSONObject);
                    this.isGod = this.godUserData.isGod();
                    this.isBigV = this.godUserData.isBigV();
                }
                if (optJSONObject2 != null) {
                    this.bigVData.parseJson(optJSONObject2);
                }
                optJSONObject3 = jSONObject.optJSONObject("theme_card");
                if (optJSONObject3 != null) {
                    this.themeCard.parser(optJSONObject3);
                }
                this.isLikeStatusFromNet = true;
                AlaUserInfoData alaUserInfoData = new AlaUserInfoData();
                this.alaUserData = alaUserInfoData;
                alaUserInfoData.parserJson(jSONObject.optJSONObject("ala_info"));
                AlaInfoData alaInfoData = new AlaInfoData();
                this.alaInfo = alaInfoData;
                alaInfoData.parserJson(jSONObject.optJSONObject("ala_live_info"));
                optJSONObject4 = jSONObject.optJSONObject("spring_virtual_user");
                if (optJSONObject4 != null) {
                    int optInt2 = optJSONObject4.optInt("is_virtual");
                    String optString = optJSONObject4.optString("url");
                    if (optInt2 == 1 && !StringUtils.isNull(optString)) {
                        this.virtualUserUrl = optString;
                    }
                }
                this.left_call_num = jSONObject.optInt("left_call_num", 0);
                optJSONObject5 = jSONObject.optJSONObject("baijiahao_info");
                if (optJSONObject5 != null) {
                    BaijiahaoInfo.Builder builder = new BaijiahaoInfo.Builder();
                    builder.name = optJSONObject5.optString("name");
                    builder.avatar = optJSONObject5.optString("avatar");
                    builder.avatar_h = optJSONObject5.optString("avatar_h");
                    builder.brief = optJSONObject5.optString(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF);
                    builder.auth_id = Integer.valueOf(optJSONObject5.optInt("auth_id"));
                    builder.auth_desc = optJSONObject5.optString("auth_desc");
                    this.baijiahaoInfo = builder.build(false);
                }
                optJSONObject6 = jSONObject.optJSONObject("new_god_data");
                if (optJSONObject6 != null) {
                    this.mNewGodData.parserJson(optJSONObject6);
                }
                optJSONObject7 = jSONObject.optJSONObject("bazhu_grade");
                if (optJSONObject7 != null) {
                    this.mBazhuGrade.parserJson(optJSONObject7);
                }
                optJSONObject8 = jSONObject.optJSONObject("priv_sets");
                if (optJSONObject8 != null) {
                    this.privSetsData.parserJson(optJSONObject8);
                }
                this.isOriginalAuthor = jSONObject.optInt("is_original_author", 0);
                if (jSONObject.optInt("can_modify_avatar") == 0) {
                    z2 = false;
                }
                this.canModifyAvatar = z2;
                this.cantModifyAvatarDesc = jSONObject.optString("modify_avatar_desc");
                optJSONObject9 = jSONObject.optJSONObject("business_account_info");
                if (optJSONObject9 != null) {
                    BusinessAccountData businessAccountData = new BusinessAccountData();
                    this.businessAccountData = businessAccountData;
                    businessAccountData.parseJson(optJSONObject9);
                    TbSingleton.getInstance().setBusinessAccount(this.businessAccountData.isBusinessAccount);
                }
                this.appealThreadPopover = jSONObject.optString("appeal_thread_popover");
                this.forumToolAuth.clear();
                optJSONArray4 = jSONObject.optJSONArray("forum_tool_auth");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        ForumToolPerm.Builder builder2 = new ForumToolPerm.Builder();
                        builder2.perm = Long.valueOf(((JSONObject) optJSONArray4.get(i4)).optLong("perm"));
                        this.forumToolAuth.add(builder2.build(false));
                    }
                }
                this.tiebaUid = jSONObject.optString("tieba_uid");
                this.managerForum.clear();
                optJSONArray5 = jSONObject.optJSONArray("manager_forum");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        JSONObject optJSONObject11 = optJSONArray5.optJSONObject(i5);
                        BazhuGradeData bazhuGradeData = new BazhuGradeData();
                        bazhuGradeData.parserJson(optJSONObject11);
                        this.managerForum.add(bazhuGradeData);
                    }
                }
                this.authType = jSONObject.optInt("display_auth_type");
                optJSONObject10 = jSONObject.optJSONObject("work_creator_info");
                if (optJSONObject10 != null) {
                    WorkCreateAutherData workCreateAutherData = new WorkCreateAutherData();
                    this.creatorInfo = workCreateAutherData;
                    workCreateAutherData.parseJson(optJSONObject10);
                }
                this.mRelation = jSONObject.optInt("relation");
            }
            z = true;
            this.mHadConcerned = z;
            setLikeStatus(optInt);
            optJSONArray = jSONObject.optJSONArray("iconinfo");
            optJSONArray2 = jSONObject.optJSONArray("tshow_icon");
            optJSONArray3 = jSONObject.optJSONArray("new_tshow_icon");
            optJSONObject = jSONObject.optJSONObject("god_data");
            optJSONObject2 = jSONObject.optJSONObject("tb_vip");
            if (optJSONArray != null) {
            }
            if (optJSONArray2 != null) {
            }
            if (optJSONArray3 != null) {
            }
            if (optJSONObject != null) {
            }
            if (optJSONObject2 != null) {
            }
            optJSONObject3 = jSONObject.optJSONObject("theme_card");
            if (optJSONObject3 != null) {
            }
            this.isLikeStatusFromNet = true;
            AlaUserInfoData alaUserInfoData2 = new AlaUserInfoData();
            this.alaUserData = alaUserInfoData2;
            alaUserInfoData2.parserJson(jSONObject.optJSONObject("ala_info"));
            AlaInfoData alaInfoData2 = new AlaInfoData();
            this.alaInfo = alaInfoData2;
            alaInfoData2.parserJson(jSONObject.optJSONObject("ala_live_info"));
            optJSONObject4 = jSONObject.optJSONObject("spring_virtual_user");
            if (optJSONObject4 != null) {
            }
            this.left_call_num = jSONObject.optInt("left_call_num", 0);
            optJSONObject5 = jSONObject.optJSONObject("baijiahao_info");
            if (optJSONObject5 != null) {
            }
            optJSONObject6 = jSONObject.optJSONObject("new_god_data");
            if (optJSONObject6 != null) {
            }
            optJSONObject7 = jSONObject.optJSONObject("bazhu_grade");
            if (optJSONObject7 != null) {
            }
            optJSONObject8 = jSONObject.optJSONObject("priv_sets");
            if (optJSONObject8 != null) {
            }
            this.isOriginalAuthor = jSONObject.optInt("is_original_author", 0);
            if (jSONObject.optInt("can_modify_avatar") == 0) {
            }
            this.canModifyAvatar = z2;
            this.cantModifyAvatarDesc = jSONObject.optString("modify_avatar_desc");
            optJSONObject9 = jSONObject.optJSONObject("business_account_info");
            if (optJSONObject9 != null) {
            }
            this.appealThreadPopover = jSONObject.optString("appeal_thread_popover");
            this.forumToolAuth.clear();
            optJSONArray4 = jSONObject.optJSONArray("forum_tool_auth");
            if (optJSONArray4 != null) {
            }
            this.tiebaUid = jSONObject.optString("tieba_uid");
            this.managerForum.clear();
            optJSONArray5 = jSONObject.optJSONArray("manager_forum");
            if (optJSONArray5 != null) {
            }
            this.authType = jSONObject.optInt("display_auth_type");
            optJSONObject10 = jSONObject.optJSONObject("work_creator_info");
            if (optJSONObject10 != null) {
            }
            this.mRelation = jSONObject.optInt("relation");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
