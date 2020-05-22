package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a eHI = new a();
    private AtomicBoolean eHJ = new AtomicBoolean(false);
    private int eHK = 0;
    private int eHL;

    private a() {
    }

    public static a bjL() {
        return eHI;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.eHJ.get();
        if (jSONObject != null && !z) {
            this.eHJ.set(true);
            this.eHK = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.eHL = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        }
    }

    public int bjM() {
        return this.eHK;
    }

    public boolean bjN() {
        return this.eHL == 1;
    }
}
