package com.baidu.tbadk.coreExtra.data;

import com.baidu.searchbox.ng.ai.apps.system.bluetooth.utils.AiAppsBluetoothConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int aNt;
    private long aNu;
    private long aNv;
    private String aNw;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int aNq = 1;
    private int aNs = 0;
    private int aNx = 0;
    private int aNy = 1;
    private int aNz = 0;
    private int aNA = 0;
    private int aNB = 300;
    private int aNC = 1;
    public int aND = 4;
    public int aNE = 4;
    public int aNF = 7;
    private g aNr = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aNq = jSONObject.optInt("als_control", 1);
            this.aNs = jSONObject.optInt("not_use_lego_patch", 0);
            this.aNy = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.aNA = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aNr.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aNt = optJSONObject.optInt("log_feed_switch", 0);
                this.aNu = optJSONObject.optLong("start_time", -1L);
                this.aNv = optJSONObject.optLong("end_time", -1L);
                this.aNw = optJSONObject.optString("ext_info");
            }
            this.aNx = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.aNB = optJSONObject2.optInt(AiAppsBluetoothConstants.KEY_INTERVAL, 300);
            }
            this.aNC = jSONObject.optInt("video_page_style", 1);
            this.aNz = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.aND = optJSONObject3.optInt("first_floor");
                this.aNE = optJSONObject3.optInt("prefetch_step");
                this.aNF = optJSONObject3.optInt("step");
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

    public g Gs() {
        return this.aNr;
    }

    public boolean Gt() {
        return this.aNq > 0;
    }

    public boolean Gu() {
        if (this.aNt == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.aNu < currentTimeMillis && currentTimeMillis < this.aNv;
        }
        return false;
    }

    public boolean Gv() {
        return this.aNy == 1;
    }

    public boolean Gw() {
        return this.aNA == 1;
    }

    public String Gx() {
        return this.aNw;
    }

    public boolean Gy() {
        return this.aNx == 1;
    }

    public int Gz() {
        return this.aNB;
    }

    public int GA() {
        return this.aNC;
    }

    public boolean GB() {
        return this.aNz == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
