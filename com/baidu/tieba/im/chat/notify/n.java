package com.baidu.tieba.im.chat.notify;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ g aQQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(g gVar) {
        this.aQQ = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("is_shut_down_validate", true);
        this.aQQ.cF(false);
        this.aQQ.cD(false);
    }
}
