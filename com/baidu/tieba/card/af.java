package com.baidu.tieba.card;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements QuickVideoView.b {
    final /* synthetic */ u bvn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(u uVar) {
        this.bvn = uVar;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        this.bvn.stopPlay();
    }
}
