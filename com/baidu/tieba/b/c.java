package com.baidu.tieba.b;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.l;
/* loaded from: classes.dex */
public final class c extends l {
    private static final String c = String.valueOf(com.baidu.tieba.data.i.a) + "c/f/forum/forumrecommend";

    public final String g() {
        a("like_forum", SocialConstants.TRUE);
        a("topic", SocialConstants.FALSE);
        a("recommend", SocialConstants.FALSE);
        a(c);
        return this.a.l();
    }

    public final long h() {
        if (this.a != null) {
            return this.a.p();
        }
        return 0L;
    }

    public final long i() {
        if (this.a != null) {
            return this.a.q();
        }
        return 0L;
    }
}
