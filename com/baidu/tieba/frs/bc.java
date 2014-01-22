package com.baidu.tieba.frs;

import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc extends com.baidu.adp.a.g {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        com.baidu.tieba.model.ar arVar;
        if (obj != null && (obj instanceof com.baidu.tieba.data.ag)) {
            arVar = this.a.q;
            arVar.b().setLike(1);
            this.a.showToast(this.a.getString(R.string.like_success));
            return;
        }
        this.a.showToast(this.a.getString(R.string.had_liked_forum));
    }
}
