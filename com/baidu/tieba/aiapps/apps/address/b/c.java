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
    private static volatile c cSo;
    private boolean aIe;
    private List<d> cSl = new ArrayList();
    private Map<d, List<d>> cSm = new HashMap();
    private Map<d, List<d>> cSn = new HashMap();

    public static c ayr() {
        if (cSo == null) {
            synchronized (c.class) {
                if (cSo == null) {
                    cSo = new c();
                }
            }
        }
        return cSo;
    }

    public void initData() {
        C(ayw());
        this.aIe = true;
    }

    public boolean ays() {
        return this.aIe;
    }

    public List<d> ayt() {
        return this.cSl;
    }

    public Map<d, List<d>> ayu() {
        return this.cSm;
    }

    public Map<d, List<d>> ayv() {
        return this.cSn;
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
                        this.cSl.add(aU);
                        if (aU.ayA()) {
                            this.cSm.put(aU, aU.aeG);
                            for (d dVar : aU.aeG) {
                                if (dVar.ayA()) {
                                    this.cSn.put(dVar, dVar.aeG);
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

    private JSONArray ayw() {
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
