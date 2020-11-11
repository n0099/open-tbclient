package com.baidu.tbadk.coreExtra.data;

import com.baidu.searchbox.ugc.model.UgcConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int fci;
    private long fcj;
    private long fck;
    private String fcl;
    public boolean fcw;
    public String fcx;
    public String fcy;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int fcf = 1;
    private int fch = 0;
    private int fcm = 0;
    private int fcn = 1;
    private int fco = 0;
    private int fcq = 0;
    private int fcr = 300;
    private int fcs = 1;
    public int fct = 4;
    public int fcu = 4;
    public int fcv = 7;
    private h fcg = new h();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.fcf = jSONObject.optInt("als_control", 1);
            this.fch = jSONObject.optInt("not_use_lego_patch", 0);
            this.fcn = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.fcq = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.fcg.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.fci = optJSONObject.optInt("log_feed_switch", 0);
                this.fcj = optJSONObject.optLong("start_time", -1L);
                this.fck = optJSONObject.optLong("end_time", -1L);
                this.fcl = optJSONObject.optString(UgcConstant.EXT_INFO);
            }
            this.fcm = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.fcr = optJSONObject2.optInt("interval", 300);
            }
            this.fcs = jSONObject.optInt("video_page_style", 1);
            this.fco = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.fct = optJSONObject3.optInt("first_floor");
                this.fcu = optJSONObject3.optInt("prefetch_step");
                this.fcv = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.fcw = jSONObject.optInt("afd_jump_pb") == 1;
            this.fcx = jSONObject.optString("afd_eid");
            JSONObject optJSONObject5 = jSONObject.optJSONObject("iadex_sniff_list_url");
            if (optJSONObject5 != null) {
                this.fcy = optJSONObject5.optString("os_type2_iadex_url");
                com.baidu.tbadk.util.c.Eu(this.fcy);
                return;
            }
            com.baidu.tbadk.util.c.Eu(null);
        }
    }

    public h bun() {
        return this.fcg;
    }

    public boolean buo() {
        return this.fcf > 0;
    }

    public boolean bup() {
        if (this.fci == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.fcj < currentTimeMillis && currentTimeMillis < this.fck;
        }
        return false;
    }

    public boolean buq() {
        return this.fcn == 1;
    }

    public boolean bur() {
        return this.fcq == 1;
    }

    public String bus() {
        return this.fcl;
    }

    public boolean but() {
        return this.fcm == 1;
    }

    public int buu() {
        return this.fcr;
    }

    public int buv() {
        return this.fcs;
    }

    public boolean buw() {
        return this.fco == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
