package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class da implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ PersonalChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(PersonalChatActivity personalChatActivity) {
        this.a = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        if (bool != null) {
            if (bool.booleanValue()) {
                this.a.d.M();
            } else {
                this.a.d.N();
            }
        }
    }
}
