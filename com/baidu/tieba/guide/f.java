package com.baidu.tieba.guide;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        LinearLayout linearLayout;
        if (aVar != null) {
            linearLayout = this.a.e;
            View findViewWithTag = linearLayout.findViewWithTag(str);
            if (findViewWithTag != null && (findViewWithTag instanceof ImageView)) {
                aVar.a((ImageView) findViewWithTag);
            }
        }
    }
}
