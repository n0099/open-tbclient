package com.baidu.tieba.card;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements TbImageView.a {
    final /* synthetic */ bu bCs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(bu buVar) {
        this.bCs = buVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void s(String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (z) {
            tbImageView = this.bCs.bCp;
            if (tbImageView != null) {
                tbImageView2 = this.bCs.bCp;
                tbImageView2.setDefaultBgResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
