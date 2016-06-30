package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int ahO;
    private int ahP;
    private int ahQ;
    private int[] ahR;

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.ahO = jSONObject.optInt("conn_conf");
            this.ahP = jSONObject.optInt("continuous_fail_count");
            this.ahQ = jSONObject.optInt("restart_time_interval");
            JSONArray optJSONArray = jSONObject.optJSONArray("android_conn_black_list");
            if (optJSONArray != null) {
                this.ahR = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.ahR[i] = optJSONArray.optInt(i);
                }
                return;
            }
            this.ahR = new int[0];
        }
    }

    public int yi() {
        return this.ahO;
    }

    public int yj() {
        return this.ahP;
    }

    public int yk() {
        return this.ahQ;
    }

    public int[] yl() {
        return this.ahR;
    }
}
