package com.baidu.tbadk.coreExtra.c;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private int abN;
    private int abO;
    private int abP;
    private int[] abQ;
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
            this.abN = jSONObject.optInt("conn_conf");
            this.abO = jSONObject.optInt("continuous_fail_count");
            this.abP = jSONObject.optInt("restart_time_interval");
            this.lcsTimeout2G = jSONObject.optInt("lcs_timeout_2G");
            this.lcsTimeout3G = jSONObject.optInt("lcs_timeout_3G");
            this.lcsTimeoutwifi = jSONObject.optInt("lcs_timeout_wifi");
            JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
            if (optJSONArray != null) {
                this.abQ = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.abQ[i] = optJSONArray.optInt(i);
                }
                return;
            }
            this.abQ = new int[0];
        }
    }

    public int vN() {
        return this.abN;
    }

    public int vO() {
        return this.abO;
    }

    public int vP() {
        return this.abP;
    }

    public int[] vQ() {
        return this.abQ;
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
