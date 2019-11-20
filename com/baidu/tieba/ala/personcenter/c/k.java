package com.baidu.tieba.ala.personcenter.c;

import android.net.http.Headers;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k {
    public String exe;
    public String exf;
    public String exg;
    public String exh;
    public String exi;
    public String exj;
    public String exk;
    public String exl;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.exe = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.exf = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.exg = jSONObject.optString("level_id");
            this.location = jSONObject.optString(Headers.LOCATION);
            this.exh = jSONObject.optString("follow_status");
            this.exj = jSONObject.optString("follow_count");
            this.exi = jSONObject.optString("fans_count");
            this.exk = jSONObject.optString("live_count");
            this.exl = jSONObject.optString("record_count");
        }
    }
}
