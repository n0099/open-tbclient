package com.baidu.tieba.forumdetail;

import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class n implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ItemInfoView a;
    private final /* synthetic */ HeadImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ItemInfoView itemInfoView, HeadImageView headImageView) {
        this.a = itemInfoView;
        this.b = headImageView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null) {
            this.b.setImageBitmap(aVar.h());
            this.b.invalidate();
        }
    }
}
