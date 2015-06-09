package com.baidu.tieba.addresslist.im.searchfriend;

import android.view.View;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ SearchFriendActivity aAR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SearchFriendActivity searchFriendActivity) {
        this.aAR = searchFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aAR.finish();
    }
}
