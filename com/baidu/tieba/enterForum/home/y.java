package com.baidu.tieba.enterForum.home;

import android.view.View;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ x bbA;
    private final /* synthetic */ View bbB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, View view) {
        this.bbA = xVar;
        this.bbB = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bbB != null) {
            this.bbB.setVisibility(8);
        }
    }
}
