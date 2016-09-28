package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int alq;
    private int alr;
    private int als;
    private int[] alt;

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.alq = jSONObject.optInt("conn_conf");
            this.alr = jSONObject.optInt("continuous_fail_count");
            this.als = jSONObject.optInt("restart_time_interval");
            JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
            if (optJSONArray != null) {
                this.alt = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.alt[i] = optJSONArray.optInt(i);
                }
                return;
            }
            this.alt = new int[0];
        }
    }

    public int zy() {
        return this.alq;
    }

    public int zz() {
        return this.alr;
    }

    public int zA() {
        return this.als;
    }

    public int[] zB() {
        return this.alt;
    }
}
