package com.baidu.tieba.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ v apJ;
    private final /* synthetic */ ImageFileInfo apK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, ImageFileInfo imageFileInfo) {
        this.apJ = vVar;
        this.apK = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.apJ.aoO;
        albumActivity.c(this.apK);
        albumActivity2 = this.apJ.aoO;
        albumActivity2.c(this.apK, false);
        albumActivity3 = this.apJ.aoO;
        albumActivity3.d(this.apK, false);
    }
}
