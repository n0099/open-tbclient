package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b {
    private static b euI = null;

    private b() {
    }

    public static synchronized b bgk() {
        b bVar;
        synchronized (b.class) {
            if (euI == null) {
                euI = new b();
            }
            bVar = euI;
        }
        return bVar;
    }

    public void bgl() {
        String bgm = bgm();
        if (!TextUtils.isEmpty(bgm)) {
            com.baidu.adp.lib.e.c.kX().a(bgm, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String bgm() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }
}
