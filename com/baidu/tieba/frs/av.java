package com.baidu.tieba.frs;

import android.view.ViewStub;
import android.widget.FrameLayout;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements Runnable {
    final /* synthetic */ au bVN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar) {
        this.bVN = auVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewStub viewStub;
        FrameLayout frameLayout;
        TbImageView tbImageView;
        TbImageView tbImageView2;
        viewStub = this.bVN.bVr;
        if (viewStub != null) {
            frameLayout = this.bVN.bVs;
            frameLayout.setVisibility(0);
            tbImageView = this.bVN.bVu;
            tbImageView.setVisibility(0);
            tbImageView2 = this.bVN.bVt;
            tbImageView2.setVisibility(8);
        }
    }
}
