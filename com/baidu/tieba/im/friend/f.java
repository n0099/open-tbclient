package com.baidu.tieba.im.friend;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e baa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.baa = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IMBlackListActivity iMBlackListActivity;
        Object tag = view.getTag();
        if (tag != null && (tag instanceof com.baidu.tieba.im.data.a)) {
            iMBlackListActivity = this.baa.aZZ;
            iMBlackListActivity.a(view, (com.baidu.tieba.im.data.a) tag);
        }
    }
}
