package com.baidu.tieba.frs.headvideo;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.frs.headvideo.u;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class j extends u.a {
    final /* synthetic */ ForumHeadVideoView cfB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ForumHeadVideoView forumHeadVideoView) {
        this.cfB = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.frs.headvideo.u.a
    public boolean ag(View view) {
        boolean p;
        if (!com.baidu.adp.lib.util.i.gm()) {
            com.baidu.adp.lib.util.k.m(this.cfB.getContext(), this.cfB.getContext().getString(r.j.neterror));
        } else {
            c currentVideoItemView = this.cfB.getCurrentVideoItemView();
            if (currentVideoItemView != null && currentVideoItemView.getThreadInfo() != null) {
                bk threadInfo = currentVideoItemView.getThreadInfo();
                p = this.cfB.p(threadInfo);
                if (p) {
                    com.baidu.adp.lib.util.k.showToast(this.cfB.getContext(), r.j.data_illegal);
                } else {
                    currentVideoItemView.pausePlay();
                    this.cfB.q(threadInfo);
                }
            }
        }
        return super.ag(view);
    }

    @Override // com.baidu.tieba.frs.headvideo.u.a
    public boolean ah(View view) {
        this.cfB.afX();
        this.cfB.agc();
        return super.ah(view);
    }
}
