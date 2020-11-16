package com.baidu.tbadk.coreExtra.data;

import com.baidu.searchbox.ugc.model.UgcConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public boolean fbD;
    public String fbE;
    public String fbF;
    private int fbq;
    private long fbr;
    private long fbs;
    private String fbt;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int fbn = 1;
    private int fbp = 0;
    private int fbu = 0;
    private int fbv = 1;
    private int fbw = 0;
    private int fbx = 0;
    private int fby = 300;
    private int fbz = 1;
    public int fbA = 4;
    public int fbB = 4;
    public int fbC = 7;
    private h fbo = new h();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.fbn = jSONObject.optInt("als_control", 1);
            this.fbp = jSONObject.optInt("not_use_lego_patch", 0);
            this.fbv = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.fbx = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.fbo.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.fbq = optJSONObject.optInt("log_feed_switch", 0);
                this.fbr = optJSONObject.optLong("start_time", -1L);
                this.fbs = optJSONObject.optLong("end_time", -1L);
                this.fbt = optJSONObject.optString(UgcConstant.EXT_INFO);
            }
            this.fbu = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.fby = optJSONObject2.optInt("interval", 300);
            }
            this.fbz = jSONObject.optInt("video_page_style", 1);
            this.fbw = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.fbA = optJSONObject3.optInt("first_floor");
                this.fbB = optJSONObject3.optInt("prefetch_step");
                this.fbC = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.fbD = jSONObject.optInt("afd_jump_pb") == 1;
            this.fbE = jSONObject.optString("afd_eid");
            JSONObject optJSONObject5 = jSONObject.optJSONObject("iadex_sniff_list_url");
            if (optJSONObject5 != null) {
                this.fbF = optJSONObject5.optString("os_type2_iadex_url");
                com.baidu.tbadk.util.c.DT(this.fbF);
                return;
            }
            com.baidu.tbadk.util.c.DT(null);
        }
    }

    public h btD() {
        return this.fbo;
    }

    public boolean btE() {
        return this.fbn > 0;
    }

    public boolean btF() {
        if (this.fbq == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.fbr < currentTimeMillis && currentTimeMillis < this.fbs;
        }
        return false;
    }

    public boolean btG() {
        return this.fbv == 1;
    }

    public boolean btH() {
        return this.fbx == 1;
    }

    public String btI() {
        return this.fbt;
    }

    public boolean btJ() {
        return this.fbu == 1;
    }

    public int btK() {
        return this.fby;
    }

    public int btL() {
        return this.fbz;
    }

    public boolean btM() {
        return this.fbw == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
