package com.baidu.tieba.addresslist.im.searchfriend.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.RecommendFriend.UserInfo;
/* loaded from: classes.dex */
public class c {
    private String VS;
    private String VU;
    private String VV;
    private int distance;
    private boolean isAdded;
    private String name;
    private int sex;
    private String st_type;
    private String tag_name;
    private long userId;
    private IconData VW = new IconData();
    private com.baidu.tbadk.coreExtra.relationship.b lbsInfo = new com.baidu.tbadk.coreExtra.relationship.b();

    public void ss() {
        this.isAdded = true;
    }

    public boolean st() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.id.longValue();
            this.VU = userInfo.portrait;
            this.name = userInfo.name;
            this.sex = userInfo.sex.intValue();
            this.distance = userInfo.distance.intValue();
            this.VV = userInfo.intro;
            this.tag_name = userInfo.tag_name;
            this.st_type = userInfo.st_type;
            this.VS = userInfo.message;
            if (userInfo.tshow_icon != null) {
                this.VW.setIcon(userInfo.tshow_icon.icon);
                this.VW.setIconName(userInfo.tshow_icon.name);
                this.VW.setUrl(userInfo.tshow_icon.url);
            }
            if (userInfo.location != null) {
                this.lbsInfo.ex(userInfo.location.distance);
                this.lbsInfo.setTime(userInfo.location.time.longValue());
                this.lbsInfo.dM(userInfo.location.is_hide.intValue());
            }
        }
    }

    public long getUserId() {
        return this.userId;
    }

    public String su() {
        return this.VU;
    }

    public String getName() {
        return this.name;
    }

    public boolean sv() {
        return 2 == this.sex;
    }

    public String sw() {
        return this.VV;
    }

    public IconData sx() {
        return this.VW;
    }

    public boolean isEmpty() {
        return this.userId == 0 && TextUtils.isEmpty(this.VU) && TextUtils.isEmpty(this.name);
    }

    public JSONObject HG() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.userId);
        jSONObject.put("name", this.name);
        jSONObject.put("portait", this.VU);
        jSONObject.put(MyGiftListActivityConfig.USER_SEX, this.sex);
        jSONObject.put("recommend_is_added", this.isAdded);
        jSONObject.put("distance", this.distance);
        jSONObject.put("intro", this.VV);
        jSONObject.put("tag_name", this.tag_name);
        jSONObject.put("st_type", this.st_type);
        jSONObject.put(AddFriendActivityConfig.DEFAULT_MESSAGE, this.VS);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("icon", this.VW.getIcon());
        jSONObject2.put("name", this.VW.getIconName());
        jSONObject2.put("url", this.VW.getUrl());
        jSONObject.put("crown_info", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("distance", this.lbsInfo.getDistance());
        jSONObject3.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.lbsInfo.getTime());
        jSONObject3.put("is_hide", this.lbsInfo.zw());
        jSONObject.put("location", jSONObject3);
        return jSONObject;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optLong("id");
            this.name = jSONObject.optString("name");
            this.VU = jSONObject.optString("portait");
            this.sex = jSONObject.optInt(MyGiftListActivityConfig.USER_SEX);
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.distance = jSONObject.optInt("distance");
            this.VV = jSONObject.optString("intro");
            this.VS = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.VW.setIcon(optJSONObject.optString("icon"));
                this.VW.setIconName(optJSONObject.optString("name"));
                this.VW.setUrl(optJSONObject.optString("url"));
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location");
            if (optJSONObject2 != null) {
                this.lbsInfo.ex(optJSONObject2.optString("distance"));
                this.lbsInfo.setTime(optJSONObject2.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                this.lbsInfo.dM(optJSONObject2.optInt("is_hide"));
            }
        }
    }

    public com.baidu.tbadk.coreExtra.relationship.b getLbsInfo() {
        return this.lbsInfo;
    }

    public String getTagName() {
        return this.tag_name;
    }

    public String HH() {
        return this.st_type;
    }

    public String sr() {
        return this.VS;
    }
}
