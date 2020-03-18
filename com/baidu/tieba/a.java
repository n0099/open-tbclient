package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a dTf = new a();
    private AtomicBoolean dTg = new AtomicBoolean(false);
    private int dTh = 0;
    private int dTi;

    private a() {
    }

    public static a aVs() {
        return dTf;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.dTg.get();
        if (jSONObject != null && !z) {
            this.dTg.set(true);
            this.dTh = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.dTi = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        }
    }

    public int aVt() {
        return this.dTh;
    }

    public boolean aVu() {
        return this.dTi == 1;
    }
}
