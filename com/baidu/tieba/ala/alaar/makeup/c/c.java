package com.baidu.tieba.ala.alaar.makeup.c;

import com.baidu.live.d;
/* loaded from: classes10.dex */
public abstract class c<T> extends b<T> {
    public c() {
    }

    public c(String str, T t, String str2) {
        super(str, t, str2);
    }

    @Override // com.baidu.tieba.ala.alaar.makeup.c.b
    protected long w(String str, long j) {
        return d.xf().getLong(str, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aH(String str, int i) {
        return d.xf().getInt(str, i);
    }
}
