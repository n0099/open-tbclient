package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.core.flow.b {
    final /* synthetic */ b bwr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar) {
        this.bwr = bVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c uB() {
        com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
        cVar.ct(t.f.icon_dot_personal_s);
        cVar.cu(t.f.icon_dot_personal_n);
        cVar.setSpacing(t.e.ds10);
        cVar.setGravity(85);
        cVar.cw(t.e.ds20);
        cVar.cv(t.e.ds16);
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public TbImageView K(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.e uC() {
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        eVar.setHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds280));
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public View uD() {
        return this.bwr.bvw;
    }
}
