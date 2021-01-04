package com.baidu.tieba.ala.alaar.makeup.c;

import com.baidu.live.d;
/* loaded from: classes11.dex */
public abstract class c<T> extends b<T> {
    public c() {
    }

    public c(String str, T t, String str2) {
        super(str, t, str2);
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.c.b
    protected long x(String str, long j) {
        return d.Ba().getLong(str, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aE(String str, int i) {
        return d.Ba().getInt(str, i);
    }
}
