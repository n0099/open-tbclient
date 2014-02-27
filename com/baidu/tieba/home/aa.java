package com.baidu.tieba.home;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.ba;
/* loaded from: classes.dex */
public final class aa {
    private static final String b = String.valueOf(com.baidu.tieba.data.i.a) + "c/c/forum/msign";
    private ba a = null;

    public final String a(String str) {
        AccountData y = TiebaApplication.y();
        String str2 = null;
        if (y != null) {
            str2 = y.getID();
        }
        this.a = new ba(b);
        this.a.a(PushConstants.EXTRA_USER_ID, str2);
        this.a.a("forum_ids", str);
        this.a.c(true);
        this.a.e(true);
        return this.a.l();
    }

    public final void a() {
        if (this.a != null) {
            this.a.j();
        }
    }

    public final boolean b() {
        if (this.a != null) {
            return this.a.c();
        }
        return false;
    }

    public final String c() {
        if (this.a != null) {
            return this.a.i();
        }
        return null;
    }
}
