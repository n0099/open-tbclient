package com.baidu.tieba.card;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements TbImageView.a {
    final /* synthetic */ br bbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(br brVar) {
        this.bbb = brVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void u(String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (z) {
            tbImageView = this.bbb.baX;
            if (tbImageView != null) {
                tbImageView2 = this.bbb.baX;
                tbImageView2.setDefaultBgResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
