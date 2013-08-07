package com.baidu.tieba.a;

import com.baidu.tieba.data.ao;
import com.baidu.tieba.util.u;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static final String f835a = String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/s/uo/add_pk_vote_client";
    private u b;
    private ao c;

    public String a(String str, String str2, int i) {
        this.b = new u();
        this.b.a("player_id", String.valueOf(str2));
        this.b.a("shake_number", String.valueOf(i));
        this.b.a("pk_id", String.valueOf(str));
        this.b.e(true);
        this.b.a(f835a);
        String k = this.b.k();
        this.c = new ao();
        this.c.a(k);
        return k;
    }

    public void a() {
        if (this.b != null) {
            this.b.i();
        }
    }
}
