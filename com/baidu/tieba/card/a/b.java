package com.baidu.tieba.card.a;

import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class b implements TbImageView.a {
    final /* synthetic */ a bDM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bDM = aVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void t(String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (z) {
            tbImageView = this.bDM.bDy;
            if (tbImageView != null) {
                tbImageView2 = this.bDM.bDy;
                tbImageView2.setDefaultBgResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
