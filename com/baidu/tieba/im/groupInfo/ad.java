package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.widget.ImageView.BDImageView;
/* loaded from: classes.dex */
class ad implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ BDImageView a;
    final /* synthetic */ PhotoWallView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PhotoWallView photoWallView, BDImageView bDImageView) {
        this.b = photoWallView;
        this.a = bDImageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        if (dVar != null) {
            this.a.setBackgroundDrawable(null);
            this.a.setImageBitmap(null);
            dVar.a(this.a);
        }
    }
}
