package com.baidu.tieba.forumdetail;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ ItemHeaderView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ItemHeaderView itemHeaderView) {
        this.a = itemHeaderView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        if (eVar != null) {
            headImageView = this.a.b;
            headImageView.setImageBitmap(eVar.f());
            headImageView2 = this.a.b;
            headImageView2.invalidate();
        }
    }
}
