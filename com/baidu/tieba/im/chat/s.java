package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ AbsMsglistView aQh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(AbsMsglistView absMsglistView) {
        this.aQh = absMsglistView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aQh.SendMore1Event();
    }
}
