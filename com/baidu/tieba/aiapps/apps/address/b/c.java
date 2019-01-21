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
    private static volatile c bGT;
    private List<d> bGQ = new ArrayList();
    private Map<d, List<d>> bGR = new HashMap();
    private Map<d, List<d>> bGS = new HashMap();
    private boolean isInited;

    public static c Yq() {
        if (bGT == null) {
            synchronized (c.class) {
                if (bGT == null) {
                    bGT = new c();
                }
            }
        }
        return bGT;
    }

    public void initData() {
        n(Yv());
        this.isInited = true;
    }

    public boolean Yr() {
        return this.isInited;
    }

    public List<d> Ys() {
        return this.bGQ;
    }

    public Map<d, List<d>> Yt() {
        return this.bGR;
    }

    public Map<d, List<d>> Yu() {
        return this.bGS;
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
                        this.bGQ.add(L);
                        if (L.Yz()) {
                            this.bGR.put(L, L.acA);
                            for (d dVar : L.acA) {
                                if (dVar.Yz()) {
                                    this.bGS.put(dVar, dVar.acA);
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

    private JSONArray Yv() {
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
