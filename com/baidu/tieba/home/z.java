package com.baidu.tieba.home;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.ba;
/* loaded from: classes.dex */
public final class z {
    private static final String b = String.valueOf(com.baidu.tieba.data.i.a) + "c/f/forum/getforumlist";
    private ba a = null;

    public final String a() {
        AccountData y = TiebaApplication.y();
        String str = null;
        if (y != null) {
            str = y.getID();
        }
        this.a = new ba(b);
        this.a.a(PushConstants.EXTRA_USER_ID, str);
        this.a.c(true);
        return this.a.l();
    }

    public final void b() {
        if (this.a != null) {
            this.a.j();
        }
    }

    public final boolean c() {
        if (this.a != null) {
            return this.a.c();
        }
        return false;
    }

    public final String d() {
        if (this.a != null) {
            return this.a.i();
        }
        return null;
    }
}
