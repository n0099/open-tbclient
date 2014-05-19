package com.baidu.tieba.forumdetail;

import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ItemHeaderView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ItemHeaderView itemHeaderView) {
        this.a = itemHeaderView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        if (aVar != null) {
            headImageView = this.a.b;
            headImageView.setImageBitmap(aVar.h());
            headImageView2 = this.a.b;
            headImageView2.invalidate();
        }
    }
}
