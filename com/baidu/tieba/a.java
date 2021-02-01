package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a gbP = new a();
    private AtomicBoolean gbQ = new AtomicBoolean(false);
    private int gbR = 0;
    private int gbS;
    private int gbT;
    private int gbU;

    private a() {
    }

    public static a bJg() {
        return gbP;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.gbQ.get();
        if (jSONObject != null && !z) {
            this.gbQ.set(true);
            this.gbR = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.gbS = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
            this.gbT = jSONObject.optInt("tieba_12.2_download_ad_discard", -1);
            this.gbU = jSONObject.optInt("tieba_12.3_ad_discard_optimize", -1);
        }
    }

    public boolean bJh() {
        return this.gbS == 1;
    }

    public boolean bJi() {
        return this.gbT == 1;
    }

    public boolean bJj() {
        return this.gbU == 1;
    }
}
