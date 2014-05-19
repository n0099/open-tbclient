package com.baidu.tieba.faceshop;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ap apVar) {
        this.a = apVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        TbImageView tbImageView3;
        if (aVar != null) {
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
