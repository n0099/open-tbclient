package com.baidu.tieba.ala.personcenter.c;

import android.net.http.Headers;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k {
    public String exW;
    public String exX;
    public String exY;
    public String exZ;
    public String eya;
    public String eyb;
    public String eyc;
    public String eyd;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.exW = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.exX = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.exY = jSONObject.optString("level_id");
            this.location = jSONObject.optString(Headers.LOCATION);
            this.exZ = jSONObject.optString("follow_status");
            this.eyb = jSONObject.optString("follow_count");
            this.eya = jSONObject.optString("fans_count");
            this.eyc = jSONObject.optString("live_count");
            this.eyd = jSONObject.optString("record_count");
        }
    }
}
