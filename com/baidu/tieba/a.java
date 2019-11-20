package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a dar = new a();
    private AtomicBoolean das = new AtomicBoolean(false);
    private int dat = 0;
    private int dau;

    private a() {
    }

    public static a aAM() {
        return dar;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.das.get();
        if (jSONObject != null && !z) {
            this.das.set(true);
            this.dat = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.dau = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        }
    }

    public int aAN() {
        return this.dat;
    }

    public boolean aAO() {
        return this.dau == 1;
    }
}
