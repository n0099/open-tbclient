package com.baidu.tieba.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t aqE;
    private final /* synthetic */ ImageFileInfo aqF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImageFileInfo imageFileInfo) {
        this.aqE = tVar;
        this.aqF = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.aqE.apJ;
        albumActivity.c(this.aqF);
        albumActivity2 = this.aqE.apJ;
        albumActivity2.c(this.aqF, false);
        albumActivity3 = this.aqE.apJ;
        albumActivity3.d(this.aqF, false);
    }
}
