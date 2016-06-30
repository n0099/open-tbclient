package com.baidu.tieba.frs;

import android.view.ViewStub;
import android.widget.FrameLayout;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements Runnable {
    final /* synthetic */ bq bFI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bq bqVar) {
        this.bFI = bqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewStub viewStub;
        FrameLayout frameLayout;
        TbImageView tbImageView;
        TbImageView tbImageView2;
        viewStub = this.bFI.bEW;
        if (viewStub != null) {
            frameLayout = this.bFI.bEX;
            frameLayout.setVisibility(0);
            tbImageView = this.bFI.bEZ;
            tbImageView.setVisibility(0);
            tbImageView2 = this.bFI.bEY;
            tbImageView2.setVisibility(8);
        }
    }
}
