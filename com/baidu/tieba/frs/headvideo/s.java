package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.play.e;
import java.util.List;
/* loaded from: classes.dex */
class s implements e.d {
    final /* synthetic */ ForumHeadVideoView ccf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ForumHeadVideoView forumHeadVideoView) {
        this.ccf = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.play.e.d
    public void onPrepared(com.baidu.tieba.play.e eVar) {
        List list;
        if (eVar != null) {
            try {
                eVar.setVolume(0.0f, 0.0f);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        list = this.ccf.aSU;
        if (y.s(list) > 1) {
            eVar.setLooping(false);
        } else {
            eVar.setLooping(true);
        }
        e currentVideoItemView = this.ccf.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            currentVideoItemView.setVideoPlayState(3);
            this.ccf.q(currentVideoItemView.getThreadInfo());
        }
    }
}
