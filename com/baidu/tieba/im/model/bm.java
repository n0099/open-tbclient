package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public final class bm {
    private static bm a;
    private com.baidu.adp.lib.d.a<String, String> b;

    private bm() {
        this.b = null;
        this.b = new com.baidu.adp.lib.d.a<>(256);
    }

    public static synchronized bm a() {
        bm bmVar;
        synchronized (bm.class) {
            if (a == null) {
                a = new bm();
            }
            bmVar = a;
        }
        return bmVar;
    }

    public final void a(String str, Long l) {
        if (str != null && str.length() > 0) {
            this.b.a(String.valueOf(TbadkApplication.E()) + str, String.valueOf(l));
        }
    }

    public final boolean a(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        String a2 = this.b.a((com.baidu.adp.lib.d.a<String, String>) (String.valueOf(TbadkApplication.E()) + str));
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return UtilHelper.a(com.baidu.adp.lib.f.b.a(a2, 0L), System.currentTimeMillis());
    }
}
