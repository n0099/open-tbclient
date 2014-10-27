package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ bu aDt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(bu buVar) {
        this.aDt = buVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        FrsActivity frsActivity;
        frsActivity = this.aDt.aBp;
        ImageView imageView = new ImageView(frsActivity);
        imageView.setBackgroundResource(com.baidu.tieba.u.good_threads_tip);
        return imageView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dy() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dz() {
        return 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.aDt.aBp;
        frsActivity2 = this.aDt.aBp;
        return (int) ((frsActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds138) - 0.5f) / frsActivity2.getResources().getDisplayMetrics().density);
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 0;
    }
}
