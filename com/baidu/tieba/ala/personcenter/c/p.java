package com.baidu.tieba.ala.personcenter.c;

import android.net.http.Headers;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class p {
    public String aLn;
    public String ibN;
    public String ibO;
    public String ibP;
    public String ibQ;
    public String ibR;
    public String ibS;
    public String ibT;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ibN = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.ibO = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.ibP = jSONObject.optString("level_id");
            this.location = jSONObject.optString(Headers.LOCATION);
            this.aLn = jSONObject.optString("follow_status");
            this.ibR = jSONObject.optString("follow_count");
            this.ibQ = jSONObject.optString("fans_count");
            this.ibS = jSONObject.optString("live_count");
            this.ibT = jSONObject.optString("record_count");
        }
    }
}
