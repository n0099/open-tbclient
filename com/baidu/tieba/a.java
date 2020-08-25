package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static final a fjS = new a();
    private AtomicBoolean fjT = new AtomicBoolean(false);
    private int fjU = 0;
    private int fjV;

    private a() {
    }

    public static a bzf() {
        return fjS;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.fjT.get();
        if (jSONObject != null && !z) {
            this.fjT.set(true);
            this.fjU = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.fjV = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        }
    }

    @Deprecated
    public int bzg() {
        return this.fjU;
    }

    public boolean bzh() {
        return this.fjV == 1;
    }
}
