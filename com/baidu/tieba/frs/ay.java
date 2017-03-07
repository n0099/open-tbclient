package com.baidu.tieba.frs;

import android.view.ViewStub;
import android.widget.FrameLayout;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements Runnable {
    final /* synthetic */ ax bOZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar) {
        this.bOZ = axVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewStub viewStub;
        FrameLayout frameLayout;
        TbImageView tbImageView;
        TbImageView tbImageView2;
        viewStub = this.bOZ.bOt;
        if (viewStub != null) {
            frameLayout = this.bOZ.bOu;
            frameLayout.setVisibility(0);
            tbImageView = this.bOZ.bOw;
            tbImageView.setVisibility(0);
            tbImageView2 = this.bOZ.bOv;
            tbImageView2.setVisibility(8);
        }
    }
}
