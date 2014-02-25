package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class bk implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        bp bpVar;
        try {
            bpVar = this.a.l;
            View findViewWithTag = bpVar.e().a(2).findViewWithTag(str);
            if (findViewWithTag != null && (findViewWithTag instanceof TbImageView)) {
                findViewWithTag.invalidate();
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "imageLoaded", e.getMessage());
        }
    }
}
