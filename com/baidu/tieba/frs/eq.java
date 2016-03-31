package com.baidu.tieba.frs;

import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class eq implements TbImageView.a {
    final /* synthetic */ em bqE;
    private final /* synthetic */ TbImageView bqF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eq(em emVar, TbImageView tbImageView) {
        this.bqE = emVar;
        this.bqF = tbImageView;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void s(String str, boolean z) {
        if (!z) {
            this.bqF.reset();
            this.bqF.setImageResource(t.f.pic_interview_top);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
