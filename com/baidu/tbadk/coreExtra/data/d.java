package com.baidu.tbadk.coreExtra.data;

import com.baidu.searchbox.ugc.model.UgcConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int eNX;
    private long eNY;
    private long eNZ;
    private String eOa;
    public boolean eOk;
    public String eOl;
    public String eOm;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int eNU = 1;
    private int eNW = 0;
    private int eOb = 0;
    private int eOc = 1;
    private int eOd = 0;
    private int eOe = 0;
    private int eOf = 300;
    private int eOg = 1;
    public int eOh = 4;
    public int eOi = 4;
    public int eOj = 7;
    private h eNV = new h();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.eNU = jSONObject.optInt("als_control", 1);
            this.eNW = jSONObject.optInt("not_use_lego_patch", 0);
            this.eOc = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.eOe = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.eNV.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.eNX = optJSONObject.optInt("log_feed_switch", 0);
                this.eNY = optJSONObject.optLong("start_time", -1L);
                this.eNZ = optJSONObject.optLong("end_time", -1L);
                this.eOa = optJSONObject.optString(UgcConstant.EXT_INFO);
            }
            this.eOb = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.eOf = optJSONObject2.optInt("interval", 300);
            }
            this.eOg = jSONObject.optInt("video_page_style", 1);
            this.eOd = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.eOh = optJSONObject3.optInt("first_floor");
                this.eOi = optJSONObject3.optInt("prefetch_step");
                this.eOj = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.eOk = jSONObject.optInt("afd_jump_pb") == 1;
            this.eOl = jSONObject.optString("afd_eid");
            JSONObject optJSONObject5 = jSONObject.optJSONObject("iadex_sniff_list_url");
            if (optJSONObject5 != null) {
                this.eOm = optJSONObject5.optString("os_type2_iadex_url");
                com.baidu.tbadk.util.c.DN(this.eOm);
                return;
            }
            com.baidu.tbadk.util.c.DN(null);
        }
    }

    public h bpU() {
        return this.eNV;
    }

    public boolean bpV() {
        return this.eNU > 0;
    }

    public boolean bpW() {
        if (this.eNX == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.eNY < currentTimeMillis && currentTimeMillis < this.eNZ;
        }
        return false;
    }

    public boolean bpX() {
        return this.eOc == 1;
    }

    public boolean bpY() {
        return this.eOe == 1;
    }

    public String bpZ() {
        return this.eOa;
    }

    public boolean bqa() {
        return this.eOb == 1;
    }

    public int bqb() {
        return this.eOf;
    }

    public int bqc() {
        return this.eOg;
    }

    public boolean bqd() {
        return this.eOd == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
