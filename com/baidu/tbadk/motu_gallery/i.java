package com.baidu.tbadk.motu_gallery;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ JigsawAlbumActivity adc;
    private final /* synthetic */ w ade;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(JigsawAlbumActivity jigsawAlbumActivity, w wVar) {
        this.adc = jigsawAlbumActivity;
        this.ade = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u uVar;
        LinearLayout linearLayout;
        u uVar2;
        uVar = this.adc.acP;
        uVar.d(this.adc.getPageContext().getPageActivity(), this.ade.getUri());
        linearLayout = this.adc.acZ;
        linearLayout.removeView(view);
        TextView textView = this.adc.acY;
        uVar2 = this.adc.acP;
        textView.setText(uVar2.ab(this.adc.getPageContext().getPageActivity()));
    }
}
