package com.baidu.tieba.aiapps.apps.address.b;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.aiapps.apps.address.c.d;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c cSm;
    private boolean aIb;
    private List<d> cSj = new ArrayList();
    private Map<d, List<d>> cSk = new HashMap();
    private Map<d, List<d>> cSl = new HashMap();

    public static c ayu() {
        if (cSm == null) {
            synchronized (c.class) {
                if (cSm == null) {
                    cSm = new c();
                }
            }
        }
        return cSm;
    }

    public void initData() {
        C(ayz());
        this.aIb = true;
    }

    public boolean ayv() {
        return this.aIb;
    }

    public List<d> ayw() {
        return this.cSj;
    }

    public Map<d, List<d>> ayx() {
        return this.cSk;
    }

    public Map<d, List<d>> ayy() {
        return this.cSl;
    }

    private void C(JSONArray jSONArray) {
        d aU;
        if (jSONArray != null && jSONArray.length() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < jSONArray.length()) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null && (aU = d.aU(optJSONObject)) != null) {
                        this.cSj.add(aU);
                        if (aU.ayD()) {
                            this.cSk.put(aU, aU.aeB);
                            for (d dVar : aU.aeB) {
                                if (dVar.ayD()) {
                                    this.cSl.put(dVar, dVar.aeB);
                                }
                            }
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private JSONArray ayz() {
        JSONArray jSONArray;
        Exception e;
        InputStream open;
        try {
            open = AppRuntime.getAppContext().getAssets().open("aiapps/pickerRegion.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            jSONArray = new JSONArray(new String(bArr, HTTP.UTF_8));
        } catch (Exception e2) {
            jSONArray = null;
            e = e2;
        }
        try {
            open.close();
        } catch (Exception e3) {
            e = e3;
            if (DEBUG) {
                e.printStackTrace();
            }
            return jSONArray;
        }
        return jSONArray;
    }
}
