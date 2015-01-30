package com.baidu.tieba.im.chat.notify;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ g aTE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(g gVar) {
        this.aTE = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.oj().putBoolean("is_shut_down_validate", true);
        this.aTE.cx(false);
        this.aTE.cv(false);
    }
}
