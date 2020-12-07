package com.baidu.tbadk.coreExtra.data;

import com.baidu.searchbox.ugc.model.UgcConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int fiQ;
    private long fiR;
    private long fiS;
    private String fiT;
    public boolean fjd;
    public String fje;
    public String fjf;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int fiN = 1;
    private int fiP = 0;
    private int fiU = 0;
    private int fiV = 1;
    private int fiW = 0;
    private int fiX = 0;
    private int fiY = 300;
    private int fiZ = 1;
    public int fja = 4;
    public int fjb = 4;
    public int fjc = 7;
    private h fiO = new h();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.fiN = jSONObject.optInt("als_control", 1);
            this.fiP = jSONObject.optInt("not_use_lego_patch", 0);
            this.fiV = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.fiX = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.fiO.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.fiQ = optJSONObject.optInt("log_feed_switch", 0);
                this.fiR = optJSONObject.optLong("start_time", -1L);
                this.fiS = optJSONObject.optLong("end_time", -1L);
                this.fiT = optJSONObject.optString(UgcConstant.EXT_INFO);
            }
            this.fiU = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.fiY = optJSONObject2.optInt("interval", 300);
            }
            this.fiZ = jSONObject.optInt("video_page_style", 1);
            this.fiW = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.fja = optJSONObject3.optInt("first_floor");
                this.fjb = optJSONObject3.optInt("prefetch_step");
                this.fjc = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.fjd = jSONObject.optInt("afd_jump_pb") == 1;
            this.fje = jSONObject.optString("afd_eid");
            JSONObject optJSONObject5 = jSONObject.optJSONObject("iadex_sniff_list_url");
            if (optJSONObject5 != null) {
                this.fjf = optJSONObject5.optString("os_type2_iadex_url");
                com.baidu.tbadk.util.c.EG(this.fjf);
                return;
            }
            com.baidu.tbadk.util.c.EG(null);
        }
    }

    public h bxd() {
        return this.fiO;
    }

    public boolean bxe() {
        return this.fiN > 0;
    }

    public boolean bxf() {
        if (this.fiQ == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.fiR < currentTimeMillis && currentTimeMillis < this.fiS;
        }
        return false;
    }

    public boolean bxg() {
        return this.fiV == 1;
    }

    public boolean bxh() {
        return this.fiX == 1;
    }

    public String bxi() {
        return this.fiT;
    }

    public boolean bxj() {
        return this.fiU == 1;
    }

    public int bxk() {
        return this.fiY;
    }

    public int bxl() {
        return this.fiZ;
    }

    public boolean bxm() {
        return this.fiW == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
