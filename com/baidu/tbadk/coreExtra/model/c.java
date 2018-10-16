package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int aMn;
    private int[] aMo;
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
            this.aMn = jSONObject.optInt("conn_conf");
            this.continuousFailCount = jSONObject.optInt("continuous_fail_count");
            this.restartTimeInterval = jSONObject.optInt("restart_time_interval");
            JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
            if (optJSONArray != null) {
                this.aMo = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aMo[i] = optJSONArray.optInt(i);
                }
                return;
            }
            this.aMo = new int[0];
        }
    }

    public int HE() {
        return this.aMn;
    }

    public int HF() {
        return this.continuousFailCount;
    }

    public int HG() {
        return this.restartTimeInterval;
    }

    public int[] HH() {
        return this.aMo;
    }
}
