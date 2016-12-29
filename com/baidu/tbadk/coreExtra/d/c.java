package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int alL;
    private int alM;
    private int alN;
    private int[] alO;

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.alL = jSONObject.optInt("conn_conf");
            this.alM = jSONObject.optInt("continuous_fail_count");
            this.alN = jSONObject.optInt("restart_time_interval");
            JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
            if (optJSONArray != null) {
                this.alO = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.alO[i] = optJSONArray.optInt(i);
                }
                return;
            }
            this.alO = new int[0];
        }
    }

    public int zs() {
        return this.alL;
    }

    public int zt() {
        return this.alM;
    }

    public int zu() {
        return this.alN;
    }

    public int[] zv() {
        return this.alO;
    }
}
