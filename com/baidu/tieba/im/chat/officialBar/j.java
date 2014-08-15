package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
class j implements com.baidu.adp.lib.d.c<f> {
    final /* synthetic */ i a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, Context context) {
        this.a = iVar;
        this.b = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: b */
    public f a() {
        return new f(this.b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public void a(f fVar) {
        if (fVar instanceof f) {
            fVar.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public f b(f fVar) {
        return fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public f c(f fVar) {
        if (fVar instanceof f) {
            fVar.a();
        }
        return fVar;
    }
}
