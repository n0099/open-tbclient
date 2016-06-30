package com.baidu.tieba.frs.headvideo;

import android.view.View;
import com.baidu.tbadk.core.data.az;
import com.baidu.tieba.frs.headvideo.w;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class l extends w.a {
    final /* synthetic */ ForumHeadVideoView bPh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ForumHeadVideoView forumHeadVideoView) {
        this.bPh = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.frs.headvideo.w.a
    public boolean ah(View view) {
        boolean l;
        if (!com.baidu.adp.lib.util.i.fr()) {
            com.baidu.adp.lib.util.k.m(this.bPh.getContext(), this.bPh.getContext().getString(u.j.neterror));
        } else {
            e currentVideoItemView = this.bPh.getCurrentVideoItemView();
            if (currentVideoItemView != null && currentVideoItemView.getThreadInfo() != null) {
                az threadInfo = currentVideoItemView.getThreadInfo();
                l = this.bPh.l(threadInfo);
                if (l) {
                    com.baidu.adp.lib.util.k.showToast(this.bPh.getContext(), u.j.data_illegal);
                } else {
                    currentVideoItemView.Zf();
                    this.bPh.m(threadInfo);
                }
            }
        }
        return super.ah(view);
    }

    @Override // com.baidu.tieba.frs.headvideo.w.a
    public boolean ai(View view) {
        this.bPh.Zk();
        this.bPh.Zp();
        return super.ai(view);
    }
}
