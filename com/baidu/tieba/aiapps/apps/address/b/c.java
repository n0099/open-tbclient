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
    private static volatile c dmH;
    private boolean bdZ;
    private List<d> dmE = new ArrayList();
    private Map<d, List<d>> dmF = new HashMap();
    private Map<d, List<d>> dmG = new HashMap();

    public static c aFI() {
        if (dmH == null) {
            synchronized (c.class) {
                if (dmH == null) {
                    dmH = new c();
                }
            }
        }
        return dmH;
    }

    public void initData() {
        L(aFN());
        this.bdZ = true;
    }

    public boolean aFJ() {
        return this.bdZ;
    }

    public List<d> aFK() {
        return this.dmE;
    }

    public Map<d, List<d>> aFL() {
        return this.dmF;
    }

    public Map<d, List<d>> aFM() {
        return this.dmG;
    }

    private void L(JSONArray jSONArray) {
        d bE;
        if (jSONArray != null && jSONArray.length() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < jSONArray.length()) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null && (bE = d.bE(optJSONObject)) != null) {
                        this.dmE.add(bE);
                        if (bE.aFR()) {
                            this.dmF.put(bE, bE.Ms);
                            for (d dVar : bE.Ms) {
                                if (dVar.aFR()) {
                                    this.dmG.put(dVar, dVar.Ms);
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

    private JSONArray aFN() {
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
