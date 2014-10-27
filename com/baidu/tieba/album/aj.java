package com.baidu.tieba.album;

import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
class aj implements z {
    final /* synthetic */ ah aiK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.aiK = ahVar;
    }

    @Override // com.baidu.tieba.album.z
    public void onClick(int i, ImageFileInfo imageFileInfo) {
        p pVar;
        List<ImageFileInfo> list;
        p pVar2;
        AlbumActivity albumActivity;
        pVar = this.aiK.ahk;
        list = this.aiK.Wx;
        pVar.y(list);
        pVar2 = this.aiK.ahk;
        pVar2.dP(i);
        albumActivity = this.aiK.ahq;
        albumActivity.dK(2);
    }
}
