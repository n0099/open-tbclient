package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int[] ahA;
    private int ahx;
    private int ahy;
    private int ahz;
    private int lcsTimeout2G;
    private int lcsTimeout3G;
    private int lcsTimeoutwifi;

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.ahx = jSONObject.optInt("conn_conf");
            this.ahy = jSONObject.optInt("continuous_fail_count");
            this.ahz = jSONObject.optInt("restart_time_interval");
            this.lcsTimeout2G = jSONObject.optInt("lcs_timeout_2G");
            this.lcsTimeout3G = jSONObject.optInt("lcs_timeout_3G");
            this.lcsTimeoutwifi = jSONObject.optInt("lcs_timeout_wifi");
            JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
            if (optJSONArray != null) {
                this.ahA = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.ahA[i] = optJSONArray.optInt(i);
                }
                return;
            }
            this.ahA = new int[0];
        }
    }

    public int xH() {
        return this.ahx;
    }

    public int xI() {
        return this.ahy;
    }

    public int xJ() {
        return this.ahz;
    }

    public int[] xK() {
        return this.ahA;
    }

    public int getLcsTimeout2G() {
        return this.lcsTimeout2G;
    }

    public int getLcsTimeout3G() {
        return this.lcsTimeout3G;
    }

    public int getLcsTimeoutwifi() {
        return this.lcsTimeoutwifi;
    }
}
