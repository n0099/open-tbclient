package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class aq {
    private int a = 0;
    private String b = null;

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final void a(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("error");
            try {
                this.a = optJSONObject.optInt("errno");
                this.b = optJSONObject.optString("usermsg");
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.toString());
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e2.toString());
        }
    }
}
