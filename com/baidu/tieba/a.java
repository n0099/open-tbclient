package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a geg = new a();
    private AtomicBoolean geh = new AtomicBoolean(false);
    private int gei = 0;
    private int gej;
    private int gek;

    private a() {
    }

    public static a bMF() {
        return geg;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.geh.get();
        if (jSONObject != null && !z) {
            this.geh.set(true);
            this.gei = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.gej = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
            this.gek = jSONObject.optInt("tieba_12.2_download_ad_discard", -1);
        }
    }

    public boolean bMG() {
        return this.gej == 1;
    }

    public boolean bMH() {
        return this.gek == 1;
    }
}
