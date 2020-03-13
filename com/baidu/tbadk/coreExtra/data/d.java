package com.baidu.tbadk.coreExtra.data;

import com.baidu.minivideo.effect.core.entity.AEffectParams;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int dlX;
    private long dlY;
    private long dlZ;
    private String dma;
    public boolean dmk;
    public String dml;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int dlU = 1;
    private int dlW = 0;
    private int dmb = 0;
    private int dmc = 1;
    private int dmd = 0;
    private int dme = 0;
    private int dmf = 300;
    private int dmg = 1;
    public int dmh = 4;
    public int dmi = 4;
    public int dmj = 7;
    private g dlV = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.dlU = jSONObject.optInt("als_control", 1);
            this.dlW = jSONObject.optInt("not_use_lego_patch", 0);
            this.dmc = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.dme = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.dlV.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.dlX = optJSONObject.optInt("log_feed_switch", 0);
                this.dlY = optJSONObject.optLong("start_time", -1L);
                this.dlZ = optJSONObject.optLong("end_time", -1L);
                this.dma = optJSONObject.optString("ext_info");
            }
            this.dmb = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.dmf = optJSONObject2.optInt("interval", 300);
            }
            this.dmg = jSONObject.optInt("video_page_style", 1);
            this.dmd = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.dmh = optJSONObject3.optInt("first_floor");
                this.dmi = optJSONObject3.optInt("prefetch_step");
                this.dmj = optJSONObject3.optInt(AEffectParams.VALUE_TYPE_STEP);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.dmk = jSONObject.optInt("afd_jump_pb") == 1;
            this.dml = jSONObject.optString("afd_eid");
        }
    }

    public g aJc() {
        return this.dlV;
    }

    public boolean aJd() {
        return this.dlU > 0;
    }

    public boolean aJe() {
        if (this.dlX == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.dlY < currentTimeMillis && currentTimeMillis < this.dlZ;
        }
        return false;
    }

    public boolean aJf() {
        return this.dmc == 1;
    }

    public boolean aJg() {
        return this.dme == 1;
    }

    public String aJh() {
        return this.dma;
    }

    public boolean aJi() {
        return this.dmb == 1;
    }

    public int aJj() {
        return this.dmf;
    }

    public int aJk() {
        return this.dmg;
    }

    public boolean aJl() {
        return this.dmd == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
