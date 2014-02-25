package com.baidu.tieba.album;

import com.baidu.tieba.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
class ai implements y {
    final /* synthetic */ ag a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.a = agVar;
    }

    @Override // com.baidu.tieba.album.y
    public void onClick(int i, ImageFileInfo imageFileInfo) {
        p pVar;
        List<ImageFileInfo> list;
        p pVar2;
        AlbumActivity albumActivity;
        pVar = this.a.c;
        list = this.a.n;
        pVar.a(list);
        pVar2 = this.a.c;
        pVar2.a(i);
        albumActivity = this.a.b;
        albumActivity.d(2);
    }
}
