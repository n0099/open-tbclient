package com.baidu.tieba.frs.headvideo;

import com.baidu.tieba.play.v;
/* loaded from: classes.dex */
class r implements v.b {
    final /* synthetic */ ForumHeadVideoView bRD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ForumHeadVideoView forumHeadVideoView) {
        this.bRD = forumHeadVideoView;
    }

    @Override // com.baidu.tieba.play.v.b
    public boolean onError(v vVar, int i, int i2) {
        c currentVideoItemView = this.bRD.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            currentVideoItemView.stopPlayback();
            currentVideoItemView.setVideoPlayState(4);
            return true;
        }
        return true;
    }
}
