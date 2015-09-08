package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.core.flow.b {
    final /* synthetic */ a bdi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.bdi = aVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c tg() {
        com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
        cVar.setDrawableId(i.e.icon_dot_personal_s);
        cVar.bX(i.e.icon_dot_personal_n);
        cVar.setSpacing(i.d.ds10);
        cVar.setGravity(85);
        cVar.bZ(i.d.ds20);
        cVar.bY(i.d.ds16);
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public TbImageView X(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.e th() {
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        eVar.setHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds280));
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public View ti() {
        return this.bdi.bcw;
    }
}
