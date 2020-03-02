package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a dSC = new a();
    private AtomicBoolean dSD = new AtomicBoolean(false);
    private int dSE = 0;
    private int dSF;

    private a() {
    }

    public static a aVn() {
        return dSC;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.dSD.get();
        if (jSONObject != null && !z) {
            this.dSD.set(true);
            this.dSE = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.dSF = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        }
    }

    public int aVo() {
        return this.dSE;
    }

    public boolean aVp() {
        return this.dSF == 1;
    }
}
