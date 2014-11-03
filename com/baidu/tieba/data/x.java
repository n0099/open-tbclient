package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.User;
/* loaded from: classes.dex */
public class x {
    private int alt;
    private String mId = "";
    private String mName = "";
    private String alq = "";
    private String mPortrait = "";
    private int alr = 0;
    private int als = 0;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mId = jSONObject.optString("id");
                this.alr = jSONObject.optInt("user_type");
                this.als = jSONObject.optInt("is_verify");
                this.mName = jSONObject.optString("name");
                this.alq = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
                this.mPortrait = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                this.alt = jSONObject.optInt("is_friend");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(User user) {
        if (user != null) {
            try {
                this.mId = String.valueOf(user.id);
                this.alr = user.user_type.intValue();
                this.als = user.is_verify.intValue();
                this.mName = user.name;
                this.alq = user.name_show;
                this.mPortrait = user.portrait;
                this.alt = user.is_friend.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String zx() {
        return this.alq;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getIsMyFriend() {
        return this.alt;
    }
}
