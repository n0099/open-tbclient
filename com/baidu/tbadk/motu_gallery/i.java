package com.baidu.tbadk.motu_gallery;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ JigsawAlbumActivity Wv;
    private final /* synthetic */ x Ww;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(JigsawAlbumActivity jigsawAlbumActivity, x xVar) {
        this.Wv = jigsawAlbumActivity;
        this.Ww = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u uVar;
        LinearLayout linearLayout;
        u uVar2;
        uVar = this.Wv.Wi;
        uVar.b(this.Wv, this.Ww.getUri());
        linearLayout = this.Wv.Ws;
        linearLayout.removeView(view);
        TextView textView = this.Wv.Wr;
        uVar2 = this.Wv.Wi;
        textView.setText(uVar2.E(this.Wv));
    }
}
