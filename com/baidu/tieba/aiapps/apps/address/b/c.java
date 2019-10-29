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
    private static volatile c dnz;
    private boolean bes;
    private List<d> dnw = new ArrayList();
    private Map<d, List<d>> dnx = new HashMap();
    private Map<d, List<d>> dny = new HashMap();

    public static c aFK() {
        if (dnz == null) {
            synchronized (c.class) {
                if (dnz == null) {
                    dnz = new c();
                }
            }
        }
        return dnz;
    }

    public void initData() {
        L(aFP());
        this.bes = true;
    }

    public boolean aFL() {
        return this.bes;
    }

    public List<d> aFM() {
        return this.dnw;
    }

    public Map<d, List<d>> aFN() {
        return this.dnx;
    }

    public Map<d, List<d>> aFO() {
        return this.dny;
    }

    private void L(JSONArray jSONArray) {
        d bD;
        if (jSONArray != null && jSONArray.length() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < jSONArray.length()) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null && (bD = d.bD(optJSONObject)) != null) {
                        this.dnw.add(bD);
                        if (bD.aFT()) {
                            this.dnx.put(bD, bD.MT);
                            for (d dVar : bD.MT) {
                                if (dVar.aFT()) {
                                    this.dny.put(dVar, dVar.MT);
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

    private JSONArray aFP() {
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
