package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(m mVar) {
        this.a = mVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        HeadImageView headImageView;
        if (bVar != null) {
            headImageView = this.a.x;
            bVar.a(headImageView);
        }
    }
}
