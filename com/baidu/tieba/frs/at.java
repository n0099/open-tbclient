package com.baidu.tieba.frs;

import android.graphics.Rect;
import android.view.View;
import com.baidu.tieba.view.ImageViewDrawer;
/* loaded from: classes.dex */
class at implements com.baidu.tbadk.a.d {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        ax axVar;
        Rect rect;
        Rect rect2;
        Rect rect3;
        Rect rect4;
        try {
            axVar = this.a.n;
            View findViewWithTag = axVar.a().a(2).findViewWithTag(str);
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
            com.baidu.tieba.util.z.b(getClass().getName(), "imageLoaded", e.getMessage());
        }
    }
}
