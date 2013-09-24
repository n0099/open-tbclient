package com.baidu.tieba.forumdetail;

import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ItemInfoView f1096a;
    private final /* synthetic */ HeadImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ItemInfoView itemInfoView, HeadImageView headImageView) {
        this.f1096a = itemInfoView;
        this.b = headImageView;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        if (cVar != null) {
            this.b.setImageBitmap(cVar.f());
            this.b.invalidate();
        }
    }
}
