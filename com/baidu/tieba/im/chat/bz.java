package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
final class bz implements View.OnClickListener {
    final /* synthetic */ MsgActivityView a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(MsgActivityView msgActivityView, String str, String str2) {
        this.a = msgActivityView;
        this.b = str;
        this.c = str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new com.baidu.tbadk.core.b.ag(this.a.b(), this.b, this.c)));
    }
}
