package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ NewFriendsActivity a;
    private final /* synthetic */ com.baidu.tieba.im.data.k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.k kVar) {
        this.a = newFriendsActivity;
        this.b = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        av avVar;
        if (bool.booleanValue()) {
            avVar = this.a.d;
            avVar.a(this.b);
        }
    }
}
