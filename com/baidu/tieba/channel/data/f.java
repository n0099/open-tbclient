package com.baidu.tieba.channel.data;

import com.tencent.open.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    private String cEL;
    private String channel_avatar;
    private String channel_name;
    private String create_time;
    private String description;
    private String follow_time;
    private String user_id;

    public String ajP() {
        return this.cEL;
    }

    public String ajQ() {
        return this.channel_name;
    }

    public String getDescription() {
        return this.description;
    }

    public String ajR() {
        return this.channel_avatar;
    }

    public void parserJson(JSONObject jSONObject) {
        this.cEL = jSONObject.optString("channel_id");
        this.channel_name = jSONObject.optString("channel_name");
        this.description = jSONObject.optString(SocialConstants.PARAM_COMMENT);
        this.channel_avatar = jSONObject.optString("channel_avatar");
        this.user_id = jSONObject.optString("user_id");
        this.create_time = jSONObject.optString("create_time");
        this.follow_time = jSONObject.optString("follow_time");
    }
}
