package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.b {
    final /* synthetic */ c cfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar) {
        this.cfo = cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c tE() {
        com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
        cVar.cp(w.g.icon_dot_personal_s);
        cVar.cq(w.g.icon_dot_personal_n);
        cVar.setSpacing(w.f.ds10);
        cVar.setGravity(85);
        cVar.cs(w.f.ds20);
        cVar.cr(w.f.ds16);
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public TbImageView aq(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.e tF() {
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        eVar.setHeight(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds280));
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public View tG() {
        return this.cfo.cep;
    }
}
