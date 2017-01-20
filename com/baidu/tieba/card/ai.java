package com.baidu.tieba.card;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements QuickVideoView.b {
    final /* synthetic */ x bml;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(x xVar) {
        this.bml = xVar;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        this.bml.stopPlay();
    }
}
