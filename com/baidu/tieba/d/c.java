package com.baidu.tieba.d;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class c implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ b bJm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bJm = bVar;
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
        a aVar9;
        int i;
        aVar = this.bJm.bJl;
        tbPageContext = aVar.ajh;
        TextView textView = new TextView(tbPageContext.getPageActivity());
        aVar2 = this.bJm.bJl;
        str = aVar2.mMessage;
        textView.setText(str);
        textView.setGravity(17);
        aq.i(textView, w.e.cp_cont_i);
        aVar3 = this.bJm.bJl;
        tbPageContext2 = aVar3.ajh;
        textView.setTextSize(0, tbPageContext2.getResources().getDimensionPixelSize(w.f.fontsize28));
        aVar4 = this.bJm.bJl;
        tbPageContext3 = aVar4.ajh;
        textView.setHeight(tbPageContext3.getResources().getDimensionPixelSize(w.f.ds76));
        aVar5 = this.bJm.bJl;
        tbPageContext4 = aVar5.ajh;
        int dimensionPixelSize = tbPageContext4.getResources().getDimensionPixelSize(w.f.ds24);
        aVar6 = this.bJm.bJl;
        tbPageContext5 = aVar6.ajh;
        int dimensionPixelSize2 = tbPageContext5.getResources().getDimensionPixelSize(w.f.ds24);
        aVar7 = this.bJm.bJl;
        tbPageContext6 = aVar7.ajh;
        int dimensionPixelSize3 = tbPageContext6.getResources().getDimensionPixelSize(w.f.ds24);
        aVar8 = this.bJm.bJl;
        tbPageContext7 = aVar8.ajh;
        textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, tbPageContext7.getResources().getDimensionPixelSize(w.f.ds10));
        textView.setSingleLine(true);
        aVar9 = this.bJm.bJl;
        i = aVar9.bJf;
        aq.j(textView, i);
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int fa() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int fb() {
        return 48;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        a aVar;
        int i;
        aVar = this.bJm.bJl;
        i = aVar.ajo;
        return i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        a aVar;
        int i;
        aVar = this.bJm.bJl;
        i = aVar.mYOffset;
        return i;
    }
}
