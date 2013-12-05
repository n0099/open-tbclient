package com.baidu.tieba.home;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f1472a;
    final /* synthetic */ bf b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bf bfVar, View view) {
        this.b = bfVar;
        this.f1472a = view;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        View findViewWithTag = this.f1472a.findViewWithTag(str);
        if (findViewWithTag != null) {
            findViewWithTag.invalidate();
        }
    }
}
