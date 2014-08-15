package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
class l implements com.baidu.adp.lib.d.c<c> {
    final /* synthetic */ i a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar, Context context) {
        this.a = iVar;
        this.b = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: b */
    public c a() {
        return new c(this.b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public void a(c cVar) {
        if (cVar instanceof c) {
            cVar.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public c b(c cVar) {
        return cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public c c(c cVar) {
        if (cVar instanceof c) {
            cVar.a();
        }
        return cVar;
    }
}
