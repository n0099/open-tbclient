package com.baidu.tieba.editortool;

import android.support.v4.view.bq;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FaceView f1225a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FaceView faceView) {
        this.f1225a = faceView;
    }

    @Override // android.support.v4.view.bq
    public void onPageSelected(int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        this.f1225a.f1218a = i;
        this.f1225a.a(i);
        arrayList = this.f1225a.e;
        if (i == arrayList.size() - 1 || i == 0) {
            if (i == 0) {
                this.f1225a.setCurrentItem(1);
                return;
            }
            this.f1225a.setCurrentItem(i - 1);
            arrayList2 = this.f1225a.f;
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
