package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int ctF;
    private long ctG;
    private long ctH;
    private String ctI;
    public boolean ctS;
    public String ctT;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int ctC = 1;
    private int ctE = 0;
    private int ctJ = 0;
    private int ctK = 1;
    private int ctL = 0;
    private int ctM = 0;
    private int ctN = 300;
    private int ctO = 1;
    public int ctP = 4;
    public int ctQ = 4;
    public int ctR = 7;
    private g ctD = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.ctC = jSONObject.optInt("als_control", 1);
            this.ctE = jSONObject.optInt("not_use_lego_patch", 0);
            this.ctK = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.ctM = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.ctD.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.ctF = optJSONObject.optInt("log_feed_switch", 0);
                this.ctG = optJSONObject.optLong("start_time", -1L);
                this.ctH = optJSONObject.optLong("end_time", -1L);
                this.ctI = optJSONObject.optString("ext_info");
            }
            this.ctJ = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.ctN = optJSONObject2.optInt("interval", 300);
            }
            this.ctO = jSONObject.optInt("video_page_style", 1);
            this.ctL = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.ctP = optJSONObject3.optInt("first_floor");
                this.ctQ = optJSONObject3.optInt("prefetch_step");
                this.ctR = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.ctS = jSONObject.optInt("afd_jump_pb") == 1;
            this.ctT = jSONObject.optString("afd_eid");
        }
    }

    public g aoQ() {
        return this.ctD;
    }

    public boolean aoR() {
        return this.ctC > 0;
    }

    public boolean aoS() {
        if (this.ctF == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.ctG < currentTimeMillis && currentTimeMillis < this.ctH;
        }
        return false;
    }

    public boolean aoT() {
        return this.ctK == 1;
    }

    public boolean aoU() {
        return this.ctM == 1;
    }

    public String aoV() {
        return this.ctI;
    }

    public boolean aoW() {
        return this.ctJ == 1;
    }

    public int aoX() {
        return this.ctN;
    }

    public int aoY() {
        return this.ctO;
    }

    public boolean aoZ() {
        return this.ctL == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
