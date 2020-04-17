package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a ete = new a();
    private AtomicBoolean etf = new AtomicBoolean(false);
    private int etg = 0;
    private int eth;

    private a() {
    }

    public static a bdC() {
        return ete;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.etf.get();
        if (jSONObject != null && !z) {
            this.etf.set(true);
            this.etg = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.eth = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        }
    }

    public int bdD() {
        return this.etg;
    }

    public boolean bdE() {
        return this.eth == 1;
    }
}
