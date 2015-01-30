package com.baidu.tieba.album;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b apR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.apR = bVar;
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
        hVar = this.apR.apO;
        if (hVar != null) {
            hVar2 = this.apR.apO;
            i = this.apR.mCurrentIndex;
            ImageFileInfo em = hVar2.em(i);
            nVar = this.apR.apH;
            if (nVar != null) {
                albumActivity = this.apR.apM;
                if (albumActivity != null) {
                    hVar3 = this.apR.apO;
                    i2 = this.apR.mCurrentIndex;
                    if (hVar3.en(i2)) {
                        nVar2 = this.apR.apH;
                        if (nVar2.isAdded(em)) {
                            albumActivity5 = this.apR.apM;
                            if (albumActivity5.c(em)) {
                                b bVar = this.apR;
                                imageView3 = this.apR.apP;
                                bVar.a(imageView3, false);
                                albumActivity6 = this.apR.apM;
                                i4 = this.apR.mCurrentIndex;
                                albumActivity6.k(i4, false);
                                return;
                            }
                            return;
                        }
                        albumActivity2 = this.apR.apM;
                        if (albumActivity2.b(em)) {
                            b bVar2 = this.apR;
                            imageView = this.apR.apP;
                            bVar2.a(imageView, true);
                            albumActivity3 = this.apR.apM;
                            i3 = this.apR.mCurrentIndex;
                            albumActivity3.k(i3, true);
                            albumActivity4 = this.apR.apM;
                            Animation loadAnimation = AnimationUtils.loadAnimation(albumActivity4.getPageContext().getContext(), com.baidu.tieba.q.album_choose_icon);
                            imageView2 = this.apR.apP;
                            imageView2.startAnimation(loadAnimation);
                        }
                    }
                }
            }
        }
    }
}
