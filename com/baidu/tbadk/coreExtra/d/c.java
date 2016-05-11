package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int ahj;
    private int ahk;
    private int ahl;
    private int[] ahm;

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.ahj = jSONObject.optInt("conn_conf");
            this.ahk = jSONObject.optInt("continuous_fail_count");
            this.ahl = jSONObject.optInt("restart_time_interval");
            JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
            if (optJSONArray != null) {
                this.ahm = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.ahm[i] = optJSONArray.optInt(i);
                }
                return;
            }
            this.ahm = new int[0];
        }
    }

    public int yd() {
        return this.ahj;
    }

    public int ye() {
        return this.ahk;
    }

    public int yf() {
        return this.ahl;
    }

    public int[] yg() {
        return this.ahm;
    }
}
