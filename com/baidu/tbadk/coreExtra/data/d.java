package com.baidu.tbadk.coreExtra.data;

import com.baidu.searchbox.ng.ai.apps.system.bluetooth.utils.AiAppsBluetoothConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int aNW;
    private long aNX;
    private long aNY;
    private String aNZ;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int aNT = 1;
    private int aNV = 0;
    private int aOa = 0;
    private int aOb = 1;
    private int aOc = 0;
    private int aOd = 0;
    private int aOe = 300;
    private int aOf = 1;
    public int aOg = 4;
    public int aOh = 4;
    public int aOi = 7;
    private g aNU = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aNT = jSONObject.optInt("als_control", 1);
            this.aNV = jSONObject.optInt("not_use_lego_patch", 0);
            this.aOb = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.aOd = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aNU.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aNW = optJSONObject.optInt("log_feed_switch", 0);
                this.aNX = optJSONObject.optLong("start_time", -1L);
                this.aNY = optJSONObject.optLong("end_time", -1L);
                this.aNZ = optJSONObject.optString("ext_info");
            }
            this.aOa = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.aOe = optJSONObject2.optInt(AiAppsBluetoothConstants.KEY_INTERVAL, 300);
            }
            this.aOf = jSONObject.optInt("video_page_style", 1);
            this.aOc = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.aOg = optJSONObject3.optInt("first_floor");
                this.aOh = optJSONObject3.optInt("prefetch_step");
                this.aOi = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
        }
    }

    public g GF() {
        return this.aNU;
    }

    public boolean GG() {
        return this.aNT > 0;
    }

    public boolean GH() {
        if (this.aNW == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.aNX < currentTimeMillis && currentTimeMillis < this.aNY;
        }
        return false;
    }

    public boolean GI() {
        return this.aOb == 1;
    }

    public boolean GJ() {
        return this.aOd == 1;
    }

    public String GK() {
        return this.aNZ;
    }

    public boolean GL() {
        return this.aOa == 1;
    }

    public int GM() {
        return this.aOe;
    }

    public int GN() {
        return this.aOf;
    }

    public boolean GO() {
        return this.aOc == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
