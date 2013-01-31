package com.baidu.tieba.frs;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import com.baidu.tieba.view.ImageViewDrawer;
import com.baidu.tieba.view.WaterFallView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tieba.c.d {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        WaterFallView waterFallView;
        Rect rect;
        Rect rect2;
        Rect rect3;
        Rect rect4;
        try {
            waterFallView = this.a.d;
            View findViewWithTag = waterFallView.a(1).findViewWithTag(str);
            if (findViewWithTag != null && (findViewWithTag instanceof ImageViewDrawer)) {
                rect = this.a.D;
                if (findViewWithTag.getLocalVisibleRect(rect)) {
                    rect2 = this.a.D;
                    int i = rect2.bottom;
                    rect3 = this.a.D;
                    if (i - rect3.top >= findViewWithTag.getHeight()) {
                        rect4 = this.a.D;
                        if (rect4.top != 0) {
                            findViewWithTag.invalidate();
                        }
                    }
                    ((ImageViewDrawer) findViewWithTag).a();
                } else {
                    findViewWithTag.invalidate();
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "imageLoaded", e.getMessage());
        }
    }
}
