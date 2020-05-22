package com.baidu.tbadk.coreExtra.data;

import com.baidu.searchbox.ugc.model.UgcConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int eaA;
    private long eaB;
    private long eaC;
    private String eaD;
    public boolean eaN;
    public String eaO;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int eax = 1;
    private int eaz = 0;
    private int eaE = 0;
    private int eaF = 1;
    private int eaG = 0;
    private int eaH = 0;
    private int eaI = 300;
    private int eaJ = 1;
    public int eaK = 4;
    public int eaL = 4;
    public int eaM = 7;
    private g eay = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.eax = jSONObject.optInt("als_control", 1);
            this.eaz = jSONObject.optInt("not_use_lego_patch", 0);
            this.eaF = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.eaH = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.eay.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.eaA = optJSONObject.optInt("log_feed_switch", 0);
                this.eaB = optJSONObject.optLong("start_time", -1L);
                this.eaC = optJSONObject.optLong("end_time", -1L);
                this.eaD = optJSONObject.optString(UgcConstant.EXT_INFO);
            }
            this.eaE = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.eaI = optJSONObject2.optInt("interval", 300);
            }
            this.eaJ = jSONObject.optInt("video_page_style", 1);
            this.eaG = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.eaK = optJSONObject3.optInt("first_floor");
                this.eaL = optJSONObject3.optInt("prefetch_step");
                this.eaM = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.eaN = jSONObject.optInt("afd_jump_pb") == 1;
            this.eaO = jSONObject.optString("afd_eid");
        }
    }

    public g aXH() {
        return this.eay;
    }

    public boolean aXI() {
        return this.eax > 0;
    }

    public boolean aXJ() {
        if (this.eaA == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.eaB < currentTimeMillis && currentTimeMillis < this.eaC;
        }
        return false;
    }

    public boolean aXK() {
        return this.eaF == 1;
    }

    public boolean aXL() {
        return this.eaH == 1;
    }

    public String aXM() {
        return this.eaD;
    }

    public boolean aXN() {
        return this.eaE == 1;
    }

    public int aXO() {
        return this.eaI;
    }

    public int aXP() {
        return this.eaJ;
    }

    public boolean aXQ() {
        return this.eaG == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
