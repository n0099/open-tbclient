package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.play.v;
import java.util.List;
/* loaded from: classes.dex */
class q implements v.a {
    final /* synthetic */ ForumHeadVideoView bRD;
    private long bRE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ForumHeadVideoView forumHeadVideoView) {
        this.bRD = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.play.v.a
    public void onCompletion(v vVar) {
        List list;
        c currentVideoItemView = this.bRD.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            list = this.bRD.aPE;
            if (w.r(list) == 1 && vVar != null && vVar.isLooping()) {
                if (System.currentTimeMillis() - this.bRE > 100) {
                    currentVideoItemView.abt();
                    this.bRE = System.currentTimeMillis();
                    return;
                }
                return;
            }
            currentVideoItemView.setVideoPlayState(1);
            this.bRD.abE();
        }
    }
}
