package com.baidu.tbadk.motu_gallery;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ JigsawAlbumActivity acF;
    private final /* synthetic */ x acG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(JigsawAlbumActivity jigsawAlbumActivity, x xVar) {
        this.acF = jigsawAlbumActivity;
        this.acG = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u uVar;
        LinearLayout linearLayout;
        u uVar2;
        uVar = this.acF.acr;
        uVar.d(this.acF.getPageContext().getPageActivity(), this.acG.getUri());
        linearLayout = this.acF.acC;
        linearLayout.removeView(view);
        TextView textView = this.acF.acB;
        uVar2 = this.acF.acr;
        textView.setText(uVar2.ab(this.acF.getPageContext().getPageActivity()));
    }
}
