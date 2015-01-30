package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ AbsMsglistView aRm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(AbsMsglistView absMsglistView) {
        this.aRm = absMsglistView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aRm.sendMore2Event();
    }
}
