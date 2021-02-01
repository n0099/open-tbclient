package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int fqh;
    private long fqi;
    private long fqj;
    private String fqk;
    public boolean fqu;
    public String fqv;
    public String fqw;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int fqe = 1;
    private int fqg = 0;
    private int fql = 0;
    private int fqm = 1;
    private int fqn = 0;
    private int fqo = 0;
    private int fqp = 300;
    private int fqq = 1;
    public int fqr = 4;
    public int fqs = 4;
    public int fqt = 7;
    private h fqf = new h();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.fqe = jSONObject.optInt("als_control", 1);
            this.fqg = jSONObject.optInt("not_use_lego_patch", 0);
            this.fqm = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.fqo = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.fqf.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.fqh = optJSONObject.optInt("log_feed_switch", 0);
                this.fqi = optJSONObject.optLong("start_time", -1L);
                this.fqj = optJSONObject.optLong("end_time", -1L);
                this.fqk = optJSONObject.optString("ext_info");
            }
            this.fql = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.fqp = optJSONObject2.optInt("interval", 300);
            }
            this.fqq = jSONObject.optInt("video_page_style", 1);
            com.baidu.tbadk.core.sharedPref.b.brQ().putInt("video_page_style", this.fqq);
            this.fqn = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.fqr = optJSONObject3.optInt("first_floor");
                this.fqs = optJSONObject3.optInt("prefetch_step");
                this.fqt = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.fqu = jSONObject.optInt("afd_jump_pb") == 1;
            this.fqv = jSONObject.optString("afd_eid");
            JSONObject optJSONObject5 = jSONObject.optJSONObject("iadex_sniff_list_url");
            if (optJSONObject5 != null) {
                this.fqw = optJSONObject5.optString("os_type2_iadex_url");
                com.baidu.tbadk.util.d.DK(this.fqw);
                return;
            }
            com.baidu.tbadk.util.d.DK(null);
        }
    }

    public h bvW() {
        return this.fqf;
    }

    public boolean bvX() {
        return this.fqe > 0;
    }

    public boolean bvY() {
        if (this.fqh == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.fqi < currentTimeMillis && currentTimeMillis < this.fqj;
        }
        return false;
    }

    public boolean bvZ() {
        return this.fqm == 1;
    }

    public boolean bwa() {
        return this.fqo == 1;
    }

    public String bwb() {
        return this.fqk;
    }

    public boolean bwc() {
        return this.fql == 1;
    }

    public int bwd() {
        return this.fqp;
    }

    public boolean bwe() {
        return this.fqn == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
