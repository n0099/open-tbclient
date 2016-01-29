package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int alf;
    private int alg;
    private int alh;
    private int[] ali;
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
            this.alf = jSONObject.optInt("conn_conf");
            this.alg = jSONObject.optInt("continuous_fail_count");
            this.alh = jSONObject.optInt("restart_time_interval");
            this.lcsTimeout2G = jSONObject.optInt("lcs_timeout_2G");
            this.lcsTimeout3G = jSONObject.optInt("lcs_timeout_3G");
            this.lcsTimeoutwifi = jSONObject.optInt("lcs_timeout_wifi");
            JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
            if (optJSONArray != null) {
                this.ali = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.ali[i] = optJSONArray.optInt(i);
                }
                return;
            }
            this.ali = new int[0];
        }
    }

    public int zH() {
        return this.alf;
    }

    public int zI() {
        return this.alg;
    }

    public int zJ() {
        return this.alh;
    }

    public int[] zK() {
        return this.ali;
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
