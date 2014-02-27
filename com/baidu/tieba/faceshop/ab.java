package com.baidu.tieba.faceshop;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ab implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar) {
        this.a = xVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        TbImageView tbImageView3;
        if (bVar != null) {
            tbImageView2 = this.a.H;
            tbImageView2.setVisibility(0);
            tbImageView3 = this.a.H;
            tbImageView3.invalidate();
            return;
        }
        tbImageView = this.a.H;
        tbImageView.setVisibility(8);
    }
}
