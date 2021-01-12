package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a fZx = new a();
    private int fZA;
    private int fZB;
    private AtomicBoolean fZy = new AtomicBoolean(false);
    private int fZz = 0;

    private a() {
    }

    public static a bIN() {
        return fZx;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.fZy.get();
        if (jSONObject != null && !z) {
            this.fZy.set(true);
            this.fZz = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.fZA = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
            this.fZB = jSONObject.optInt("tieba_12.2_download_ad_discard", -1);
        }
    }

    public boolean bIO() {
        return this.fZA == 1;
    }

    public boolean bIP() {
        return this.fZB == 1;
    }
}
