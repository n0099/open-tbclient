package com.baidu.tieba.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b apO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.apO = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        h hVar2;
        int i;
        n nVar;
        AlbumActivity albumActivity;
        h hVar3;
        int i2;
        n nVar2;
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
        hVar = this.apO.apL;
        if (hVar != null) {
            hVar2 = this.apO.apL;
            i = this.apO.mCurrentIndex;
            ImageFileInfo em = hVar2.em(i);
            nVar = this.apO.apE;
            if (nVar != null) {
                albumActivity = this.apO.apJ;
                if (albumActivity != null) {
                    hVar3 = this.apO.apL;
                    i2 = this.apO.mCurrentIndex;
                    if (hVar3.en(i2)) {
                        nVar2 = this.apO.apE;
                        if (nVar2.isAdded(em)) {
                            albumActivity5 = this.apO.apJ;
                            if (albumActivity5.c(em)) {
                                b bVar = this.apO;
                                imageView3 = this.apO.apM;
                                bVar.a(imageView3, false);
                                albumActivity6 = this.apO.apJ;
                                i4 = this.apO.mCurrentIndex;
                                albumActivity6.k(i4, false);
                                return;
                            }
                            return;
                        }
                        albumActivity2 = this.apO.apJ;
                        if (albumActivity2.b(em)) {
                            b bVar2 = this.apO;
                            imageView = this.apO.apM;
                            bVar2.a(imageView, true);
                            albumActivity3 = this.apO.apJ;
                            i3 = this.apO.mCurrentIndex;
                            albumActivity3.k(i3, true);
                            albumActivity4 = this.apO.apJ;
                            Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), com.baidu.tieba.q.album_choose_icon);
                            imageView2 = this.apO.apM;
                            imageView2.startAnimation(loadAnimation);
                        }
                    }
                }
            }
        }
    }
}
