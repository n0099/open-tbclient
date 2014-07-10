package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
class r implements com.baidu.adp.lib.d.c<bf> {
    final /* synthetic */ m a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(m mVar, Context context) {
        this.a = mVar;
        this.b = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: b */
    public bf a() {
        return new bf(this.b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public void a(bf bfVar) {
        if (bfVar instanceof bf) {
            bfVar.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public bf b(bf bfVar) {
        return bfVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public bf c(bf bfVar) {
        if (bfVar instanceof bf) {
            bfVar.a();
        }
        return bfVar;
    }
}
