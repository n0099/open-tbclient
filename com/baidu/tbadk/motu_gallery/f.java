package com.baidu.tbadk.motu_gallery;

import android.view.View;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ JigsawAlbumActivity acF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(JigsawAlbumActivity jigsawAlbumActivity) {
        this.acF = jigsawAlbumActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.acF.finish();
    }
}
