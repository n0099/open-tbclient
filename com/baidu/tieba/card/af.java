package com.baidu.tieba.card;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements TbImageView.a {
    final /* synthetic */ x bsX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(x xVar) {
        this.bsX = xVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (z) {
            tbImageView = this.bsX.bsz;
            if (tbImageView != null) {
                tbImageView2 = this.bsX.bsz;
                tbImageView2.setDefaultBgResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
