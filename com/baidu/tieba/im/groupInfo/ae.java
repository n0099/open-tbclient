package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.widget.ImageView.BDImageView;
/* loaded from: classes.dex */
class ae implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ PhotoWallView a;
    private final /* synthetic */ BDImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PhotoWallView photoWallView, BDImageView bDImageView) {
        this.a = photoWallView;
        this.b = bDImageView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null) {
            this.b.setBackgroundDrawable(null);
            this.b.setImageBitmap(null);
            bVar.a(this.b);
        }
    }
}
