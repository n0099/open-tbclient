package com.baidu.tbadk.motu_gallery;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ JigsawAlbumActivity a;
    private final /* synthetic */ x b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(JigsawAlbumActivity jigsawAlbumActivity, x xVar) {
        this.a = jigsawAlbumActivity;
        this.b = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u uVar;
        LinearLayout linearLayout;
        u uVar2;
        uVar = this.a.k;
        uVar.b(this.a, this.b.getUri());
        linearLayout = this.a.v;
        linearLayout.removeView(view);
        TextView textView = this.a.a;
        uVar2 = this.a.k;
        textView.setText(uVar2.e(this.a));
    }
}
