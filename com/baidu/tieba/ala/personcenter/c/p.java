package com.baidu.tieba.ala.personcenter.c;

import android.net.http.Headers;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class p {
    public String aJN;
    public String hZQ;
    public String hZR;
    public String hZS;
    public String hZT;
    public String hZU;
    public String hZV;
    public String hZW;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hZQ = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.hZR = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.hZS = jSONObject.optString("level_id");
            this.location = jSONObject.optString(Headers.LOCATION);
            this.aJN = jSONObject.optString("follow_status");
            this.hZU = jSONObject.optString("follow_count");
            this.hZT = jSONObject.optString("fans_count");
            this.hZV = jSONObject.optString("live_count");
            this.hZW = jSONObject.optString("record_count");
        }
    }
}
