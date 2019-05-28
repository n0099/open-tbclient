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
    private static volatile c daL;
    private boolean aJY;
    private List<d> daI = new ArrayList();
    private Map<d, List<d>> daJ = new HashMap();
    private Map<d, List<d>> daK = new HashMap();

    public static c aDC() {
        if (daL == null) {
            synchronized (c.class) {
                if (daL == null) {
                    daL = new c();
                }
            }
        }
        return daL;
    }

    public void initData() {
        D(aDH());
        this.aJY = true;
    }

    public boolean aDD() {
        return this.aJY;
    }

    public List<d> aDE() {
        return this.daI;
    }

    public Map<d, List<d>> aDF() {
        return this.daJ;
    }

    public Map<d, List<d>> aDG() {
        return this.daK;
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
                        this.daI.add(bg);
                        if (bg.aDL()) {
                            this.daJ.put(bg, bg.acx);
                            for (d dVar : bg.acx) {
                                if (dVar.aDL()) {
                                    this.daK.put(dVar, dVar.acx);
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

    private JSONArray aDH() {
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
