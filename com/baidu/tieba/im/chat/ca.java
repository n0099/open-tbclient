package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ca implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f1453a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(View view) {
        this.f1453a = view;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null && this.f1453a != null && (this.f1453a instanceof ViewGroup)) {
            com.baidu.tieba.util.bj.a((ViewGroup) this.f1453a, false, (com.baidu.tieba.util.bo) new cb(this, str, eVar));
        }
    }
}
