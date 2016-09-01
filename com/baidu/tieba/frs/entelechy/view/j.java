package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements TbImageView.a {
    final /* synthetic */ a bXm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.bXm = aVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void u(String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (z) {
            tbImageView = this.bXm.aZj;
            if (tbImageView != null) {
                tbImageView2 = this.bXm.aZj;
                tbImageView2.setDefaultBgResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
