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
    private static volatile c cSp;
    private boolean aIf;
    private List<d> cSm = new ArrayList();
    private Map<d, List<d>> cSn = new HashMap();
    private Map<d, List<d>> cSo = new HashMap();

    public static c ayr() {
        if (cSp == null) {
            synchronized (c.class) {
                if (cSp == null) {
                    cSp = new c();
                }
            }
        }
        return cSp;
    }

    public void initData() {
        C(ayw());
        this.aIf = true;
    }

    public boolean ays() {
        return this.aIf;
    }

    public List<d> ayt() {
        return this.cSm;
    }

    public Map<d, List<d>> ayu() {
        return this.cSn;
    }

    public Map<d, List<d>> ayv() {
        return this.cSo;
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
                        this.cSm.add(aU);
                        if (aU.ayA()) {
                            this.cSn.put(aU, aU.aeH);
                            for (d dVar : aU.aeH) {
                                if (dVar.ayA()) {
                                    this.cSo.put(dVar, dVar.aeH);
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
