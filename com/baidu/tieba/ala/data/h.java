package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    public long fsD;
    public long fsE;
    public String id;
    public String portrait;
    public long startTime;
    public int status;
    public String userName;

    public void parserJson(JSONObject jSONObject) {
        this.id = jSONObject.optString("id");
        this.fsD = jSONObject.optLong("sys_time");
        this.startTime = jSONObject.optLong("start_time");
        this.fsE = jSONObject.optLong("balance");
        this.status = jSONObject.optInt("status");
        this.userName = jSONObject.optString("user_name");
        this.portrait = jSONObject.optString("bd_portrait");
    }
}
