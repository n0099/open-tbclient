package com.baidu.tbadk.coreExtra.data;

import com.baidu.searchbox.ugc.model.UgcConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int dMf;
    private long dMg;
    private long dMh;
    private String dMi;
    public boolean dMs;
    public String dMt;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int dMc = 1;
    private int dMe = 0;
    private int dMj = 0;
    private int dMk = 1;
    private int dMl = 0;
    private int dMm = 0;
    private int dMn = 300;
    private int dMo = 1;
    public int dMp = 4;
    public int dMq = 4;
    public int dMr = 7;
    private g dMd = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.dMc = jSONObject.optInt("als_control", 1);
            this.dMe = jSONObject.optInt("not_use_lego_patch", 0);
            this.dMk = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.dMm = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.dMd.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.dMf = optJSONObject.optInt("log_feed_switch", 0);
                this.dMg = optJSONObject.optLong("start_time", -1L);
                this.dMh = optJSONObject.optLong("end_time", -1L);
                this.dMi = optJSONObject.optString(UgcConstant.EXT_INFO);
            }
            this.dMj = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.dMn = optJSONObject2.optInt("interval", 300);
            }
            this.dMo = jSONObject.optInt("video_page_style", 1);
            this.dMl = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.dMp = optJSONObject3.optInt("first_floor");
                this.dMq = optJSONObject3.optInt("prefetch_step");
                this.dMr = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.dMs = jSONObject.optInt("afd_jump_pb") == 1;
            this.dMt = jSONObject.optString("afd_eid");
        }
    }

    public g aRD() {
        return this.dMd;
    }

    public boolean aRE() {
        return this.dMc > 0;
    }

    public boolean aRF() {
        if (this.dMf == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.dMg < currentTimeMillis && currentTimeMillis < this.dMh;
        }
        return false;
    }

    public boolean aRG() {
        return this.dMk == 1;
    }

    public boolean aRH() {
        return this.dMm == 1;
    }

    public String aRI() {
        return this.dMi;
    }

    public boolean aRJ() {
        return this.dMj == 1;
    }

    public int aRK() {
        return this.dMn;
    }

    public int aRL() {
        return this.dMo;
    }

    public boolean aRM() {
        return this.dMl == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
