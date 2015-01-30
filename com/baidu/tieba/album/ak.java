package com.baidu.tieba.album;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ak implements x {
    final /* synthetic */ ah ari;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ah ahVar) {
        this.ari = ahVar;
    }

    @Override // com.baidu.tieba.album.x
    public void onClick(int i, ImageFileInfo imageFileInfo) {
        n nVar;
        n nVar2;
        n nVar3;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        nVar = this.ari.apH;
        int maxImagesAllowed = nVar.getMaxImagesAllowed();
        nVar2 = this.ari.apH;
        if (nVar2.size() < maxImagesAllowed) {
            nVar3 = this.ari.apH;
            String BS = nVar3.BS();
            if (!TextUtils.isEmpty(BS)) {
                albumActivity2 = this.ari.apM;
                bb.a(albumActivity2.getPageContext(), BS);
                return;
            }
            albumActivity = this.ari.apM;
            bb.a(albumActivity.getPageContext());
            return;
        }
        this.ari.showToast(String.format(this.ari.getPageContext().getString(com.baidu.tieba.z.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
    }
}
