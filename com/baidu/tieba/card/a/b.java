package com.baidu.tieba.card.a;

import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class b implements TbImageView.a {
    final /* synthetic */ a bCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bCT = aVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void s(String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (z) {
            tbImageView = this.bCT.bCF;
            if (tbImageView != null) {
                tbImageView2 = this.bCT.bCF;
                tbImageView2.setDefaultBgResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
