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
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static volatile c cSq;
    private boolean aIa;
    private List<d> cSn = new ArrayList();
    private Map<d, List<d>> cSo = new HashMap();
    private Map<d, List<d>> cSp = new HashMap();

    public static c ayu() {
        if (cSq == null) {
            synchronized (c.class) {
                if (cSq == null) {
                    cSq = new c();
                }
            }
        }
        return cSq;
    }

    public void initData() {
        C(ayz());
        this.aIa = true;
    }

    public boolean ayv() {
        return this.aIa;
    }

    public List<d> ayw() {
        return this.cSn;
    }

    public Map<d, List<d>> ayx() {
        return this.cSo;
    }

    public Map<d, List<d>> ayy() {
        return this.cSp;
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
                        this.cSn.add(aU);
                        if (aU.ayD()) {
                            this.cSo.put(aU, aU.aeA);
                            for (d dVar : aU.aeA) {
                                if (dVar.ayD()) {
                                    this.cSp.put(dVar, dVar.aeA);
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
