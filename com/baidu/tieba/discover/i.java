package com.baidu.tieba.discover;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ DiscoverItemView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(DiscoverItemView discoverItemView) {
        this.a = discoverItemView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (aVar != null) {
            tbImageView = this.a.i;
            tbImageView.setImageBitmap(aVar.h());
            tbImageView2 = this.a.i;
            tbImageView2.invalidate();
        }
    }
}
