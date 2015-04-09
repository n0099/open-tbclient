package com.baidu.tieba.im.forum.detail;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ ForumDetailActivity bcT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ForumDetailActivity forumDetailActivity) {
        this.bcT = forumDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m mVar;
        m mVar2;
        h hVar;
        String str;
        if (com.baidu.adp.lib.util.n.isNetOk()) {
            mVar = this.bcT.bcO;
            mVar.hideNoDataView();
            mVar2 = this.bcT.bcO;
            mVar2.showLoading();
            hVar = this.bcT.bcP;
            str = this.bcT.mForumId;
            hVar.gC(str);
        }
    }
}
