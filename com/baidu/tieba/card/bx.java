package com.baidu.tieba.card;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements TbImageView.a {
    final /* synthetic */ bp bwH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bp bpVar) {
        this.bwH = bpVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (z) {
            tbImageView = this.bwH.bwE;
            if (tbImageView != null) {
                tbImageView2 = this.bwH.bwE;
                tbImageView2.setDefaultBgResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
