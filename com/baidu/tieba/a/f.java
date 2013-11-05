package com.baidu.tieba.a;

import com.baidu.cloudsdk.social.core.SocialConstants;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.n {
    private static final String c = com.baidu.tieba.data.h.f1165a + "c/f/forum/forumrecommend";

    public String g() {
        a("like_forum", SocialConstants.TRUE);
        a("topic", SocialConstants.FALSE);
        a("recommend", SocialConstants.FALSE);
        a(c);
        return this.f2027a.j();
    }
}
