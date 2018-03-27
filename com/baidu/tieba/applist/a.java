package com.baidu.tieba.applist;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private String cVd;
    private boolean cVe;
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

    public void kp(String str) {
        this.cVd = str;
    }

    public void eF(boolean z) {
        this.cVe = z;
    }

    public JSONObject akJ() {
        JSONObject jSONObject;
        JSONException e;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.name);
                jSONObject.put("packagename", this.cVd);
                jSONObject.put("version", this.version);
                jSONObject.put("isUserApp", this.cVe ? "0" : "1");
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
        hashMap.put("packagename", this.cVd);
        hashMap.put("version", this.version);
        hashMap.put("isUserApp", this.cVe ? "0" : "1");
        return new JSONObject(hashMap).toString();
    }
}
