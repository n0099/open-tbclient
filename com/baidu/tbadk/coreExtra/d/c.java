package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int amj;
    private int amk;
    private int aml;
    private int[] amm;

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.amj = jSONObject.optInt("conn_conf");
            this.amk = jSONObject.optInt("continuous_fail_count");
            this.aml = jSONObject.optInt("restart_time_interval");
            JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
            if (optJSONArray != null) {
                this.amm = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.amm[i] = optJSONArray.optInt(i);
                }
                return;
            }
            this.amm = new int[0];
        }
    }

    public int zF() {
        return this.amj;
    }

    public int zG() {
        return this.amk;
    }

    public int zH() {
        return this.aml;
    }

    public int[] zI() {
        return this.amm;
    }
}
