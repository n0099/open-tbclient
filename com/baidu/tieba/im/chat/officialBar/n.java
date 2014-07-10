package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
class n implements com.baidu.adp.lib.d.c<h> {
    final /* synthetic */ m a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, Context context) {
        this.a = mVar;
        this.b = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: b */
    public h a() {
        return new h(this.b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public void a(h hVar) {
        if (hVar instanceof h) {
            hVar.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public h b(h hVar) {
        return hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public h c(h hVar) {
        if (hVar instanceof h) {
            hVar.a();
        }
        return hVar;
    }
}
