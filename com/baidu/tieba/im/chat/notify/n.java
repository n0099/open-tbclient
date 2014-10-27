package com.baidu.tieba.im.chat.notify;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ g aQC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(g gVar) {
        this.aQC = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("is_shut_down_validate", true);
        this.aQC.cF(false);
        this.aQC.cD(false);
    }
}
