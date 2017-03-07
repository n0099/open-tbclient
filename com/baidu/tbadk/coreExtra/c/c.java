package com.baidu.tbadk.coreExtra.c;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int aqn;
    private int[] aqo;
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
            this.aqn = jSONObject.optInt("conn_conf");
            this.continuousFailCount = jSONObject.optInt("continuous_fail_count");
            this.restartTimeInterval = jSONObject.optInt("restart_time_interval");
            JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
            if (optJSONArray != null) {
                this.aqo = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aqo[i] = optJSONArray.optInt(i);
                }
                return;
            }
            this.aqo = new int[0];
        }
    }

    public int zE() {
        return this.aqn;
    }

    public int zF() {
        return this.continuousFailCount;
    }

    public int zG() {
        return this.restartTimeInterval;
    }

    public int[] zH() {
        return this.aqo;
    }
}
