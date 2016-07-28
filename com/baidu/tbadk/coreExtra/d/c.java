package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int aiD;
    private int aiE;
    private int aiF;
    private int[] aiG;

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.aiD = jSONObject.optInt("conn_conf");
            this.aiE = jSONObject.optInt("continuous_fail_count");
            this.aiF = jSONObject.optInt("restart_time_interval");
            JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
            if (optJSONArray != null) {
                this.aiG = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aiG[i] = optJSONArray.optInt(i);
                }
                return;
            }
            this.aiG = new int[0];
        }
    }

    public int yi() {
        return this.aiD;
    }

    public int yj() {
        return this.aiE;
    }

    public int yk() {
        return this.aiF;
    }

    public int[] yl() {
        return this.aiG;
    }
}
