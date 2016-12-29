package com.baidu.tieba.card;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements TbImageView.a {
    final /* synthetic */ bn bdP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bn bnVar) {
        this.bdP = bnVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (z) {
            tbImageView = this.bdP.bdL;
            if (tbImageView != null) {
                tbImageView2 = this.bdP.bdL;
                tbImageView2.setDefaultBgResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
