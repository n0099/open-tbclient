package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.b {
    final /* synthetic */ c bTP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar) {
        this.bTP = cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c sf() {
        com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
        cVar.ce(u.f.icon_dot_personal_s);
        cVar.cf(u.f.icon_dot_personal_n);
        cVar.setSpacing(u.e.ds10);
        cVar.setGravity(85);
        cVar.ch(u.e.ds20);
        cVar.cg(u.e.ds16);
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public TbImageView I(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.e sg() {
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        eVar.setHeight(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds280));
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public View sh() {
        return this.bTP.bSS;
    }
}
