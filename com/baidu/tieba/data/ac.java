package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ac {
    private String a = null;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("name");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
