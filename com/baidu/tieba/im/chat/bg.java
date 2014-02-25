package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements View.OnClickListener {
    final /* synthetic */ MsgActivityView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(MsgActivityView msgActivityView) {
        this.a = msgActivityView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.b.a aVar;
        com.baidu.adp.lib.b.a aVar2;
        int i;
        aVar = this.a.v;
        if (aVar != null) {
            aVar2 = this.a.v;
            i = this.a.t;
            aVar2.a(view, 8, i, 0L);
        }
    }
}
