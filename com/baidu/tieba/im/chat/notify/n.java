package com.baidu.tieba.im.chat.notify;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ g aSu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(g gVar) {
        this.aSu = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.og().putBoolean("is_shut_down_validate", true);
        this.aSu.ct(false);
        this.aSu.cr(false);
    }
}
