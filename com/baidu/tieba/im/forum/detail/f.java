package com.baidu.tieba.im.forum.detail;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.core.view.y {
    final /* synthetic */ ForumDetailActivity bcD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ForumDetailActivity forumDetailActivity) {
        this.bcD = forumDetailActivity;
    }

    @Override // com.baidu.tbadk.core.view.y
    public void an(boolean z) {
        m mVar;
        m mVar2;
        m mVar3;
        m mVar4;
        h hVar;
        String str;
        if (!this.bcD.aQr) {
            if (z) {
                mVar3 = this.bcD.bcy;
                mVar3.hideNoDataView();
                mVar4 = this.bcD.bcy;
                mVar4.showLoading();
                hVar = this.bcD.bcz;
                str = this.bcD.mForumId;
                hVar.gz(str);
                return;
            }
            mVar = this.bcD.bcy;
            mVar.Qj();
            mVar2 = this.bcD.bcy;
            mVar2.fg(com.baidu.tieba.y.game_index_no_network_text);
        }
    }
}
