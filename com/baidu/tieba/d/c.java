package com.baidu.tieba.d;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class c implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ b bDv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bDv = bVar;
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
        aVar = this.bDv.bDu;
        tbPageContext = aVar.ajU;
        TextView textView = new TextView(tbPageContext.getPageActivity());
        aVar2 = this.bDv.bDu;
        str = aVar2.mMessage;
        textView.setText(str);
        textView.setGravity(17);
        aq.i(textView, w.e.cp_cont_i);
        aVar3 = this.bDv.bDu;
        tbPageContext2 = aVar3.ajU;
        textView.setTextSize(0, tbPageContext2.getResources().getDimensionPixelSize(w.f.fontsize28));
        aVar4 = this.bDv.bDu;
        tbPageContext3 = aVar4.ajU;
        textView.setHeight(tbPageContext3.getResources().getDimensionPixelSize(w.f.ds76));
        aVar5 = this.bDv.bDu;
        tbPageContext4 = aVar5.ajU;
        int dimensionPixelSize = tbPageContext4.getResources().getDimensionPixelSize(w.f.ds24);
        aVar6 = this.bDv.bDu;
        tbPageContext5 = aVar6.ajU;
        int dimensionPixelSize2 = tbPageContext5.getResources().getDimensionPixelSize(w.f.ds24);
        aVar7 = this.bDv.bDu;
        tbPageContext6 = aVar7.ajU;
        int dimensionPixelSize3 = tbPageContext6.getResources().getDimensionPixelSize(w.f.ds24);
        aVar8 = this.bDv.bDu;
        tbPageContext7 = aVar8.ajU;
        textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, tbPageContext7.getResources().getDimensionPixelSize(w.f.ds10));
        textView.setSingleLine(true);
        aVar9 = this.bDv.bDu;
        i = aVar9.bDo;
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
        aVar = this.bDv.bDu;
        i = aVar.akb;
        return i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        a aVar;
        int i;
        aVar = this.bDv.bDu;
        i = aVar.mYOffset;
        return i;
    }
}
