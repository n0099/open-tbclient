package com.baidu.tieba.im.chat;

import android.widget.ImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements android.support.v4.view.bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ad f1539a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ad adVar) {
        this.f1539a = adVar;
    }

    @Override // android.support.v4.view.bq
    public void onPageSelected(int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        this.f1539a.c = i;
        this.f1539a.c(i);
        arrayList = this.f1539a.g;
        if (i == arrayList.size() - 1 || i == 0) {
            if (i == 0) {
                this.f1539a.b(1);
                return;
            }
            this.f1539a.b(i - 1);
            arrayList2 = this.f1539a.h;
            ((ImageView) arrayList2.get(i - 1)).setBackgroundResource(R.drawable.icon_liaotianye_s);
        }
    }

    @Override // android.support.v4.view.bq
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.bq
    public void onPageScrollStateChanged(int i) {
    }
}
