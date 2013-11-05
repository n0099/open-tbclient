package com.baidu.tieba.forumdetail;

import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class p implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HeadImageView f1228a;
    final /* synthetic */ ItemInfoView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ItemInfoView itemInfoView, HeadImageView headImageView) {
        this.b = itemInfoView;
        this.f1228a = headImageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null) {
            this.f1228a.setImageBitmap(eVar.f());
            this.f1228a.invalidate();
        }
    }
}
