package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ bf aMc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bf bfVar) {
        this.aMc = bfVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        FrsActivity frsActivity;
        frsActivity = this.aMc.aKd;
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
