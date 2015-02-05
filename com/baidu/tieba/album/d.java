package com.baidu.tieba.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ b apO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.apO = bVar;
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
        this.apO.mCurrentIndex = i;
        b bVar = this.apO;
        i2 = this.apO.mCurrentIndex;
        bVar.el(i2 + 1);
        hVar = this.apO.apL;
        if (hVar != null) {
            nVar = this.apO.apE;
            if (nVar != null) {
                hVar2 = this.apO.apL;
                i3 = this.apO.mCurrentIndex;
                ImageFileInfo em = hVar2.em(i3);
                nVar2 = this.apO.apE;
                if (nVar2.isAdded(em)) {
                    b bVar2 = this.apO;
                    imageView2 = this.apO.apM;
                    bVar2.a(imageView2, true);
                    return;
                }
                b bVar3 = this.apO;
                imageView = this.apO.apM;
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
