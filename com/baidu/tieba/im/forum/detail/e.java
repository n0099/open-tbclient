package com.baidu.tieba.im.forum.detail;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ ForumDetailActivity aZe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ForumDetailActivity forumDetailActivity) {
        this.aZe = forumDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k kVar;
        k kVar2;
        f fVar;
        String str;
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            kVar = this.aZe.aZa;
            kVar.HE();
            kVar2 = this.aZe.aZa;
            kVar2.showLoading();
            fVar = this.aZe.aZb;
            str = this.aZe.mForumId;
            fVar.gG(str);
        }
    }
}
