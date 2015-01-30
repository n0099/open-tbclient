package com.baidu.tieba.im.selectfriend;

import android.view.View;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ SelectFriendActivity bos;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SelectFriendActivity selectFriendActivity) {
        this.bos = selectFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bos.onBackPressed();
    }
}
