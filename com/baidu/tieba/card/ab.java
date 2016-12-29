package com.baidu.tieba.card;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements TbImageView.a {
    final /* synthetic */ t bcw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(t tVar) {
        this.bcw = tVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (z) {
            tbImageView = this.bcw.bcg;
            if (tbImageView != null) {
                tbImageView2 = this.bcw.bcg;
                tbImageView2.setDefaultBgResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
