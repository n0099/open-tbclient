package com.baidu.tbadk.motu_gallery;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ JigsawAlbumActivity acZ;
    private final /* synthetic */ w ada;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(JigsawAlbumActivity jigsawAlbumActivity, w wVar) {
        this.acZ = jigsawAlbumActivity;
        this.ada = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u uVar;
        LinearLayout linearLayout;
        u uVar2;
        uVar = this.acZ.acM;
        uVar.d(this.acZ.getPageContext().getPageActivity(), this.ada.getUri());
        linearLayout = this.acZ.acW;
        linearLayout.removeView(view);
        TextView textView = this.acZ.acV;
        uVar2 = this.acZ.acM;
        textView.setText(uVar2.ab(this.acZ.getPageContext().getPageActivity()));
    }
}
