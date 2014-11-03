package com.baidu.tieba.im.selectfriend;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ SelectFriendActivity biu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SelectFriendActivity selectFriendActivity) {
        this.biu = selectFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.biu.onBackPressed();
    }
}
