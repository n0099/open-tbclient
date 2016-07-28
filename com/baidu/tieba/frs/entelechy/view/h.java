package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements TbImageView.a {
    final /* synthetic */ a bLV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.bLV = aVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void t(String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (z) {
            tbImageView = this.bLV.aUb;
            if (tbImageView != null) {
                tbImageView2 = this.bLV.aUb;
                tbImageView2.setDefaultBgResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
