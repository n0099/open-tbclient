package com.baidu.tieba.frs.headvideo;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.frs.headvideo.w;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class l extends w.a {
    final /* synthetic */ ForumHeadVideoView ccd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ForumHeadVideoView forumHeadVideoView) {
        this.ccd = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.frs.headvideo.w.a
    public boolean af(View view) {
        boolean n;
        if (!com.baidu.adp.lib.util.i.gm()) {
            com.baidu.adp.lib.util.k.m(this.ccd.getContext(), this.ccd.getContext().getString(t.j.neterror));
        } else {
            e currentVideoItemView = this.ccd.getCurrentVideoItemView();
            if (currentVideoItemView != null && currentVideoItemView.getThreadInfo() != null) {
                bg threadInfo = currentVideoItemView.getThreadInfo();
                n = this.ccd.n(threadInfo);
                if (n) {
                    com.baidu.adp.lib.util.k.showToast(this.ccd.getContext(), t.j.data_illegal);
                } else {
                    currentVideoItemView.pausePlay();
                    this.ccd.o(threadInfo);
                }
            }
        }
        return super.af(view);
    }

    @Override // com.baidu.tieba.frs.headvideo.w.a
    public boolean ag(View view) {
        this.ccd.aeq();
        this.ccd.aev();
        return super.ag(view);
    }
}
