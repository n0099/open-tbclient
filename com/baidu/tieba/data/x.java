package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.User;
/* loaded from: classes.dex */
public class x {
    private int alj;
    private String mId = "";
    private String mName = "";
    private String alg = "";
    private String mPortrait = "";
    private int alh = 0;
    private int ali = 0;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mId = jSONObject.optString("id");
                this.alh = jSONObject.optInt("user_type");
                this.ali = jSONObject.optInt("is_verify");
                this.mName = jSONObject.optString("name");
                this.alg = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
                this.mPortrait = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                this.alj = jSONObject.optInt("is_friend");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(User user) {
        if (user != null) {
            try {
                this.mId = String.valueOf(user.id);
                this.alh = user.user_type.intValue();
                this.ali = user.is_verify.intValue();
                this.mName = user.name;
                this.alg = user.name_show;
                this.mPortrait = user.portrait;
                this.alj = user.is_friend.intValue();
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

    public String zv() {
        return this.alg;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public int getIsMyFriend() {
        return this.alj;
    }
}
