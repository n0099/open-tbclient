package com.baidu.tieba.frs.entelechy;

import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class h implements TbImageView.a {
    final /* synthetic */ d bIu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar) {
        this.bIu = dVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void t(String str, boolean z) {
        if (z) {
            this.bIu.XL();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
