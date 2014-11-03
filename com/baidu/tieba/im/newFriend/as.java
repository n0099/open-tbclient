package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class as implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ NewFriendsActivity bhm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(NewFriendsActivity newFriendsActivity) {
        this.bhm = newFriendsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        if (!z) {
            this.bhm.Rk();
        }
    }
}
