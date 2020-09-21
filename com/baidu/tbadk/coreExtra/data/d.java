package com.baidu.tbadk.coreExtra.data;

import com.baidu.searchbox.ugc.model.UgcConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int eBQ;
    private long eBR;
    private long eBS;
    private String eBT;
    public boolean eCd;
    public String eCe;
    public String eCf;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int eBN = 1;
    private int eBP = 0;
    private int eBU = 0;
    private int eBV = 1;
    private int eBW = 0;
    private int eBX = 0;
    private int eBY = 300;
    private int eBZ = 1;
    public int eCa = 4;
    public int eCb = 4;
    public int eCc = 7;
    private h eBO = new h();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.eBN = jSONObject.optInt("als_control", 1);
            this.eBP = jSONObject.optInt("not_use_lego_patch", 0);
            this.eBV = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.eBX = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.eBO.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.eBQ = optJSONObject.optInt("log_feed_switch", 0);
                this.eBR = optJSONObject.optLong("start_time", -1L);
                this.eBS = optJSONObject.optLong("end_time", -1L);
                this.eBT = optJSONObject.optString(UgcConstant.EXT_INFO);
            }
            this.eBU = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.eBY = optJSONObject2.optInt("interval", 300);
            }
            this.eBZ = jSONObject.optInt("video_page_style", 1);
            this.eBW = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.eCa = optJSONObject3.optInt("first_floor");
                this.eCb = optJSONObject3.optInt("prefetch_step");
                this.eCc = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.eCd = jSONObject.optInt("afd_jump_pb") == 1;
            this.eCe = jSONObject.optString("afd_eid");
            JSONObject optJSONObject5 = jSONObject.optJSONObject("iadex_sniff_list_url");
            if (optJSONObject5 != null) {
                this.eCf = optJSONObject5.optString("os_type2_iadex_url");
                com.baidu.tbadk.util.c.Db(this.eCf);
                return;
            }
            com.baidu.tbadk.util.c.Db(null);
        }
    }

    public h bnk() {
        return this.eBO;
    }

    public boolean bnl() {
        return this.eBN > 0;
    }

    public boolean bnm() {
        if (this.eBQ == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.eBR < currentTimeMillis && currentTimeMillis < this.eBS;
        }
        return false;
    }

    public boolean bnn() {
        return this.eBV == 1;
    }

    public boolean bno() {
        return this.eBX == 1;
    }

    public String bnp() {
        return this.eBT;
    }

    public boolean bnq() {
        return this.eBU == 1;
    }

    public int bnr() {
        return this.eBY;
    }

    public int bns() {
        return this.eBZ;
    }

    public boolean bnt() {
        return this.eBW == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
