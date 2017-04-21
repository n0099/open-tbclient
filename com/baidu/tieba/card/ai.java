package com.baidu.tieba.card;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements QuickVideoView.b {
    final /* synthetic */ x bvq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(x xVar) {
        this.bvq = xVar;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        this.bvq.stopPlay();
    }
}
