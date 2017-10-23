package com.baidu.tbadk.coreExtra.c;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int asb;
    private int[] asc;
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
            this.asb = jSONObject.optInt("conn_conf");
            this.continuousFailCount = jSONObject.optInt("continuous_fail_count");
            this.restartTimeInterval = jSONObject.optInt("restart_time_interval");
            JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
            if (optJSONArray != null) {
                this.asc = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.asc[i] = optJSONArray.optInt(i);
                }
                return;
            }
            this.asc = new int[0];
        }
    }

    public int zp() {
        return this.asb;
    }

    public int zq() {
        return this.continuousFailCount;
    }

    public int zr() {
        return this.restartTimeInterval;
    }

    public int[] zs() {
        return this.asc;
    }
}
