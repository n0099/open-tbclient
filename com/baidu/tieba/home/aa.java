package com.baidu.tieba.home;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.ba;
/* loaded from: classes.dex */
public class aa {
    private static final String b = String.valueOf(com.baidu.tieba.data.i.a) + "c/c/forum/msign";
    private ba a = null;

    public String a(String str) {
        AccountData E = TiebaApplication.E();
        String str2 = null;
        if (E != null) {
            str2 = E.getID();
        }
        this.a = new ba(b);
        this.a.a(PushConstants.EXTRA_USER_ID, str2);
        this.a.a("forum_ids", str);
        this.a.c(true);
        this.a.e(true);
        return this.a.m();
    }

    public void a() {
        if (this.a != null) {
            this.a.k();
        }
    }

    public boolean b() {
        if (this.a != null) {
            return this.a.d();
        }
        return false;
    }

    public String c() {
        if (this.a != null) {
            return this.a.j();
        }
        return null;
    }
}
