package com.baidu.tieba.im.forum.detail;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.core.view.y {
    final /* synthetic */ ForumDetailActivity bcT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ForumDetailActivity forumDetailActivity) {
        this.bcT = forumDetailActivity;
    }

    @Override // com.baidu.tbadk.core.view.y
    public void an(boolean z) {
        m mVar;
        m mVar2;
        m mVar3;
        m mVar4;
        h hVar;
        String str;
        if (!this.bcT.aQI) {
            if (z) {
                mVar3 = this.bcT.bcO;
                mVar3.hideNoDataView();
                mVar4 = this.bcT.bcO;
                mVar4.showLoading();
                hVar = this.bcT.bcP;
                str = this.bcT.mForumId;
                hVar.gC(str);
                return;
            }
            mVar = this.bcT.bcO;
            mVar.Qw();
            mVar2 = this.bcT.bcO;
            mVar2.fh(com.baidu.tieba.y.game_index_no_network_text);
        }
    }
}
