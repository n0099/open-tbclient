package com.baidu.tieba.card.a;

import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class b implements TbImageView.a {
    final /* synthetic */ a bwW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bwW = aVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (z) {
            tbImageView = this.bwW.aTz;
            if (tbImageView != null) {
                tbImageView2 = this.bwW.aTz;
                tbImageView2.setDefaultBgResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
