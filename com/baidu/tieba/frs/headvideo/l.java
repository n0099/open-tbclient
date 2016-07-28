package com.baidu.tieba.frs.headvideo;

import android.view.View;
import com.baidu.tbadk.core.data.be;
import com.baidu.tieba.frs.headvideo.w;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class l extends w.a {
    final /* synthetic */ ForumHeadVideoView bQU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ForumHeadVideoView forumHeadVideoView) {
        this.bQU = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.frs.headvideo.w.a
    public boolean af(View view) {
        boolean n;
        if (!com.baidu.adp.lib.util.i.fq()) {
            com.baidu.adp.lib.util.k.m(this.bQU.getContext(), this.bQU.getContext().getString(u.j.neterror));
        } else {
            e currentVideoItemView = this.bQU.getCurrentVideoItemView();
            if (currentVideoItemView != null && currentVideoItemView.getThreadInfo() != null) {
                be threadInfo = currentVideoItemView.getThreadInfo();
                n = this.bQU.n(threadInfo);
                if (n) {
                    com.baidu.adp.lib.util.k.showToast(this.bQU.getContext(), u.j.data_illegal);
                } else {
                    currentVideoItemView.ZB();
                    this.bQU.o(threadInfo);
                }
            }
        }
        return super.af(view);
    }

    @Override // com.baidu.tieba.frs.headvideo.w.a
    public boolean ag(View view) {
        this.bQU.ZG();
        this.bQU.ZL();
        return super.ag(view);
    }
}
