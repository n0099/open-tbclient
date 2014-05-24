package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd extends com.baidu.adp.base.e {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.adp.base.e
    public void a(Object obj) {
        di diVar;
        if (obj != null && (obj instanceof com.baidu.tieba.data.z)) {
            diVar = this.a.t;
            diVar.b().setLike(1);
            this.a.showToast(this.a.getString(com.baidu.tieba.y.like_success));
            return;
        }
        this.a.showToast(this.a.getString(com.baidu.tieba.y.had_liked_forum));
    }
}
