package com.baidu.tieba.im.chat;

import android.widget.ImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements android.support.v4.view.bq {
    final /* synthetic */ aj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(aj ajVar) {
        this.a = ajVar;
    }

    @Override // android.support.v4.view.bq
    public void onPageSelected(int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        this.a.c = i;
        this.a.c(i);
        arrayList = this.a.g;
        if (i == arrayList.size() - 1 || i == 0) {
            if (i == 0) {
                this.a.b(1);
                return;
            }
            this.a.b(i - 1);
            arrayList2 = this.a.h;
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
