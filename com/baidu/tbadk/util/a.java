package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aCP = null;

    private a() {
    }

    public static synchronized a Gq() {
        a aVar;
        synchronized (a.class) {
            if (aCP == null) {
                aCP = new a();
            }
            aVar = aCP;
        }
        return aVar;
    }

    public void Gr() {
        String Gs = Gs();
        if (!TextUtils.isEmpty(Gs)) {
            com.baidu.adp.lib.g.c.hl().a(Gs, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Gs() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
