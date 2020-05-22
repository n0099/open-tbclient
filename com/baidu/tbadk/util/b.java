package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b {
    private static b euI = null;

    private b() {
    }

    public static synchronized b bgj() {
        b bVar;
        synchronized (b.class) {
            if (euI == null) {
                euI = new b();
            }
            bVar = euI;
        }
        return bVar;
    }

    public void bgk() {
        String bgl = bgl();
        if (!TextUtils.isEmpty(bgl)) {
            com.baidu.adp.lib.e.c.kX().a(bgl, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String bgl() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }
}
