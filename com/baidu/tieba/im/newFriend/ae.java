package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ NewFriendsActivity a;
    private final /* synthetic */ com.baidu.tieba.im.data.k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.k kVar) {
        this.a = newFriendsActivity;
        this.b = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        ao aoVar;
        if (bool.booleanValue()) {
            aoVar = this.a.d;
            aoVar.a(this.b);
        }
    }
}
