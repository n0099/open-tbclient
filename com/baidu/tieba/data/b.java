package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class b {
    public abstract void parserJson(JSONObject jSONObject);

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }
}
