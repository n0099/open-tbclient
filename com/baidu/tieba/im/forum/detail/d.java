package com.baidu.tieba.im.forum.detail;

import com.baidu.tbadk.core.view.ad;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class d implements ad {
    final /* synthetic */ ForumDetailActivity aZe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ForumDetailActivity forumDetailActivity) {
        this.aZe = forumDetailActivity;
    }

    @Override // com.baidu.tbadk.core.view.ad
    public void ar(boolean z) {
        k kVar;
        k kVar2;
        k kVar3;
        k kVar4;
        f fVar;
        String str;
        if (!this.aZe.aJi) {
            if (z) {
                kVar3 = this.aZe.aZa;
                kVar3.HE();
                kVar4 = this.aZe.aZa;
                kVar4.showLoading();
                fVar = this.aZe.aZb;
                str = this.aZe.mForumId;
                fVar.gG(str);
                return;
            }
            kVar = this.aZe.aZa;
            kVar.Od();
            kVar2 = this.aZe.aZa;
            kVar2.fb(z.game_index_no_network_text);
        }
    }
}
