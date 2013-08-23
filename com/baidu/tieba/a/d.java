package com.baidu.tieba.a;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.k {
    private static final String c = String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/f/forum/forumrecommend";

    public String g() {
        a("like_forum", "1");
        a("topic", "0");
        a("recommend", "0");
        a(c);
        return this.f1202a.j();
    }
}
