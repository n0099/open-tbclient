package com.baidu.tbadk.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.IMUserExtraData;
import com.baidu.tbadk.core.data.SmallTailThemeData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.coreExtra.data.BazhuGradeData;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.coreExtra.data.PrivSetsData;
import com.baidu.tieba.e75;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.md5;
import com.baidu.tieba.pd5;
import com.baidu.tieba.rd;
import com.baidu.tieba.y5b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import tbclient.TagsInfo;
import tbclient.TbVipInfo;
import tbclient.ThemeColorInfo;
import tbclient.TshowInfo;
import tbclient.User;
/* loaded from: classes5.dex */
public class MetaData extends OrmObject implements Serializable, e75 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -2658065756886586092L;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaInfoData alaInfo;
    public AlaUserInfoData alaUserData;
    public String appealThreadPopover;
    public String authDesc;
    public int authType;
    public String avatarUrl;
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
    public String diplayIntro;
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
    public GroupInfoData groupData;
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
    public long lastUpdateTime;
    public int left_call_num;
    public int level_id;
    public String level_name;
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
    public List<String> pendants;
    public String portrait;
    public String portraith;
    public PrivSetsData privSetsData;
    public int rankInfluence;
    public String rankNum;
    public String sealPrefix;
    public SmallTailThemeData smallTailThemeData;
    public String tag;
    public String tagIcon;
    public ArrayList<TagsInfo> tags;
    public String targetScheme;
    public ThemeCardInUserData themeCard;
    public int threadNum;
    public String tiebaUid;
    public int type;
    public String uk;
    public md5 userGrowthData;
    public String userId;
    public String userName;
    public pd5 userWorldCupData;
    public String virtualUserUrl;

    public void setImBjhAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, str) == null) {
        }
    }

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
        this.diplayIntro = null;
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
        this.avatarUrl = null;
        this.targetScheme = null;
        this.tags = new ArrayList<>();
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
        this.userGrowthData = null;
        this.diplayIntro = null;
        this.groupData = null;
        this.lastUpdateTime = 0L;
        this.tag = null;
        this.tagIcon = null;
    }

    public boolean canModifyAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.canModifyAvatar;
        }
        return invokeV.booleanValue;
    }

    public AlaInfoData getAlaInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.alaInfo;
        }
        return (AlaInfoData) invokeV.objValue;
    }

    public AlaUserInfoData getAlaUserData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.alaUserData;
        }
        return (AlaUserInfoData) invokeV.objValue;
    }

    public String getAppealThreadPopover() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.appealThreadPopover;
        }
        return (String) invokeV.objValue;
    }

    public String getAuthDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.authDesc;
        }
        return (String) invokeV.objValue;
    }

    public int getAuthType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.authType;
        }
        return invokeV.intValue;
    }

    public String getAvatarH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.portraith;
        }
        return (String) invokeV.objValue;
    }

    public String getAvatarUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.avatarUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getAvater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.portrait;
        }
        return (String) invokeV.objValue;
    }

    public BaijiahaoInfo getBaijiahaoInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.baijiahaoInfo;
        }
        return (BaijiahaoInfo) invokeV.objValue;
    }

    public String getBawu_type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.bawu_type;
        }
        return (String) invokeV.objValue;
    }

    public BazhuGradeData getBazhuGradeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mBazhuGrade;
        }
        return (BazhuGradeData) invokeV.objValue;
    }

    public String getBazhuLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.bazhuLevel;
        }
        return (String) invokeV.objValue;
    }

    public int getBazhuShowOutside() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.bazhuShowOutside;
        }
        return invokeV.intValue;
    }

    public BusinessAccountData getBusinessAccountData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.businessAccountData;
        }
        return (BusinessAccountData) invokeV.objValue;
    }

    public String getCantModifyAvatarDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.cantModifyAvatarDesc;
        }
        return (String) invokeV.objValue;
    }

    public int getConcernNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.concernNum;
        }
        return invokeV.intValue;
    }

    public int getConcern_num() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.concernNum;
        }
        return invokeV.intValue;
    }

    public WorkCreateAutherData getCreatorInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.creatorInfo;
        }
        return (WorkCreateAutherData) invokeV.objValue;
    }

    public String getDiplayIntro() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.diplayIntro;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e75
    public int getFansNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.fansNum;
        }
        return invokeV.intValue;
    }

    public List<ForumToolPerm> getForumToolAuth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.forumToolAuth;
        }
        return (List) invokeV.objValue;
    }

    public String getGaokaoTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.tag;
        }
        return (String) invokeV.objValue;
    }

    public String getGaokaoTagIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.tagIcon;
        }
        return (String) invokeV.objValue;
    }

    public int getGender() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.gender;
        }
        return invokeV.intValue;
    }

    public int getGiftNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.giftNum;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public GodInfo getGodInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.godInfo;
        }
        return (GodInfo) invokeV.objValue;
    }

    public String getGodIntro() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.god_intro;
        }
        return (String) invokeV.objValue;
    }

    public int getGodStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.godStatus;
        }
        return invokeV.intValue;
    }

    public GodUserData getGodUserData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.godUserData;
        }
        return (GodUserData) invokeV.objValue;
    }

    public ArrayList<IconData> getIconInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.mIconInfo;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String getImBjhAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.imBjhAvatar;
        }
        return (String) invokeV.objValue;
    }

    public String getIpAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.ipAddress;
        }
        return (String) invokeV.objValue;
    }

    public int getIsBaZhu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.is_bazhu;
        }
        return invokeV.intValue;
    }

    public int getIsBussinessAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.isBusinessAccount;
        }
        return invokeV.intValue;
    }

    public int getIsFollower() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.is_follower;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.e75
    public boolean getIsLike() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (isGod()) {
                if (!this.godUserData.getIsLike() && !this.mHadConcerned) {
                    return false;
                }
                return true;
            } else if (this.is_like != 1 && !this.mHadConcerned) {
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public int getIsMem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.isMem;
        }
        return invokeV.intValue;
    }

    public int getIsMyFans() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.is_myfans;
        }
        return invokeV.intValue;
    }

    public int getIsMyFollower() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.is_my_follower;
        }
        return invokeV.intValue;
    }

    public int getIsMyFriend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.is_myfriend;
        }
        return invokeV.intValue;
    }

    public int getIsNearlyAt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.is_nearlyAt;
        }
        return invokeV.intValue;
    }

    public int getIsOriginalAuthor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.isOriginalAuthor;
        }
        return invokeV.intValue;
    }

    public int getIs_bawu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.is_bawu;
        }
        return invokeV.intValue;
    }

    public int getIs_manager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.is_manager;
        }
        return invokeV.intValue;
    }

    public String getLevelName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.level_name;
        }
        return (String) invokeV.objValue;
    }

    public int getLevel_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.level_id;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.e75
    public int getLikeStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.likeStatus;
        }
        return invokeV.intValue;
    }

    public LiveRoomInfo getLiveRoomInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.liveRoomInfo;
        }
        return (LiveRoomInfo) invokeV.objValue;
    }

    public List<BazhuGradeData> getManagerForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.managerForum;
        }
        return (List) invokeV.objValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.mNewGodData;
        }
        return (NewGodData) invokeV.objValue;
    }

    public UserPendantData getPendantData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.pendantData;
        }
        return (UserPendantData) invokeV.objValue;
    }

    public List<String> getPendants() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.pendants;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e75
    public String getPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.portrait;
        }
        return (String) invokeV.objValue;
    }

    public String getPortraitH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.portraith;
        }
        return (String) invokeV.objValue;
    }

    public PrivSetsData getPrivSetsData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.privSetsData;
        }
        return (PrivSetsData) invokeV.objValue;
    }

    public String getSealPrefix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.sealPrefix;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public SmallTailThemeData getSmallTailThemeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.smallTailThemeData;
        }
        return (SmallTailThemeData) invokeV.objValue;
    }

    public ArrayList<IconData> getTShowInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.mTShowIconInfo;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ArrayList<IconData> getTShowInfoNew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.mTShowIconInfoNew;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ArrayList<TagsInfo> getTags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.tags;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String getTargetScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.targetScheme;
        }
        return (String) invokeV.objValue;
    }

    public ThemeCardInUserData getThemeCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.themeCard;
        }
        return (ThemeCardInUserData) invokeV.objValue;
    }

    public int getThreadNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.threadNum;
        }
        return invokeV.intValue;
    }

    public String getTiebaUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.tiebaUid;
        }
        return (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }

    public String getUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.uk;
        }
        return (String) invokeV.objValue;
    }

    public md5 getUserGrowthData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.userGrowthData;
        }
        return (md5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e75
    public String getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.userId;
        }
        return (String) invokeV.objValue;
    }

    public long getUserIdLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return JavaTypesHelper.toLong(this.userId, 0L);
        }
        return invokeV.longValue;
    }

    public String getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            String str = this.userName;
            if (str != null && str.length() > 0) {
                return this.userName;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public UserTbVipInfoData getUserTbVipInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.bigVData;
        }
        return (UserTbVipInfoData) invokeV.objValue;
    }

    public pd5 getUserWorldCupData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.userWorldCupData;
        }
        return (pd5) invokeV.objValue;
    }

    public String getVirtualUserUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return this.virtualUserUrl;
        }
        return (String) invokeV.objValue;
    }

    public int getmRelation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return this.mRelation;
        }
        return invokeV.intValue;
    }

    public boolean hadConcerned() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            if (this.mHadConcerned || this.is_like == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isBaijiahaoUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            BaijiahaoInfo baijiahaoInfo = this.baijiahaoInfo;
            if (baijiahaoInfo != null && baijiahaoInfo.auth_id.intValue() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isBigV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.isBigV;
        }
        return invokeV.booleanValue;
    }

    public boolean isForumBusinessAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            BusinessAccountData businessAccountData = this.businessAccountData;
            if (businessAccountData != null && businessAccountData.isForumBusinessAccount) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.e75
    public boolean isGod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return this.isGod;
        }
        return invokeV.booleanValue;
    }

    public boolean isNewGod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            NewGodData newGodData = this.mNewGodData;
            if (newGodData != null && newGodData.isNewGod()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isOfficial() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            BusinessAccountData businessAccountData = this.businessAccountData;
            if (businessAccountData != null && businessAccountData.isBusinessAccount) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isOriginal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            WorkCreateAutherData workCreateAutherData = this.creatorInfo;
            if (workCreateAutherData != null && !TextUtils.isEmpty(workCreateAutherData.authDesc)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isVideoGod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            NewGodData newGodData = this.mNewGodData;
            if (newGodData != null && newGodData.isVideoGod()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void parseFromCurrentUser() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048661, this) != null) || TbadkCoreApplication.getCurrentAccountInfo() == null) {
            return;
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        this.userId = currentAccountInfo.getID();
        this.gender = currentAccountInfo.getSex();
        this.userName = currentAccountInfo.getAccount();
        this.name_show = currentAccountInfo.getAccountNameShow();
        this.portrait = currentAccountInfo.getPortrait();
    }

    public boolean showBazhuGrade() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) {
            BazhuGradeData bazhuGradeData = this.mBazhuGrade;
            if (bazhuGradeData == null || rd.isEmpty(bazhuGradeData.getDesc())) {
                return false;
            }
            if (this.is_bawu == 1 && "manager".equals(this.bawu_type)) {
                if (this.privSetsData.getBazhuShowInside() == 3) {
                    return false;
                }
                return true;
            } else if (this.privSetsData.getBazhuShowOutside() == 3) {
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void parserJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, str) == null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void setAlaInfo(AlaInfoData alaInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, alaInfoData) == null) {
            this.alaInfo = alaInfoData;
        }
    }

    public void setAuthDesc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, str) == null) {
            this.authDesc = str;
        }
    }

    public void setAuthType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048667, this, i) == null) {
            this.authType = i;
        }
    }

    public void setBaijiahaoInfo(BaijiahaoInfo baijiahaoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, baijiahaoInfo) == null) {
            this.baijiahaoInfo = baijiahaoInfo;
        }
    }

    public void setBazhuDesc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, str) == null) {
            this.bazhuDesc = str;
        }
    }

    public void setBazhuGradeData(BazhuGradeData bazhuGradeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, bazhuGradeData) == null) {
            this.mBazhuGrade = bazhuGradeData;
        }
    }

    public void setBazhuLevel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, str) == null) {
            this.bazhuLevel = str;
        }
    }

    public void setBazhuShowOutside(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048672, this, i) == null) {
            this.bazhuShowOutside = i;
        }
    }

    public void setBusinessAccountData(BusinessAccountData businessAccountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, businessAccountData) == null) {
            this.businessAccountData = businessAccountData;
        }
    }

    public void setConcern_num(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048674, this, i) == null) {
            this.concernNum = i;
        }
    }

    public void setCreatorInfo(WorkCreateAutherData workCreateAutherData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, workCreateAutherData) == null) {
            this.creatorInfo = workCreateAutherData;
        }
    }

    public void setDiplayIntro(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, str) == null) {
            this.diplayIntro = str;
        }
    }

    @Override // com.baidu.tieba.e75
    public void setFansNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048677, this, i) == null) {
            this.fansNum = i;
        }
    }

    public void setForumToolAuth(List<ForumToolPerm> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, list) == null) {
            this.forumToolAuth = list;
        }
    }

    public void setGaokaoTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048679, this, str) == null) {
            this.tag = str;
        }
    }

    public void setGaokaoTagIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, str) == null) {
            this.tagIcon = str;
        }
    }

    public void setGender(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048681, this, i) == null) {
            this.gender = i;
        }
    }

    public void setGiftNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048682, this, i) == null) {
            this.giftNum = i;
        }
    }

    @Deprecated
    public void setGodInfo(GodInfo godInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, godInfo) == null) {
            this.godInfo = godInfo;
        }
    }

    public void setGodIntor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, str) == null) {
            this.god_intro = str;
        }
    }

    public void setGodStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048685, this, i) == null) {
            this.godStatus = i;
        }
    }

    public void setGodUserData(GodUserData godUserData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048686, this, godUserData) == null) {
            this.godUserData = godUserData;
        }
    }

    public void setHadConcerned(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048687, this, z) == null) {
            this.mHadConcerned = z;
            setIsLike(z);
        }
    }

    public void setIconInfo(ArrayList<IconData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, arrayList) == null) {
            this.mIconInfo = arrayList;
        }
    }

    public void setIpAddress(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048690, this, str) == null) {
            this.ipAddress = str;
        }
    }

    public void setIsBaZhu(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048691, this, i) == null) {
            this.is_bazhu = i;
        }
    }

    public void setIsBigV(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048692, this, z) == null) {
            this.isBigV = z;
        }
    }

    public void setIsBusinessAccount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048693, this, i) == null) {
            this.isBusinessAccount = i;
        }
    }

    @Override // com.baidu.tieba.e75
    public void setIsFromNetWork(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048694, this, z) == null) {
            this.isLikeStatusFromNet = z;
            GodUserData godUserData = this.godUserData;
            if (godUserData != null) {
                godUserData.setIsFromNetWork(z);
            }
        }
    }

    public void setIsGod(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048695, this, z) == null) {
            this.isGod = z;
        }
    }

    public void setIsGodUser(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048696, this, i) == null) {
            this.is_god_user = i;
        }
    }

    public void setIsLike(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048697, this, z) == null) {
            this.is_like = z ? 1 : 0;
            this.mHadConcerned = z;
            if (isGod()) {
                this.godUserData.setIsLike(z);
            }
        }
    }

    public void setIsManager(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048698, this, i) == null) {
            this.is_manager = i;
        }
    }

    public void setIsMyFriend(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048699, this, i) == null) {
            this.is_myfriend = i;
        }
    }

    public void setIsOriginalAuthor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048700, this, i) == null) {
            this.isOriginalAuthor = i;
        }
    }

    public void setLevelName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048701, this, str) == null) {
            this.level_name = str;
        }
    }

    public void setLevel_id(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048702, this, i) == null) {
            this.level_id = i;
        }
    }

    @Override // com.baidu.tieba.e75
    public void setLikeStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048703, this, i) == null) {
            this.likeStatus = i;
        }
    }

    public void setName_show(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048704, this, str) == null) {
            this.name_show = str;
        }
    }

    public void setNewGodData(NewGodData newGodData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, newGodData) == null) {
            this.mNewGodData = newGodData;
        }
    }

    public void setPendantData(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, userPendantData) == null) {
            this.pendantData = userPendantData;
        }
    }

    public void setPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048707, this, str) == null) {
            this.portrait = str;
        }
    }

    public void setPortraitH(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, str) == null) {
            this.portraith = str;
        }
    }

    public void setPrivSetsData(PrivSetsData privSetsData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, privSetsData) == null) {
            this.privSetsData = privSetsData;
        }
    }

    public void setSealPrefix(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, str) == null) {
            this.sealPrefix = str;
        }
    }

    public void setTShowInfo(ArrayList<IconData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, arrayList) == null) {
            this.mTShowIconInfo = arrayList;
        }
    }

    public void setTbVipInfoData(UserTbVipInfoData userTbVipInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, userTbVipInfoData) == null) {
            this.bigVData = userTbVipInfoData;
        }
    }

    public void setThreadNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048713, this, i) == null) {
            this.threadNum = i;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048714, this, i) == null) {
            this.type = i;
        }
    }

    public void setUk(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, str) == null) {
            this.uk = str;
        }
    }

    public void setUserGrowthData(md5 md5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048716, this, md5Var) == null) {
            this.userGrowthData = md5Var;
        }
    }

    public void setUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, str) == null) {
            this.userId = str;
        }
    }

    public void setUserIdLong(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048718, this, j) == null) {
            this.userId = String.valueOf(j);
        }
    }

    public void setUserName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, str) == null) {
            this.userName = str;
        }
    }

    public void setVirtualUserUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, str) == null) {
            this.virtualUserUrl = str;
        }
    }

    public void setmRelation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048721, this, i) == null) {
            this.mRelation = i;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x03b2 A[Catch: Exception -> 0x041d, TryCatch #0 {Exception -> 0x041d, blocks: (B:7:0x0009, B:9:0x00b4, B:11:0x00bc, B:12:0x00bf, B:16:0x00db, B:23:0x0124, B:26:0x0150, B:28:0x0156, B:31:0x016d, B:33:0x0173, B:34:0x0187, B:36:0x018f, B:39:0x019c, B:41:0x01a2, B:42:0x01b6, B:44:0x01bf, B:45:0x01ca, B:47:0x01d0, B:51:0x01e6, B:50:0x01d7, B:53:0x01eb, B:55:0x0202, B:56:0x0207, B:58:0x020f, B:59:0x0214, B:61:0x023e, B:63:0x024c, B:65:0x0252, B:66:0x0254, B:68:0x0264, B:70:0x02a3, B:71:0x02a7, B:73:0x02af, B:74:0x02bc, B:76:0x02c4, B:77:0x02d9, B:79:0x02e1, B:80:0x02ee, B:84:0x0301, B:86:0x0313, B:88:0x032e, B:89:0x0331, B:90:0x0333, B:93:0x0349, B:95:0x034f, B:96:0x0372, B:99:0x0388, B:101:0x038e, B:102:0x03a2, B:104:0x03b2, B:105:0x03bc, B:107:0x03cc, B:108:0x03d6, B:110:0x03de, B:112:0x03ea, B:114:0x03f2, B:115:0x03fc, B:117:0x0404, B:118:0x040b, B:120:0x0411, B:111:0x03e6), top: B:128:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x03cc A[Catch: Exception -> 0x041d, TryCatch #0 {Exception -> 0x041d, blocks: (B:7:0x0009, B:9:0x00b4, B:11:0x00bc, B:12:0x00bf, B:16:0x00db, B:23:0x0124, B:26:0x0150, B:28:0x0156, B:31:0x016d, B:33:0x0173, B:34:0x0187, B:36:0x018f, B:39:0x019c, B:41:0x01a2, B:42:0x01b6, B:44:0x01bf, B:45:0x01ca, B:47:0x01d0, B:51:0x01e6, B:50:0x01d7, B:53:0x01eb, B:55:0x0202, B:56:0x0207, B:58:0x020f, B:59:0x0214, B:61:0x023e, B:63:0x024c, B:65:0x0252, B:66:0x0254, B:68:0x0264, B:70:0x02a3, B:71:0x02a7, B:73:0x02af, B:74:0x02bc, B:76:0x02c4, B:77:0x02d9, B:79:0x02e1, B:80:0x02ee, B:84:0x0301, B:86:0x0313, B:88:0x032e, B:89:0x0331, B:90:0x0333, B:93:0x0349, B:95:0x034f, B:96:0x0372, B:99:0x0388, B:101:0x038e, B:102:0x03a2, B:104:0x03b2, B:105:0x03bc, B:107:0x03cc, B:108:0x03d6, B:110:0x03de, B:112:0x03ea, B:114:0x03f2, B:115:0x03fc, B:117:0x0404, B:118:0x040b, B:120:0x0411, B:111:0x03e6), top: B:128:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03de A[Catch: Exception -> 0x041d, TryCatch #0 {Exception -> 0x041d, blocks: (B:7:0x0009, B:9:0x00b4, B:11:0x00bc, B:12:0x00bf, B:16:0x00db, B:23:0x0124, B:26:0x0150, B:28:0x0156, B:31:0x016d, B:33:0x0173, B:34:0x0187, B:36:0x018f, B:39:0x019c, B:41:0x01a2, B:42:0x01b6, B:44:0x01bf, B:45:0x01ca, B:47:0x01d0, B:51:0x01e6, B:50:0x01d7, B:53:0x01eb, B:55:0x0202, B:56:0x0207, B:58:0x020f, B:59:0x0214, B:61:0x023e, B:63:0x024c, B:65:0x0252, B:66:0x0254, B:68:0x0264, B:70:0x02a3, B:71:0x02a7, B:73:0x02af, B:74:0x02bc, B:76:0x02c4, B:77:0x02d9, B:79:0x02e1, B:80:0x02ee, B:84:0x0301, B:86:0x0313, B:88:0x032e, B:89:0x0331, B:90:0x0333, B:93:0x0349, B:95:0x034f, B:96:0x0372, B:99:0x0388, B:101:0x038e, B:102:0x03a2, B:104:0x03b2, B:105:0x03bc, B:107:0x03cc, B:108:0x03d6, B:110:0x03de, B:112:0x03ea, B:114:0x03f2, B:115:0x03fc, B:117:0x0404, B:118:0x040b, B:120:0x0411, B:111:0x03e6), top: B:128:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03e6 A[Catch: Exception -> 0x041d, TryCatch #0 {Exception -> 0x041d, blocks: (B:7:0x0009, B:9:0x00b4, B:11:0x00bc, B:12:0x00bf, B:16:0x00db, B:23:0x0124, B:26:0x0150, B:28:0x0156, B:31:0x016d, B:33:0x0173, B:34:0x0187, B:36:0x018f, B:39:0x019c, B:41:0x01a2, B:42:0x01b6, B:44:0x01bf, B:45:0x01ca, B:47:0x01d0, B:51:0x01e6, B:50:0x01d7, B:53:0x01eb, B:55:0x0202, B:56:0x0207, B:58:0x020f, B:59:0x0214, B:61:0x023e, B:63:0x024c, B:65:0x0252, B:66:0x0254, B:68:0x0264, B:70:0x02a3, B:71:0x02a7, B:73:0x02af, B:74:0x02bc, B:76:0x02c4, B:77:0x02d9, B:79:0x02e1, B:80:0x02ee, B:84:0x0301, B:86:0x0313, B:88:0x032e, B:89:0x0331, B:90:0x0333, B:93:0x0349, B:95:0x034f, B:96:0x0372, B:99:0x0388, B:101:0x038e, B:102:0x03a2, B:104:0x03b2, B:105:0x03bc, B:107:0x03cc, B:108:0x03d6, B:110:0x03de, B:112:0x03ea, B:114:0x03f2, B:115:0x03fc, B:117:0x0404, B:118:0x040b, B:120:0x0411, B:111:0x03e6), top: B:128:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03f2 A[Catch: Exception -> 0x041d, TryCatch #0 {Exception -> 0x041d, blocks: (B:7:0x0009, B:9:0x00b4, B:11:0x00bc, B:12:0x00bf, B:16:0x00db, B:23:0x0124, B:26:0x0150, B:28:0x0156, B:31:0x016d, B:33:0x0173, B:34:0x0187, B:36:0x018f, B:39:0x019c, B:41:0x01a2, B:42:0x01b6, B:44:0x01bf, B:45:0x01ca, B:47:0x01d0, B:51:0x01e6, B:50:0x01d7, B:53:0x01eb, B:55:0x0202, B:56:0x0207, B:58:0x020f, B:59:0x0214, B:61:0x023e, B:63:0x024c, B:65:0x0252, B:66:0x0254, B:68:0x0264, B:70:0x02a3, B:71:0x02a7, B:73:0x02af, B:74:0x02bc, B:76:0x02c4, B:77:0x02d9, B:79:0x02e1, B:80:0x02ee, B:84:0x0301, B:86:0x0313, B:88:0x032e, B:89:0x0331, B:90:0x0333, B:93:0x0349, B:95:0x034f, B:96:0x0372, B:99:0x0388, B:101:0x038e, B:102:0x03a2, B:104:0x03b2, B:105:0x03bc, B:107:0x03cc, B:108:0x03d6, B:110:0x03de, B:112:0x03ea, B:114:0x03f2, B:115:0x03fc, B:117:0x0404, B:118:0x040b, B:120:0x0411, B:111:0x03e6), top: B:128:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0404 A[Catch: Exception -> 0x041d, TryCatch #0 {Exception -> 0x041d, blocks: (B:7:0x0009, B:9:0x00b4, B:11:0x00bc, B:12:0x00bf, B:16:0x00db, B:23:0x0124, B:26:0x0150, B:28:0x0156, B:31:0x016d, B:33:0x0173, B:34:0x0187, B:36:0x018f, B:39:0x019c, B:41:0x01a2, B:42:0x01b6, B:44:0x01bf, B:45:0x01ca, B:47:0x01d0, B:51:0x01e6, B:50:0x01d7, B:53:0x01eb, B:55:0x0202, B:56:0x0207, B:58:0x020f, B:59:0x0214, B:61:0x023e, B:63:0x024c, B:65:0x0252, B:66:0x0254, B:68:0x0264, B:70:0x02a3, B:71:0x02a7, B:73:0x02af, B:74:0x02bc, B:76:0x02c4, B:77:0x02d9, B:79:0x02e1, B:80:0x02ee, B:84:0x0301, B:86:0x0313, B:88:0x032e, B:89:0x0331, B:90:0x0333, B:93:0x0349, B:95:0x034f, B:96:0x0372, B:99:0x0388, B:101:0x038e, B:102:0x03a2, B:104:0x03b2, B:105:0x03bc, B:107:0x03cc, B:108:0x03d6, B:110:0x03de, B:112:0x03ea, B:114:0x03f2, B:115:0x03fc, B:117:0x0404, B:118:0x040b, B:120:0x0411, B:111:0x03e6), top: B:128:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x018f A[Catch: Exception -> 0x041d, TryCatch #0 {Exception -> 0x041d, blocks: (B:7:0x0009, B:9:0x00b4, B:11:0x00bc, B:12:0x00bf, B:16:0x00db, B:23:0x0124, B:26:0x0150, B:28:0x0156, B:31:0x016d, B:33:0x0173, B:34:0x0187, B:36:0x018f, B:39:0x019c, B:41:0x01a2, B:42:0x01b6, B:44:0x01bf, B:45:0x01ca, B:47:0x01d0, B:51:0x01e6, B:50:0x01d7, B:53:0x01eb, B:55:0x0202, B:56:0x0207, B:58:0x020f, B:59:0x0214, B:61:0x023e, B:63:0x024c, B:65:0x0252, B:66:0x0254, B:68:0x0264, B:70:0x02a3, B:71:0x02a7, B:73:0x02af, B:74:0x02bc, B:76:0x02c4, B:77:0x02d9, B:79:0x02e1, B:80:0x02ee, B:84:0x0301, B:86:0x0313, B:88:0x032e, B:89:0x0331, B:90:0x0333, B:93:0x0349, B:95:0x034f, B:96:0x0372, B:99:0x0388, B:101:0x038e, B:102:0x03a2, B:104:0x03b2, B:105:0x03bc, B:107:0x03cc, B:108:0x03d6, B:110:0x03de, B:112:0x03ea, B:114:0x03f2, B:115:0x03fc, B:117:0x0404, B:118:0x040b, B:120:0x0411, B:111:0x03e6), top: B:128:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01bf A[Catch: Exception -> 0x041d, TryCatch #0 {Exception -> 0x041d, blocks: (B:7:0x0009, B:9:0x00b4, B:11:0x00bc, B:12:0x00bf, B:16:0x00db, B:23:0x0124, B:26:0x0150, B:28:0x0156, B:31:0x016d, B:33:0x0173, B:34:0x0187, B:36:0x018f, B:39:0x019c, B:41:0x01a2, B:42:0x01b6, B:44:0x01bf, B:45:0x01ca, B:47:0x01d0, B:51:0x01e6, B:50:0x01d7, B:53:0x01eb, B:55:0x0202, B:56:0x0207, B:58:0x020f, B:59:0x0214, B:61:0x023e, B:63:0x024c, B:65:0x0252, B:66:0x0254, B:68:0x0264, B:70:0x02a3, B:71:0x02a7, B:73:0x02af, B:74:0x02bc, B:76:0x02c4, B:77:0x02d9, B:79:0x02e1, B:80:0x02ee, B:84:0x0301, B:86:0x0313, B:88:0x032e, B:89:0x0331, B:90:0x0333, B:93:0x0349, B:95:0x034f, B:96:0x0372, B:99:0x0388, B:101:0x038e, B:102:0x03a2, B:104:0x03b2, B:105:0x03bc, B:107:0x03cc, B:108:0x03d6, B:110:0x03de, B:112:0x03ea, B:114:0x03f2, B:115:0x03fc, B:117:0x0404, B:118:0x040b, B:120:0x0411, B:111:0x03e6), top: B:128:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01eb A[Catch: Exception -> 0x041d, TryCatch #0 {Exception -> 0x041d, blocks: (B:7:0x0009, B:9:0x00b4, B:11:0x00bc, B:12:0x00bf, B:16:0x00db, B:23:0x0124, B:26:0x0150, B:28:0x0156, B:31:0x016d, B:33:0x0173, B:34:0x0187, B:36:0x018f, B:39:0x019c, B:41:0x01a2, B:42:0x01b6, B:44:0x01bf, B:45:0x01ca, B:47:0x01d0, B:51:0x01e6, B:50:0x01d7, B:53:0x01eb, B:55:0x0202, B:56:0x0207, B:58:0x020f, B:59:0x0214, B:61:0x023e, B:63:0x024c, B:65:0x0252, B:66:0x0254, B:68:0x0264, B:70:0x02a3, B:71:0x02a7, B:73:0x02af, B:74:0x02bc, B:76:0x02c4, B:77:0x02d9, B:79:0x02e1, B:80:0x02ee, B:84:0x0301, B:86:0x0313, B:88:0x032e, B:89:0x0331, B:90:0x0333, B:93:0x0349, B:95:0x034f, B:96:0x0372, B:99:0x0388, B:101:0x038e, B:102:0x03a2, B:104:0x03b2, B:105:0x03bc, B:107:0x03cc, B:108:0x03d6, B:110:0x03de, B:112:0x03ea, B:114:0x03f2, B:115:0x03fc, B:117:0x0404, B:118:0x040b, B:120:0x0411, B:111:0x03e6), top: B:128:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0202 A[Catch: Exception -> 0x041d, TryCatch #0 {Exception -> 0x041d, blocks: (B:7:0x0009, B:9:0x00b4, B:11:0x00bc, B:12:0x00bf, B:16:0x00db, B:23:0x0124, B:26:0x0150, B:28:0x0156, B:31:0x016d, B:33:0x0173, B:34:0x0187, B:36:0x018f, B:39:0x019c, B:41:0x01a2, B:42:0x01b6, B:44:0x01bf, B:45:0x01ca, B:47:0x01d0, B:51:0x01e6, B:50:0x01d7, B:53:0x01eb, B:55:0x0202, B:56:0x0207, B:58:0x020f, B:59:0x0214, B:61:0x023e, B:63:0x024c, B:65:0x0252, B:66:0x0254, B:68:0x0264, B:70:0x02a3, B:71:0x02a7, B:73:0x02af, B:74:0x02bc, B:76:0x02c4, B:77:0x02d9, B:79:0x02e1, B:80:0x02ee, B:84:0x0301, B:86:0x0313, B:88:0x032e, B:89:0x0331, B:90:0x0333, B:93:0x0349, B:95:0x034f, B:96:0x0372, B:99:0x0388, B:101:0x038e, B:102:0x03a2, B:104:0x03b2, B:105:0x03bc, B:107:0x03cc, B:108:0x03d6, B:110:0x03de, B:112:0x03ea, B:114:0x03f2, B:115:0x03fc, B:117:0x0404, B:118:0x040b, B:120:0x0411, B:111:0x03e6), top: B:128:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x020f A[Catch: Exception -> 0x041d, TryCatch #0 {Exception -> 0x041d, blocks: (B:7:0x0009, B:9:0x00b4, B:11:0x00bc, B:12:0x00bf, B:16:0x00db, B:23:0x0124, B:26:0x0150, B:28:0x0156, B:31:0x016d, B:33:0x0173, B:34:0x0187, B:36:0x018f, B:39:0x019c, B:41:0x01a2, B:42:0x01b6, B:44:0x01bf, B:45:0x01ca, B:47:0x01d0, B:51:0x01e6, B:50:0x01d7, B:53:0x01eb, B:55:0x0202, B:56:0x0207, B:58:0x020f, B:59:0x0214, B:61:0x023e, B:63:0x024c, B:65:0x0252, B:66:0x0254, B:68:0x0264, B:70:0x02a3, B:71:0x02a7, B:73:0x02af, B:74:0x02bc, B:76:0x02c4, B:77:0x02d9, B:79:0x02e1, B:80:0x02ee, B:84:0x0301, B:86:0x0313, B:88:0x032e, B:89:0x0331, B:90:0x0333, B:93:0x0349, B:95:0x034f, B:96:0x0372, B:99:0x0388, B:101:0x038e, B:102:0x03a2, B:104:0x03b2, B:105:0x03bc, B:107:0x03cc, B:108:0x03d6, B:110:0x03de, B:112:0x03ea, B:114:0x03f2, B:115:0x03fc, B:117:0x0404, B:118:0x040b, B:120:0x0411, B:111:0x03e6), top: B:128:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x023e A[Catch: Exception -> 0x041d, TryCatch #0 {Exception -> 0x041d, blocks: (B:7:0x0009, B:9:0x00b4, B:11:0x00bc, B:12:0x00bf, B:16:0x00db, B:23:0x0124, B:26:0x0150, B:28:0x0156, B:31:0x016d, B:33:0x0173, B:34:0x0187, B:36:0x018f, B:39:0x019c, B:41:0x01a2, B:42:0x01b6, B:44:0x01bf, B:45:0x01ca, B:47:0x01d0, B:51:0x01e6, B:50:0x01d7, B:53:0x01eb, B:55:0x0202, B:56:0x0207, B:58:0x020f, B:59:0x0214, B:61:0x023e, B:63:0x024c, B:65:0x0252, B:66:0x0254, B:68:0x0264, B:70:0x02a3, B:71:0x02a7, B:73:0x02af, B:74:0x02bc, B:76:0x02c4, B:77:0x02d9, B:79:0x02e1, B:80:0x02ee, B:84:0x0301, B:86:0x0313, B:88:0x032e, B:89:0x0331, B:90:0x0333, B:93:0x0349, B:95:0x034f, B:96:0x0372, B:99:0x0388, B:101:0x038e, B:102:0x03a2, B:104:0x03b2, B:105:0x03bc, B:107:0x03cc, B:108:0x03d6, B:110:0x03de, B:112:0x03ea, B:114:0x03f2, B:115:0x03fc, B:117:0x0404, B:118:0x040b, B:120:0x0411, B:111:0x03e6), top: B:128:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0264 A[Catch: Exception -> 0x041d, TryCatch #0 {Exception -> 0x041d, blocks: (B:7:0x0009, B:9:0x00b4, B:11:0x00bc, B:12:0x00bf, B:16:0x00db, B:23:0x0124, B:26:0x0150, B:28:0x0156, B:31:0x016d, B:33:0x0173, B:34:0x0187, B:36:0x018f, B:39:0x019c, B:41:0x01a2, B:42:0x01b6, B:44:0x01bf, B:45:0x01ca, B:47:0x01d0, B:51:0x01e6, B:50:0x01d7, B:53:0x01eb, B:55:0x0202, B:56:0x0207, B:58:0x020f, B:59:0x0214, B:61:0x023e, B:63:0x024c, B:65:0x0252, B:66:0x0254, B:68:0x0264, B:70:0x02a3, B:71:0x02a7, B:73:0x02af, B:74:0x02bc, B:76:0x02c4, B:77:0x02d9, B:79:0x02e1, B:80:0x02ee, B:84:0x0301, B:86:0x0313, B:88:0x032e, B:89:0x0331, B:90:0x0333, B:93:0x0349, B:95:0x034f, B:96:0x0372, B:99:0x0388, B:101:0x038e, B:102:0x03a2, B:104:0x03b2, B:105:0x03bc, B:107:0x03cc, B:108:0x03d6, B:110:0x03de, B:112:0x03ea, B:114:0x03f2, B:115:0x03fc, B:117:0x0404, B:118:0x040b, B:120:0x0411, B:111:0x03e6), top: B:128:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02af A[Catch: Exception -> 0x041d, TryCatch #0 {Exception -> 0x041d, blocks: (B:7:0x0009, B:9:0x00b4, B:11:0x00bc, B:12:0x00bf, B:16:0x00db, B:23:0x0124, B:26:0x0150, B:28:0x0156, B:31:0x016d, B:33:0x0173, B:34:0x0187, B:36:0x018f, B:39:0x019c, B:41:0x01a2, B:42:0x01b6, B:44:0x01bf, B:45:0x01ca, B:47:0x01d0, B:51:0x01e6, B:50:0x01d7, B:53:0x01eb, B:55:0x0202, B:56:0x0207, B:58:0x020f, B:59:0x0214, B:61:0x023e, B:63:0x024c, B:65:0x0252, B:66:0x0254, B:68:0x0264, B:70:0x02a3, B:71:0x02a7, B:73:0x02af, B:74:0x02bc, B:76:0x02c4, B:77:0x02d9, B:79:0x02e1, B:80:0x02ee, B:84:0x0301, B:86:0x0313, B:88:0x032e, B:89:0x0331, B:90:0x0333, B:93:0x0349, B:95:0x034f, B:96:0x0372, B:99:0x0388, B:101:0x038e, B:102:0x03a2, B:104:0x03b2, B:105:0x03bc, B:107:0x03cc, B:108:0x03d6, B:110:0x03de, B:112:0x03ea, B:114:0x03f2, B:115:0x03fc, B:117:0x0404, B:118:0x040b, B:120:0x0411, B:111:0x03e6), top: B:128:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02c4 A[Catch: Exception -> 0x041d, TryCatch #0 {Exception -> 0x041d, blocks: (B:7:0x0009, B:9:0x00b4, B:11:0x00bc, B:12:0x00bf, B:16:0x00db, B:23:0x0124, B:26:0x0150, B:28:0x0156, B:31:0x016d, B:33:0x0173, B:34:0x0187, B:36:0x018f, B:39:0x019c, B:41:0x01a2, B:42:0x01b6, B:44:0x01bf, B:45:0x01ca, B:47:0x01d0, B:51:0x01e6, B:50:0x01d7, B:53:0x01eb, B:55:0x0202, B:56:0x0207, B:58:0x020f, B:59:0x0214, B:61:0x023e, B:63:0x024c, B:65:0x0252, B:66:0x0254, B:68:0x0264, B:70:0x02a3, B:71:0x02a7, B:73:0x02af, B:74:0x02bc, B:76:0x02c4, B:77:0x02d9, B:79:0x02e1, B:80:0x02ee, B:84:0x0301, B:86:0x0313, B:88:0x032e, B:89:0x0331, B:90:0x0333, B:93:0x0349, B:95:0x034f, B:96:0x0372, B:99:0x0388, B:101:0x038e, B:102:0x03a2, B:104:0x03b2, B:105:0x03bc, B:107:0x03cc, B:108:0x03d6, B:110:0x03de, B:112:0x03ea, B:114:0x03f2, B:115:0x03fc, B:117:0x0404, B:118:0x040b, B:120:0x0411, B:111:0x03e6), top: B:128:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02e1 A[Catch: Exception -> 0x041d, TryCatch #0 {Exception -> 0x041d, blocks: (B:7:0x0009, B:9:0x00b4, B:11:0x00bc, B:12:0x00bf, B:16:0x00db, B:23:0x0124, B:26:0x0150, B:28:0x0156, B:31:0x016d, B:33:0x0173, B:34:0x0187, B:36:0x018f, B:39:0x019c, B:41:0x01a2, B:42:0x01b6, B:44:0x01bf, B:45:0x01ca, B:47:0x01d0, B:51:0x01e6, B:50:0x01d7, B:53:0x01eb, B:55:0x0202, B:56:0x0207, B:58:0x020f, B:59:0x0214, B:61:0x023e, B:63:0x024c, B:65:0x0252, B:66:0x0254, B:68:0x0264, B:70:0x02a3, B:71:0x02a7, B:73:0x02af, B:74:0x02bc, B:76:0x02c4, B:77:0x02d9, B:79:0x02e1, B:80:0x02ee, B:84:0x0301, B:86:0x0313, B:88:0x032e, B:89:0x0331, B:90:0x0333, B:93:0x0349, B:95:0x034f, B:96:0x0372, B:99:0x0388, B:101:0x038e, B:102:0x03a2, B:104:0x03b2, B:105:0x03bc, B:107:0x03cc, B:108:0x03d6, B:110:0x03de, B:112:0x03ea, B:114:0x03f2, B:115:0x03fc, B:117:0x0404, B:118:0x040b, B:120:0x0411, B:111:0x03e6), top: B:128:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0313 A[Catch: Exception -> 0x041d, TryCatch #0 {Exception -> 0x041d, blocks: (B:7:0x0009, B:9:0x00b4, B:11:0x00bc, B:12:0x00bf, B:16:0x00db, B:23:0x0124, B:26:0x0150, B:28:0x0156, B:31:0x016d, B:33:0x0173, B:34:0x0187, B:36:0x018f, B:39:0x019c, B:41:0x01a2, B:42:0x01b6, B:44:0x01bf, B:45:0x01ca, B:47:0x01d0, B:51:0x01e6, B:50:0x01d7, B:53:0x01eb, B:55:0x0202, B:56:0x0207, B:58:0x020f, B:59:0x0214, B:61:0x023e, B:63:0x024c, B:65:0x0252, B:66:0x0254, B:68:0x0264, B:70:0x02a3, B:71:0x02a7, B:73:0x02af, B:74:0x02bc, B:76:0x02c4, B:77:0x02d9, B:79:0x02e1, B:80:0x02ee, B:84:0x0301, B:86:0x0313, B:88:0x032e, B:89:0x0331, B:90:0x0333, B:93:0x0349, B:95:0x034f, B:96:0x0372, B:99:0x0388, B:101:0x038e, B:102:0x03a2, B:104:0x03b2, B:105:0x03bc, B:107:0x03cc, B:108:0x03d6, B:110:0x03de, B:112:0x03ea, B:114:0x03f2, B:115:0x03fc, B:117:0x0404, B:118:0x040b, B:120:0x0411, B:111:0x03e6), top: B:128:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0387  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parserJson(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        JSONArray optJSONArray3;
        JSONArray optJSONArray4;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        JSONObject optJSONObject5;
        JSONObject optJSONObject6;
        JSONObject optJSONObject7;
        JSONObject optJSONObject8;
        JSONObject optJSONObject9;
        boolean z3;
        JSONObject optJSONObject10;
        JSONArray optJSONArray5;
        JSONArray optJSONArray6;
        JSONObject optJSONObject11;
        JSONObject optJSONObject12;
        JSONObject optJSONObject13;
        JSONObject optJSONObject14;
        JSONArray optJSONArray7;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048663, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            this.userId = jSONObject.optString("id");
            this.gender = jSONObject.optInt("gender", 0);
            this.type = jSONObject.optInt("type", 0);
            this.userName = jSONObject.optString("name");
            this.uk = jSONObject.optString("uk");
            this.level_id = jSONObject.optInt("level_id", 0);
            this.level_name = jSONObject.optString("level_name");
            this.is_like = jSONObject.optInt("is_like", 0);
            this.is_bawu = jSONObject.optInt("is_bawu", 0);
            this.is_manager = jSONObject.optInt("is_manager", 0);
            this.isMem = jSONObject.optInt("is_mem", 0);
            this.bawu_type = jSONObject.optString("bawu_type");
            this.is_myfriend = jSONObject.optInt("is_friend");
            this.is_myfans = jSONObject.optInt("is_fans");
            this.is_follower = jSONObject.optInt("is_double_concern");
            this.is_my_follower = jSONObject.optInt("is_my_concern");
            this.is_nearlyAt = jSONObject.optInt("is_at");
            this.is_bazhu = jSONObject.optInt("is_bazhu");
            this.is_god_user = jSONObject.optInt(IMUserExtraData.KEY_IS_GOD);
            this.tag = jSONObject.optString("tag");
            this.tagIcon = jSONObject.optString("tag_icon");
            if (this.userName != null && this.userName.length() <= 0) {
                this.userName = null;
            }
            this.name_show = jSONObject.optString("name_show");
            this.nickNameInVerifying = jSONObject.optString("editing_nickname");
            if (jSONObject.optInt("is_nickname_editing", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            this.isNickNameInVerifying = z;
            this.portrait = jSONObject.optString("portrait");
            this.avatarUrl = jSONObject.optString("avatar_url");
            this.targetScheme = jSONObject.optString("target_scheme");
            this.portraith = jSONObject.optString("portraith");
            this.fansNum = jSONObject.optInt(PersonInfoActivityConfig.FANS_NUM);
            this.likeNum = jSONObject.optInt("my_like_num");
            this.threadNum = jSONObject.optInt("post_num");
            int optInt = jSONObject.optInt("has_concerned");
            if (optInt != 1 && optInt != 2) {
                z2 = false;
                this.mHadConcerned = z2;
                setLikeStatus(optInt);
                optJSONArray = jSONObject.optJSONArray("iconinfo");
                optJSONArray2 = jSONObject.optJSONArray("tshow_icon");
                optJSONArray3 = jSONObject.optJSONArray("new_tshow_icon");
                optJSONArray4 = jSONObject.optJSONArray("tags");
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
                optJSONObject3 = jSONObject.optJSONObject("pendant");
                if (optJSONObject3 != null) {
                    UserPendantData userPendantData = new UserPendantData();
                    this.pendantData = userPendantData;
                    userPendantData.parserJson(optJSONObject3);
                }
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        IconData iconData3 = new IconData();
                        iconData3.parserJson(optJSONArray3.getJSONObject(i3));
                        this.mTShowIconInfoNew.add(iconData3);
                    }
                }
                this.tags = new ArrayList<>();
                if (optJSONArray4 != null) {
                    TagsInfo.Builder builder = new TagsInfo.Builder();
                    new ThemeColorInfo.Builder();
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        JSONObject optJSONObject15 = optJSONArray4.optJSONObject(i4);
                        if (optJSONObject15 != null) {
                            builder.img_info = y5b.j(optJSONObject15);
                            this.tags.add(builder.build(true));
                        }
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
                optJSONObject4 = jSONObject.optJSONObject("theme_card");
                if (optJSONObject4 != null) {
                    this.themeCard.parser(optJSONObject4);
                }
                this.isLikeStatusFromNet = true;
                AlaUserInfoData alaUserInfoData = new AlaUserInfoData();
                this.alaUserData = alaUserInfoData;
                alaUserInfoData.parserJson(jSONObject.optJSONObject("ala_info"));
                AlaInfoData alaInfoData = new AlaInfoData();
                this.alaInfo = alaInfoData;
                alaInfoData.parserJson(jSONObject.optJSONObject("ala_live_info"));
                optJSONObject5 = jSONObject.optJSONObject("spring_virtual_user");
                if (optJSONObject5 != null) {
                    int optInt2 = optJSONObject5.optInt("is_virtual");
                    String optString = optJSONObject5.optString("url");
                    if (optInt2 == 1 && !StringUtils.isNull(optString)) {
                        this.virtualUserUrl = optString;
                    }
                }
                this.left_call_num = jSONObject.optInt("left_call_num", 0);
                optJSONObject6 = jSONObject.optJSONObject("baijiahao_info");
                if (optJSONObject6 != null) {
                    BaijiahaoInfo.Builder builder2 = new BaijiahaoInfo.Builder();
                    builder2.name = optJSONObject6.optString("name");
                    builder2.avatar = optJSONObject6.optString("avatar");
                    builder2.avatar_h = optJSONObject6.optString("avatar_h");
                    builder2.brief = optJSONObject6.optString(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF);
                    builder2.auth_id = Integer.valueOf(optJSONObject6.optInt("auth_id"));
                    builder2.auth_desc = optJSONObject6.optString(IMUserExtraData.KEY_AUTH_DESC);
                    BaijiahaoInfo build = builder2.build(false);
                    this.baijiahaoInfo = build;
                    if (build != null) {
                        this.authDesc = build.auth_desc;
                    }
                }
                optJSONObject7 = jSONObject.optJSONObject("new_god_data");
                if (optJSONObject7 != null) {
                    this.mNewGodData.parserJson(optJSONObject7);
                    this.godStatus = this.mNewGodData.getStatus();
                }
                optJSONObject8 = jSONObject.optJSONObject("bazhu_grade");
                if (optJSONObject8 != null) {
                    this.mBazhuGrade.parserJson(optJSONObject8);
                    this.bazhuDesc = this.mBazhuGrade.getDesc();
                    this.bazhuLevel = this.mBazhuGrade.getLevel();
                }
                optJSONObject9 = jSONObject.optJSONObject("priv_sets");
                if (optJSONObject9 != null) {
                    this.privSetsData.parserJson(optJSONObject9);
                    this.bazhuShowOutside = this.privSetsData.getBazhuShowOutside();
                }
                this.isOriginalAuthor = jSONObject.optInt(IMUserExtraData.KEY_IS_ORIGINAL_AUTHOR, 0);
                if (jSONObject.optInt("can_modify_avatar") != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.canModifyAvatar = z3;
                this.cantModifyAvatarDesc = jSONObject.optString("modify_avatar_desc");
                optJSONObject10 = jSONObject.optJSONObject("business_account_info");
                if (optJSONObject10 != null) {
                    BusinessAccountData businessAccountData = new BusinessAccountData();
                    this.businessAccountData = businessAccountData;
                    businessAccountData.parseJson(optJSONObject10);
                    TbSingleton.getInstance().setBusinessAccount(this.businessAccountData.isBusinessAccount);
                    if (this.businessAccountData.isBusinessAccount) {
                        this.isBusinessAccount = 1;
                    } else {
                        this.isBusinessAccount = 0;
                    }
                }
                this.appealThreadPopover = jSONObject.optString("appeal_thread_popover");
                this.forumToolAuth.clear();
                optJSONArray5 = jSONObject.optJSONArray("forum_tool_auth");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        ForumToolPerm.Builder builder3 = new ForumToolPerm.Builder();
                        builder3.perm = Long.valueOf(((JSONObject) optJSONArray5.get(i5)).optLong("perm"));
                        this.forumToolAuth.add(builder3.build(false));
                    }
                }
                this.tiebaUid = jSONObject.optString("tieba_uid");
                this.managerForum.clear();
                optJSONArray6 = jSONObject.optJSONArray("manager_forum");
                if (optJSONArray6 != null) {
                    for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                        JSONObject optJSONObject16 = optJSONArray6.optJSONObject(i6);
                        BazhuGradeData bazhuGradeData = new BazhuGradeData();
                        bazhuGradeData.parserJson(optJSONObject16);
                        this.managerForum.add(bazhuGradeData);
                    }
                }
                this.authType = jSONObject.optInt("display_auth_type");
                optJSONObject11 = jSONObject.optJSONObject("work_creator_info");
                if (optJSONObject11 != null) {
                    WorkCreateAutherData workCreateAutherData = new WorkCreateAutherData();
                    this.creatorInfo = workCreateAutherData;
                    workCreateAutherData.parseJson(optJSONObject11);
                }
                this.mRelation = jSONObject.optInt("relation");
                optJSONObject12 = jSONObject.optJSONObject("user_growth");
                if (optJSONObject12 != null) {
                    md5 md5Var = new md5();
                    this.userGrowthData = md5Var;
                    md5Var.f(optJSONObject12);
                }
                optJSONObject13 = jSONObject.optJSONObject("theme_tail");
                if (optJSONObject13 == null) {
                    this.smallTailThemeData = new SmallTailThemeData(optJSONObject13);
                } else {
                    this.smallTailThemeData = SmallTailThemeData.DEFAULT;
                }
                optJSONObject14 = jSONObject.optJSONObject("world_cup_info");
                if (optJSONObject14 != null) {
                    pd5 pd5Var = new pd5();
                    this.userWorldCupData = pd5Var;
                    pd5Var.a(optJSONObject14);
                }
                optJSONArray7 = jSONObject.optJSONArray("pendants");
                if (optJSONArray7 == null) {
                    this.pendants = new ArrayList();
                    for (int i7 = 0; i7 < optJSONArray7.length(); i7++) {
                        this.pendants.add(optJSONArray7.optString(i7));
                    }
                    return;
                }
                return;
            }
            z2 = true;
            this.mHadConcerned = z2;
            setLikeStatus(optInt);
            optJSONArray = jSONObject.optJSONArray("iconinfo");
            optJSONArray2 = jSONObject.optJSONArray("tshow_icon");
            optJSONArray3 = jSONObject.optJSONArray("new_tshow_icon");
            optJSONArray4 = jSONObject.optJSONArray("tags");
            optJSONObject = jSONObject.optJSONObject("god_data");
            optJSONObject2 = jSONObject.optJSONObject("tb_vip");
            if (optJSONArray != null) {
            }
            if (optJSONArray2 != null) {
            }
            optJSONObject3 = jSONObject.optJSONObject("pendant");
            if (optJSONObject3 != null) {
            }
            if (optJSONArray3 != null) {
            }
            this.tags = new ArrayList<>();
            if (optJSONArray4 != null) {
            }
            if (optJSONObject != null) {
            }
            if (optJSONObject2 != null) {
            }
            optJSONObject4 = jSONObject.optJSONObject("theme_card");
            if (optJSONObject4 != null) {
            }
            this.isLikeStatusFromNet = true;
            AlaUserInfoData alaUserInfoData2 = new AlaUserInfoData();
            this.alaUserData = alaUserInfoData2;
            alaUserInfoData2.parserJson(jSONObject.optJSONObject("ala_info"));
            AlaInfoData alaInfoData2 = new AlaInfoData();
            this.alaInfo = alaInfoData2;
            alaInfoData2.parserJson(jSONObject.optJSONObject("ala_live_info"));
            optJSONObject5 = jSONObject.optJSONObject("spring_virtual_user");
            if (optJSONObject5 != null) {
            }
            this.left_call_num = jSONObject.optInt("left_call_num", 0);
            optJSONObject6 = jSONObject.optJSONObject("baijiahao_info");
            if (optJSONObject6 != null) {
            }
            optJSONObject7 = jSONObject.optJSONObject("new_god_data");
            if (optJSONObject7 != null) {
            }
            optJSONObject8 = jSONObject.optJSONObject("bazhu_grade");
            if (optJSONObject8 != null) {
            }
            optJSONObject9 = jSONObject.optJSONObject("priv_sets");
            if (optJSONObject9 != null) {
            }
            this.isOriginalAuthor = jSONObject.optInt(IMUserExtraData.KEY_IS_ORIGINAL_AUTHOR, 0);
            if (jSONObject.optInt("can_modify_avatar") != 0) {
            }
            this.canModifyAvatar = z3;
            this.cantModifyAvatarDesc = jSONObject.optString("modify_avatar_desc");
            optJSONObject10 = jSONObject.optJSONObject("business_account_info");
            if (optJSONObject10 != null) {
            }
            this.appealThreadPopover = jSONObject.optString("appeal_thread_popover");
            this.forumToolAuth.clear();
            optJSONArray5 = jSONObject.optJSONArray("forum_tool_auth");
            if (optJSONArray5 != null) {
            }
            this.tiebaUid = jSONObject.optString("tieba_uid");
            this.managerForum.clear();
            optJSONArray6 = jSONObject.optJSONArray("manager_forum");
            if (optJSONArray6 != null) {
            }
            this.authType = jSONObject.optInt("display_auth_type");
            optJSONObject11 = jSONObject.optJSONObject("work_creator_info");
            if (optJSONObject11 != null) {
            }
            this.mRelation = jSONObject.optInt("relation");
            optJSONObject12 = jSONObject.optJSONObject("user_growth");
            if (optJSONObject12 != null) {
            }
            optJSONObject13 = jSONObject.optJSONObject("theme_tail");
            if (optJSONObject13 == null) {
            }
            optJSONObject14 = jSONObject.optJSONObject("world_cup_info");
            if (optJSONObject14 != null) {
            }
            optJSONArray7 = jSONObject.optJSONArray("pendants");
            if (optJSONArray7 == null) {
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserProtobuf(User user) {
        boolean z;
        boolean z2;
        boolean z3;
        int intValue;
        boolean z4;
        boolean z5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048664, this, user) != null) || user == null) {
            return;
        }
        this.userId = user.id + "";
        this.gender = user.gender.intValue();
        this.type = user.type.intValue();
        this.userName = user.name;
        this.level_id = user.level_id.intValue();
        this.level_name = user.level_name;
        this.is_like = user.is_like.intValue();
        this.is_bawu = user.is_bawu.intValue();
        this.is_manager = user.is_manager.intValue();
        this.bawu_type = user.bawu_type;
        this.is_myfriend = user.is_friend.intValue();
        this.is_myfans = user.is_fans.intValue();
        this.concernNum = user.concern_num.intValue();
        this.diplayIntro = user.display_intro;
        if (user.has_concerned.intValue() != 1 && user.has_concerned.intValue() != 2) {
            z = false;
        } else {
            z = true;
        }
        this.mHadConcerned = z;
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
        if (user.is_nickname_editing.intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.isNickNameInVerifying = z2;
        this.portrait = user.portrait;
        this.avatarUrl = user.avatar_url;
        this.targetScheme = user.target_scheme;
        this.portraith = user.portraith;
        List<Icon> list = user.iconinfo;
        List<TshowInfo> list2 = user.tshow_icon;
        List<TshowInfo> list3 = user.new_tshow_icon;
        List<TagsInfo> list4 = user.tags;
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
        ArrayList<TagsInfo> arrayList = new ArrayList<>();
        this.tags = arrayList;
        if (list4 != null) {
            arrayList.addAll(list4);
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
        BaijiahaoInfo baijiahaoInfo = user.baijiahao_info;
        this.baijiahaoInfo = baijiahaoInfo;
        if (baijiahaoInfo != null) {
            this.authDesc = baijiahaoInfo.auth_desc;
        }
        if (user.can_modify_avatar.intValue() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.canModifyAvatar = z3;
        this.cantModifyAvatarDesc = user.modify_avatar_desc;
        this.rankNum = user.level_influence;
        Integer num = user.influence;
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        this.rankInfluence = intValue;
        if (user.is_mask.intValue() == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.isMask = z4;
        NewGodInfo newGodInfo = user.new_god_data;
        if (newGodInfo != null) {
            this.mNewGodData.parserProtobuf(newGodInfo);
        }
        BazhuSign bazhuSign = user.bazhu_grade;
        if (bazhuSign != null) {
            this.mBazhuGrade.parserProtobuf(bazhuSign);
            this.bazhuDesc = this.mBazhuGrade.getDesc();
            this.bazhuLevel = this.mBazhuGrade.getLevel();
        }
        NewGodInfo newGodInfo2 = user.new_god_data;
        if (newGodInfo2 != null) {
            this.mNewGodData.parserProtobuf(newGodInfo2);
            this.godStatus = this.mNewGodData.getStatus();
        }
        if (user.is_default_avatar.intValue() == 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.isDefaultAvatar = z5;
        this.uk = user.uk;
        PrivSets privSets = user.priv_sets;
        if (privSets != null) {
            this.privSetsData.parserProtobuf(privSets);
            this.bazhuShowOutside = this.privSetsData.getBazhuShowOutside();
        }
        if (user.business_account_info != null) {
            BusinessAccountData businessAccountData = new BusinessAccountData();
            this.businessAccountData = businessAccountData;
            businessAccountData.parseProto(user.business_account_info);
            TbSingleton.getInstance().setBusinessAccount(this.businessAccountData.isBusinessAccount);
            if (this.businessAccountData.isBusinessAccount) {
                this.isBusinessAccount = 1;
            } else {
                this.isBusinessAccount = 0;
            }
        }
        if (!StringUtils.isNull(user.appeal_thread_popover)) {
            this.appealThreadPopover = user.appeal_thread_popover;
        }
        List<ForumToolPerm> list5 = user.forum_tool_auth;
        this.forumToolAuth.clear();
        if (list5 != null && list5.size() > 0) {
            this.forumToolAuth.addAll(list5);
        }
        String str2 = user.tieba_uid;
        if (str2 != null) {
            this.tiebaUid = str2;
        }
        this.managerForum.clear();
        List<BazhuSign> list6 = user.manager_forum;
        if (list6 != null) {
            for (BazhuSign bazhuSign2 : list6) {
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
        if (user.user_growth != null) {
            md5 md5Var = new md5();
            this.userGrowthData = md5Var;
            md5Var.g(user.user_growth);
        }
        if (user.theme_tail != null) {
            this.smallTailThemeData = new SmallTailThemeData(user.theme_tail);
        } else {
            this.smallTailThemeData = SmallTailThemeData.DEFAULT;
        }
        pd5 pd5Var = new pd5();
        this.userWorldCupData = pd5Var;
        pd5Var.b(user.world_cup_info);
        this.pendants = user.pendants;
    }
}
