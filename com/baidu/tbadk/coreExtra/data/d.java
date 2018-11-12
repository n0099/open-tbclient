package com.baidu.tbadk.coreExtra.data;

import com.baidu.searchbox.ng.ai.apps.system.bluetooth.utils.AiAppsBluetoothConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int aJR;
    private long aJS;
    private long aJT;
    private String aJU;
    private int aJO = 1;
    private int aJQ = 0;
    private int aJV = 0;
    private int aJW = 1;
    private int aJX = 0;
    private int aJY = 0;
    private int aJZ = 300;
    private int aKa = 1;
    public int aKb = 4;
    public int aKc = 4;
    public int aKd = 7;
    private g aJP = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aJO = jSONObject.optInt("als_control", 1);
            this.aJQ = jSONObject.optInt("not_use_lego_patch", 0);
            this.aJW = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.aJY = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aJP.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aJR = optJSONObject.optInt("log_feed_switch", 0);
                this.aJS = optJSONObject.optLong("start_time", -1L);
                this.aJT = optJSONObject.optLong("end_time", -1L);
                this.aJU = optJSONObject.optString("ext_info");
            }
            this.aJV = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.aJZ = optJSONObject2.optInt(AiAppsBluetoothConstants.KEY_INTERVAL, 300);
            }
            this.aKa = jSONObject.optInt("video_page_style", 1);
            this.aJX = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.aKb = optJSONObject3.optInt("first_floor");
                this.aKc = optJSONObject3.optInt("prefetch_step");
                this.aKd = optJSONObject3.optInt("step");
            }
        }
    }

    public g Fn() {
        return this.aJP;
    }

    public boolean Fo() {
        return this.aJO > 0;
    }

    public boolean Fp() {
        if (this.aJR == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.aJS < currentTimeMillis && currentTimeMillis < this.aJT;
        }
        return false;
    }

    public boolean Fq() {
        return this.aJW == 1;
    }

    public boolean Fr() {
        return this.aJY == 1;
    }

    public String Fs() {
        return this.aJU;
    }

    public boolean Ft() {
        return this.aJV == 1;
    }

    public int Fu() {
        return this.aJZ;
    }

    public int Fv() {
        return this.aKa;
    }

    public boolean Fw() {
        return this.aJX == 0;
    }
}
