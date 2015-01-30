package com.baidu.tbadk.motu_gallery;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private final /* synthetic */ w ade;
    final /* synthetic */ JigsawAlbumListActivity adu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(JigsawAlbumListActivity jigsawAlbumListActivity, w wVar) {
        this.adu = jigsawAlbumListActivity;
        this.ade = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.adu.e(this.ade.getUri());
    }
}
