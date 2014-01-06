package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ HeadImageView a;
    final /* synthetic */ m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(m mVar, HeadImageView headImageView) {
        this.b = mVar;
        this.a = headImageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        if (dVar != null) {
            dVar.a(this.a);
        }
    }
}
