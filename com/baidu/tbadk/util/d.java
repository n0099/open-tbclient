package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class d {
    private static d asf = new d();
    private f asg;
    private e ash;

    private d() {
    }

    public static d DU() {
        return asf;
    }

    public void a(e eVar) {
        this.ash = eVar;
        if (this.asg != null) {
            this.asg.cancel();
        }
        this.asg = new f(this, null);
        this.asg.setPriority(4);
        this.asg.execute(new String[0]);
    }

    public boolean DV() {
        int i;
        long j = 0;
        byte[] aN = com.baidu.adp.lib.util.f.aN("crash_hour_record.log");
        String str = null;
        if (aN != null) {
            str = new String(aN);
        }
        long j2 = StringUtils.getyyyyMMddHHTimeForNow();
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            String[] split = str.split(":");
            if (split == null || split.length != 2) {
                i = 0;
            } else {
                i = com.baidu.adp.lib.g.c.toInt(split[0], 0);
                j = com.baidu.adp.lib.g.c.c(split[1], j2);
            }
        }
        if (j == j2 && i > 1) {
            return true;
        }
        return false;
    }
}
