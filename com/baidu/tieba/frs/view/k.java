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
    final /* synthetic */ c cgf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar) {
        this.cgf = cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c ub() {
        com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
        cVar.cs(w.g.icon_dot_personal_s);
        cVar.ct(w.g.icon_dot_personal_n);
        cVar.setSpacing(w.f.ds10);
        cVar.setGravity(85);
        cVar.cv(w.f.ds20);
        cVar.cu(w.f.ds16);
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public TbImageView as(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.e uc() {
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        eVar.setHeight(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds280));
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public View ud() {
        return this.cgf.cfh;
    }
}
