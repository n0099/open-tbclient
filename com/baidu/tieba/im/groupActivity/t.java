package com.baidu.tieba.im.groupActivity;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.a = rVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        HeadImageView headImageView;
        if (bVar != null) {
            headImageView = this.a.c;
            bVar.a(headImageView);
        }
    }
}
