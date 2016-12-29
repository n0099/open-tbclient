package com.baidu.tieba.frs.headvideo;

import com.baidu.tieba.play.t;
/* loaded from: classes.dex */
class s implements t.b {
    final /* synthetic */ ForumHeadVideoView bLk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ForumHeadVideoView forumHeadVideoView) {
        this.bLk = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.play.t.b
    public boolean onError(com.baidu.tieba.play.t tVar, int i, int i2) {
        c currentVideoItemView = this.bLk.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            currentVideoItemView.stopPlayback();
            currentVideoItemView.setVideoPlayState(4);
            return true;
        }
        return true;
    }
}
