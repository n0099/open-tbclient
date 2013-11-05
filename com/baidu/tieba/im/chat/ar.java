package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class ar implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgleftView f1418a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(MsgleftView msgleftView) {
        this.f1418a = msgleftView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1418a.d.b(view, 2, this.f1418a.f, 0L);
        return true;
    }
}
