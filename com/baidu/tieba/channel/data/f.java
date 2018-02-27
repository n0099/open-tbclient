package com.baidu.tieba.channel.data;

import com.sina.weibo.sdk.constant.WBConstants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    private String channel_avatar;
    private String channel_name;
    private String create_time;
    private String dcL;
    private String description;
    private String follow_time;
    private String user_id;

    public String aml() {
        return this.dcL;
    }

    public String amm() {
        return this.channel_name;
    }

    public String getDescription() {
        return this.description;
    }

    public String amn() {
        return this.channel_avatar;
    }

    public void parserJson(JSONObject jSONObject) {
        this.dcL = jSONObject.optString("channel_id");
        this.channel_name = jSONObject.optString("channel_name");
        this.description = jSONObject.optString("description");
        this.channel_avatar = jSONObject.optString("channel_avatar");
        this.user_id = jSONObject.optString("user_id");
        this.create_time = jSONObject.optString(WBConstants.GAME_PARAMS_GAME_CREATE_TIME);
        this.follow_time = jSONObject.optString("follow_time");
    }
}
