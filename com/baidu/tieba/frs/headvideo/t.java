package com.baidu.tieba.frs.headvideo;

import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.play.e;
import java.util.List;
/* loaded from: classes.dex */
class t implements e.a {
    final /* synthetic */ ForumHeadVideoView ccf;
    private long ccg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ForumHeadVideoView forumHeadVideoView) {
        this.ccf = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.play.e.a
    public void onCompletion(com.baidu.tieba.play.e eVar) {
        List list;
        e currentVideoItemView = this.ccf.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            list = this.ccf.aSU;
            if (y.s(list) == 1 && eVar != null && eVar.isLooping()) {
                if (System.currentTimeMillis() - this.ccg > 100) {
                    currentVideoItemView.aeB();
                    this.ccg = System.currentTimeMillis();
                    return;
                }
                return;
            }
            currentVideoItemView.setVideoPlayState(1);
            this.ccf.aeK();
        }
    }
}
