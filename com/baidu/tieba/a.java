package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a fzd = new a();
    private AtomicBoolean fze = new AtomicBoolean(false);
    private int fzf = 0;
    private int fzg;

    private a() {
    }

    public static a bDb() {
        return fzd;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.fze.get();
        if (jSONObject != null && !z) {
            this.fze.set(true);
            this.fzf = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.fzg = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        }
    }

    @Deprecated
    public int bDc() {
        return this.fzf;
    }

    public boolean bDd() {
        return this.fzg == 1;
    }
}
