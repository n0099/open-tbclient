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
    private static volatile c dcr;
    private boolean aKG;
    private List<d> dco = new ArrayList();
    private Map<d, List<d>> dcp = new HashMap();
    private Map<d, List<d>> dcq = new HashMap();

    public static c aEU() {
        if (dcr == null) {
            synchronized (c.class) {
                if (dcr == null) {
                    dcr = new c();
                }
            }
        }
        return dcr;
    }

    public void initData() {
        D(aEZ());
        this.aKG = true;
    }

    public boolean aEV() {
        return this.aKG;
    }

    public List<d> aEW() {
        return this.dco;
    }

    public Map<d, List<d>> aEX() {
        return this.dcp;
    }

    public Map<d, List<d>> aEY() {
        return this.dcq;
    }

    private void D(JSONArray jSONArray) {
        d bg;
        if (jSONArray != null && jSONArray.length() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < jSONArray.length()) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null && (bg = d.bg(optJSONObject)) != null) {
                        this.dco.add(bg);
                        if (bg.aFd()) {
                            this.dcp.put(bg, bg.acU);
                            for (d dVar : bg.acU) {
                                if (dVar.aFd()) {
                                    this.dcq.put(dVar, dVar.acU);
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

    private JSONArray aEZ() {
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
