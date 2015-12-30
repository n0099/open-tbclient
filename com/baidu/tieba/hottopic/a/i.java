package com.baidu.tieba.hottopic.a;

import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class i implements TbImageView.a {
    final /* synthetic */ h bGi;
    private final /* synthetic */ com.baidu.tieba.hottopic.b.b bGj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, com.baidu.tieba.hottopic.b.b bVar) {
        this.bGi = hVar;
        this.bGj = bVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onComplete(String str, boolean z) {
        if (!z) {
            this.bGj.bIn.setVisibility(8);
        } else {
            this.bGj.bIn.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
        this.bGj.bIn.setVisibility(8);
    }
}
