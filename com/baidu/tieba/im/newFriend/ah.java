package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class ah implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ NewFriendsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(NewFriendsActivity newFriendsActivity) {
        this.a = newFriendsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        if (!z) {
            this.a.a();
        }
    }
}
