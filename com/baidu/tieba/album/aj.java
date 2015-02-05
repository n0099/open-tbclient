package com.baidu.tieba.album;

import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class aj implements y {
    final /* synthetic */ ah arf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.arf = ahVar;
    }

    @Override // com.baidu.tieba.album.y
    public void onClick(int i, ImageFileInfo imageFileInfo) {
        n nVar;
        AlbumActivity albumActivity;
        nVar = this.arf.apE;
        nVar.setCurrentIndex(i);
        albumActivity = this.arf.apJ;
        albumActivity.ek(1);
    }
}
