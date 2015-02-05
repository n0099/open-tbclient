package com.baidu.tbadk.motu_gallery;

import android.view.View;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ JigsawAlbumListActivity adr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(JigsawAlbumListActivity jigsawAlbumListActivity) {
        this.adr = jigsawAlbumListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.adr.finish();
    }
}
