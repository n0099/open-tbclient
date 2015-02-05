package com.baidu.tieba.im.forum.detail;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ ForumDetailActivity baA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ForumDetailActivity forumDetailActivity) {
        this.baA = forumDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m mVar;
        m mVar2;
        h hVar;
        String str;
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            mVar = this.baA.baw;
            mVar.HW();
            mVar2 = this.baA.baw;
            mVar2.showLoading();
            hVar = this.baA.bax;
            str = this.baA.mForumId;
            hVar.gI(str);
        }
    }
}
