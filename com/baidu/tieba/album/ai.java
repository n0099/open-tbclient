package com.baidu.tieba.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ai implements z {
    final /* synthetic */ ah arf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.arf = ahVar;
    }

    @Override // com.baidu.tieba.album.z
    public boolean onClick(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        if (z) {
            albumActivity2 = this.arf.apJ;
            return albumActivity2.b(imageFileInfo);
        }
        albumActivity = this.arf.apJ;
        return albumActivity.c(imageFileInfo);
    }
}
