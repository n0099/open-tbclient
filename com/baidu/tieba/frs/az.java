package com.baidu.tieba.frs;

import android.view.ViewStub;
import android.widget.FrameLayout;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements Runnable {
    final /* synthetic */ ax bAv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ax axVar) {
        this.bAv = axVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewStub viewStub;
        FrameLayout frameLayout;
        TbImageView tbImageView;
        TbImageView tbImageView2;
        viewStub = this.bAv.bzK;
        if (viewStub != null) {
            frameLayout = this.bAv.bzL;
            frameLayout.setVisibility(0);
            tbImageView = this.bAv.bzN;
            tbImageView.setVisibility(0);
            tbImageView2 = this.bAv.bzM;
            tbImageView2.setVisibility(8);
        }
    }
}
