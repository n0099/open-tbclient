package com.baidu.tieba.home;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ View a;
    final /* synthetic */ bf b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bf bfVar, View view) {
        this.b = bfVar;
        this.a = view;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        View findViewWithTag = this.a.findViewWithTag(str);
        if (findViewWithTag != null) {
            findViewWithTag.invalidate();
        }
    }
}
