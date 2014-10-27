package com.baidu.tbadk.motu_gallery;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ JigsawAlbumListActivity WN;
    private final /* synthetic */ x Ww;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(JigsawAlbumListActivity jigsawAlbumListActivity, x xVar) {
        this.WN = jigsawAlbumListActivity;
        this.Ww = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.WN.d(this.Ww.getUri());
    }
}
