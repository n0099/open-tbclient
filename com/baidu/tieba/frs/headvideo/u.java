package com.baidu.tieba.frs.headvideo;

import com.baidu.tieba.play.e;
/* loaded from: classes.dex */
class u implements e.b {
    final /* synthetic */ ForumHeadVideoView ccf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ForumHeadVideoView forumHeadVideoView) {
        this.ccf = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.play.e.b
    public boolean onError(com.baidu.tieba.play.e eVar, int i, int i2) {
        e currentVideoItemView = this.ccf.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            currentVideoItemView.stopPlayback();
            currentVideoItemView.setVideoPlayState(4);
            return true;
        }
        return true;
    }
}
