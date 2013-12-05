package com.baidu.tieba.im.groupInfo;
/* loaded from: classes.dex */
class ad implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.adp.widget.ImageView.a f1742a;
    final /* synthetic */ PhotoWallView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PhotoWallView photoWallView, com.baidu.adp.widget.ImageView.a aVar) {
        this.b = photoWallView;
        this.f1742a = aVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null) {
            this.f1742a.setBackgroundDrawable(null);
            this.f1742a.setImageBitmap(null);
            eVar.a(this.f1742a);
        }
    }
}
