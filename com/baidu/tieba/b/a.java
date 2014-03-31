package com.baidu.tieba.b;

import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.f;
/* loaded from: classes.dex */
public final class a extends f {
    private static final String c = String.valueOf(n.a) + "c/f/forum/forumrecommend";

    public final String g() {
        a("like_forum", "1");
        a("topic", "0");
        a("recommend", "0");
        a(c);
        return this.a.i();
    }

    public final long h() {
        if (this.a != null) {
            return this.a.a().c().a.d;
        }
        return 0L;
    }

    public final long i() {
        if (this.a != null) {
            return this.a.a().c().a.c;
        }
        return 0L;
    }
}
