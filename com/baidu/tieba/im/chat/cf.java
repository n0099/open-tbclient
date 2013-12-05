package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
final class cf implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f1589a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(View view) {
        this.f1589a = view;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null && this.f1589a != null && (this.f1589a instanceof ViewGroup)) {
            com.baidu.tieba.util.bj.a((ViewGroup) this.f1589a, false, (com.baidu.tieba.util.bl) new cg(this, str, eVar));
        }
    }
}
