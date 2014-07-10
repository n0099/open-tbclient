package com.baidu.tieba.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ v a;
    private final /* synthetic */ ImageFileInfo b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, ImageFileInfo imageFileInfo) {
        this.a = vVar;
        this.b = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        albumActivity = this.a.k;
        albumActivity.b(this.b);
        albumActivity2 = this.a.k;
        albumActivity2.a(this.b, false);
        albumActivity3 = this.a.k;
        albumActivity3.b(this.b, false);
    }
}
