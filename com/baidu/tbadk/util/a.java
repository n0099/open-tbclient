package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a {
    private static a aAN = null;

    private a() {
    }

    public static synchronized a EF() {
        a aVar;
        synchronized (a.class) {
            if (aAN == null) {
                aAN = new a();
            }
            aVar = aAN;
        }
        return aVar;
    }

    public void EG() {
        String EH = EH();
        if (!TextUtils.isEmpty(EH)) {
            com.baidu.adp.lib.f.c.gZ().a(EH, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String EH() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }
}
