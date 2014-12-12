package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
class l implements com.baidu.adp.lib.e.c<c> {
    final /* synthetic */ i aSR;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar, Context context) {
        this.aSR = iVar;
        this.val$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: KB */
    public c ed() {
        return new c(this.val$context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: d */
    public void k(c cVar) {
        if (cVar instanceof c) {
            cVar.reset();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: e */
    public c l(c cVar) {
        return cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: f */
    public c m(c cVar) {
        if (cVar instanceof c) {
            cVar.reset();
        }
        return cVar;
    }
}
