package com.baidu.tbadk.data;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupLevelActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.coreExtra.data.BazhuGradeData;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.coreExtra.data.PrivSetsData;
import d.a.c.e.m.b;
import d.a.c.e.p.k;
import d.a.m0.r.f0.q.a;
import d.a.m0.t.d;
import d.a.m0.t.n;
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
public class MetaData extends OrmObject implements Serializable, a {
    public static final long serialVersionUID = -2658065756886586092L;
    public AlaInfoData alaInfo;
    public AlaUserInfoData alaUserData;
    public String appealThreadPopover;
    public d businessAccountData;
    public boolean canModifyAvatar;
    public String cantModifyAvatarDesc;
    public String fansNickName;
    public int gender;
    public String god_intro;
    public String imBjhAvatar;
    public boolean isBigV;
    public boolean isDefaultAvatar;
    public boolean isGod;
    public boolean isMask;
    public int is_manager;
    public int is_myfans;
    public int is_myfriend;
    public LiveRoomInfo liveRoomInfo;
    public n pendantData;
    public int rankInfluence;
    public String rankNum;
    public String virtualUserUrl;
    public boolean isLikeStatusFromNet = true;
    public int is_like = 0;
    public int likeStatus = 0;
    public GodUserData godUserData = new GodUserData();
    public UserTbVipInfoData bigVData = new UserTbVipInfoData();
    public NewGodData mNewGodData = new NewGodData();
    public BazhuGradeData mBazhuGrade = new BazhuGradeData();
    public PrivSetsData privSetsData = new PrivSetsData();
    public String userId = null;
    public int type = 0;
    public int level_id = 0;
    public String userName = null;
    public String uk = null;
    public String name_show = null;
    public String portrait = null;
    public String portraith = null;
    public ArrayList<IconData> mIconInfo = new ArrayList<>();
    public ArrayList<IconData> mTShowIconInfo = new ArrayList<>();
    public ArrayList<IconData> mTShowIconInfoNew = new ArrayList<>();
    public int is_bawu = 0;
    public String bawu_type = null;
    public int concernNum = 0;
    public int fansNum = 0;
    public int threadNum = -1;
    public int likeNum = -1;
    public boolean mHadConcerned = false;
    @Deprecated
    public GodInfo godInfo = null;
    public int giftNum = 0;
    public int isMem = 0;
    public ThemeCardInUserData themeCard = new ThemeCardInUserData();
    public String sealPrefix = null;
    public int left_call_num = 0;
    public BaijiahaoInfo baijiahaoInfo = null;
    public List<ForumToolPerm> forumToolAuth = new ArrayList();
    public String tiebaUid = null;
    public List<BazhuGradeData> managerForum = new ArrayList();

    private void testBaijiahaoInfo() {
        BaijiahaoInfo.Builder builder = new BaijiahaoInfo.Builder();
        builder.auth_id = 1;
        builder.auth_desc = "专家";
        this.baijiahaoInfo = builder.build(true);
    }

    public boolean canModifyAvatar() {
        return this.canModifyAvatar;
    }

    public AlaInfoData getAlaInfo() {
        return this.alaInfo;
    }

    public AlaUserInfoData getAlaUserData() {
        return this.alaUserData;
    }

    public String getAppealThreadPopover() {
        return this.appealThreadPopover;
    }

    public String getAvatarH() {
        BaijiahaoInfo baijiahaoInfo = this.baijiahaoInfo;
        if (baijiahaoInfo != null && !TextUtils.isEmpty(baijiahaoInfo.avatar_h)) {
            return this.baijiahaoInfo.avatar_h;
        }
        return this.portraith;
    }

    public String getAvater() {
        BaijiahaoInfo baijiahaoInfo = this.baijiahaoInfo;
        if (baijiahaoInfo != null && !TextUtils.isEmpty(baijiahaoInfo.avatar)) {
            return this.baijiahaoInfo.avatar;
        }
        if (!TextUtils.isEmpty(this.imBjhAvatar)) {
            return this.imBjhAvatar;
        }
        return this.portrait;
    }

    public BaijiahaoInfo getBaijiahaoInfo() {
        return this.baijiahaoInfo;
    }

    public String getBawu_type() {
        return this.bawu_type;
    }

    public BazhuGradeData getBazhuGradeData() {
        return this.mBazhuGrade;
    }

    public d getBusinessAccountData() {
        return this.businessAccountData;
    }

    public String getCantModifyAvatarDesc() {
        return this.cantModifyAvatarDesc;
    }

