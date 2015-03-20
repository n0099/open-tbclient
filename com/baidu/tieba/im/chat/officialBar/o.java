package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
class o implements com.baidu.adp.lib.e.c<av> {
    final /* synthetic */ j aYJ;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar, Context context) {
        this.aYJ = jVar;
        this.val$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: NY */
    public av hA() {
        return new av(this.val$context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: a */
    public void k(av avVar) {
        if (avVar instanceof av) {
            avVar.reset();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public av l(av avVar) {
        return avVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public av m(av avVar) {
        if (avVar instanceof av) {
            avVar.reset();
        }
        return avVar;
    }
}
