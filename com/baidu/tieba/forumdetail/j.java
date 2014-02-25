package com.baidu.tieba.forumdetail;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ItemHeaderView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ItemHeaderView itemHeaderView) {
        this.a = itemHeaderView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        if (bVar != null) {
            headImageView = this.a.b;
            headImageView.setImageBitmap(bVar.h());
            headImageView2 = this.a.b;
            headImageView2.invalidate();
        }
    }
}
