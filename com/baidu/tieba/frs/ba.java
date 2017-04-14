package com.baidu.tieba.frs;

import android.view.ViewStub;
import android.widget.FrameLayout;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements Runnable {
    final /* synthetic */ az bOO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar) {
        this.bOO = azVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewStub viewStub;
        FrameLayout frameLayout;
        TbImageView tbImageView;
        TbImageView tbImageView2;
        viewStub = this.bOO.bOi;
        if (viewStub != null) {
            frameLayout = this.bOO.bOj;
            frameLayout.setVisibility(0);
            tbImageView = this.bOO.bOl;
            tbImageView.setVisibility(0);
            tbImageView2 = this.bOO.bOk;
            tbImageView2.setVisibility(8);
        }
    }
}
