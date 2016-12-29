package com.baidu.tieba.frs.entelechy;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements TbImageView.a {
    final /* synthetic */ j bEc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.bEc = jVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        if (z) {
            this.bEc.YJ();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
