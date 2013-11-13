package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class ax implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1323a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(FrsImageActivity frsImageActivity) {
        this.f1323a = frsImageActivity;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        bl blVar;
        try {
            blVar = this.f1323a.l;
            View findViewWithTag = blVar.e().a(1).findViewWithTag(str);
            if (findViewWithTag != null && (findViewWithTag instanceof TbImageView)) {
                findViewWithTag.invalidate();
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b(getClass().getName(), "imageLoaded", e.getMessage());
        }
    }
}
