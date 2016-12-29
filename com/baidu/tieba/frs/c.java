package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class c implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ b bxO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bxO = bVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        a aVar;
        TbPageContext tbPageContext;
        a aVar2;
        String str;
        a aVar3;
        TbPageContext tbPageContext2;
        a aVar4;
        TbPageContext tbPageContext3;
        a aVar5;
        TbPageContext tbPageContext4;
        a aVar6;
        TbPageContext tbPageContext5;
        a aVar7;
        TbPageContext tbPageContext6;
        a aVar8;
        TbPageContext tbPageContext7;
        aVar = this.bxO.bxN;
        tbPageContext = aVar.GO;
        TextView textView = new TextView(tbPageContext.getPageActivity());
        aVar2 = this.bxO.bxN;
        str = aVar2.mMessage;
        textView.setText(str);
        textView.setGravity(17);
        com.baidu.tbadk.core.util.ar.j((View) textView, r.d.cp_cont_i);
        aVar3 = this.bxO.bxN;
        tbPageContext2 = aVar3.GO;
        textView.setTextSize(0, tbPageContext2.getResources().getDimensionPixelSize(r.e.fontsize28));
        aVar4 = this.bxO.bxN;
        tbPageContext3 = aVar4.GO;
        textView.setHeight(tbPageContext3.getResources().getDimensionPixelSize(r.e.ds76));
        aVar5 = this.bxO.bxN;
        tbPageContext4 = aVar5.GO;
        int dimensionPixelSize = tbPageContext4.getResources().getDimensionPixelSize(r.e.ds24);
        aVar6 = this.bxO.bxN;
        tbPageContext5 = aVar6.GO;
        int dimensionPixelSize2 = tbPageContext5.getResources().getDimensionPixelSize(r.e.ds24);
        aVar7 = this.bxO.bxN;
        tbPageContext6 = aVar7.GO;
        int dimensionPixelSize3 = tbPageContext6.getResources().getDimensionPixelSize(r.e.ds24);
        aVar8 = this.bxO.bxN;
        tbPageContext7 = aVar8.GO;
        textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, tbPageContext7.getResources().getDimensionPixelSize(r.e.ds10));
        textView.setSingleLine(true);
        com.baidu.tbadk.core.util.ar.k(textView, r.f.pic_sign_tip);
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
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 0;
    }
}
