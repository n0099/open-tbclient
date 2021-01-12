package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int fnO;
    private long fnP;
    private long fnQ;
    private String fnR;
    public boolean fob;
    public String foc;
    public String fod;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int fnL = 1;
    private int fnN = 0;
    private int fnS = 0;
    private int fnT = 1;
    private int fnU = 0;
    private int fnV = 0;
    private int fnW = 300;
    private int fnX = 1;
    public int fnY = 4;
    public int fnZ = 4;
    public int foa = 7;
    private h fnM = new h();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.fnL = jSONObject.optInt("als_control", 1);
            this.fnN = jSONObject.optInt("not_use_lego_patch", 0);
            this.fnT = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.fnV = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.fnM.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.fnO = optJSONObject.optInt("log_feed_switch", 0);
                this.fnP = optJSONObject.optLong("start_time", -1L);
                this.fnQ = optJSONObject.optLong("end_time", -1L);
                this.fnR = optJSONObject.optString("ext_info");
            }
            this.fnS = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.fnW = optJSONObject2.optInt("interval", 300);
            }
            this.fnX = jSONObject.optInt("video_page_style", 1);
            com.baidu.tbadk.core.sharedPref.b.brx().putInt("video_page_style", this.fnX);
            this.fnU = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.fnY = optJSONObject3.optInt("first_floor");
                this.fnZ = optJSONObject3.optInt("prefetch_step");
                this.foa = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.fob = jSONObject.optInt("afd_jump_pb") == 1;
            this.foc = jSONObject.optString("afd_eid");
            JSONObject optJSONObject5 = jSONObject.optJSONObject("iadex_sniff_list_url");
            if (optJSONObject5 != null) {
                this.fod = optJSONObject5.optString("os_type2_iadex_url");
                com.baidu.tbadk.util.c.Ds(this.fod);
                return;
            }
            com.baidu.tbadk.util.c.Ds(null);
        }
    }

    public h bvD() {
        return this.fnM;
    }

    public boolean bvE() {
        return this.fnL > 0;
    }

    public boolean bvF() {
        if (this.fnO == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.fnP < currentTimeMillis && currentTimeMillis < this.fnQ;
        }
        return false;
    }

    public boolean bvG() {
        return this.fnT == 1;
    }

    public boolean bvH() {
        return this.fnV == 1;
    }

    public String bvI() {
        return this.fnR;
    }

    public boolean bvJ() {
        return this.fnS == 1;
    }

    public int bvK() {
        return this.fnW;
    }

    public boolean bvL() {
        return this.fnU == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
