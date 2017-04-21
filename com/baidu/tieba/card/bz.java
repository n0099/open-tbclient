package com.baidu.tieba.card;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements TbImageView.a {
    final /* synthetic */ br bwI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(br brVar) {
        this.bwI = brVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (z) {
            tbImageView = this.bwI.bwF;
            if (tbImageView != null) {
                tbImageView2 = this.bwI.bwF;
                tbImageView2.setDefaultBgResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
