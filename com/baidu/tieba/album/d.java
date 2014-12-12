package com.baidu.tieba.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ b aoT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.aoT = bVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2;
        h hVar;
        p pVar;
        h hVar2;
        int i3;
        p pVar2;
        ImageView imageView;
        ImageView imageView2;
        this.aoT.mCurrentIndex = i;
        b bVar = this.aoT;
        i2 = this.aoT.mCurrentIndex;
        bVar.ef(i2 + 1);
        hVar = this.aoT.aoQ;
        if (hVar != null) {
            pVar = this.aoT.aoJ;
            if (pVar != null) {
                hVar2 = this.aoT.aoQ;
                i3 = this.aoT.mCurrentIndex;
                ImageFileInfo eg = hVar2.eg(i3);
                pVar2 = this.aoT.aoJ;
                if (pVar2.isAdded(eg)) {
                    b bVar2 = this.aoT;
                    imageView2 = this.aoT.aoR;
                    bVar2.a(imageView2, true);
                    return;
                }
                b bVar3 = this.aoT;
                imageView = this.aoT.aoR;
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
