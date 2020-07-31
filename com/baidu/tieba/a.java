package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a eYA = new a();
    private AtomicBoolean eYB = new AtomicBoolean(false);
    private int eYC = 0;
    private int eYD;

    private a() {
    }

    public static a bqh() {
        return eYA;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.eYB.get();
        if (jSONObject != null && !z) {
            this.eYB.set(true);
            this.eYC = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.eYD = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        }
    }

    public int bqi() {
        return this.eYC;
    }

    public boolean bqj() {
        return this.eYD == 1;
    }
}
