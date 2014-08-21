package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
class n implements com.baidu.adp.lib.d.c<bc> {
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
    public bc a() {
        return new bc(this.b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public void a(bc bcVar) {
        if (bcVar instanceof bc) {
            bcVar.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public bc b(bc bcVar) {
        return bcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public bc c(bc bcVar) {
        if (bcVar instanceof bc) {
            bcVar.a();
        }
        return bcVar;
    }
}
