package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a fMR = new a();
    private AtomicBoolean fMS = new AtomicBoolean(false);
    private int fMT = 0;
    private int fMU;

    private a() {
    }

    public static a bGM() {
        return fMR;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.fMS.get();
        if (jSONObject != null && !z) {
            this.fMS.set(true);
            this.fMT = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.fMU = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        }
    }

    @Deprecated
    public int bGN() {
        return this.fMT;
    }

    public boolean bGO() {
        return this.fMU == 1;
    }
}
