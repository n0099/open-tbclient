package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class bt {
    private static bt a;
    private com.baidu.adp.lib.d.a<String, String> b;

    private bt() {
        this.b = null;
        this.b = new com.baidu.adp.lib.d.a<>(256);
    }

    public static synchronized bt a() {
        bt btVar;
        synchronized (bt.class) {
            if (a == null) {
                a = new bt();
            }
            btVar = a;
        }
        return btVar;
    }

    public void a(String str, Long l) {
        if (str != null && str.length() > 0) {
            this.b.a(String.valueOf(TbadkApplication.getCurrentAccount()) + str, String.valueOf(l));
        }
    }

    public boolean a(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        String a2 = this.b.a((com.baidu.adp.lib.d.a<String, String>) (String.valueOf(TbadkApplication.getCurrentAccount()) + str));
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return UtilHelper.isSameDay(com.baidu.adp.lib.f.b.a(a2, 0L), System.currentTimeMillis());
    }
}
