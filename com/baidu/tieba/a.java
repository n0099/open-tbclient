package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a dbj = new a();
    private AtomicBoolean dbk = new AtomicBoolean(false);
    private int dbl = 0;
    private int dbm;

    private a() {
    }

    public static a aAO() {
        return dbj;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.dbk.get();
        if (jSONObject != null && !z) {
            this.dbk.set(true);
            this.dbl = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.dbm = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        }
    }

    public int aAP() {
        return this.dbl;
    }

    public boolean aAQ() {
        return this.dbm == 1;
    }
}
