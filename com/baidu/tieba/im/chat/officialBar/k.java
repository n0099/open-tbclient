package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
class k implements com.baidu.adp.lib.e.c<g> {
    final /* synthetic */ j aYZ;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, Context context) {
        this.aYZ = jVar;
        this.val$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: Oj */
    public g hA() {
        return new g(this.val$context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: d */
    public void k(g gVar) {
        if (gVar instanceof g) {
            gVar.reset();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: e */
    public g l(g gVar) {
        return gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: f */
    public g m(g gVar) {
        if (gVar instanceof g) {
            gVar.reset();
        }
        return gVar;
    }
}
