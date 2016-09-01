package com.baidu.tieba.frs.entelechy;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements TbImageView.a {
    final /* synthetic */ j bVn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.bVn = jVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void u(String str, boolean z) {
        if (z) {
            this.bVn.acR();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
