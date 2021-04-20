package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupLevelActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import d.b.c.j.e.n;
import d.b.h0.r.q.g2;
import d.b.h0.t.o;
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
import tbclient.TwZhiBoUser;
import tbclient.User;
import tbclient.UserPics;
import tbclient.UserVipInfo;
import tbclient.VipCloseAd;
import tbclient.VipShowInfo;
/* loaded from: classes3.dex */
public class UserData extends MetaData {
    public static final int USER_PICS_MAX_COUNT = 9;
    public static final long serialVersionUID = -1871115639893992930L;
    public String BDUSS;
    public int anchorLevel;
    public BawuThrones bawuThrones;
    public String bg_pic;
    public int bimg_end_time;
    public String bimg_url;
    public CloseAdData closeAdData;
    public String grade;
    public int have_attention;
    public long inTime;
    public String intro;
    public String ip;
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
    public g2 mBirthdayInfo;
    public List<MyGift> mGift;
    public int mGiftNum;
    public List<MyGroup> mGroup;
    public boolean mIsSelectTail;
    public List<MyLikeForum> mLikeForum;
    public List<n> mPhotoAlbum;
    public long mTDouNum;
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
    public int sex;
    public int showPbPrivateFlag;
    public UserTbVipInfoData tbVipInfo;
    public String tb_age;
    public int userType;
    public UserVipInfoData vipInfo;
    public int visitorNum;

    /* loaded from: classes3.dex */
    public static class Permission extends OrmObject implements Serializable {
        public static final int TRUE = 1;
        public static final long serialVersionUID = -661968182172681650L;
        public int isGroupManager;
        public int isGroupOwner;

        public boolean getIsGroupManager() {
            return this.isGroupManager == 1;
        }

        public boolean getIsGroupOwner() {
            return this.isGroupOwner == 1;
        }

        public boolean isController() {
            return getIsGroupManager() || getIsGroupOwner();
        }

        public void setIsGroupManager(int i) {
            this.isGroupManager = i;
        }

        public void setIsGroupOwner(int i) {
            this.isGroupOwner = i;
        }
    }

