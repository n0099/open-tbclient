package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int alw;
    private int alx;
    private int aly;
    private int[] alz;

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.alw = jSONObject.optInt("conn_conf");
            this.alx = jSONObject.optInt("continuous_fail_count");
            this.aly = jSONObject.optInt("restart_time_interval");
            JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
            if (optJSONArray != null) {
                this.alz = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.alz[i] = optJSONArray.optInt(i);
                }
                return;
            }
            this.alz = new int[0];
        }
    }

    public int Ak() {
        return this.alw;
    }

    public int Al() {
        return this.alx;
    }

    public int Am() {
        return this.aly;
    }

    public int[] An() {
        return this.alz;
    }
}
