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
    private String Et;
    private String Ev;
    private String Ew;
    private int distance;
    private boolean isAdded;
    private String name;
    private int sex;
    private String st_type;
    private String tag_name;
    private int userId;
    private IconData Ex = new IconData();
    private f lbsInfo = new f();

    public void nj() {
        this.isAdded = true;
    }

    public boolean nk() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.id.intValue();
            this.Ev = userInfo.portrait;
            this.name = userInfo.name;
            this.sex = userInfo.sex.intValue();
            this.distance = userInfo.distance.intValue();
            this.Ew = userInfo.intro;
            this.tag_name = userInfo.tag_name;
            this.st_type = userInfo.st_type;
            this.Et = userInfo.message;
            if (userInfo.tshow_icon != null) {
                this.Ex.setIcon(userInfo.tshow_icon.icon);
                this.Ex.setIconName(userInfo.tshow_icon.name);
                this.Ex.setUrl(userInfo.tshow_icon.url);
            }
            if (userInfo.location != null) {
                this.lbsInfo.dD(userInfo.location.distance);
                this.lbsInfo.setTime(userInfo.location.time.longValue());
                this.lbsInfo.cO(userInfo.location.is_hide.intValue());
            }
        }
    }

    public int getUserId() {
        return this.userId;
    }

    public String nl() {
        return this.Ev;
    }

    public String getName() {
        return this.name;
    }

    public boolean nm() {
        return 2 == this.sex;
    }

    public String nn() {
        return this.Ew;
    }

    public IconData no() {
        return this.Ex;
    }

    public boolean isEmpty() {
        return this.userId == 0 && TextUtils.isEmpty(this.Ev) && TextUtils.isEmpty(this.name);
    }

    public JSONObject SQ() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.userId);
        jSONObject.put("name", this.name);
        jSONObject.put("portait", this.Ev);
        jSONObject.put(MyGiftListActivityConfig.USER_SEX, this.sex);
        jSONObject.put("recommend_is_added", this.isAdded);
        jSONObject.put("distance", this.distance);
        jSONObject.put("intro", this.Ew);
        jSONObject.put("tag_name", this.tag_name);
        jSONObject.put("st_type", this.st_type);
        jSONObject.put(AddFriendActivityConfig.DEFAULT_MESSAGE, this.Et);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("icon", this.Ex.getIcon());
        jSONObject2.put("name", this.Ex.getIconName());
        jSONObject2.put(ImageViewerConfig.URL, this.Ex.getUrl());
        jSONObject.put("crown_info", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("distance", this.lbsInfo.getDistance());
        jSONObject3.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.lbsInfo.getTime());
        jSONObject3.put("is_hide", this.lbsInfo.sX());
        jSONObject.put("location", jSONObject3);
        return jSONObject;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optInt("id");
            this.name = jSONObject.optString("name");
            this.Ev = jSONObject.optString("portait");
            this.sex = jSONObject.optInt(MyGiftListActivityConfig.USER_SEX);
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.distance = jSONObject.optInt("distance");
            this.Ew = jSONObject.optString("intro");
            this.Et = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.Ex.setIcon(optJSONObject.optString("icon"));
                this.Ex.setIconName(optJSONObject.optString("name"));
                this.Ex.setUrl(optJSONObject.optString(ImageViewerConfig.URL));
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location");
            if (optJSONObject2 != null) {
                this.lbsInfo.dD(optJSONObject2.optString("distance"));
                this.lbsInfo.setTime(optJSONObject2.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                this.lbsInfo.cO(optJSONObject2.optInt("is_hide"));
            }
        }
    }

    public f getLbsInfo() {
        return this.lbsInfo;
    }

    public String getTagName() {
        return this.tag_name;
    }

    public String SR() {
        return this.st_type;
    }

    public String ni() {
        return this.Et;
    }
}
