package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a cRQ = new a();
    private AtomicBoolean cRR = new AtomicBoolean(false);
    private int cRS = 0;

    private a() {
    }

    public static a aAF() {
        return cRQ;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.cRR.get();
        if (jSONObject != null && !z) {
            this.cRR.set(true);
            this.cRS = jSONObject.optInt("tieba_landing_page_type_switch", -1);
        }
    }

    public int aAG() {
        return this.cRS;
    }
}
