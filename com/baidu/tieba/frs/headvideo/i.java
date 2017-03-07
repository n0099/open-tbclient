package com.baidu.tieba.frs.headvideo;

import android.view.View;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.frs.headvideo.t;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class i extends t.a {
    final /* synthetic */ ForumHeadVideoView bYL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ForumHeadVideoView forumHeadVideoView) {
        this.bYL = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.frs.headvideo.t.a
    public boolean aj(View view) {
        boolean x;
        if (!com.baidu.adp.lib.util.i.he()) {
            com.baidu.adp.lib.util.k.G(this.bYL.getContext(), this.bYL.getContext().getString(w.l.neterror));
        } else {
            c currentVideoItemView = this.bYL.getCurrentVideoItemView();
            if (currentVideoItemView != null && currentVideoItemView.getThreadInfo() != null) {
                bj threadInfo = currentVideoItemView.getThreadInfo();
                x = this.bYL.x(threadInfo);
                if (x) {
                    com.baidu.adp.lib.util.k.showToast(this.bYL.getContext(), w.l.data_illegal);
                } else {
                    currentVideoItemView.pausePlay();
                    this.bYL.y(threadInfo);
                }
            }
        }
        return super.aj(view);
    }

    @Override // com.baidu.tieba.frs.headvideo.t.a
    public boolean ak(View view) {
        this.bYL.acw();
        this.bYL.acB();
        return super.ak(view);
    }
}
