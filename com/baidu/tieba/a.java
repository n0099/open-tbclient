package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a fNo = new a();
    private AtomicBoolean fNp = new AtomicBoolean(false);
    private int fNq = 0;
    private int fNr;

    private a() {
    }

    public static a bHt() {
        return fNo;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.fNp.get();
        if (jSONObject != null && !z) {
            this.fNp.set(true);
            this.fNq = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.fNr = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        }
    }

    @Deprecated
    public int bHu() {
        return this.fNq;
    }

    public boolean bHv() {
        return this.fNr == 1;
    }
}
