package com.baidu.tieba.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.f;
/* loaded from: classes.dex */
public class c extends f {
    private static final String c = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/forumsquare";

    public String g() {
        a(c);
        return b();
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
