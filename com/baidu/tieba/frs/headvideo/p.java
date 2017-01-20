package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.play.v;
import java.util.List;
/* loaded from: classes.dex */
class p implements v.d {
    final /* synthetic */ ForumHeadVideoView bRD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ForumHeadVideoView forumHeadVideoView) {
        this.bRD = forumHeadVideoView;
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
        c currentVideoItemView = this.bRD.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            list = this.bRD.aPE;
            if (w.r(list) > 1) {
                currentVideoItemView.setLooping(false);
            } else {
                currentVideoItemView.setLooping(true);
            }
            currentVideoItemView.setVideoPlayState(3);
            this.bRD.z(currentVideoItemView.getThreadInfo());
        }
    }
}
