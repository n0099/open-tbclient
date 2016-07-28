package com.baidu.tieba.frs.entelechy;

import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class i implements TbImageView.a {
    final /* synthetic */ e bJY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.bJY = eVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void t(String str, boolean z) {
        if (z) {
            this.bJY.Ye();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
