package com.baidu.tieba.album;

import com.baidu.tieba.img.ImageFileInfo;
/* loaded from: classes.dex */
final class ai implements aa {
    final /* synthetic */ ah a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.a = ahVar;
    }

    @Override // com.baidu.tieba.album.aa
    public final boolean onClick(int i, ImageFileInfo imageFileInfo, boolean z) {
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
