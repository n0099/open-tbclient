package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p {
    public String hyA;
    public String hyt;
    public String hyu;
    public String hyv;
    public String hyw;
    public String hyx;
    public String hyy;
    public String hyz;
    public String location;
    public String portrait;
    public String sex;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hyt = jSONObject.optString("user_id");
            this.userName = jSONObject.optString("user_name");
            this.sex = jSONObject.optString("sex");
            this.hyu = jSONObject.optString("description");
            this.portrait = jSONObject.optString("portrait");
            this.hyv = jSONObject.optString("level_id");
            this.location = jSONObject.optString("location");
            this.hyw = jSONObject.optString("follow_status");
            this.hyy = jSONObject.optString("follow_count");
            this.hyx = jSONObject.optString("fans_count");
            this.hyz = jSONObject.optString("live_count");
            this.hyA = jSONObject.optString("record_count");
        }
    }
}
