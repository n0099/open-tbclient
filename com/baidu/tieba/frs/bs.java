package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ bq aFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bq bqVar) {
        this.aFg = bqVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        FrsActivity frsActivity;
        frsActivity = this.aFg.aDc;
        ImageView imageView = new ImageView(frsActivity.getPageContext().getPageActivity());
        imageView.setBackgroundResource(com.baidu.tieba.v.good_threads_tip);
        return imageView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dx() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dy() {
        return 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.aFg.aDc;
        frsActivity2 = this.aFg.aDc;
        return (int) ((frsActivity.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds138) - 0.5f) / frsActivity2.getResources().getDisplayMetrics().density);
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 0;
    }
}
