package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private long fsA;
    private long fsB;
    private String fsC;
    public boolean fsM;
    public String fsN;
    public String fsO;
    private int fsz;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int fsw = 1;
    private int fsy = 0;
    private int fsD = 0;
    private int fsE = 1;
    private int fsF = 0;
    private int fsG = 0;
    private int fsH = 300;
    private int fsI = 1;
    public int fsJ = 4;
    public int fsK = 4;
    public int fsL = 7;
    private h fsx = new h();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.fsw = jSONObject.optInt("als_control", 1);
            this.fsy = jSONObject.optInt("not_use_lego_patch", 0);
            this.fsE = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.fsG = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.fsx.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.fsz = optJSONObject.optInt("log_feed_switch", 0);
                this.fsA = optJSONObject.optLong("start_time", -1L);
                this.fsB = optJSONObject.optLong("end_time", -1L);
                this.fsC = optJSONObject.optString("ext_info");
            }
            this.fsD = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.fsH = optJSONObject2.optInt("interval", 300);
            }
            this.fsI = jSONObject.optInt("video_page_style", 1);
            com.baidu.tbadk.core.sharedPref.b.bvq().putInt("video_page_style", this.fsI);
            this.fsF = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.fsJ = optJSONObject3.optInt("first_floor");
                this.fsK = optJSONObject3.optInt("prefetch_step");
                this.fsL = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.fsM = jSONObject.optInt("afd_jump_pb") == 1;
            this.fsN = jSONObject.optString("afd_eid");
            JSONObject optJSONObject5 = jSONObject.optJSONObject("iadex_sniff_list_url");
            if (optJSONObject5 != null) {
                this.fsO = optJSONObject5.optString("os_type2_iadex_url");
                com.baidu.tbadk.util.c.EE(this.fsO);
                return;
            }
            com.baidu.tbadk.util.c.EE(null);
        }
    }

    public h bzw() {
        return this.fsx;
    }

    public boolean bzx() {
        return this.fsw > 0;
    }

    public boolean bzy() {
        if (this.fsz == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.fsA < currentTimeMillis && currentTimeMillis < this.fsB;
        }
        return false;
    }

    public boolean bzz() {
        return this.fsE == 1;
    }

    public boolean bzA() {
        return this.fsG == 1;
    }

    public String bzB() {
        return this.fsC;
    }

    public boolean bzC() {
        return this.fsD == 1;
    }

    public int bzD() {
        return this.fsH;
    }

    public boolean bzE() {
        return this.fsF == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
