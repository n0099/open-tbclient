package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.b {
    final /* synthetic */ c bRo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar) {
        this.bRo = cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c tn() {
        com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
        cVar.cu(r.f.icon_dot_personal_s);
        cVar.cv(r.f.icon_dot_personal_n);
        cVar.setSpacing(r.e.ds10);
        cVar.setGravity(85);
        cVar.cx(r.e.ds20);
        cVar.cw(r.e.ds16);
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public TbImageView Q(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.e to() {
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        eVar.setHeight(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds280));
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public View tp() {
        return this.bRo.bQn;
    }
}
