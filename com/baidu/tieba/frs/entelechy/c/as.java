package com.baidu.tieba.frs.entelechy.c;

import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class as implements TbImageView.a {
    final /* synthetic */ ar bqd;
    private final /* synthetic */ TbImageView bqe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar, TbImageView tbImageView) {
        this.bqd = arVar;
        this.bqe = tbImageView;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void t(String str, boolean z) {
        if (!z) {
            this.bqe.reset();
            this.bqe.setImageResource(t.f.pic_interview_top);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
