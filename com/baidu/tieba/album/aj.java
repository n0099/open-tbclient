package com.baidu.tieba.album;

import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
class aj implements z {
    final /* synthetic */ ah a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.a = ahVar;
    }

    @Override // com.baidu.tieba.album.z
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
