package com.baidu.tieba.card;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements QuickVideoView.b {
    final /* synthetic */ r aZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(r rVar) {
        this.aZW = rVar;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        this.aZW.stopPlay();
    }
}
