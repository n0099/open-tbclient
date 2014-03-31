package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p implements com.baidu.adp.lib.d.c<c> {
    final /* synthetic */ m a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar, Context context) {
        this.a = mVar;
        this.b = context;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ c a() {
        return new c(this.b);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.adp.lib.d.c
    public final /* bridge */ /* synthetic */ void a(c cVar) {
        c cVar2 = cVar;
        if (cVar2 instanceof c) {
            cVar2.a();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* bridge */ /* synthetic */ c b(c cVar) {
        return cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ c c(c cVar) {
        c cVar2 = cVar;
        if (cVar2 instanceof c) {
            cVar2.a();
        }
        return cVar2;
    }
}
