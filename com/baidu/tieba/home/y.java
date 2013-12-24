package com.baidu.tieba.home;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
public class y {
    private static final String b = com.baidu.tieba.data.h.a + "c/f/forum/getforumlist";
    private com.baidu.tieba.util.an a = null;

    public String a() {
        AccountData F = TiebaApplication.F();
        String str = null;
        if (F != null) {
            str = F.getID();
        }
        this.a = new com.baidu.tieba.util.an(b);
        this.a.a(PushConstants.EXTRA_USER_ID, str);
        this.a.c(true);
        return this.a.l();
    }

    public void b() {
        if (this.a != null) {
            this.a.j();
        }
    }

    public boolean c() {
        if (this.a != null) {
            return this.a.c();
        }
        return false;
    }

    public String d() {
        if (this.a != null) {
            return this.a.i();
        }
        return null;
    }
}
