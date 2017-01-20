package com.baidu.tieba.frs.headvideo;

import android.view.View;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.frs.headvideo.t;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class i extends t.a {
    final /* synthetic */ ForumHeadVideoView bRD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ForumHeadVideoView forumHeadVideoView) {
        this.bRD = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.frs.headvideo.t.a
    public boolean al(View view) {
        boolean x;
        if (!com.baidu.adp.lib.util.i.gk()) {
            com.baidu.adp.lib.util.k.m(this.bRD.getContext(), this.bRD.getContext().getString(r.l.neterror));
        } else {
            c currentVideoItemView = this.bRD.getCurrentVideoItemView();
            if (currentVideoItemView != null && currentVideoItemView.getThreadInfo() != null) {
                bh threadInfo = currentVideoItemView.getThreadInfo();
                x = this.bRD.x(threadInfo);
                if (x) {
                    com.baidu.adp.lib.util.k.showToast(this.bRD.getContext(), r.l.data_illegal);
                } else {
                    currentVideoItemView.pausePlay();
                    this.bRD.y(threadInfo);
                }
            }
        }
        return super.al(view);
    }

    @Override // com.baidu.tieba.frs.headvideo.t.a
    public boolean am(View view) {
        this.bRD.abz();
        this.bRD.abE();
        return super.am(view);
    }
}
