package com.baidu.tieba.im.forum.detail;

import com.baidu.tbadk.core.view.ad;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class f implements ad {
    final /* synthetic */ ForumDetailActivity baA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ForumDetailActivity forumDetailActivity) {
        this.baA = forumDetailActivity;
    }

    @Override // com.baidu.tbadk.core.view.ad
    public void at(boolean z) {
        m mVar;
        m mVar2;
        m mVar3;
        m mVar4;
        h hVar;
        String str;
        if (!this.baA.aKp) {
            if (z) {
                mVar3 = this.baA.baw;
                mVar3.HW();
                mVar4 = this.baA.baw;
                mVar4.showLoading();
                hVar = this.baA.bax;
                str = this.baA.mForumId;
                hVar.gI(str);
                return;
            }
            mVar = this.baA.baw;
            mVar.Ou();
            mVar2 = this.baA.baw;
            mVar2.fg(z.game_index_no_network_text);
        }
    }
}
