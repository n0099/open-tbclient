package com.baidu.tbadk.coreExtra.data;

import com.baidu.minivideo.effect.core.entity.AEffectParams;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int dhD;
    private long dhE;
    private long dhF;
    private String dhG;
    public boolean dhQ;
    public String dhR;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int dhA = 1;
    private int dhC = 0;
    private int dhH = 0;
    private int dhI = 1;
    private int dhJ = 0;
    private int dhK = 0;
    private int dhL = 300;
    private int dhM = 1;
    public int dhN = 4;
    public int dhO = 4;
    public int dhP = 7;
    private g dhB = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.dhA = jSONObject.optInt("als_control", 1);
            this.dhC = jSONObject.optInt("not_use_lego_patch", 0);
            this.dhI = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.dhK = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.dhB.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.dhD = optJSONObject.optInt("log_feed_switch", 0);
                this.dhE = optJSONObject.optLong("start_time", -1L);
                this.dhF = optJSONObject.optLong("end_time", -1L);
                this.dhG = optJSONObject.optString("ext_info");
            }
            this.dhH = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.dhL = optJSONObject2.optInt("interval", 300);
            }
            this.dhM = jSONObject.optInt("video_page_style", 1);
            this.dhJ = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.dhN = optJSONObject3.optInt("first_floor");
                this.dhO = optJSONObject3.optInt("prefetch_step");
                this.dhP = optJSONObject3.optInt(AEffectParams.VALUE_TYPE_STEP);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.dhQ = jSONObject.optInt("afd_jump_pb") == 1;
            this.dhR = jSONObject.optString("afd_eid");
        }
    }

    public g aGL() {
        return this.dhB;
    }

    public boolean aGM() {
        return this.dhA > 0;
    }

    public boolean aGN() {
        if (this.dhD == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.dhE < currentTimeMillis && currentTimeMillis < this.dhF;
        }
        return false;
    }

    public boolean aGO() {
        return this.dhI == 1;
    }

    public boolean aGP() {
        return this.dhK == 1;
    }

    public String aGQ() {
        return this.dhG;
    }

    public boolean aGR() {
        return this.dhH == 1;
    }

    public int aGS() {
        return this.dhL;
    }

    public int aGT() {
        return this.dhM;
    }

    public boolean aGU() {
        return this.dhJ == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
