package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {
    public long gAn;
    public long gAo;
    public String id;
    public String portrait;
    public long startTime;
    public int status;
    public String userName;

    public void parserJson(JSONObject jSONObject) {
        this.id = jSONObject.optString("id");
        this.gAn = jSONObject.optLong("sys_time");
        this.startTime = jSONObject.optLong("start_time");
        this.gAo = jSONObject.optLong("balance");
        this.status = jSONObject.optInt("status");
        this.userName = jSONObject.optString("user_name");
        this.portrait = jSONObject.optString("bd_portrait");
    }
}
