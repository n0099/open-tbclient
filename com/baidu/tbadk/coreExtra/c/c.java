package com.baidu.tbadk.coreExtra.c;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int arq;
    private int[] arr;
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
            this.arq = jSONObject.optInt("conn_conf");
            this.continuousFailCount = jSONObject.optInt("continuous_fail_count");
            this.restartTimeInterval = jSONObject.optInt("restart_time_interval");
            JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
            if (optJSONArray != null) {
                this.arr = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.arr[i] = optJSONArray.optInt(i);
                }
                return;
            }
            this.arr = new int[0];
        }
    }

    public int zA() {
        return this.arq;
    }

    public int zB() {
        return this.continuousFailCount;
    }

    public int zC() {
        return this.restartTimeInterval;
    }

    public int[] zD() {
        return this.arr;
    }
}
