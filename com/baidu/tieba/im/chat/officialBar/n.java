package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
class n implements com.baidu.adp.lib.e.c<ba> {
    final /* synthetic */ i aRl;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar, Context context) {
        this.aRl = iVar;
        this.val$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: Kt */
    public ba ee() {
        return new ba(this.val$context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: a */
    public void i(ba baVar) {
        if (baVar instanceof ba) {
            baVar.reset();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public ba j(ba baVar) {
        return baVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public ba k(ba baVar) {
        if (baVar instanceof ba) {
            baVar.reset();
        }
        return baVar;
    }
}
