package com.baidu.tbadk.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.ShakeAdSwitchData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.hh5;
import com.baidu.tieba.t45;
import com.baidu.tieba.vn;
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
import tbclient.ActivitySponsor;
import tbclient.AlaUserInfo;
import tbclient.BawuThrones;
import tbclient.BirthdayInfo;
import tbclient.GiftInfo;
import tbclient.LikeForumInfo;
import tbclient.MyGroupInfo;
import tbclient.NewParrScores;
import tbclient.PayMemberInfo;
import tbclient.PrivSets;
import tbclient.ThemeMyTab;
import tbclient.TwZhiBoUser;
import tbclient.User;
import tbclient.UserPics;
import tbclient.UserVipInfo;
import tbclient.VipCloseAd;
import tbclient.VipShowInfo;
/* loaded from: classes4.dex */
public class UserData extends MetaData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int USER_PICS_MAX_COUNT = 9;
    public static final long serialVersionUID = -1871115639893992930L;
    public transient /* synthetic */ FieldHolder $fh;
    public String BDUSS;
    public int anchorLevel;
    public BawuThrones bawuThrones;
    public String bg_pic;
    public int bimg_end_time;
    public String bimg_url;
    public int canChat;
    public CloseAdData closeAdData;
    public String dynamic_url;
    public int favoriteNum;
    public String followFrom;
    public String grade;
    public int have_attention;
    public long inTime;
    public String intro;
    public String ip;
    public int isBlocked;
    public int isFriend;
    public boolean isGodInvited;
    public boolean isManager;
    public boolean isMask;
    public int isOfficialAccount;
    public boolean isShowDriftingBottle;
    public boolean isShowRedPacket;
    public int is_mem;
    public long lastReplyTime;
    public String lat;
    public int like_bars;
    public String liveId;
    public int liveLevel;
    public long liveLevelExp;
    public int liveStatus;
    public String lng;
    public long loginTime;
    public ActivitySponsorData mActivitySponsorData;
    public t45 mBirthdayInfo;
    public List<MyGift> mGift;
    public int mGiftNum;
    public List<MyGroup> mGroup;
    public boolean mIsSelectTail;
    public List<MyLikeForum> mLikeForum;
    public List<vn> mPhotoAlbum;
    public ShakeAdSwitchData mShakeAdSwitch;
    public long mTDouNum;
    public String mTiebaUid;
    public int managerLevel;
    public int markCount;
    public MembershipUserInfo membershipInfo;
    public int newMarkCount;
    public String password;
    public PayMemberInfoData payMemberInfo;
    public Permission permission;
    public PersonPrivateData personPrivate;
    public String position;
    public int posts_num;
    public int privateThread;
    public int relation;
    public int sex;
    public int showPbPrivateFlag;
    public UserTbVipInfoData tbVipInfo;
    public String tb_age;
    public ThemeMyTab themeMyTab;
    public int userType;
    public UserVipInfoData vipInfo;
    public int visitorNum;

    /* loaded from: classes4.dex */
    public static class Permission extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int TRUE = 1;
        public static final long serialVersionUID = -661968182172681650L;
        public transient /* synthetic */ FieldHolder $fh;
        public int isGroupManager;
        public int isGroupOwner;

        public Permission() {
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

        public boolean getIsGroupManager() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.isGroupManager == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean getIsGroupOwner() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.isGroupOwner == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean isController() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (!getIsGroupManager() && !getIsGroupOwner()) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public void setIsGroupManager(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                this.isGroupManager = i;
            }
        }

        public void setIsGroupOwner(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                this.isGroupOwner = i;
            }
        }
    }

    public UserData() {
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
        this.password = null;
        this.isManager = false;
        this.isMask = false;
        this.mLikeForum = new ArrayList();
        this.mGroup = new ArrayList();
        this.mGift = new ArrayList();
        this.showPbPrivateFlag = 0;
        this.mPhotoAlbum = new ArrayList();
        this.liveLevel = 1;
        this.liveLevelExp = 0L;
        this.liveStatus = 0;
        this.liveId = "0";
        this.isGodInvited = false;
        this.ip = null;
        this.BDUSS = null;
        this.like_bars = -1;
        this.sex = 1;
        this.intro = null;
        this.posts_num = -1;
        setHave_attention(0);
        this.tb_age = "";
        this.markCount = 0;
        this.newMarkCount = 0;
        this.anchorLevel = 0;
    }

    public UserData(long j, String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), str, str2, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.password = null;
        this.isManager = false;
        this.isMask = false;
        this.mLikeForum = new ArrayList();
        this.mGroup = new ArrayList();
        this.mGift = new ArrayList();
        this.showPbPrivateFlag = 0;
        this.mPhotoAlbum = new ArrayList();
        this.liveLevel = 1;
        this.liveLevelExp = 0L;
        this.liveStatus = 0;
        this.liveId = "0";
        this.isGodInvited = false;
        setUserId(String.valueOf(j));
        setUserName(str);
        setPortrait(str2);
        this.sex = i;
    }

    public boolean canChat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.canChat == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getAnchorLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.anchorLevel;
        }
        return invokeV.intValue;
    }

    public String getBDUSS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.BDUSS;
        }
        return (String) invokeV.objValue;
    }

    public String getBg_pic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.bg_pic;
        }
        return (String) invokeV.objValue;
    }

    public int getBimg_end_time() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.bimg_end_time;
        }
        return invokeV.intValue;
    }

    public String getBimg_url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.bimg_url;
        }
        return (String) invokeV.objValue;
    }

    public t45 getBirthdayInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mBirthdayInfo;
        }
        return (t45) invokeV.objValue;
    }

    public int getCanChat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.canChat;
        }
        return invokeV.intValue;
    }

    public CloseAdData getCloseAdData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.closeAdData;
        }
        return (CloseAdData) invokeV.objValue;
    }

    public String getDynamicUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.dynamic_url;
        }
        return (String) invokeV.objValue;
    }

    public int getFavoriteNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.favoriteNum;
        }
        return invokeV.intValue;
    }

    public String getFollowFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.followFrom;
        }
        return (String) invokeV.objValue;
    }

    public List<MyGift> getGift() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mGift;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.data.MetaData
    public int getGiftNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mGiftNum;
        }
        return invokeV.intValue;
    }

    public String getGrade() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.grade;
        }
        return (String) invokeV.objValue;
    }

    public List<MyGroup> getGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mGroup;
        }
        return (List) invokeV.objValue;
    }

    public int getHave_attention() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.have_attention;
        }
        return invokeV.intValue;
    }

    public long getInTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.inTime;
        }
        return invokeV.longValue;
    }

    public String getIntro() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.intro;
        }
        return (String) invokeV.objValue;
    }

    public String getIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.ip;
        }
        return (String) invokeV.objValue;
    }

    public int getIsBlocked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.isBlocked;
        }
        return invokeV.intValue;
    }

    public int getIsFriend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.isFriend;
        }
        return invokeV.intValue;
    }

    public boolean getIsGodInvited() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.isGodInvited;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.data.MetaData
    public int getIsMem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.is_mem;
        }
        return invokeV.intValue;
    }

    public int getIsOfficialAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.isOfficialAccount;
        }
        return invokeV.intValue;
    }

    public boolean getIsSelectTail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.mIsSelectTail;
        }
        return invokeV.booleanValue;
    }

    public long getLastReplyTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.lastReplyTime;
        }
        return invokeV.longValue;
    }

    public String getLat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.lat;
        }
        return (String) invokeV.objValue;
    }

    public List<MyLikeForum> getLikeForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.mLikeForum;
        }
        return (List) invokeV.objValue;
    }

    public int getLike_bars() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.like_bars;
        }
        return invokeV.intValue;
    }

    public String getLiveId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.liveId;
        }
        return (String) invokeV.objValue;
    }

    public int getLiveLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.liveLevel;
        }
        return invokeV.intValue;
    }

    public long getLiveLevelExp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.liveLevelExp;
        }
        return invokeV.longValue;
    }

    public int getLiveStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.liveStatus;
        }
        return invokeV.intValue;
    }

    public String getLng() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.lng;
        }
        return (String) invokeV.objValue;
    }

    public long getLoginTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.loginTime;
        }
        return invokeV.longValue;
    }

    public String getPassword() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.password;
        }
        return (String) invokeV.objValue;
    }

    public PayMemberInfoData getPayMemberInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.payMemberInfo;
        }
        return (PayMemberInfoData) invokeV.objValue;
    }

    public Permission getPermission() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.permission;
        }
        return (Permission) invokeV.objValue;
    }

    public PersonPrivateData getPersonPrivate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.personPrivate;
        }
        return (PersonPrivateData) invokeV.objValue;
    }

    public List<vn> getPhotoAlbum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.mPhotoAlbum;
        }
        return (List) invokeV.objValue;
    }

    public String getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.position;
        }
        return (String) invokeV.objValue;
    }

    public int getPosts_num() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.posts_num;
        }
        return invokeV.intValue;
    }

    public int getPrivateThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.privateThread;
        }
        return invokeV.intValue;
    }

    public int getRelation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.relation;
        }
        return invokeV.intValue;
    }

    public int getSex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.sex;
        }
        return invokeV.intValue;
    }

    public ShakeAdSwitchData getShakeAdSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.mShakeAdSwitch;
        }
        return (ShakeAdSwitchData) invokeV.objValue;
    }

    public long getTDouNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.mTDouNum;
        }
        return invokeV.longValue;
    }

    public String getTb_age() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.tb_age;
        }
        return (String) invokeV.objValue;
    }

    public int getUserType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.userType;
        }
        return invokeV.intValue;
    }

    public UserVipInfoData getUserVipInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.vipInfo;
        }
        return (UserVipInfoData) invokeV.objValue;
    }

    public int getVisitorNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.visitorNum;
        }
        return invokeV.intValue;
    }

    public String getmTiebaUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.mTiebaUid;
        }
        return (String) invokeV.objValue;
    }

    public boolean isBawu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            int i = this.managerLevel;
            if (i == 1 || i == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isBlocked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            if (this.isBlocked == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isLike() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if (this.have_attention == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.isMask;
        }
        return invokeV.booleanValue;
    }

    public boolean isNormal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            if (this.managerLevel == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isOtherBawu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            int i = this.managerLevel;
            if (i != 2 && i != 3 && i != 4) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowDriftingBottle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.isShowDriftingBottle;
        }
        return invokeV.booleanValue;
    }

    public boolean showPbPrivate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            if (this.showPbPrivateFlag == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.data.MetaData
    public void parserJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            super.parserJson(str);
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void setBDUSS(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
            this.BDUSS = str;
        }
    }

    public void setBg_pic(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, str) == null) {
            this.bg_pic = str;
        }
    }

    public void setBimg_end_time(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i) == null) {
            this.bimg_end_time = i;
        }
    }

    public void setBimg_url(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, str) == null) {
            this.bimg_url = str;
        }
    }

    public void setCanChat(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048643, this, i) == null) {
            this.canChat = i;
        }
    }

    public void setDynamicUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, str) == null) {
            this.dynamic_url = str;
        }
    }

    public void setFavoriteNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i) == null) {
            this.favoriteNum = i;
        }
    }

    public void setGift(List<MyGift> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, list) == null) {
            this.mGift = list;
        }
    }

    @Override // com.baidu.tbadk.data.MetaData
    public void setGiftNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i) == null) {
            this.mGiftNum = i;
        }
    }

    public void setGrade(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, str) == null) {
            this.grade = str;
        }
    }

    public void setGroup(List<MyGroup> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, list) == null) {
            this.mGroup = list;
        }
    }

    public void setHave_attention(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i) == null) {
            setLikeStatus(i);
        }
    }

    public void setInTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048651, this, j) == null) {
            this.inTime = j;
        }
    }

    public void setIntro(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, str) == null) {
            this.intro = str;
        }
    }

    public void setIp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, str) == null) {
            this.ip = str;
        }
    }

    public void setIsBlocked(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048654, this, i) == null) {
            this.isBlocked = i;
        }
    }

    public void setIsFriend(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048655, this, i) == null) {
            this.isFriend = i;
        }
    }

    public void setIsMem(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048656, this, i) == null) {
            this.is_mem = i;
        }
    }

    public void setLastReplyTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048657, this, j) == null) {
            this.lastReplyTime = j;
        }
    }

    public void setLat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, str) == null) {
            this.lat = str;
        }
    }

    public void setLike(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048659, this, z) == null) {
            if (z) {
                this.have_attention = 1;
            } else {
                this.have_attention = 0;
            }
        }
    }

    public void setLikeForum(List<MyLikeForum> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, list) == null) {
            this.mLikeForum = list;
        }
    }

    @Override // com.baidu.tbadk.data.MetaData, com.baidu.tieba.mb5
    public void setLikeStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048661, this, i) == null) {
            super.setLikeStatus(i);
            this.have_attention = i;
        }
    }

    public void setLike_bars(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048662, this, i) == null) {
            this.like_bars = i;
        }
    }

    public void setLng(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, str) == null) {
            this.lng = str;
        }
    }

    public void setLoginTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048664, this, j) == null) {
            this.loginTime = j;
        }
    }

    public void setMask(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048665, this, z) == null) {
            this.isMask = z;
        }
    }

    public void setPermission(Permission permission) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, permission) == null) {
            this.permission = permission;
        }
    }

    public void setPosition(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, str) == null) {
            this.position = str;
        }
    }

    public void setPosts_num(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048668, this, i) == null) {
            this.posts_num = i;
        }
    }

    public void setPrivateThread(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048669, this, i) == null) {
            this.privateThread = i;
        }
    }

    public void setRelation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048670, this, i) == null) {
            this.relation = i;
        }
    }

    public void setSex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048671, this, i) == null) {
            this.sex = i;
        }
    }

    public void setTb_age(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, str) == null) {
            this.tb_age = str;
        }
    }

    public void setUserType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048673, this, i) == null) {
            this.userType = i;
        }
    }

    public void setmTiebaUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, str) == null) {
            this.mTiebaUid = str;
        }
    }

    @Override // com.baidu.tbadk.data.MetaData
    public void parserJson(JSONObject jSONObject) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, jSONObject) == null) {
            try {
                super.parserJson(jSONObject);
                if (jSONObject == null) {
                    return;
                }
                this.ip = jSONObject.optString("ip");
                this.BDUSS = jSONObject.optString(HttpRequest.BDUSS);
                this.favoriteNum = jSONObject.optInt("favorite_num");
                int optInt = jSONObject.optInt("sex", 1);
                this.sex = optInt;
                if (optInt != 2 && optInt != 1) {
                    this.sex = 1;
                }
                this.like_bars = jSONObject.optInt("my_like_num");
                this.intro = jSONObject.optString("intro");
                this.isFriend = jSONObject.optInt("is_friend");
                this.markCount = jSONObject.optInt("bookmark_count");
                this.newMarkCount = jSONObject.optInt("bookmark_new_count", 0);
                this.have_attention = jSONObject.optInt("has_concerned");
                this.relation = jSONObject.optInt("relation");
                setLikeStatus(this.have_attention);
                this.password = jSONObject.optString("passwd");
                this.posts_num = jSONObject.optInt("post_num", 0);
                this.tb_age = jSONObject.optString("tb_age");
                int optInt2 = jSONObject.optInt("is_manager", 0);
                this.isOfficialAccount = jSONObject.optInt("is_guanfang", 0);
                this.followFrom = jSONObject.optString("follow_from");
                if (optInt2 == 1) {
                    this.isManager = true;
                } else {
                    this.isManager = false;
                }
                this.bg_pic = jSONObject.optString("bg_pic");
                this.bimg_url = jSONObject.optString("bimg_url");
                this.dynamic_url = jSONObject.optString("dynamic_url");
                this.bimg_end_time = jSONObject.optInt("bimg_end_time", 0);
                this.is_mem = jSONObject.optInt("is_mem");
                JSONObject optJSONObject = jSONObject.optJSONObject("vipInfo");
                if (optJSONObject != null) {
                    UserVipInfoData userVipInfoData = new UserVipInfoData();
                    this.vipInfo = userVipInfoData;
                    userVipInfoData.parseJson(optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("vip_show_info");
                if (optJSONObject2 != null) {
                    MembershipUserInfo membershipUserInfo = new MembershipUserInfo();
                    this.membershipInfo = membershipUserInfo;
                    membershipUserInfo.parseJson(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("vip_close_ad");
                if (optJSONObject3 != null) {
                    CloseAdData closeAdData = new CloseAdData();
                    this.closeAdData = closeAdData;
                    closeAdData.parseJson(optJSONObject3);
                }
                this.mGiftNum = jSONObject.optInt("gift_num");
                JSONObject optJSONObject4 = jSONObject.optJSONObject("priv_sets");
                if (optJSONObject4 != null) {
                    PersonPrivateData personPrivateData = new PersonPrivateData();
                    this.personPrivate = personPrivateData;
                    personPrivateData.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("pay_member_info");
                if (optJSONObject5 != null) {
                    PayMemberInfoData payMemberInfoData = new PayMemberInfoData();
                    this.payMemberInfo = payMemberInfoData;
                    payMemberInfoData.parseJson(optJSONObject5);
                }
                if (jSONObject.optInt("is_mask") == 1) {
                    this.isMask = true;
                } else {
                    this.isMask = false;
                }
                if (jSONObject.optInt("is_show_redpacket") == 1) {
                    z = true;
                } else {
                    z = false;
                }
                this.isShowRedPacket = z;
                if (this.mPhotoAlbum == null) {
                    this.mPhotoAlbum = new ArrayList();
                }
                this.mPhotoAlbum.clear();
                hh5 hh5Var = new hh5();
                hh5Var.d(getPortraitH());
                hh5Var.f(getPortrait());
                hh5Var.e(true);
                this.mPhotoAlbum.add(hh5Var);
                JSONArray optJSONArray = jSONObject.optJSONArray("user_pics");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            hh5 hh5Var2 = new hh5();
                            hh5Var2.d(jSONObject2.optString("big"));
                            hh5Var2.f(jSONObject2.optString("small"));
                            hh5Var2.e(false);
                            this.mPhotoAlbum.add(hh5Var2);
                        }
                    }
                }
                if (this.mPhotoAlbum.size() > 9) {
                    this.mPhotoAlbum = this.mPhotoAlbum.subList(0, 8);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("likeForum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject optJSONObject6 = optJSONArray2.optJSONObject(i2);
                        if (optJSONObject6 != null) {
                            MyLikeForum myLikeForum = new MyLikeForum();
                            myLikeForum.parseJson(optJSONObject6);
                            this.mLikeForum.add(myLikeForum);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("groupList");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        JSONObject optJSONObject7 = optJSONArray3.optJSONObject(i3);
                        if (optJSONObject7 != null) {
                            MyGroup myGroup = new MyGroup();
                            myGroup.parseJson(optJSONObject7);
                            this.mGroup.add(myGroup);
                        }
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("gift_list");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        JSONObject optJSONObject8 = optJSONArray4.optJSONObject(i4);
                        if (optJSONObject8 != null) {
                            MyGift myGift = new MyGift();
                            myGift.parseJson(optJSONObject8);
                            this.mGift.add(myGift);
                        }
                    }
                }
                JSONObject optJSONObject9 = jSONObject.optJSONObject("ala_info");
                if (optJSONObject9 != null) {
                    this.liveLevel = optJSONObject9.optInt("level_id");
                    this.liveLevelExp = optJSONObject9.optInt("level_exp");
                    this.liveStatus = optJSONObject9.optInt(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS);
                    this.liveId = optJSONObject9.optString("live_id");
                    AlaUserInfoData alaUserInfoData = (AlaUserInfoData) OrmObject.objectWithJson(jSONObject.optJSONObject("ala_info"), AlaUserInfoData.class);
                    this.alaUserData = alaUserInfoData;
                    if (StringUtils.isNull(alaUserInfoData.sex)) {
                        this.alaUserData.sex = StringHelper.getUserDescByGender(this.sex);
                    }
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("birthday_info");
                if (optJSONObject10 != null) {
                    t45 t45Var = new t45();
                    this.mBirthdayInfo = t45Var;
                    t45Var.a(optJSONObject10);
                }
                this.mTiebaUid = jSONObject.optString("tieba_uid");
                this.isBlocked = jSONObject.optInt("is_blocked");
                this.canChat = jSONObject.optInt("can_chat");
                JSONObject optJSONObject11 = jSONObject.optJSONObject("shake_ad_switch");
                if (optJSONObject11 != null) {
                    ShakeAdSwitchData shakeAdSwitchData = new ShakeAdSwitchData();
                    this.mShakeAdSwitch = shakeAdSwitchData;
                    shakeAdSwitchData.parseJson(optJSONObject11);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.data.MetaData
    public void parserProtobuf(User user) {
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048638, this, user) != null) || user == null) {
            return;
        }
        super.parserProtobuf(user);
        this.favoriteNum = user.favorite_num.intValue();
        this.ip = user.ip;
        this.BDUSS = user.BDUSS;
        this.sex = user.sex.intValue();
        this.like_bars = user.my_like_num.intValue();
        this.intro = user.intro;
        int intValue = user.has_concerned.intValue();
        this.have_attention = intValue;
        setLikeStatus(intValue);
        this.password = user.passwd;
        this.posts_num = user.post_num.intValue();
        this.tb_age = user.tb_age;
        this.managerLevel = user.is_manager.intValue();
        this.markCount = user.bookmark_count.intValue();
        this.newMarkCount = user.bookmark_new_count.intValue();
        this.visitorNum = user.visitor_num.intValue();
        this.themeMyTab = user.theme_my_tab;
        setUserType(user.user_type.intValue());
        boolean z4 = false;
        if (user.has_bottle_enter.intValue() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isShowDriftingBottle = z;
        this.isOfficialAccount = user.is_guanfang.intValue();
        if (this.mPhotoAlbum == null) {
            this.mPhotoAlbum = new ArrayList();
        }
        this.mPhotoAlbum.clear();
        hh5 hh5Var = new hh5();
        hh5Var.d(getPortraitH());
        hh5Var.f(getPortrait());
        hh5Var.e(true);
        this.mPhotoAlbum.add(hh5Var);
        List<UserPics> list = user.user_pics;
        if (list != null && list.size() > 0) {
            for (UserPics userPics : user.user_pics) {
                if (userPics != null) {
                    hh5 hh5Var2 = new hh5();
                    hh5Var2.d(userPics.big);
                    hh5Var2.f(userPics.small);
                    hh5Var2.e(false);
                    this.mPhotoAlbum.add(hh5Var2);
                }
            }
        }
        if (this.mPhotoAlbum.size() > 9) {
            this.mPhotoAlbum = this.mPhotoAlbum.subList(0, 8);
        }
        if (user.is_manager.intValue() == 1) {
            this.isManager = true;
        } else {
            this.isManager = false;
        }
        Integer num = user.is_mem;
        if (num != null) {
            this.is_mem = num.intValue();
        }
        UserVipInfo userVipInfo = user.vipInfo;
        if (userVipInfo != null) {
            UserVipInfoData userVipInfoData = new UserVipInfoData();
            this.vipInfo = userVipInfoData;
            userVipInfoData.parserProtobuf(userVipInfo);
        }
        VipShowInfo vipShowInfo = user.vip_show_info;
        if (vipShowInfo != null) {
            MembershipUserInfo membershipUserInfo = new MembershipUserInfo();
            this.membershipInfo = membershipUserInfo;
            membershipUserInfo.parserProtobuf(vipShowInfo);
        }
        VipCloseAd vipCloseAd = user.vip_close_ad;
        if (vipCloseAd != null) {
            CloseAdData closeAdData = new CloseAdData();
            this.closeAdData = closeAdData;
            closeAdData.W(vipCloseAd);
        }
        this.bg_pic = user.bg_pic;
        this.bimg_url = user.bimg_url;
        this.dynamic_url = user.dynamic_url;
        this.bimg_end_time = user.bimg_end_time.intValue();
        this.isFriend = user.is_friend.intValue();
        PrivSets privSets = user.priv_sets;
        if (privSets != null) {
            PersonPrivateData personPrivateData = new PersonPrivateData();
            this.personPrivate = personPrivateData;
            personPrivateData.V(privSets);
        }
        PayMemberInfo payMemberInfo = user.pay_member_info;
        if (payMemberInfo != null) {
            PayMemberInfoData payMemberInfoData = new PayMemberInfoData();
            this.payMemberInfo = payMemberInfoData;
            payMemberInfoData.U(payMemberInfo);
        }
        if (user.is_mask.intValue() == 1) {
            this.isMask = true;
        } else {
            this.isMask = false;
        }
        if (user.is_select_tail.intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mIsSelectTail = z2;
        this.mGiftNum = user.gift_num.intValue();
        this.mLikeForum.clear();
        List<LikeForumInfo> list2 = user.likeForum;
        if (list2 != null) {
            for (int i = 0; i < list2.size(); i++) {
                MyLikeForum myLikeForum = new MyLikeForum();
                myLikeForum.parserProtobuf(list2.get(i));
                this.mLikeForum.add(myLikeForum);
            }
        }
        this.mGroup.clear();
        List<MyGroupInfo> list3 = user.groupList;
        if (list3 != null) {
            for (int i2 = 0; i2 < list3.size(); i2++) {
                MyGroup myGroup = new MyGroup();
                myGroup.parserProtobuf(list3.get(i2));
                this.mGroup.add(myGroup);
            }
        }
        this.mGift.clear();
        List<GiftInfo> list4 = user.gift_list;
        if (list4 != null) {
            for (int i3 = 0; i3 < list4.size(); i3++) {
                MyGift myGift = new MyGift();
                myGift.parserProtobuf(list4.get(i3));
                this.mGift.add(myGift);
            }
        }
        NewParrScores newParrScores = user.parr_scores;
        if (newParrScores == null) {
            this.mTDouNum = 0L;
        } else {
            this.mTDouNum = newParrScores.scores_total.longValue();
        }
        if (getUserId() != null && getUserId().equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = this.mTDouNum;
        }
        TwZhiBoUser twZhiBoUser = user.tw_anchor_info;
        if (twZhiBoUser != null) {
            this.anchorLevel = twZhiBoUser.anchor_level.intValue();
        }
        ActivitySponsor activitySponsor = user.activity_sponsor;
        if (activitySponsor != null) {
            ActivitySponsorData activitySponsorData = new ActivitySponsorData();
            this.mActivitySponsorData = activitySponsorData;
            activitySponsorData.U(activitySponsor);
        }
        AlaUserInfo alaUserInfo = user.ala_info;
        if (alaUserInfo != null) {
            this.liveLevel = alaUserInfo.level_id.intValue();
            this.liveLevelExp = user.ala_info.level_exp.longValue();
            this.liveStatus = user.ala_info.live_status.intValue();
            this.liveId = Long.toString(user.ala_info.live_id.longValue());
            AlaUserInfoData alaUserInfoData = new AlaUserInfoData();
            this.alaUserData = alaUserInfoData;
            alaUserInfoData.parserProtobuf(user.ala_info);
            if (StringUtils.isNull(this.alaUserData.sex)) {
                this.alaUserData.sex = StringHelper.getUserDescByGender(this.sex);
            }
        }
        if (user.is_invited.intValue() == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.isGodInvited = z3;
        this.privateThread = user.priv_thread.intValue();
        if (user.is_show_redpacket.intValue() == 1) {
            z4 = true;
        }
        this.isShowRedPacket = z4;
        BirthdayInfo birthdayInfo = user.birthday_info;
        if (birthdayInfo != null) {
            t45 t45Var = new t45();
            this.mBirthdayInfo = t45Var;
            t45Var.b(birthdayInfo);
        }
        this.bawuThrones = user.bawu_thrones;
        this.showPbPrivateFlag = user.show_pb_private_flag.intValue();
        this.mTiebaUid = user.tieba_uid;
        if (user.shake_ad_switch != null) {
            ShakeAdSwitchData shakeAdSwitchData = new ShakeAdSwitchData();
            this.mShakeAdSwitch = shakeAdSwitchData;
            shakeAdSwitchData.parserProtobuf(user.shake_ad_switch);
        }
    }
}
