package com.baidu.tieba.frs;

import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1389a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(FrsImageActivity frsImageActivity) {
        this.f1389a = frsImageActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        com.baidu.tieba.model.ar arVar;
        if (obj != null && (obj instanceof com.baidu.tieba.data.af)) {
            arVar = this.f1389a.r;
            arVar.a().setLike(1);
            this.f1389a.showToast(this.f1389a.getString(R.string.like_success));
            return;
        }
        this.f1389a.showToast(this.f1389a.getString(R.string.had_liked_forum));
    }
}
