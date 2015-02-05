package com.baidu.tieba.album;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ak implements x {
    final /* synthetic */ ah arf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ah ahVar) {
        this.arf = ahVar;
    }

    @Override // com.baidu.tieba.album.x
    public void onClick(int i, ImageFileInfo imageFileInfo) {
        n nVar;
        n nVar2;
        n nVar3;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        nVar = this.arf.apE;
        int maxImagesAllowed = nVar.getMaxImagesAllowed();
        nVar2 = this.arf.apE;
        if (nVar2.size() < maxImagesAllowed) {
            nVar3 = this.arf.apE;
            String BM = nVar3.BM();
            if (!TextUtils.isEmpty(BM)) {
                albumActivity2 = this.arf.apJ;
                bb.a(albumActivity2.getPageContext(), BM);
                return;
            }
            albumActivity = this.arf.apJ;
            bb.a(albumActivity.getPageContext());
            return;
        }
        this.arf.showToast(String.format(this.arf.getPageContext().getString(com.baidu.tieba.z.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
    }
}
