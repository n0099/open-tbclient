package com.baidu.tieba.im.groupInfo;

import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class aj implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ PhotoWallView a;
    private final /* synthetic */ TbImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PhotoWallView photoWallView, TbImageView tbImageView) {
        this.a = photoWallView;
        this.b = tbImageView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null) {
            this.b.setBackgroundDrawable(null);
            this.b.setImageBitmap(null);
            aVar.a(this.b);
        }
    }
}
