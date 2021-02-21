package com.baidu.tieba.ala.personcenter.c;

import android.net.http.Headers;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class p {
    public String aJN;
    public String iae;
    public String iaf;
    public String iag;
    public String iah;
    public String iai;
    public String iaj;
    public String iak;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.iae = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.iaf = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.iag = jSONObject.optString("level_id");
            this.location = jSONObject.optString(Headers.LOCATION);
            this.aJN = jSONObject.optString("follow_status");
            this.iai = jSONObject.optString("follow_count");
            this.iah = jSONObject.optString("fans_count");
            this.iaj = jSONObject.optString("live_count");
            this.iak = jSONObject.optString("record_count");
        }
    }
}
