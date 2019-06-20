package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int chM;
    private int[] chN;
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
            this.chM = jSONObject.optInt("conn_conf");
            this.continuousFailCount = jSONObject.optInt("continuous_fail_count");
            this.restartTimeInterval = jSONObject.optInt("restart_time_interval");
            JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
            if (optJSONArray != null) {
                this.chN = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.chN[i] = optJSONArray.optInt(i);
                }
                return;
            }
            this.chN = new int[0];
        }
    }

    public int anE() {
        return this.chM;
    }

    public int anF() {
        return this.continuousFailCount;
    }

    public int anG() {
        return this.restartTimeInterval;
    }

    public int[] anH() {
        return this.chN;
    }
}
