package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a {
    private static a asc = null;

    private a() {
    }

    public static synchronized a DQ() {
        a aVar;
        synchronized (a.class) {
            if (asc == null) {
                asc = new a();
            }
            aVar = asc;
        }
        return aVar;
    }

    public void DR() {
        String DS = DS();
        if (!TextUtils.isEmpty(DS)) {
            com.baidu.adp.lib.f.d.hl().a(DS, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String DS() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }
}
