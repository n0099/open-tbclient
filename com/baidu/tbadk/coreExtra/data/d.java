package com.baidu.tbadk.coreExtra.data;

import com.baidu.searchbox.ng.ai.apps.system.bluetooth.utils.AiAppsBluetoothConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int aNr;
    private long aNs;
    private long aNt;
    private String aNu;
    private int aNo = 1;
    private int aNq = 0;
    private int aNv = 0;
    private int aNw = 1;
    private int aNx = 0;
    private int aNy = 0;
    private int aNz = 300;
    private int aNA = 1;
    public int aNB = 4;
    public int aNC = 4;
    public int aND = 7;
    private g aNp = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aNo = jSONObject.optInt("als_control", 1);
            this.aNq = jSONObject.optInt("not_use_lego_patch", 0);
            this.aNw = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.aNy = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aNp.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aNr = optJSONObject.optInt("log_feed_switch", 0);
                this.aNs = optJSONObject.optLong("start_time", -1L);
                this.aNt = optJSONObject.optLong("end_time", -1L);
                this.aNu = optJSONObject.optString("ext_info");
            }
            this.aNv = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.aNz = optJSONObject2.optInt(AiAppsBluetoothConstants.KEY_INTERVAL, 300);
            }
            this.aNA = jSONObject.optInt("video_page_style", 1);
            this.aNx = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.aNB = optJSONObject3.optInt("first_floor");
                this.aNC = optJSONObject3.optInt("prefetch_step");
                this.aND = optJSONObject3.optInt("step");
            }
        }
    }

    public g Gr() {
        return this.aNp;
    }

    public boolean Gs() {
        return this.aNo > 0;
    }

    public boolean Gt() {
        if (this.aNr == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.aNs < currentTimeMillis && currentTimeMillis < this.aNt;
        }
        return false;
    }

    public boolean Gu() {
        return this.aNw == 1;
    }

    public boolean Gv() {
        return this.aNy == 1;
    }

    public String Gw() {
        return this.aNu;
    }

    public boolean Gx() {
        return this.aNv == 1;
    }

    public int Gy() {
        return this.aNz;
    }

    public int Gz() {
        return this.aNA;
    }

    public boolean GA() {
        return this.aNx == 0;
    }
}
