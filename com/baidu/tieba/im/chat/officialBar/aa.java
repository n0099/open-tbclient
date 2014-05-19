package com.baidu.tieba.im.chat.officialBar;
/* loaded from: classes.dex */
class aa implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ OfficialBarChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(OfficialBarChatActivity officialBarChatActivity) {
        this.a = officialBarChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        com.baidu.tieba.im.chat.h hVar;
        com.baidu.tieba.im.chat.h hVar2;
        if (bool != null) {
            if (bool.booleanValue()) {
                hVar2 = this.a.d;
                hVar2.L();
                return;
            }
            hVar = this.a.d;
            hVar.M();
        }
    }
}