    public int getConcernNum() {
        return this.concernNum;
    }

    public int getConcern_num() {
        return this.concernNum;
    }

    public String getFansNickName() {
        return this.fansNickName;
    }

    @Override // d.a.m0.r.f0.q.a
    public int getFansNum() {
        return this.fansNum;
    }

    public List<ForumToolPerm> getForumToolAuth() {
        return this.forumToolAuth;
    }

    public int getGender() {
        return this.gender;
    }

    public int getGiftNum() {
        return this.giftNum;
    }

    @Deprecated
    public GodInfo getGodInfo() {
        return this.godInfo;
    }

    public String getGodIntro() {
        return this.god_intro;
    }

    public GodUserData getGodUserData() {
        return this.godUserData;
    }

    public ArrayList<IconData> getIconInfo() {
        return this.mIconInfo;
    }

    public String getImBjhAvatar() {
        if (!TextUtils.isEmpty(this.imBjhAvatar)) {
            return this.imBjhAvatar;
        }
        BaijiahaoInfo baijiahaoInfo = this.baijiahaoInfo;
        if (baijiahaoInfo != null && !TextUtils.isEmpty(baijiahaoInfo.avatar)) {
            return this.baijiahaoInfo.avatar;
        }
        return this.imBjhAvatar;
    }

    @Override // d.a.m0.r.f0.q.a
    public boolean getIsLike() {
        return isGod() ? this.godUserData.getIsLike() || this.mHadConcerned : this.is_like == 1 || this.mHadConcerned;
    }

    public int getIsMem() {
        return this.isMem;
    }

    public int getIsMyFans() {
        return this.is_myfans;
    }

    public int getIsMyFriend() {
        return this.is_myfriend;
    }

    public int getIs_bawu() {
        return this.is_bawu;
    }

    public int getIs_manager() {
        return this.is_manager;
    }

    public int getLeft_call_num() {
        return this.left_call_num;
    }

    public int getLevel_id() {
        return this.level_id;
    }

    public int getLikeNum() {
        return this.likeNum;
    }

    @Override // d.a.m0.r.f0.q.a
    public int getLikeStatus() {
        return this.likeStatus;
    }

    public LiveRoomInfo getLiveRoomInfo() {
        return this.liveRoomInfo;
    }

    public List<BazhuGradeData> getManagerForum() {
        return this.managerForum;
    }

    public String getName_show() {
        if (!StringUtils.isNull(this.name_show)) {
            return this.name_show;
        }
        return this.userName;
    }

    public NewGodData getNewGodData() {
        return this.mNewGodData;
    }

    public n getPendantData() {
        return this.pendantData;
    }

    @Override // d.a.m0.r.f0.q.a
    public String getPortrait() {
        return this.portrait;
    }

    public String getPortraitH() {
        return this.portraith;
    }

    public PrivSetsData getPrivSetsData() {
        return this.privSetsData;
    }

    public String getSealPrefix() {
        return this.sealPrefix;
    }

    public ArrayList<IconData> getTShowInfo() {
        return this.mTShowIconInfo;
    }

    public ArrayList<IconData> getTShowInfoNew() {
        return this.mTShowIconInfoNew;
    }

    public ThemeCardInUserData getThemeCard() {
        return this.themeCard;
    }

    public int getThreadNum() {
        return this.threadNum;
    }

    public String getTiebaUid() {
        return this.tiebaUid;
    }

    public int getType() {
        return this.type;
    }

    public String getUk() {
        return this.uk;
    }

    @Override // d.a.m0.r.f0.q.a
    public String getUserId() {
        return this.userId;
    }

    public long getUserIdLong() {
        return b.f(this.userId, 0L);
    }

    public String getUserName() {
        String str = this.userName;
        return (str == null || str.length() <= 0) ? "" : this.userName;
    }

    public UserTbVipInfoData getUserTbVipInfoData() {
        return this.bigVData;
    }

    public String getVirtualUserUrl() {
        return this.virtualUserUrl;
    }

    public boolean hadConcerned() {
        return this.mHadConcerned || this.is_like == 1;
    }

    public boolean isBaijiahaoUser() {
        BaijiahaoInfo baijiahaoInfo = this.baijiahaoInfo;
        return baijiahaoInfo != null && baijiahaoInfo.auth_id.intValue() > 0;
    }

    public boolean isBigV() {
        return this.isBigV;
    }

    public boolean isForumBusinessAccount() {
        d dVar = this.businessAccountData;
        return dVar != null && dVar.f54451b;
    }

