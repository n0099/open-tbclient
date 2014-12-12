package com.baidu.tieba.im.selectfriend;

import android.view.View;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ SelectFriendActivity bmV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SelectFriendActivity selectFriendActivity) {
        this.bmV = selectFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bmV.onBackPressed();
    }
}
