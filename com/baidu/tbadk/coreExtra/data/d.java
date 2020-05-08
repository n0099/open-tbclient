package com.baidu.tbadk.coreExtra.data;

import com.baidu.searchbox.ugc.model.UgcConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int dMj;
    private long dMk;
    private long dMl;
    private String dMm;
    public boolean dMw;
    public String dMx;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int dMg = 1;
    private int dMi = 0;
    private int dMn = 0;
    private int dMo = 1;
    private int dMp = 0;
    private int dMq = 0;
    private int dMr = 300;
    private int dMs = 1;
    public int dMt = 4;
    public int dMu = 4;
    public int dMv = 7;
    private g dMh = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.dMg = jSONObject.optInt("als_control", 1);
            this.dMi = jSONObject.optInt("not_use_lego_patch", 0);
            this.dMo = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.dMq = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.dMh.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.dMj = optJSONObject.optInt("log_feed_switch", 0);
                this.dMk = optJSONObject.optLong("start_time", -1L);
                this.dMl = optJSONObject.optLong("end_time", -1L);
                this.dMm = optJSONObject.optString(UgcConstant.EXT_INFO);
            }
            this.dMn = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.dMr = optJSONObject2.optInt("interval", 300);
            }
            this.dMs = jSONObject.optInt("video_page_style", 1);
            this.dMp = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.dMt = optJSONObject3.optInt("first_floor");
                this.dMu = optJSONObject3.optInt("prefetch_step");
                this.dMv = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.dMw = jSONObject.optInt("afd_jump_pb") == 1;
            this.dMx = jSONObject.optString("afd_eid");
        }
    }

    public g aRA() {
        return this.dMh;
    }

    public boolean aRB() {
        return this.dMg > 0;
    }

    public boolean aRC() {
        if (this.dMj == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.dMk < currentTimeMillis && currentTimeMillis < this.dMl;
        }
        return false;
    }

    public boolean aRD() {
        return this.dMo == 1;
    }

    public boolean aRE() {
        return this.dMq == 1;
    }

    public String aRF() {
        return this.dMm;
    }

    public boolean aRG() {
        return this.dMn == 1;
    }

    public int aRH() {
        return this.dMr;
    }

    public int aRI() {
        return this.dMs;
    }

    public boolean aRJ() {
        return this.dMp == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
