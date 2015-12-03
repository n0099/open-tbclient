package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a {
    private static a aAs = null;

    private a() {
    }

    public static synchronized a Fk() {
        a aVar;
        synchronized (a.class) {
            if (aAs == null) {
                aAs = new a();
            }
            aVar = aAs;
        }
        return aVar;
    }

    public void Fl() {
        String Fm = Fm();
        if (!TextUtils.isEmpty(Fm)) {
            com.baidu.adp.lib.g.c.hd().a(Fm, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Fm() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }
}
