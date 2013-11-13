package com.baidu.tieba.forumdetail;

import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class n implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HeadImageView f1285a;
    final /* synthetic */ ItemInfoView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ItemInfoView itemInfoView, HeadImageView headImageView) {
        this.b = itemInfoView;
        this.f1285a = headImageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null) {
            this.f1285a.setImageBitmap(eVar.f());
            this.f1285a.invalidate();
        }
    }
}
