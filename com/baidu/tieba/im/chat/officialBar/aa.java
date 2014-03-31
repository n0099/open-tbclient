package com.baidu.tieba.im.chat.officialBar;
/* loaded from: classes.dex */
final class aa implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ OfficialBarChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(OfficialBarChatActivity officialBarChatActivity) {
        this.a = officialBarChatActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        com.baidu.tieba.im.chat.h hVar;
        com.baidu.tieba.im.chat.h hVar2;
        Boolean bool2 = bool;
        if (bool2 != null) {
            if (bool2.booleanValue()) {
                hVar2 = this.a.d;
                hVar2.J();
                return;
            }
            hVar = this.a.d;
            hVar.K();
        }
    }
}
