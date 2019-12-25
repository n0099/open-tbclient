package com.baidu.tbadk.coreExtra.data;

import com.baidu.minivideo.effect.core.entity.AEffectParams;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public boolean dhE;
    public String dhF;
    private int dhr;
    private long dhs;
    private long dht;
    private String dhu;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int dho = 1;
    private int dhq = 0;
    private int dhv = 0;
    private int dhw = 1;
    private int dhx = 0;
    private int dhy = 0;
    private int dhz = 300;
    private int dhA = 1;
    public int dhB = 4;
    public int dhC = 4;
    public int dhD = 7;
    private g dhp = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.dho = jSONObject.optInt("als_control", 1);
            this.dhq = jSONObject.optInt("not_use_lego_patch", 0);
            this.dhw = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.dhy = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.dhp.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.dhr = optJSONObject.optInt("log_feed_switch", 0);
                this.dhs = optJSONObject.optLong("start_time", -1L);
                this.dht = optJSONObject.optLong("end_time", -1L);
                this.dhu = optJSONObject.optString("ext_info");
            }
            this.dhv = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.dhz = optJSONObject2.optInt("interval", 300);
            }
            this.dhA = jSONObject.optInt("video_page_style", 1);
            this.dhx = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.dhB = optJSONObject3.optInt("first_floor");
                this.dhC = optJSONObject3.optInt("prefetch_step");
                this.dhD = optJSONObject3.optInt(AEffectParams.VALUE_TYPE_STEP);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.dhE = jSONObject.optInt("afd_jump_pb") == 1;
            this.dhF = jSONObject.optString("afd_eid");
        }
    }

    public g aGs() {
        return this.dhp;
    }

    public boolean aGt() {
        return this.dho > 0;
    }

    public boolean aGu() {
        if (this.dhr == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.dhs < currentTimeMillis && currentTimeMillis < this.dht;
        }
        return false;
    }

    public boolean aGv() {
        return this.dhw == 1;
    }

    public boolean aGw() {
        return this.dhy == 1;
    }

    public String aGx() {
        return this.dhu;
    }

    public boolean aGy() {
        return this.dhv == 1;
    }

    public int aGz() {
        return this.dhz;
    }

    public int aGA() {
        return this.dhA;
    }

    public boolean aGB() {
        return this.dhx == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
