package com.baidu.tieba.home;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
public class z {
    private static final String b = com.baidu.tieba.data.h.a + "c/c/forum/msign";
    private com.baidu.tieba.util.an a = null;

    public String a(String str) {
        AccountData F = TiebaApplication.F();
        String str2 = null;
        if (F != null) {
            str2 = F.getID();
        }
        this.a = new com.baidu.tieba.util.an(b);
        this.a.a(PushConstants.EXTRA_USER_ID, str2);
        this.a.a("forum_ids", str);
        this.a.c(true);
        this.a.e(true);
        return this.a.l();
    }

    public void a() {
        if (this.a != null) {
            this.a.j();
        }
    }

    public boolean b() {
        if (this.a != null) {
            return this.a.c();
        }
        return false;
    }

    public String c() {
        if (this.a != null) {
            return this.a.i();
        }
        return null;
    }
}
