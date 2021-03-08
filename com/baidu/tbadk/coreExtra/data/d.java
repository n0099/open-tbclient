package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int frI;
    private long frJ;
    private long frK;
    private String frL;
    public boolean frV;
    public String frW;
    public String frX;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int frF = 1;
    private int frH = 0;
    private int frM = 0;
    private int frN = 1;
    private int frO = 0;
    private int frP = 0;
    private int frQ = 300;
    private int frR = 1;
    public int frS = 4;
    public int frT = 4;
    public int frU = 7;
    private h frG = new h();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.frF = jSONObject.optInt("als_control", 1);
            this.frH = jSONObject.optInt("not_use_lego_patch", 0);
            this.frN = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.frP = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.frG.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.frI = optJSONObject.optInt("log_feed_switch", 0);
                this.frJ = optJSONObject.optLong("start_time", -1L);
                this.frK = optJSONObject.optLong("end_time", -1L);
                this.frL = optJSONObject.optString("ext_info");
            }
            this.frM = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.frQ = optJSONObject2.optInt("interval", 300);
            }
            this.frR = jSONObject.optInt("video_page_style", 1);
            com.baidu.tbadk.core.sharedPref.b.brR().putInt("video_page_style", this.frR);
            this.frO = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.frS = optJSONObject3.optInt("first_floor");
                this.frT = optJSONObject3.optInt("prefetch_step");
                this.frU = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.frV = jSONObject.optInt("afd_jump_pb") == 1;
            this.frW = jSONObject.optString("afd_eid");
            JSONObject optJSONObject5 = jSONObject.optJSONObject("iadex_sniff_list_url");
            if (optJSONObject5 != null) {
                this.frX = optJSONObject5.optString("os_type2_iadex_url");
                com.baidu.tbadk.util.d.DP(this.frX);
                return;
            }
            com.baidu.tbadk.util.d.DP(null);
        }
    }

    public h bvZ() {
        return this.frG;
    }

    public boolean bwa() {
        return this.frF > 0;
    }

    public boolean bwb() {
        if (this.frI == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.frJ < currentTimeMillis && currentTimeMillis < this.frK;
        }
        return false;
    }

    public boolean bwc() {
        return this.frN == 1;
    }

    public boolean bwd() {
        return this.frP == 1;
    }

    public String bwe() {
        return this.frL;
    }

    public boolean bwf() {
        return this.frM == 1;
    }

    public int bwg() {
        return this.frQ;
    }

    public boolean bwh() {
        return this.frO == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
