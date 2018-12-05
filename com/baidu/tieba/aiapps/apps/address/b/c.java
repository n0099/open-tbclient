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
    private static volatile c bGc;
    private List<d> bFZ = new ArrayList();
    private Map<d, List<d>> bGa = new HashMap();
    private Map<d, List<d>> bGb = new HashMap();
    private boolean isInited;

    public static c XR() {
        if (bGc == null) {
            synchronized (c.class) {
                if (bGc == null) {
                    bGc = new c();
                }
            }
        }
        return bGc;
    }

    public void initData() {
        n(XW());
        this.isInited = true;
    }

    public boolean XS() {
        return this.isInited;
    }

    public List<d> XT() {
        return this.bFZ;
    }

    public Map<d, List<d>> XU() {
        return this.bGa;
    }

    public Map<d, List<d>> XV() {
        return this.bGb;
    }

    private void n(JSONArray jSONArray) {
        d L;
        if (jSONArray != null && jSONArray.length() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < jSONArray.length()) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null && (L = d.L(optJSONObject)) != null) {
                        this.bFZ.add(L);
                        if (L.Ya()) {
                            this.bGa.put(L, L.acq);
                            for (d dVar : L.acq) {
                                if (dVar.Ya()) {
                                    this.bGb.put(dVar, dVar.acq);
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

    private JSONArray XW() {
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
