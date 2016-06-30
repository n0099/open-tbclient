package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.guide.b;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class bu implements b {
    final /* synthetic */ bt bFJ;
    private final /* synthetic */ String bFK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bt btVar, String str) {
        this.bFJ = btVar;
        this.bFK = str;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        bq bqVar;
        FrsActivity frsActivity;
        bq bqVar2;
        FrsActivity frsActivity2;
        bq bqVar3;
        FrsActivity frsActivity3;
        bq bqVar4;
        FrsActivity frsActivity4;
        bq bqVar5;
        FrsActivity frsActivity5;
        bq bqVar6;
        FrsActivity frsActivity6;
        bq bqVar7;
        FrsActivity frsActivity7;
        bqVar = this.bFJ.bFI;
        frsActivity = bqVar.bET;
        TextView textView = new TextView(frsActivity.getPageContext().getPageActivity());
        textView.setText(this.bFK);
        textView.setGravity(17);
        textView.setSingleLine(true);
        com.baidu.tbadk.core.util.av.j((View) textView, u.d.cp_cont_i);
        bqVar2 = this.bFJ.bFI;
        frsActivity2 = bqVar2.bET;
        textView.setTextSize(0, frsActivity2.getResources().getDimensionPixelSize(u.e.fontsize28));
        bqVar3 = this.bFJ.bFI;
        frsActivity3 = bqVar3.bET;
        textView.setWidth(frsActivity3.getResources().getDimensionPixelSize(u.e.ds618));
        bqVar4 = this.bFJ.bFI;
        frsActivity4 = bqVar4.bET;
        bqVar5 = this.bFJ.bFI;
        frsActivity5 = bqVar5.bET;
        bqVar6 = this.bFJ.bFI;
        frsActivity6 = bqVar6.bET;
        textView.setPadding((int) frsActivity4.getResources().getDimension(u.e.ds4), (int) frsActivity5.getResources().getDimension(u.e.ds10), (int) frsActivity6.getResources().getDimension(u.e.ds4), 0);
        bqVar7 = this.bFJ.bFI;
        frsActivity7 = bqVar7.bET;
        textView.setHeight(frsActivity7.getResources().getDimensionPixelSize(u.e.ds76));
        com.baidu.tbadk.core.util.av.k(textView, u.f.pic_sign_tip);
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int cU() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int cV() {
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
