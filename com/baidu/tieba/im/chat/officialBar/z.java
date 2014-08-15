package com.baidu.tieba.im.chat.officialBar;
/* loaded from: classes.dex */
class z implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ OfficialBarChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(OfficialBarChatActivity officialBarChatActivity) {
        this.a = officialBarChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        com.baidu.tieba.im.chat.g gVar;
        com.baidu.tieba.im.chat.g gVar2;
        if (bool != null) {
            if (bool.booleanValue()) {
                gVar2 = this.a.d;
                gVar2.M();
                return;
            }
            gVar = this.a.d;
            gVar.N();
        }
    }
}
