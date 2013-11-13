package com.baidu.tieba.frs;

import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1333a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(FrsImageActivity frsImageActivity) {
        this.f1333a = frsImageActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        com.baidu.tieba.model.ar arVar;
        bl blVar;
        if (obj != null && (obj instanceof com.baidu.tieba.data.ag)) {
            arVar = this.f1333a.r;
            arVar.a().setLike(1);
            blVar = this.f1333a.l;
            blVar.f().c(true);
            this.f1333a.showToast(this.f1333a.getString(R.string.like_success));
            return;
        }
        this.f1333a.showToast(this.f1333a.getString(R.string.had_liked_forum));
    }
}
