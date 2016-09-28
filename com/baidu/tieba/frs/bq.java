package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.guide.b;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class bq implements b {
    final /* synthetic */ bp bRW;
    private final /* synthetic */ String bRX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar, String str) {
        this.bRW = bpVar;
        this.bRX = str;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        bm bmVar;
        FrsActivity frsActivity;
        bm bmVar2;
        FrsActivity frsActivity2;
        bm bmVar3;
        FrsActivity frsActivity3;
        bm bmVar4;
        FrsActivity frsActivity4;
        bm bmVar5;
        FrsActivity frsActivity5;
        bm bmVar6;
        FrsActivity frsActivity6;
        bm bmVar7;
        FrsActivity frsActivity7;
        bmVar = this.bRW.bRV;
        frsActivity = bmVar.bRi;
        TextView textView = new TextView(frsActivity.getPageContext().getPageActivity());
        textView.setText(this.bRX);
        textView.setGravity(17);
        textView.setSingleLine(true);
        com.baidu.tbadk.core.util.av.j((View) textView, r.d.cp_cont_i);
        bmVar2 = this.bRW.bRV;
        frsActivity2 = bmVar2.bRi;
        textView.setTextSize(0, frsActivity2.getResources().getDimensionPixelSize(r.e.fontsize28));
        bmVar3 = this.bRW.bRV;
        frsActivity3 = bmVar3.bRi;
        textView.setWidth(frsActivity3.getResources().getDimensionPixelSize(r.e.ds618));
        bmVar4 = this.bRW.bRV;
        frsActivity4 = bmVar4.bRi;
        bmVar5 = this.bRW.bRV;
        frsActivity5 = bmVar5.bRi;
        bmVar6 = this.bRW.bRV;
        frsActivity6 = bmVar6.bRi;
        textView.setPadding((int) frsActivity4.getResources().getDimension(r.e.ds4), (int) frsActivity5.getResources().getDimension(r.e.ds10), (int) frsActivity6.getResources().getDimension(r.e.ds4), 0);
        bmVar7 = this.bRW.bRV;
        frsActivity7 = bmVar7.bRi;
        textView.setHeight(frsActivity7.getResources().getDimensionPixelSize(r.e.ds76));
        com.baidu.tbadk.core.util.av.k(textView, r.f.pic_sign_tip);
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dO() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dP() {
        return 48;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return -1;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 4;
    }
}
