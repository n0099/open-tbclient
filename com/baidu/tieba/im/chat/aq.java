package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class aq implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgleftView f1501a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(MsgleftView msgleftView) {
        this.f1501a = msgleftView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1501a.d.b(view, 2, this.f1501a.f, 0L);
        return true;
    }
}
