package com.baidu.tieba.forumdetail;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ItemHeaderView f1091a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ItemHeaderView itemHeaderView) {
        this.f1091a = itemHeaderView;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        if (cVar != null) {
            headImageView = this.f1091a.b;
            headImageView.setImageBitmap(cVar.f());
            headImageView2 = this.f1091a.b;
            headImageView2.invalidate();
        }
    }
}
