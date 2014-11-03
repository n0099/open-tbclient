package com.baidu.tieba.album;

import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
class aj implements z {
    final /* synthetic */ ah aiT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.aiT = ahVar;
    }

    @Override // com.baidu.tieba.album.z
    public void onClick(int i, ImageFileInfo imageFileInfo) {
        p pVar;
        List<ImageFileInfo> list;
        p pVar2;
        AlbumActivity albumActivity;
        pVar = this.aiT.aht;
        list = this.aiT.WB;
        pVar.y(list);
        pVar2 = this.aiT.aht;
        pVar2.dP(i);
        albumActivity = this.aiT.ahz;
        albumActivity.dK(2);
    }
}
