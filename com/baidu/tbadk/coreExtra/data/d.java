package com.baidu.tbadk.coreExtra.data;

import com.baidu.searchbox.ng.ai.apps.system.bluetooth.utils.AiAppsBluetoothConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int aNV;
    private long aNW;
    private long aNX;
    private String aNY;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int aNS = 1;
    private int aNU = 0;
    private int aNZ = 0;
    private int aOa = 1;
    private int aOb = 0;
    private int aOc = 0;
    private int aOd = 300;
    private int aOe = 1;
    public int aOf = 4;
    public int aOg = 4;
    public int aOh = 7;
    private g aNT = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aNS = jSONObject.optInt("als_control", 1);
            this.aNU = jSONObject.optInt("not_use_lego_patch", 0);
            this.aOa = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.aOc = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aNT.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aNV = optJSONObject.optInt("log_feed_switch", 0);
                this.aNW = optJSONObject.optLong("start_time", -1L);
                this.aNX = optJSONObject.optLong("end_time", -1L);
                this.aNY = optJSONObject.optString("ext_info");
            }
            this.aNZ = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.aOd = optJSONObject2.optInt(AiAppsBluetoothConstants.KEY_INTERVAL, 300);
            }
            this.aOe = jSONObject.optInt("video_page_style", 1);
            this.aOb = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.aOf = optJSONObject3.optInt("first_floor");
                this.aOg = optJSONObject3.optInt("prefetch_step");
                this.aOh = optJSONObject3.optInt("step");
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
        return this.aNT;
    }

    public boolean GG() {
        return this.aNS > 0;
    }

    public boolean GH() {
        if (this.aNV == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.aNW < currentTimeMillis && currentTimeMillis < this.aNX;
        }
        return false;
    }

    public boolean GI() {
        return this.aOa == 1;
    }

    public boolean GJ() {
        return this.aOc == 1;
    }

    public String GK() {
        return this.aNY;
    }

    public boolean GL() {
        return this.aNZ == 1;
    }

    public int GM() {
        return this.aOd;
    }

    public int GN() {
        return this.aOe;
    }

    public boolean GO() {
        return this.aOb == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
