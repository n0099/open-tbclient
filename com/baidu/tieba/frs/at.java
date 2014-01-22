package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class at implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        bi biVar;
        try {
            biVar = this.a.l;
            View findViewWithTag = biVar.e().a(2).findViewWithTag(str);
            if (findViewWithTag != null && (findViewWithTag instanceof TbImageView)) {
                findViewWithTag.invalidate();
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "imageLoaded", e.getMessage());
        }
    }
}