    @Override // d.a.m0.r.f0.q.a
    public boolean isGod() {
        return this.isGod;
    }

    public boolean isLikeStatusFromNet() {
        return this.isLikeStatusFromNet;
    }

    public boolean isNewGod() {
        NewGodData newGodData = this.mNewGodData;
        return newGodData != null && newGodData.isNewGod();
    }

    public boolean isOfficial() {
        d dVar = this.businessAccountData;
        return dVar != null && dVar.f54450a;
    }

    public boolean isVideoGod() {
        NewGodData newGodData = this.mNewGodData;
        return newGodData != null && newGodData.isVideoGod();
    }

    public void parseFromCurrentUser() {
        if (TbadkCoreApplication.getCurrentAccountInfo() == null) {
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
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void parserProtobuf(User user) {
        if (user == null) {
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
        this.portrait = user.portrait;
        this.portraith = user.portraith;
        List<Icon> list = user.iconinfo;
        List<TshowInfo> list2 = user.tshow_icon;
        List<TshowInfo> list3 = user.new_tshow_icon;
        this.isMem = user.is_mem.intValue();
        this.mIconInfo.clear();
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                IconData iconData = new IconData();
                iconData.parserProtobuf(list.get(i2));
                this.mIconInfo.add(iconData);
            }
        }
        this.mTShowIconInfo.clear();
        if (list2 != null) {
            for (int i3 = 0; i3 < list2.size(); i3++) {
                IconData iconData2 = new IconData();
                iconData2.parserProtobuf(list2.get(i3));
                this.mTShowIconInfo.add(iconData2);
            }
        }
        this.mTShowIconInfoNew.clear();
        if (list3 != null) {
            for (int i4 = 0; i4 < list3.size(); i4++) {
                IconData iconData3 = new IconData();
                iconData3.parserProtobuf(list3.get(i4));
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
            n nVar = new n();
            this.pendantData = nVar;
            nVar.c(user.pendant);
        }
        this.isLikeStatusFromNet = true;
        if (user.ala_info != null) {
            AlaUserInfoData alaUserInfoData = new AlaUserInfoData();
            this.alaUserData = alaUserInfoData;
            alaUserInfoData.w(user.ala_info);
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
            d dVar = new d();
            this.businessAccountData = dVar;
            dVar.b(user.business_account_info);
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
    }

    public void setBaijiahaoInfo(BaijiahaoInfo baijiahaoInfo) {
        this.baijiahaoInfo = baijiahaoInfo;
    }

    public void setBazhuGradeData(BazhuGradeData bazhuGradeData) {
        this.mBazhuGrade = bazhuGradeData;
    }

    public void setBusinessAccountData(d dVar) {
        this.businessAccountData = dVar;
    }

    public void setConcern_num(int i2) {
        this.concernNum = i2;
    }

    public void setFansNickName(String str) {
        this.fansNickName = str;
    }

    @Override // d.a.m0.r.f0.q.a
    public void setFansNum(int i2) {
        this.fansNum = i2;
    }

    public void setForumToolAuth(List<ForumToolPerm> list) {
        this.forumToolAuth = list;
    }

    public void setGender(int i2) {
        this.gender = i2;
    }

    public void setGiftNum(int i2) {
        this.giftNum = i2;
    }

    @Deprecated
    public void setGodInfo(GodInfo godInfo) {
        this.godInfo = godInfo;
    }

    public void setGodIntor(String str) {
        this.god_intro = str;
    }

    public void setGodUserData(GodUserData godUserData) {
        this.godUserData = godUserData;
    }

    public void setHadConcerned(boolean z) {
        this.mHadConcerned = z;
        setIsLike(z);
    }

    public void setIconInfo(ArrayList<IconData> arrayList) {
        this.mIconInfo = arrayList;
    }

    public void setImBjhAvatar(String str) {
        this.imBjhAvatar = str;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    @Override // d.a.m0.r.f0.q.a
    public void setIsFromNetWork(boolean z) {
        this.isLikeStatusFromNet = z;
        GodUserData godUserData = this.godUserData;
        if (godUserData != null) {
            godUserData.setIsFromNetWork(z);
        }
    }

    public void setIsGod(boolean z) {
        this.isGod = z;
    }

    public void setIsLike(boolean z) {
        this.is_like = z ? 1 : 0;
        this.mHadConcerned = z;
        if (isGod()) {
            this.godUserData.setIsLike(z);
        }
    }

    public void setIsManager(int i2) {
        this.is_manager = i2;
    }

    public void setLeft_call_num(int i2) {
        this.left_call_num = i2;
    }

    public void setLevel_id(int i2) {
        this.level_id = i2;
    }

    public void setLikeNum(int i2) {
        this.likeNum = i2;
    }

    @Override // d.a.m0.r.f0.q.a
    public void setLikeStatus(int i2) {
        this.likeStatus = i2;
    }

    public void setName_show(String str) {
        this.name_show = str;
    }

    public void setNewGodData(NewGodData newGodData) {
        this.mNewGodData = newGodData;
    }

    public void setPendantData(n nVar) {
        this.pendantData = nVar;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public void setPortraitH(String str) {
        this.portraith = str;
    }

    public void setPrivSetsData(PrivSetsData privSetsData) {
        this.privSetsData = privSetsData;
    }

    public void setSealPrefix(String str) {
        this.sealPrefix = str;
    }

    public void setTShowInfo(ArrayList<IconData> arrayList) {
        this.mTShowIconInfo = arrayList;
    }

    public void setTbVipInfoData(UserTbVipInfoData userTbVipInfoData) {
        this.bigVData = userTbVipInfoData;
    }

    public void setThreadNum(int i2) {
        this.threadNum = i2;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setUk(String str) {
        this.uk = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserIdLong(long j) {
        this.userId = String.valueOf(j);
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setVirtualUserUrl(String str) {
        this.virtualUserUrl = str;
    }

    public boolean showBazhuGrade() {
        BazhuGradeData bazhuGradeData;
        BaijiahaoInfo baijiahaoInfo = this.baijiahaoInfo;
        if ((baijiahaoInfo != null && baijiahaoInfo.auth_id.intValue() != 0 && !k.isEmpty(this.baijiahaoInfo.auth_desc)) || (bazhuGradeData = this.mBazhuGrade) == null || k.isEmpty(bazhuGradeData.getDesc())) {
            return false;
        }
        return (this.is_bawu == 1 && "manager".equals(this.bawu_type)) ? this.privSetsData.getBazhuShowInside() != 3 : this.privSetsData.getBazhuShowOutside() != 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0137 A[Catch: Exception -> 0x029a, TryCatch #0 {Exception -> 0x029a, blocks: (B:5:0x0005, B:7:0x0070, B:9:0x0078, B:10:0x007b, B:17:0x00bb, B:20:0x00e1, B:22:0x00e7, B:25:0x00fe, B:27:0x0104, B:30:0x011b, B:32:0x0121, B:34:0x0137, B:36:0x014e, B:37:0x0153, B:39:0x015b, B:40:0x0160, B:42:0x018a, B:44:0x0198, B:46:0x019e, B:47:0x01a0, B:49:0x01b0, B:50:0x01ed, B:52:0x01f5, B:53:0x01fa, B:55:0x0202, B:56:0x0207, B:60:0x0211, B:63:0x0227, B:64:0x022c, B:67:0x0242, B:69:0x0248, B:70:0x026b, B:72:0x0280, B:74:0x0286), top: B:79:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x014e A[Catch: Exception -> 0x029a, TryCatch #0 {Exception -> 0x029a, blocks: (B:5:0x0005, B:7:0x0070, B:9:0x0078, B:10:0x007b, B:17:0x00bb, B:20:0x00e1, B:22:0x00e7, B:25:0x00fe, B:27:0x0104, B:30:0x011b, B:32:0x0121, B:34:0x0137, B:36:0x014e, B:37:0x0153, B:39:0x015b, B:40:0x0160, B:42:0x018a, B:44:0x0198, B:46:0x019e, B:47:0x01a0, B:49:0x01b0, B:50:0x01ed, B:52:0x01f5, B:53:0x01fa, B:55:0x0202, B:56:0x0207, B:60:0x0211, B:63:0x0227, B:64:0x022c, B:67:0x0242, B:69:0x0248, B:70:0x026b, B:72:0x0280, B:74:0x0286), top: B:79:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x015b A[Catch: Exception -> 0x029a, TryCatch #0 {Exception -> 0x029a, blocks: (B:5:0x0005, B:7:0x0070, B:9:0x0078, B:10:0x007b, B:17:0x00bb, B:20:0x00e1, B:22:0x00e7, B:25:0x00fe, B:27:0x0104, B:30:0x011b, B:32:0x0121, B:34:0x0137, B:36:0x014e, B:37:0x0153, B:39:0x015b, B:40:0x0160, B:42:0x018a, B:44:0x0198, B:46:0x019e, B:47:0x01a0, B:49:0x01b0, B:50:0x01ed, B:52:0x01f5, B:53:0x01fa, B:55:0x0202, B:56:0x0207, B:60:0x0211, B:63:0x0227, B:64:0x022c, B:67:0x0242, B:69:0x0248, B:70:0x026b, B:72:0x0280, B:74:0x0286), top: B:79:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x018a A[Catch: Exception -> 0x029a, TryCatch #0 {Exception -> 0x029a, blocks: (B:5:0x0005, B:7:0x0070, B:9:0x0078, B:10:0x007b, B:17:0x00bb, B:20:0x00e1, B:22:0x00e7, B:25:0x00fe, B:27:0x0104, B:30:0x011b, B:32:0x0121, B:34:0x0137, B:36:0x014e, B:37:0x0153, B:39:0x015b, B:40:0x0160, B:42:0x018a, B:44:0x0198, B:46:0x019e, B:47:0x01a0, B:49:0x01b0, B:50:0x01ed, B:52:0x01f5, B:53:0x01fa, B:55:0x0202, B:56:0x0207, B:60:0x0211, B:63:0x0227, B:64:0x022c, B:67:0x0242, B:69:0x0248, B:70:0x026b, B:72:0x0280, B:74:0x0286), top: B:79:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01b0 A[Catch: Exception -> 0x029a, TryCatch #0 {Exception -> 0x029a, blocks: (B:5:0x0005, B:7:0x0070, B:9:0x0078, B:10:0x007b, B:17:0x00bb, B:20:0x00e1, B:22:0x00e7, B:25:0x00fe, B:27:0x0104, B:30:0x011b, B:32:0x0121, B:34:0x0137, B:36:0x014e, B:37:0x0153, B:39:0x015b, B:40:0x0160, B:42:0x018a, B:44:0x0198, B:46:0x019e, B:47:0x01a0, B:49:0x01b0, B:50:0x01ed, B:52:0x01f5, B:53:0x01fa, B:55:0x0202, B:56:0x0207, B:60:0x0211, B:63:0x0227, B:64:0x022c, B:67:0x0242, B:69:0x0248, B:70:0x026b, B:72:0x0280, B:74:0x0286), top: B:79:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01f5 A[Catch: Exception -> 0x029a, TryCatch #0 {Exception -> 0x029a, blocks: (B:5:0x0005, B:7:0x0070, B:9:0x0078, B:10:0x007b, B:17:0x00bb, B:20:0x00e1, B:22:0x00e7, B:25:0x00fe, B:27:0x0104, B:30:0x011b, B:32:0x0121, B:34:0x0137, B:36:0x014e, B:37:0x0153, B:39:0x015b, B:40:0x0160, B:42:0x018a, B:44:0x0198, B:46:0x019e, B:47:0x01a0, B:49:0x01b0, B:50:0x01ed, B:52:0x01f5, B:53:0x01fa, B:55:0x0202, B:56:0x0207, B:60:0x0211, B:63:0x0227, B:64:0x022c, B:67:0x0242, B:69:0x0248, B:70:0x026b, B:72:0x0280, B:74:0x0286), top: B:79:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0202 A[Catch: Exception -> 0x029a, TryCatch #0 {Exception -> 0x029a, blocks: (B:5:0x0005, B:7:0x0070, B:9:0x0078, B:10:0x007b, B:17:0x00bb, B:20:0x00e1, B:22:0x00e7, B:25:0x00fe, B:27:0x0104, B:30:0x011b, B:32:0x0121, B:34:0x0137, B:36:0x014e, B:37:0x0153, B:39:0x015b, B:40:0x0160, B:42:0x018a, B:44:0x0198, B:46:0x019e, B:47:0x01a0, B:49:0x01b0, B:50:0x01ed, B:52:0x01f5, B:53:0x01fa, B:55:0x0202, B:56:0x0207, B:60:0x0211, B:63:0x0227, B:64:0x022c, B:67:0x0242, B:69:0x0248, B:70:0x026b, B:72:0x0280, B:74:0x0286), top: B:79:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0280 A[Catch: Exception -> 0x029a, LOOP:4: B:72:0x0280->B:75:0x0297, LOOP_START, PHI: r2 
      PHI: (r2v1 int) = (r2v0 int), (r2v2 int) binds: [B:71:0x027e, B:75:0x0297] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x029a, blocks: (B:5:0x0005, B:7:0x0070, B:9:0x0078, B:10:0x007b, B:17:0x00bb, B:20:0x00e1, B:22:0x00e7, B:25:0x00fe, B:27:0x0104, B:30:0x011b, B:32:0x0121, B:34:0x0137, B:36:0x014e, B:37:0x0153, B:39:0x015b, B:40:0x0160, B:42:0x018a, B:44:0x0198, B:46:0x019e, B:47:0x01a0, B:49:0x01b0, B:50:0x01ed, B:52:0x01f5, B:53:0x01fa, B:55:0x0202, B:56:0x0207, B:60:0x0211, B:63:0x0227, B:64:0x022c, B:67:0x0242, B:69:0x0248, B:70:0x026b, B:72:0x0280, B:74:0x0286), top: B:79:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
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
        JSONArray optJSONArray4;
        JSONArray optJSONArray5;
        if (jSONObject == null) {
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
            if (this.userName != null && this.userName.length() <= 0) {
                this.userName = null;
            }
            this.name_show = jSONObject.optString("name_show");
            this.portrait = jSONObject.optString("portrait");
            this.portraith = jSONObject.optString("portraith");
            this.fansNum = jSONObject.optInt(PersonInfoActivityConfig.FANS_NUM);
            this.likeNum = jSONObject.optInt("my_like_num");
            this.threadNum = jSONObject.optInt("post_num");
            int optInt = jSONObject.optInt("has_concerned");
            boolean z2 = true;
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
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        IconData iconData = new IconData();
                        iconData.parserJson(optJSONArray.getJSONObject(i2));
                        this.mIconInfo.add(iconData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        IconData iconData2 = new IconData();
                        iconData2.parserJson(optJSONArray2.getJSONObject(i3));
                        this.mTShowIconInfo.add(iconData2);
                    }
                }
                if (optJSONArray3 != null) {
                    for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                        IconData iconData3 = new IconData();
                        iconData3.parserJson(optJSONArray3.getJSONObject(i4));
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
                if (jSONObject.optInt("can_modify_avatar") == 0) {
                    z2 = false;
                }
                this.canModifyAvatar = z2;
                this.cantModifyAvatarDesc = jSONObject.optString("modify_avatar_desc");
                optJSONObject8 = jSONObject.optJSONObject("business_account_info");
                if (this.businessAccountData != null && optJSONObject8 != null) {
                    this.businessAccountData.a(optJSONObject8);
                }
                this.appealThreadPopover = jSONObject.optString("appeal_thread_popover");
                this.forumToolAuth.clear();
                optJSONArray4 = jSONObject.optJSONArray("forum_tool_auth");
                if (optJSONArray4 != null) {
                    for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                        ForumToolPerm.Builder builder2 = new ForumToolPerm.Builder();
                        builder2.perm = Long.valueOf(((JSONObject) optJSONArray4.get(i5)).optLong("perm"));
                        this.forumToolAuth.add(builder2.build(false));
                    }
                }
                this.tiebaUid = jSONObject.optString("tieba_uid");
                this.managerForum.clear();
                optJSONArray5 = jSONObject.optJSONArray("manager_forum");
                if (optJSONArray5 == null) {
                    for (int i6 = 0; i6 < optJSONArray5.length(); i6++) {
                        JSONObject optJSONObject9 = optJSONArray5.optJSONObject(i6);
                        BazhuGradeData bazhuGradeData = new BazhuGradeData();
                        bazhuGradeData.parserJson(optJSONObject9);
                        this.managerForum.add(bazhuGradeData);
                    }
                    return;
                }
                return;
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
            if (jSONObject.optInt("can_modify_avatar") == 0) {
            }
            this.canModifyAvatar = z2;
            this.cantModifyAvatarDesc = jSONObject.optString("modify_avatar_desc");
            optJSONObject8 = jSONObject.optJSONObject("business_account_info");
            if (this.businessAccountData != null) {
                this.businessAccountData.a(optJSONObject8);
            }
            this.appealThreadPopover = jSONObject.optString("appeal_thread_popover");
            this.forumToolAuth.clear();
            optJSONArray4 = jSONObject.optJSONArray("forum_tool_auth");
            if (optJSONArray4 != null) {
            }
            this.tiebaUid = jSONObject.optString("tieba_uid");
            this.managerForum.clear();
            optJSONArray5 = jSONObject.optJSONArray("manager_forum");
            if (optJSONArray5 == null) {
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
