package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
final class bz implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f1544a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(View view) {
        this.f1544a = view;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null && this.f1544a != null && (this.f1544a instanceof ViewGroup)) {
            com.baidu.tieba.util.bl.a((ViewGroup) this.f1544a, false, (com.baidu.tieba.util.bn) new ca(this, str, eVar));
        }
    }
}
