package com.baidu.tieba.im.searchfriend.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.coreExtra.relationship.f;
import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.RecommendFriend.UserInfo;
/* loaded from: classes.dex */
public class c {
    private String Eu;
    private String Ew;
    private String Ex;
    private int distance;
    private boolean isAdded;
    private String name;
    private int sex;
    private String st_type;
    private String tag_name;
    private int userId;
    private IconData Ey = new IconData();
    private f lbsInfo = new f();

    public void ne() {
        this.isAdded = true;
    }

    public boolean nf() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.id.intValue();
            this.Ew = userInfo.portrait;
            this.name = userInfo.name;
            this.sex = userInfo.sex.intValue();
            this.distance = userInfo.distance.intValue();
            this.Ex = userInfo.intro;
            this.tag_name = userInfo.tag_name;
            this.st_type = userInfo.st_type;
            this.Eu = userInfo.message;
            if (userInfo.tshow_icon != null) {
                this.Ey.setIcon(userInfo.tshow_icon.icon);
                this.Ey.setIconName(userInfo.tshow_icon.name);
                this.Ey.setUrl(userInfo.tshow_icon.url);
            }
            if (userInfo.location != null) {
                this.lbsInfo.dz(userInfo.location.distance);
                this.lbsInfo.setTime(userInfo.location.time.longValue());
                this.lbsInfo.cV(userInfo.location.is_hide.intValue());
            }
        }
    }

    public int getUserId() {
        return this.userId;
    }

    public String ng() {
        return this.Ew;
    }

    public String getName() {
        return this.name;
    }

    public boolean nh() {
        return 2 == this.sex;
    }

    public String ni() {
        return this.Ex;
    }

    public IconData nj() {
        return this.Ey;
    }

    public boolean isEmpty() {
        return this.userId == 0 && TextUtils.isEmpty(this.Ew) && TextUtils.isEmpty(this.name);
    }

    public JSONObject Th() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.userId);
        jSONObject.put("name", this.name);
        jSONObject.put("portait", this.Ew);
        jSONObject.put(MyGiftListActivityConfig.USER_SEX, this.sex);
        jSONObject.put("recommend_is_added", this.isAdded);
        jSONObject.put("distance", this.distance);
        jSONObject.put("intro", this.Ex);
        jSONObject.put("tag_name", this.tag_name);
        jSONObject.put("st_type", this.st_type);
        jSONObject.put(AddFriendActivityConfig.DEFAULT_MESSAGE, this.Eu);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("icon", this.Ey.getIcon());
        jSONObject2.put("name", this.Ey.getIconName());
        jSONObject2.put(ImageViewerConfig.URL, this.Ey.getUrl());
        jSONObject.put("crown_info", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("distance", this.lbsInfo.getDistance());
        jSONObject3.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.lbsInfo.getTime());
        jSONObject3.put("is_hide", this.lbsInfo.ti());
        jSONObject.put("location", jSONObject3);
        return jSONObject;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optInt("id");
            this.name = jSONObject.optString("name");
            this.Ew = jSONObject.optString("portait");
            this.sex = jSONObject.optInt(MyGiftListActivityConfig.USER_SEX);
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.distance = jSONObject.optInt("distance");
            this.Ex = jSONObject.optString("intro");
            this.Eu = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            this.tag_name = jSONObject.optString("tag_name");
            this.st_type = jSONObject.optString("st_type");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.Ey.setIcon(optJSONObject.optString("icon"));
                this.Ey.setIconName(optJSONObject.optString("name"));
                this.Ey.setUrl(optJSONObject.optString(ImageViewerConfig.URL));
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location");
            if (optJSONObject2 != null) {
                this.lbsInfo.dz(optJSONObject2.optString("distance"));
                this.lbsInfo.setTime(optJSONObject2.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                this.lbsInfo.cV(optJSONObject2.optInt("is_hide"));
            }
        }
    }

    public f getLbsInfo() {
        return this.lbsInfo;
    }

    public String getTagName() {
        return this.tag_name;
    }

    public String Ti() {
        return this.st_type;
    }

    public String nd() {
        return this.Eu;
    }
}
