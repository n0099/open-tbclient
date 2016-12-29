package com.baidu.tieba.frs.headvideo;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.frs.headvideo.u;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class j extends u.a {
    final /* synthetic */ ForumHeadVideoView bLk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ForumHeadVideoView forumHeadVideoView) {
        this.bLk = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.frs.headvideo.u.a
    public boolean ag(View view) {
        boolean u;
        if (!com.baidu.adp.lib.util.i.gm()) {
            com.baidu.adp.lib.util.k.m(this.bLk.getContext(), this.bLk.getContext().getString(r.j.neterror));
        } else {
            c currentVideoItemView = this.bLk.getCurrentVideoItemView();
            if (currentVideoItemView != null && currentVideoItemView.getThreadInfo() != null) {
                bg threadInfo = currentVideoItemView.getThreadInfo();
                u = this.bLk.u(threadInfo);
                if (u) {
                    com.baidu.adp.lib.util.k.showToast(this.bLk.getContext(), r.j.data_illegal);
                } else {
                    currentVideoItemView.pausePlay();
                    this.bLk.v(threadInfo);
                }
            }
        }
        return super.ag(view);
    }

    @Override // com.baidu.tieba.frs.headvideo.u.a
    public boolean ah(View view) {
        this.bLk.aat();
        this.bLk.aay();
        return super.ah(view);
    }
}
