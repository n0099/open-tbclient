package com.baidu.tieba.a;

import com.baidu.tieba.data.ak;
import com.baidu.tieba.util.v;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f857a = String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/s/uo/add_pk_vote_client";
    private v b;
    private ak c;

    public String a(String str, String str2, int i) {
        this.b = new v();
        this.b.a("player_id", String.valueOf(str2));
        this.b.a("shake_number", String.valueOf(i));
        this.b.a("pk_id", String.valueOf(str));
        this.b.e(true);
        this.b.a(f857a);
        String j = this.b.j();
        this.c = new ak();
        this.c.a(j);
        return j;
    }

    public void a() {
        if (this.b != null) {
            this.b.h();
        }
    }
}
