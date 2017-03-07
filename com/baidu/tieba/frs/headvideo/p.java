package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.play.v;
import java.util.List;
/* loaded from: classes.dex */
class p implements v.d {
    final /* synthetic */ ForumHeadVideoView bYL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ForumHeadVideoView forumHeadVideoView) {
        this.bYL = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.play.v.d
    public void onPrepared(v vVar) {
        List list;
        if (vVar != null) {
            try {
                vVar.setVolume(0.0f, 0.0f);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        c currentVideoItemView = this.bYL.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            list = this.bYL.aVq;
            if (x.p(list) > 1) {
                currentVideoItemView.setLooping(false);
            } else {
                currentVideoItemView.setLooping(true);
            }
            currentVideoItemView.setVideoPlayState(3);
            this.bYL.z(currentVideoItemView.getThreadInfo());
        }
    }
}
