package com.baidu.tieba.forumdetail;

import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class n implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ HeadImageView a;
    final /* synthetic */ ItemInfoView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ItemInfoView itemInfoView, HeadImageView headImageView) {
        this.b = itemInfoView;
        this.a = headImageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null) {
            this.a.setImageBitmap(eVar.f());
            this.a.invalidate();
        }
    }
}
