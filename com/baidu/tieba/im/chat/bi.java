package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bi implements View.OnClickListener {
    final /* synthetic */ MsgActivityView a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(MsgActivityView msgActivityView, String str, String str2) {
        this.a = msgActivityView;
        this.b = str;
        this.c = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.person.cm.a(this.a.b(), this.b, this.c);
    }
}
