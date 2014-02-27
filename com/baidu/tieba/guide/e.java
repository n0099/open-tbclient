package com.baidu.tieba.guide;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
final class e implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        LinearLayout linearLayout;
        if (bVar != null) {
            linearLayout = this.a.e;
            View findViewWithTag = linearLayout.findViewWithTag(str);
            if (findViewWithTag != null && (findViewWithTag instanceof ImageView)) {
                bVar.a((ImageView) findViewWithTag);
            }
        }
    }
}
