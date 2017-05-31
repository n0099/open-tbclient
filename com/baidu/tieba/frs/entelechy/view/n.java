package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements QuickVideoView.b {
    final /* synthetic */ a bZs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a aVar) {
        this.bZs = aVar;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        this.bZs.stopPlay();
    }
}
