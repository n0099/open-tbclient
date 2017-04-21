package com.baidu.tieba.card;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements TbImageView.a {
    final /* synthetic */ x bvq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(x xVar) {
        this.bvq = xVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (z) {
            tbImageView = this.bvq.buS;
            if (tbImageView != null) {
                tbImageView2 = this.bvq.buS;
                tbImageView2.setDefaultBgResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
