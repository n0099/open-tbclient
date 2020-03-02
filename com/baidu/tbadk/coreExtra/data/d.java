package com.baidu.tbadk.coreExtra.data;

import com.baidu.minivideo.effect.core.entity.AEffectParams;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int dlK;
    private long dlL;
    private long dlM;
    private String dlN;
    public boolean dlX;
    public String dlY;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int dlH = 1;
    private int dlJ = 0;
    private int dlO = 0;
    private int dlP = 1;
    private int dlQ = 0;
    private int dlR = 0;
    private int dlS = 300;
    private int dlT = 1;
    public int dlU = 4;
    public int dlV = 4;
    public int dlW = 7;
    private g dlI = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.dlH = jSONObject.optInt("als_control", 1);
            this.dlJ = jSONObject.optInt("not_use_lego_patch", 0);
            this.dlP = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.dlR = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.dlI.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.dlK = optJSONObject.optInt("log_feed_switch", 0);
                this.dlL = optJSONObject.optLong("start_time", -1L);
                this.dlM = optJSONObject.optLong("end_time", -1L);
                this.dlN = optJSONObject.optString("ext_info");
            }
            this.dlO = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.dlS = optJSONObject2.optInt("interval", 300);
            }
            this.dlT = jSONObject.optInt("video_page_style", 1);
            this.dlQ = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.dlU = optJSONObject3.optInt("first_floor");
                this.dlV = optJSONObject3.optInt("prefetch_step");
                this.dlW = optJSONObject3.optInt(AEffectParams.VALUE_TYPE_STEP);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.dlX = jSONObject.optInt("afd_jump_pb") == 1;
            this.dlY = jSONObject.optString("afd_eid");
        }
    }

    public g aJb() {
        return this.dlI;
    }

    public boolean aJc() {
        return this.dlH > 0;
    }

    public boolean aJd() {
        if (this.dlK == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.dlL < currentTimeMillis && currentTimeMillis < this.dlM;
        }
        return false;
    }

    public boolean aJe() {
        return this.dlP == 1;
    }

    public boolean aJf() {
        return this.dlR == 1;
    }

    public String aJg() {
        return this.dlN;
    }

    public boolean aJh() {
        return this.dlO == 1;
    }

    public int aJi() {
        return this.dlS;
    }

    public int aJj() {
        return this.dlT;
    }

    public boolean aJk() {
        return this.dlQ == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
