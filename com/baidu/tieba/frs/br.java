package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ bp aGj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bp bpVar) {
        this.aGj = bpVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        FrsActivity frsActivity;
        frsActivity = this.aGj.aEd;
        ImageView imageView = new ImageView(frsActivity.getPageContext().getPageActivity());
        imageView.setBackgroundResource(com.baidu.tieba.v.good_threads_tip);
        return imageView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dv() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dw() {
        return 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.aGj.aEd;
        frsActivity2 = this.aGj.aEd;
        return (int) ((frsActivity.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds138) - 0.5f) / frsActivity2.getResources().getDisplayMetrics().density);
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 0;
    }
}
