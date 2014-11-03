package com.baidu.tieba.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ b ahE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.ahE = bVar;
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
        this.ahE.RO = i;
        b bVar = this.ahE;
        i2 = this.ahE.RO;
        bVar.dL(i2 + 1);
        hVar = this.ahE.ahB;
        if (hVar != null) {
            pVar = this.ahE.aht;
            if (pVar != null) {
                hVar2 = this.ahE.ahB;
                i3 = this.ahE.RO;
                ImageFileInfo dM = hVar2.dM(i3);
                pVar2 = this.ahE.aht;
                if (pVar2.isAdded(dM)) {
                    b bVar2 = this.ahE;
                    imageView2 = this.ahE.ahC;
                    bVar2.a(imageView2, true);
                    return;
                }
                b bVar3 = this.ahE;
                imageView = this.ahE.ahC;
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
