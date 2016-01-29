package com.baidu.tieba.frs;

import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class ei implements TbImageView.a {
    final /* synthetic */ ee blm;
    private final /* synthetic */ TbImageView bln;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ei(ee eeVar, TbImageView tbImageView) {
        this.blm = eeVar;
        this.bln = tbImageView;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void t(String str, boolean z) {
        if (!z) {
            this.bln.reset();
            this.bln.setImageResource(t.f.pic_interview_top);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
