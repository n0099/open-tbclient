package com.baidu.tieba.discover;

import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ DiscoverItemView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(DiscoverItemView discoverItemView) {
        this.a = discoverItemView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        if (bVar != null) {
            headImageView = this.a.i;
            headImageView.setImageBitmap(bVar.h());
            headImageView2 = this.a.i;
            headImageView2.invalidate();
        }
    }
}
