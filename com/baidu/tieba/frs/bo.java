package com.baidu.tieba.frs;

import android.view.ViewStub;
import android.widget.FrameLayout;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements Runnable {
    final /* synthetic */ bm bSc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bm bmVar) {
        this.bSc = bmVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewStub viewStub;
        FrameLayout frameLayout;
        TbImageView tbImageView;
        TbImageView tbImageView2;
        viewStub = this.bSc.bRs;
        if (viewStub != null) {
            frameLayout = this.bSc.bRt;
            frameLayout.setVisibility(0);
            tbImageView = this.bSc.bRv;
            tbImageView.setVisibility(0);
            tbImageView2 = this.bSc.bRu;
            tbImageView2.setVisibility(8);
        }
    }
}
