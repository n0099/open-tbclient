package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class au implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1083a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(FrsImageActivity frsImageActivity) {
        this.f1083a = frsImageActivity;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        az azVar;
        try {
            azVar = this.f1083a.n;
            View findViewWithTag = azVar.a().a(1).findViewWithTag(str);
            if (findViewWithTag != null && (findViewWithTag instanceof TbImageView)) {
                findViewWithTag.invalidate();
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "imageLoaded", e.getMessage());
        }
    }
}
