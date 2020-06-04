package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a eHT = new a();
    private AtomicBoolean eHU = new AtomicBoolean(false);
    private int eHV = 0;
    private int eHW;

    private a() {
    }

    public static a bjN() {
        return eHT;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.eHU.get();
        if (jSONObject != null && !z) {
            this.eHU.set(true);
            this.eHV = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.eHW = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        }
    }

    public int bjO() {
        return this.eHV;
    }

    public boolean bjP() {
        return this.eHW == 1;
    }
}
