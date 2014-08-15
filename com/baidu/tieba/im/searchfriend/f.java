package com.baidu.tieba.im.searchfriend;

import android.view.View;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ SearchFriendActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SearchFriendActivity searchFriendActivity) {
        this.a = searchFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        hVar = this.a.a;
        hVar.a();
    }
}
