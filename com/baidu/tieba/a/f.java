package com.baidu.tieba.a;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class f extends n {
    private static final String c = com.baidu.tieba.data.h.f1196a + "c/f/forum/forumrecommend";

    public String g() {
        a("like_forum", SocialConstants.TRUE);
        a("topic", SocialConstants.FALSE);
        a("recommend", SocialConstants.FALSE);
        a(c);
        return this.f2043a.j();
    }
}
