package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Icon;
import tbclient.TshowInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class MetaData implements Serializable {
    private static final long serialVersionUID = -2658065756886586092L;
    private int is_myfriend;
    private int is_like = 0;
    private String userId = null;
    private int type = 0;
    private int level_id = 0;
    private String userName = null;
    private String name_show = null;
    private String portrait = null;
    private String portraith = null;
    private LinkedList<IconData> mIconInfo = new LinkedList<>();
    private LinkedList<IconData> mTShowIconInfo = new LinkedList<>();
    private int is_bawu = 0;
    private String bawu_type = null;

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserIdLong(long j) {
        this.userId = String.valueOf(j);
    }

    public int getIsLike() {
        return this.is_like;
    }

    public void setIsLike(int i) {
        this.is_like = i;
    }

    public long getUserIdLong() {
        return com.baidu.adp.lib.e.b.a(this.userId, 0L);
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

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortraitH(String str) {
        this.portraith = str;
    }

    public String getPortraitH() {
        return this.portraith;
    }

    public LinkedList<IconData> getIconInfo() {
        return this.mIconInfo;
    }

    public void setIconInfo(LinkedList<IconData> linkedList) {
        this.mIconInfo = linkedList;
    }

    public LinkedList<IconData> getTShowInfo() {
        return this.mTShowIconInfo;
    }

    public void setTShowInfo(LinkedList<IconData> linkedList) {
        this.mTShowIconInfo = linkedList;
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

    public void setIsBawu(int i) {
        this.is_bawu = i;
    }

    public String getBawu_type() {
        return this.bawu_type;
    }

    public void setBawuType(String str) {
        this.bawu_type = str;
    }

    public int getIsMyFriend() {
        return this.is_myfriend;
    }

    public void setIsMyFriend(int i) {
        this.is_myfriend = i;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0009: IGET  (r1v0 java.lang.Integer A[REMOVE]) = (r7v0 tbclient.User) tbclient.User.id java.lang.Integer)] */
    public void parserProtobuf(User user) {
        if (user != null) {
            this.userId = new StringBuilder().append(user.id).toString();
            this.type = user.type.intValue();
            this.userName = user.name;
            this.level_id = user.level_id.intValue();
            this.is_like = user.is_like.intValue();
            this.is_bawu = user.is_bawu.intValue();
            this.bawu_type = user.bawu_type;
            this.is_myfriend = user.is_friend.intValue();
            if (this.userName != null && this.userName.length() <= 0) {
                this.userName = null;
            }
            this.name_show = user.name_show;
            this.portrait = user.portrait;
            this.portraith = user.portraith;
            List<Icon> list = user.iconinfo;
            List<TshowInfo> list2 = user.tshow_icon;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    IconData iconData = new IconData();
                    iconData.parserProtobuf(list.get(i));
                    this.mIconInfo.add(iconData);
                }
            }
            if (list2 != null) {
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    IconData iconData2 = new IconData();
                    iconData2.parserProtobuf(list2.get(i2));
                    this.mTShowIconInfo.add(iconData2);
                }
            }
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
                this.type = jSONObject.optInt("type", 0);
                this.userName = jSONObject.optString("name");
                this.level_id = jSONObject.optInt("level_id", 0);
                this.is_like = jSONObject.optInt("is_like", 0);
                this.is_bawu = jSONObject.optInt("is_bawu", 0);
                this.bawu_type = jSONObject.optString("bawu_type");
                this.is_myfriend = jSONObject.optInt("is_friend");
                if (this.userName != null && this.userName.length() <= 0) {
                    this.userName = null;
                }
                this.name_show = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
                this.portrait = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                this.portraith = jSONObject.optString("portraith");
                JSONArray optJSONArray = jSONObject.optJSONArray("iconinfo");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("tshow_icon");
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
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void logPrint() {
    }
}
