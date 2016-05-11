package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.b {
    final /* synthetic */ c bwe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar) {
        this.bwe = cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c sg() {
        com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
        cVar.ce(t.f.icon_dot_personal_s);
        cVar.cf(t.f.icon_dot_personal_n);
        cVar.setSpacing(t.e.ds10);
        cVar.setGravity(85);
        cVar.ch(t.e.ds20);
        cVar.cg(t.e.ds16);
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public TbImageView J(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.e sh() {
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        eVar.setHeight(TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds280));
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public View si() {
        return this.bwe.bvl;
    }
}
