package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements TbImageView.a {
    final /* synthetic */ a bKn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.bKn = aVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void t(String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (z) {
            tbImageView = this.bKn.aTf;
            if (tbImageView != null) {
                tbImageView2 = this.bKn.aTf;
                tbImageView2.setDefaultBgResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
