package com.baidu.tieba.im.searchfriend;

import android.view.View;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ SearchFriendActivity bnY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SearchFriendActivity searchFriendActivity) {
        this.bnY = searchFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bnY.finish();
    }
}
