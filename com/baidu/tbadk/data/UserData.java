package com.baidu.tbadk.data;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.GroupLevelActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.GiftInfo;
import tbclient.LikeForumInfo;
import tbclient.MyGroupInfo;
import tbclient.NewParrScores;
import tbclient.PayMemberInfo;
import tbclient.PrivSets;
import tbclient.User;
import tbclient.UserPics;
import tbclient.UserVipInfo;
import tbclient.VipShowInfo;
/* loaded from: classes.dex */
public class UserData extends MetaData {
    private static final long serialVersionUID = -1871115639893992930L;
    private String BDUSS;
    private int anchorLevel;
    private String bg_pic;
    private int bimg_end_time;
    private String bimg_url;
    private String grade;
    private int have_attention;
    private long inTime;
    private String intro;
    private String ip;
    private int isFriend;
    private boolean isManager;
    private boolean isMask;
    private int isOfficialAccount;
    private int is_mem;
    private long lastReplyTime;
    private String lat;
    private int like_bars;
    private String lng;
    private long loginTime;
    private List<MyGift> mGift;
    private int mGiftNum;
    private List<MyGroup> mGroup;
    private boolean mIsSelectTail;
    private List<MyLikeForum> mLikeForum;
    private List<g> mPhotoAlbum;
    private long mTDouNum;
    private int managerLevel;
    private int markCount;
    private MembershipUserInfo membershipInfo;
    private int newMarkCount;
    private String password;
    private e payMemberInfo;
    private Permission permission;
    private f personPrivate;
    private String position;
    private int posts_num;
    private int sex;
    private String tb_age;
    private int userType;
    private UserVipInfoData vipInfo;

    public int getMarkCount() {
        return this.markCount;
    }

    public void setMarkCount(int i) {
        this.markCount = i;
    }

    public int getNewMarkCount() {
        return this.newMarkCount;
    }

    public void setNewMarkCount(int i) {
        this.newMarkCount = i;
    }

    public f getPersonPrivate() {
        return this.personPrivate;
    }

    public void setPersonPrivate(f fVar) {
        this.personPrivate = fVar;
    }

    public List<MyLikeForum> getLikeForum() {
        return this.mLikeForum;
    }

    public void setLikeForum(List<MyLikeForum> list) {
        this.mLikeForum = list;
    }

    public MembershipUserInfo getMembershipUserInfo() {
        return this.membershipInfo;
    }

    public void setMembershipUserInfo(MembershipUserInfo membershipUserInfo) {
        this.membershipInfo = membershipUserInfo;
    }

    public List<MyGroup> getGroup() {
        return this.mGroup;
    }

    public void setGroup(List<MyGroup> list) {
        this.mGroup = list;
    }

    public List<MyGift> getGift() {
        return this.mGift;
    }

    public void setGift(List<MyGift> list) {
        this.mGift = list;
    }

    @Override // com.baidu.tbadk.data.MetaData
    public void setGiftNum(int i) {
        this.mGiftNum = i;
    }

    @Override // com.baidu.tbadk.data.MetaData
    public int getGiftNum() {
        return this.mGiftNum;
    }

    public String getTb_age() {
        return this.tb_age;
    }

    public void setTb_age(String str) {
        this.tb_age = str;
    }

    @Override // com.baidu.tbadk.data.MetaData
    public int getIsMem() {
        return this.is_mem;
    }

    public void setIsMem(int i) {
        this.is_mem = i;
    }

    public UserVipInfoData getUserVipInfo() {
        return this.vipInfo;
    }

    public int getIsFriend() {
        return this.isFriend;
    }

    public void setIsFriend(int i) {
        this.isFriend = i;
    }

    public String getGrade() {
        return this.grade;
    }

    public void setGrade(String str) {
        this.grade = str;
    }

    public boolean getIsSelectTail() {
        return this.mIsSelectTail;
    }

    public void setIsSelectTail(boolean z) {
        this.mIsSelectTail = z;
    }

