package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private String dotTimestamp;
    private String enterForumText;
    private String feedText;
    private String h5Url;
    private String myTabText;
    private boolean personItemSwitch;
    private String personItemText;
    private boolean switchTurn;
    private boolean userSatisfy;

    public boolean isSwitchTurn() {
        return this.switchTurn;
    }

    public void setSwitchTurn(boolean z) {
        this.switchTurn = z;
    }

    public boolean isPersonItemSwitch() {
        return this.personItemSwitch;
    }

    public String getPersonItemText() {
        return this.personItemText;
    }

    public String getH5Url() {
        return this.h5Url;
    }

    public boolean isUserSatisfy() {
        return this.userSatisfy;
    }

    public String getDotTimestamp() {
        return this.dotTimestamp;
    }

    public String getMyTabText() {
        return this.myTabText;
    }

    public String getFeedText() {
        return this.feedText;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            setSwitchTurn(jSONObject.optInt("switch") == 1);
            this.feedText = jSONObject.optString("feed_text");
            this.enterForumText = jSONObject.optString("enter_forum_text");
            this.myTabText = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.dotTimestamp = optLong == 0 ? "" : optLong + "";
            this.userSatisfy = jSONObject.optInt("user_satisfy") == 1;
            this.h5Url = jSONObject.optString("h5_url");
            this.personItemSwitch = jSONObject.optInt("person_item_switch") == 1;
            this.personItemText = jSONObject.optString("person_item_text");
        }
    }
}
