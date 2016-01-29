package com.baidu.tieba.frs;

import android.widget.FrameLayout;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr implements Runnable {
    final /* synthetic */ cn bjV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(cn cnVar) {
        this.bjV = cnVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        TbImageView tbImageView;
        TbImageView tbImageView2;
        frameLayout = this.bjV.bjo;
        frameLayout.setVisibility(0);
        tbImageView = this.bjV.bjq;
        tbImageView.setVisibility(0);
        tbImageView2 = this.bjV.bjp;
        tbImageView2.setVisibility(8);
    }
}
