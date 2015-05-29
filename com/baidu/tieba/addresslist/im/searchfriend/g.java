package com.baidu.tieba.addresslist.im.searchfriend;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ SearchFriendActivity aAQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SearchFriendActivity searchFriendActivity) {
        this.aAQ = searchFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j jVar;
        jVar = this.aAQ.aAG;
        jVar.hideSoftKeyboard();
    }
}
