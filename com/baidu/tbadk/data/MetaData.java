package com.baidu.tbadk.data;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.data.BazhuGradeData;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.BaijiahaoInfo;
import tbclient.GodInfo;
import tbclient.Icon;
import tbclient.TshowInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class MetaData extends OrmObject implements com.baidu.tbadk.core.view.userLike.a, Serializable {
    private static final long serialVersionUID = -2658065756886586092L;
    private AlaInfoData alaInfo;
    public AlaUserInfoData alaUserData;
    private boolean canModifyAvatar;
    private String cantModifyAvatarDesc;
    private String fansNickName;
    private int gender;
    private String god_intro;
    private String imBjhAvatar;
    private boolean isBigV;
    public boolean isDefaultAvatar;
    private boolean isGod;
    public boolean isMask;
    private int is_manager;
    private int is_myfans;
    private int is_myfriend;
    private l pendantData;
    public int rankInfluence;
    public String rankNum;
    private String virtualUserUrl;
    private boolean isLikeStatusFromNet = true;
    private int is_like = 0;
    private int likeStatus = 0;
    private GodUserData godUserData = new GodUserData();
    private UserTbVipInfoData bigVData = new UserTbVipInfoData();
    private NewGodData mNewGodData = new NewGodData();
    private BazhuGradeData mBazhuGrade = new BazhuGradeData();
    private String userId = null;
    private int type = 0;
    private int level_id = 0;
    private String userName = null;
    private String uk = null;
    private String name_show = null;
    private String portrait = null;
    private String portraith = null;
    private ArrayList<IconData> mIconInfo = new ArrayList<>();
    private ArrayList<IconData> mTShowIconInfo = new ArrayList<>();
    private ArrayList<IconData> mTShowIconInfoNew = new ArrayList<>();
    private int is_bawu = 0;
    private String bawu_type = null;
    private int concernNum = 0;
    private int fansNum = 0;
    private int threadNum = -1;
    private int likeNum = -1;
    private boolean mHadConcerned = false;
    @Deprecated
    private GodInfo godInfo = null;
    private int giftNum = 0;
    private int isMem = 0;
    private ThemeCardInUserData themeCard = new ThemeCardInUserData();
    private String sealPrefix = null;
    private int left_call_num = 0;
    private BaijiahaoInfo baijiahaoInfo = null;

    public BaijiahaoInfo getBaijiahaoInfo() {
        return this.baijiahaoInfo;
    }

    public void setBaijiahaoInfo(BaijiahaoInfo baijiahaoInfo) {
        this.baijiahaoInfo = baijiahaoInfo;
    }

    public boolean isBaijiahaoUser() {
        return this.baijiahaoInfo != null && this.baijiahaoInfo.auth_id.intValue() > 0;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public String getUserId() {
        return this.userId;
    }

    public String getUk() {
        return this.uk;
    }

    public void setUk(String str) {
        this.uk = str;
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public void setIsFromNetWork(boolean z) {
        this.isLikeStatusFromNet = z;
        if (this.godUserData != null) {
            this.godUserData.setIsFromNetWork(z);
        }
    }

    public boolean isLikeStatusFromNet() {
        return this.isLikeStatusFromNet;
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public boolean isGod() {
        return this.isGod;
    }

    public boolean isBigV() {
        return this.isBigV;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setIsGod(boolean z) {
        this.isGod = z;
    }

    public void setUserIdLong(long j) {
        this.userId = String.valueOf(j);
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public boolean getIsLike() {
        return isGod() ? this.godUserData.getIsLike() || this.mHadConcerned : this.is_like == 1 || this.mHadConcerned;
    }

    public void setIsLike(boolean z) {
        this.is_like = z ? 1 : 0;
        this.mHadConcerned = z;
        if (isGod()) {
            this.godUserData.setIsLike(z);
        }
    }

    public void setHadConcerned(boolean z) {
        this.mHadConcerned = z;
        setIsLike(z);
    }

    public boolean hadConcerned() {
        return this.mHadConcerned || this.is_like == 1;
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public void setLikeStatus(int i) {
        this.likeStatus = i;
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public int getLikeStatus() {
        return this.likeStatus;
    }

    public long getUserIdLong() {
        return com.baidu.adp.lib.f.b.toLong(this.userId, 0L);
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public int getIsMem() {
        return this.isMem;
    }

    public String getUserName() {
        return (this.userName == null || this.userName.length() <= 0) ? "" : this.userName;
    }

    public void setName_show(String str) {
        this.name_show = str;
    }

    public String getName_show() {
        return !StringUtils.isNull(this.name_show) ? this.name_show : this.userName;
    }

    public String getGodIntro() {
        return this.god_intro;
    }

    public void setGodIntor(String str) {
        this.god_intro = str;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public String getPortrait() {
        return this.portrait;
    }

    public void setPortraitH(String str) {
        this.portraith = str;
    }

    public AlaUserInfoData getAlaUserData() {
        return this.alaUserData;
    }

    public AlaInfoData getAlaInfo() {
        return this.alaInfo;
    }

    public String getPortraitH() {
        return this.portraith;
    }

    public ArrayList<IconData> getIconInfo() {
        return this.mIconInfo;
    }

    public void setIconInfo(ArrayList<IconData> arrayList) {
        this.mIconInfo = arrayList;
    }

    public ArrayList<IconData> getTShowInfo() {
        return this.mTShowIconInfo;
    }

    public void setTShowInfo(ArrayList<IconData> arrayList) {
        this.mTShowIconInfo = arrayList;
    }

    public ArrayList<IconData> getTShowInfoNew() {
        return this.mTShowIconInfoNew;
    }

    public int getLeft_call_num() {
        return this.left_call_num;
    }

    public void setLeft_call_num(int i) {
        this.left_call_num = i;
    }

    public int getLevel_id() {
        return this.level_id;
    }

    public void setLevel_id(int i) {
        this.level_id = i;
    }

    public int getIs_bawu() {
        return this.is_bawu;
    }

    public int getIs_manager() {
        return this.is_manager;
    }

    public String getBawu_type() {
        return this.bawu_type;
    }

    public int getIsMyFriend() {
        return this.is_myfriend;
    }

    public int getIsMyFans() {
        return this.is_myfans;
    }

    public int getGender() {
        return this.gender;
    }

    public void setGender(int i) {
        this.gender = i;
    }

    public int getConcernNum() {
        return this.concernNum;
    }

    public int getConcern_num() {
        return this.concernNum;
    }

    public void setConcern_num(int i) {
        this.concernNum = i;
    }

    public String getFansNickName() {
        return this.fansNickName;
    }

    public void setFansNickName(String str) {
        this.fansNickName = str;
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public void setFansNum(int i) {
        this.fansNum = i;
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public int getFansNum() {
        return this.fansNum;
    }

    public void setLikeNum(int i) {
        this.likeNum = i;
    }

    public int getLikeNum() {
        return this.likeNum;
    }

    public void setThreadNum(int i) {
        this.threadNum = i;
    }

    public int getThreadNum() {
        return this.threadNum;
    }

    @Deprecated
    public GodInfo getGodInfo() {
        return this.godInfo;
    }

    @Deprecated
    public void setGodInfo(GodInfo godInfo) {
        this.godInfo = godInfo;
    }

    public GodUserData getGodUserData() {
        return this.godUserData;
    }

    public UserTbVipInfoData getUserTbVipInfoData() {
        return this.bigVData;
    }

    public void setGodUserData(GodUserData godUserData) {
        this.godUserData = godUserData;
    }

    public void setTbVipInfoData(UserTbVipInfoData userTbVipInfoData) {
        this.bigVData = userTbVipInfoData;
    }

    public int getGiftNum() {
        return this.giftNum;
    }

    public void setGiftNum(int i) {
        this.giftNum = i;
    }

    public void setSealPrefix(String str) {
        this.sealPrefix = str;
    }

    public String getSealPrefix() {
        return this.sealPrefix;
    }

    public void parserProtobuf(User user) {
        if (user != null) {
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
            if (this.userName != null && this.userName.length() <= 0) {
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
            if (user.god_data != null) {
                this.godUserData.parserProtobuf(user.god_data);
                this.isGod = this.godUserData.isGod();
                this.isBigV = this.godUserData.isBigV();
                this.god_intro = this.godUserData.getIntro();
            }
            if (user.tb_vip != null) {
                this.bigVData.parserProtobuf(user.tb_vip);
            }
            this.godInfo = user.god_data;
            this.giftNum = user.gift_num.intValue();
            this.themeCard.parser(user.theme_card);
            if (user.pendant != null) {
                this.pendantData = new l();
                this.pendantData.a(user.pendant);
            }
            this.isLikeStatusFromNet = true;
            if (user.ala_info != null) {
                this.alaUserData = new AlaUserInfoData();
                this.alaUserData.a(user.ala_info);
            }
            if (user.ala_live_info != null) {
                this.alaInfo = new AlaInfoData();
                this.alaInfo.parserProtobuf(user.ala_live_info);
            } else if (this.alaUserData != null) {
                this.alaInfo = new AlaInfoData();
                this.alaInfo.live_status = this.alaUserData.live_status;
                this.alaInfo.live_id = this.alaUserData.live_id;
            }
            this.sealPrefix = user.seal_prefix;
            if (user.spring_virtual_user != null && user.spring_virtual_user.is_virtual.intValue() == 1 && !StringUtils.isNull(user.spring_virtual_user.url)) {
                this.virtualUserUrl = user.spring_virtual_user.url;
            }
            this.left_call_num = user.left_call_num.intValue();
            this.baijiahaoInfo = user.baijiahao_info;
            this.canModifyAvatar = user.can_modify_avatar.intValue() == 0;
            this.cantModifyAvatarDesc = user.modify_avatar_desc;
            this.rankNum = user.level_influence;
            this.rankInfluence = user.influence == null ? 0 : user.influence.intValue();
            this.isMask = user.is_mask.intValue() == 1;
            if (user.new_god_data != null) {
                this.mNewGodData.parserProtobuf(user.new_god_data);
            }
            if (user.bazhu_grade != null) {
                this.mBazhuGrade.parserProtobuf(user.bazhu_grade);
            }
            this.isDefaultAvatar = user.is_default_avatar.intValue() == 1;
        }
    }

    private void testBaijiahaoInfo() {
        BaijiahaoInfo.Builder builder = new BaijiahaoInfo.Builder();
        builder.auth_id = 1;
        builder.auth_desc = "专家";
        this.baijiahaoInfo = builder.build(true);
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
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
                this.isMem = jSONObject.optInt("is_mem", 0);
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
                this.mHadConcerned = optInt == 1 || optInt == 2;
                setLikeStatus(optInt);
                JSONArray optJSONArray = jSONObject.optJSONArray("iconinfo");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("tshow_icon");
                JSONArray optJSONArray3 = jSONObject.optJSONArray("new_tshow_icon");
                JSONObject optJSONObject = jSONObject.optJSONObject("god_data");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("tb_vip");
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
                JSONObject optJSONObject3 = jSONObject.optJSONObject("theme_card");
                if (optJSONObject3 != null) {
                    this.themeCard.parser(optJSONObject3);
                }
                this.isLikeStatusFromNet = true;
                this.alaUserData = new AlaUserInfoData();
                this.alaUserData.parserJson(jSONObject.optJSONObject("ala_info"));
                this.alaInfo = new AlaInfoData();
                this.alaInfo.parserJson(jSONObject.optJSONObject("ala_live_info"));
                JSONObject optJSONObject4 = jSONObject.optJSONObject("spring_virtual_user");
                if (optJSONObject4 != null) {
                    int optInt2 = optJSONObject4.optInt("is_virtual");
                    String optString = optJSONObject4.optString("url");
                    if (optInt2 == 1 && !StringUtils.isNull(optString)) {
                        this.virtualUserUrl = optString;
                    }
                }
                this.left_call_num = jSONObject.optInt("left_call_num", 0);
                JSONObject optJSONObject5 = jSONObject.optJSONObject("baijiahao_info");
                if (optJSONObject5 != null) {
                    BaijiahaoInfo.Builder builder = new BaijiahaoInfo.Builder();
                    builder.name = optJSONObject5.optString("name");
                    builder.avatar = optJSONObject5.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                    builder.avatar_h = optJSONObject5.optString("avatar_h");
                    builder.brief = optJSONObject5.optString(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF);
                    builder.auth_id = Integer.valueOf(optJSONObject5.optInt("auth_id"));
                    builder.auth_desc = optJSONObject5.optString("auth_desc");
                    this.baijiahaoInfo = builder.build(false);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("new_god_data");
                if (optJSONObject6 != null) {
                    this.mNewGodData.parserJson(optJSONObject6);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("bazhu_grade");
                if (optJSONObject7 != null) {
                    this.mBazhuGrade.parserJson(optJSONObject7);
                }
                this.canModifyAvatar = jSONObject.optInt("can_modify_avatar") == 0;
                this.cantModifyAvatarDesc = jSONObject.getString("modify_avatar_desc");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public ThemeCardInUserData getThemeCard() {
        return this.themeCard;
    }

    public l getPendantData() {
        return this.pendantData;
    }

    public void setPendantData(l lVar) {
        this.pendantData = lVar;
    }

    public String getVirtualUserUrl() {
        return this.virtualUserUrl;
    }

    public void setVirtualUserUrl(String str) {
        this.virtualUserUrl = str;
    }

    public boolean canModifyAvatar() {
        return this.canModifyAvatar;
    }

    public String getCantModifyAvatarDesc() {
        return this.cantModifyAvatarDesc;
    }

    public String getImBjhAvatar() {
        if (!TextUtils.isEmpty(this.imBjhAvatar)) {
            return this.imBjhAvatar;
        }
        if (this.baijiahaoInfo != null && !TextUtils.isEmpty(this.baijiahaoInfo.avatar)) {
            return this.baijiahaoInfo.avatar;
        }
        return this.imBjhAvatar;
    }

    public void setImBjhAvatar(String str) {
        this.imBjhAvatar = str;
    }

    public String getAvater() {
        if (this.baijiahaoInfo != null && !TextUtils.isEmpty(this.baijiahaoInfo.avatar)) {
            return this.baijiahaoInfo.avatar;
        }
        if (!TextUtils.isEmpty(this.imBjhAvatar)) {
            return this.imBjhAvatar;
        }
        return this.portrait;
    }

    public String getAvatarH() {
        return (this.baijiahaoInfo == null || TextUtils.isEmpty(this.baijiahaoInfo.avatar_h)) ? this.portraith : this.baijiahaoInfo.avatar_h;
    }

    public NewGodData getNewGodData() {
        return this.mNewGodData;
    }

    public void setNewGodData(NewGodData newGodData) {
        this.mNewGodData = newGodData;
    }

    public boolean isNewGod() {
        return this.mNewGodData != null && this.mNewGodData.isNewGod();
    }

    public BazhuGradeData getBazhuGradeData() {
        return this.mBazhuGrade;
    }

    public void setBazhuGradeData(BazhuGradeData bazhuGradeData) {
        this.mBazhuGrade = bazhuGradeData;
    }

    public boolean showBazhuGrade() {
        return ((this.baijiahaoInfo != null && (this.baijiahaoInfo.auth_id.intValue() != 0 || !as.isEmpty(this.baijiahaoInfo.auth_desc))) || this.mBazhuGrade == null || as.isEmpty(this.mBazhuGrade.getDesc())) ? false : true;
    }
}
