package com.baidu.tieba.d;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class c implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ b bKj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bKj = bVar;
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
        int i;
        a aVar6;
        int i2;
        a aVar7;
        int i3;
        a aVar8;
        int i4;
        a aVar9;
        int i5;
        a aVar10;
        View.OnClickListener onClickListener;
        a aVar11;
        View.OnClickListener onClickListener2;
        aVar = this.bKj.bKi;
        tbPageContext = aVar.ajP;
        TextView textView = new TextView(tbPageContext.getPageActivity());
        aVar2 = this.bKj.bKi;
        str = aVar2.mMessage;
        textView.setText(str);
        textView.setGravity(17);
        as.i(textView, w.e.cp_cont_i);
        aVar3 = this.bKj.bKi;
        tbPageContext2 = aVar3.ajP;
        textView.setTextSize(0, tbPageContext2.getResources().getDimensionPixelSize(w.f.fontsize28));
        aVar4 = this.bKj.bKi;
        tbPageContext3 = aVar4.ajP;
        textView.setHeight(tbPageContext3.getResources().getDimensionPixelSize(w.f.ds76));
        aVar5 = this.bKj.bKi;
        i = aVar5.bKc;
        aVar6 = this.bKj.bKi;
        i2 = aVar6.bKd;
        aVar7 = this.bKj.bKi;
        i3 = aVar7.bKe;
        aVar8 = this.bKj.bKi;
        i4 = aVar8.bKf;
        textView.setPadding(i, i2, i3, i4);
        textView.setSingleLine(true);
        aVar9 = this.bKj.bKi;
        i5 = aVar9.bJX;
        as.j(textView, i5);
        aVar10 = this.bKj.bKi;
        onClickListener = aVar10.bKg;
        if (onClickListener != null) {
            aVar11 = this.bKj.bKi;
            onClickListener2 = aVar11.bKg;
            textView.setOnClickListener(onClickListener2);
        }
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int eZ() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int fa() {
        return 48;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        a aVar;
        int i;
        aVar = this.bKj.bKi;
        i = aVar.ajW;
        return i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        a aVar;
        int i;
        aVar = this.bKj.bKi;
        i = aVar.ajX;
        return i;
    }
}
