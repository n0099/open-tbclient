package com.baidu.tieba.album;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
final class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.a = bVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i) {
        int i2;
        h hVar;
        p pVar;
        h hVar2;
        int i3;
        p pVar2;
        ImageView imageView;
        ImageView imageView2;
        this.a.j = i;
        b bVar = this.a;
        i2 = this.a.j;
        bVar.d(i2 + 1);
        hVar = this.a.i;
        if (hVar != null) {
            pVar = this.a.c;
            if (pVar != null) {
                hVar2 = this.a.i;
                i3 = this.a.j;
                ImageFileInfo a = hVar2.a(i3);
                pVar2 = this.a.c;
                if (pVar2.c(a)) {
                    b bVar2 = this.a;
                    imageView2 = this.a.l;
                    b.a(imageView2, true);
                    return;
                }
                b bVar3 = this.a;
                imageView = this.a.l;
                b.a(imageView, false);
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i) {
    }
}