    public UserData() {
        this.password = null;
        this.isManager = false;
        this.isMask = false;
        this.mLikeForum = new ArrayList();
        this.mGroup = new ArrayList();
        this.mGift = new ArrayList();
        this.mPhotoAlbum = new ArrayList();
        this.ip = null;
        this.BDUSS = null;
        this.like_bars = 0;
        this.sex = 1;
        this.intro = null;
        this.posts_num = 0;
        setHave_attention(0);
        this.tb_age = "";
        this.markCount = 0;
        this.newMarkCount = 0;
        this.anchorLevel = 0;
    }

    public UserData(long j, String str, String str2, int i) {
        this.password = null;
        this.isManager = false;
        this.isMask = false;
        this.mLikeForum = new ArrayList();
        this.mGroup = new ArrayList();
        this.mGift = new ArrayList();
        this.mPhotoAlbum = new ArrayList();
        setUserId(String.valueOf(j));
        setUserName(str);
        setPortrait(str2);
        this.sex = i;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void setAnchorLevel(int i) {
        this.anchorLevel = i;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public boolean getIsManager() {
        return this.isManager;
    }

    public String getIp() {
        return this.ip;
    }

    public String getPassword() {
        return this.password;
    }

    @Override // com.baidu.tbadk.data.MetaData
    public void parserProtobuf(User user) {
        if (user != null) {
            super.parserProtobuf(user);
            this.ip = user.ip;
            this.BDUSS = user.BDUSS;
            this.sex = user.sex.intValue();
            this.like_bars = user.my_like_num.intValue();
            this.intro = user.intro;
            this.have_attention = user.has_concerned.intValue();
            this.password = user.passwd;
            this.posts_num = user.post_num.intValue();
            this.tb_age = user.tb_age;
            this.managerLevel = user.is_manager.intValue();
            this.markCount = user.bookmark_count.intValue();
            this.newMarkCount = user.bookmark_new_count.intValue();
            this.isOfficialAccount = user.is_guanfang.intValue();
            if (this.mPhotoAlbum == null) {
                this.mPhotoAlbum = new ArrayList();
            }
            this.mPhotoAlbum.clear();
            g gVar = new g();
            gVar.eS(getPortraitH());
            gVar.eT(getPortrait());
            gVar.bd(true);
            this.mPhotoAlbum.add(gVar);
            if (user.user_pics != null && user.user_pics.size() > 0) {
                for (UserPics userPics : user.user_pics) {
                    if (userPics != null) {
                        g gVar2 = new g();
                        gVar2.eS(userPics.big);
                        gVar2.eT(userPics.small);
                        gVar2.bd(false);
                        this.mPhotoAlbum.add(gVar2);
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
            if (user.is_mem != null) {
                this.is_mem = user.is_mem.intValue();
            }
            UserVipInfo userVipInfo = user.vipInfo;
            if (userVipInfo != null) {
                this.vipInfo = new UserVipInfoData();
                this.vipInfo.parserProtobuf(userVipInfo);
            }
            VipShowInfo vipShowInfo = user.vip_show_info;
            if (vipShowInfo != null) {
                this.membershipInfo = new MembershipUserInfo();
                this.membershipInfo.parserProtobuf(vipShowInfo);
            }
            this.bg_pic = user.bg_pic;
            this.bimg_url = user.bimg_url;
            this.bimg_end_time = user.bimg_end_time.intValue();
            this.isFriend = user.is_friend.intValue();
            PrivSets privSets = user.priv_sets;
            if (privSets != null) {
                this.personPrivate = new f();
                this.personPrivate.a(privSets);
            }
            PayMemberInfo payMemberInfo = user.pay_member_info;
            if (payMemberInfo != null) {
                this.payMemberInfo = new e();
                this.payMemberInfo.a(payMemberInfo);
            }
            if (user.is_mask.intValue() == 1) {
                this.isMask = true;
            } else {
                this.isMask = false;
            }
            this.mIsSelectTail = user.is_select_tail.intValue() == 1;
            this.mGiftNum = user.gift_num.intValue();
            this.mLikeForum.clear();
            List<LikeForumInfo> list = user.likeForum;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    MyLikeForum myLikeForum = new MyLikeForum();
                    myLikeForum.parserProtobuf(list.get(i));
                    this.mLikeForum.add(myLikeForum);
                }
            }
            this.mGroup.clear();
            List<MyGroupInfo> list2 = user.groupList;
            if (list2 != null) {
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    MyGroup myGroup = new MyGroup();
                    myGroup.parserProtobuf(list2.get(i2));
                    this.mGroup.add(myGroup);
                }
            }
            this.mGift.clear();
            List<GiftInfo> list3 = user.gift_list;
            if (list3 != null) {
                for (int i3 = 0; i3 < list3.size(); i3++) {
                    MyGift myGift = new MyGift();
                    myGift.parserProtobuf(list3.get(i3));
                    this.mGift.add(myGift);
                }
            }
            NewParrScores newParrScores = user.parr_scores;
            if (newParrScores != null) {
                this.mTDouNum = newParrScores.scores_total.longValue();
            }
            if (user.tw_anchor_info != null) {
                this.anchorLevel = user.tw_anchor_info.anchor_level.intValue();
            }
        }
    }

    public boolean isBawu() {
        return this.managerLevel == 1 || this.managerLevel == 2;
    }

    @Override // com.baidu.tbadk.data.MetaData
    public void parserJson(String str) {
        super.parserJson(str);
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.data.MetaData
    public void parserJson(JSONObject jSONObject) {
        try {
            super.parserJson(jSONObject);
            if (jSONObject != null) {
                this.ip = jSONObject.optString("ip");
                this.BDUSS = jSONObject.optString("BDUSS");
                this.sex = jSONObject.optInt(MyGiftListActivityConfig.USER_SEX, 1);
                if (this.sex != 2 && this.sex != 1) {
                    this.sex = 1;
                }
                this.like_bars = jSONObject.optInt("my_like_num");
                this.intro = jSONObject.optString("intro");
                this.isFriend = jSONObject.optInt("is_friend");
                this.markCount = jSONObject.optInt("bookmark_count");
                this.newMarkCount = jSONObject.optInt("bookmark_new_count", 0);
                this.have_attention = jSONObject.optInt("has_concerned");
                this.password = jSONObject.optString("passwd");
                this.posts_num = jSONObject.optInt("post_num", 0);
                this.tb_age = jSONObject.optString("tb_age");
                int optInt = jSONObject.optInt("is_manager", 0);
                this.isOfficialAccount = jSONObject.optInt("is_guanfang", 0);
                if (optInt == 1) {
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
                    this.vipInfo = new UserVipInfoData();
                    this.vipInfo.parseJson(optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("vip_show_info");
                if (optJSONObject2 != null) {
                    this.membershipInfo = new MembershipUserInfo();
                    this.membershipInfo.parseJson(optJSONObject2);
                }
                this.mGiftNum = jSONObject.optInt("gift_num");
                JSONObject optJSONObject3 = jSONObject.optJSONObject("priv_sets");
                if (optJSONObject3 != null) {
                    this.personPrivate = new f();
                    this.personPrivate.parserJson(optJSONObject3);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("pay_member_info");
                if (optJSONObject4 != null) {
                    this.payMemberInfo = new e();
                    this.payMemberInfo.parseJson(optJSONObject4);
                }
                if (jSONObject.optInt("is_mask") == 1) {
                    this.isMask = true;
                } else {
                    this.isMask = false;
                }
                if (this.mPhotoAlbum == null) {
                    this.mPhotoAlbum = new ArrayList();
                }
                this.mPhotoAlbum.clear();
                g gVar = new g();
                gVar.eS(getPortraitH());
                gVar.eT(getPortrait());
                gVar.bd(true);
                this.mPhotoAlbum.add(gVar);
                JSONArray optJSONArray = jSONObject.optJSONArray("user_pics");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            g gVar2 = new g();
                            gVar2.eS(jSONObject2.optString("big"));
                            gVar2.eT(jSONObject2.optString("small"));
                            gVar2.bd(false);
                            this.mPhotoAlbum.add(gVar2);
                        }
                    }
                }
                if (this.mPhotoAlbum.size() > 9) {
                    this.mPhotoAlbum = this.mPhotoAlbum.subList(0, 8);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("likeForum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject optJSONObject5 = optJSONArray2.optJSONObject(i2);
                        if (optJSONObject5 != null) {
                            MyLikeForum myLikeForum = new MyLikeForum();
                            myLikeForum.parseJson(optJSONObject5);
                            this.mLikeForum.add(myLikeForum);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("groupList");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        JSONObject optJSONObject6 = optJSONArray3.optJSONObject(i3);
                        if (optJSONObject6 != null) {
                            MyGroup myGroup = new MyGroup();
                            myGroup.parseJson(optJSONObject6);
                            this.mGroup.add(myGroup);
                        }
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("gift_list");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        JSONObject optJSONObject7 = optJSONArray4.optJSONObject(i4);
                        if (optJSONObject7 != null) {
                            MyGift myGift = new MyGift();
                            myGift.parseJson(optJSONObject7);
                            this.mGift.add(myGift);
                        }
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public String getIntro() {
        return this.intro;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public String getLng() {
        return this.lng;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public long getInTime() {
        return this.inTime;
    }

    public void setInTime(long j) {
        this.inTime = j;
    }

    public long getLoginTime() {
        return this.loginTime;
    }

    public void setLoginTime(long j) {
        this.loginTime = j;
    }

    public long getLastReplyTime() {
        return this.lastReplyTime;
    }

    public void setLastReplyTime(long j) {
        this.lastReplyTime = j;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public int getSex() {
        return this.sex;
    }

    public e getPayMemberInfoData() {
        return this.payMemberInfo;
    }

    public Permission getPermission() {
        return this.permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public void setBDUSS(String str) {
        this.BDUSS = str;
    }

    public String getBDUSS() {
        return this.BDUSS;
    }

    public void setLike_bars(int i) {
        this.like_bars = i;
    }

    public int getLike_bars() {
        return this.like_bars;
    }

    public void setPosts_num(int i) {
        this.posts_num = i;
    }

    public int getPosts_num() {
        return this.posts_num;
    }

    public void setHave_attention(int i) {
        this.have_attention = i;
    }

    public int getHave_attention() {
        return this.have_attention;
    }

    public int getUserType() {
        return this.userType;
    }

    public void setUserType(int i) {
        this.userType = i;
    }

    public String getBg_pic() {
        return this.bg_pic;
    }

    public void setBg_pic(String str) {
        this.bg_pic = str;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public void setBimg_url(String str) {
        this.bimg_url = str;
    }

    public int getBimg_end_time() {
        return this.bimg_end_time;
    }

    public void setBimg_end_time(int i) {
        this.bimg_end_time = i;
    }

    public boolean isMask() {
        return this.isMask;
    }

    public void setMask(boolean z) {
        this.isMask = z;
    }

    public int getIsOfficialAccount() {
        return this.isOfficialAccount;
    }

    public void setIsOfficialAccount(int i) {
        this.isOfficialAccount = i;
    }

    public long getTDouNum() {
        return this.mTDouNum;
    }

    public void setTDouNum(long j) {
        this.mTDouNum = j;
    }

    public List<g> getPhotoAlbum() {
        return this.mPhotoAlbum;
    }

    public void setPhotoAlbum(List<g> list) {
        this.mPhotoAlbum = list;
    }

    /* loaded from: classes.dex */
    public static class Permission extends i implements Serializable {
        private static final long serialVersionUID = -661968182172681650L;
        private int isGroupManager;
        private int isGroupOwner;

        public boolean getIsGroupOwner() {
            return this.isGroupOwner == 1;
        }

        public void setIsGroupOwner(int i) {
            this.isGroupOwner = i;
        }

        public boolean getIsGroupManager() {
            return this.isGroupManager == 1;
        }

        public void setIsGroupManager(int i) {
            this.isGroupManager = i;
        }

        public boolean isController() {
            return getIsGroupManager() || getIsGroupOwner();
        }
    }
}
