package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc extends com.baidu.adp.base.h {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        dj djVar;
        if (obj != null && (obj instanceof com.baidu.tieba.data.ab)) {
            djVar = this.a.s;
            djVar.b().setLike(1);
            this.a.showToast(this.a.getString(com.baidu.tieba.y.like_success));
            return;
        }
        this.a.showToast(this.a.getString(com.baidu.tieba.y.had_liked_forum));
    }
}
