package com.baidu.tbadk.coreExtra.data;

import com.baidu.searchbox.ugc.model.UgcConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public boolean eWG;
    public String eWH;
    public String eWI;
    private int eWt;
    private long eWu;
    private long eWv;
    private String eWw;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int eWq = 1;
    private int eWs = 0;
    private int eWx = 0;
    private int eWy = 1;
    private int eWz = 0;
    private int eWA = 0;
    private int eWB = 300;
    private int eWC = 1;
    public int eWD = 4;
    public int eWE = 4;
    public int eWF = 7;
    private h eWr = new h();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.eWq = jSONObject.optInt("als_control", 1);
            this.eWs = jSONObject.optInt("not_use_lego_patch", 0);
            this.eWy = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.eWA = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.eWr.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.eWt = optJSONObject.optInt("log_feed_switch", 0);
                this.eWu = optJSONObject.optLong("start_time", -1L);
                this.eWv = optJSONObject.optLong("end_time", -1L);
                this.eWw = optJSONObject.optString(UgcConstant.EXT_INFO);
            }
            this.eWx = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.eWB = optJSONObject2.optInt("interval", 300);
            }
            this.eWC = jSONObject.optInt("video_page_style", 1);
            this.eWz = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.eWD = optJSONObject3.optInt("first_floor");
                this.eWE = optJSONObject3.optInt("prefetch_step");
                this.eWF = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.eWG = jSONObject.optInt("afd_jump_pb") == 1;
            this.eWH = jSONObject.optString("afd_eid");
            JSONObject optJSONObject5 = jSONObject.optJSONObject("iadex_sniff_list_url");
            if (optJSONObject5 != null) {
                this.eWI = optJSONObject5.optString("os_type2_iadex_url");
                com.baidu.tbadk.util.c.Eg(this.eWI);
                return;
            }
            com.baidu.tbadk.util.c.Eg(null);
        }
    }

    public h brN() {
        return this.eWr;
    }

    public boolean brO() {
        return this.eWq > 0;
    }

    public boolean brP() {
        if (this.eWt == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.eWu < currentTimeMillis && currentTimeMillis < this.eWv;
        }
        return false;
    }

    public boolean brQ() {
        return this.eWy == 1;
    }

    public boolean brR() {
        return this.eWA == 1;
    }

    public String brS() {
        return this.eWw;
    }

    public boolean brT() {
        return this.eWx == 1;
    }

    public int brU() {
        return this.eWB;
    }

    public int brV() {
        return this.eWC;
    }

    public boolean brW() {
        return this.eWz == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
