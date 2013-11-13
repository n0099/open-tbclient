package com.baidu.tieba.home;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
public class ae {
    private static final String b = com.baidu.tieba.data.h.f1196a + "c/c/forum/msign";

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.util.ap f1399a = null;

    public String a(String str) {
        AccountData E = TiebaApplication.E();
        String str2 = null;
        if (E != null) {
            str2 = E.getID();
        }
        this.f1399a = new com.baidu.tieba.util.ap(b);
        this.f1399a.a(PushConstants.EXTRA_USER_ID, str2);
        this.f1399a.a("forum_ids", str);
        this.f1399a.c(true);
        this.f1399a.e(true);
        return this.f1399a.j();
    }

    public void a() {
        if (this.f1399a != null) {
            this.f1399a.h();
        }
    }

    public boolean b() {
        if (this.f1399a != null) {
            return this.f1399a.c();
        }
        return false;
    }

    public String c() {
        if (this.f1399a != null) {
            return this.f1399a.g();
        }
        return null;
    }
}
