package com.baidu.tieba.forumdetail;

import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
final class n implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ItemInfoView a;
    private final /* synthetic */ HeadImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ItemInfoView itemInfoView, HeadImageView headImageView) {
        this.a = itemInfoView;
        this.b = headImageView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null) {
            this.b.setImageBitmap(bVar.h());
            this.b.invalidate();
        }
    }
}
