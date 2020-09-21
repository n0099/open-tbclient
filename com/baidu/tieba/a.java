package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a fmP = new a();
    private AtomicBoolean fmQ = new AtomicBoolean(false);
    private int fmR = 0;
    private int fmS;

    private a() {
    }

    public static a bAp() {
        return fmP;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.fmQ.get();
        if (jSONObject != null && !z) {
            this.fmQ.set(true);
            this.fmR = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.fmS = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        }
    }

    @Deprecated
    public int bAq() {
        return this.fmR;
    }

    public boolean bAr() {
        return this.fmS == 1;
    }
}
