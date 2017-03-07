package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.play.v;
import java.util.List;
/* loaded from: classes.dex */
class q implements v.a {
    final /* synthetic */ ForumHeadVideoView bYL;
    private long bYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ForumHeadVideoView forumHeadVideoView) {
        this.bYL = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.play.v.a
    public void onCompletion(v vVar) {
        List list;
        c currentVideoItemView = this.bYL.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            list = this.bYL.aVq;
            if (x.p(list) == 1 && vVar != null && vVar.isLooping()) {
                if (System.currentTimeMillis() - this.bYM > 100) {
                    currentVideoItemView.acq();
                    this.bYM = System.currentTimeMillis();
                    return;
                }
                return;
            }
            currentVideoItemView.setVideoPlayState(1);
            this.bYL.acB();
        }
    }
}
