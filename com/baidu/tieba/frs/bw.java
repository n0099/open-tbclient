package com.baidu.tieba.frs;
/* loaded from: classes.dex */
final class bw extends com.baidu.adp.a.h {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        cy cyVar;
        if (obj != null && (obj instanceof com.baidu.tieba.data.z)) {
            cyVar = this.a.q;
            cyVar.b().setLike(1);
            this.a.showToast(this.a.getString(com.baidu.tieba.a.k.like_success));
            return;
        }
        this.a.showToast(this.a.getString(com.baidu.tieba.a.k.had_liked_forum));
    }
}
