package com.baidu.tieba.im.chat;

import android.widget.ImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements android.support.v4.view.bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f1498a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar) {
        this.f1498a = aaVar;
    }

    @Override // android.support.v4.view.bq
    public void onPageSelected(int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        this.f1498a.c = i;
        this.f1498a.c(i);
        arrayList = this.f1498a.g;
        if (i == arrayList.size() - 1 || i == 0) {
            if (i == 0) {
                this.f1498a.b(1);
                return;
            }
            this.f1498a.b(i - 1);
            arrayList2 = this.f1498a.h;
            ((ImageView) arrayList2.get(i - 1)).setBackgroundResource(R.drawable.face_im_dot_corners_selected);
        }
    }

    @Override // android.support.v4.view.bq
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.bq
    public void onPageScrollStateChanged(int i) {
    }
}
