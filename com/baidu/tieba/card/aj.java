package com.baidu.tieba.card;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements QuickVideoView.b {
    final /* synthetic */ y bBb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(y yVar) {
        this.bBb = yVar;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        this.bBb.stopPlay();
    }
}
