package com.baidu.tieba.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ v aiw;
    private final /* synthetic */ ImageFileInfo aix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, ImageFileInfo imageFileInfo) {
        this.aiw = vVar;
        this.aix = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.aiw.ahz;
        albumActivity.c(this.aix);
        albumActivity2 = this.aiw.ahz;
        albumActivity2.c(this.aix, false);
        albumActivity3 = this.aiw.ahz;
        albumActivity3.d(this.aix, false);
    }
}