    public UserData() {
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

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public String getBDUSS() {
        return this.BDUSS;
    }

    public String getBg_pic() {
        return this.bg_pic;
    }

    public int getBimg_end_time() {
        return this.bimg_end_time;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public g2 getBirthdayInfo() {
        return this.mBirthdayInfo;
    }

    public CloseAdData getCloseAdData() {
        return this.closeAdData;
    }

    public List<MyGift> getGift() {
        return this.mGift;
    }

    @Override // com.baidu.tbadk.data.MetaData
    public int getGiftNum() {
        return this.mGiftNum;
    }

    public String getGrade() {
        return this.grade;
    }

    public List<MyGroup> getGroup() {
        return this.mGroup;
    }

    public int getHave_attention() {
        return this.have_attention;
    }

    public long getInTime() {
        return this.inTime;
    }

    public String getIntro() {
        return this.intro;
    }

    public String getIp() {
        return this.ip;
    }

    public int getIsFriend() {
        return this.isFriend;
    }

    public boolean getIsGodInvited() {
        return this.isGodInvited;
    }

    @Override // com.baidu.tbadk.data.MetaData
    public int getIsMem() {
        return this.is_mem;
    }

    public int getIsOfficialAccount() {
        return this.isOfficialAccount;
    }

    public boolean getIsSelectTail() {
        return this.mIsSelectTail;
    }

    public long getLastReplyTime() {
        return this.lastReplyTime;
    }

    public String getLat() {
        return this.lat;
    }

    public List<MyLikeForum> getLikeForum() {
        return this.mLikeForum;
    }

    public int getLike_bars() {
        return this.like_bars;
    }

    public String getLiveId() {
        return this.liveId;
    }

    public int getLiveLevel() {
        return this.liveLevel;
    }

    public long getLiveLevelExp() {
        return this.liveLevelExp;
    }

    public int getLiveStatus() {
        return this.liveStatus;
    }

    public String getLng() {
        return this.lng;
    }

    public long getLoginTime() {
        return this.loginTime;
    }

    public String getPassword() {
        return this.password;
    }

    public PayMemberInfoData getPayMemberInfoData() {
        return this.payMemberInfo;
    }

    public Permission getPermission() {
        return this.permission;
    }

    public PersonPrivateData getPersonPrivate() {
        return this.personPrivate;
    }

    public List<n> getPhotoAlbum() {
        return this.mPhotoAlbum;
    }

    public String getPosition() {
        return this.position;
    }

    public int getPosts_num() {
        return this.posts_num;
    }

    public int getPrivateThread() {
        return this.privateThread;
    }

    public int getSex() {
        return this.sex;
    }

    public long getTDouNum() {
        return this.mTDouNum;
    }

    public String getTb_age() {
        return this.tb_age;
    }

    public int getUserType() {
        return this.userType;
    }

    public UserVipInfoData getUserVipInfo() {
        return this.vipInfo;
    }

    public int getVisitorNum() {
        return this.visitorNum;
    }

    public boolean isBawu() {
        int i = this.managerLevel;
        return i == 1 || i == 2;
    }

    public boolean isLike() {
        return this.have_attention == 1;
    }

    public boolean isMask() {
        return this.isMask;
    }

    public boolean isShowDriftingBottle() {
        return this.isShowDriftingBottle;
    }

    @Override // com.baidu.tbadk.data.MetaData
    public void parserJson(String str) {
        super.parserJson(str);
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    @Override // com.baidu.tbadk.data.MetaData
    public void parserProtobuf(User user) {
        if (user == null) {
            return;
        }
        super.parserProtobuf(user);
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
        setUserType(user.user_type.intValue());
        this.isShowDriftingBottle = user.has_bottle_enter.intValue() == 1;
        this.isOfficialAccount = user.is_guanfang.intValue();
        if (this.mPhotoAlbum == null) {
            this.mPhotoAlbum = new ArrayList();
        }
        this.mPhotoAlbum.clear();
        o oVar = new o();
        oVar.g(getPortraitH());
        oVar.k(getPortrait());
        oVar.j(true);
        this.mPhotoAlbum.add(oVar);
        List<UserPics> list = user.user_pics;
        if (list != null && list.size() > 0) {
            for (UserPics userPics : user.user_pics) {
                if (userPics != null) {
                    o oVar2 = new o();
                    oVar2.g(userPics.big);
                    oVar2.k(userPics.small);
                    oVar2.j(false);
                    this.mPhotoAlbum.add(oVar2);
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
            closeAdData.u(vipCloseAd);
        }
        this.bg_pic = user.bg_pic;
        this.bimg_url = user.bimg_url;
        this.bimg_end_time = user.bimg_end_time.intValue();
        this.isFriend = user.is_friend.intValue();
        PrivSets privSets = user.priv_sets;
        if (privSets != null) {
            PersonPrivateData personPrivateData = new PersonPrivateData();
            this.personPrivate = personPrivateData;
            personPrivateData.t(privSets);
        }
        PayMemberInfo payMemberInfo = user.pay_member_info;
        if (payMemberInfo != null) {
            PayMemberInfoData payMemberInfoData = new PayMemberInfoData();
            this.payMemberInfo = payMemberInfoData;
            payMemberInfoData.v(payMemberInfo);
        }
        if (user.is_mask.intValue() == 1) {
            this.isMask = true;
        } else {
            this.isMask = false;
        }
        this.mIsSelectTail = user.is_select_tail.intValue() == 1;
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
            activitySponsorData.s(activitySponsor);
        }
        AlaUserInfo alaUserInfo = user.ala_info;
        if (alaUserInfo != null) {
            this.liveLevel = alaUserInfo.level_id.intValue();
            this.liveLevelExp = user.ala_info.level_exp.longValue();
            this.liveStatus = user.ala_info.live_status.intValue();
            this.liveId = Long.toString(user.ala_info.live_id.longValue());
            AlaUserInfoData alaUserInfoData = new AlaUserInfoData();
            this.alaUserData = alaUserInfoData;
            alaUserInfoData.s(user.ala_info);
            if (StringUtils.isNull(this.alaUserData.sex)) {
                this.alaUserData.sex = StringHelper.getUserDescByGender(this.sex);
            }
        }
        this.isGodInvited = user.is_invited.intValue() == 1;
        this.privateThread = user.priv_thread.intValue();
        this.isShowRedPacket = user.is_show_redpacket.intValue() == 1;
        BirthdayInfo birthdayInfo = user.birthday_info;
        if (birthdayInfo != null) {
            g2 g2Var = new g2();
            this.mBirthdayInfo = g2Var;
            g2Var.b(birthdayInfo);
        }
        this.bawuThrones = user.bawu_thrones;
        this.showPbPrivateFlag = user.show_pb_private_flag.intValue();
    }

    public void setBDUSS(String str) {
        this.BDUSS = str;
    }

    public void setBg_pic(String str) {
        this.bg_pic = str;
    }

    public void setBimg_end_time(int i) {
        this.bimg_end_time = i;
    }

    public void setBimg_url(String str) {
        this.bimg_url = str;
    }

    public void setGift(List<MyGift> list) {
        this.mGift = list;
    }

    @Override // com.baidu.tbadk.data.MetaData
    public void setGiftNum(int i) {
        this.mGiftNum = i;
    }

    public void setGrade(String str) {
        this.grade = str;
    }

    public void setGroup(List<MyGroup> list) {
        this.mGroup = list;
    }

    public void setHave_attention(int i) {
        setLikeStatus(i);
    }

    public void setInTime(long j) {
        this.inTime = j;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setIsFriend(int i) {
        this.isFriend = i;
    }

    public void setIsMem(int i) {
        this.is_mem = i;
    }

    public void setLastReplyTime(long j) {
        this.lastReplyTime = j;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public void setLike(boolean z) {
        if (z) {
            this.have_attention = 1;
        } else {
            this.have_attention = 0;
        }
    }

    public void setLikeForum(List<MyLikeForum> list) {
        this.mLikeForum = list;
    }

    @Override // com.baidu.tbadk.data.MetaData, d.b.h0.r.f0.q.a
    public void setLikeStatus(int i) {
        super.setLikeStatus(i);
        this.have_attention = i;
    }

    public void setLike_bars(int i) {
        this.like_bars = i;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public void setLoginTime(long j) {
        this.loginTime = j;
    }

    public void setMask(boolean z) {
        this.isMask = z;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public void setPosts_num(int i) {
        this.posts_num = i;
    }

    public void setPrivateThread(int i) {
        this.privateThread = i;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setTb_age(String str) {
        this.tb_age = str;
    }

    public void setUserType(int i) {
        this.userType = i;
    }

    public boolean showPbPrivate() {
        return this.showPbPrivateFlag == 1;
    }

    @Override // com.baidu.tbadk.data.MetaData
    public void parserJson(JSONObject jSONObject) {
        try {
            super.parserJson(jSONObject);
            if (jSONObject == null) {
                return;
            }
            this.ip = jSONObject.optString("ip");
            this.BDUSS = jSONObject.optString(HttpRequest.BDUSS);
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
            int optInt2 = jSONObject.optInt("has_concerned");
            this.have_attention = optInt2;
            setLikeStatus(optInt2);
            this.password = jSONObject.optString("passwd");
            this.posts_num = jSONObject.optInt("post_num", 0);
            this.tb_age = jSONObject.optString("tb_age");
            int optInt3 = jSONObject.optInt("is_manager", 0);
            this.isOfficialAccount = jSONObject.optInt("is_guanfang", 0);
            if (optInt3 == 1) {
                this.isManager = true;
            } else {
                this.isManager = false;
            }
            this.bg_pic = jSONObject.optString("bg_pic");
            this.bimg_url = jSONObject.optString("bimg_url");
            this.bimg_end_time = jSONObject.optInt("bimg_end_time", 0);
            this.is_mem = jSONObject.optInt(GroupLevelActivityConfig.IS_MEM);
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
            this.isShowRedPacket = jSONObject.getInt("is_show_redpacket") == 1;
            if (this.mPhotoAlbum == null) {
                this.mPhotoAlbum = new ArrayList();
            }
            this.mPhotoAlbum.clear();
            o oVar = new o();
            oVar.g(getPortraitH());
            oVar.k(getPortrait());
            oVar.j(true);
            this.mPhotoAlbum.add(oVar);
            JSONArray optJSONArray = jSONObject.optJSONArray("user_pics");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        o oVar2 = new o();
                        oVar2.g(jSONObject2.optString("big"));
                        oVar2.k(jSONObject2.optString("small"));
                        oVar2.j(false);
                        this.mPhotoAlbum.add(oVar2);
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
            if (optJSONObject9 == null) {
                return;
            }
            this.liveLevel = optJSONObject9.optInt("level_id");
            this.liveLevelExp = optJSONObject9.optInt("level_exp");
            this.liveStatus = optJSONObject9.optInt(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS);
            this.liveId = optJSONObject9.optString("live_id");
            AlaUserInfoData alaUserInfoData = (AlaUserInfoData) OrmObject.objectWithJson(jSONObject.optJSONObject("ala_info"), AlaUserInfoData.class);
            this.alaUserData = alaUserInfoData;
            if (StringUtils.isNull(alaUserInfoData.sex)) {
                this.alaUserData.sex = StringHelper.getUserDescByGender(this.sex);
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("birthday_info");
            if (optJSONObject10 != null) {
                g2 g2Var = new g2();
                this.mBirthdayInfo = g2Var;
                g2Var.a(optJSONObject10);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public UserData(long j, String str, String str2, int i) {
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
}
