package com.baidu.tieba.ala.personcenter.c;

import android.net.http.Headers;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class p {
    public String aHj;
    public String hVA;
    public String hVB;
    public String hVv;
    public String hVw;
    public String hVx;
    public String hVy;
    public String hVz;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hVv = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.hVw = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.hVx = jSONObject.optString("level_id");
            this.location = jSONObject.optString(Headers.LOCATION);
            this.aHj = jSONObject.optString("follow_status");
            this.hVz = jSONObject.optString("follow_count");
            this.hVy = jSONObject.optString("fans_count");
            this.hVA = jSONObject.optString("live_count");
            this.hVB = jSONObject.optString("record_count");
        }
    }
}
