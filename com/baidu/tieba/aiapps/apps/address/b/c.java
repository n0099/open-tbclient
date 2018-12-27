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
    private static volatile c bGf;
    private List<d> bGc = new ArrayList();
    private Map<d, List<d>> bGd = new HashMap();
    private Map<d, List<d>> bGe = new HashMap();
    private boolean isInited;

    public static c XT() {
        if (bGf == null) {
            synchronized (c.class) {
                if (bGf == null) {
                    bGf = new c();
                }
            }
        }
        return bGf;
    }

    public void initData() {
        n(XY());
        this.isInited = true;
    }

    public boolean XU() {
        return this.isInited;
    }

    public List<d> XV() {
        return this.bGc;
    }

    public Map<d, List<d>> XW() {
        return this.bGd;
    }

    public Map<d, List<d>> XX() {
        return this.bGe;
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
                        this.bGc.add(L);
                        if (L.Yc()) {
                            this.bGd.put(L, L.acq);
                            for (d dVar : L.acq) {
                                if (dVar.Yc()) {
                                    this.bGe.put(dVar, dVar.acq);
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

    private JSONArray XY() {
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
