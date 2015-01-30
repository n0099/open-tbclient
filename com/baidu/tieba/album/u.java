package com.baidu.tieba.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t aqH;
    private final /* synthetic */ ImageFileInfo aqI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImageFileInfo imageFileInfo) {
        this.aqH = tVar;
        this.aqI = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.aqH.apM;
        albumActivity.c(this.aqI);
        albumActivity2 = this.aqH.apM;
        albumActivity2.c(this.aqI, false);
        albumActivity3 = this.aqH.apM;
        albumActivity3.d(this.aqI, false);
    }
}
