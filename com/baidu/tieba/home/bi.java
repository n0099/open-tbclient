package com.baidu.tieba.home;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ View a;
    final /* synthetic */ bg b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bg bgVar, View view) {
        this.b = bgVar;
        this.a = view;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        View findViewWithTag = this.a.findViewWithTag(str);
        if (findViewWithTag != null) {
            findViewWithTag.invalidate();
        }
    }
}
