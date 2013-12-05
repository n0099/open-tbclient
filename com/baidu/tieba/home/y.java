package com.baidu.tieba.home;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
public class y {
    private static final String b = com.baidu.tieba.data.h.f1248a + "c/f/forum/getforumlist";

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.util.am f1509a = null;

    public String a() {
        AccountData F = TiebaApplication.F();
        String str = null;
        if (F != null) {
            str = F.getID();
        }
        this.f1509a = new com.baidu.tieba.util.am(b);
        this.f1509a.a(PushConstants.EXTRA_USER_ID, str);
        this.f1509a.c(true);
        return this.f1509a.l();
    }

    public void b() {
        if (this.f1509a != null) {
            this.f1509a.j();
        }
    }

    public boolean c() {
        if (this.f1509a != null) {
            return this.f1509a.c();
        }
        return false;
    }

    public String d() {
        if (this.f1509a != null) {
            return this.f1509a.i();
        }
        return null;
    }
}
