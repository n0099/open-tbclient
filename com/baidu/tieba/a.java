package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a dSP = new a();
    private AtomicBoolean dSQ = new AtomicBoolean(false);
    private int dSR = 0;
    private int dSS;

    private a() {
    }

    public static a aVo() {
        return dSP;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.dSQ.get();
        if (jSONObject != null && !z) {
            this.dSQ.set(true);
            this.dSR = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.dSS = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        }
    }

    public int aVp() {
        return this.dSR;
    }

    public boolean aVq() {
        return this.dSS == 1;
    }
}
