package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.GroupLevelActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.GodInfo;
import tbclient.Icon;
import tbclient.TshowInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class MetaData extends com.baidu.adp.lib.a.b.a.a.i implements com.baidu.tbadk.core.view.userLike.a, Serializable {
    private static final long serialVersionUID = -2658065756886586092L;
    private String fansNickName;
    private int gender;
    private boolean isGod;
    private int is_myfriend;
    private k pendantData;
    private boolean isLikeStatusFromNet = false;
    private int is_like = 0;
    private GodUserData godUserData = new GodUserData();
    private UserTbVipInfoData bigVData = new UserTbVipInfoData();
    private String userId = null;
    private int type = 0;
    private int level_id = 0;
    private String userName = null;
    private String name_show = null;
    private String portrait = null;
    private String portraith = null;
    private ArrayList<IconData> mIconInfo = new ArrayList<>();
    private ArrayList<IconData> mTShowIconInfo = new ArrayList<>();
    private ArrayList<IconData> mTShowIconInfoNew = new ArrayList<>();
    private int is_bawu = 0;
    private String bawu_type = null;
    private int concernNum = -1;
    private int fansNum = -1;
    private boolean mHadConcerned = false;
    @Deprecated
    private GodInfo godInfo = null;
    private int giftNum = 0;
    private int isMem = 0;
    private ThemeCardInUserData themeCard = new ThemeCardInUserData();
    private String sealPrefix = null;

    public void setUserId(String str) {
        this.userId = str;
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public String getUserId() {
        return this.userId;
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public void setIsFromNetWork(boolean z) {
        this.isLikeStatusFromNet = z;
        if (this.godUserData != null) {
            this.godUserData.setIsFromNetWork(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public boolean isGod() {
        return this.isGod;
    }

    public void setIsGod(boolean z) {
        this.isGod = z;
    }

    public void setUserIdLong(long j) {
        this.userId = String.valueOf(j);
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public boolean getIsLike() {
        if (isGod()) {
            return this.godUserData.getIsLike();
        }
        return this.is_like == 1;
    }

    @Override // com.baidu.tbadk.core.view.userLike.a
    public void setIsLike(boolean z) {
        this.is_like = z ? 1 : 0;
        this.mHadConcerned = z;
        if (isGod()) {
            this.godUserData.setIsLike(z);
        }
    }

    public long getUserIdLong() {
        return com.baidu.adp.lib.h.b.c(this.userId, 0L);
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
        if (this.userName != null && this.userName.length() > 0) {
            return this.userName;
        }
        if (this.name_show != null) {
            return this.name_show;
        }
        return this.userName;
    }

    public void setName_show(String str) {
        this.name_show = str;
    }

    public String getName_show() {
        if (this.name_show != null && this.name_show.length() > 0) {
            return this.name_show;
        }
        if (this.userName != null) {
            return this.userName;
        }
        return this.name_show;
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

    public int getLevel_id() {
        return this.level_id;
    }

    public void setLevel_id(int i) {
        this.level_id = i;
    }

    public int getIs_bawu() {
        return this.is_bawu;
    }

    public String getBawu_type() {
        return this.bawu_type;
    }

    public int getIsMyFriend() {
        return this.is_myfriend;
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

    public boolean hadConcerned() {
        return this.mHadConcerned;
    }

    public void setHadConcerned(boolean z) {
        this.mHadConcerned = z;
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

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x000a: IGET  (r3v0 java.lang.Long A[REMOVE]) = (r9v0 tbclient.User) tbclient.User.id java.lang.Long)] */
    public void parserProtobuf(User user) {
        if (user != null) {
            this.userId = new StringBuilder().append(user.id).toString();
            this.gender = user.gender.intValue();
            this.type = user.type.intValue();
            this.userName = user.name;
            this.level_id = user.level_id.intValue();
            this.is_like = user.is_like.intValue();
            this.is_bawu = user.is_bawu.intValue();
            this.bawu_type = user.bawu_type;
            this.is_myfriend = user.is_friend.intValue();
            this.concernNum = user.concern_num.intValue();
            this.mHadConcerned = user.has_concerned.intValue() == 1;
            this.fansNickName = user.fans_nickname;
            this.fansNum = user.fans_num.intValue();
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
            }
            if (user.tb_vip != null) {
                this.bigVData.parserProtobuf(user.tb_vip);
            }
            this.godInfo = user.god_data;
            this.giftNum = user.gift_num.intValue();
            this.themeCard.parser(user.theme_card);
            if (user.pendant != null) {
                this.pendantData = new k();
                this.pendantData.a(user.pendant);
            }
            this.isLikeStatusFromNet = true;
            this.sealPrefix = user.seal_prefix;
        }
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
                this.level_id = jSONObject.optInt("level_id", 0);
                this.is_like = jSONObject.optInt("is_like", 0);
                this.is_bawu = jSONObject.optInt("is_bawu", 0);
                this.isMem = jSONObject.optInt(GroupLevelActivityConfig.IS_MEM, 0);
                this.bawu_type = jSONObject.optString("bawu_type");
                this.is_myfriend = jSONObject.optInt("is_friend");
                if (this.userName != null && this.userName.length() <= 0) {
                    this.userName = null;
                }
                this.name_show = jSONObject.optString(IntentConfig.NAME_SHOW);
                this.portrait = jSONObject.optString(IntentConfig.PORTRAIT);
                this.portraith = jSONObject.optString("portraith");
                this.fansNum = jSONObject.optInt(PersonInfoActivityConfig.FANS_NUM);
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
                }
                if (optJSONObject2 != null) {
                    this.bigVData.parseJson(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("theme_card");
                if (optJSONObject3 != null) {
                    this.themeCard.parser(optJSONObject3);
                }
                this.isLikeStatusFromNet = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public ThemeCardInUserData getThemeCard() {
        return this.themeCard;
    }

    public k getPendantData() {
        return this.pendantData;
    }

    public void setPendantData(k kVar) {
        this.pendantData = kVar;
    }
}
