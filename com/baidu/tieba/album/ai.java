package com.baidu.tieba.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ai implements aa {
    final /* synthetic */ ah aqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.aqf = ahVar;
    }

    @Override // com.baidu.tieba.album.aa
    public boolean onClick(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        if (z) {
            albumActivity2 = this.aqf.aoO;
            return albumActivity2.b(imageFileInfo);
        }
        albumActivity = this.aqf.aoO;
        return albumActivity.c(imageFileInfo);
    }
}
