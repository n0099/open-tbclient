package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class b {
    private static b bdW = null;

    private b() {
    }

    public static synchronized b Ot() {
        b bVar;
        synchronized (b.class) {
            if (bdW == null) {
                bdW = new b();
            }
            bVar = bdW;
        }
        return bVar;
    }

    public void Ou() {
        String Ov = Ov();
        if (!TextUtils.isEmpty(Ov)) {
            com.baidu.adp.lib.f.c.jC().a(Ov, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Ov() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
