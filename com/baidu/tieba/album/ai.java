package com.baidu.tieba.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ai implements z {
    final /* synthetic */ ah ari;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.ari = ahVar;
    }

    @Override // com.baidu.tieba.album.z
    public boolean onClick(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        if (z) {
            albumActivity2 = this.ari.apM;
            return albumActivity2.b(imageFileInfo);
        }
        albumActivity = this.ari.apM;
        return albumActivity.c(imageFileInfo);
    }
}
