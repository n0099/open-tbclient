package com.baidu.tbadk.coreExtra.data;

import com.baidu.minivideo.effect.core.entity.AEffectParams;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int dmk;
    private long dml;
    private long dmm;
    private String dmn;
    public boolean dmx;
    public String dmy;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int dmh = 1;
    private int dmj = 0;
    private int dmo = 0;
    private int dmp = 1;
    private int dmq = 0;
    private int dmr = 0;
    private int dms = 300;
    private int dmt = 1;
    public int dmu = 4;
    public int dmv = 4;
    public int dmw = 7;
    private g dmi = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.dmh = jSONObject.optInt("als_control", 1);
            this.dmj = jSONObject.optInt("not_use_lego_patch", 0);
            this.dmp = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.dmr = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.dmi.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.dmk = optJSONObject.optInt("log_feed_switch", 0);
                this.dml = optJSONObject.optLong("start_time", -1L);
                this.dmm = optJSONObject.optLong("end_time", -1L);
                this.dmn = optJSONObject.optString("ext_info");
            }
            this.dmo = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.dms = optJSONObject2.optInt("interval", 300);
            }
            this.dmt = jSONObject.optInt("video_page_style", 1);
            this.dmq = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.dmu = optJSONObject3.optInt("first_floor");
                this.dmv = optJSONObject3.optInt("prefetch_step");
                this.dmw = optJSONObject3.optInt(AEffectParams.VALUE_TYPE_STEP);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.dmx = jSONObject.optInt("afd_jump_pb") == 1;
            this.dmy = jSONObject.optString("afd_eid");
        }
    }

    public g aJg() {
        return this.dmi;
    }

    public boolean aJh() {
        return this.dmh > 0;
    }

    public boolean aJi() {
        if (this.dmk == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.dml < currentTimeMillis && currentTimeMillis < this.dmm;
        }
        return false;
    }

    public boolean aJj() {
        return this.dmp == 1;
    }

    public boolean aJk() {
        return this.dmr == 1;
    }

    public String aJl() {
        return this.dmn;
    }

    public boolean aJm() {
        return this.dmo == 1;
    }

    public int aJn() {
        return this.dms;
    }

    public int aJo() {
        return this.dmt;
    }

    public boolean aJp() {
        return this.dmq == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
