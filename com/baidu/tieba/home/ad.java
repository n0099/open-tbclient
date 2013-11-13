package com.baidu.tieba.home;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
public class ad {
    private static final String b = com.baidu.tieba.data.h.f1196a + "c/f/forum/getforumlist";

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.util.ap f1398a = null;

    public String a() {
        AccountData E = TiebaApplication.E();
        String str = null;
        if (E != null) {
            str = E.getID();
        }
        this.f1398a = new com.baidu.tieba.util.ap(b);
        this.f1398a.a(PushConstants.EXTRA_USER_ID, str);
        this.f1398a.c(true);
        return this.f1398a.j();
    }

    public void b() {
        if (this.f1398a != null) {
            this.f1398a.h();
        }
    }

    public boolean c() {
        if (this.f1398a != null) {
            return this.f1398a.c();
        }
        return false;
    }

    public String d() {
        if (this.f1398a != null) {
            return this.f1398a.g();
        }
        return null;
    }
}
