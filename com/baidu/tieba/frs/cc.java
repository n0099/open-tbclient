package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc extends com.baidu.adp.base.g {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.adp.base.g
    public void a(Object obj) {
        dh dhVar;
        if (obj != null && (obj instanceof com.baidu.tieba.data.z)) {
            dhVar = this.a.t;
            dhVar.b().setLike(1);
            this.a.showToast(this.a.getString(com.baidu.tieba.u.like_success));
            return;
        }
        this.a.showToast(this.a.getString(com.baidu.tieba.u.had_liked_forum));
    }
}
