package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a dOn = new a();
    private AtomicBoolean dOo = new AtomicBoolean(false);
    private int dOp = 0;
    private int dOq;

    private a() {
    }

    public static a aSA() {
        return dOn;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.dOo.get();
        if (jSONObject != null && !z) {
            this.dOo.set(true);
            this.dOp = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.dOq = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        }
    }

    public int aSB() {
        return this.dOp;
    }

    public boolean aSC() {
        return this.dOq == 1;
    }
}
