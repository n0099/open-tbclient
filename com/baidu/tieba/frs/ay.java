package com.baidu.tieba.frs;

import android.view.ViewStub;
import android.widget.FrameLayout;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements Runnable {
    final /* synthetic */ ax bHQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar) {
        this.bHQ = axVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewStub viewStub;
        FrameLayout frameLayout;
        TbImageView tbImageView;
        TbImageView tbImageView2;
        viewStub = this.bHQ.bHk;
        if (viewStub != null) {
            frameLayout = this.bHQ.bHl;
            frameLayout.setVisibility(0);
            tbImageView = this.bHQ.bHn;
            tbImageView.setVisibility(0);
            tbImageView2 = this.bHQ.bHm;
            tbImageView2.setVisibility(8);
        }
    }
}
