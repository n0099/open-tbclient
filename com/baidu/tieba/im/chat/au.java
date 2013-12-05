package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgleftView f1552a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(MsgleftView msgleftView) {
        this.f1552a = msgleftView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        TouchType touchType;
        touchType = this.f1552a.r;
        touchType.set(true);
        return true;
    }
}
