package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class b {
    private static b biZ = null;

    private b() {
    }

    public static synchronized b Qc() {
        b bVar;
        synchronized (b.class) {
            if (biZ == null) {
                biZ = new b();
            }
            bVar = biZ;
        }
        return bVar;
    }

    public void Qd() {
        String Qe = Qe();
        if (!TextUtils.isEmpty(Qe)) {
            com.baidu.adp.lib.f.c.jA().a(Qe, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Qe() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
