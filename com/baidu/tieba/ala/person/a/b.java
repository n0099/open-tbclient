package com.baidu.tieba.ala.person.a;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public int dRF;
    public int dRG;
    public String id;
    public String intro;
    public int live_status;
    public String metaKey;
    public String name;
    public String name_show;
    public String portrait;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.id = jSONObject.optString("id");
            this.metaKey = jSONObject.optString("meta_key");
            this.name = jSONObject.optString("name");
            this.name_show = jSONObject.optString("name_show");
            this.portrait = jSONObject.optString("bd_portrait");
            if (StringUtils.isNull(this.portrait)) {
                this.portrait = jSONObject.optString("portrait");
            }
            this.intro = jSONObject.optString("intro");
            this.live_status = jSONObject.optInt("live_status");
            this.dRF = jSONObject.optInt("live_id");
            this.dRG = jSONObject.optInt("has_concerned");
        }
    }

    public String getNameShow() {
        return TextUtils.isEmpty(this.name_show) ? this.name : this.name_show;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("name", this.name);
            jSONObject.put("name_show", this.name_show);
            jSONObject.put("portrait", this.portrait);
            jSONObject.put("intro", this.intro);
            jSONObject.put("live_status", this.live_status);
            jSONObject.put("live_id", this.dRF);
            jSONObject.put("has_concerned", this.dRG);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
