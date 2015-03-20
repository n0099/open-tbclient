package com.baidu.tieba.addresslist.im.searchfriend.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.RecommendFriend.UserInfo;
/* loaded from: classes.dex */
public class c {
    private String Qg;
    private String Qi;
    private String Qj;
    private int distance;
    private boolean isAdded;
    private String name;
    private int sex;
    private String st_type;
    private String tag_name;
    private int userId;
    private IconData Qk = new IconData();
    private com.baidu.tbadk.coreExtra.relationship.b lbsInfo = new com.baidu.tbadk.coreExtra.relationship.b();

    public void qu() {
        this.isAdded = true;
    }

    public boolean qv() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.id.intValue();
            this.Qi = userInfo.portrait;
            this.name = userInfo.name;
            this.sex = userInfo.sex.intValue();
            this.distance = userInfo.distance.intValue();
            this.Qj = userInfo.intro;
            this.tag_name = userInfo.tag_name;
            this.st_type = userInfo.st_type;
            this.Qg = userInfo.message;
            if (userInfo.tshow_icon != null) {
                this.Qk.setIcon(userInfo.tshow_icon.icon);
                this.Qk.setIconName(userInfo.tshow_icon.name);
                this.Qk.setUrl(userInfo.tshow_icon.url);
            }
            if (userInfo.location != null) {
                this.lbsInfo.dH(userInfo.location.distance);
                this.lbsInfo.setTime(userInfo.location.time.longValue());
                this.lbsInfo.cW(userInfo.location.is_hide.intValue());
            }
        }
    }

    public int getUserId() {
        return this.userId;
    }

    public String qw() {
        return this.Qi;
    }

    public String getName() {
        return this.name;
    }

    public boolean qx() {
        return 2 == this.sex;
    }

    public String qy() {
        return this.Qj;
    }

    public IconData qz() {
        return this.Qk;
    }

    public boolean isEmpty() {
        return this.userId == 0 && TextUtils.isEmpty(this.Qi) && TextUtils.isEmpty(this.name);
    }

    public JSONObject Fk() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.userId);
        jSONObject.put("name", this.name);
        jSONObject.put("portait", this.Qi);
        jSONObject.put(MyGiftListActivityConfig.USER_SEX, this.sex);
        jSONObject.put("recommend_is_added", this.isAdded);
        jSONObject.put("distance", this.distance);
        jSONObject.put("intro", this.Qj);
        jSONObject.put("tag_name", this.tag_name);
        jSONObject.put("st_type", this.st_type);
        jSONObject.put(AddFriendActivityConfig.DEFAULT_MESSAGE, this.Qg);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("icon", this.Qk.getIcon());
        jSONObject2.put("name", this.Qk.getIconName());
        jSONObject2.put(ImageViewerConfig.URL, this.Qk.getUrl());
        jSONObject.put("crown_info", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("distance", this.lbsInfo.getDistance());
        jSONObject3.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.lbsInfo.getTime());
        jSONObject3.put("is_hide", this.lbsInfo.wE());
        jSONObject.put("location", jSONObject3);
        return jSONObject;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optInt("id");
            this.name = jSONObject.optString("name");
            this.Qi = jSONObject.optString("portait");
            this.sex = jSONObject.optInt(MyGiftListActivityConfig.USER_SEX);
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.distance = jSONObject.optInt("distance");
            this.Qj = jSONObject.optString("intro");
            this.Qg = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.Qk.setIcon(optJSONObject.optString("icon"));
                this.Qk.setIconName(optJSONObject.optString("name"));
                this.Qk.setUrl(optJSONObject.optString(ImageViewerConfig.URL));
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location");
            if (optJSONObject2 != null) {
                this.lbsInfo.dH(optJSONObject2.optString("distance"));
                this.lbsInfo.setTime(optJSONObject2.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                this.lbsInfo.cW(optJSONObject2.optInt("is_hide"));
            }
        }
    }

    public com.baidu.tbadk.coreExtra.relationship.b getLbsInfo() {
        return this.lbsInfo;
    }

    public String getTagName() {
        return this.tag_name;
    }

    public String Fl() {
        return this.st_type;
    }

    public String qt() {
        return this.Qg;
    }
}
