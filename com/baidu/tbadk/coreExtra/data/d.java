package com.baidu.tbadk.coreExtra.data;

import com.baidu.searchbox.ng.ai.apps.system.bluetooth.utils.AiAppsBluetoothConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int aJb;
    private long aJc;
    private long aJd;
    private String aJe;
    private int aIY = 1;
    private int aJa = 0;
    private int aJf = 0;
    private int aJg = 1;
    private int aJh = 0;
    private int aJi = 0;
    private int aJj = 300;
    private int aJk = 1;
    public int aJl = 4;
    public int aJm = 4;
    public int aJn = 7;
    private f aIZ = new f();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aIY = jSONObject.optInt("als_control", 1);
            this.aJa = jSONObject.optInt("not_use_lego_patch", 0);
            this.aJg = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.aJi = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aIZ.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aJb = optJSONObject.optInt("log_feed_switch", 0);
                this.aJc = optJSONObject.optLong("start_time", -1L);
                this.aJd = optJSONObject.optLong("end_time", -1L);
                this.aJe = optJSONObject.optString("ext_info");
            }
            this.aJf = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.aJj = optJSONObject2.optInt(AiAppsBluetoothConstants.KEY_INTERVAL, 300);
            }
            this.aJk = jSONObject.optInt("video_page_style", 1);
            this.aJh = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.aJl = optJSONObject3.optInt("first_floor");
                this.aJm = optJSONObject3.optInt("prefetch_step");
                this.aJn = optJSONObject3.optInt("step");
            }
        }
    }

    public f Fc() {
        return this.aIZ;
    }

    public boolean Fd() {
        return this.aIY > 0;
    }

    public boolean Fe() {
        if (this.aJb == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.aJc < currentTimeMillis && currentTimeMillis < this.aJd;
        }
        return false;
    }

    public boolean Ff() {
        return this.aJg == 1;
    }

    public boolean Fg() {
        return this.aJi == 1;
    }

    public String Fh() {
        return this.aJe;
    }

    public boolean Fi() {
        return this.aJf == 1;
    }

    public int Fj() {
        return this.aJj;
    }

    public int Fk() {
        return this.aJk;
    }

    public boolean Fl() {
        return this.aJh == 0;
    }
}
