package com.baidu.tieba.frs;

import android.view.ViewStub;
import android.widget.FrameLayout;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements Runnable {
    final /* synthetic */ at bPW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(at atVar) {
        this.bPW = atVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewStub viewStub;
        FrameLayout frameLayout;
        TbImageView tbImageView;
        TbImageView tbImageView2;
        viewStub = this.bPW.bPB;
        if (viewStub != null) {
            frameLayout = this.bPW.bPC;
            frameLayout.setVisibility(0);
            tbImageView = this.bPW.bPE;
            tbImageView.setVisibility(0);
            tbImageView2 = this.bPW.bPD;
            tbImageView2.setVisibility(8);
        }
    }
}
