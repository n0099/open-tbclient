package com.baidu.tieba.im.chat.notify;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ g aTD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(g gVar) {
        this.aTD = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.oc().putBoolean("is_shut_down_validate", true);
        this.aTD.cx(false);
        this.aTD.cv(false);
    }
}
