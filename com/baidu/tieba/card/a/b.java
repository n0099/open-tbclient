package com.baidu.tieba.card.a;

import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class b implements TbImageView.a {
    final /* synthetic */ a bwY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bwY = aVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (z) {
            tbImageView = this.bwY.aTe;
            if (tbImageView != null) {
                tbImageView2 = this.bwY.aTe;
                tbImageView2.setDefaultBgResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
