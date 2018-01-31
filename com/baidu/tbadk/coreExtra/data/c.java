package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int bfn;
    private long bfo;
    private long bfp;
    private String bfq;
    private int bfk = 1;
    private int bfm = 0;
    private int bfr = 0;
    private int bfs = 1;
    private int bft = 0;
    private int bfu = 300;
    private int bfv = 1;
    private e bfl = new e();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.bfk = jSONObject.optInt("als_control", 1);
            this.bfm = jSONObject.optInt("not_use_lego_patch", 0);
            this.bfs = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.bft = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.bfl.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.bfn = optJSONObject.optInt("log_feed_switch", 0);
                this.bfo = optJSONObject.optLong("start_time", -1L);
                this.bfp = optJSONObject.optLong("end_time", -1L);
                this.bfq = optJSONObject.optString("ext_info");
            }
            this.bfr = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.bfu = optJSONObject2.optInt("interval", 300);
            }
            this.bfv = jSONObject.optInt("video_page_style", 1);
        }
    }

    public e EX() {
        return this.bfl;
    }

    public boolean EY() {
        return this.bfk > 0;
    }

    public boolean EZ() {
        if (this.bfn == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.bfo < currentTimeMillis && currentTimeMillis < this.bfp;
        }
        return false;
    }

    public boolean Fa() {
        return this.bfs == 1;
    }

    public boolean Fb() {
        return this.bft == 1;
    }

    public String Fc() {
        return this.bfq;
    }

    public boolean Fd() {
        return this.bfr == 1;
    }

    public int Fe() {
        return this.bfu;
    }

    public int Ff() {
        return this.bfv;
    }
}
