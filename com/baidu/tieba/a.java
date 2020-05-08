package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a etj = new a();
    private AtomicBoolean etk = new AtomicBoolean(false);
    private int etl = 0;
    private int etm;

    private a() {
    }

    public static a bdA() {
        return etj;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.etk.get();
        if (jSONObject != null && !z) {
            this.etk.set(true);
            this.etl = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.etm = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        }
    }

    public int bdB() {
        return this.etl;
    }

    public boolean bdC() {
        return this.etm == 1;
    }
}
