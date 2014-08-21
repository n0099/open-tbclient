package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce extends com.baidu.adp.base.h {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        Cdo cdo;
        if (obj != null && (obj instanceof com.baidu.tieba.data.ab)) {
            cdo = this.a.t;
            cdo.b().setLike(1);
            this.a.showToast(this.a.getString(com.baidu.tieba.x.like_success));
            return;
        }
        this.a.showToast(this.a.getString(com.baidu.tieba.x.had_liked_forum));
    }
}
