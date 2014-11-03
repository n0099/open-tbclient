package com.baidu.tieba.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b ahE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.ahE = bVar;
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
        hVar = this.ahE.ahB;
        if (hVar != null) {
            hVar2 = this.ahE.ahB;
            i = this.ahE.RO;
            ImageFileInfo dM = hVar2.dM(i);
            pVar = this.ahE.aht;
            if (pVar != null) {
                albumActivity = this.ahE.ahz;
                if (albumActivity != null) {
                    hVar3 = this.ahE.ahB;
                    i2 = this.ahE.RO;
                    if (hVar3.dN(i2)) {
                        pVar2 = this.ahE.aht;
                        if (pVar2.isAdded(dM)) {
                            albumActivity5 = this.ahE.ahz;
                            if (albumActivity5.c(dM)) {
                                b bVar = this.ahE;
                                imageView3 = this.ahE.ahC;
                                bVar.a(imageView3, false);
                                albumActivity6 = this.ahE.ahz;
                                i4 = this.ahE.RO;
                                albumActivity6.k(i4, false);
                                return;
                            }
                            return;
                        }
                        albumActivity2 = this.ahE.ahz;
                        if (albumActivity2.b(dM)) {
                            b bVar2 = this.ahE;
                            imageView = this.ahE.ahC;
                            bVar2.a(imageView, true);
                            albumActivity3 = this.ahE.ahz;
                            i3 = this.ahE.RO;
                            albumActivity3.k(i3, true);
                            albumActivity4 = this.ahE.ahz;
                            Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4, com.baidu.tieba.p.album_choose_icon);
                            imageView2 = this.ahE.ahC;
                            imageView2.startAnimation(loadAnimation);
                        }
                    }
                }
            }
        }
    }
}
