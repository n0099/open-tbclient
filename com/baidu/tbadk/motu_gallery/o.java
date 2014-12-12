package com.baidu.tbadk.motu_gallery;

import android.view.View;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ JigsawAlbumListActivity acW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(JigsawAlbumListActivity jigsawAlbumListActivity) {
        this.acW = jigsawAlbumListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.acW.wm();
    }
}
