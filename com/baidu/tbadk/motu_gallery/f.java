package com.baidu.tbadk.motu_gallery;

import android.view.View;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ JigsawAlbumActivity Wz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(JigsawAlbumActivity jigsawAlbumActivity) {
        this.Wz = jigsawAlbumActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Wz.finish();
    }
}
