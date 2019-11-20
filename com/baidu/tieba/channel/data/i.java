package com.baidu.tieba.channel.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {
    private long eSs;
    private String intro;
    private String portrait;
    private long user_id;
    private String user_name;

    public long bbr() {
        return this.user_id;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public String getIntro() {
        return this.intro;
    }

    public void parserJson(JSONObject jSONObject) {
        this.user_id = jSONObject.optLong("user_id");
        this.user_name = jSONObject.optString("user_name");
        this.portrait = jSONObject.optString("portrait");
        this.eSs = jSONObject.optLong("channel_avatar");
        this.intro = jSONObject.optString("intro");
    }
}
