package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a fHy = new a();
    private int fHB;
    private AtomicBoolean fHz = new AtomicBoolean(false);
    private int fHA = 0;

    private a() {
    }

    public static a bEU() {
        return fHy;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.fHz.get();
        if (jSONObject != null && !z) {
            this.fHz.set(true);
            this.fHA = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.fHB = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        }
    }

    @Deprecated
    public int bEV() {
        return this.fHA;
    }

    public boolean bEW() {
        return this.fHB == 1;
    }
}
