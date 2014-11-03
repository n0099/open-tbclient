package com.baidu.tieba.im.searchfriend;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ SearchFriendActivity bhZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SearchFriendActivity searchFriendActivity) {
        this.bhZ = searchFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bhZ.finish();
    }
}
