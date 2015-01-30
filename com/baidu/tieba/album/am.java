package com.baidu.tieba.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class am implements com.baidu.tieba.view.e {
    final /* synthetic */ ah ari;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ah ahVar) {
        this.ari = ahVar;
    }

    @Override // com.baidu.tieba.view.e
    public void a(int i, a aVar) {
        n nVar;
        n nVar2;
        boolean z;
        List<ImageFileInfo> list;
        n nVar3;
        n nVar4;
        TextView textView;
        String albumId = aVar.getAlbumId();
        String name = aVar.getName();
        if (!TextUtils.isEmpty(albumId)) {
            nVar = this.ari.apH;
            if (!albumId.equals(nVar.BO())) {
                nVar2 = this.ari.apH;
                List<ImageFileInfo> BR = nVar2.BR();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : BR) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = BR;
                }
                nVar3 = this.ari.apH;
                nVar3.D(list);
                nVar4 = this.ari.apH;
                nVar4.eX(albumId);
                this.ari.setData(list, z);
                textView = this.ari.mTitleText;
                textView.setText(name);
            }
        }
    }
}
