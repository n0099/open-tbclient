package com.baidu.tbadk.motu_gallery;

import android.view.View;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ JigsawAlbumListActivity adu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(JigsawAlbumListActivity jigsawAlbumListActivity) {
        this.adu = jigsawAlbumListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.adu.finish();
    }
}
