package com.baidu.tieba.ala.person.a;

import com.baidu.mobstat.Config;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public int has_more;
    public int pn;
    public int ps;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.pn = jSONObject.optInt(Config.PACKAGE_NAME);
            this.ps = jSONObject.optInt("ps");
            this.has_more = jSONObject.optInt("has_more");
        }
    }
}
