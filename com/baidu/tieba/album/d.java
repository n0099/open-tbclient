package com.baidu.tieba.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ b apR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.apR = bVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        h hVar;
        n nVar;
        h hVar2;
        int i3;
        n nVar2;
        ImageView imageView;
        ImageView imageView2;
        this.apR.mCurrentIndex = i;
        b bVar = this.apR;
        i2 = this.apR.mCurrentIndex;
        bVar.el(i2 + 1);
        hVar = this.apR.apO;
        if (hVar != null) {
            nVar = this.apR.apH;
            if (nVar != null) {
                hVar2 = this.apR.apO;
                i3 = this.apR.mCurrentIndex;
                ImageFileInfo em = hVar2.em(i3);
                nVar2 = this.apR.apH;
                if (nVar2.isAdded(em)) {
                    b bVar2 = this.apR;
                    imageView2 = this.apR.apP;
                    bVar2.a(imageView2, true);
                    return;
                }
                b bVar3 = this.apR;
                imageView = this.apR.apP;
                bVar3.a(imageView, false);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
