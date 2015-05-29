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
    private String QE;
    private String QG;
    private String QH;
    private int distance;
    private boolean isAdded;
    private String name;
    private int sex;
    private String st_type;
    private String tag_name;
    private int userId;
    private IconData QI = new IconData();
    private com.baidu.tbadk.coreExtra.relationship.b lbsInfo = new com.baidu.tbadk.coreExtra.relationship.b();

    public void ra() {
        this.isAdded = true;
    }

    public boolean rb() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.id.intValue();
            this.QG = userInfo.portrait;
            this.name = userInfo.name;
            this.sex = userInfo.sex.intValue();
            this.distance = userInfo.distance.intValue();
            this.QH = userInfo.intro;
            this.tag_name = userInfo.tag_name;
            this.st_type = userInfo.st_type;
            this.QE = userInfo.message;
            if (userInfo.tshow_icon != null) {
                this.QI.setIcon(userInfo.tshow_icon.icon);
                this.QI.setIconName(userInfo.tshow_icon.name);
                this.QI.setUrl(userInfo.tshow_icon.url);
            }
            if (userInfo.location != null) {
                this.lbsInfo.eb(userInfo.location.distance);
                this.lbsInfo.setTime(userInfo.location.time.longValue());
                this.lbsInfo.df(userInfo.location.is_hide.intValue());
            }
        }
    }

    public int getUserId() {
        return this.userId;
    }

    public String rc() {
        return this.QG;
    }

    public String getName() {
        return this.name;
    }

    public boolean rd() {
        return 2 == this.sex;
    }

    public String re() {
        return this.QH;
    }

    public IconData rf() {
        return this.QI;
    }

    public boolean isEmpty() {
        return this.userId == 0 && TextUtils.isEmpty(this.QG) && TextUtils.isEmpty(this.name);
    }

    public JSONObject Gj() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.userId);
        jSONObject.put("name", this.name);
        jSONObject.put("portait", this.QG);
        jSONObject.put(MyGiftListActivityConfig.USER_SEX, this.sex);
        jSONObject.put("recommend_is_added", this.isAdded);
        jSONObject.put("distance", this.distance);
        jSONObject.put("intro", this.QH);
        jSONObject.put("tag_name", this.tag_name);
        jSONObject.put("st_type", this.st_type);
        jSONObject.put(AddFriendActivityConfig.DEFAULT_MESSAGE, this.QE);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("icon", this.QI.getIcon());
        jSONObject2.put("name", this.QI.getIconName());
        jSONObject2.put(ImageViewerConfig.URL, this.QI.getUrl());
        jSONObject.put("crown_info", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("distance", this.lbsInfo.getDistance());
        jSONObject3.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.lbsInfo.getTime());
        jSONObject3.put("is_hide", this.lbsInfo.xx());
        jSONObject.put("location", jSONObject3);
        return jSONObject;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optInt("id");
            this.name = jSONObject.optString("name");
            this.QG = jSONObject.optString("portait");
            this.sex = jSONObject.optInt(MyGiftListActivityConfig.USER_SEX);
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.distance = jSONObject.optInt("distance");
            this.QH = jSONObject.optString("intro");
            this.QE = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.QI.setIcon(optJSONObject.optString("icon"));
                this.QI.setIconName(optJSONObject.optString("name"));
                this.QI.setUrl(optJSONObject.optString(ImageViewerConfig.URL));
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location");
            if (optJSONObject2 != null) {
                this.lbsInfo.eb(optJSONObject2.optString("distance"));
                this.lbsInfo.setTime(optJSONObject2.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME));
                this.lbsInfo.df(optJSONObject2.optInt("is_hide"));
            }
        }
    }

    public com.baidu.tbadk.coreExtra.relationship.b getLbsInfo() {
        return this.lbsInfo;
    }

    public String getTagName() {
        return this.tag_name;
    }

    public String Gk() {
        return this.st_type;
    }

    public String qZ() {
        return this.QE;
    }
}
