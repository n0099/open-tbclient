package com.baidu.tieba.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class aj implements y {
    final /* synthetic */ ah ari;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.ari = ahVar;
    }

    @Override // com.baidu.tieba.album.y
    public void onClick(int i, ImageFileInfo imageFileInfo) {
        n nVar;
        AlbumActivity albumActivity;
        nVar = this.ari.apH;
        nVar.setCurrentIndex(i);
        albumActivity = this.ari.apM;
        albumActivity.ek(1);
    }
}
