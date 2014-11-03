package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
class l implements com.baidu.adp.lib.e.c<c> {
    final /* synthetic */ i aRl;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar, Context context) {
        this.aRl = iVar;
        this.val$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: Ks */
    public c ee() {
        return new c(this.val$context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: d */
    public void i(c cVar) {
        if (cVar instanceof c) {
            cVar.reset();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: e */
    public c j(c cVar) {
        return cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: f */
    public c k(c cVar) {
        if (cVar instanceof c) {
            cVar.reset();
        }
        return cVar;
    }
}
