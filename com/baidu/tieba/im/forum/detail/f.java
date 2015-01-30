package com.baidu.tieba.im.forum.detail;

import com.baidu.tbadk.core.view.ad;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class f implements ad {
    final /* synthetic */ ForumDetailActivity baB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ForumDetailActivity forumDetailActivity) {
        this.baB = forumDetailActivity;
    }

    @Override // com.baidu.tbadk.core.view.ad
    public void at(boolean z) {
        m mVar;
        m mVar2;
        m mVar3;
        m mVar4;
        h hVar;
        String str;
        if (!this.baB.aKs) {
            if (z) {
                mVar3 = this.baB.bax;
                mVar3.Ic();
                mVar4 = this.baB.bax;
                mVar4.showLoading();
                hVar = this.baB.bay;
                str = this.baB.mForumId;
                hVar.gL(str);
                return;
            }
            mVar = this.baB.bax;
            mVar.Oz();
            mVar2 = this.baB.bax;
            mVar2.fg(z.game_index_no_network_text);
        }
    }
}
