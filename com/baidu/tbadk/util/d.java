package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class d {
    private static d ahQ = new d();
    private f ahR;
    private e ahS;

    private d() {
    }

    public static d zJ() {
        return ahQ;
    }

    public void a(e eVar) {
        this.ahS = eVar;
        if (this.ahR != null) {
            this.ahR.cancel();
        }
        this.ahR = new f(this, null);
        this.ahR.setPriority(4);
        this.ahR.execute(new String[0]);
    }

    public boolean zK() {
        int i;
        long j = 0;
        byte[] aw = com.baidu.adp.lib.util.d.aw("crash_hour_record.log");
        String str = null;
        if (aw != null) {
            str = new String(aw);
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
