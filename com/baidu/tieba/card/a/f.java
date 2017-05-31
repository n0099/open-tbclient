package com.baidu.tieba.card.a;

import com.baidu.tieba.play.QuickVideoView;
/* loaded from: classes.dex */
class f implements QuickVideoView.b {
    final /* synthetic */ a bCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.bCT = aVar;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.b
    public void onSurfaceDestroyed() {
        this.bCT.Uz();
    }
}
