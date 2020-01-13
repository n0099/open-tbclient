package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a dOv = new a();
    private AtomicBoolean dOw = new AtomicBoolean(false);
    private int dOx = 0;
    private int dOy;

    private a() {
    }

    public static a aSU() {
        return dOv;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.dOw.get();
        if (jSONObject != null && !z) {
            this.dOw.set(true);
            this.dOx = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.dOy = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        }
    }

    public int aSV() {
        return this.dOx;
    }

    public boolean aSW() {
        return this.dOy == 1;
    }
}
