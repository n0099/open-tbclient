package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class d {
    private static d aqv = new d();
    private f aqw;
    private e aqx;

    private d() {
    }

    public static d Dd() {
        return aqv;
    }

    public void a(e eVar) {
        this.aqx = eVar;
        if (this.aqw != null) {
            this.aqw.cancel();
        }
        this.aqw = new f(this, null);
        this.aqw.setPriority(4);
        this.aqw.execute(new String[0]);
    }

    public boolean De() {
        int i;
        long j = 0;
        byte[] aE = com.baidu.adp.lib.util.f.aE("crash_hour_record.log");
        String str = null;
        if (aE != null) {
            str = new String(aE);
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
                j = com.baidu.adp.lib.g.c.a(split[1], j2);
            }
        }
        if (j == j2 && i > 1) {
            return true;
        }
        return false;
    }
}
