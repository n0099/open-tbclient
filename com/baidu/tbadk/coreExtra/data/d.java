package com.baidu.tbadk.coreExtra.data;

import com.baidu.searchbox.ugc.model.UgcConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int ejk;
    private long ejl;
    private long ejm;
    private String ejn;
    public boolean ejx;
    public String ejy;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int ejh = 1;
    private int ejj = 0;
    private int ejo = 0;
    private int ejp = 1;
    private int ejq = 0;
    private int ejr = 0;
    private int ejs = 300;
    private int ejt = 1;
    public int eju = 4;
    public int ejv = 4;
    public int ejw = 7;
    private g eji = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.ejh = jSONObject.optInt("als_control", 1);
            this.ejj = jSONObject.optInt("not_use_lego_patch", 0);
            this.ejp = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.ejr = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.eji.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.ejk = optJSONObject.optInt("log_feed_switch", 0);
                this.ejl = optJSONObject.optLong("start_time", -1L);
                this.ejm = optJSONObject.optLong("end_time", -1L);
                this.ejn = optJSONObject.optString(UgcConstant.EXT_INFO);
            }
            this.ejo = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.ejs = optJSONObject2.optInt("interval", 300);
            }
            this.ejt = jSONObject.optInt("video_page_style", 1);
            this.ejq = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.eju = optJSONObject3.optInt("first_floor");
                this.ejv = optJSONObject3.optInt("prefetch_step");
                this.ejw = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.ejx = jSONObject.optInt("afd_jump_pb") == 1;
            this.ejy = jSONObject.optString("afd_eid");
        }
    }

    public g aZN() {
        return this.eji;
    }

    public boolean aZO() {
        return this.ejh > 0;
    }

    public boolean aZP() {
        if (this.ejk == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.ejl < currentTimeMillis && currentTimeMillis < this.ejm;
        }
        return false;
    }

    public boolean aZQ() {
        return this.ejp == 1;
    }

    public boolean aZR() {
        return this.ejr == 1;
    }

    public String aZS() {
        return this.ejn;
    }

    public boolean aZT() {
        return this.ejo == 1;
    }

    public int aZU() {
        return this.ejs;
    }

    public int aZV() {
        return this.ejt;
    }

    public boolean aZW() {
        return this.ejq == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
