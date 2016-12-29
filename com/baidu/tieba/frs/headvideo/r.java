package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.play.t;
import java.util.List;
/* loaded from: classes.dex */
class r implements t.a {
    final /* synthetic */ ForumHeadVideoView bLk;
    private long bLl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ForumHeadVideoView forumHeadVideoView) {
        this.bLk = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.play.t.a
    public void onCompletion(com.baidu.tieba.play.t tVar) {
        List list;
        c currentVideoItemView = this.bLk.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            list = this.bLk.aUm;
            if (x.s(list) == 1 && tVar != null && tVar.isLooping()) {
                if (System.currentTimeMillis() - this.bLl > 100) {
                    currentVideoItemView.aao();
                    this.bLl = System.currentTimeMillis();
                    return;
                }
                return;
            }
            currentVideoItemView.setVideoPlayState(1);
            this.bLk.aay();
        }
    }
}
