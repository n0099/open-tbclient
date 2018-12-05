package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int aQC;
    private int[] aQD;
    private int continuousFailCount;
    private int restartTimeInterval;

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.aQC = jSONObject.optInt("conn_conf");
            this.continuousFailCount = jSONObject.optInt("continuous_fail_count");
            this.restartTimeInterval = jSONObject.optInt("restart_time_interval");
            JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
            if (optJSONArray != null) {
                this.aQD = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aQD[i] = optJSONArray.optInt(i);
                }
                return;
            }
            this.aQD = new int[0];
        }
    }

    public int IU() {
        return this.aQC;
    }

    public int IV() {
        return this.continuousFailCount;
    }

    public int IW() {
        return this.restartTimeInterval;
    }

    public int[] IX() {
        return this.aQD;
    }
}
