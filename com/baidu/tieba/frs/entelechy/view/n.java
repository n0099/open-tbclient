package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements QuickVideoView.b {
    final /* synthetic */ a bTA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a aVar) {
        this.bTA = aVar;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        this.bTA.stopPlay();
    }
}
