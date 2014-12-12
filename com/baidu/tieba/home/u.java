package com.baidu.tieba.home;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private int aPp = -1;
    private String errorMsg = null;
    private String userMsg = null;

    public int getErrorNumber() {
        return this.aPp;
    }

    public String getUserMsg() {
        return this.userMsg;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aPp = jSONObject.optInt("errno");
                this.errorMsg = jSONObject.optString("errmsg");
                this.userMsg = jSONObject.optString("usermsg");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
