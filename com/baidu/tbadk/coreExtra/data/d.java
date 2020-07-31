package com.baidu.tbadk.coreExtra.data;

import com.baidu.searchbox.ugc.model.UgcConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public boolean epJ;
    public String epK;
    public String epL;
    private int epw;
    private long epx;
    private long epy;
    private String epz;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int ept = 1;
    private int epv = 0;
    private int epA = 0;
    private int epB = 1;
    private int epC = 0;
    private int epD = 0;
    private int epE = 300;
    private int epF = 1;
    public int epG = 4;
    public int epH = 4;
    public int epI = 7;
    private g epu = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.ept = jSONObject.optInt("als_control", 1);
            this.epv = jSONObject.optInt("not_use_lego_patch", 0);
            this.epB = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.epD = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.epu.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.epw = optJSONObject.optInt("log_feed_switch", 0);
                this.epx = optJSONObject.optLong("start_time", -1L);
                this.epy = optJSONObject.optLong("end_time", -1L);
                this.epz = optJSONObject.optString(UgcConstant.EXT_INFO);
            }
            this.epA = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.epE = optJSONObject2.optInt("interval", 300);
            }
            this.epF = jSONObject.optInt("video_page_style", 1);
            this.epC = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.epG = optJSONObject3.optInt("first_floor");
                this.epH = optJSONObject3.optInt("prefetch_step");
                this.epI = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.epJ = jSONObject.optInt("afd_jump_pb") == 1;
            this.epK = jSONObject.optString("afd_eid");
            JSONObject optJSONObject5 = jSONObject.optJSONObject("iadex_sniff_list_url");
            if (optJSONObject5 != null) {
                this.epL = optJSONObject5.optString("os_type2_iadex_url");
                com.baidu.tbadk.util.c.Ao(this.epL);
                return;
            }
            com.baidu.tbadk.util.c.Ao(null);
        }
    }

    public g bdK() {
        return this.epu;
    }

    public boolean bdL() {
        return this.ept > 0;
    }

    public boolean bdM() {
        if (this.epw == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.epx < currentTimeMillis && currentTimeMillis < this.epy;
        }
        return false;
    }

    public boolean bdN() {
        return this.epB == 1;
    }

    public boolean bdO() {
        return this.epD == 1;
    }

    public String bdP() {
        return this.epz;
    }

    public boolean bdQ() {
        return this.epA == 1;
    }

    public int bdR() {
        return this.epE;
    }

    public int bdS() {
        return this.epF;
    }

    public boolean bdT() {
        return this.epC == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
