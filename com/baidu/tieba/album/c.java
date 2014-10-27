package com.baidu.tieba.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b ahv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.ahv = bVar;
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
        hVar = this.ahv.ahs;
        if (hVar != null) {
            hVar2 = this.ahv.ahs;
            i = this.ahv.RK;
            ImageFileInfo dM = hVar2.dM(i);
            pVar = this.ahv.ahk;
            if (pVar != null) {
                albumActivity = this.ahv.ahq;
                if (albumActivity != null) {
                    hVar3 = this.ahv.ahs;
                    i2 = this.ahv.RK;
                    if (hVar3.dN(i2)) {
                        pVar2 = this.ahv.ahk;
                        if (pVar2.isAdded(dM)) {
                            albumActivity5 = this.ahv.ahq;
                            if (albumActivity5.c(dM)) {
                                b bVar = this.ahv;
                                imageView3 = this.ahv.aht;
                                bVar.a(imageView3, false);
                                albumActivity6 = this.ahv.ahq;
                                i4 = this.ahv.RK;
                                albumActivity6.k(i4, false);
                                return;
                            }
                            return;
                        }
                        albumActivity2 = this.ahv.ahq;
                        if (albumActivity2.b(dM)) {
                            b bVar2 = this.ahv;
                            imageView = this.ahv.aht;
                            bVar2.a(imageView, true);
                            albumActivity3 = this.ahv.ahq;
                            i3 = this.ahv.RK;
                            albumActivity3.k(i3, true);
                            albumActivity4 = this.ahv.ahq;
                            Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4, com.baidu.tieba.p.album_choose_icon);
                            imageView2 = this.ahv.aht;
                            imageView2.startAnimation(loadAnimation);
                        }
                    }
                }
            }
        }
    }
}
