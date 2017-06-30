package com.baidu.tieba.card;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements TbImageView.a {
    final /* synthetic */ bu bDl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(bu buVar) {
        this.bDl = buVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void t(String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (z) {
            tbImageView = this.bDl.bDi;
            if (tbImageView != null) {
                tbImageView2 = this.bDl.bDi;
                tbImageView2.setDefaultBgResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
