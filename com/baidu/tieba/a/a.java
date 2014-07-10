package com.baidu.tieba.a;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.e {
    private static final String c = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/forumrecommend";

    public String g() {
        a("like_forum", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
        a("topic", "0");
        a("recommend", "0");
        a(c);
        return this.a.i();
    }

    public long h() {
        if (this.a != null) {
            return this.a.a().c().a.d;
        }
        return 0L;
    }

    public long i() {
        if (this.a != null) {
            return this.a.a().c().a.c;
        }
        return 0L;
    }
}
