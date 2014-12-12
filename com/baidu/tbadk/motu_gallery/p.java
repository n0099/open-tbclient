package com.baidu.tbadk.motu_gallery;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private final /* synthetic */ x acG;
    final /* synthetic */ JigsawAlbumListActivity acW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(JigsawAlbumListActivity jigsawAlbumListActivity, x xVar) {
        this.acW = jigsawAlbumListActivity;
        this.acG = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.acW.e(this.acG.getUri());
    }
}
