package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a fjW = new a();
    private AtomicBoolean fjX = new AtomicBoolean(false);
    private int fjY = 0;
    private int fjZ;

    private a() {
    }

    public static a bzg() {
        return fjW;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.fjX.get();
        if (jSONObject != null && !z) {
            this.fjX.set(true);
            this.fjY = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.fjZ = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        }
    }

    @Deprecated
    public int bzh() {
        return this.fjY;
    }

    public boolean bzi() {
        return this.fjZ == 1;
    }
}
