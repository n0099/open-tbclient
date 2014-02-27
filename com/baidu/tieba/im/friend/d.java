package com.baidu.tieba.im.friend;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        IMBlackListActivity iMBlackListActivity;
        Object tag = view.getTag();
        if (tag != null && (tag instanceof com.baidu.tieba.im.data.a)) {
            iMBlackListActivity = this.a.a;
            iMBlackListActivity.a((com.baidu.tieba.im.data.a) tag);
        }
    }
}
