package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class i {
    public String gSM;
    public long gSX;
    public long gSY;
    public String id;
    public String portrait;
    public long startTime;
    public int status;
    public String userName;

    public void parserJson(JSONObject jSONObject) {
        this.id = jSONObject.optString("id");
        this.gSX = jSONObject.optLong("sys_time");
        this.startTime = jSONObject.optLong("start_time");
        this.gSY = jSONObject.optLong("balance");
        this.status = jSONObject.optInt("status");
        this.userName = jSONObject.optString("user_name");
        this.portrait = jSONObject.optString("bd_portrait");
        this.gSM = jSONObject.optString("name_suffix");
    }
}
