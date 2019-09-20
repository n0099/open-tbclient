package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private long cgA;
    private String cgB;
    public boolean cgL;
    public String cgM;
    private int cgy;
    private long cgz;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int cgv = 1;
    private int cgx = 0;
    private int cgC = 0;
    private int cgD = 1;
    private int cgE = 0;
    private int cgF = 0;
    private int cgG = 300;
    private int cgH = 1;
    public int cgI = 4;
    public int cgJ = 4;
    public int cgK = 7;
    private g cgw = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.cgv = jSONObject.optInt("als_control", 1);
            this.cgx = jSONObject.optInt("not_use_lego_patch", 0);
            this.cgD = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.cgF = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.cgw.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.cgy = optJSONObject.optInt("log_feed_switch", 0);
                this.cgz = optJSONObject.optLong("start_time", -1L);
                this.cgA = optJSONObject.optLong("end_time", -1L);
                this.cgB = optJSONObject.optString("ext_info");
            }
            this.cgC = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.cgG = optJSONObject2.optInt("interval", 300);
            }
            this.cgH = jSONObject.optInt("video_page_style", 1);
            this.cgE = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.cgI = optJSONObject3.optInt("first_floor");
                this.cgJ = optJSONObject3.optInt("prefetch_step");
                this.cgK = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.cgL = jSONObject.optInt("afd_jump_pb") == 1;
            this.cgM = jSONObject.optString("afd_eid");
        }
    }

    public g amn() {
        return this.cgw;
    }

    public boolean amo() {
        return this.cgv > 0;
    }

    public boolean amp() {
        if (this.cgy == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.cgz < currentTimeMillis && currentTimeMillis < this.cgA;
        }
        return false;
    }

    public boolean amq() {
        return this.cgD == 1;
    }

    public boolean amr() {
        return this.cgF == 1;
    }

    public String ams() {
        return this.cgB;
    }

    public boolean amt() {
        return this.cgC == 1;
    }

    public int amu() {
        return this.cgG;
    }

    public int amv() {
        return this.cgH;
    }

    public boolean amw() {
        return this.cgE == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
