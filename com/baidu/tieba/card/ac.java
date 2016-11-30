package com.baidu.tieba.card;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements QuickVideoView.b {
    final /* synthetic */ r bde;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(r rVar) {
        this.bde = rVar;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        this.bde.stopPlay();
    }
}
