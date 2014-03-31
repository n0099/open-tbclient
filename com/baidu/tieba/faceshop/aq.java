package com.baidu.tieba.faceshop;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aq implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ am a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(am amVar) {
        this.a = amVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        TbImageView tbImageView3;
        if (bVar != null) {
            tbImageView2 = this.a.I;
            tbImageView2.setVisibility(0);
            tbImageView3 = this.a.I;
            tbImageView3.invalidate();
            return;
        }
        tbImageView = this.a.I;
        tbImageView.setVisibility(8);
    }
}
