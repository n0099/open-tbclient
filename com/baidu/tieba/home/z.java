package com.baidu.tieba.home;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.ba;
/* loaded from: classes.dex */
public class z {
    private static final String b = String.valueOf(com.baidu.tieba.data.i.a) + "c/f/forum/getforumlist";
    private ba a = null;

    public String a() {
        AccountData E = TiebaApplication.E();
        String str = null;
        if (E != null) {
            str = E.getID();
        }
        this.a = new ba(b);
        this.a.a(PushConstants.EXTRA_USER_ID, str);
        this.a.c(true);
        return this.a.m();
    }

    public void b() {
        if (this.a != null) {
            this.a.k();
        }
    }

    public boolean c() {
        if (this.a != null) {
            return this.a.d();
        }
        return false;
    }

    public String d() {
        if (this.a != null) {
            return this.a.j();
        }
        return null;
    }
}
