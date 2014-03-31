package com.baidu.tieba.album;

import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
final class aj implements z {
    final /* synthetic */ ah a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.a = ahVar;
    }

    @Override // com.baidu.tieba.album.z
    public final void onClick(int i, ImageFileInfo imageFileInfo) {
        p pVar;
        List<ImageFileInfo> list;
        p pVar2;
        AlbumActivity albumActivity;
        pVar = this.a.b;
        list = this.a.m;
        pVar.a(list);
        pVar2 = this.a.b;
        pVar2.a(i);
        albumActivity = this.a.a;
        albumActivity.e(2);
    }
}
