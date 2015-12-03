package com.baidu.tieba.hottopic.a;

import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class i implements TbImageView.a {
    final /* synthetic */ h bCE;
    private final /* synthetic */ com.baidu.tieba.hottopic.b.b bCF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, com.baidu.tieba.hottopic.b.b bVar) {
        this.bCE = hVar;
        this.bCF = bVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onComplete(String str, boolean z) {
        if (!z) {
            this.bCF.bEJ.setVisibility(8);
        } else {
            this.bCF.bEJ.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
        this.bCF.bEJ.setVisibility(8);
    }
}
