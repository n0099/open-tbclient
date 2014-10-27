package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Lbs;
/* loaded from: classes.dex */
public class ab {
    private String name = null;

    public String getName() {
        return this.name;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.name = jSONObject.optString("name");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Lbs lbs) {
        if (lbs != null) {
            try {
                this.name = lbs.name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
