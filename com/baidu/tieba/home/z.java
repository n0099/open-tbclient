package com.baidu.tieba.home;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
public class z {
    private static final String b = com.baidu.tieba.data.h.f1248a + "c/c/forum/msign";

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.util.am f1510a = null;

    public String a(String str) {
        AccountData F = TiebaApplication.F();
        String str2 = null;
        if (F != null) {
            str2 = F.getID();
        }
        this.f1510a = new com.baidu.tieba.util.am(b);
        this.f1510a.a(PushConstants.EXTRA_USER_ID, str2);
        this.f1510a.a("forum_ids", str);
        this.f1510a.c(true);
        this.f1510a.e(true);
        return this.f1510a.l();
    }

    public void a() {
        if (this.f1510a != null) {
            this.f1510a.j();
        }
    }

    public boolean b() {
        if (this.f1510a != null) {
            return this.f1510a.c();
        }
        return false;
    }

    public String c() {
        if (this.f1510a != null) {
            return this.f1510a.i();
        }
        return null;
    }
}
