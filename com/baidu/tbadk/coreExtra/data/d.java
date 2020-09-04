package com.baidu.tbadk.coreExtra.data;

import com.baidu.searchbox.ugc.model.UgcConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public String eAa;
    public String eAb;
    private int ezM;
    private long ezN;
    private long ezO;
    private String ezP;
    public boolean ezZ;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int ezJ = 1;
    private int ezL = 0;
    private int ezQ = 0;
    private int ezR = 1;
    private int ezS = 0;
    private int ezT = 0;
    private int ezU = 300;
    private int ezV = 1;
    public int ezW = 4;
    public int ezX = 4;
    public int ezY = 7;
    private g ezK = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.ezJ = jSONObject.optInt("als_control", 1);
            this.ezL = jSONObject.optInt("not_use_lego_patch", 0);
            this.ezR = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.ezT = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.ezK.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.ezM = optJSONObject.optInt("log_feed_switch", 0);
                this.ezN = optJSONObject.optLong("start_time", -1L);
                this.ezO = optJSONObject.optLong("end_time", -1L);
                this.ezP = optJSONObject.optString(UgcConstant.EXT_INFO);
            }
            this.ezQ = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.ezU = optJSONObject2.optInt("interval", 300);
            }
            this.ezV = jSONObject.optInt("video_page_style", 1);
            this.ezS = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.ezW = optJSONObject3.optInt("first_floor");
                this.ezX = optJSONObject3.optInt("prefetch_step");
                this.ezY = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.ezZ = jSONObject.optInt("afd_jump_pb") == 1;
            this.eAa = jSONObject.optString("afd_eid");
            JSONObject optJSONObject5 = jSONObject.optJSONObject("iadex_sniff_list_url");
            if (optJSONObject5 != null) {
                this.eAb = optJSONObject5.optString("os_type2_iadex_url");
                com.baidu.tbadk.util.c.CF(this.eAb);
                return;
            }
            com.baidu.tbadk.util.c.CF(null);
        }
    }

    public g bmq() {
        return this.ezK;
    }

    public boolean bmr() {
        return this.ezJ > 0;
    }

    public boolean bms() {
        if (this.ezM == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.ezN < currentTimeMillis && currentTimeMillis < this.ezO;
        }
        return false;
    }

    public boolean bmt() {
        return this.ezR == 1;
    }

    public boolean bmu() {
        return this.ezT == 1;
    }

    public String bmv() {
        return this.ezP;
    }

    public boolean bmw() {
        return this.ezQ == 1;
    }

    public int bmx() {
        return this.ezU;
    }

    public int bmy() {
        return this.ezV;
    }

    public boolean bmz() {
        return this.ezS == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
