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
    private static volatile c bCJ;
    private List<d> bCG = new ArrayList();
    private Map<d, List<d>> bCH = new HashMap();
    private Map<d, List<d>> bCI = new HashMap();
    private boolean isInited;

    public static c WO() {
        if (bCJ == null) {
            synchronized (c.class) {
                if (bCJ == null) {
                    bCJ = new c();
                }
            }
        }
        return bCJ;
    }

    public void initData() {
        n(WT());
        this.isInited = true;
    }

    public boolean WP() {
        return this.isInited;
    }

    public List<d> WQ() {
        return this.bCG;
    }

    public Map<d, List<d>> WR() {
        return this.bCH;
    }

    public Map<d, List<d>> WS() {
        return this.bCI;
    }

    private void n(JSONArray jSONArray) {
        d K;
        if (jSONArray != null && jSONArray.length() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < jSONArray.length()) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null && (K = d.K(optJSONObject)) != null) {
                        this.bCG.add(K);
                        if (K.WX()) {
                            this.bCH.put(K, K.acq);
                            for (d dVar : K.acq) {
                                if (dVar.WX()) {
                                    this.bCI.put(dVar, dVar.acq);
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

    private JSONArray WT() {
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
