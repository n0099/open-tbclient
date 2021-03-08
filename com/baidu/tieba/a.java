package com.baidu.tieba;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final a gdq = new a();
    private int gdA;
    private AtomicBoolean gdr = new AtomicBoolean(false);
    private int gds = 0;
    private int gdt;
    private int gdu;
    private int gdv;
    private String gdw;
    private int gdx;
    private int gdy;
    private int gdz;

    private a() {
    }

    public static a bJk() {
        return gdq;
    }

    public void parse(JSONObject jSONObject) {
        boolean z = this.gdr.get();
        if (jSONObject != null && !z) {
            this.gdr.set(true);
            this.gds = jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.gdt = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
            this.gdu = jSONObject.optInt("tieba_12.2_download_ad_discard", -1);
            this.gdv = jSONObject.optInt("tieba_12.3_ad_discard_optimize", -1);
            this.gdw = jSONObject.optString("tieba_follow_up_cmatch_switchs", "");
            this.gdx = jSONObject.optInt("tieba_follow_up_expire_time", 7);
            this.gdy = jSONObject.optInt("tieba_follow_up_max_remind_times", 3);
            this.gdz = jSONObject.optInt("tieba_follow_up_gap_time", 5);
            this.gdA = jSONObject.optInt("tieba_12.4_download_path", 0);
        }
    }

    public boolean bJl() {
        return this.gdt == 1;
    }

    public boolean bJm() {
        return this.gdu == 1;
    }

    public boolean bJn() {
        return this.gdv == 1;
    }

    public String bJo() {
        return this.gdw;
    }

    public int bJp() {
        return this.gdx;
    }

    public int bJq() {
        return this.gdy;
    }

    public int bJr() {
        return this.gdz;
    }

    public boolean bJs() {
        return this.gdA == 1;
    }
}
