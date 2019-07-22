package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private long cfA;
    private String cfB;
    public boolean cfL;
    public String cfM;
    private int cfy;
    private long cfz;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int cfv = 1;
    private int cfx = 0;
    private int cfC = 0;
    private int cfD = 1;
    private int cfE = 0;
    private int cfF = 0;
    private int cfG = 300;
    private int cfH = 1;
    public int cfI = 4;
    public int cfJ = 4;
    public int cfK = 7;
    private g cfw = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.cfv = jSONObject.optInt("als_control", 1);
            this.cfx = jSONObject.optInt("not_use_lego_patch", 0);
            this.cfD = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.cfF = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.cfw.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.cfy = optJSONObject.optInt("log_feed_switch", 0);
                this.cfz = optJSONObject.optLong("start_time", -1L);
                this.cfA = optJSONObject.optLong("end_time", -1L);
                this.cfB = optJSONObject.optString("ext_info");
            }
            this.cfC = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.cfG = optJSONObject2.optInt("interval", 300);
            }
            this.cfH = jSONObject.optInt("video_page_style", 1);
            this.cfE = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.cfI = optJSONObject3.optInt("first_floor");
                this.cfJ = optJSONObject3.optInt("prefetch_step");
                this.cfK = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.cfL = jSONObject.optInt("afd_jump_pb") == 1;
            this.cfM = jSONObject.optString("afd_eid");
        }
    }

    public g alZ() {
        return this.cfw;
    }

    public boolean ama() {
        return this.cfv > 0;
    }

    public boolean amb() {
        if (this.cfy == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.cfz < currentTimeMillis && currentTimeMillis < this.cfA;
        }
        return false;
    }

    public boolean amc() {
        return this.cfD == 1;
    }

    public boolean amd() {
        return this.cfF == 1;
    }

    public String ame() {
        return this.cfB;
    }

    public boolean amf() {
        return this.cfC == 1;
    }

    public int amg() {
        return this.cfG;
    }

    public int amh() {
        return this.cfH;
    }

    public boolean ami() {
        return this.cfE == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
