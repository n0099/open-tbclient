package com.baidu.tieba.ala.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class i {
    public long gSJ;
    public long gSK;
    public String gSy;
    public String id;
    public String portrait;
    public long startTime;
    public int status;
    public String userName;

    public void parserJson(JSONObject jSONObject) {
        this.id = jSONObject.optString("id");
        this.gSJ = jSONObject.optLong("sys_time");
        this.startTime = jSONObject.optLong("start_time");
        this.gSK = jSONObject.optLong("balance");
        this.status = jSONObject.optInt("status");
        this.userName = jSONObject.optString("user_name");
        this.portrait = jSONObject.optString("bd_portrait");
        this.gSy = jSONObject.optString("name_suffix");
    }
}
