package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.play.t;
import java.util.List;
/* loaded from: classes.dex */
class q implements t.d {
    final /* synthetic */ ForumHeadVideoView cfB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ForumHeadVideoView forumHeadVideoView) {
        this.cfB = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.play.t.d
    public void onPrepared(com.baidu.tieba.play.t tVar) {
        List list;
        if (tVar != null) {
            try {
                tVar.setVolume(0.0f, 0.0f);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        c currentVideoItemView = this.cfB.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            list = this.cfB.aUV;
            if (x.s(list) > 1) {
                currentVideoItemView.setLooping(false);
            } else {
                currentVideoItemView.setLooping(true);
            }
            currentVideoItemView.setVideoPlayState(3);
            this.cfB.r(currentVideoItemView.getThreadInfo());
        }
    }
}
