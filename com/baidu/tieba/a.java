package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a eSf = new a();
    private AtomicBoolean eSg = new AtomicBoolean(false);
    private int eSh = 0;
    private int eSi;

    private a() {
    }

    public static a bmm() {
        return eSf;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.eSg.get();
        if (jSONObject != null && !z) {
            this.eSg.set(true);
            this.eSh = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.eSi = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        }
    }

    public int bmn() {
        return this.eSh;
    }

    public boolean bmo() {
        return this.eSi == 1;
    }
}
