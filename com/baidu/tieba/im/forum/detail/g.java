package com.baidu.tieba.im.forum.detail;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ ForumDetailActivity baB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ForumDetailActivity forumDetailActivity) {
        this.baB = forumDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m mVar;
        m mVar2;
        h hVar;
        String str;
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            mVar = this.baB.bax;
            mVar.Ic();
            mVar2 = this.baB.bax;
            mVar2.showLoading();
            hVar = this.baB.bay;
            str = this.baB.mForumId;
            hVar.gL(str);
        }
    }
}
