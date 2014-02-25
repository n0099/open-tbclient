package com.baidu.tieba.home;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ae a;
    private final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar, View view) {
        this.a = aeVar;
        this.b = view;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        View findViewWithTag = this.b.findViewWithTag(str);
        if (findViewWithTag != null) {
            findViewWithTag.invalidate();
        }
    }
}
