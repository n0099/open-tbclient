package com.baidu.tbadk.motu_gallery;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private final /* synthetic */ x WA;
    final /* synthetic */ JigsawAlbumListActivity WR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(JigsawAlbumListActivity jigsawAlbumListActivity, x xVar) {
        this.WR = jigsawAlbumListActivity;
        this.WA = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.WR.d(this.WA.getUri());
    }
}
