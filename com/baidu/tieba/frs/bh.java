package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ bf aLR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bf bfVar) {
        this.aLR = bfVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        FrsActivity frsActivity;
        frsActivity = this.aLR.aJT;
        ImageView imageView = new ImageView(frsActivity.getPageContext().getPageActivity());
        imageView.setImageResource(com.baidu.tieba.u.tips_swipe_back);
        return imageView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gT() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gU() {
        return 32;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return 0;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 60;
    }
}
