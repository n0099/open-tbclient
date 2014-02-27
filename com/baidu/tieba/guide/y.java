package com.baidu.tieba.guide;

import com.baidu.tieba.model.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y implements by {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.a = wVar;
    }

    @Override // com.baidu.tieba.model.by
    public final void a(String str, long j) {
        a aVar;
        int a = com.baidu.adp.lib.f.b.a(String.valueOf(j), 0);
        aVar = this.a.c;
        aVar.b(a);
        this.a.a(a, false);
    }

    @Override // com.baidu.tieba.model.by
    public final void a() {
    }
}
