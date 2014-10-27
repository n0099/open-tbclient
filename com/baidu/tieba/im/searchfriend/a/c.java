package com.baidu.tieba.im.searchfriend.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.coreExtra.relationship.f;
import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import tbclient.RecommendFriend.UserInfo;
/* loaded from: classes.dex */
public class c {
    private String Ai;
    private String Ak;
    private String Al;
    private IconData Am = new IconData();
    private int distance;
    private boolean isAdded;
    private f lbsInfo;
    private String name;
    private int sex;
    private String st_type;
    private String tag_name;
    private int userId;

    public void kq() {
        this.isAdded = true;
    }

    public boolean kr() {
        return this.isAdded;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.isAdded = false;
            this.userId = userInfo.id.intValue();
            this.Ak = userInfo.portrait;
            this.name = userInfo.name;
            this.sex = userInfo.sex.intValue();
            this.distance = userInfo.distance.intValue();
            this.Al = userInfo.intro;
            this.tag_name = userInfo.tag_name;
            this.st_type = userInfo.st_type;
            this.Ai = userInfo.message;
            if (userInfo.tshow_icon != null) {
                this.Am.setIcon(userInfo.tshow_icon.icon);
                this.Am.setIconName(userInfo.tshow_icon.name);
                this.Am.setUrl(userInfo.tshow_icon.url);
            }
            if (userInfo.location != null) {
                this.lbsInfo = new f(userInfo.location.distance, userInfo.location.time.longValue(), userInfo.location.is_hide.intValue());
            }
        }
    }

    public int getUserId() {
        return this.userId;
    }

    public String ks() {
        return this.Ak;
    }

    public String getName() {
        return this.name;
    }

    public boolean kt() {
        return 2 == this.sex;
    }

    public String ku() {
        return this.Al;
    }

    public IconData kv() {
        return this.Am;
    }

    public boolean isEmpty() {
        return this.userId == 0 && TextUtils.isEmpty(this.Ak) && TextUtils.isEmpty(this.name);
    }

    public JSONObject RB() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.userId);
        jSONObject.put("name", this.name);
        jSONObject.put("portait", this.Ak);
        jSONObject.put(MyGiftListActivityConfig.USER_SEX, this.sex);
        jSONObject.put("recommend_is_added", this.isAdded);
        jSONObject.put("distance", this.distance);
        jSONObject.put("intro", this.Al);
        jSONObject.put("tag_name", this.tag_name);
        jSONObject.put("st_type", this.st_type);
        jSONObject.put(AddFriendActivityConfig.DEFAULT_MESSAGE, this.Ai);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("icon", this.Am.getIcon());
        jSONObject2.put("name", this.Am.getIconName());
        jSONObject2.put(ImageViewerConfig.URL, this.Am.getUrl());
        jSONObject.put("crown_info", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("distance", this.lbsInfo.getDistance());
        jSONObject3.put("time", this.lbsInfo.getTime());
        jSONObject3.put("is_hide", this.lbsInfo.pB());
        jSONObject.put("location", jSONObject3);
        return jSONObject;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optInt("id");
            this.name = jSONObject.optString("name");
            this.Ak = jSONObject.optString("portait");
            this.sex = jSONObject.optInt(MyGiftListActivityConfig.USER_SEX);
            this.isAdded = jSONObject.optBoolean("recommend_is_added");
            this.distance = jSONObject.optInt("distance");
            this.Al = jSONObject.optString("intro");
            this.Ai = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.Am.setIcon(optJSONObject.optString("icon"));
                this.Am.setIconName(optJSONObject.optString("name"));
                this.Am.setUrl(optJSONObject.optString(ImageViewerConfig.URL));
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location");
            if (optJSONObject2 != null) {
                this.lbsInfo.cF(optJSONObject2.optString("distance"));
                this.lbsInfo.setTime(optJSONObject2.optLong("time"));
                this.lbsInfo.co(optJSONObject2.optInt("is_hide"));
            }
        }
    }

    public f getLbsInfo() {
        return this.lbsInfo;
    }

    public String getTagName() {
        return this.tag_name;
    }

    public String RC() {
        return this.st_type;
    }

    public String kp() {
        return this.Ai;
    }
}
