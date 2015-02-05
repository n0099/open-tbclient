package com.baidu.tieba.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class am implements com.baidu.tieba.view.e {
    final /* synthetic */ ah arf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ah ahVar) {
        this.arf = ahVar;
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
            nVar = this.arf.apE;
            if (!albumId.equals(nVar.BI())) {
                nVar2 = this.arf.apE;
                List<ImageFileInfo> BL = nVar2.BL();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : BL) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = BL;
                }
                nVar3 = this.arf.apE;
                nVar3.D(list);
                nVar4 = this.arf.apE;
                nVar4.eU(albumId);
                this.arf.setData(list, z);
                textView = this.arf.mTitleText;
                textView.setText(name);
            }
        }
    }
}
