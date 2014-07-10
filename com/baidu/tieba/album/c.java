package com.baidu.tieba.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        h hVar2;
        int i;
        p pVar;
        AlbumActivity albumActivity;
        h hVar3;
        int i2;
        p pVar2;
        AlbumActivity albumActivity2;
        ImageView imageView;
        AlbumActivity albumActivity3;
        int i3;
        AlbumActivity albumActivity4;
        ImageView imageView2;
        AlbumActivity albumActivity5;
        ImageView imageView3;
        AlbumActivity albumActivity6;
        int i4;
        hVar = this.a.i;
        if (hVar != null) {
            hVar2 = this.a.i;
            i = this.a.j;
            ImageFileInfo a = hVar2.a(i);
            pVar = this.a.c;
            if (pVar != null) {
                albumActivity = this.a.b;
                if (albumActivity != null) {
                    hVar3 = this.a.i;
                    i2 = this.a.j;
                    if (hVar3.b(i2)) {
                        pVar2 = this.a.c;
                        if (pVar2.c(a)) {
                            albumActivity5 = this.a.b;
                            if (albumActivity5.b(a)) {
                                b bVar = this.a;
                                imageView3 = this.a.l;
                                bVar.a(imageView3, false);
                                albumActivity6 = this.a.b;
                                i4 = this.a.j;
                                albumActivity6.a(i4, false);
                                return;
                            }
                            return;
                        }
                        albumActivity2 = this.a.b;
                        if (albumActivity2.a(a)) {
                            b bVar2 = this.a;
                            imageView = this.a.l;
                            bVar2.a(imageView, true);
                            albumActivity3 = this.a.b;
                            i3 = this.a.j;
                            albumActivity3.a(i3, true);
                            albumActivity4 = this.a.b;
                            Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4, com.baidu.tieba.p.album_choose_icon);
                            imageView2 = this.a.l;
                            imageView2.startAnimation(loadAnimation);
                        }
                    }
                }
            }
        }
    }
}
