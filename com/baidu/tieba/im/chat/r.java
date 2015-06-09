package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ AbsMsglistView aZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(AbsMsglistView absMsglistView) {
        this.aZp = absMsglistView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aZp.sendSoftkeyEvent();
    }
}
