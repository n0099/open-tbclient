package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class d {
    private static d ahT = new d();
    private f ahU;
    private e ahV;

    private d() {
    }

    public static d zP() {
        return ahT;
    }

    public void a(e eVar) {
        this.ahV = eVar;
        if (this.ahU != null) {
            this.ahU.cancel();
        }
        this.ahU = new f(this, null);
        this.ahU.setPriority(4);
        this.ahU.execute(new String[0]);
    }

    public boolean zQ() {
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
        if (j == j2 && i > 2) {
            return true;
        }
        return false;
    }
}
