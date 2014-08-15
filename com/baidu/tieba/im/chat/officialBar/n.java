package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
class n implements com.baidu.adp.lib.d.c<bb> {
    final /* synthetic */ i a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar, Context context) {
        this.a = iVar;
        this.b = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: b */
    public bb a() {
        return new bb(this.b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public void a(bb bbVar) {
        if (bbVar instanceof bb) {
            bbVar.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public bb b(bb bbVar) {
        return bbVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public bb c(bb bbVar) {
        if (bbVar instanceof bb) {
            bbVar.a();
        }
        return bbVar;
    }
}
