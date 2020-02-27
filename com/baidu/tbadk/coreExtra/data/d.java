package com.baidu.tbadk.coreExtra.data;

import com.baidu.minivideo.effect.core.entity.AEffectParams;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int dlJ;
    private long dlK;
    private long dlL;
    private String dlM;
    public boolean dlW;
    public String dlX;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int dlG = 1;
    private int dlI = 0;
    private int dlN = 0;
    private int dlO = 1;
    private int dlP = 0;
    private int dlQ = 0;
    private int dlR = 300;
    private int dlS = 1;
    public int dlT = 4;
    public int dlU = 4;
    public int dlV = 7;
    private g dlH = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.dlG = jSONObject.optInt("als_control", 1);
            this.dlI = jSONObject.optInt("not_use_lego_patch", 0);
            this.dlO = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.dlQ = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.dlH.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.dlJ = optJSONObject.optInt("log_feed_switch", 0);
                this.dlK = optJSONObject.optLong("start_time", -1L);
                this.dlL = optJSONObject.optLong("end_time", -1L);
                this.dlM = optJSONObject.optString("ext_info");
            }
            this.dlN = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.dlR = optJSONObject2.optInt("interval", 300);
            }
            this.dlS = jSONObject.optInt("video_page_style", 1);
            this.dlP = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.dlT = optJSONObject3.optInt("first_floor");
                this.dlU = optJSONObject3.optInt("prefetch_step");
                this.dlV = optJSONObject3.optInt(AEffectParams.VALUE_TYPE_STEP);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.dlW = jSONObject.optInt("afd_jump_pb") == 1;
            this.dlX = jSONObject.optString("afd_eid");
        }
    }

    public g aIZ() {
        return this.dlH;
    }

    public boolean aJa() {
        return this.dlG > 0;
    }

    public boolean aJb() {
        if (this.dlJ == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.dlK < currentTimeMillis && currentTimeMillis < this.dlL;
        }
        return false;
    }

    public boolean aJc() {
        return this.dlO == 1;
    }

    public boolean aJd() {
        return this.dlQ == 1;
    }

    public String aJe() {
        return this.dlM;
    }

    public boolean aJf() {
        return this.dlN == 1;
    }

    public int aJg() {
        return this.dlR;
    }

    public int aJh() {
        return this.dlS;
    }

    public boolean aJi() {
        return this.dlP == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
