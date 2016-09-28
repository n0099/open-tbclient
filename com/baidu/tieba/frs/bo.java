package com.baidu.tieba.frs;

import android.view.ViewStub;
import android.widget.FrameLayout;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements Runnable {
    final /* synthetic */ bm bRV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bm bmVar) {
        this.bRV = bmVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewStub viewStub;
        FrameLayout frameLayout;
        TbImageView tbImageView;
        TbImageView tbImageView2;
        viewStub = this.bRV.bRl;
        if (viewStub != null) {
            frameLayout = this.bRV.bRm;
            frameLayout.setVisibility(0);
            tbImageView = this.bRV.bRo;
            tbImageView.setVisibility(0);
            tbImageView2 = this.bRV.bRn;
            tbImageView2.setVisibility(8);
        }
    }
}
