package com.baidu.tieba.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ b ahv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.ahv = bVar;
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
        this.ahv.RK = i;
        b bVar = this.ahv;
        i2 = this.ahv.RK;
        bVar.dL(i2 + 1);
        hVar = this.ahv.ahs;
        if (hVar != null) {
            pVar = this.ahv.ahk;
            if (pVar != null) {
                hVar2 = this.ahv.ahs;
                i3 = this.ahv.RK;
                ImageFileInfo dM = hVar2.dM(i3);
                pVar2 = this.ahv.ahk;
                if (pVar2.isAdded(dM)) {
                    b bVar2 = this.ahv;
                    imageView2 = this.ahv.aht;
                    bVar2.a(imageView2, true);
                    return;
                }
                b bVar3 = this.ahv;
                imageView = this.ahv.aht;
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
