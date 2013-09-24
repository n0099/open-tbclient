package com.baidu.tieba.a;

import com.baidu.tieba.data.ak;
import com.baidu.tieba.util.z;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static final String f871a = String.valueOf(com.baidu.tieba.data.g.f1032a) + "/c/s/uo/add_vote_client";
    private z b;
    private ak c;

    public String a(String str, int i) {
        this.b = new z();
        this.b.a("player_id", String.valueOf(str));
        this.b.a("shake_number", String.valueOf(i));
        this.b.e(true);
        this.b.a(f871a);
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
