package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int cfF;
    private long cfG;
    private long cfH;
    private String cfI;
    public boolean cfS;
    public String cfT;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int cfC = 1;
    private int cfE = 0;
    private int cfJ = 0;
    private int cfK = 1;
    private int cfL = 0;
    private int cfM = 0;
    private int cfN = 300;
    private int cfO = 1;
    public int cfP = 4;
    public int cfQ = 4;
    public int cfR = 7;
    private g cfD = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.cfC = jSONObject.optInt("als_control", 1);
            this.cfE = jSONObject.optInt("not_use_lego_patch", 0);
            this.cfK = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.cfM = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.cfD.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.cfF = optJSONObject.optInt("log_feed_switch", 0);
                this.cfG = optJSONObject.optLong("start_time", -1L);
                this.cfH = optJSONObject.optLong("end_time", -1L);
                this.cfI = optJSONObject.optString("ext_info");
            }
            this.cfJ = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.cfN = optJSONObject2.optInt("interval", 300);
            }
            this.cfO = jSONObject.optInt("video_page_style", 1);
            this.cfL = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.cfP = optJSONObject3.optInt("first_floor");
                this.cfQ = optJSONObject3.optInt("prefetch_step");
                this.cfR = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.cfS = jSONObject.optInt("afd_jump_pb") == 1;
            this.cfT = jSONObject.optString("afd_eid");
        }
    }

    public g amb() {
        return this.cfD;
    }

    public boolean amc() {
        return this.cfC > 0;
    }

    public boolean amd() {
        if (this.cfF == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.cfG < currentTimeMillis && currentTimeMillis < this.cfH;
        }
        return false;
    }

    public boolean ame() {
        return this.cfK == 1;
    }

    public boolean amf() {
        return this.cfM == 1;
    }

    public String amg() {
        return this.cfI;
    }

    public boolean amh() {
        return this.cfJ == 1;
    }

    public int ami() {
        return this.cfN;
    }

    public int amj() {
        return this.cfO;
    }

    public boolean amk() {
        return this.cfL == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
