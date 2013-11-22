package com.baidu.tieba.home;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
public class ae {
    private static final String b = com.baidu.tieba.data.h.f1201a + "c/c/forum/msign";

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.util.ap f1390a = null;

    public String a(String str) {
        AccountData E = TiebaApplication.E();
        String str2 = null;
        if (E != null) {
            str2 = E.getID();
        }
        this.f1390a = new com.baidu.tieba.util.ap(b);
        this.f1390a.a(PushConstants.EXTRA_USER_ID, str2);
        this.f1390a.a("forum_ids", str);
        this.f1390a.c(true);
        this.f1390a.e(true);
        return this.f1390a.l();
    }

    public void a() {
        if (this.f1390a != null) {
            this.f1390a.j();
        }
    }

    public boolean b() {
        if (this.f1390a != null) {
            return this.f1390a.c();
        }
        return false;
    }

    public String c() {
        if (this.f1390a != null) {
            return this.f1390a.i();
        }
        return null;
    }
}
