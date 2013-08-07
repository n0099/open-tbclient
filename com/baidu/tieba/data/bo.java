package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bo {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f1003a = null;

    public bo(JSONArray jSONArray) {
        a(jSONArray);
    }

    public ArrayList a() {
        return this.f1003a;
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.f1003a = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                bp bpVar = new bp(this);
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bpVar.f1004a = optJSONObject.optString("img_url");
                    bpVar.b = optJSONObject.optString("link");
                    bpVar.c = optJSONObject.optString("webview");
                }
                this.f1003a.add(bpVar);
            }
        }
    }
}
