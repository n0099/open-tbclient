package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.play.t;
import java.util.List;
/* loaded from: classes.dex */
class r implements t.a {
    final /* synthetic */ ForumHeadVideoView cfB;
    private long cfC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ForumHeadVideoView forumHeadVideoView) {
        this.cfB = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.play.t.a
    public void onCompletion(com.baidu.tieba.play.t tVar) {
        List list;
        c currentVideoItemView = this.cfB.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            list = this.cfB.aUV;
            if (x.s(list) == 1 && tVar != null && tVar.isLooping()) {
                if (System.currentTimeMillis() - this.cfC > 100) {
                    currentVideoItemView.afS();
                    this.cfC = System.currentTimeMillis();
                    return;
                }
                return;
            }
            currentVideoItemView.setVideoPlayState(1);
            this.cfB.agc();
        }
    }
}
