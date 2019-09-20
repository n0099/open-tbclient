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
    private static volatile c dee;
    private boolean aLe;
    private List<d> deb = new ArrayList();
    private Map<d, List<d>> dec = new HashMap();
    private Map<d, List<d>> ded = new HashMap();

    public static c aFy() {
        if (dee == null) {
            synchronized (c.class) {
                if (dee == null) {
                    dee = new c();
                }
            }
        }
        return dee;
    }

    public void initData() {
        D(aFD());
        this.aLe = true;
    }

    public boolean aFz() {
        return this.aLe;
    }

    public List<d> aFA() {
        return this.deb;
    }

    public Map<d, List<d>> aFB() {
        return this.dec;
    }

    public Map<d, List<d>> aFC() {
        return this.ded;
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
                        this.deb.add(bg);
                        if (bg.aFH()) {
                            this.dec.put(bg, bg.acU);
                            for (d dVar : bg.acU) {
                                if (dVar.aFH()) {
                                    this.ded.put(dVar, dVar.acU);
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

    private JSONArray aFD() {
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
