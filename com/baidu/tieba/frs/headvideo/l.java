package com.baidu.tieba.frs.headvideo;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.frs.headvideo.w;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class l extends w.a {
    final /* synthetic */ ForumHeadVideoView ccf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ForumHeadVideoView forumHeadVideoView) {
        this.ccf = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.frs.headvideo.w.a
    public boolean af(View view) {
        boolean o;
        if (!com.baidu.adp.lib.util.i.gm()) {
            com.baidu.adp.lib.util.k.m(this.ccf.getContext(), this.ccf.getContext().getString(r.j.neterror));
        } else {
            e currentVideoItemView = this.ccf.getCurrentVideoItemView();
            if (currentVideoItemView != null && currentVideoItemView.getThreadInfo() != null) {
                bi threadInfo = currentVideoItemView.getThreadInfo();
                o = this.ccf.o(threadInfo);
                if (o) {
                    com.baidu.adp.lib.util.k.showToast(this.ccf.getContext(), r.j.data_illegal);
                } else {
                    currentVideoItemView.pausePlay();
                    this.ccf.p(threadInfo);
                }
            }
        }
        return super.af(view);
    }

    @Override // com.baidu.tieba.frs.headvideo.w.a
    public boolean ag(View view) {
        this.ccf.aeF();
        this.ccf.aeK();
        return super.ag(view);
    }
}
