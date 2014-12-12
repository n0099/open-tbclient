package com.baidu.tieba.album;

import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
class aj implements z {
    final /* synthetic */ ah aqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.aqf = ahVar;
    }

    @Override // com.baidu.tieba.album.z
    public void onClick(int i, ImageFileInfo imageFileInfo) {
        p pVar;
        List<ImageFileInfo> list;
        p pVar2;
        AlbumActivity albumActivity;
        pVar = this.aqf.aoJ;
        list = this.aqf.mList;
        pVar.D(list);
        pVar2 = this.aqf.aoJ;
        pVar2.setCurrentIndex(i);
        albumActivity = this.aqf.aoO;
        albumActivity.ee(2);
    }
}
