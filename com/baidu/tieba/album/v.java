package com.baidu.tieba.album;

import android.view.View;
import com.baidu.tieba.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ u a;
    private final /* synthetic */ ImageFileInfo b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, ImageFileInfo imageFileInfo) {
        this.a = uVar;
        this.b = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.a.l;
        albumActivity.b(this.b);
        albumActivity2 = this.a.l;
        albumActivity2.a(this.b, false);
        albumActivity3 = this.a.l;
        albumActivity3.b(this.b, false);
    }
}
