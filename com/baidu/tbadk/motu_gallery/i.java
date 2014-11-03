package com.baidu.tbadk.motu_gallery;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    private final /* synthetic */ x WA;
    final /* synthetic */ JigsawAlbumActivity Wz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(JigsawAlbumActivity jigsawAlbumActivity, x xVar) {
        this.Wz = jigsawAlbumActivity;
        this.WA = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u uVar;
        LinearLayout linearLayout;
        u uVar2;
        uVar = this.Wz.Wm;
        uVar.b(this.Wz, this.WA.getUri());
        linearLayout = this.Wz.Ww;
        linearLayout.removeView(view);
        TextView textView = this.Wz.Wv;
        uVar2 = this.Wz.Wm;
        textView.setText(uVar2.E(this.Wz));
    }
}
