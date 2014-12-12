package com.baidu.tieba.im.searchfriend;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ SearchFriendActivity bmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SearchFriendActivity searchFriendActivity) {
        this.bmC = searchFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j jVar;
        jVar = this.bmC.bmt;
        jVar.hideSoftKeyboard();
    }
}
