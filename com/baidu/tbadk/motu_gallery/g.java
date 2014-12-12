package com.baidu.tbadk.motu_gallery;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ JigsawAlbumActivity acF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(JigsawAlbumActivity jigsawAlbumActivity) {
        this.acF = jigsawAlbumActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.acF.wm();
    }
}
