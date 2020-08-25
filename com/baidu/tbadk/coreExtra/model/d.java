package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private int[] blackCmds;
    private int connConf;
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
            this.connConf = jSONObject.optInt("conn_conf");
            this.continuousFailCount = jSONObject.optInt("continuous_fail_count");
            this.restartTimeInterval = jSONObject.optInt("restart_time_interval");
            JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
            if (optJSONArray != null) {
                this.blackCmds = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.blackCmds[i] = optJSONArray.optInt(i);
                }
                return;
            }
            this.blackCmds = new int[0];
        }
    }

    public int getConnConf() {
        return this.connConf;
    }

    public int getContinuousFailCount() {
        return this.continuousFailCount;
    }

    public int getRestartTimeInterval() {
        return this.restartTimeInterval;
    }

    public int[] getBlackCmds() {
        return this.blackCmds;
    }
}
