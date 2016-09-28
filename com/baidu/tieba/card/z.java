package com.baidu.tieba.card;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements TbImageView.a {
    final /* synthetic */ r aZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(r rVar) {
        this.aZW = rVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (z) {
            tbImageView = this.aZW.aZE;
            if (tbImageView != null) {
                tbImageView2 = this.aZW.aZE;
                tbImageView2.setDefaultBgResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
