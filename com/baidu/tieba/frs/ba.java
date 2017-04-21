package com.baidu.tieba.frs;

import android.view.ViewStub;
import android.widget.FrameLayout;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements Runnable {
    final /* synthetic */ az bRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar) {
        this.bRf = azVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewStub viewStub;
        FrameLayout frameLayout;
        TbImageView tbImageView;
        TbImageView tbImageView2;
        viewStub = this.bRf.bQz;
        if (viewStub != null) {
            frameLayout = this.bRf.bQA;
            frameLayout.setVisibility(0);
            tbImageView = this.bRf.bQC;
            tbImageView.setVisibility(0);
            tbImageView2 = this.bRf.bQB;
            tbImageView2.setVisibility(8);
        }
    }
}
