package com.baidu.tieba.frs;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import com.baidu.tieba.view.ImageViewDrawer;
/* loaded from: classes.dex */
class at implements com.baidu.tieba.d.d {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.d.d
    public void a(Bitmap bitmap, String str, boolean z) {
        ay ayVar;
        Rect rect;
        Rect rect2;
        Rect rect3;
        Rect rect4;
        try {
            ayVar = this.a.n;
            View findViewWithTag = ayVar.a().a(2).findViewWithTag(str);
            if (findViewWithTag != null && (findViewWithTag instanceof ImageViewDrawer)) {
                rect = this.a.m;
                if (findViewWithTag.getLocalVisibleRect(rect)) {
                    rect2 = this.a.m;
                    int i = rect2.bottom;
                    rect3 = this.a.m;
                    if (i - rect3.top >= findViewWithTag.getHeight()) {
                        rect4 = this.a.m;
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
            com.baidu.tieba.d.ae.b(getClass().getName(), "imageLoaded", e.getMessage());
        }
    }
}
