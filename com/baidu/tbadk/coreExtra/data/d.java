package com.baidu.tbadk.coreExtra.data;

import com.baidu.searchbox.ugc.model.UgcConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private int ezI;
    private long ezJ;
    private long ezK;
    private String ezL;
    public boolean ezV;
    public String ezW;
    public String ezX;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int ezF = 1;
    private int ezH = 0;
    private int ezM = 0;
    private int ezN = 1;
    private int ezO = 0;
    private int ezP = 0;
    private int ezQ = 300;
    private int ezR = 1;
    public int ezS = 4;
    public int ezT = 4;
    public int ezU = 7;
    private g ezG = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.ezF = jSONObject.optInt("als_control", 1);
            this.ezH = jSONObject.optInt("not_use_lego_patch", 0);
            this.ezN = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.ezP = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.ezG.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.ezI = optJSONObject.optInt("log_feed_switch", 0);
                this.ezJ = optJSONObject.optLong("start_time", -1L);
                this.ezK = optJSONObject.optLong("end_time", -1L);
                this.ezL = optJSONObject.optString(UgcConstant.EXT_INFO);
            }
            this.ezM = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.ezQ = optJSONObject2.optInt("interval", 300);
            }
            this.ezR = jSONObject.optInt("video_page_style", 1);
            this.ezO = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.ezS = optJSONObject3.optInt("first_floor");
                this.ezT = optJSONObject3.optInt("prefetch_step");
                this.ezU = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.ezV = jSONObject.optInt("afd_jump_pb") == 1;
            this.ezW = jSONObject.optString("afd_eid");
            JSONObject optJSONObject5 = jSONObject.optJSONObject("iadex_sniff_list_url");
            if (optJSONObject5 != null) {
                this.ezX = optJSONObject5.optString("os_type2_iadex_url");
                com.baidu.tbadk.util.c.CE(this.ezX);
                return;
            }
            com.baidu.tbadk.util.c.CE(null);
        }
    }

    public g bmq() {
        return this.ezG;
    }

    public boolean bmr() {
        return this.ezF > 0;
    }

    public boolean bms() {
        if (this.ezI == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.ezJ < currentTimeMillis && currentTimeMillis < this.ezK;
        }
        return false;
    }

    public boolean bmt() {
        return this.ezN == 1;
    }

    public boolean bmu() {
        return this.ezP == 1;
    }

    public String bmv() {
        return this.ezL;
    }

    public boolean bmw() {
        return this.ezM == 1;
    }

    public int bmx() {
        return this.ezQ;
    }

    public int bmy() {
        return this.ezR;
    }

    public boolean bmz() {
        return this.ezO == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
