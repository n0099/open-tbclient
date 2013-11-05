package com.baidu.tieba.forumdetail;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ItemHeaderView f1223a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ItemHeaderView itemHeaderView) {
        this.f1223a = itemHeaderView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        if (eVar != null) {
            headImageView = this.f1223a.b;
            headImageView.setImageBitmap(eVar.f());
            headImageView2 = this.f1223a.b;
            headImageView2.invalidate();
        }
    }
}
