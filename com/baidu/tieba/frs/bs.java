package com.baidu.tieba.frs;

import android.view.ViewStub;
import android.widget.FrameLayout;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements Runnable {
    final /* synthetic */ bq bGW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bq bqVar) {
        this.bGW = bqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewStub viewStub;
        FrameLayout frameLayout;
        TbImageView tbImageView;
        TbImageView tbImageView2;
        viewStub = this.bGW.bGk;
        if (viewStub != null) {
            frameLayout = this.bGW.bGl;
            frameLayout.setVisibility(0);
            tbImageView = this.bGW.bGn;
            tbImageView.setVisibility(0);
            tbImageView2 = this.bGW.bGm;
            tbImageView2.setVisibility(8);
        }
    }
}
