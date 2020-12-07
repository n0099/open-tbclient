package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a fUC = new a();
    private AtomicBoolean fUD = new AtomicBoolean(false);
    private int fUE = 0;
    private int fUF;

    private a() {
    }

    public static a bKm() {
        return fUC;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.fUD.get();
        if (jSONObject != null && !z) {
            this.fUD.set(true);
            this.fUE = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.fUF = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        }
    }

    @Deprecated
    public int bKn() {
        return this.fUE;
    }

    public boolean bKo() {
        return this.fUF == 1;
    }
}
