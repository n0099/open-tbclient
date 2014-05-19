package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ac {
    private int a;
    private String b;
    private int c;
    private String d;

    public String a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt(com.baidu.tbadk.core.frameworkData.a.FORUM_ID);
                this.b = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME);
                this.c = jSONObject.optInt("member_count");
                this.d = jSONObject.optString("avatar");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
