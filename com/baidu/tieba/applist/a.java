package com.baidu.tieba.applist;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private boolean ctA;
    private String ctz;
    private Drawable icon;
    private String name;
    private String version;

    public void setIcon(Drawable drawable) {
        this.icon = drawable;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void kW(String str) {
        this.ctz = str;
    }

    public void eo(boolean z) {
        this.ctA = z;
    }

    public JSONObject ahW() {
        JSONObject jSONObject;
        JSONException e;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.name);
                jSONObject.put("packagename", this.ctz);
                jSONObject.put("version", this.version);
                jSONObject.put("isUserApp", this.ctA ? "0" : "1");
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
                return jSONObject;
            }
        } catch (JSONException e3) {
            jSONObject = null;
            e = e3;
        }
        return jSONObject;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", this.name);
        hashMap.put("packagename", this.ctz);
        hashMap.put("version", this.version);
        hashMap.put("isUserApp", this.ctA ? "0" : "1");
        return new JSONObject(hashMap).toString();
    }
}
