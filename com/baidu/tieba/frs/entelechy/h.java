package com.baidu.tieba.frs.entelechy;

import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class h implements TbImageView.a {
    final /* synthetic */ d bnY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar) {
        this.bnY = dVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void t(String str, boolean z) {
        if (z) {
            this.bnY.Sq();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
