package com.baidu.tieba.frs.entelechy;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements TbImageView.a {
    final /* synthetic */ j bYo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.bYo = jVar;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        if (z) {
            this.bYo.aeq();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
