package com.baidu.tieba.album;

import com.baidu.tieba.img.ImageFileInfo;
/* loaded from: classes.dex */
class ah implements z {
    final /* synthetic */ ag a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.a = agVar;
    }

    @Override // com.baidu.tieba.album.z
    public boolean onClick(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        if (z) {
            albumActivity2 = this.a.b;
            return albumActivity2.a(imageFileInfo);
        }
        albumActivity = this.a.b;
        return albumActivity.b(imageFileInfo);
    }
}
