package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.guide.b;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class bq implements b {
    final /* synthetic */ bp bSd;
    private final /* synthetic */ String bSe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar, String str) {
        this.bSd = bpVar;
        this.bSe = str;
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
        bmVar = this.bSd.bSc;
        frsActivity = bmVar.bRp;
        TextView textView = new TextView(frsActivity.getPageContext().getPageActivity());
        textView.setText(this.bSe);
        textView.setGravity(17);
        textView.setSingleLine(true);
        com.baidu.tbadk.core.util.av.j((View) textView, t.d.cp_cont_i);
        bmVar2 = this.bSd.bSc;
        frsActivity2 = bmVar2.bRp;
        textView.setTextSize(0, frsActivity2.getResources().getDimensionPixelSize(t.e.fontsize28));
        bmVar3 = this.bSd.bSc;
        frsActivity3 = bmVar3.bRp;
        textView.setWidth(frsActivity3.getResources().getDimensionPixelSize(t.e.ds618));
        bmVar4 = this.bSd.bSc;
        frsActivity4 = bmVar4.bRp;
        bmVar5 = this.bSd.bSc;
        frsActivity5 = bmVar5.bRp;
        bmVar6 = this.bSd.bSc;
        frsActivity6 = bmVar6.bRp;
        textView.setPadding((int) frsActivity4.getResources().getDimension(t.e.ds4), (int) frsActivity5.getResources().getDimension(t.e.ds10), (int) frsActivity6.getResources().getDimension(t.e.ds4), 0);
        bmVar7 = this.bSd.bSc;
        frsActivity7 = bmVar7.bRp;
        textView.setHeight(frsActivity7.getResources().getDimensionPixelSize(t.e.ds76));
        com.baidu.tbadk.core.util.av.k(textView, t.f.pic_sign_tip);
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
