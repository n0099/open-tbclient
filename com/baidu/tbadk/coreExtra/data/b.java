package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private int aqR;
    private long aqS;
    private long aqT;
    private String aqU;
    private int aqO = 1;
    private int aqQ = 0;
    private int aqV = 0;
    private int aqW = 1;
    private int aqX = 0;
    private int aqY = 300;
    private int aqZ = 1;
    private d aqP = new d();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aqO = jSONObject.optInt("als_control", 1);
            this.aqQ = jSONObject.optInt("not_use_lego_patch", 0);
            this.aqW = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.aqX = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aqP.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aqR = optJSONObject.optInt("log_feed_switch", 0);
                this.aqS = optJSONObject.optLong("start_time", -1L);
                this.aqT = optJSONObject.optLong("end_time", -1L);
                this.aqU = optJSONObject.optString("ext_info");
            }
            this.aqV = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.aqY = optJSONObject2.optInt("interval", 300);
            }
            this.aqZ = jSONObject.optInt("video_page_style", 1);
        }
    }

    public d xE() {
        return this.aqP;
    }

    public boolean xF() {
        return this.aqO > 0;
    }

    public boolean xG() {
        if (this.aqR == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.aqS < currentTimeMillis && currentTimeMillis < this.aqT;
        }
        return false;
    }

    public boolean xH() {
        return this.aqW == 1;
    }

    public boolean xI() {
        return this.aqX == 1;
    }

    public String xJ() {
        return this.aqU;
    }

    public boolean xK() {
        return this.aqV == 1;
    }

    public int xL() {
        return this.aqY;
    }

    public int xM() {
        return this.aqZ;
    }
}
