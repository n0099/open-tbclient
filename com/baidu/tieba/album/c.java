package com.baidu.tieba.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b aoT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aoT = bVar;
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
        hVar = this.aoT.aoQ;
        if (hVar != null) {
            hVar2 = this.aoT.aoQ;
            i = this.aoT.mCurrentIndex;
            ImageFileInfo eg = hVar2.eg(i);
            pVar = this.aoT.aoJ;
            if (pVar != null) {
                albumActivity = this.aoT.aoO;
                if (albumActivity != null) {
                    hVar3 = this.aoT.aoQ;
                    i2 = this.aoT.mCurrentIndex;
                    if (hVar3.eh(i2)) {
                        pVar2 = this.aoT.aoJ;
                        if (pVar2.isAdded(eg)) {
                            albumActivity5 = this.aoT.aoO;
                            if (albumActivity5.c(eg)) {
                                b bVar = this.aoT;
                                imageView3 = this.aoT.aoR;
                                bVar.a(imageView3, false);
                                albumActivity6 = this.aoT.aoO;
                                i4 = this.aoT.mCurrentIndex;
                                albumActivity6.k(i4, false);
                                return;
                            }
                            return;
                        }
                        albumActivity2 = this.aoT.aoO;
                        if (albumActivity2.b(eg)) {
                            b bVar2 = this.aoT;
                            imageView = this.aoT.aoR;
                            bVar2.a(imageView, true);
                            albumActivity3 = this.aoT.aoO;
                            i3 = this.aoT.mCurrentIndex;
                            albumActivity3.k(i3, true);
                            albumActivity4 = this.aoT.aoO;
                            Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), com.baidu.tieba.q.album_choose_icon);
                            imageView2 = this.aoT.aoR;
                            imageView2.startAnimation(loadAnimation);
                        }
                    }
                }
            }
        }
    }
}
