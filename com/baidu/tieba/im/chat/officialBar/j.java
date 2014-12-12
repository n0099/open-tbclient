package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
class j implements com.baidu.adp.lib.e.c<f> {
    final /* synthetic */ i aSR;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, Context context) {
        this.aSR = iVar;
        this.val$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: KA */
    public f ed() {
        return new f(this.val$context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: d */
    public void k(f fVar) {
        if (fVar instanceof f) {
            fVar.reset();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: e */
    public f l(f fVar) {
        return fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: f */
    public f m(f fVar) {
        if (fVar instanceof f) {
            fVar.reset();
        }
        return fVar;
    }
}
