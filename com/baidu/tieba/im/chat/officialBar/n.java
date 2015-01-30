package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
class n implements com.baidu.adp.lib.e.c<ar> {
    final /* synthetic */ i aUd;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar, Context context) {
        this.aUd = iVar;
        this.val$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: KX */
    public ar eb() {
        return new ar(this.val$context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: a */
    public void k(ar arVar) {
        if (arVar instanceof ar) {
            arVar.reset();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public ar l(ar arVar) {
        return arVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public ar m(ar arVar) {
        if (arVar instanceof ar) {
            arVar.reset();
        }
        return arVar;
    }
}
