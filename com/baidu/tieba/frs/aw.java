package com.baidu.tieba.frs;

import android.view.ViewStub;
import android.widget.FrameLayout;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements Runnable {
    final /* synthetic */ av cdV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar) {
        this.cdV = avVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewStub viewStub;
        FrameLayout frameLayout;
        TbImageView tbImageView;
        TbImageView tbImageView2;
        viewStub = this.cdV.cdA;
        if (viewStub != null) {
            frameLayout = this.cdV.cdB;
            frameLayout.setVisibility(0);
            tbImageView = this.cdV.cdD;
            tbImageView.setVisibility(0);
            tbImageView2 = this.cdV.cdC;
            tbImageView2.setVisibility(8);
        }
    }
}
