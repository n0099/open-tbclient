package com.baidu.tieba.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ v ain;
    private final /* synthetic */ ImageFileInfo aio;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, ImageFileInfo imageFileInfo) {
        this.ain = vVar;
        this.aio = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.ain.ahq;
        albumActivity.c(this.aio);
        albumActivity2 = this.ain.ahq;
        albumActivity2.c(this.aio, false);
        albumActivity3 = this.ain.ahq;
        albumActivity3.d(this.aio, false);
    }
}
