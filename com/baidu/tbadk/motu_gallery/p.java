package com.baidu.tbadk.motu_gallery;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private final /* synthetic */ w ada;
    final /* synthetic */ JigsawAlbumListActivity adr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(JigsawAlbumListActivity jigsawAlbumListActivity, w wVar) {
        this.adr = jigsawAlbumListActivity;
        this.ada = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.adr.e(this.ada.getUri());
    }
}
