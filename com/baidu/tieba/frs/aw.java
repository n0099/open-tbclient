package com.baidu.tieba.frs;

import android.view.ViewStub;
import android.widget.FrameLayout;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements Runnable {
    final /* synthetic */ au bUk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(au auVar) {
        this.bUk = auVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewStub viewStub;
        FrameLayout frameLayout;
        TbImageView tbImageView;
        TbImageView tbImageView2;
        viewStub = this.bUk.bTD;
        if (viewStub != null) {
            frameLayout = this.bUk.bTE;
            frameLayout.setVisibility(0);
            tbImageView = this.bUk.bTG;
            tbImageView.setVisibility(0);
            tbImageView2 = this.bUk.bTF;
            tbImageView2.setVisibility(8);
        }
    }
}
