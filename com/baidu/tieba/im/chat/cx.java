package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
final class cx implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ PersonalChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(PersonalChatActivity personalChatActivity) {
        this.a = personalChatActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        Boolean bool2 = bool;
        if (bool2 != null) {
            if (bool2.booleanValue()) {
                this.a.d.K();
            } else {
                this.a.d.L();
            }
        }
    }
}
