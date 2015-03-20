package com.baidu.tieba.im.forum.detail;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ ForumDetailActivity bcD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ForumDetailActivity forumDetailActivity) {
        this.bcD = forumDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m mVar;
        m mVar2;
        h hVar;
        String str;
        if (com.baidu.adp.lib.util.n.isNetOk()) {
            mVar = this.bcD.bcy;
            mVar.hideNoDataView();
            mVar2 = this.bcD.bcy;
            mVar2.showLoading();
            hVar = this.bcD.bcz;
            str = this.bcD.mForumId;
            hVar.gz(str);
        }
    }
}
