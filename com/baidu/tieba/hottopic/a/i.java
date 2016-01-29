package com.baidu.tieba.hottopic.a;

import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class i implements TbImageView.a {
    final /* synthetic */ h bJw;
    private final /* synthetic */ com.baidu.tieba.hottopic.b.d bJx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, com.baidu.tieba.hottopic.b.d dVar) {
        this.bJw = hVar;
        this.bJx = dVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void t(String str, boolean z) {
        if (!z) {
            this.bJx.bLY.setVisibility(8);
        } else {
            this.bJx.bLY.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
        this.bJx.bLY.setVisibility(8);
    }
}
