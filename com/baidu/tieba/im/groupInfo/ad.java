package com.baidu.tieba.im.groupInfo;
/* loaded from: classes.dex */
class ad implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ com.baidu.adp.widget.ImageView.a a;
    final /* synthetic */ PhotoWallView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PhotoWallView photoWallView, com.baidu.adp.widget.ImageView.a aVar) {
        this.b = photoWallView;
        this.a = aVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null) {
            this.a.setBackgroundDrawable(null);
            this.a.setImageBitmap(null);
            eVar.a(this.a);
        }
    }
}
