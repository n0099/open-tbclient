package com.baidu.tieba.aiapps.apps.address.b;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.aiapps.apps.address.c.d;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private static volatile c bBX;
    private List<d> bBU = new ArrayList();
    private Map<d, List<d>> bBV = new HashMap();
    private Map<d, List<d>> bBW = new HashMap();
    private boolean isInited;

    public static c WD() {
        if (bBX == null) {
            synchronized (c.class) {
                if (bBX == null) {
                    bBX = new c();
                }
            }
        }
        return bBX;
    }

    public void initData() {
        l(WI());
        this.isInited = true;
    }

    public boolean WE() {
        return this.isInited;
    }

    public List<d> WF() {
        return this.bBU;
    }

    public Map<d, List<d>> WG() {
        return this.bBV;
    }

    public Map<d, List<d>> WH() {
        return this.bBW;
    }

    private void l(JSONArray jSONArray) {
        d K;
        if (jSONArray != null && jSONArray.length() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < jSONArray.length()) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null && (K = d.K(optJSONObject)) != null) {
                        this.bBU.add(K);
                        if (K.WM()) {
                            this.bBV.put(K, K.act);
                            for (d dVar : K.act) {
                                if (dVar.WM()) {
                                    this.bBW.put(dVar, dVar.act);
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

    private JSONArray WI() {
        try {
            InputStream open = AppRuntime.getAppContext().getAssets().open("aiapps/pickerRegion.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            JSONArray jSONArray = new JSONArray(new String(bArr, "UTF-8"));
            try {
                open.close();
                return jSONArray;
            } catch (Exception e) {
                return jSONArray;
            }
        } catch (Exception e2) {
            return null;
        }
    }
}
