package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a dSB = new a();
    private AtomicBoolean dSC = new AtomicBoolean(false);
    private int dSD = 0;
    private int dSE;

    private a() {
    }

    public static a aVl() {
        return dSB;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.dSC.get();
        if (jSONObject != null && !z) {
            this.dSC.set(true);
            this.dSD = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.dSE = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        }
    }

    public int aVm() {
        return this.dSD;
    }

    public boolean aVn() {
        return this.dSE == 1;
    }
}
