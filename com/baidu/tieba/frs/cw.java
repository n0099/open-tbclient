package com.baidu.tieba.frs;

import android.widget.FrameLayout;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements Runnable {
    final /* synthetic */ cs bpe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(cs csVar) {
        this.bpe = csVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        TbImageView tbImageView;
        TbImageView tbImageView2;
        frameLayout = this.bpe.boy;
        frameLayout.setVisibility(0);
        tbImageView = this.bpe.boA;
        tbImageView.setVisibility(0);
        tbImageView2 = this.bpe.boz;
        tbImageView2.setVisibility(8);
    }
}
