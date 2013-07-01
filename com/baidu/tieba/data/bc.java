package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bc {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f779a = null;

    public bc(JSONArray jSONArray) {
        a(jSONArray);
    }

    public ArrayList a() {
        return this.f779a;
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.f779a = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                bd bdVar = new bd(this);
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bdVar.f780a = optJSONObject.optString("img_url");
                    bdVar.b = optJSONObject.optString("link");
                    bdVar.c = optJSONObject.optString("webview");
                }
                this.f779a.add(bdVar);
            }
        }
    }
}
