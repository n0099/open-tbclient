package com.baidu.tieba.a;

import com.baidu.tieba.data.ao;
import com.baidu.tieba.util.u;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f836a = String.valueOf(com.baidu.tieba.data.g.f1013a) + "/c/s/uo/add_vote_client";
    private u b;
    private ao c;

    public String a(String str, int i) {
        this.b = new u();
        this.b.a("player_id", String.valueOf(str));
        this.b.a("shake_number", String.valueOf(i));
        this.b.e(true);
        this.b.a(f836a);
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
