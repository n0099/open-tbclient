package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int alI;
    private int alJ;
    private int alK;
    private int[] alL;

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.alI = jSONObject.optInt("conn_conf");
            this.alJ = jSONObject.optInt("continuous_fail_count");
            this.alK = jSONObject.optInt("restart_time_interval");
            JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
            if (optJSONArray != null) {
                this.alL = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.alL[i] = optJSONArray.optInt(i);
                }
                return;
            }
            this.alL = new int[0];
        }
    }

    public int zv() {
        return this.alI;
    }

    public int zw() {
        return this.alJ;
    }

    public int zx() {
        return this.alK;
    }

    public int[] zy() {
        return this.alL;
    }
}
